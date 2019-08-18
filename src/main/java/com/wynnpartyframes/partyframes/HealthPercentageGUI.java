package com.wynnpartyframes.partyframes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import scala.Int;

public class HealthPercentageGUI extends Gui {

    public HealthPercentageGUI(Minecraft mc, EntityPlayer player, int x, int y){
        if(player != null) {
            String healthPercent = Integer.toString(Math.round((player.getHealth() / player.getMaxHealth()) * 100));
            drawString(mc.fontRenderer, healthPercent, x + 24, y + 1, 0xFFFFFFFF);
        } else {
            drawString(mc.fontRenderer, "Out of range", x+3, y+1, 0xFFFFFFFF);
        }
    }
}
