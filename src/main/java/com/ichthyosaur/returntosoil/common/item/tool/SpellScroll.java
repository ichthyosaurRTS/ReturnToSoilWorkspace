package com.ichthyosaur.returntosoil.common.item.tool;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Set;

public class SpellScroll extends AbstractSpellTool{
    public SpellScroll(float p_i48512_1_, float p_i48512_2_, IItemTier p_i48512_3_, Set<Block> p_i48512_4_, Properties p_i48512_5_) {
        super(p_i48512_1_, p_i48512_2_, p_i48512_3_, p_i48512_4_, p_i48512_5_);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        ItemStack scroll = player.getItemInHand(hand);
        float spell = this.getSpell(scroll);
        if (spell > 3) player.setDeltaMovement(player.getDeltaMovement().add(0,5,0));
        else this.setSpell(scroll,spell+1);

        return ActionResult.success(player.getItemInHand(hand));
    }
}
