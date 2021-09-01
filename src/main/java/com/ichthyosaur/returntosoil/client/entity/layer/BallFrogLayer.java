package com.ichthyosaur.returntosoil.client.entity.layer;

import com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel.BallFrogDeflatedModel;
import com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel.BallFrogInflatedModel;
import com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel.BallFrogModel;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class BallFrogLayer<T extends BallFrogEntity> extends LayerRenderer<T, BallFrogModel<T>> {

    private ResourceLocation TEXTURE;

    public BallFrogLayer(IEntityRenderer<T, BallFrogModel<T>> renderer) {
        super(renderer);
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {

        if (p_225628_4_.getInflated()){
            BallFrogInflatedModel<T> model = new BallFrogInflatedModel<T>();
            if (p_225628_4_.getColourInt()==0) {
                TEXTURE = new ResourceLocation("returntosoil:textures/entity/ball_frog/ball_frog_green_inflated.png");
            }
            else if (p_225628_4_.getColourInt()==1) {
                TEXTURE = new ResourceLocation("returntosoil:textures/entity/ball_frog/ball_frog_blue_inflated.png");
            }
            if (p_225628_4_.getColourInt()==2) {
                TEXTURE = new ResourceLocation("returntosoil:textures/entity/ball_frog/ball_frog_green_inflated.png");
            }
            coloredCutoutModelCopyLayerRender(this.getParentModel(), model, TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }

        else {
            BallFrogDeflatedModel<T> model = new BallFrogDeflatedModel<T>();
            if (p_225628_4_.getColourInt()==0) {
                TEXTURE = new ResourceLocation("returntosoil:textures/entity/ball_frog/ball_frog_green_deflated.png");
            }
            else if (p_225628_4_.getColourInt()==1) {
                TEXTURE = new ResourceLocation("returntosoil:textures/entity/ball_frog/ball_frog_blue_deflated.png");
            }
            else if (p_225628_4_.getColourInt()==2) {
                TEXTURE = new ResourceLocation("returntosoil:textures/entity/ball_frog/ball_frog_green_deflated.png");
            }
            coloredCutoutModelCopyLayerRender(this.getParentModel(), model, TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1, 1, 1);
        }
    }
}

