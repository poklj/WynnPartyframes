package com.wynnpartyframes.partyframes;

import me.bed0.jWynn.api.v2.player.WynncraftPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class FrameOriginGUI {


    //TODO: Create FaceShow (Face orb) for Partyframes for if players want it
    /**
     * The origin of a PlayerFrame, this will spawn the necessary gui Pieces to construct a single Playerframe
     * @param mc The minecraft Instance
     * @param player the assigned PlayerEntity
     * @param x Origin X position
     * @param y Origin Y position
     */
    public FrameOriginGUI(Minecraft mc, WynncraftPlayer wp, EntityPlayer player, String playerName, int x, int y){
        new PlayerNameGUI(mc, wp,playerName, x, y);
        new HealthBarGUI(mc, player, x, y+10);
        //Todo: figure out how to make this optional
        new HealthPercentageGUI(mc, player, x, y+10);
    }
}
