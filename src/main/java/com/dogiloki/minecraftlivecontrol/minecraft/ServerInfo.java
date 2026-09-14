package com.dogiloki.minecraftlivecontrol.minecraft;

import com.dogiloki.multitaks.code.Code;
import com.google.gson.Gson;
import net.minecraft.SharedConstants;
import net.minecraft.server.MinecraftServer;

/**
 *
 * @author _dogi
 */

public class ServerInfo{
    
    private final String name;
    private final String ip;
    private final int port;
    private final String version;
    
    public ServerInfo(MinecraftServer server){
        this.name=server.getMotd();
        this.ip=server.getLocalIp();
        this.port=server.getPort();
        this.version=SharedConstants.getCurrentVersion().getName();
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getIp(){
        return this.ip;
    }
    
    public int getPort(){
        return this.port;
    }
    
    public String getVersion(){
        return this.version;
    }
    
    public String toString(){
        return new Gson().toJson(this);
    }
    
    public String toBase64(){
        return Code.decode64(this.toString());
    }
    
}
