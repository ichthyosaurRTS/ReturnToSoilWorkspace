package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.block.cropblock.SpringLeafBlock;
import com.ichthyosaur.returntosoil.common.block.functional.RTSPottedBlock;
import com.ichthyosaur.returntosoil.common.block.functional.SpringLeafPottedBlock;
import com.ichthyosaur.returntosoil.common.tileentity.IHoldsTarget;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = RTSMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockEvents {

    private static final IntegerProperty COOL_DOWN = RTSMain.COOL_DOWN;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

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

    @SubscribeEvent
    public static void springTargetSet (LivingEvent event) {
        LivingEntity entity = event.getEntityLiving();
        World world = entity.level;
        BlockState inState = entity.getFeetBlockState();
        BlockPos in = new BlockPos (entity.getPosition(1));

        if (inState.hasTileEntity() && inState.getBlock() instanceof SpringLeafPottedBlock && !world.isClientSide())
        {
            if (world.getBlockEntity(in) instanceof IHoldsTarget)
            ((IHoldsTarget) Objects.requireNonNull(world.getBlockEntity(in))).setTarget(entity);
        }
    }
}
