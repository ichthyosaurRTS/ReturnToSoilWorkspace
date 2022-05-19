package com.ichthyosaur.returntosoil.client.entity.model.spell;

import com.ichthyosaur.returntosoil.common.entity.SpellEntity;
import com.ichthyosaur.returntosoil.core.util.rollChance;
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
        bone.setPos(0.0F, 0.0F, 0.9342F);
        this.setRotationAngle(bone, 0.7854F, 0.0F, 0.0F);
        bone.texOffs(0, 10).addBox(-0.5F, -2.1447F, -1.9342F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone.texOffs(6, 11).addBox(-0.5F, 5.8553F, 6.0658F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone.texOffs(11, 5).addBox(-0.5F, 3.8553F, 4.0658F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone.texOffs(10, 9).addBox(-0.5F, 1.8553F, 2.0658F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone.texOffs(10, 0).addBox(-0.5F, -0.1447F, 0.0658F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone.texOffs(0, 0).addBox(-0.5F, -9.1447F, -8.9342F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        bone.texOffs(18, 0).addBox(-0.5F, -8.1447F, -5.9342F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone.texOffs(14, 20).addBox(-0.5F, -7.1447F, -4.9342F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(20, 7).addBox(-0.5F, -5.1447F, -2.9342F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(4, 20).addBox(-0.5F, -3.1447F, -0.9342F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(20, 3).addBox(-0.5F, -1.1447F, 1.0658F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(5, 3).addBox(-0.5F, 0.8553F, 3.0658F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone.texOffs(10, 13).addBox(-0.5F, -0.1447F, 4.0658F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone.texOffs(4, 18).addBox(-0.5F, 1.8553F, 4.0658F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(14, 0).addBox(-0.5F, 3.8553F, 2.0658F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(14, 0).addBox(-0.5F, 4.8553F, 1.0658F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(5, 0).addBox(-0.5F, 3.8553F, 0.0658F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone.texOffs(5, 0).addBox(-0.5F, 3.8553F, 0.0658F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone.texOffs(16, 8).addBox(-0.5F, 2.8553F, 1.0658F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone.texOffs(7, 19).addBox(-0.5F, 3.8553F, 3.0658F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(18, 17).addBox(-0.5F, 5.8553F, 5.0658F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(18, 14).addBox(-0.5F, 4.8553F, 6.0658F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(18, 11).addBox(-0.5F, 2.8553F, 4.0658F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(0, 20).addBox(-0.5F, -1.1447F, -2.9342F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(17, 19).addBox(-0.5F, -3.1447F, -4.9342F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(11, 19).addBox(-0.5F, 0.8553F, -0.9342F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(20, 9).addBox(-0.5F, -5.1447F, -6.9342F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.texOffs(14, 17).addBox(-0.5F, -6.1447F, -3.9342F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone.texOffs(17, 5).addBox(-0.5F, -4.1447F, -1.9342F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone.texOffs(0, 17).addBox(-0.5F, -2.1447F, 0.0658F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone.texOffs(10, 16).addBox(-0.5F, -0.1447F, 2.0658F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone.texOffs(4, 15).addBox(-0.5F, -6.1447F, -7.9342F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone.texOffs(14, 14).addBox(-0.5F, -4.1447F, -5.9342F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone.texOffs(14, 11).addBox(-0.5F, -2.1447F, -3.9342F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone.texOffs(14, 2).addBox(-0.5F, -0.1447F, -1.9342F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone.texOffs(0, 14).addBox(-0.5F, 1.8553F, 0.0658F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone.texOffs(0, 6).addBox(-0.5F, -6.1447F, -5.9342F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone.texOffs(6, 7).addBox(-0.5F, -4.1447F, -3.9342F, 1.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(SpellEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    public void setupAnim(float p_225603_1_, float p_225603_2_, float p_225603_3_) {
        //SWORD POINTS EXACT WRONG DIRECTION w/o circle swap
        this.bone.yRot = rollChance.getCircleDegrees((int)p_225603_2_-180) * ((float)Math.PI / 180F);
        this.bone.xRot = (p_225603_3_+45) * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
