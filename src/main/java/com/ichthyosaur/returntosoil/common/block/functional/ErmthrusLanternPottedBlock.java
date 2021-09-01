package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.ErmthrusLanternTileEntity;
import com.ichthyosaur.returntosoil.common.tileentity.WardenPlantTileEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.lwjgl.system.CallbackI;

import java.util.Random;

public class ErmthrusLanternPottedBlock extends RTSPottedBlock{

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;

    public ErmthrusLanternPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FUEL_LEVEL,0).setValue(FACING, Direction.NORTH));
    }

    @Override
    public ActionResultType use(BlockState p_225533_1_, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        ErmthrusLanternTileEntity te = (ErmthrusLanternTileEntity) world.getBlockEntity(pos);

        if (item == BlockItemInit.BOTTLED_SPIRIT_ITEM.get() && te.getSpiritLevel()<8000) {
            itemstack.shrink(1);
            ItemStack returnDrop = new ItemStack(Items.GLASS_BOTTLE, 1);
            player.inventory.add(returnDrop);
            te.spiritLevelAdd(5000);//normall 500

            player.playSound(SoundEvents.SALMON_FLOP, 1, 1);

            return ActionResultType.SUCCESS;

        }
        return ActionResultType.PASS;
    }


    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite()).setValue(FUEL_LEVEL,0);
    }


    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FUEL_LEVEL, FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.ERMTHRUS_LANTERN_TILE_ENTITY_TYPE.get().create();
    }

    @Override
    public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
        if (p_220082_2_.getBlockEntity(p_220082_3_) == null) this.createTileEntity(p_220082_1_, p_220082_2_);
        super.onPlace(p_220082_1_, p_220082_2_, p_220082_3_, p_220082_4_, p_220082_5_);
    }
}
