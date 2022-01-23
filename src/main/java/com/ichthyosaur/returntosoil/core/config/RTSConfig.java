package com.ichthyosaur.returntosoil.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("DEBUG")
public final class RTSConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    //this list will contain playername.cultivationlevel, playername.cultivationlevel, playername.cultivationlevel,
    public static final ForgeConfigSpec.ConfigValue<List<String>> player_cult_string_list;

    static List<String> emptyListS = new ArrayList();


    static {
        BUILDER.push("config for returntosoil");

        player_cult_string_list = BUILDER.comment("player cultivation level list").define("player_cult",emptyListS);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
