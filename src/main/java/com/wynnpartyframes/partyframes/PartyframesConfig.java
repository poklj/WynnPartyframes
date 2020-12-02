package com.wynnpartyframes.partyframes;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RangeInt;


@SuppressWarnings("WeakerAccess")
@Config(modid="wynnpartyframes", name="WynnPartyframesConfig")
public class PartyframesConfig {


    //TODO: Add Spacer Configuration for Unitframes, Column configuration and FaceShow

    @Config.Comment({
            "Change the X position of the origin point for the party frames",
            "Warning this is a Coarse adjustment",
            "It's recommended to change the Offsets rather then this, as this can cause a Divide by 0 error"

    })
    @RangeInt(min=-5, max=5)
    static int PartyframesX = 4;


    @Config.Comment({
            "Change the Y position of the origin point for the party frames",
            "Warning this is a Coarse adjustment",
            "It's recommended to change the Offsets rather then this, as this can cause a Divide by 0 error"

    })
    @RangeInt(min=-5, max=5)
    static int PartyframesY = 3;

    @Config.Comment({
            "Change the X Offset position"
    })
    @RangeInt(min=-5000, max=5000)
    public static int PartyframesXOffset = -1;
    @Config.Comment({
            "Change the Y Offset position"
    })
    @RangeInt(min=-5000, max=5000)
    public static int PartyframesYOffset = -1;

    @Config.Comment({
            "Set the Maximum Players per Column",
            "Note the maximum is way higher then the theoretical max party size (19)"
    })
    @RangeInt(min=1, max=30)
    public static int MaxPlayersPerColumn = 5;

    @Config.Comment({
            "Set the Distance separation between Columns (Not Implemented)"
    })
    public static int ColumnSpace = 1000;
    @Config.Comment({
            "Enable  Combat Level Display"
    })
    public static boolean ShowLevel = true;

}
