package com.ichthyosaur.returntosoil.client.entity.layer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.segmentmodel.*;
import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class GeneralFlyingSegmentLayer<T extends GeneralFlyingSegmentEntity> extends LayerRenderer<T, EmptyModel<T>> {

    private static final ResourceLocation WARRA_RUPE_NECK_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/warra_rupe/warra_rupe_neck.png");
    private final WarraRupeNeckModel<T> warraRupeNeckModel = new WarraRupeNeckModel<T>();

    private static final ResourceLocation WARRA_RUPE_BODY1_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/warra_rupe/warra_rupe_body1.png");
    private final WarraRupeBody1Model<T> warraRupeBody1Model = new WarraRupeBody1Model<T>();

    private static final ResourceLocation WARRA_RUPE_BODY2_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/warra_rupe/warra_rupe_body2.png");
    private final WarraRupeBody2Model<T> warraRupeBody2Model = new WarraRupeBody2Model<T>();

    private static final ResourceLocation WARRA_RUPE_TAIL1_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/warra_rupe/warra_rupe_tail1.png");
    private final WarraRupeTail1Model<T> warraRupeTail1Model = new WarraRupeTail1Model<T>();

    private static final ResourceLocation WARRA_RUPE_TAIL2_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/warra_rupe/warra_rupe_tail2.png");
    private final WarraRupeTail2Model<T> warraRupeTail2Model = new WarraRupeTail2Model<T>();


    public GeneralFlyingSegmentLayer(IEntityRenderer<T, EmptyModel<T>> renderer) {
        super(renderer);
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {

        if (p_225628_4_.getModelString().equals("WarraRupeNeck")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeNeckModel, WARRA_RUPE_NECK_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("WarraRupeBody1")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeBody1Model, WARRA_RUPE_BODY1_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("WarraRupeBody2")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeBody2Model, WARRA_RUPE_BODY2_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("WarraRupeTail1")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeTail1Model, WARRA_RUPE_TAIL1_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("WarraRupeTail2")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeTail2Model, WARRA_RUPE_TAIL2_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }

    }

}

