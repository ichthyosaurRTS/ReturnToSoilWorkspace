package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.BaruGaruSegmentRenderer;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
    public static void roseBeetleItem (TickEvent.PlayerTickEvent event) {

        PlayerEntity player = event.player;
        double speedMod = 0.4;

        if (rollChance.containsItem(BlockItemInit.ROSE_BEETLE_ITEM.get(),player) != 1000) {
            if (player.getHealth() == player.getMaxHealth()) {
                Vector3d playerVector = player.getDeltaMovement();
                float currentMoveSpeed;
                double playerXVector = playerVector.x;
                double playerZVector = playerVector.z;
                currentMoveSpeed = ( (float) Math.abs(playerXVector) + (float) Math.abs(playerZVector) )/2;
                if ( (playerVector.y > 0.2 && playerVector.y < 0.25) && (currentMoveSpeed > 0.075 && currentMoveSpeed < 2) )
                    player.setDeltaMovement(player.getDeltaMovement().add(speedMod * playerXVector, 0, speedMod * playerZVector));
            }
        }
    }
}




