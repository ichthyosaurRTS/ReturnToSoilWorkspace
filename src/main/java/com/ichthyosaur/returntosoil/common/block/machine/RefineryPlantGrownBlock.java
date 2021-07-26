package com.ichthyosaur.returntosoil.common.block.machine;

import com.ichthyosaur.returntosoil.common.container.RefineryPlantContainer;
import com.ichthyosaur.returntosoil.common.tileentity.RefineryPlantTileEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
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
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class RefineryPlantGrownBlock extends Block {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public RefineryPlantTileEntity te;

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
        te = TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get().create();
        return TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get().create();
    }

    @Override
    public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
        super.onPlace(p_220082_1_, p_220082_2_, p_220082_3_, p_220082_4_, p_220082_5_);
    }

    //pretty sure the block gets replaced with a new one like this...
    @ParametersAreNonnullByDefault
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        /*if (state.getValue(LIT)) {
            world.setBlock(pos, this.defaultBlockState().setValue(LIT, false), 2);
        }
        world.setBlock(pos, this.defaultBlockState().setValue(LIT, true), 2);

        //temporary for testing
        ItemStack randomDrops = new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get(),1);
        popResource(world, pos, randomDrops);
            return ActionResultType.SUCCESS;*/

        if (world.isClientSide()) {
            TileEntity te = world.getBlockEntity(pos);
            if (te instanceof RefineryPlantTileEntity){
                INamedContainerProvider inamedcontainerprovider = new RefineryPlantTileEntity(TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get());
                NetworkHooks.openGui((ServerPlayerEntity) player, this.te);
            }

            /*INamedContainerProvider inamedcontainerprovider = new RefineryPlantTileEntity(TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get());
            if (inamedcontainerprovider != null) {
                player.openMenu(inamedcontainerprovider);
            }*/

            return super.use(state,world,pos,player,p_225533_5_,p_225533_6_);


        }
        return ActionResultType.PASS;

    }

    public ActionResultType use(World p_227031_1_, PlayerEntity p_227031_2_, Hand p_227031_3_, BlockRayTraceResult p_227031_4_) {
        return this.getBlock().use(p_227031_1_.getBlockState(p_227031_4_.getBlockPos()), p_227031_1_, p_227031_4_.getBlockPos(), p_227031_2_, p_227031_3_, p_227031_4_);
    }


    @Override
    public void animateTick(BlockState state, World world, BlockPos player, Random p_180655_4_) {
        if (state.getValue(LIT)&&world.isClientSide()) world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
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
