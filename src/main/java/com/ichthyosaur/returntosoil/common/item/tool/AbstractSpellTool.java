package com.ichthyosaur.returntosoil.common.item.tool;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.nbt.CompoundNBT;

import java.util.Set;

public abstract class AbstractSpellTool extends ToolItem {
    public AbstractSpellTool(float p_i48512_1_, float p_i48512_2_, IItemTier p_i48512_3_, Set<Block> p_i48512_4_, Properties p_i48512_5_) {
        super(p_i48512_1_, p_i48512_2_, p_i48512_3_, p_i48512_4_, p_i48512_5_);
    }

    public float getSpell (ItemStack item){
        CompoundNBT compoundnbt = item.getTag();
        if ( compoundnbt != null && compoundnbt.getFloat("Spell")>(-10)) {
        return compoundnbt.getFloat("Spell");}
        else return -10;
    }
    public void setSpell (ItemStack item, float num){
        CompoundNBT compoundnbt = item.getOrCreateTag();
        compoundnbt.putFloat("Spell", num);
    }

}
