package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.WardenPlantTileEntity;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class WardenPlantPottedBlock extends RTSPottedBlock{

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;

    public WardenPlantPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FUEL_LEVEL,0));
    }


    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FUEL_LEVEL);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.WARDEN_PLANT_TILE_ENTITY_TYPE.get().create();
    }

    @Override
    public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
        if (p_220082_2_.getBlockEntity(p_220082_3_) == null) this.createTileEntity(p_220082_1_, p_220082_2_);
        super.onPlace(p_220082_1_, p_220082_2_, p_220082_3_, p_220082_4_, p_220082_5_);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {

        ((WardenPlantTileEntity)world.getBlockEntity(pos)).spiritLevelAdd(500);
        if (state.getValue(FUEL_LEVEL) == 0) world.setBlock(pos, state.setValue(FUEL_LEVEL,2), 2);
        else if (state.getValue(FUEL_LEVEL) == 1) world.setBlock(pos, state.setValue(FUEL_LEVEL,2), 2);
        else if (state.getValue(FUEL_LEVEL) == 2) world.setBlock(pos, state.setValue(FUEL_LEVEL,1), 2);

        return super.use(state, world, pos, player, p_225533_5_, p_225533_6_);
    }
}
