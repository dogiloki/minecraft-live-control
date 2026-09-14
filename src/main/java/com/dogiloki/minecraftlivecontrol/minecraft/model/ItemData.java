package com.dogiloki.minecraftlivecontrol.minecraft.model;

/**
 *
 * @author _dogi
 */

public class ItemData{
    
    private final int slot;
    private final String id;
    private final int count;
    private final Object nbt;
    
    public ItemData(int slot, String id, int count, Object nbt){
        this.slot=slot;
        this.id=id;
        this.count=count;
        this.nbt=nbt;
    }
    
    public int getSlot(){
        return this.slot;
    }
    
    public String getId(){
        return this.id;
    }
    
    public int getCount(){
        return this.count;
    }
    
    public Object getNbt(){
        return this.nbt;
    }
    
}
