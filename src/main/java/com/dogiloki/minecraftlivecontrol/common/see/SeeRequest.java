package com.dogiloki.minecraftlivecontrol.common.see;

import com.dogiloki.minecraftlivecontrol.minecraft.model.ListItems;

/**
 *
 * @author _dogi
 */

public class SeeRequest{
    
    private String id_request;
    private SeeAction action;
    private String uuid;
    private ListItems items;
    
    public String getIdRequest(){
        return this.id_request;
    }
    
    public SeeAction getAction(){
        return this.action;
    }
    
    public String getUuid(){
        return this.uuid;
    }
    
    public ListItems getItems(){
        return this.items;
    }
    
}
