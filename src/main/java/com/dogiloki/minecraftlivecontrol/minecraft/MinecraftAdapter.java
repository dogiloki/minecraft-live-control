package com.dogiloki.minecraftlivecontrol.minecraft;

/**
 *
 * @author _dogi
 */

public interface MinecraftAdapter{
    
    public PlayerAdapter getPlayerAdapter();
    public InventoryAdapter getInventoryAdapter();
    public NbtAdapter getNbtAdapter();
    
}
