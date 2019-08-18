package com.wynnpartyframes.partyframes;

import com.ibm.icu.text.MessagePattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;


public class HealthBarGUI extends Gui {

    /**
     * Draw the healthbar based on health maximum
     * @param mc Minecraft instance
     * @param player PlayerEntity
     * @param x X position
     * @param y Y Position (Row Adjusted)
     */
    public HealthBarGUI(Minecraft mc, EntityPlayer player, int x, int y){
        GL11.glPushMatrix();
        GL11.glTranslatef(x-1,y-1,0);
        drawRect(0,0,72, 12, 0xFF000000);
        //Translate from the black bar to required point
        GL11.glTranslatef(1,1,0);
        if(player != null) {
            Partyframes.logger.info("Rendering Inrange");
            double health = player.getHealth();
            double maxHealth = player.getMaxHealth();
            double healthPercentage = (health / maxHealth);
            drawRect(0, 0, (int) Math.round(70*healthPercentage), 10, 0xFFFF5555);
        } else {
            Partyframes.logger.info("Rendering OutOfRange");
            drawRect(0, 0, 70,  10, 0xFF808080);
        }
        GL11.glPopMatrix();
    }
}
