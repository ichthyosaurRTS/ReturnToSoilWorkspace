package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.FourTailedFoxEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class FourTailedFoxModel<T extends FourTailedFoxEntity> extends EntityModel<FourTailedFoxEntity> {

    private final ModelRenderer all;
    private final ModelRenderer body;
    private final ModelRenderer butt;
    private final ModelRenderer tails;
    private final ModelRenderer tail1;
    private final ModelRenderer tail11;
    private final ModelRenderer tail12;
    private final ModelRenderer tail13;
    private final ModelRenderer tail14;
    private final ModelRenderer tail4;
    private final ModelRenderer tail41;
    private final ModelRenderer tail42;
    private final ModelRenderer tail43;
    private final ModelRenderer tail44;
    private final ModelRenderer tail2;
    private final ModelRenderer tail21;
    private final ModelRenderer tail22;
    private final ModelRenderer tail23;
    private final ModelRenderer tail24;
    private final ModelRenderer tail3;
    private final ModelRenderer tail31;
    private final ModelRenderer tail32;
    private final ModelRenderer tail33;
    private final ModelRenderer tail34;
    private final ModelRenderer torso;
    private final ModelRenderer head;
    private final ModelRenderer ears;
    private final ModelRenderer rightear;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r3_r1;
    private final ModelRenderer leftear;
    private final ModelRenderer cube_r4_r1;
    private final ModelRenderer legs;
    private final ModelRenderer frontright;
    private final ModelRenderer frontleft;
    private final ModelRenderer backright;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer backleft;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;

    private float tailTimer = -3.14F;

    public FourTailedFoxModel() {
        texWidth = 128;
        texHeight = 128;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 24.0F, 0.0F);


        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(body);


        butt = new ModelRenderer(this);
        butt.setPos(0.0F, -4.5F, 3.0F);
        body.addChild(butt);
        setRotationAngle(butt, 0.1745F, 0.0F, 0.0F);
        butt.texOffs(21, 0).addBox(-2.5F, -1.0F, -2.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        tails = new ModelRenderer(this);
        tails.setPos(0.0F, 4.5F, -3.0F);
        butt.addChild(tails);


        tail1 = new ModelRenderer(this);
        tail1.setPos(0.0F, -6.0F, 3.0F);
        tails.addChild(tail1);
        setRotationAngle(tail1, 0.1309F, 0.0F, 0.0F);


        tail11 = new ModelRenderer(this);
        tail11.setPos(0.0F, 0.0F, 0.0F);
        tail1.addChild(tail11);
        tail11.texOffs(58, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        tail12 = new ModelRenderer(this);
        tail12.setPos(0.0F, 0.0F, 3.0F);
        tail11.addChild(tail12);
        setRotationAngle(tail12, 0.0F, 0.0F, 0.0F);
        tail12.texOffs(0, 53).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        tail13 = new ModelRenderer(this);
        tail13.setPos(0.0F, 0.0F, 4.0F);
        tail12.addChild(tail13);
        setRotationAngle(tail13, 0.0F, 0.0F, 0.0F);
        tail13.texOffs(21, 21).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 9.0F, 0.0F, false);

        tail14 = new ModelRenderer(this);
        tail14.setPos(0.0F, 0.0F, 7.0F);
        tail13.addChild(tail14);
        tail14.texOffs(58, 43).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        tail14.texOffs(38, 47).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        tail4 = new ModelRenderer(this);
        tail4.setPos(0.0F, -6.0F, 3.0F);
        tails.addChild(tail4);
        setRotationAngle(tail4, 0.1309F, 0.0F, 0.0F);


        tail41 = new ModelRenderer(this);
        tail41.setPos(0.0F, 0.0F, 0.0F);
        tail4.addChild(tail41);
        setRotationAngle(tail41, 0.0F, -0.5236F, 0.0F);
        tail41.texOffs(34, 36).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        tail42 = new ModelRenderer(this);
        tail42.setPos(0.0F, 0.0F, 3.0F);
        tail41.addChild(tail42);
        setRotationAngle(tail42, 0.0F, -0.7854F, 0.0F);
        tail42.texOffs(40, 36).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        tail43 = new ModelRenderer(this);
        tail43.setPos(0.0F, 0.0F, 4.0F);
        tail42.addChild(tail43);
        setRotationAngle(tail43, 0.0F, -0.6981F, 0.0F);
        tail43.texOffs(0, 0).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 9.0F, 0.0F, false);

        tail44 = new ModelRenderer(this);
        tail44.setPos(0.0F, 0.0F, 7.0F);
        tail43.addChild(tail44);
        setRotationAngle(tail44, 0.0F, 1.2654F, 0.0F);
        tail44.texOffs(56, 54).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        tail44.texOffs(18, 36).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        tail2 = new ModelRenderer(this);
        tail2.setPos(0.0F, -6.0F, 3.0F);
        tails.addChild(tail2);


        tail21 = new ModelRenderer(this);
        tail21.setPos(0.0F, 0.0F, 0.0F);
        tail2.addChild(tail21);
        setRotationAngle(tail21, 0.8727F, 0.0F, 0.0F);
        tail21.texOffs(56, 35).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        tail22 = new ModelRenderer(this);
        tail22.setPos(0.0F, 0.0F, 3.0F);
        tail21.addChild(tail22);
        setRotationAngle(tail22, 0.3491F, 0.0F, 0.0F);
        tail22.texOffs(16, 47).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        tail23 = new ModelRenderer(this);
        tail23.setPos(0.0F, 0.0F, 4.0F);
        tail22.addChild(tail23);
        setRotationAngle(tail23, 0.9599F, 0.0F, 0.0F);
        tail23.texOffs(21, 6).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 9.0F, 0.0F, false);

        tail24 = new ModelRenderer(this);
        tail24.setPos(0.0F, 0.0F, 7.0F);
        tail23.addChild(tail24);
        setRotationAngle(tail24, -1.2217F, 0.0F, 0.0F);
        tail24.texOffs(38, 58).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        tail24.texOffs(45, 15).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        tail3 = new ModelRenderer(this);
        tail3.setPos(0.0F, -6.0F, 3.0F);
        tails.addChild(tail3);
        setRotationAngle(tail3, 0.1309F, 0.0F, 0.0F);


        tail31 = new ModelRenderer(this);
        tail31.setPos(0.0F, 0.0F, 0.0F);
        tail3.addChild(tail31);
        setRotationAngle(tail31, 0.0F, 0.6109F, 0.0F);
        tail31.texOffs(32, 47).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        tail32 = new ModelRenderer(this);
        tail32.setPos(0.0F, 0.0F, 3.0F);
        tail31.addChild(tail32);
        setRotationAngle(tail32, 0.0F, 0.6109F, 0.0F);
        tail32.texOffs(42, 0).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        tail33 = new ModelRenderer(this);
        tail33.setPos(0.0F, 0.0F, 4.0F);
        tail32.addChild(tail33);
        setRotationAngle(tail33, 0.0F, 0.829F, 0.0F);
        tail33.texOffs(0, 15).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 9.0F, 0.0F, false);

        tail34 = new ModelRenderer(this);
        tail34.setPos(0.0F, 0.0F, 7.0F);
        tail33.addChild(tail34);
        setRotationAngle(tail34, 0.0F, -1.2654F, 0.0F);
        tail34.texOffs(22, 58).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        tail34.texOffs(0, 42).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        torso = new ModelRenderer(this);
        torso.setPos(0.0F, -5.0F, 1.0F);
        body.addChild(torso);
        setRotationAngle(torso, 0.2618F, 0.0F, 0.0F);
        torso.texOffs(0, 30).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, -6.0F, -2.0F);
        all.addChild(head);
        head.texOffs(51, 26).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 5.0F, 4.0F, 0.0F, false);
        head.texOffs(0, 30).addBox(-1.0F, 1.0F, -5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        ears = new ModelRenderer(this);
        ears.setPos(0.0F, 6.0F, 2.0F);
        head.addChild(ears);


        rightear = new ModelRenderer(this);
        rightear.setPos(0.0F, 0.0F, 0.0F);
        ears.addChild(rightear);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-2.0F, -9.5F, -1.5F);
        rightear.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 0.0F);


        cube_r3_r1 = new ModelRenderer(this);
        cube_r3_r1.setPos(0.0F, 0.0F, -1.0F);
        cube_r3.addChild(cube_r3_r1);
        setRotationAngle(cube_r3_r1, 0.1309F, 0.0F, 0.0F);
        cube_r3_r1.texOffs(0, 15).addBox(-1.5F, -2.5F, -0.5F, 3.0F, 5.0F, 1.0F, 0.0F, false);

        leftear = new ModelRenderer(this);
        leftear.setPos(2.0F, -10.5F, -3.5F);
        ears.addChild(leftear);


        cube_r4_r1 = new ModelRenderer(this);
        cube_r4_r1.setPos(0.0F, 0.0F, 2.0F);
        leftear.addChild(cube_r4_r1);
        setRotationAngle(cube_r4_r1, 0.1309F, 0.0F, 0.0F);
        cube_r4_r1.texOffs(0, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 5.0F, 1.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(legs);


        frontright = new ModelRenderer(this);
        frontright.setPos(-1.0F, -3.0F, -1.5F);
        legs.addChild(frontright);
        frontright.texOffs(0, 34).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        frontleft = new ModelRenderer(this);
        frontleft.setPos(1.0F, -3.0F, -1.5F);
        legs.addChild(frontleft);
        frontleft.texOffs(16, 30).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        backright = new ModelRenderer(this);
        backright.setPos(-2.0F, -4.0F, 2.0F);
        legs.addChild(backright);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(-0.5F, 3.0F, 1.5F);
        backright.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.3491F, 0.0F, 0.0F);
        cube_r5.texOffs(4, 6).addBox(-0.7F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(-0.5F, 2.0F, 0.5F);
        backright.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.2618F, 0.0F, 0.0F);
        cube_r6.texOffs(0, 42).addBox(-0.3F, -2.0F, -0.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        backleft = new ModelRenderer(this);
        backleft.setPos(2.0F, -4.0F, 2.0F);
        legs.addChild(backleft);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(-0.5F, 2.0F, 0.5F);
        backleft.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.2618F, 0.0F, 0.0F);
        cube_r7.texOffs(37, 0).addBox(0.3F, -2.0F, -0.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(-0.5F, 3.0F, 1.5F);
        backleft.addChild(cube_r8);
        setRotationAngle(cube_r8, -0.3491F, 0.0F, 0.0F);
        cube_r8.texOffs(0, 6).addBox(0.7F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
    }


    public void prepareMobModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        this.frontright.xRot = MathHelper.cos(p_212843_2_ * 0.6662F) * 1.4F * p_212843_3_;
        this.frontleft.xRot = MathHelper.cos(p_212843_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_212843_3_;
        this.backright.xRot = MathHelper.cos(p_212843_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_212843_3_;
        this.backleft.xRot = MathHelper.cos(p_212843_2_ * 0.6662F) * 1.4F * p_212843_3_;
    }

    @Override
    public void setupAnim(FourTailedFoxEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);


        // if the tailtimer reaches 3.14, reset to -3.14 otherwise add to it. Just prevents number buildup
        this.tailTimer = this.tailTimer<3.14 ? this.tailTimer+=0.008 : -3.14F;

        this.butt.zRot = (float) (Math.sin(limbSwing*-1)*limbSwingAmount)/10;

        this.frontleft.xRot = (float) Math.sin(limbSwing*-1)*limbSwingAmount;
        this.frontright.xRot = (float) Math.sin(limbSwing*1)*limbSwingAmount;
        this.backleft.xRot = (float) Math.sin(limbSwing*1)*limbSwingAmount;
        this.backright.xRot = (float) Math.sin(limbSwing*-1)*limbSwingAmount;

        this.tail21.xRot = getRot(0.0F) + 0.3F;
        this.tail22.xRot = (getRot(-1.5F ) + 0.5F ) * 1.8F;
        this.tail23.xRot = getRotNoDiv(-3F) * 1.2F ;
        this.tail24.xRot = getRotNoDiv(-4F) * 1.5F;

        this.tail31.zRot = -0.6F;
        this.tail31.yRot = getRotWithVars(0F, this.tailTimer-1.5F, 5) + 0.3F;
        this.tail32.yRot = (getRotWithVars(-1.5F,this.tailTimer - 1.5F, 5F) + 0.5F ) * 1.8F;
        this.tail33.yRot = getRotWithVars(-3F, this.tailTimer-1.5F, 1F) * 1.2F ;
        this.tail34.yRot = getRotWithVars(-4F, this.tailTimer-1.5F, 1F) * 1.5F;

        this.tail41.zRot = 0.6F;
        this.tail41.yRot = -(getRotWithVars(0F, this.tailTimer-2.2F, 5) + 0.3F);
        this.tail42.yRot = -((getRotWithVars(-1.5F,this.tailTimer -2.2F, 5F) + 0.5F ) * 1.8F);
        this.tail43.yRot = -(getRotWithVars(-3F, this.tailTimer-2.2F, 1F) * 1.2F);
        this.tail44.yRot = -(getRotWithVars(-4F, this.tailTimer-2.2F, 1F) * 1.5F);

    }

    //  Returns a value from sin between 1 & -1
    private float getRot (float swingModifier) {
        return (float) Math.sin(this.tailTimer+swingModifier)/5F;
    }
    //  The portion denominator will chop down the angle, timer refers to what part along the sin graph, with swing mod on top of that
    private float getRotWithVars (float swingModifier, float timer, float portionDe) {
        return (float) Math.sin(timer+swingModifier)/portionDe;
    }
    private float getRotNoDiv (float swingModifier) {
        return (float) Math.sin(this.tailTimer+swingModifier);
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


