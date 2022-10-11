package com.ichthyosaur.returntosoil.common.item.misc;

import com.ichthyosaur.returntosoil.common.item.abst.RTSBlockNamedItem;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class LilypadLanternSeed extends RTSBlockNamedItem {
    public LilypadLanternSeed(Block p_i50041_1_, Properties p_i50041_2_) {
        super(p_i50041_1_, p_i50041_2_, TextFormatting.GREEN);
    }
    public ActionResultType useOn(ItemUseContext p_195939_1_) {
        return ActionResultType.PASS;
    }

    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        BlockRayTraceResult blockraytraceresult = getPlayerPOVHitResult(p_77659_1_, p_77659_2_, RayTraceContext.FluidMode.SOURCE_ONLY);
        BlockRayTraceResult blockraytraceresult1 = blockraytraceresult.withPosition(blockraytraceresult.getBlockPos().above());
        ActionResultType actionresulttype = super.useOn(new ItemUseContext(p_77659_2_, p_77659_3_, blockraytraceresult1));
        return new ActionResult<>(actionresulttype, p_77659_2_.getItemInHand(p_77659_3_));
    }

}
