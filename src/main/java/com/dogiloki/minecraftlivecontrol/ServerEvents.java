package com.dogiloki.minecraftlivecontrol;

import com.dogiloki.minecraftlivecontrol.common.see.SeeHandler;
import com.dogiloki.minecraftlivecontrol.minecraft.MinecraftAdapter;
import net.minecraft.server.MinecraftServer;
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
        MinecraftServer server=event.getServer();
        ClientInfo.initialize(server);
        MinecraftAdapter minecraft=new MinecraftAdapterImpl(server);
        SeeHandler.initialize(minecraft);
    }
    
}
