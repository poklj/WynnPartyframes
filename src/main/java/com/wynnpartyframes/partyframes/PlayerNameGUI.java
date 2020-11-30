package com.wynnpartyframes.partyframes;

import com.ibm.icu.text.MessagePattern;
import ibxm.Player;
import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.v2.player.WynncraftPlayer;
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
        String DisplayString = "";
        //Toggle if you should display total levels.
        Partyframes.AsyncAPI_Player.Pulldata(playerName);
        WynncraftPlayer wynnPlayer = null;
        if(PartyframesConfig.TotalLevel){
            if(Partyframes.AsyncAPI_Player.getValue() != null) {
                wynnPlayer = (WynncraftPlayer) Partyframes.AsyncAPI_Player.getValue();
                DisplayString += wynnPlayer.getGlobal().getTotalLevel().getCombat() + "| ";
            }
        }
        DisplayString += playerName;
        drawString(mc.fontRenderer, DisplayString,x, y, Integer.parseInt("FFFFFF", 16));
    }
}
