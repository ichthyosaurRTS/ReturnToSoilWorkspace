package com.ichthyosaur.returntosoil.client.screen;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.container.RefinementBaAdvContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RefinementBaAdvScreen extends ContainerScreen<RefinementBaAdvContainer> {

    private static final ResourceLocation REFINEMENT_BA_ADV_GUI = new ResourceLocation(RTSMain.MOD_ID,"textures/gui/refinement_ba_adv.png");

    public RefinementBaAdvScreen(RefinementBaAdvContainer p_i51105_1_, PlayerInventory p_i51105_2_, ITextComponent p_i51105_3_) {
        super(p_i51105_1_, p_i51105_2_, p_i51105_3_);
        this.leftPos = 0;
        this.topPos = 0;
        this.width = 175;
        this.height = 201;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(MatrixStack matrixStack, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        assert this.minecraft != null;
        this.minecraft.textureManager.bind(REFINEMENT_BA_ADV_GUI);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }

    //sus
    public void render(MatrixStack mstack, int p_230430_2_, int p_230430_3_, float p_230430_4_){
        this.renderBackground(mstack);
        super.render(mstack,  p_230430_2_, p_230430_3_,  p_230430_4_);
        this.renderTooltip(mstack, p_230430_2_, p_230430_3_);
    }

    //think this is the wrong one
    @Override
    protected void renderLabels(MatrixStack matrixStack, int p_230451_2_, int p_230451_3_) {
        this.font.draw(matrixStack, this.inventory.getDisplayName(), (float) this.inventoryLabelX,
                (float) this.inventoryLabelY, 4210752);
        this.font.draw(matrixStack, "Refinement", (float) this.titleLabelX,
                (float) this.titleLabelY, 4210752);
        /*(this.font.draw(matrixStack, "Refinement", (float) this.titleLabelX,
                (float) this.titleLabelY + 10, 4210752);
        this.font.draw(matrixStack, "Barrel", (float) this.titleLabelX,
                (float) this.titleLabelY+20, 4210752);*/
    }
}
