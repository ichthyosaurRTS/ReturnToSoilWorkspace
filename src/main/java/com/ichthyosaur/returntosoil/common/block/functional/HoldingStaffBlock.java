package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.common.tileentity.HoldingStaffTileEntity;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.ParametersAreNonnullByDefault;

public class HoldingStaffBlock extends Block {
    public static final Logger LOGGER = LogManager.getLogger();

    public HoldingStaffBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.HOLDING_STAFF_TILE_ENTITY_TYPE.get().create();
    }

    @ParametersAreNonnullByDefault
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (world.isClientSide()) {
            return ActionResultType.PASS;
        }
        else {
            if (world.getBlockEntity(pos) instanceof HoldingStaffTileEntity) {

                HoldingStaffTileEntity HSte = (HoldingStaffTileEntity) world.getBlockEntity(pos);

                if  (HSte.hasItem() && item != Items.AIR) {
                    LOGGER.info("staff is holding: "+HSte.holdingItem());
                }

                else  if (HSte.hasItem()) { }

                else  if (item == Items.AIR) {
                    //HSte.dropItem();
                }

                else  {
                    LOGGER.info("trying to give staff"+ item);

                    HSte.giveItem(item);
                    itemstack.shrink(1);
                }

            }
            return ActionResultType.SUCCESS;
        }
    }


    public ActionResultType use(World p_227031_1_, PlayerEntity p_227031_2_, Hand p_227031_3_, BlockRayTraceResult p_227031_4_) {
        return this.getBlock().use(p_227031_1_.getBlockState(p_227031_4_.getBlockPos()), p_227031_1_, p_227031_4_.getBlockPos(), p_227031_2_, p_227031_3_, p_227031_4_);
    }

    @Override
    public void playerDestroy(World p_180657_1_, PlayerEntity p_180657_2_, BlockPos p_180657_3_, BlockState p_180657_4_, TileEntity p_180657_5_, ItemStack p_180657_6_) {
            if (p_180657_5_ instanceof HoldingStaffTileEntity) {

                HoldingStaffTileEntity HSte = (HoldingStaffTileEntity) p_180657_5_;
                if  (HSte.hasItem()) HSte.dropItem();
            }

            super.playerDestroy(p_180657_1_, p_180657_2_, p_180657_3_, p_180657_4_, p_180657_5_, p_180657_6_);
    }

    protected static final VoxelShape SHAPE = Block.box(4.0D, 2.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
