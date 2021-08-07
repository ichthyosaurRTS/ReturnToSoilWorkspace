package com.ichthyosaur.returntosoil.core.util;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

//Now a static util function class
public class rollChance {
    public static boolean roll (int denominator) {
        Random rand = new Random();
        int i = rand.nextInt(denominator);
        return i==0;
    }

    //give 20, receive number between 1-20 inclusive
    public static float returnRoll (int denominator) {
        Random rand = new Random();
        int i = rand.nextInt(denominator);
        return i+1;
    }

    //returns the slot an item is in(0-35). if the item is not there, returns 1000;
    public static float containsItem(Item item, PlayerEntity player) {
        for(int i = 0; i < 36; i++) {
            if (player.inventory.getItem(i).getItem() == item) return i; }
        return 1000;
    }

    public static Entity[] createSegmentList(UUID[] UUIDList, ServerWorld world) {
        Entity[] returnList = new Entity[UUIDList.length];
        for (int i = 0; i < UUIDList.length; i++) {
            if (world.getEntity(UUIDList[i])!=null) returnList[i] = world.getEntity(UUIDList[i]);
        }
        return returnList;
    }

}
