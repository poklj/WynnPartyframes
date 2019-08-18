package com.wynnpartyframes.partyframes;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RangeInt;

@Config(modid="wynnpartyframes", name="WynnPartyframesConfig")
public class PartyframesConfig {


    @Config.Comment({
            "Change the X position of the origin point for the party frames",
            "Warning this is a Coarse adjustment"

    })
    @RangeInt(min=-5, max=5)
    public static int PartyframesX = 4;
    @Config.Comment({
            "Change the Y position of the origin point for the party frames",
            "Warning this is a Coarse adjustment"

    })
    @RangeInt(min=-5, max=5)
    public static int PartyframesY = 3;
}
