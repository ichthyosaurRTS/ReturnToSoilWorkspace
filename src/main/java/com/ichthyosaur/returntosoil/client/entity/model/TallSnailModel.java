package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.TallSnailEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class TallSnailModel<T extends TallSnailEntity> extends EntityModel<TallSnailEntity> {

    private final ModelRenderer all;
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer shell;


	public TallSnailModel() {
            texWidth = 64;
            texHeight = 64;

            all = new ModelRenderer(this);
            all.setPos(0.0F, 24.0F, 0.0F);


            body = new ModelRenderer(this);
            body.setPos(0.0F, 0.0F, 0.0F);
            all.addChild(body);
            body.texOffs(11, 5).addBox(-1.0F, -1.9F, -3.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
            body.texOffs(13, 0).addBox(-1.0F, -1.9F, -5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

            head = new ModelRenderer(this);
            head.setPos(0.0F, -1.0F, -3.0F);
            body.addChild(head);
            head.texOffs(0, 0).addBox(-1.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

            shell = new ModelRenderer(this);
            shell.setPos(0.0F, 0.0F, 0.0F);
            all.addChild(shell);
            shell.texOffs(0, 0).addBox(-1.5F, -7.0F, -3.0F, 3.0F, 7.0F, 7.0F, 0.0F, false);
	}


    @Override
    public void setupAnim(TallSnailEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.all.zRot = (float) 0.5* -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount*10;
    }


    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        all.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

}
