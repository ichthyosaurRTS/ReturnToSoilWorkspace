package com.ichthyosaur.returntosoil.client.entity.GeneralFlyingSegmentLayers;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepButtModelold;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;

public class GeneralFlyingSegmentLayer<T extends GeneralFlyingSegmentEntity> extends LayerRenderer<T, EmptyModel<T>> {

    private static final ResourceLocation SHEEP_BUTT_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_butt.png");
    private final JudasSheepButtModel<T> sheepButtModel = new JudasSheepButtModel<T>();

    public GeneralFlyingSegmentLayer(IEntityRenderer<T, EmptyModel<T>> renderer) {
        super(renderer);
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {

        if (p_225628_4_.getModelString().equals("JudasSheepButt")) {
            renderColoredCutoutModel(sheepButtModel, SHEEP_BUTT_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, 1.0F, 1.0F, 1.0F);

            //coloredCutoutModelCopyLayerRender(this.getParentModel(), sheepButtModel, SHEEP_BUTT_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }

    }

}

