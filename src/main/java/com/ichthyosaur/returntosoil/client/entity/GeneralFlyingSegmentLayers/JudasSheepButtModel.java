package com.ichthyosaur.returntosoil.client.entity.GeneralFlyingSegmentLayers;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepButtEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class JudasSheepButtModel <T extends GeneralFlyingSegmentEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer legs;
    private final ModelRenderer rightleg;
    private final ModelRenderer rightleg2;
    private final ModelRenderer leftleg;
    private final ModelRenderer leftleg2;
    private final ModelRenderer spine;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer hips;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;

    public JudasSheepButtModel() {
        texWidth = 32;
        texHeight = 32;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 4.0F, 0.0F);
        EmptyAll.addChild(all);


        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 1.0F);
        all.addChild(legs);


        rightleg = new ModelRenderer(this);
        rightleg.setPos(-3.0F, -0.5F, 1.0F);
        legs.addChild(rightleg);
        setRotationAngle(rightleg, 0.6981F, 0.0F, 0.0F);
        rightleg.texOffs(16, 21).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        rightleg2 = new ModelRenderer(this);
        rightleg2.setPos(0.5F, 5.0F, 0.5F);
        rightleg.addChild(rightleg2);
        setRotationAngle(rightleg2, 0.3491F, 0.0F, 0.0F);
        rightleg2.texOffs(8, 21).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(3.0F, -0.5F, 1.0F);
        legs.addChild(leftleg);
        setRotationAngle(leftleg, 0.6981F, 0.0F, 0.0F);
        leftleg.texOffs(23, 14).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        leftleg2 = new ModelRenderer(this);
        leftleg2.setPos(-0.5F, 5.0F, 0.5F);
        leftleg.addChild(leftleg2);
        setRotationAngle(leftleg2, 0.3491F, 0.0F, 0.0F);
        leftleg2.texOffs(0, 19).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        spine = new ModelRenderer(this);
        spine.setPos(0.0F, 0.0F, 1.0F);
        all.addChild(spine);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -1.6078F, 0.9468F);
        spine.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0873F, 0.0F, 0.0F);
        cube_r1.texOffs(16, 0).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.5F, -1.0F, -2.5F);
        spine.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.48F, 0.0F, 0.0F);
        cube_r2.texOffs(11, 0).addBox(-1.5F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, -2.5F, -7.5F);
        spine.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.5236F, 0.0F, 0.0F);
        cube_r3.texOffs(0, 12).addBox(-1.0F, -0.1F, 0.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, -2.4071F, -10.6307F);
        spine.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.1745F, 0.0F, 0.0F);
        cube_r4.texOffs(0, 0).addBox(-1.5F, -1.5929F, -0.5F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        hips = new ModelRenderer(this);
        hips.setPos(0.0F, 0.0F, 1.0F);
        all.addChild(hips);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(-2.5F, 0.5F, -2.5F);
        hips.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.1309F, -0.1309F, 0.0F);
        cube_r5.texOffs(13, 7).addBox(-0.5F, -0.5F, -2.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.0F, 0.5F, 1.0F);
        hips.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.1309F, 0.0F, 0.0F);
        cube_r6.texOffs(0, 8).addBox(-3.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(2.5F, 0.5F, -2.5F);
        hips.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.1309F, 0.1309F, 0.0F);
        cube_r7.texOffs(9, 14).addBox(-1.5F, -0.5F, -2.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);


    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

