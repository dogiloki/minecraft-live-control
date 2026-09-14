package com.dogiloki.minecraftlivecontrol.common.see;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author _dogi
 */

public enum SeeEvent{
    
    @SerializedName("events")
    EVENTS("events"),
    @SerializedName("request")
    REQUEST("request"),
    @SerializedName("response")
    RESPONSE("response");
    
    private final String str;
    
    private SeeEvent(String str){
        this.str=str;
    }
    
    @Override
    public String toString(){
        return this.str;
    }
    
    public static SeeEvent from(String value){
        for(SeeEvent type:values()){
            if(type.str.equals(value)) return type;
        }
        return null;
    }
    
}
