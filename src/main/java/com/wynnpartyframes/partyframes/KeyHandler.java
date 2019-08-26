package com.wynnpartyframes.partyframes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyHandler {


    @SideOnly(Side.CLIENT)

    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled = true)
    public static void onEvent(InputEvent.KeyInputEvent event){
        KeyBinding[] keyBindings = Partyframes.keyBindings;
        if(keyBindings[0].isPressed()){
            Partyframes.logger.info("Config binding pressed");
            System.out.println("Config binding pressed");
        }
    }
}
