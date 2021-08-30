package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fluids.FluidAttributes;

import java.util.Random;

//filled when off cool down you can only take from when it can find a block below
public class DroughtCactusPottedBlock extends RTSPottedBlock implements IBucketPickupHandler{
    public DroughtCactusPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FUEL_LEVEL,0));
    }

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FUEL_LEVEL);
    }

    @Override
    public void randomTick(BlockState p_225542_1_, ServerWorld p_225542_2_, BlockPos p_225542_3_, Random p_225542_4_) {
        super.randomTick(p_225542_1_, p_225542_2_, p_225542_3_, p_225542_4_);

        if (rollChance.roll(2) && p_225542_1_.getValue(FUEL_LEVEL)==0) p_225542_2_.setBlock(p_225542_3_,p_225542_1_.setValue(FUEL_LEVEL,1),2);
    }



    private BlockPos findBelowFluidPos (BlockPos pos, ServerWorld world) {
        for (int y = 0 ; y > -100 ; y --) {
            for (int z = -1 ; z < 2 ; z ++) {
                for (int x = -1 ; x < 2 ; x ++) {

                    BlockPos current = new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()+z);
                    if (world.getFluidState(current).isSource()) return current;
                }
            }
        }
        return pos;
    }

    @Override
    public Fluid takeLiquid(IWorld world, BlockPos pos, BlockState state) {

        if (!world.isClientSide() && state.getValue(FUEL_LEVEL) == 1) {
            BlockPos source = findBelowFluidPos(pos, (ServerWorld) world);

            if (world.getBlockState(source).getFluidState() != Fluids.EMPTY.defaultFluidState()) {
                BlockState sourceState = world.getBlockState(source);
                world.setBlock(pos, state.setValue(FUEL_LEVEL, 0), 2);
                return ((IBucketPickupHandler) sourceState.getBlock()).takeLiquid(world, source, sourceState);
            }
        }
        return Fluids.EMPTY;
    }
}
