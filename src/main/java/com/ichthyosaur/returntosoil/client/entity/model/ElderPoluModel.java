package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.Entity.ElderPoluEntity;
import com.ichthyosaur.returntosoil.common.Entity.JawBeetleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ElderPoluModel <T extends ElderPoluEntity> extends EntityModel<ElderPoluEntity> {

    private final ModelRenderer all;
    private final ModelRenderer body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer legs;
    private final ModelRenderer rightleg;
    private final ModelRenderer rightleg1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer rightleg2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer rightleg3;
    private final ModelRenderer leftleg;
    private final ModelRenderer leftleg1;
    private final ModelRenderer cube_r4;
    private final ModelRenderer leftleg2;
    private final ModelRenderer cube_r5;
    private final ModelRenderer leftleg3;
    private final ModelRenderer tail;
    private final ModelRenderer tail2;
    private final ModelRenderer head;
    private final ModelRenderer sac;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer skull;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer tusk;
    private final ModelRenderer plants;
    private final ModelRenderer plant1;
    private final ModelRenderer plant2;
    private final ModelRenderer plant4;
    private final ModelRenderer plant3;

    public ElderPoluModel() {
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 18.0F, 0.0F);


        body = new ModelRenderer(this);
        body.setPos(0.0F, 6.0F, 0.0F);
        all.addChild(body);
        body.texOffs(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -8.0F, 0.0F);
        body.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.6981F, 0.0F, 0.0F);
        cube_r1.texOffs(18, 20).addBox(-2.5F, -1.7F, -4.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(legs);


        rightleg = new ModelRenderer(this);
        rightleg.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(rightleg);


        rightleg1 = new ModelRenderer(this);
        rightleg1.setPos(-4.0F, -3.0F, 2.0F);
        rightleg.addChild(rightleg1);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, -2.1F);
        rightleg1.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.3054F, 0.0F, 0.0F);
        cube_r2.texOffs(29, 37).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        rightleg2 = new ModelRenderer(this);
        rightleg2.setPos(-1.0F, 0.0F, -3.0F);
        rightleg1.addChild(rightleg2);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(5.0F, 3.0F, 1.0F);
        rightleg2.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.1309F, 0.0F, 0.0F);
        cube_r3.texOffs(27, 12).addBox(-6.0F, -3.0F, -2.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        rightleg3 = new ModelRenderer(this);
        rightleg3.setPos(-1.0F, 2.0F, 3.0F);
        rightleg2.addChild(rightleg3);
        rightleg3.texOffs(29, 31).addBox(-1.0F, 0.1F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(9.0F, 0.0F, 0.0F);
        legs.addChild(leftleg);


        leftleg1 = new ModelRenderer(this);
        leftleg1.setPos(-5.0F, -3.0F, 2.0F);
        leftleg.addChild(leftleg1);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(1.0F, 0.0F, -2.1F);
        leftleg1.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.3054F, 0.0F, 0.0F);
        cube_r4.texOffs(36, 4).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        leftleg2 = new ModelRenderer(this);
        leftleg2.setPos(0.0F, 0.0F, -3.0F);
        leftleg1.addChild(leftleg2);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(5.0F, 3.0F, 1.0F);
        leftleg2.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.1309F, 0.0F, 0.0F);
        cube_r5.texOffs(24, 0).addBox(-6.0F, -3.0F, -2.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        leftleg3 = new ModelRenderer(this);
        leftleg3.setPos(1.0F, 2.0F, 3.0F);
        leftleg2.addChild(leftleg3);
        leftleg3.texOffs(20, 30).addBox(0.0F, 0.1F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(0.0F, -2.0F, 4.0F);
        body.addChild(tail);
        tail.texOffs(10, 35).addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 0.0F, false);
        tail.texOffs(38, 10).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        tail2 = new ModelRenderer(this);
        tail2.setPos(0.0F, 0.0F, 1.0F);
        tail.addChild(tail2);
        tail2.texOffs(0, 38).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        tail2.texOffs(0, 0).addBox(0.0F, -2.0F, 1.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(head);


        sac = new ModelRenderer(this);
        sac.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(sac);
        sac.texOffs(0, 17).addBox(-3.5F, -4.5F, -7.7802F, 7.0F, 4.0F, 5.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.0F, -4.5F, -5.0F);
        sac.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0873F, 0.0F, 0.0F);
        cube_r6.texOffs(0, 26).addBox(-3.0F, -4.5F, -2.0F, 6.0F, 8.0F, 4.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(0.0F, -8.5F, -5.0F);
        sac.addChild(cube_r7);
        setRotationAngle(cube_r7, -0.829F, 0.0F, 0.0F);
        cube_r7.texOffs(34, 20).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        skull = new ModelRenderer(this);
        skull.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(skull);


        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(0.0F, -11.3F, -4.2F);
        skull.addChild(cube_r8);
        setRotationAngle(cube_r8, -0.2618F, 0.0F, 0.0F);
        cube_r8.texOffs(35, 0).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(0.0F, -10.5F, -3.5F);
        skull.addChild(cube_r9);
        setRotationAngle(cube_r9, -0.3054F, 0.0F, 0.0F);
        cube_r9.texOffs(17, 36).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        tusk = new ModelRenderer(this);
        tusk.setPos(0.0F, 0.0F, 0.0F);
        skull.addChild(tusk);


        plants = new ModelRenderer(this);
        plants.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(plants);


        plant1 = new ModelRenderer(this);
        plant1.setPos(1.0F, -10.5F, 0.5F);
        plants.addChild(plant1);
        setRotationAngle(plant1, -0.3927F, -0.0436F, 0.2618F);
        plant1.texOffs(0, 17).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        plant1.texOffs(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);

        plant2 = new ModelRenderer(this);
        plant2.setPos(-2.0F, -9.5F, 2.5F);
        plants.addChild(plant2);
        setRotationAngle(plant2, -0.2618F, 0.0F, -0.2618F);
        plant2.texOffs(0, 17).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        plant2.texOffs(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);

        plant4 = new ModelRenderer(this);
        plant4.setPos(2.0F, -6.5F, 4.5F);
        plants.addChild(plant4);
        setRotationAngle(plant4, -1.3526F, 0.0F, -0.2182F);
        plant4.texOffs(0, 17).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        plant4.texOffs(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);

        plant3 = new ModelRenderer(this);
        plant3.setPos(-2.0F, -4.5F, 4.5F);
        plants.addChild(plant3);
        setRotationAngle(plant3, -1.7453F, -0.3054F, 0.3491F);
        plant3.texOffs(0, 17).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        plant3.texOffs(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(ElderPoluEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        if (!entity.getSwimmingAnim()) {
            head.yRot = netHeadYaw/100;
        } //needs sac sway, breathing

        if (entity.getSwimmingAnim()) { //need passive floaty movement here
            all.yRot = netHeadYaw/50;
            all.xRot = headPitch/100;
            head.yRot = 0;
        }
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
