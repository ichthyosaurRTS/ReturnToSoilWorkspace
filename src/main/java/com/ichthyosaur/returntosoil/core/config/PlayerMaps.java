package com.ichthyosaur.returntosoil.core.config;

import com.ichthyosaur.returntosoil.RTSMain;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class PlayerMaps {

    //its sad, but theres no too much point using a map here, probably just rely on slow ass lists.
    //maybe better to build an index map on startup, so we atleast know where things are on the list
    static final HashMap cultMap = new HashMap<String, Integer>();

    //to be built once every time the game is loaded
    public static void cultMapBuild(){
        List<String> pCList = RTSConfig.player_cult_string_list.get();

        for (String s : pCList) {

            String name;
            Integer cultLevel;

            String fullString = "null";
            int fullStopIndex = 0;

            for (int o = 0; o < fullString.length(); o++) {

                if (fullString.charAt(o) == '.') {
                    fullStopIndex = o;
                    o = fullString.length();
                }
            }

            name = fullString.substring(0,fullStopIndex);
            cultLevel = Integer.parseInt(fullString.substring(fullStopIndex+1, fullString.length()));

            //on build, we're just looking to build from the config file, not adding to it
            cultMapAdd(name, cultLevel);
            RTSMain.LOGGER.info("now adding "+name+" with level "+cultLevel);
        }
    }

    public static boolean onCultMap(String player){
        return cultMap.containsKey(player);
    }

    public static void cultMapAdd(String player, Integer cult_lvl){
        if (!onCultMap(player)) cultMap.put(player,cult_lvl);
    }

    public static void configListAdd(String player, Integer cult_lvl){

        String nameCult = player+"."+cult_lvl;
        RTSConfig.player_cult_string_list.get().add(nameCult);
    }

    public static int cultMapGetLvl(String player){
        if (!cultMap.containsKey(player)) cultMapAdd(player, 0);
        return (int) cultMap.get(player);
    }

    public static void playerCultIncrease(String playerName, int increment) {

        List<String> configList = RTSConfig.player_cult_string_list.get();
        for (int i = 0; i <  configList.size();i++) {
            String s = configList.get(i);

            if (s.length()>playerName.length()) {
                String namePlusFullstop = playerName+".";
                String listNamePlusOne = s.substring(0,namePlusFullstop.length());

                //in string + int + int the last int will be added as a string (duh)
                if (namePlusFullstop.equals(listNamePlusOne)) {
                    String c = s.substring((namePlusFullstop.length()));
                    RTSMain.LOGGER.info(c);
                    int newCultLvl = Integer.parseInt(c)+increment;
                    String newConfigString = namePlusFullstop+newCultLvl;

                    configList.set(i, newConfigString);
                    RTSConfig.player_cult_string_list.set(configList);
                    RTSMain.LOGGER.info("trying to set config list to "+configList);

                    cultMap.put(playerName, cultMapGetLvl(playerName)+increment);

                    i = configList.size();
                }
            }
        }
    }

}
