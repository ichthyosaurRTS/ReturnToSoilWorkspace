package com.ichthyosaur.returntosoil.common.item.misc;

import com.ichthyosaur.returntosoil.common.entity.VesselEntity;
import com.ichthyosaur.returntosoil.common.item.abst.RTSDescItem;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class VesselSacItem extends RTSDescItem {

    //rushed so no wonder if it crashes everything

    public VesselSacItem(Properties p_i48487_1_, TextFormatting text) {
        super(p_i48487_1_,text);
    }

    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        BlockRayTraceResult blockraytraceresult = getPlayerPOVHitResult(p_77659_1_, p_77659_2_, RayTraceContext.FluidMode.SOURCE_ONLY);
        BlockPos blockpos = blockraytraceresult.getBlockPos();
        VesselEntity entity = EntityTypesInit.VESSEL.get().create(p_77659_1_);
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);

        if (entity!=null && !p_77659_1_.isClientSide()) {

            if (!(p_77659_1_.getBlockState(blockpos).getBlock() instanceof AirBlock)) {

                entity.setOwner(p_77659_2_);
                entity.moveTo((double) blockpos.getX() + 0.5, (double) blockpos.getY() + 1, (double) blockpos.getZ() + 0.5, 0.0F, 0.0F);
                entity.finalizeSpawn((ServerWorld) p_77659_1_, p_77659_1_.getCurrentDifficultyAt(blockpos), SpawnReason.NATURAL, null, null);
                p_77659_1_.addFreshEntity(entity);

                itemstack.shrink(1);

                return ActionResult.success(itemstack);
            }
            else  return ActionResult.fail(itemstack);
        }

        else  return ActionResult.fail(itemstack);
    }

    /*@Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getLevel();
        if (!world.isClientSide()) {

            PlayerEntity player = context.getPlayer();
            BlockPos pos = context.getClickedPos();
            ItemStack itemstack = context.getItemInHand();

            VesselEntity entity = EntityTypesInit.VESSEL.get().create(world);
            entity.setOwner(player);
            entity.moveTo((double) pos.getX() + 0.5, (double) pos.getY() + 1, (double) pos.getZ() + 0.5, 0.0F, 0.0F);
            entity.finalizeSpawn((ServerWorld) world, world.getCurrentDifficultyAt(pos), SpawnReason.NATURAL, null, null);
            world.addFreshEntity(entity);

            itemstack.shrink(1);
        }

        return super.onItemUseFirst(stack, context);
    }*/

    public ActionResultType useOn(ItemUseContext p_195939_1_) {
        return ActionResultType.PASS;
    }

}
