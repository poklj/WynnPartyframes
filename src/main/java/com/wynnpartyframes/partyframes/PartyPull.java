package com.wynnpartyframes.partyframes;

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

public class PartyPull extends Gui {
    public static <R> Predicate<R> not(Predicate<R> predicate) {
        return predicate.negate();
    }
    public PartyPull(Minecraft mc){

        List<String> PlayerList = null;
        List<String> PartyList = new ArrayList<>();
        ScaledResolution scaled;
        scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        List<EntityPlayer> PartyEntities = new ArrayList<>();
        //Get Taboverlay
        final NetHandlerPlayClient netHandlerPlayClient = mc.getConnection();
        if (netHandlerPlayClient != null) {
            final Collection<NetworkPlayerInfo> playerInfoMap = netHandlerPlayClient.getPlayerInfoMap();
            final GuiPlayerTabOverlay tabOverlay = mc.ingameGUI.getTabList();

            PlayerList = playerInfoMap.stream().map(tabOverlay::getPlayerName).collect(Collectors.toList());
            PlayerList.removeIf(n -> n.equals(""));
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
        //Add Get all player entities
        for (String player : PartyList) {
            PartyEntities.add(mc.world.getPlayerEntityByName(player));
        }

            int row = 0;
            for(int i = 0; i < PartyList.size(); i++){
                String name = PartyList.get(i);
                String health = "";
                String mana = "";
                if(PartyEntities.get(i) != null){
                    health = String.valueOf(PartyEntities.get(i).getHealth());
                    mana = String.valueOf(PartyEntities.get(i).getFoodStats().getFoodLevel());
                } else {
                    health = "Out of render range";
                }
                drawString(mc.fontRenderer, name, width / PartyframesConfig.PartyframesX, (height / PartyframesConfig.PartyFramesY)+(row*22), Integer.parseInt("FFFFFF", 16));
                drawString(mc.fontRenderer, health, width / PartyframesConfig.PartyframesX, (height / PartyframesConfig.PartyFramesY)+(row*22)+8, Integer.parseInt("FF5555", 16));
                //drawString(mc.fontRenderer, mana, width / PartyframesConfig.PartyframesX, (height / PartyframesConfig.PartyFramesY)+(row*22)+16, Integer.parseInt("5555FF", 16));
                row++;
            }


    }
}
