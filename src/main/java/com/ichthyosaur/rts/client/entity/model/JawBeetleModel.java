package com.ichthyosaur.rts.client.entity.model;

import com.ichthyosaur.rts.common.Entity.JawBeetleEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class JawBeetleModel <T extends JawBeetleEntity> extends EntityModel<JawBeetleEntity> {

    private final ModelRenderer all;
    private final ModelRenderer torso;
    private final ModelRenderer head;
    private final ModelRenderer notmoving;
    private final ModelRenderer bottomhornrightpoint_r1;
    private final ModelRenderer bottomhornleftpoint_r1;
    private final ModelRenderer bottomhornleft1st_r1;
    private final ModelRenderer bottomhornright2nd_r1;
    private final ModelRenderer bottomhornright_r1;
    private final ModelRenderer tophornpoint_r1;
    private final ModelRenderer tophorninner_r1;
    private final ModelRenderer tophornbase_r1;
    private final ModelRenderer skull_r1;
    private final ModelRenderer moving;
    private final ModelRenderer rightarm;
    private final ModelRenderer rightarm2nd_r1;
    private final ModelRenderer rightarm1st_r1;
    private final ModelRenderer leftarm;
    private final ModelRenderer leftarm2nd_r1;
    private final ModelRenderer leftarm1st_r1;
    private final ModelRenderer legs;
    private final ModelRenderer frontright;
    private final ModelRenderer frontrightleg_r1;
    private final ModelRenderer midright;
    private final ModelRenderer midrigtleg_r1;
    private final ModelRenderer backright;
    private final ModelRenderer backrightleg_r1;
    private final ModelRenderer frontleft;
    private final ModelRenderer frontleftleg_r1;
    private final ModelRenderer midleft;
    private final ModelRenderer midleftleg_r1;
    private final ModelRenderer backleft;
    private final ModelRenderer backleftleg_r1;

    private float ArmsCounter;
    private float ArmsCounter2 = 0.1F;
    private boolean Increasing;
    private boolean Increasing2;

    public JawBeetleModel() {
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 24.0F, 0.0F);


        torso = new ModelRenderer(this);
        torso.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(torso);
        torso.texOffs(0, 0).addBox(-5.0F, -9.0F, 0.0F, 10.0F, 9.0F, 11.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(head);


        notmoving = new ModelRenderer(this);
        notmoving.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(notmoving);
        notmoving.texOffs(23, 27).addBox(-1.5F, -7.0F, -11.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        bottomhornrightpoint_r1 = new ModelRenderer(this);
        bottomhornrightpoint_r1.setPos(-2.5F, -3.0F, -12.5F);
        notmoving.addChild(bottomhornrightpoint_r1);
        setRotationAngle(bottomhornrightpoint_r1, 0.3054F, 0.0F, 0.1745F);
        bottomhornrightpoint_r1.texOffs(31, 7).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        bottomhornleftpoint_r1 = new ModelRenderer(this);
        bottomhornleftpoint_r1.setPos(2.5F, -3.0F, -12.5F);
        notmoving.addChild(bottomhornleftpoint_r1);
        setRotationAngle(bottomhornleftpoint_r1, 0.3054F, 0.0F, -0.1745F);
        bottomhornleftpoint_r1.texOffs(0, 32).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        bottomhornleft1st_r1 = new ModelRenderer(this);
        bottomhornleft1st_r1.setPos(1.5F, -1.5F, -6.5F);
        notmoving.addChild(bottomhornleft1st_r1);
        setRotationAngle(bottomhornleft1st_r1, 0.2182F, 0.0F, 0.2618F);
        bottomhornleft1st_r1.texOffs(31, 0).addBox(0.5F, -2.5F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);

        bottomhornright2nd_r1 = new ModelRenderer(this);
        bottomhornright2nd_r1.setPos(2.5F, -1.1514F, -10.4848F);
        notmoving.addChild(bottomhornright2nd_r1);
        setRotationAngle(bottomhornright2nd_r1, -0.2182F, 0.0F, 0.0F);
        bottomhornright2nd_r1.texOffs(12, 32).addBox(-5.5F, -1.5F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bottomhornright2nd_r1.texOffs(34, 30).addBox(-0.5F, -1.5F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

        bottomhornright_r1 = new ModelRenderer(this);
        bottomhornright_r1.setPos(-1.5F, -1.5F, -6.5F);
        notmoving.addChild(bottomhornright_r1);
        setRotationAngle(bottomhornright_r1, 0.2182F, -0.0436F, -0.2618F);
        bottomhornright_r1.texOffs(0, 32).addBox(-1.5F, -2.5F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);

        tophornpoint_r1 = new ModelRenderer(this);
        tophornpoint_r1.setPos(0.0F, -5.0F, -14.5F);
        notmoving.addChild(tophornpoint_r1);
        setRotationAngle(tophornpoint_r1, 0.0873F, 0.0F, 0.0F);
        tophornpoint_r1.texOffs(7, 32).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        tophorninner_r1 = new ModelRenderer(this);
        tophorninner_r1.setPos(0.0F, -6.0F, -14.0F);
        notmoving.addChild(tophorninner_r1);
        setRotationAngle(tophorninner_r1, 0.0873F, 0.0F, 0.0F);
        tophorninner_r1.texOffs(20, 35).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        tophornbase_r1 = new ModelRenderer(this);
        tophornbase_r1.setPos(0.0F, -5.0872F, -5.5038F);
        notmoving.addChild(tophornbase_r1);
        setRotationAngle(tophornbase_r1, -0.0436F, 0.0F, 0.0F);
        tophornbase_r1.texOffs(28, 20).addBox(-3.0F, -2.0F, -1.5F, 6.0F, 4.0F, 3.0F, 0.0F, false);

        skull_r1 = new ModelRenderer(this);
        skull_r1.setPos(0.0F, -4.0F, -2.0F);
        notmoving.addChild(skull_r1);
        setRotationAngle(skull_r1, -0.0873F, 0.0F, 0.0F);
        skull_r1.texOffs(0, 20).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 6.0F, 6.0F, 0.0F, false);

        moving = new ModelRenderer(this);
        moving.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(moving);


        rightarm = new ModelRenderer(this);
        rightarm.setPos(-1.0F, -1.0F, -5.0F);
        moving.addChild(rightarm);


        rightarm2nd_r1 = new ModelRenderer(this);
        rightarm2nd_r1.setPos(0.5F, -2.0F, -1.5F);
        rightarm.addChild(rightarm2nd_r1);
        setRotationAngle(rightarm2nd_r1, -0.2618F, 0.0F, 0.0F);
        rightarm2nd_r1.texOffs(22, 22).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        rightarm1st_r1 = new ModelRenderer(this);
        rightarm1st_r1.setPos(0.0F, 0.0F, -0.5F);
        rightarm.addChild(rightarm1st_r1);
        setRotationAngle(rightarm1st_r1, 0.2618F, 0.0F, 0.0F);
        rightarm1st_r1.texOffs(31, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setPos(1.0F, -1.0F, -5.0F);
        moving.addChild(leftarm);


        leftarm2nd_r1 = new ModelRenderer(this);
        leftarm2nd_r1.setPos(-1.5F, -2.0F, -1.5F);
        leftarm.addChild(leftarm2nd_r1);
        setRotationAngle(leftarm2nd_r1, -0.2618F, 0.0F, 0.0F);
        leftarm2nd_r1.texOffs(0, 20).addBox(0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        leftarm1st_r1 = new ModelRenderer(this);
        leftarm1st_r1.setPos(0.0F, 0.0F, -0.5F);
        leftarm.addChild(leftarm1st_r1);
        setRotationAngle(leftarm1st_r1, 0.2618F, 0.0F, 0.0F);
        leftarm1st_r1.texOffs(0, 23).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(legs);


        frontright = new ModelRenderer(this);
        frontright.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(frontright);


        frontrightleg_r1 = new ModelRenderer(this);
        frontrightleg_r1.setPos(-3.5F, -0.5F, 0.5F);
        frontright.addChild(frontrightleg_r1);
        setRotationAngle(frontrightleg_r1, 0.0F, -0.2618F, -0.2618F);
        frontrightleg_r1.texOffs(22, 20).addBox(-2.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        midright = new ModelRenderer(this);
        midright.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(midright);


        midrigtleg_r1 = new ModelRenderer(this);
        midrigtleg_r1.setPos(-4.5F, -0.5F, 3.5F);
        midright.addChild(midrigtleg_r1);
        setRotationAngle(midrigtleg_r1, 0.0F, 0.1309F, -0.2618F);
        midrigtleg_r1.texOffs(0, 8).addBox(-2.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        backright = new ModelRenderer(this);
        backright.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(backright);


        backrightleg_r1 = new ModelRenderer(this);
        backrightleg_r1.setPos(-4.5F, -0.5F, 6.5F);
        backright.addChild(backrightleg_r1);
        setRotationAngle(backrightleg_r1, 0.0F, 0.7854F, -0.2618F);
        backrightleg_r1.texOffs(0, 6).addBox(-2.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        frontleft = new ModelRenderer(this);
        frontleft.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(frontleft);


        frontleftleg_r1 = new ModelRenderer(this);
        frontleftleg_r1.setPos(3.5F, -0.5F, 0.5F);
        frontleft.addChild(frontleftleg_r1);
        setRotationAngle(frontleftleg_r1, 0.0F, 0.2618F, 0.2618F);
        frontleftleg_r1.texOffs(0, 4).addBox(-0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        midleft = new ModelRenderer(this);
        midleft.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(midleft);


        midleftleg_r1 = new ModelRenderer(this);
        midleftleg_r1.setPos(3.5F, -0.5F, 3.5F);
        midleft.addChild(midleftleg_r1);
        setRotationAngle(midleftleg_r1, 0.0F, -0.1309F, 0.2618F);
        midleftleg_r1.texOffs(0, 2).addBox(0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        backleft = new ModelRenderer(this);
        backleft.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(backleft);


        backleftleg_r1 = new ModelRenderer(this);
        backleftleg_r1.setPos(4.5F, -0.5F, 6.5F);
        backleft.addChild(backleftleg_r1);
        setRotationAngle(backleftleg_r1, 0.0F, -0.7854F, 0.2618F);
        backleftleg_r1.texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);


        rightarm.xRot -= -0.01F;

        leftarm.xRot -= -0.6F;
    }


    @Override
    public void setupAnim(JawBeetleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.head.yRot = netHeadYaw * ((float)Math.PI / 1000F);

        //this could be ever so slightly shorter....

        if (Increasing) ArmsCounter+=0.001;
        else ArmsCounter-=0.001;
        if (ArmsCounter>0.07) {Increasing = false;}
        else if (ArmsCounter<-0.07) {Increasing = true;}

        if (Increasing2) ArmsCounter2+=0.001;
        else ArmsCounter2-=0.001;
        if (ArmsCounter2>0.07) {Increasing2 = false;}
        else if (ArmsCounter2<-0.07) {Increasing2 = true;}

        if (ArmsCounter < 0 ) {
            if (Increasing) {rightarm.xRot += 0.01;}
            else {rightarm2nd_r1.xRot -= 0.01;}
        }
        else {
            if (Increasing) {rightarm2nd_r1.xRot += 0.01;}
            else {rightarm.xRot -= 0.01;}
        }

        if (ArmsCounter2 < 0) {
            if (Increasing2) {leftarm.xRot += 0.01;}
            else {leftarm2nd_r1.xRot -= 0.01;}
        }
        else {
            if (Increasing2) {leftarm2nd_r1.xRot += 0.01;}
            else {leftarm.xRot -= 0.01;}
        }

        //when the entity dies all the legs break!! Rather than just directly referencing a building up float,
        //we have to set the default position every update and then add the extra rotation

        this.frontrightleg_r1.yRot = -0.2618F;
        this.midrigtleg_r1.yRot = 0.1309F;
        this.backrightleg_r1.yRot = 0.7854F;
        this.frontleftleg_r1.yRot = 0.2618F;
        this.midleftleg_r1.yRot = -0.1309F;
        this.backleftleg_r1.yRot = -0.7854F;

        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount*10;
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount*10;
        this.frontrightleg_r1.yRot += f4;//* ((float)Math.PI / 1000F);
        this.frontleftleg_r1.yRot += f3;
        this.midrigtleg_r1.yRot -= f4;
        this.midleftleg_r1.yRot -= f3;
        this.backrightleg_r1.yRot += f4;
        this.backleftleg_r1.yRot += f3;

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
