package com.dogiloki.minecraftlivecontrol.common.see.handlers;

import com.dogiloki.minecraftlivecontrol.common.see.SeeActionHandler;
import com.dogiloki.minecraftlivecontrol.common.see.SeeHandler;
import com.dogiloki.minecraftlivecontrol.common.see.SeeRequest;
import com.dogiloki.minecraftlivecontrol.minecraft.MinecraftAdapter;
import com.dogiloki.minecraftlivecontrol.minecraft.model.ListItems;

/**
 *
 * @author _dogi
 */

public class SeeInventorySetHandler implements SeeActionHandler{
    
    @Override
    public void handle(SeeRequest request, MinecraftAdapter minecraft){
        String uuid=request.getUuid();
        if(uuid==null || uuid.isEmpty()){
            SeeHandler.sendResponse(request.getIdRequest(),"Falta UUID");
            return;
        }
        ListItems items=request.getItems();
        if(items==null || items.isEmpty()) return;
        minecraft.getInventoryAdapter().updateSlots(uuid,items);
    }
    
}
