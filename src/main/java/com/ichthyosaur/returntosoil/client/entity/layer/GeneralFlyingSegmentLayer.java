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

    private static final ResourceLocation SHEEP_BUTT_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_butt.png");
    private final JudasSheepButtModel<T> sheepButtModel = new JudasSheepButtModel<T>();

    private static final ResourceLocation SHEEP_RIBS_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_ribs.png");
    private final JudasSheepRibsModel<T> sheepRibsModel = new JudasSheepRibsModel<T>();

    private static final ResourceLocation EEL_NECK_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/joyful_eel/joyful_eel_neck.png");
    private final JoyfulEelNeckModel<T> joyfulEelNeckModel = new JoyfulEelNeckModel<T>();

    private static final ResourceLocation EEL_BODY1_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/joyful_eel/joyful_eel_body1.png");
    private final JoyfulEelBody1Model<T> joyfulEelBody1Model = new JoyfulEelBody1Model<T>();

    private static final ResourceLocation EEL_BODY2_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/joyful_eel/joyful_eel_body2.png");
    private final JoyfulEelBody2Model<T> joyfulEelBody2Model = new JoyfulEelBody2Model<T>();

    private static final ResourceLocation EEL_TAIL1_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/joyful_eel/joyful_eel_tail1.png");
    private final JoyfulEelTail1Model<T> joyfulEelTail1Model = new JoyfulEelTail1Model<T>();

    private static final ResourceLocation EEL_TAIL2_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/joyful_eel/joyful_eel_tail2.png");
    private final JoyfulEelTail2Model<T> joyfulEelTail2Model = new JoyfulEelTail2Model<T>();

    private static final ResourceLocation EEL_HEAD_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/joyful_eel/joyful_eel_head.png");
    private final JoyfulEelHead2Model<T> joyfulEelHead2Model = new JoyfulEelHead2Model<T>();


    public GeneralFlyingSegmentLayer(IEntityRenderer<T, EmptyModel<T>> renderer) {
        super(renderer);
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {

        if (p_225628_4_.getModelString().equals("JudasSheepButt")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), sheepButtModel, SHEEP_BUTT_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("JudasSheepRibs")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), sheepRibsModel, SHEEP_RIBS_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }

        if (p_225628_4_.getModelString().equals("JoyfulEelNeck")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), joyfulEelNeckModel, EEL_NECK_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("JoyfulEelBody1")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), joyfulEelBody1Model, EEL_BODY1_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("JoyfulEelBody2")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), joyfulEelBody2Model, EEL_BODY2_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("JoyfulEelTail1")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), joyfulEelTail1Model, EEL_TAIL1_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("JoyfulEelTail2")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), joyfulEelTail2Model, EEL_TAIL2_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
        if (p_225628_4_.getModelString().equals("JoyfulEelHead")) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), joyfulEelHead2Model, EEL_HEAD_TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }

    }

}

