package com.wynnpartyframes.partyframes;

import me.bed0.jWynn.WynncraftAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.management.PlayerList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartyPull {

    public PartyPull(Minecraft mc){

        List<String> PlayerList = null;
        List<String> PartyList = new ArrayList<>();

        List<EntityPlayer> PartyEntities = new ArrayList<>();

        //Get Taboverlay
        final NetHandlerPlayClient netHandlerPlayClient = mc.getConnection();
        if (netHandlerPlayClient != null) {
            final Collection<NetworkPlayerInfo> playerInfoMap = netHandlerPlayClient.getPlayerInfoMap();
            final GuiPlayerTabOverlay tabOverlay = mc.ingameGUI.getTabList();

            PlayerList = playerInfoMap.stream().map(tabOverlay::getPlayerName).collect(Collectors.toList());
            PlayerList.removeIf(n -> n.equals(""));


            //TODO: Figure out if this supports long playernames
            //TODO: Convert these to proper UNICODE checks, possibly using regex or maybe some other matching solution.
            for(String player : PlayerList){
                if (!player.contains("Party")) {
                    if((player.charAt(1) == 'c' && player.charAt(2) != '[') && player.endsWith("r")){
                        StringBuilder sb = new StringBuilder(player.trim());
                        PartyList.add(sb.deleteCharAt(0).deleteCharAt(0).deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1).toString());
                    } else if ((player.charAt(1) == 'e' && player.charAt(2) != '[') &&  player.endsWith("r")) {
                        StringBuilder sb = new StringBuilder(player.trim());
                        PartyList.add(sb.deleteCharAt(0).deleteCharAt(0).deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1).toString());
                    }
                }
            }
        }

        //Spawn the GUI
        try{
            new PartyGui(mc, PartyList);
        } catch (Exception e){}

    }
}
