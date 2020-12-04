package com.wynnpartyframes.partyframes;

import me.bed0.jWynn.api.v2.player.WynncraftPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;

class PlayerNameGUI extends Gui {
    /**
     * Display a Partymates name on the Hud
     * @param mc The Minecraft Instance
     * @param playerName The Player's name
     * @param x X position
     * @param y Y Position
     */
    PlayerNameGUI(Minecraft mc, String playerName, EntityPlayer player,int x, int y){
        String DisplayString = "";
        //Toggle if you should display total levels.
        if(PartyframesConfig.ShowLevel){
            if(player != null) {
                DisplayString += player.experienceLevel + " | ";
            } else {
                DisplayString += "* | ";
            }
        }
        DisplayString += playerName;
        drawString(mc.fontRenderer, DisplayString, x, y, Integer.parseInt("FFFFFF", 16));
    }
}
