package com.ichthyosaur.returntosoil.client.wearable.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class CentipedeChestModel extends BipedModel<LivingEntity> {

    public static final CentipedeChestModel INSTANCE = new CentipedeChestModel();

    private final ModelRenderer all;
    private final ModelRenderer segment;
    private final ModelRenderer fakehead;
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
    private final ModelRenderer segment3;
    private final ModelRenderer fakehead3;
    private final ModelRenderer boody3;
    private final ModelRenderer flesh3;
    private final ModelRenderer legleft5;
    private final ModelRenderer legleft6;
    private final ModelRenderer legright3;
    private final ModelRenderer legrightfront3;
    private final ModelRenderer shell3;
    private final ModelRenderer cube_r3;
    private final ModelRenderer gem3;
    private final ModelRenderer cube_r4;

    public CentipedeChestModel() {
        super(1.0F);
        texWidth = 128;
        texHeight = 128;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 2.0F, 7.0F);


        segment = new ModelRenderer(this);
        segment.setPos(0.0F, 0.0F, 3.0F);
        all.addChild(segment);
        setRotationAngle(segment, -0.1745F, 0.0F, 0.0F);


        fakehead = new ModelRenderer(this);
        fakehead.setPos(0.0F, -10.0F, 7.0F);
        segment.addChild(fakehead);


        boody = new ModelRenderer(this);
        boody.setPos(0.0F, 7.0F, -14.0F);
        fakehead.addChild(boody);
        setRotationAngle(boody, -1.4835F, 0.0F, 0.0F);


        flesh = new ModelRenderer(this);
        flesh.setPos(0.0F, 3.0F, 14.0F);
        boody.addChild(flesh);
        flesh.texOffs(38, 0).addBox(-6.0F, -3.0F, -13.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);

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

        segment3 = new ModelRenderer(this);
        segment3.setPos(0.0F, 23.0F, -16.0F);
        all.addChild(segment3);
        setRotationAngle(segment3, 2.9671F, 0.0F, -3.1416F);


        fakehead3 = new ModelRenderer(this);
        fakehead3.setPos(0.0F, -32.0F, 2.0F);
        segment3.addChild(fakehead3);


        boody3 = new ModelRenderer(this);
        boody3.setPos(0.0F, 7.0F, -14.0F);
        fakehead3.addChild(boody3);
        setRotationAngle(boody3, -1.4835F, 0.0F, 0.0F);


        flesh3 = new ModelRenderer(this);
        flesh3.setPos(0.0F, 3.0F, 14.0F);
        boody3.addChild(flesh3);


        legleft5 = new ModelRenderer(this);
        legleft5.setPos(6.0F, 2.0F, 8.0F);
        boody3.addChild(legleft5);


        legleft6 = new ModelRenderer(this);
        legleft6.setPos(5.0F, 2.0F, -1.0F);
        boody3.addChild(legleft6);


        legright3 = new ModelRenderer(this);
        legright3.setPos(-6.0F, 2.0F, 8.0F);
        boody3.addChild(legright3);


        legrightfront3 = new ModelRenderer(this);
        legrightfront3.setPos(-5.0F, 2.0F, -1.0F);
        boody3.addChild(legrightfront3);


        shell3 = new ModelRenderer(this);
        shell3.setPos(0.0F, 3.0F, 14.0F);
        boody3.addChild(shell3);
        shell3.texOffs(0, 0).addBox(-5.0F, -4.9F, -16.0F, 10.0F, 4.0F, 18.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, -4.5F, -7.0F);
        shell3.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0873F, 0.0F, 0.0F);
        cube_r3.texOffs(0, 22).addBox(-7.0F, -2.5F, -7.0F, 14.0F, 5.0F, 14.0F, 0.0F, false);

        gem3 = new ModelRenderer(this);
        gem3.setPos(0.0F, -3.5F, 7.0F);
        boody3.addChild(gem3);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, -1.0F, 0.0F);
        gem3.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.1309F, 0.0F, 0.0F);
        cube_r4.texOffs(0, 6).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

        body.addChild(all);
    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        all.y = body.y+2;
        all.z = body.z+7;
        all.xRot = body.xRot;
        all.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

}
