package com.dogiloki.minecraftlivecontrol.common.see.handlers;

import com.dogiloki.minecraftlivecontrol.common.see.SeeActionHandler;
import com.dogiloki.minecraftlivecontrol.common.see.SeeHandler;
import com.dogiloki.minecraftlivecontrol.common.see.SeeRequest;
import com.dogiloki.minecraftlivecontrol.minecraft.MinecraftAdapter;

/**
 *
 * @author _dogi
 */
public class SeePlayersHandler implements SeeActionHandler{
    
    @Override
    public void handle(SeeRequest request, MinecraftAdapter minecraft){
        SeeHandler.sendResponse(request.getIdRequest(),minecraft.getPlayerAdapter().getPlayers());
    }
    
}
