package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RTSMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemEvents {
 

    //Multiplier item; multiplies your flat speed during upwards y movement; stacks with other items
    //must be full hp to use. has an upper limit.
    @SubscribeEvent
    public static void roseBeetleItem (TickEvent.PlayerTickEvent event) {

        PlayerEntity player = event.player;
        double speedMod = 0.4;

        if (rollChance.containsItem(BlockItemInit.ROSE_BEETLE_ITEM.get(),player) != 1000) {
            Vector3d playerVector = player.getDeltaMovement();
            float currentMoveSpeed;
            double playerXVector = playerVector.x;
            double playerZVector = playerVector.z;
            currentMoveSpeed = ( (float) Math.abs(playerXVector) + (float) Math.abs(playerZVector) )/2;
            if ( (playerVector.y > 0.2 && playerVector.y < 0.25) && (currentMoveSpeed > 0.075 && currentMoveSpeed < 2) )
                player.setDeltaMovement(player.getDeltaMovement().add(speedMod * playerXVector, 0, speedMod * playerZVector));
        }

        //
        /*if (!player.isCreative()&&player.isAlive()){  this works great
            player.setHealth(8);
        }*/
    }



    @SubscribeEvent
    public static void invItemTick (TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ServerWorld world;
        if (!player.level.isClientSide())  world = (ServerWorld) player.level;
            for(int i = 0; i < 36; i++) {
                Item item = player.inventory.getItem(i).getItem();

                if (item == BlockItemInit.HEAVY_PLANT_SEED.get() || item == BlockItemInit.HEAVY_PLANT_POTTED_ITEM.get()) {heavyVector(player);}

            }
    }

    private static void heavyVector(PlayerEntity player){
        float yVector;
        if ((player.getDeltaMovement().y) < 0) yVector = (float) (player.getDeltaMovement().y*1.5);
        else yVector = (float)-0.1;
        if ((player.getDeltaMovement().y) < -5) {}
        else player.setDeltaMovement(player.getDeltaMovement().x/2,player.getDeltaMovement().y+yVector,player.getDeltaMovement().z/2);
    }

}






