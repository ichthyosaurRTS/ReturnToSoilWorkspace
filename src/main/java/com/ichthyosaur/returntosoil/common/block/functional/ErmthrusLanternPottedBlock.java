package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

public class ErmthrusLanternPottedBlock extends RTSPottedBlock{
    public ErmthrusLanternPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FUEL_LEVEL,0));
    }

    @Override
    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        p_225533_2_.setBlock(p_225533_3_,p_225533_1_.setValue(FUEL_LEVEL, 1),2);
        return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);

    }

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FUEL_LEVEL);
    }
}
