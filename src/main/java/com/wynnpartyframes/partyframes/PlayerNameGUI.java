package com.wynnpartyframes.partyframes;

import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerNameGUI extends Gui {
    /**
     * Display a Partymates name on the Hud
     * @param mc The Minecraft Instance
     * @param playerName The Player's name
     * @param x X position
     * @param y Y Position
     */
    public PlayerNameGUI(Minecraft mc, String playerName, int x, int y){
        drawString(mc.fontRenderer, playerName,x, y, Integer.parseInt("FFFFFF", 16));
    }
}
