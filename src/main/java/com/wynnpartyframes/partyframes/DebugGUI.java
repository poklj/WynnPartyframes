package com.wynnpartyframes.partyframes;

import ibxm.Player;
import javafx.scene.transform.Scale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DebugGUI extends Gui {
    //TODO: update this to be more useful later on
    public DebugGUI(Minecraft mc){
        /*
        Create resolution scaler
        */
        ScaledResolution scaled;
        scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();



        //NOTE: §c<Name>§r is party leader
        // §e is member

        /*
          Get Tabbed playerlist
         */
        final NetHandlerPlayClient netHandlerPlayClient = mc.getConnection();
        String text = "";

        List<String> PlayerList = null;

        if (netHandlerPlayClient != null) {
            final Collection<NetworkPlayerInfo> playerInfoMap = netHandlerPlayClient.getPlayerInfoMap();
            final GuiPlayerTabOverlay tabOverlay = mc.ingameGUI.getTabList();

             PlayerList = playerInfoMap.stream().map(tabOverlay::getPlayerName).collect(Collectors.toList());
             PlayerList.removeIf(n -> n.equals(""));
            // Partyframes.logger.info(PlayerList);
        }
        if(PlayerList != null) {
            int row = 0;
            int maxcolumns = 4;

            for(int player = 0; player<PlayerList.size(); player++) {
                    if(player%maxcolumns == 0){
                        row++;
                    }

                    int originwidth = width / 3;
                    int originheight = height / 3;


                    drawString(mc.fontRenderer, PlayerList.get(player), (width / 3)-((player % maxcolumns)*100), (height / 3)+(row*10), Integer.parseInt("FFAA00", 16));
            }
        }
        //drawString(mc.fontRenderer, text, width / 3, (height / 3) -4, Integer.parseInt("FFAA00", 16));
    }
}
