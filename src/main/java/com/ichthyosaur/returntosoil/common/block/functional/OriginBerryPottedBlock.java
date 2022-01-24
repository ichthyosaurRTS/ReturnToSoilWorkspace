package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.core.config.RTSConfigMisc;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class OriginBerryPottedBlock extends RTSPottedBlock{

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public OriginBerryPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {

        if (world.isClientSide()){
            StringTextComponent text = new StringTextComponent("Cultivation Level: "+ RTSConfigMisc.cListGetLvl(player.getName().getString())) ;
            player.displayClientMessage( text, true);
        }
        return super.use(state, world, pos, player, hand, p_225533_6_);

    }
}
