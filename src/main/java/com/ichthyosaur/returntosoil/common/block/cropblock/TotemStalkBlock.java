package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;


public class TotemStalkBlock extends BushBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public static final IntegerProperty ROTATION = ReturnToSoil.ROTATION_4;
    public static final BooleanProperty INFESTED = ReturnToSoil.INFESTED;


    public TotemStalkBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    protected static final VoxelShape SHAPE = Block.box(4.0D, 1.0D, 4.0D, 12.0D, 15.0D, 12.0D);
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(AGE, ROTATION, INFESTED);
    }

    // just tick all the time for now
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @ParametersAreNonnullByDefault
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (state.getValue(INFESTED)) {}
        if (state.getValue(AGE)==0 && !(canGrowUp(worldIn, pos))){}
        else if (state.getValue(AGE)<2 && rollChance.roll(5)){
            if (state.getValue(AGE)==1 && canGrowUp(worldIn, pos))
                worldIn.setBlock(pos.above(), this.getNextState(state, true), 2);

            worldIn.setBlock(pos, this.getNextState(state, false), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);


        }
        else if (state.getValue(AGE)==2 && canGrowUp(worldIn, pos) && rollChance.roll(5)) {
            worldIn.setBlock(pos.above(), this.getNextState(state, true), 2);
        }


    }

    private boolean canGrowUp(ServerWorld worldIn, BlockPos pos){
        if (worldIn.getBlockState(pos.above()).getBlock() instanceof AirBlock && !atMaxHeight(worldIn, pos)) return true;
        return false;
    }

    private boolean atMaxHeight(ServerWorld worldIn, BlockPos pos) {
        for (int i=0;i<14;i++) {
            if (!(worldIn.getBlockState(pos.below(i)).getBlock() instanceof TotemStalkBlock)) return false;
        }
        return true;
    }

    //call only for age 0 and 1
    public BlockState getNextState(BlockState state, boolean ageZero) {
        if (ageZero) return state.setValue(AGE, 0).setValue(INFESTED,false);

        boolean infested = state.getValue(INFESTED);
        int newAge = state.getValue(AGE)+1;
        if (newAge==2&& rollChance.roll(40)) infested = true;
        BlockState block = state.setValue(AGE, newAge).setValue(INFESTED,infested);
        return block;
    }

    @ParametersAreNonnullByDefault
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, (int)(rollChance.returnRoll(4)-1)).setValue(INFESTED,false);
    }

    @Override
    public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos p_196260_3_) {
        Block below = p_196260_2_.getBlockState(p_196260_3_.below()).getBlock();
        return (below.is(Blocks.GRASS_BLOCK)||below.is(Blocks.DIRT)||
                below instanceof  TotemStalkBlock && p_196260_2_.getBlockState(p_196260_3_.below()).getValue(AGE)==2);
    }

    public boolean propagatesSkylightDown(BlockState p_200123_1_, IBlockReader p_200123_2_, BlockPos p_200123_3_) {
        return true;
    }

    /*@ParametersAreNonnullByDefault
    public void spawnAfterBreak(BlockState p_220062_1_, ServerWorld p_220062_2_, BlockPos p_220062_3_, ItemStack p_220062_4_) {
        breakAbove(p_220062_2_,p_220062_3_);
    }*/

    /*public static void breakAbove(ServerWorld worldIn_, BlockPos pos) {
        BlockPos abovePos = pos.above();
        BlockState above = worldIn_.getBlockState(abovePos);
        if (above.getBlock() instanceof TotemStalkBlock) {
            worldIn_.destroyBlock(abovePos, true);

            if (worldIn_.getBlockState(abovePos.above()).getBlock() instanceof TotemStalkBlock)
                breakAbove(worldIn_,pos.above());
        }
    }*/

}
