package com.ichthyosaur.returntosoil.common.item.itemclass;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class RTSBlockNamedItem extends BlockNamedItem {

    TextFormatting textColour = TextFormatting.GRAY;

    public RTSBlockNamedItem(Block p_i50041_1_, Properties p_i50041_2_, TextFormatting colour ) {
        super(p_i50041_1_, p_i50041_2_);
        this.textColour = colour;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_) {
        p_77624_3_.add(this.getDisplayName().withStyle(this.textColour));
    }
    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent getDisplayName() {
        return new TranslationTextComponent(this.getDescriptionId() + ".desc");
    }

}
