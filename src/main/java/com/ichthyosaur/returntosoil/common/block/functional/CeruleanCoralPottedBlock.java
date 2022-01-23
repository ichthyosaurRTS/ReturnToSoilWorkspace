package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.CeruleanCoralTileEntity;
import com.ichthyosaur.returntosoil.common.tileentity.WardenPlantTileEntity;
import com.ichthyosaur.returntosoil.core.config.PlayerMaps;
import com.ichthyosaur.returntosoil.core.config.RTSConfig;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
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


//would like different shapes for states...
public class CeruleanCoralPottedBlock extends RTSPoweredPottedBlock{

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public CeruleanCoralPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FUEL_LEVEL,0).setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite()).setValue(FUEL_LEVEL,0);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FUEL_LEVEL).add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.CERULEAN_CORAL_TILE_ENTITY_TYPE.get().create();
    }

    protected static final VoxelShape SHAPE = Block.box(4.0D, 2.0D, 4.0D, 12.0D, 8.0D, 12.0D);
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {

        if (!world.isClientSide()) {
            RTSMain.LOGGER.info(player.getName().getString());

            PlayerMaps.playerCultIncrease(player.getName().getString(), 1);

            RTSMain.LOGGER.info(PlayerMaps.cultMapGetLvl(player.getName().getString()));
        }
        return super.use(state, world, pos, player, hand, p_225533_6_);

    }
}
