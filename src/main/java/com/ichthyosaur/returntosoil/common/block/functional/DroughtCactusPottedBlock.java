package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.entity.player.PlayerEntity;
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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fluids.FluidAttributes;

import java.util.Random;

//filled when off cool down you can only take from when it can find a block below
public class DroughtCactusPottedBlock extends RTSPottedBlock{
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

        if (rollChance.roll(3) && p_225542_1_.getValue(FUEL_LEVEL)==0) p_225542_2_.setBlock(p_225542_3_,p_225542_1_.setValue(FUEL_LEVEL,1),2);
        //goes off cooldown here

    }

    @Override
    public ActionResultType use(BlockState p_225533_1_, World world, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {

        if (!world.isClientSide() && p_225533_1_.getValue(FUEL_LEVEL) == 1) {
            BlockPos source = findBelowFluidPos(p_225533_3_, (ServerWorld) world);
            if (source != p_225533_3_.above()) {

                BlockState sourceState = world.getBlockState(source);

                ItemStack itemstack = p_225533_4_.getItemInHand(p_225533_5_);
                Item item = itemstack.getItem();
                if (item instanceof BucketItem) {
                    if (((BucketItem) item).getFluid() == Fluids.EMPTY) {

                        world.setBlock(p_225533_3_, p_225533_1_.setValue(FUEL_LEVEL, 0), 2);

                        Fluid fluid = ((IBucketPickupHandler) sourceState.getBlock()).takeLiquid(world, source, sourceState);
                        ItemStack newBucket = DrinkHelper.createFilledResult(itemstack, p_225533_4_, new ItemStack(fluid.getBucket()));

                        //p_225533_4_.drop(newBucket,false);

                        itemstack.shrink(1);
                        p_225533_4_.inventory.add(newBucket);

                        //ActionResult.sidedSuccess(newBucket, world.isClientSide());
                        //p_225533_4_.setItemInHand(p_225533_5_, newBucket);

                        return ActionResultType.SUCCESS;
                    }
                } else return ActionResultType.PASS;
            }
        }


        return super.use(p_225533_1_, world, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);

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

        return pos.above();
    }
}
