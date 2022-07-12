package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.CannonMolluscEntity;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CannonMolluscModel<T extends CannonMolluscEntity> extends EntityModel<T> {

    private final ModelRenderer bone;

    public CannonMolluscModel() {
        texWidth = 64;
        texHeight = 64;

        bone = new ModelRenderer(this);
        bone.setPos(0.0F, 21.5F, -4.5F);
        setRotationAngle(bone, -1.5708F, 0.0F, 3.1416F);
        bone.texOffs(0, 0).addBox(-7.0F, -13.5F, -0.5F, 14.0F, 17.0F, 17.0F, 0.0F, false);
        bone.texOffs(8, 8).addBox(-1.0F, 2.0F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        bone.texOffs(0, 6).addBox(-1.0F, -7.0F, -2.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        bone.texOffs(0, 0).addBox(-1.5F, -2.0F, -2.5F, 3.0F, 4.0F, 2.0F, 0.0F, false);
        bone.texOffs(10, 0).addBox(-0.5F, -10.0F, -2.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        bone.texOffs(8, 4).addBox(-1.0F, 4.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        bone.texOffs(11, 12).addBox(-1.5F, 4.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(7, 12).addBox(0.5F, 4.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
    }
    @Override
    public void setupAnim(CannonMolluscEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        //matrixStack.scale((float)1.5,(float)1.5,(float)1.5);
        //matrixStack.translate(0,-0.5,0);
        bone.render(matrixStack, buffer, packedLight, packedOverlay); //this will render all the children too
    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
