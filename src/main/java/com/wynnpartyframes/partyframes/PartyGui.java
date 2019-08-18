package com.wynnpartyframes.partyframes;

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

        for(int i = 0; i < PartyList.size(); i++){
            if(PartyframesConfig.PartyframesX != 0 && PartyframesConfig.PartyframesY != 0)
                new FrameOriginGUI(mc, PartyEntities.get(i),PartyList.get(i),width / PartyframesConfig.PartyframesX, (height / PartyframesConfig.PartyframesY)+(row*22));
            else if(PartyframesConfig.PartyframesX == 0)
                new FrameOriginGUI(mc, PartyEntities.get(i),PartyList.get(i),width, (height / PartyframesConfig.PartyframesY)+(row*22));
            else if(PartyframesConfig.PartyframesY == 0)
                new FrameOriginGUI(mc, PartyEntities.get(i),PartyList.get(i),width / PartyframesConfig.PartyframesX, (height)+(row*22));
            else
                new FrameOriginGUI(mc, PartyEntities.get(i),PartyList.get(i),width, (height)+(row*22));
            row++;
        }



    }
}
