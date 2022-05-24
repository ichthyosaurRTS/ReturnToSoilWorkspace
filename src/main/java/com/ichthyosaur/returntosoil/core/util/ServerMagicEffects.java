package com.ichthyosaur.returntosoil.core.util;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.effect.MagicEffectDraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ServerMagicEffects {

    public static LinkedList<String> MagicEffectsList;

    public static void createList(){
        MagicEffectsList = new LinkedList<>();
        //MagicEffectsList.add("a");
    }

    public static void addEffect(String string) {
        MagicEffectsList.add(string);
    }

    public static void tickMagicEffectList(ServerWorld world){

        //if (MagicEffectsList==null) createList();
        //else
        //apparently a tradittional for loop prevents concurrent exception somehow???
            for (int i = 0; i < MagicEffectsList.size(); i++) {

                if (MagicEffectsList.get(i)==null) return;

                String StringUUID = MagicEffectsList.get(i);
                UUID entityUUID = UUID.fromString(StringUUID);
                if (world.getEntity(entityUUID)!=null) {
                    Entity entity = world.getEntity(entityUUID);

                    entity.setDeltaMovement(entity.getDeltaMovement().x(), entity.getDeltaMovement().y()+0.5, entity.getDeltaMovement().z());
                    //this is needed for the server to update a players velocity this one tick... i don't like this workaround.
                    if (entity instanceof PlayerEntity) entity.hurtMarked = true;

                    //entity.moveTo(300,60,300);
                    //entity.teleportTo(300,60,300);
                    ReturnToSoil.LOGGER.info("launching entity!");
                }
                else ReturnToSoil.LOGGER.info("the entity is null?");
                MagicEffectsList.remove(StringUUID);

        }
    }
}
