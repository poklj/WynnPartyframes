package com.wynnpartyframes.partyframes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Logger;



@Mod(modid = "wynnpartyframes", version = "1.0.2", useMetadata = true)
public class Partyframes {
    public static final String MODID = "wynnpartyframes";
    public static final String NAME = "Wynn Partyframes";
    public static final String VERSION = "1.0.2";


    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event){

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
    }


}
