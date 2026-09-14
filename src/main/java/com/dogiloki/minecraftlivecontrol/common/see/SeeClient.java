package com.dogiloki.minecraftlivecontrol.common.see;

import com.dogiloki.minecraftlivecontrol.ClientInfo;
import com.dogiloki.minecraftlivecontrol.MinecraftLiveControl;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author _dogi
 */

public class SeeClient{
    
    private static final Gson GSON=new Gson();
    
    private final String host;
    private volatile HttpURLConnection connection;
    private volatile boolean connected;
    
    public SeeClient(String host){
        this.host=host;
    }
    
    public void connect(){
        if(this.connected){
            MinecraftLiveControl.LOGGER.info("SEE ya esta conectado");
            return;
        }
        Thread thread=new Thread(this::connectInternal,"Client-SEE");
        thread.setDaemon(true);
        thread.start();
    }
    
    public void disconnect(){
        HttpURLConnection current=this.connection;
        if(current!=null){
            current.disconnect();
        }
        this.connection=null;
        this.connected=false;
    }
    
    private void connectInternal(){
        HttpURLConnection current=null;
        try{
            String url=this.host+"/"+SeeEvent.EVENTS.toString()+"?id="+ClientInfo.ID_CLIENT;
            this.connection=current=(HttpURLConnection)URI.create(url).toURL().openConnection();
            current.setRequestMethod("POST");
            current.setRequestProperty("Accept","text/event-stream");
            current.setReadTimeout(0);
            current.setConnectTimeout(10000);
            current.setDoInput(true);
            int code=current.getResponseCode();
            if(code!=200){
                MinecraftLiveControl.LOGGER.warn("See respondió HTTP "+code);
                return;
            }
            this.connected=true;
            MinecraftLiveControl.LOGGER.info("Conectado a SEE");
            this.readEvents(current);
        }catch(Exception ex){
            MinecraftLiveControl.LOGGER.error("Error en conexión interna de SEE",ex);
        }finally{
            this.connected=false;
            if(current!=null){
                current.disconnect();
            }
            if(this.connection==current){
                this.connection=null;
            }
            MinecraftLiveControl.LOGGER.info("Conexión SEE cerrada");
        }
    }
    
    private void readEvents(HttpURLConnection connect)throws Exception{
        String line;
        BufferedReader reader=new BufferedReader(new InputStreamReader(connect.getInputStream(),StandardCharsets.UTF_8));
        String event=null;
        StringBuilder data=new StringBuilder();
        while((line=reader.readLine())!=null){
            if(line.startsWith("event:")){
                event=line.substring(6).trim();
                continue;
            }
            if(line.startsWith("data:")){
                if(data.length()>0){
                    data.append("\n");   
                }
                data.append(line.substring(5).trim());
                continue;
            }
            if(!line.isEmpty() || data.length()<=0) continue;
            this.processEvent(event,data.toString());
            event=null;
            data.setLength(0);
        }
    }
    
    private void processEvent(String event, String data){
        if(event.equals(SeeEvent.REQUEST.toString())){
            SeeHandler.handle(data);
        }
    }
    
    public void sendResponse(SeeResponse response){
        Thread thread=new Thread(()->{
            try{
                String json=GSON.toJson(response);
                String url=this.host+"/"+SeeEvent.RESPONSE.toString()+"?id="+ClientInfo.ID_CLIENT;
                HttpURLConnection connection=(HttpURLConnection)URI.create(url).toURL().openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type","application/json");
                connection.setDoOutput(true);
                byte[] bytes=json.getBytes(StandardCharsets.UTF_8);
                try(OutputStream output=connection.getOutputStream()){
                    output.write(bytes);
                }
                int code=connection.getResponseCode();
                connection.disconnect();
            }catch(Exception ex){
                MinecraftLiveControl.LOGGER.error("Erro al enviar respuesta SEE",ex);
            }
        },"Client-SEE-Response");
        thread.setDaemon(true);
        thread.start();
    }
    
}
