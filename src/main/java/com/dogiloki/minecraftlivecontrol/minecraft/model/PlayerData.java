package com.dogiloki.minecraftlivecontrol.minecraft.model;

/**
 *
 * @author _dogi
 */

public class PlayerData{
    
    private final String uuid;
    private final String name;
    private boolean connected;
    
    public PlayerData(String uuid, String name, boolean connected){
        this.uuid=uuid;
        this.name=name;
        this.connected=connected;
    }
    
    public String getUuid(){
        return this.uuid;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isConnected(){
        return this.connected;
    }
    
}
