package com.ichthyosaur.returntosoil.client.wearable.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class BeetleBackpackModel extends BipedModel<LivingEntity> {

    public static final BeetleBackpackModel INSTANCE = new BeetleBackpackModel();

    private final ModelRenderer all;
    private final ModelRenderer torso;
    private final ModelRenderer lid;
    private final ModelRenderer cube_r1;
    private final ModelRenderer legs;
    private final ModelRenderer frontright;
    private final ModelRenderer frontrightleg_r1;
    private final ModelRenderer midright;
    private final ModelRenderer midrigtleg_r1;
    private final ModelRenderer backright;
    private final ModelRenderer backrightleg_r1;
    private final ModelRenderer frontleft;
    private final ModelRenderer frontleftleg_r1;
    private final ModelRenderer frontleftleg_r6_r1;
    private final ModelRenderer belt;
    private final ModelRenderer frontleftleg_r5_r1;
    private final ModelRenderer frontleftleg_r3_r1;
    private final ModelRenderer midleft;
    private final ModelRenderer midleftleg_r1;
    private final ModelRenderer backleft;
    private final ModelRenderer backleftleg_r1;

    public BeetleBackpackModel() {
        super(1.0F);
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 0.0F, 2.0F);
        setRotationAngle(all, -1.5708F, 0.0F, 0.0F);


        torso = new ModelRenderer(this);
        torso.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(torso);
        torso.texOffs(0, 0).addBox(-5.0F, -9.0F, 0.0F, 10.0F, 9.0F, 11.0F, 0.0F, false);
        torso.texOffs(31, 6).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        torso.texOffs(31, 4).addBox(-4.0F, -9.0F, -1.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        torso.texOffs(26, 23).addBox(-5.0F, -10.0F, 4.0F, 10.0F, 1.0F, 2.0F, 0.0F, false);
        torso.texOffs(26, 20).addBox(-5.0F, 0.0F, 4.0F, 10.0F, 1.0F, 2.0F, 0.0F, false);
        torso.texOffs(0, 32).addBox(5.0F, -9.0F, 4.0F, 1.0F, 9.0F, 2.0F, 0.0F, false);
        torso.texOffs(0, 0).addBox(-6.0F, -9.0F, 4.0F, 1.0F, 9.0F, 2.0F, 0.0F, false);
        torso.texOffs(0, 20).addBox(-5.5F, -9.5F, 10.0F, 11.0F, 10.0F, 2.0F, 0.0F, false);
        torso.texOffs(16, 34).addBox(-5.0F, -8.0F, -1.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
        torso.texOffs(6, 0).addBox(4.0F, -8.0F, -1.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
        torso.texOffs(16, 32).addBox(-2.0F, -8.5F, -1.6993F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        lid = new ModelRenderer(this);
        lid.setPos(0.0F, -7.5F, -1.5F);
        torso.addChild(lid);
        setRotationAngle(lid, 0.2182F, 0.0F, 0.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        lid.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.3054F, 0.0F, 0.0F);
        cube_r1.texOffs(30, 34).addBox(-2.0F, 3.5F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r1.texOffs(34, 34).addBox(-1.0F, 3.5F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r1.texOffs(24, 34).addBox(1.0F, 3.5F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r1.texOffs(6, 32).addBox(-2.0F, 2.5F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r1.texOffs(26, 26).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 7.0F, 1.0F, 0.0F, false);

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


        midright = new ModelRenderer(this);
        midright.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(midright);


        midrigtleg_r1 = new ModelRenderer(this);
        midrigtleg_r1.setPos(-4.5F, -0.5F, 3.5F);
        midright.addChild(midrigtleg_r1);
        setRotationAngle(midrigtleg_r1, 0.0F, 0.1309F, -0.2618F);


        backright = new ModelRenderer(this);
        backright.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(backright);


        backrightleg_r1 = new ModelRenderer(this);
        backrightleg_r1.setPos(-4.5F, -0.5F, 6.5F);
        backright.addChild(backrightleg_r1);
        setRotationAngle(backrightleg_r1, 0.0F, 0.7854F, -0.2618F);


        frontleft = new ModelRenderer(this);
        frontleft.setPos(0.0F, -4.0F, 0.0F);
        legs.addChild(frontleft);


        frontleftleg_r1 = new ModelRenderer(this);
        frontleftleg_r1.setPos(3.5F, -0.5F, 0.5F);
        frontleft.addChild(frontleftleg_r1);
        setRotationAngle(frontleftleg_r1, 0.0F, 0.0F, 0.0F);


        frontleftleg_r6_r1 = new ModelRenderer(this);
        frontleftleg_r6_r1.setPos(0.5F, 1.5F, -1.0F);
        frontleftleg_r1.addChild(frontleftleg_r6_r1);
        setRotationAngle(frontleftleg_r6_r1, -0.8849F, 1.0151F, -0.9241F);
        frontleftleg_r6_r1.texOffs(31, 8).addBox(-1.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        belt = new ModelRenderer(this);
        belt.setPos(-3.5F, 0.5F, -0.5F);
        frontleftleg_r1.addChild(belt);
        belt.texOffs(6, 36).addBox(2.5F, 3.5F, -0.5F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        belt.texOffs(20, 34).addBox(-4.5F, 3.5F, -0.5F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        belt.texOffs(12, 35).addBox(4.5F, 3.5F, 6.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
        belt.texOffs(10, 35).addBox(-4.5F, 3.5F, 6.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);

        frontleftleg_r5_r1 = new ModelRenderer(this);
        frontleftleg_r5_r1.setPos(0.0F, 8.0F, 8.5F);
        belt.addChild(frontleftleg_r5_r1);
        setRotationAngle(frontleftleg_r5_r1, 0.0F, 1.5708F, 0.0F);
        frontleftleg_r5_r1.texOffs(29, 2).addBox(1.0F, 0.5F, 2.5F, 8.0F, 0.0F, 2.0F, 0.0F, false);

        frontleftleg_r3_r1 = new ModelRenderer(this);
        frontleftleg_r3_r1.setPos(0.0F, 8.0F, 0.5F);
        belt.addChild(frontleftleg_r3_r1);
        setRotationAngle(frontleftleg_r3_r1, 0.0F, 1.5708F, 0.0F);
        frontleftleg_r3_r1.texOffs(29, 0).addBox(-7.0F, 0.5F, -4.5F, 8.0F, 0.0F, 2.0F, 0.0F, false);

        midleft = new ModelRenderer(this);
        midleft.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(midleft);


        midleftleg_r1 = new ModelRenderer(this);
        midleftleg_r1.setPos(3.5F, -0.5F, 3.5F);
        midleft.addChild(midleftleg_r1);
        setRotationAngle(midleftleg_r1, 0.0F, -0.1309F, 0.2618F);


        backleft = new ModelRenderer(this);
        backleft.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(backleft);


        backleftleg_r1 = new ModelRenderer(this);
        backleftleg_r1.setPos(4.5F, -0.5F, 6.5F);
        backleft.addChild(backleftleg_r1);
        setRotationAngle(backleftleg_r1, 0.0F, -0.7854F, 0.2618F);

        body.addChild(all);

    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        all.xRot = (float)(body.xRot-(Math.PI/2));

        all.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

}
