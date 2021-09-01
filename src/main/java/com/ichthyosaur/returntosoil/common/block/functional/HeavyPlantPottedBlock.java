package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.common.block.cropblock.RTSCropsBlock;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class HeavyPlantPottedBlock extends RTSPottedBlock {

    public HeavyPlantPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        if (world.getBlockState(pos.below()).getBlock() instanceof AirBlock) {
            int nextBelow = findNextBelow(world, pos, 1000);
            if (nextBelow != 0) {
                world.setBlock(pos.below(1000-nextBelow),world.getBlockState(pos),2);
                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
            }
            else world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
        }

        else if (world.getBlockState(pos.below()).getBlock().getHarvestLevel(state) < 3) {
            world.destroyBlock(pos.below(),false);
            world.setBlock(pos.below(),world.getBlockState(pos),2);
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
        }

    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }
    public static final DirectionProperty FACING = BlockStateProperties.FACING;


    private int findNextBelow(ServerWorld world, BlockPos pos, int count) {
        if (count == 0) return count;
        else {
            Block below = world.getBlockState(pos.below()).getBlock();
            if (below instanceof AirBlock) return findNextBelow(world, pos.below(), count-1);
            else return count;
        }
    }
}
