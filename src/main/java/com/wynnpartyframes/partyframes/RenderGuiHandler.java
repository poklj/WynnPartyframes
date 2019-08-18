package com.wynnpartyframes.partyframes;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.GuiNotification;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderGuiHandler {
    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event){
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        //new DebugGUI(Minecraft.getMinecraft());
        new PartyPull(Minecraft.getMinecraft());
    }

}
