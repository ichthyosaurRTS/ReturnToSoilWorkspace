package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockInit;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class VesselVineBlock extends RTSCropsBlock {

    IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;

    public VesselVineBlock(Properties p_i48437_1_) {
        super(p_i48437_1_);
    }

    protected static final VoxelShape SHAPE = Block.box(4.0D, 1.0D, 4.0D, 12.0D, 14.0D, 12.0D);

    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemInit.VESSEL_SEED.get();
    }
    @Override
    protected boolean rollReplant(){
        return false;
    }
    @Override
    protected boolean useSeedDrop(){
        return false;
    }
    @Override
    protected Item getNonSeedDrop(){
        return ItemStack.EMPTY.getItem();
    }
    @Override
    protected Item getSeed(){
        return ItemStack.EMPTY.getItem();
    }

    @ParametersAreNonnullByDefault
    public void spawnAfterBreak(BlockState p_220062_1_, ServerWorld p_220062_2_, BlockPos p_220062_3_, ItemStack p_220062_4_) {
        removeAbove(p_220062_2_,p_220062_3_);
    }

    public static void removeAbove(ServerWorld p_220062_2_, BlockPos p_220062_3_) {
        BlockPos abovePos = p_220062_3_.above();
        BlockState above = p_220062_2_.getBlockState(abovePos);
        if (above.getBlock() instanceof VesselVineBlock) {
            p_220062_2_.setBlock(abovePos, Blocks.AIR.defaultBlockState(), 2);

            if (p_220062_2_.getBlockState(abovePos.above()).getBlock() instanceof VesselVineBlock)
                removeAbove(p_220062_2_,p_220062_3_.above());
        }
    }


    @Override
    @ParametersAreNonnullByDefault
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) //that last bool is the grow chance
                {
                    if (i+1 < this.getMaxAge() ) worldIn.setBlock(pos, this.nextAgeWithRotation(state,i+1), 2);

                    else if (i+1 == this.getMaxAge() && worldIn.getBlockState(pos.below()).getBlock() instanceof AirBlock) {

                        worldIn.setBlock(pos, this.nextAgeWithRotation(state,i+1), 2);

                        if (rollChance.roll(4)){
                            BlockState blockState = BlockInit.VESSEL_SAC_BLOCK.get().defaultBlockState().setValue(ROTATION,state.getValue(ROTATION)).setValue(INFESTED,false);
                            worldIn.setBlock(pos.below(),blockState,2);
                        }
                        else worldIn.setBlock(pos.below(), this.nextAgeWithRotation(state,0), 2);
                    }

                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public void growCrops(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        if (i < this.getMaxAge() ) world.setBlock(pos, this.nextAgeWithRotation(state,i), 2);

        else if (i == this.getMaxAge() && world.getBlockState(pos.below()).getBlock() instanceof AirBlock) {

            world.setBlock(pos, this.nextAgeWithRotation(state,i), 2);

            if (rollChance.roll(4)){
                BlockState blockState = BlockInit.VESSEL_SAC_BLOCK.get().defaultBlockState().setValue(ROTATION,state.getValue(ROTATION)).setValue(INFESTED,false);
                world.setBlock(pos.below(),blockState,2);
            }
            else world.setBlock(pos.below(), this.nextAgeWithRotation(state,0), 2);
        }
    }

    // When infested or less than 7 old, randomly ticks. Guess there's some unneeded code upstairs...
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE)<7;
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        return true;
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
    }

    @Override
    public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos p_196260_3_) {
        BlockState above = p_196260_2_.getBlockState(p_196260_3_.above());
        Block aboveBlock = above.getBlock();
        if (aboveBlock instanceof LeavesBlock) return true;
        else if (above.getBlock() instanceof VesselVineBlock)
            return above.getValue(AGE) == 7;
        else return false;
    }
}
