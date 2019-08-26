package com.wynnpartyframes.partyframes;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RangeInt;

@SuppressWarnings("WeakerAccess")
@Config(modid="wynnpartyframes", name="WynnPartyframesConfig")
public class PartyframesConfig {


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

}
