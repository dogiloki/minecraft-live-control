package com.dogiloki.minecraftlivecontrol.minecraft.model;

/**
 *
 * @author _dogi
 */

public class InventoryData{
    
    private final String uuid;
    private final ListItems items;
    
    public InventoryData(String uuid, ListItems items){
        this.uuid=uuid;
        this.items=items;
    }
    
    public String getUiid(){
        return this.uuid;
    }
    
    public ListItems getItems(){
        return this.items;
    }
    
}
