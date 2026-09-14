package com.dogiloki.minecraftlivecontrol;

import com.dogiloki.minecraftlivecontrol.minecraft.ServerInfo;
import net.minecraft.server.MinecraftServer;

/**
 *
 * @author _dogi
 */

public class ClientInfo{
    
    public static String ID_CLIENT;
    
    public static void initialize(MinecraftServer server){
        ID_CLIENT=new ServerInfo(server).toBase64();
    }
    
}
