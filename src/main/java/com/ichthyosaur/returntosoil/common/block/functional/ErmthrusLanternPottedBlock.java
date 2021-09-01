package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

//instead of increasing the grow rate, just lights up a large area for now
public class ErmthrusLanternPottedBlock extends RTSPottedBlock{

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;

    public ErmthrusLanternPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FUEL_LEVEL,0).setValue(FACING, Direction.NORTH));
    }

    @Override
    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        switchMode(p_225533_1_, p_225533_2_, p_225533_3_);
        return ActionResultType.SUCCESS;
        //return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);

    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite()).setValue(FUEL_LEVEL,0);
    }

    private static void switchMode(BlockState state, World world, BlockPos pos){
        int current = state.getValue(FUEL_LEVEL);
        if (current == 0) world.setBlock(pos, state.setValue(FUEL_LEVEL, 1),2);
        else world.setBlock(pos, state.setValue(FUEL_LEVEL, 0),2);
    }


    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FUEL_LEVEL, FACING);
    }
}
