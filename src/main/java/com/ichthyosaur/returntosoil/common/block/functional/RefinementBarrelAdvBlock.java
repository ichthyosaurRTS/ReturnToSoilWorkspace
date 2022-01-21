package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.common.tileentity.RefinementBaAdvTileEntity;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class RefinementBarrelAdvBlock extends Block {

    public RefinementBarrelAdvBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }
    public RefinementBaAdvTileEntity te;

    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean propagatesSkylightDown(BlockState p_200123_1_, IBlockReader p_200123_2_, BlockPos p_200123_3_) {
        return p_200123_1_.getFluidState().isEmpty();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.REFINEMENT_BA_ADV_TILE_ENTITY_TYPE.get().create();
    }

    //pretty sure the block gets replaced with a new one like this...
    @ParametersAreNonnullByDefault
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {

        if (!world.isClientSide()) {
            TileEntity te = world.getBlockEntity(pos);
            if (te instanceof RefinementBaAdvTileEntity){
                ServerPlayerEntity p = (ServerPlayerEntity) player;
                NetworkHooks.openGui(p, (RefinementBaAdvTileEntity) te, pos);
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.SUCCESS;
    }

    public ActionResultType use(World p_227031_1_, PlayerEntity p_227031_2_, Hand p_227031_3_, BlockRayTraceResult p_227031_4_) {
        return this.getBlock().use(p_227031_1_.getBlockState(p_227031_4_.getBlockPos()), p_227031_1_, p_227031_4_.getBlockPos(), p_227031_2_, p_227031_3_, p_227031_4_);
    }


    @Override
    public void animateTick(BlockState state, World world, BlockPos player, Random p_180655_4_) {
    }


}


