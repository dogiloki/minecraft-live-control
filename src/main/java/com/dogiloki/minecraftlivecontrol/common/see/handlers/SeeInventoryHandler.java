package com.dogiloki.minecraftlivecontrol.common.see.handlers;

import com.dogiloki.minecraftlivecontrol.common.see.SeeActionHandler;
import com.dogiloki.minecraftlivecontrol.common.see.SeeHandler;
import com.dogiloki.minecraftlivecontrol.common.see.SeeRequest;
import com.dogiloki.minecraftlivecontrol.minecraft.MinecraftAdapter;
import com.dogiloki.minecraftlivecontrol.minecraft.model.InventoryData;

/**
 *
 * @author _dogi
 */

public class SeeInventoryHandler implements SeeActionHandler{

    @Override
    public void handle(SeeRequest request, MinecraftAdapter minecraft){
        String uuid=request.getUuid();
        if(uuid==null || uuid.isEmpty()){
            SeeHandler.sendResponse(request.getIdRequest(),"Falta UUID");
            return;
        }
        InventoryData inventory=minecraft.getInventoryAdapter().getInventory(uuid);
        if(inventory==null){
            SeeHandler.sendResponse(request.getIdRequest(),"Jugador no conectado");
            return;
        }
        SeeHandler.sendResponse(request.getIdRequest(),inventory);
    }
    
}
