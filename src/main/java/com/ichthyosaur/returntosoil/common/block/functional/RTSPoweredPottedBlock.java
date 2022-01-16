package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.IHoldsSpirit;
import com.ichthyosaur.returntosoil.common.tileentity.WardenPlantTileEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public abstract class RTSPoweredPottedBlock extends RTSPottedBlock{

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;

    public RTSPoweredPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);

    }
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {

        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        IHoldsSpirit te = (IHoldsSpirit) world.getBlockEntity(pos);

        if (item == BlockItemInit.BOTTLED_SPIRIT_ITEM.get() && te.getSpiritLevel()<8000) {
            itemstack.shrink(1);
            ItemStack returnDrop = new ItemStack(Items.GLASS_BOTTLE, 1);
            player.inventory.add(returnDrop);
            te.spiritLevelAdd(500);

            //player.playSound(SoundEvents.TRIDENT_RETURN,1,1 );
            player.playSound(SoundEvents.SALMON_FLOP,1,1 );

            return ActionResultType.SUCCESS;
        }
        else return ActionResultType.PASS;
    }

    @Override
    public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
        if (p_220082_2_.getBlockEntity(p_220082_3_) == null) this.createTileEntity(p_220082_1_, p_220082_2_);
        super.onPlace(p_220082_1_, p_220082_2_, p_220082_3_, p_220082_4_, p_220082_5_);
    }
}
