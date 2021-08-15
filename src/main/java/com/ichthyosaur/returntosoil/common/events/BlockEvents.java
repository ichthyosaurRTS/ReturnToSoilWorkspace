package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RTSMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockEvents {

    @SubscribeEvent
    public static void onGrassBreak (BlockEvent.BreakEvent event) {
        BlockState state = event.getState();
        if (state.getBlock()== Blocks.GRASS && rollChance.roll(30) && !event.getPlayer().isCreative()) {
            BlockPos pos = event.getPos();
            ServerWorld worldIn = (ServerWorld) event.getWorld();
            ItemStack originSeed = new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get(),1);
            Block.popResource(worldIn, pos, originSeed);
        }
    }
    //technically a living entity event but oh well
    @SubscribeEvent
    public static void springLeaf (LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntityLiving();
        World world = entity.getCommandSenderWorld();
        BlockState inState = entity.getFeetBlockState(); // probs wont work
        BlockState belowState = world.getBlockState(new BlockPos (entity.getPosition(1).x(),
                entity.getPosition(1).y()-1, entity.getPosition(1).z()));

        if (inState.getBlock() == BlockItemInit.SPRING_LEAF_POTTED_BLOCK.get() ||
                belowState.getBlock() == BlockItemInit.SPRING_LEAF_POTTED_BLOCK.get() )
        {
            entity.setDeltaMovement(entity.getDeltaMovement().x(),entity.getDeltaMovement().y()+5,entity.getDeltaMovement().z());
        }
    }
}
