package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.HuskLarvaeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class HuskLarvaeEntityModel<T extends HuskLarvaeEntity> extends EntityModel<HuskLarvaeEntity> {

    private final ModelRenderer torso;
    private final ModelRenderer head;
    private final ModelRenderer tail;
    public float torsoMovementModifier;
    public boolean upOrDown;

    public HuskLarvaeEntityModel() {

        texHeight = 32;
        texWidth = 32;

        torso = new ModelRenderer(this);
        torso.texOffs(0, 0).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 6.0F, 8.0F, 2.0F, true);
        torso.setPos(0f,20.0f,0f);
        torso.y -= 2f; //moves piece up and down

        head = new ModelRenderer(this);
        head.texOffs(14, 14).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 3.0F, 3.0F, 1.0F, true);
        head.setPos(0f,24.0f,-1.0f);

        tail = new ModelRenderer(this);
        tail.texOffs(0, 14).addBox(-2.0F, -3.0F, 3.0F, 4.0F, 3.0F, 3.0F, 1.0F, true);
        tail.setPos(0f,24.0f,0f);


    }

    //public ModelRenderer getHead() { return this.head; }

    //public ModelRenderer getTail() {return this.tail; }


    @Override
    public void setupAnim(HuskLarvaeEntity p_225597_1_,  float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //this.head.yRot = p_225597_5_ * ((float)Math.PI / 1000F);


        if (this.torsoMovementModifier > 0.5) {this.torsoMovementModifier -= 0.005; this.upOrDown = false;}  //upon crossing 0.5, set the up-down to false/down and -0.01
        else if (this.torsoMovementModifier < -0.5) {this.torsoMovementModifier += 0.005; this.upOrDown = true;}
        else if (this.upOrDown) {this.torsoMovementModifier += 0.005;}
        else this.torsoMovementModifier -= 0.005;;
        this.torso.y = this.torsoMovementModifier+19;

        this.head.z = this.torsoMovementModifier - 1.5f;
        this.tail.z = -this.torsoMovementModifier + 1.5f;

    }


    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        torso.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }


    //@Override
    //public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {

    //}
}
