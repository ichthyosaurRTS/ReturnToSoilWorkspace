package com.ichthyosaur.returntosoil.client.wearable.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class CentipedeLegsModel extends BipedModel<LivingEntity> {

    public static final CentipedeLegsModel INSTANCE = new CentipedeLegsModel();

    private final ModelRenderer segment;
    private final ModelRenderer fakehead;
    private final ModelRenderer rotpoint2;
    private final ModelRenderer boody;
    private final ModelRenderer flesh;
    private final ModelRenderer legleft;
    private final ModelRenderer legleft2;
    private final ModelRenderer legright;
    private final ModelRenderer legrightfront;
    private final ModelRenderer shell;
    private final ModelRenderer cube_r1;
    private final ModelRenderer gem;
    private final ModelRenderer cube_r2;
    private final ModelRenderer rotpoint;
    private final ModelRenderer boody2;
    private final ModelRenderer flesh2;
    private final ModelRenderer legleft3;
    private final ModelRenderer legleft4;
    private final ModelRenderer legright2;
    private final ModelRenderer legrightfront2;
    private final ModelRenderer shell2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer gem2;
    private final ModelRenderer cube_r4;

    public CentipedeLegsModel() {
        super(1.0F);
        texWidth = 128;
        texHeight = 128;

        segment = new ModelRenderer(this);
        segment.setPos(0.0F, -1.0F, 13.0F);


        fakehead = new ModelRenderer(this);
        fakehead.setPos(0.0F, -10.0F, 7.0F);
        segment.addChild(fakehead);


        rotpoint2 = new ModelRenderer(this);
        rotpoint2.setPos(0.0F, 18.0F, -19.0F);
        fakehead.addChild(rotpoint2);


        boody = new ModelRenderer(this);
        boody.setPos(0.0F, 1.0F, 2.0F);
        rotpoint2.addChild(boody);
        setRotationAngle(boody, -1.5708F, 0.0F, 0.0F);


        flesh = new ModelRenderer(this);
        flesh.setPos(0.0F, 3.0F, 14.0F);
        boody.addChild(flesh);
        flesh.texOffs(38, 0).addBox(-6.0F, -4.0F, -13.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);

        legleft = new ModelRenderer(this);
        legleft.setPos(6.0F, 2.0F, 8.0F);
        boody.addChild(legleft);


        legleft2 = new ModelRenderer(this);
        legleft2.setPos(5.0F, 2.0F, -1.0F);
        boody.addChild(legleft2);


        legright = new ModelRenderer(this);
        legright.setPos(-6.0F, 2.0F, 8.0F);
        boody.addChild(legright);


        legrightfront = new ModelRenderer(this);
        legrightfront.setPos(-5.0F, 2.0F, -1.0F);
        boody.addChild(legrightfront);


        shell = new ModelRenderer(this);
        shell.setPos(0.0F, 3.0F, 14.0F);
        boody.addChild(shell);
        shell.texOffs(0, 0).addBox(-5.0F, -4.9F, -16.0F, 10.0F, 4.0F, 18.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -4.5F, -7.0F);
        shell.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0873F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 22).addBox(-7.0F, -2.5F, -7.0F, 14.0F, 5.0F, 14.0F, 0.0F, false);

        gem = new ModelRenderer(this);
        gem.setPos(0.0F, -3.5F, 7.0F);
        boody.addChild(gem);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, -1.0F, 0.0F);
        gem.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.1309F, 0.0F, 0.0F);
        cube_r2.texOffs(0, 6).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

        rotpoint = new ModelRenderer(this);
        rotpoint.setPos(0.0F, 18.0F, -19.0F);
        fakehead.addChild(rotpoint);


        boody2 = new ModelRenderer(this);
        boody2.setPos(0.0F, 1.0F, -2.0F);
        rotpoint.addChild(boody2);
        setRotationAngle(boody2, -1.5708F, 3.1416F, 0.0F);


        flesh2 = new ModelRenderer(this);
        flesh2.setPos(0.0F, 3.0F, 14.0F);
        boody2.addChild(flesh2);
        flesh2.texOffs(38, 0).addBox(-6.0F, -4.0F, -13.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);

        legleft3 = new ModelRenderer(this);
        legleft3.setPos(6.0F, 2.0F, 8.0F);
        boody2.addChild(legleft3);


        legleft4 = new ModelRenderer(this);
        legleft4.setPos(5.0F, 2.0F, -1.0F);
        boody2.addChild(legleft4);


        legright2 = new ModelRenderer(this);
        legright2.setPos(-6.0F, 2.0F, 8.0F);
        boody2.addChild(legright2);


        legrightfront2 = new ModelRenderer(this);
        legrightfront2.setPos(-5.0F, 2.0F, -1.0F);
        boody2.addChild(legrightfront2);


        shell2 = new ModelRenderer(this);
        shell2.setPos(0.0F, 3.0F, 14.0F);
        boody2.addChild(shell2);
        shell2.texOffs(0, 0).addBox(-5.0F, -4.9F, -16.0F, 10.0F, 4.0F, 18.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, -4.5F, -7.0F);
        shell2.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0873F, 0.0F, 0.0F);
        cube_r3.texOffs(0, 22).addBox(-7.0F, -2.5F, -7.0F, 14.0F, 5.0F, 14.0F, 0.0F, false);

        gem2 = new ModelRenderer(this);
        gem2.setPos(0.0F, -3.5F, 7.0F);
        boody2.addChild(gem2);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, -1.0F, 0.0F);
        gem2.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.1309F, 0.0F, 0.0F);
        cube_r4.texOffs(0, 6).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
        body.addChild(segment);
    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        segment.y = rightLeg.y-11;
        segment.z = rightLeg.z+13;

        rotpoint.xRot = -Math.abs(rightLeg.xRot);
        rotpoint2.xRot = Math.abs(rightLeg.xRot);

        segment.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

}
