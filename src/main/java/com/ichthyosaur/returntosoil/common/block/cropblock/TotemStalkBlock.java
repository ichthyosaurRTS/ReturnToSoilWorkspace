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

//an ancient plant similar to bamboo. Sometimes mysterious things grow on it.
public class TotemStalkBlock extends BushBlock {

    public static final IntegerProperty AGE = ReturnToSoil.AGE_7;
    public static final IntegerProperty ROTATION = ReturnToSoil.ROTATION_4;
    public static final BooleanProperty INFESTED = ReturnToSoil.INFESTED;


    public TotemStalkBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    protected static final VoxelShape SHAPE = Block.box(4.0D, 1.0D, 4.0D, 8.0D, 14.0D, 8.0D);
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        int rot = state.getValue(ROTATION);
        if (rot == 2) return Block.box(4.0D, 0.0D, 4.0D, 10.0D, 16.0D, 10.0D);
        if (rot == 1) return Block.box(4.0D, 0.0D, 8.0D, 10.0D, 16.0D, 14.0D);
        if (rot == 3) return Block.box(8.0D, 0.0D, 8.0D, 14.0D, 16.0D, 14.0D);
        else return Block.box(8.0D, 0.0D, 4.0D, 14.0D, 16.0D, 10.0D);
    }


    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(AGE, ROTATION, INFESTED);
    }

    // just tick all the time for now
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 3;
    }

    @ParametersAreNonnullByDefault
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (state.getValue(INFESTED)) {}

        if (state.getValue(AGE)==0 && !(canGrowUp(worldIn, pos))) {
            if (rollChance.roll(2)) worldIn.setBlock(pos, state.setValue(AGE, 6), 2);
            else worldIn.setBlock(pos, this.getNextState(state, false), 2);
        }
        else if (state.getValue(AGE)==0) worldIn.setBlock(pos, this.getNextState(state, false), 2);
        else if (state.getValue(AGE)==1) {
            worldIn.setBlock(pos.above(), state.setValue(AGE, 0), 2);
            worldIn.setBlock(pos, state.setValue(AGE, 2), 2);
        }
        else if (state.getValue(AGE)==2) {
            if (canGrowUp(worldIn, pos)) worldIn.setBlock(pos.above(), this.getNextState(state, true), 2);
            else if (grownTotemSurrounds(worldIn, pos) && rollChance.roll(10)) {
                worldIn.setBlock(pos, state.setValue(AGE, 3), 2);
            }
            else if (rollChance.roll(8)) worldIn.setBlock(pos, state.setValue(AGE, 5), 2);
            else worldIn.setBlock(pos, state.setValue(AGE, 4), 2);}
    }

    private boolean grownTotemSurrounds(ServerWorld worldIn, BlockPos pos){
        if (worldIn.getBlockState(pos.above()).getBlock() instanceof TotemStalkBlock &&
                worldIn.getBlockState(pos.below()).getBlock() instanceof TotemStalkBlock)
            return worldIn.getBlockState(pos.above()).getValue(AGE) > 3 && worldIn.getBlockState(pos.below()).getValue(AGE) == 4;
        return false;
    }

    private boolean canGrowUp(ServerWorld worldIn, BlockPos pos){
        if (worldIn.getBlockState(pos.above()).getBlock() instanceof AirBlock && !atMaxHeight(worldIn, pos)) return true;
        return false;
    }

    private boolean atMaxHeight(ServerWorld worldIn, BlockPos pos) {
        for (int i=0;i<10;i++) {
            if (!(worldIn.getBlockState(pos.below(i)).getBlock() instanceof TotemStalkBlock)) return false;
        }
        return true;
    }

    //call only for age 0 and 1
    public BlockState getNextState(BlockState state, boolean ageZero) {
        if (ageZero) return state.setValue(AGE, 0).setValue(INFESTED,false);

        boolean infested = state.getValue(INFESTED);
        int newAge = state.getValue(AGE)+1;
        if (newAge==4&& rollChance.roll(40)) infested = true;
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
        if (below instanceof AirBlock) return false;
        else return (below.is(Blocks.GRASS_BLOCK)||below.is(Blocks.DIRT)||
                below instanceof  TotemStalkBlock && p_196260_2_.getBlockState(p_196260_3_.below()).getValue(AGE)>1);
    }

    public boolean propagatesSkylightDown(BlockState p_200123_1_, IBlockReader p_200123_2_, BlockPos p_200123_3_) {
        return true;
    }

}
