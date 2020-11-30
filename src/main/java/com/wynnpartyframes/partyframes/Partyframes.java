package com.wynnpartyframes.partyframes;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.v2.player.WynncraftPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;


//Suppress Access warnings
@SuppressWarnings("WeakerAccess")
@Mod(modid = "wynnpartyframes", version = "1.1.1", useMetadata = true)
public class Partyframes {
    public static final String MODID = "wynnpartyframes";
    public static final String NAME = "Wynn Partyframes";
    public static final String VERSION = "1.1.1";
    public static final WynncraftAPI api = new WynncraftAPI();
    public static final asyncAPI AsyncAPI_Player = new asyncAPI();

    public static Logger logger;
    public static KeyBinding[] keyBindings;
    public static Configuration config;
    public KeyHandler keyHandler;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        config = new Configuration(event.getSuggestedConfigurationFile());
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(this);

    }

    @EventHandler
    public void init(FMLInitializationEvent event){
        keyBindings = new KeyBinding[1];
        keyBindings[0] = new KeyBinding("PartyFrames Configure", Keyboard.KEY_O, "Wynn Partyframes");
        ConfigManager.sync(MODID, Config.Type.INSTANCE);
        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
    }


    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.getModID().equals(Partyframes.MODID)){
            logger.info("ConfigChanged, syncing");
            ConfigManager.sync(Partyframes.MODID, Config.Type.INSTANCE);
            logger.info("Config Settings, X Coarse: "+PartyframesConfig.PartyframesX+" + Offset: "+PartyframesConfig.PartyframesXOffset+" Y Coarse: "+PartyframesConfig.PartyframesY+" + Offset: "+PartyframesConfig.PartyframesYOffset);
        }
    }

}
