package com.dogiloki.minecraftlivecontrol.common.see;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author _dogi
 */

public enum SeeAction{
    
    @SerializedName("players")
    PLAYERS("players"),
    @SerializedName("inventory")
    INVENTORY("inventory"),
    @SerializedName("inventory_set")
    INVENTORY_SET("inventory_set");
    
    private final String str;
    
    private SeeAction(String str){
        this.str=str;
    }
    
    @Override
    public String toString(){
        return this.str;
    }
    
}
