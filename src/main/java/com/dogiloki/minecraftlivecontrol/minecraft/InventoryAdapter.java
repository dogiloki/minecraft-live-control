package com.dogiloki.minecraftlivecontrol.minecraft;

import com.dogiloki.minecraftlivecontrol.minecraft.model.InventoryData;
import com.dogiloki.minecraftlivecontrol.minecraft.model.ListItems;

/**
 *
 * @author _dogi
 */

public interface InventoryAdapter{
    
    public InventoryData getInventory(String uuid);
    public void updateSlots(String uuid, ListItems items);
    
}
