package com.ichthyosaur.returntosoil.client.entity.model.spell;

import com.ichthyosaur.returntosoil.common.entity.SpellEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MoonModel<T extends SpellEntity> extends EntityModel<T> {


    private final ModelRenderer bone;

    public MoonModel() {
        texWidth = 32;
        texHeight = 32;

        bone = new ModelRenderer(this);
        bone.setPos(0.0F, 0.0F, 0.0F);
        bone.texOffs(0, 0).addBox(0.0F, -8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(SpellEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //seems like this method is never triggered.... =(
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        //this.bone.yRot = (float) (this.bone.yRot+0.1);
        //this.bone.yRot = (float) 1.56;
        //this.bone.xRot = (float) (this.bone.xRot+0.1);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

}
