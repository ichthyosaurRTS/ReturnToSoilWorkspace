package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class VesselSacBlock extends RTSCropsBlock {

    public VesselSacBlock(Properties p_i48437_1_) {
        super(p_i48437_1_);
    }

    protected static final VoxelShape SHAPE = Block.box(2.0D, 4.0D, 2.0D, 13.0D, 14.0D, 13.0D);

    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @ParametersAreNonnullByDefault
    public void spawnAfterBreak(BlockState p_220062_1_, ServerWorld p_220062_2_, BlockPos p_220062_3_, ItemStack p_220062_4_) {
        super.spawnAfterBreak(p_220062_1_,p_220062_2_,p_220062_3_,p_220062_4_);

        VesselVineBlock.removeAbove(p_220062_2_,p_220062_3_);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {
        if (world.getBlockState(pos.above()).getBlock() instanceof VesselVineBlock && !world.isClientSide()) VesselVineBlock.removeAbove((ServerWorld) world, pos);
        return super.use(state, world, pos, player, hand, p_225533_6_);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return BlockItemInit.VESSEL_SEED.get();
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
        return BlockItemInit.VESSEL_SAC_ITEM.get();
    }
    @Override
    protected Item getSeed(){
        return BlockItemInit.VESSEL_SEED.get();
    }


    @Override
    protected boolean mayPlaceOn(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos p_196260_3_) {
        if (p_196260_2_.getBlockState(p_196260_3_.above()).getBlock() instanceof VesselVineBlock) return true;
        else return false;
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) { } //nothing bc its already got a mob in there
}
