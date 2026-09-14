package com.dogiloki.minecraftlivecontrol.common.see;

import com.dogiloki.minecraftlivecontrol.minecraft.MinecraftAdapter;

/**
 *
 * @author _dogi
 */

public interface SeeActionHandler{
    
    public void handle(SeeRequest request, MinecraftAdapter minecraft);
    
}
