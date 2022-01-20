package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.DragonflyEntity;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class DragonflyModel<T extends DragonflyEntity> extends EntityModel<DragonflyEntity> {

    private final ModelRenderer all;
    private final ModelRenderer all2;
    private final ModelRenderer dbody;
    private final ModelRenderer cube_r1;
    private final ModelRenderer tailbase;
    private final ModelRenderer cube_r2;
    private final ModelRenderer tailendclose;
    private final ModelRenderer tailendfar;
    private final ModelRenderer legs;
    private final ModelRenderer cube_r3;
    private final ModelRenderer dhead;
    private final ModelRenderer eyes;
    private final ModelRenderer wings;
    private final ModelRenderer rightback;
    private final ModelRenderer rightfront;
    private final ModelRenderer leftback;
    private final ModelRenderer leftfront;

    public DragonflyModel() {
        texWidth = 32;
        texHeight = 32;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 24.0F, 0.0F);


        all2 = new ModelRenderer(this);
        all2.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(all2);


        dbody = new ModelRenderer(this);
        dbody.setPos(0.0F, 0.0F, 0.0F);
        all2.addChild(dbody);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -1.5F, -1.5F);
        dbody.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0436F, 0.0F, 0.0F);
        cube_r1.texOffs(10, 12).addBox(-1.0F, -2.0F, -2.5F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        tailbase = new ModelRenderer(this);
        tailbase.setPos(0.0F, -2.6F, 0.0F);
        dbody.addChild(tailbase);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.5132F, 2.4924F);
        tailbase.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.0436F, 0.0F, 0.0F);
        cube_r2.texOffs(8, 6).addBox(-1.0F, -1.5132F, -2.5924F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        tailendclose = new ModelRenderer(this);
        tailendclose.setPos(0.0F, 0.0F, 4.0F);
        tailbase.addChild(tailendclose);
        tailendclose.texOffs(0, 13).addBox(-1.0F, -1.0F, -0.1F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        tailendfar = new ModelRenderer(this);
        tailendfar.setPos(0.0F, -0.3F, 2.0F);
        tailendclose.addChild(tailendfar);
        tailendfar.texOffs(0, 6).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        dbody.addChild(legs);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, -1.5F, -1.5F);
        legs.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0436F, 0.0F, 0.0F);
        cube_r3.texOffs(4, 18).addBox(0.5F, -0.3F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.texOffs(0, 18).addBox(0.5F, -1.3F, 0.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r3.texOffs(8, 8).addBox(-1.5F, -0.3F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.texOffs(0, 6).addBox(-1.5F, -1.3F, 0.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        dhead = new ModelRenderer(this);
        dhead.setPos(0.0F, -1.8F, -3.5F);
        dbody.addChild(dhead);
        dhead.texOffs(16, 6).addBox(-1.0F, -1.4F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        eyes = new ModelRenderer(this);
        eyes.setPos(0.0F, -1.0F, 0.0F);
        dhead.addChild(eyes);
        eyes.texOffs(12, 18).addBox(0.2F, -0.2F, -1.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        eyes.texOffs(8, 18).addBox(-1.2F, -0.2F, -1.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        wings = new ModelRenderer(this);
        wings.setPos(0.0F, 0.0F, 0.0F);
        dbody.addChild(wings);


        rightback = new ModelRenderer(this);
        rightback.setPos(-0.5F, -3.3F, -0.5F);
        wings.addChild(rightback);
        setRotationAngle(rightback, 0.0F, 0.6109F, 0.0F);
        rightback.texOffs(0, 10).addBox(-2.0F, -0.2F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rightback.texOffs(0, 0).addBox(-9.0F, 0.0F, -0.5F, 8.0F, 0.0F, 3.0F, 0.0F, false);

        rightfront = new ModelRenderer(this);
        rightfront.setPos(-0.5F, -3.3F, -2.5F);
        wings.addChild(rightfront);
        setRotationAngle(rightfront, 0.0F, 0.2618F, 0.0F);
        rightfront.texOffs(0, 10).addBox(-2.0F, -0.2F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rightfront.texOffs(0, 0).addBox(-9.0F, 0.0F, -0.5F, 8.0F, 0.0F, 3.0F, 0.0F, false);

        leftback = new ModelRenderer(this);
        leftback.setPos(0.5F, -3.3F, -0.5F);
        wings.addChild(leftback);
        setRotationAngle(leftback, 0.0F, -0.6109F, 0.0F);
        leftback.texOffs(0, 3).addBox(1.0F, 0.0F, -0.5F, 8.0F, 0.0F, 3.0F, 0.0F, false);
        leftback.texOffs(7, 13).addBox(0.0F, -0.2F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        leftfront = new ModelRenderer(this);
        leftfront.setPos(0.5F, -3.3F, -2.5F);
        wings.addChild(leftfront);
        setRotationAngle(leftfront, 0.0F, -0.2618F, 0.0F);
        leftfront.texOffs(0, 3).addBox(1.0F, 0.0F, -0.5F, 8.0F, 0.0F, 3.0F, 0.0F, false);
        leftfront.texOffs(7, 13).addBox(0.0F, -0.2F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
    }


    @Override
    public void setupAnim(DragonflyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.dhead.xRot = -headPitch * ((float)Math.PI / 360F);
        this.dhead.yRot = -netHeadYaw * ((float)Math.PI / 360F);
        /*this.dbody.xRot = -headPitch * ((float)Math.PI / 360F);
        this.dbody.yRot = -netHeadYaw * ((float)Math.PI / 360F);*/

        //up down sway?
        this.tailbase.xRot = (float)((Math.sin(entity.getTailDegree()[0] * (float)Math.PI / 180F))/4 + 0.1);
        this.tailendclose.xRot = (float)((Math.sin(entity.getTailDegree()[1] * (float)Math.PI / 180F))/4 + 0.1);
        this.tailendfar.xRot = (float)((Math.sin(entity.getTailDegree()[2] * (float)Math.PI / 180F))/4 + 0.1);

        this.rightfront.zRot = -entity.getWingDegree() * ((float)Math.PI / 180F);
        this.leftfront.zRot = entity.getWingDegree() * ((float)Math.PI / 180F);

        this.rightback.zRot = entity.getWingDegree() * ((float)Math.PI / 180F);
        this.leftback.zRot = -entity.getWingDegree() * ((float)Math.PI / 180F);
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
