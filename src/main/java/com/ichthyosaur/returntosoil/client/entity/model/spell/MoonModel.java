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
        bone.setPos(0.0F, 24.0F, 0.0F);
        bone.texOffs(0, 0).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(SpellEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    public void setupAnim(float p_225603_1_, float p_225603_2_, float p_225603_3_) {
        //SWORD POINTS EXACT WRONG DIRECTION w/o circle swap
        this.bone.yRot = rollChance.get360Degrees((int)p_225603_2_-180) * ((float)Math.PI / 180F);
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
