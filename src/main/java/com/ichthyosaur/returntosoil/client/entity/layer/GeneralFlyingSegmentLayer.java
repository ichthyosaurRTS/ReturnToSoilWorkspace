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


    private static final ResourceLocation GAWAN_FULLBODY_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/gawan/gawan_fullbody.png");
    private final GawanNeckModel<T> gawanNeckModel = new GawanNeckModel<T>();
    private final GawanBody1Model<T> gawanBody1Model = new GawanBody1Model<T>();
    private final GawanBody2Model<T> gawanBody2Model = new GawanBody2Model<T>();
    private final GawanBody3Model<T> gawanBody3Model = new GawanBody3Model<T>();
    private final GawanBody4Model<T> gawanBody4Model = new GawanBody4Model<T>();
    private final GawanBody5Model<T> gawanBody5Model = new GawanBody5Model<T>();
    private final GawanTailModel<T> gawanTailModel = new GawanTailModel<T>();


    public GeneralFlyingSegmentLayer(IEntityRenderer<T, EmptyModel<T>> renderer) {
        super(renderer);
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {

        switch (p_225628_4_.getModelString()) {
            case "WarraRupeNeck":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeNeckModel, WARRA_RUPE_NECK_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "WarraRupeBody1":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeBody1Model, WARRA_RUPE_BODY1_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "WarraRupeBody2":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeBody2Model, WARRA_RUPE_BODY2_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "WarraRupeTail1":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeTail1Model, WARRA_RUPE_TAIL1_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "WarraRupeTail2":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), warraRupeTail2Model, WARRA_RUPE_TAIL2_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;

            case "GawanNeck":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), gawanNeckModel, GAWAN_FULLBODY_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                //RTSMain.LOGGER.info("Adding neck!");
                break;
            case "GawanBody1":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), gawanBody1Model, GAWAN_FULLBODY_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "GawanBody2":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), gawanBody2Model, GAWAN_FULLBODY_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "GawanBody3":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), gawanBody3Model, GAWAN_FULLBODY_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "GawanBody4":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), gawanBody4Model, GAWAN_FULLBODY_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "GawanBody5":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), gawanBody5Model, GAWAN_FULLBODY_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
            case "GawanTail":
                coloredCutoutModelCopyLayerRender(this.getParentModel(), gawanTailModel, GAWAN_FULLBODY_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
                break;
        }
    }

}

