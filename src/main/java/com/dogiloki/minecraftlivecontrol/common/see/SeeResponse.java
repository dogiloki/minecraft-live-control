package com.dogiloki.minecraftlivecontrol.common.see;

/**
 *
 * @author _dogi
 */

public class SeeResponse{
    
    private final String id_request;
    private final boolean success;
    private final Object data;
    private final String error;
    
    public SeeResponse(String id_request, boolean succes, Object data, String error){
        this.id_request=id_request;
        this.success=succes;
        this.data=data;
        this.error=error;
    }
    
    public String getIdRequest(){
        return this.id_request;
    }
    
    public boolean idSuccess(){
        return this.success;
    }
    
    public Object getData(){
        return this.data;
    }
    
    public String getError(){
        return this.error;
    }
    
}
