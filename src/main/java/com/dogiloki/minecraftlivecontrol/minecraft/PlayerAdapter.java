package com.dogiloki.minecraftlivecontrol.minecraft;

import com.dogiloki.minecraftlivecontrol.minecraft.model.ListPlayers;
import com.dogiloki.minecraftlivecontrol.minecraft.model.PlayerData;

/**
 *
 * @author _dogi
 */

public interface PlayerAdapter{
    
    public ListPlayers getPlayers();
    public PlayerData getPlayer(String uuid);
    
}
