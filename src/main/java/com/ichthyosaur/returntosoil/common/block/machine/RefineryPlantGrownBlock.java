package com.ichthyosaur.returntosoil.common.block.machine;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class RefineryPlantGrownBlock extends Block {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public RefineryPlantGrownBlock() {
        super(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD));
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(LIT);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get().create();
    }

    //pretty sure the block gets replaced with a new one like this...
    @ParametersAreNonnullByDefault
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (state.getValue(LIT)) {
            world.setBlock(pos, this.defaultBlockState().setValue(LIT, false), 2);
        }
        world.setBlock(pos, this.defaultBlockState().setValue(LIT, true), 2);

        //temporary for testing
        ItemStack randomDrops = new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get(),1);
        popResource(world, pos, randomDrops);
            return ActionResultType.SUCCESS;
    }



    @Override
    public void animateTick(BlockState state, World world, BlockPos player, Random p_180655_4_) {
        if (state.getValue(LIT)) world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                player.getX()+0.5, player.getY()+0.8, player.getZ()+0.5, 0.0D, 0.03D, 0.0D);
    }

    protected static final VoxelShape SHAPE = Block.box(2.0D, 6.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean propagatesSkylightDown(BlockState p_200123_1_, IBlockReader p_200123_2_, BlockPos p_200123_3_) {
        return p_200123_1_.getFluidState().isEmpty();
    }

}
