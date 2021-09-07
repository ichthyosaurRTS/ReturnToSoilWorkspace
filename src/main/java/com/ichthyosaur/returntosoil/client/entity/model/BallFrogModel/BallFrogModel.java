package com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BallFrogModel<T extends BallFrogEntity> extends EntityModel<T> {

    public final ModelRenderer EmptyAll;

    public BallFrogModel() {
        texWidth = 16;
        texHeight = 16;

        EmptyAll = new ModelRenderer(this);
        EmptyAll.setPos(0.0F, 16.0F, 0.0F);
    }


    @Override
    public void setupAnim(BallFrogEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        

        if (!entity.getInflated()) { //need passive floaty movement here
            this.EmptyAll.xRot = headPitch * ((float)Math.PI / 180F);
            this.EmptyAll.yRot = netHeadYaw * ((float)Math.PI / 180F);
        }

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        EmptyAll.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}
