package com.dogiloki.minecraftlivecontrol.common.see;

import com.dogiloki.minecraftlivecontrol.MinecraftLiveControl;
import com.dogiloki.minecraftlivecontrol.common.see.handlers.SeeInventoryHandler;
import com.dogiloki.minecraftlivecontrol.common.see.handlers.SeeInventorySetHandler;
import com.dogiloki.minecraftlivecontrol.common.see.handlers.SeePlayersHandler;
import com.dogiloki.minecraftlivecontrol.minecraft.MinecraftAdapter;
import com.google.gson.Gson;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author _dogi
 */

public class SeeHandler{
    
    private static final Gson GSON=new Gson();
    private static final Map<SeeAction,SeeActionHandler> HANDLERS=new EnumMap<>(SeeAction.class);
    private static MinecraftAdapter minecraft;
    
    public static void initialize(MinecraftAdapter minecraft){
        SeeHandler.minecraft=minecraft;
        HANDLERS.put(SeeAction.PLAYERS,new SeePlayersHandler());
        HANDLERS.put(SeeAction.INVENTORY,new SeeInventoryHandler());
        HANDLERS.put(SeeAction.INVENTORY_SET,new SeeInventorySetHandler());
    }
    
    public static void handle(String json){
        try{
            SeeRequest request=(SeeRequest)GSON.fromJson(json,SeeRequest.class);
            if(request==null){
                MinecraftLiveControl.LOGGER.warn("Request de SEE no válida");
                return;
            }
            SeeAction action=request.getAction();
            if(action==null){
                SeeHandler.sendError(request.getIdRequest(),"Falta action");
                return;
            }
            SeeActionHandler handler=HANDLERS.get(action);
            if(handler==null){
                SeeHandler.sendError(request.getIdRequest(),"Acción no soportada: "+action.toString());
                return;
            }
            if(SeeHandler.minecraft==null){
                SeeHandler.sendError(request.getIdRequest(),"MinecraftAdapter no inicializado");
                return;
            }
            handler.handle(request,SeeHandler.minecraft);
        }catch(Exception ex){
            MinecraftLiveControl.LOGGER.error("Erro al procesar request SEE",ex);
        }
    }
    
    public static void sendResponse(String id_request, Object data){
        SeeResponse response=new SeeResponse(id_request,true,data,null);
        MinecraftLiveControl.getSeeClient().sendResponse(response);
    }
    
    private static void sendError(String id_request, String error){
        SeeResponse response=new SeeResponse(id_request,false,null,error);
        MinecraftLiveControl.getSeeClient().sendResponse(response);
    }
    
    private SeeHandler(){
        
    }
    
}
