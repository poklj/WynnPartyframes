package com.wynnpartyframes.partyframes;

import me.bed0.jWynn.api.v2.player.WynncraftPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

public class PartyGui extends Gui {

    public PartyGui(Minecraft mc, List<String> PartyList) {

        ScaledResolution scaled;
        scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        List<EntityPlayer> PartyEntities = new ArrayList<>();
        for (String player : PartyList) {
            PartyEntities.add(mc.world.getPlayerEntityByName(player));
        }

        int row = 0;
        /* Old GUI code
        for(int i = 0; i < PartyList.size(); i++){
            String name = PartyList.get(i);
            String health = "";
            if(PartyEntities.get(i) != null){
                health = String.valueOf(PartyEntities.get(i).getHealth());
            } else {
                health = "Out of render range";
            }
            drawString(mc.fontRenderer, name, width / PartyframesConfig.PartyframesX, (height / PartyframesConfig.PartyFramesY)+(row*22), Integer.parseInt("FFFFFF", 16));
            drawString(mc.fontRenderer, health, width / PartyframesConfig.PartyframesX, (height / PartyframesConfig.PartyFramesY)+(row*22)+8, Integer.parseInt("FF5555", 16));
            row++;
        }
        */
        int Current_column = 0;
        for(int i = 0; i < PartyList.size(); i++) {
            //TODO: Add Columns to support the theoretical max party size of

//                if(PartyframesConfig.MaxPlayersPerColumn % i == 0){
//
//                }
            new FrameOriginGUI(mc, PartyEntities.get(i), PartyList.get(i), (width / (PartyframesConfig.PartyframesX)) + PartyframesConfig.PartyframesXOffset, ((height / PartyframesConfig.PartyframesY)+ PartyframesConfig.PartyframesYOffset) + (row * 22));
            row++;
        }
    }
}
