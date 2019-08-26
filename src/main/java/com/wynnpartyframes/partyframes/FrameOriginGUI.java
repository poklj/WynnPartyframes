package com.wynnpartyframes.partyframes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;

public class FrameOriginGUI {



    /**
     * The origin of a PlayerFrame, this will spawn the necessary gui Pieces to construct a single Playerframe
     * @param mc The minecraft Instance
     * @param player the assigned PlayerEntity
     * @param x Origin X position
     * @param y Origin Y position
     */
    public FrameOriginGUI(Minecraft mc, EntityPlayer player, String playerName, int x, int y){
        new PlayerNameGUI(mc, playerName, x, y);
        new HealthBarGUI(mc, player, x, y+10);
        //Todo: figure out how to make this optional
        new HealthPercentageGUI(mc, player, x, y+10);
    }
}
