package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class DroughtCactusBlock extends RTSCropsBlock{

    public DroughtCactusBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {
        if (state.getValue(AGE)!=7||state.getValue(INFESTED)) {
            return ActionResultType.PASS;
        }
        else {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (item == Items.FLOWER_POT) {
                itemstack.shrink(1);
                ItemStack definiteDrops = new ItemStack(BlockItemInit.DROUGHT_CACTUS_POTTED_ITEM.get(), 1);
                popResource(world, pos, definiteDrops);
                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);
                return ActionResultType.SUCCESS;
            }
            else  return ActionResultType.PASS;
        }
    }
}
