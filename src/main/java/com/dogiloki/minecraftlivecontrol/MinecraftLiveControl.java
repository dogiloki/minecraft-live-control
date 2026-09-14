package com.dogiloki.minecraftlivecontrol;

import com.dogiloki.minecraftlivecontrol.common.see.SeeClient;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

/**
 *
 * @author _dogi
 */

@Mod(MinecraftLiveControl.IDMOD)
public class MinecraftLiveControl{
    
    public static final String IDMOD="minecraftlivecontrol";
    public static final Logger LOGGER=LogUtils.getLogger();
    private static SeeClient see_client;
    
    public static SeeClient getSeeClient(){
        return MinecraftLiveControl.see_client;
    }
    
    public MinecraftLiveControl(){
        MinecraftLiveControl.see_client=new SeeClient("http://127.0.0.1:8080");
    }
    
}
