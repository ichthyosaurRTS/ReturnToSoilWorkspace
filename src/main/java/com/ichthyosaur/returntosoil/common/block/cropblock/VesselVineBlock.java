package com.ichthyosaur.returntosoil.common.block.cropblock;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;

public class VesselVineBlock extends RTSCropsBlock {

    public VesselVineBlock(Properties p_i48437_1_) {
        super(p_i48437_1_);
    }

    protected static final VoxelShape SHAPE = Block.box(4.0D, 4.0D, 4.0D, 13.0D, 14.0D, 13.0D);

    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @ParametersAreNonnullByDefault
    public void spawnAfterBreak(BlockState p_220062_1_, ServerWorld p_220062_2_, BlockPos p_220062_3_, ItemStack p_220062_4_) {
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos p_196260_3_) {
        BlockState above = p_196260_2_.getBlockState(p_196260_3_.above());
        if (above.getBlock() instanceof LeavesBlock) return true;
        else if (above.getBlock() instanceof VesselVineBlock)
            return above.getValue(AGE) == 7;
        else return false;
    }
}
