package com.ichthyosaur.returntosoil.core.config;

import java.util.List;


public final class RTSConfigMisc {

    //its sad, but theres no too much point using a map here, probably just rely on slow ass lists.
    //maybe better to build an index map on startup, so we atleast know where things are on the list

    //just adds the new player to the list straight up no checks
    private static void cListAdd(String pName) {
        List<String> cList = RTSConfig.player_cult_string_list.get();

        cList.add(pName+".0");
        RTSConfig.player_cult_string_list.set(cList);

    }

    //uses getindex, changes the list to a new one
    public static void cListModify(String pName, int newLvl) {
        List<String> cList = RTSConfig.player_cult_string_list.get();

        cList.set(cListGetListIndex(pName), pName+"."+newLvl);

        RTSConfig.player_cult_string_list.set(cList);

    }

    //for increments, uses modify. remember to use name.getString() rather than .toString()!
    public static void cListIncrease(String pName, int increment) {
        List<String> cList = RTSConfig.player_cult_string_list.get();

        cListModify(pName, cListGetLvl(pName)+increment);
    }

    //returns int index of the player in the list, will cListAdd a new one if needed and return the latest index
    private static int cListGetListIndex(String pName) {

        List<String> cList = RTSConfig.player_cult_string_list.get();

        for (int i = 0; i <  cList.size();i++) {
            String cListEntry = cList.get(i);

            //make sure the name isn't smaller than the entry eg the 7th index of 'bob.10' doesn't exist
            if (cListEntry.length() > pName.length()) {
                String nameDot = pName+".";
                int nameDotLength = nameDot.length();
                String listNameDot = cListEntry.substring(0,nameDotLength);

                if (nameDot.equals(listNameDot)) {
                    return i;
                }
            }
        }
        //if it doesnt find it, add the player and return the size and the index ie 0-49 returns index 50
        int index = cList.size();
        cListAdd(pName);
        return index;
    }

    public static int cListGetLvl (String pName) {
        List<String> cList = RTSConfig.player_cult_string_list.get();

        int pNameDot = pName.length()+1;
        String levelString = cList.get(cListGetListIndex(pName)).substring(pNameDot);
        int levelInt = Integer.parseInt(levelString);

        return levelInt;
    }
}
