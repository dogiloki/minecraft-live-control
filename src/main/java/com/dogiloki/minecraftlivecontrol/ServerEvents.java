package com.dogiloki.minecraftlivecontrol;

import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 *
 * @author _dogi
 */

@Mod.EventBusSubscriber(modid=MinecraftLiveControl.IDMOD)
public class ServerEvents{
    
    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event){
        ClientInfo.initialize(event.getServer());
    }
    
}
