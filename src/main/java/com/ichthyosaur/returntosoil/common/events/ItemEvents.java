package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.logging.Logger;

@Mod.EventBusSubscriber(modid = RTSMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemEvents {

//Logger logger = Logger.getLogger("logger");;
//logger.info(""+playerVector.x);


    //Multiplier item; multiplies your flat speed during upwards y movement; stacks with other items
    //must be full hp to use. has an upper limit.
    @SubscribeEvent
    public static void holdingRoseBeetleCharm (TickEvent.PlayerTickEvent event) {

        PlayerEntity player = event.player;

        if (rollChance.containsItem(BlockItemInit.roseBeetleItem,player) != 1000) {
            if (player.getHealth() == player.getMaxHealth()) {
                Vector3d playerVector = player.getDeltaMovement();
                float currentMoveSpeed;
                double playerXVector = playerVector.x;
                double playerZVector = playerVector.z;
                currentMoveSpeed = ( (float) Math.abs(playerXVector) + (float) Math.abs(playerZVector) )/2;
                if (playerVector.y > 0 && currentMoveSpeed > 0.05 && (currentMoveSpeed < 2) )
                    player.setDeltaMovement(player.getDeltaMovement().add(playerXVector * playerVector.y / 2, 0, playerZVector * playerVector.y / 2));
            }
        }
    }



    //just don't look...
    //Vector3d look = player.getLookAngle(); //look.x would be between 1 and -1
    //should go generally in the direction you look..
    //needs beetle model below you like stand
    //if (hand.getItem().equals(BlockItemInit.roseBeetleCharm) && !player.isInWater() && !player.isInLava() && playerVector.y < 0.01) {
    //player.setDeltaMovement(player.getDeltaMovement().add(0, 0.04, 0));
    //player.setDeltaMovement(player.getDeltaMovement().add(look.x*5, 5, look.z*5)); smthn like a cloud jumper...
    //if (rollChance.roll(20)) player.setDeltaMovement(player.getDeltaMovement().add((rollChance.returnRoll(20)-10)/15, 0.1, (rollChance.returnRoll(20)-10)/15));
    //else player.setDeltaMovement(player.getDeltaMovement().add(look.x/20, look.y/20+0.1, look.z/20));
    //}


}
