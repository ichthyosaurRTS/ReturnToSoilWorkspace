package com.ichthyosaur.returntosoil.client.entity.model.GhostRamModel;

import com.ichthyosaur.returntosoil.common.entity.BaruGaruSegmentEntity;
import com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam.GhostRamHeadEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import java.util.logging.Logger;

public class GhostRamHeadModel<T extends GhostRamHeadEntity> extends EntityModel<T> {
    Logger logger = Logger.getLogger("logger");;

    private final ModelRenderer all;
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;

    public GhostRamHeadModel() {
        texWidth = 128;
        texHeight = 128;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 18.0F, 0.0F);


        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(head);
        head.texOffs(27, 13).addBox(-6.0F, -2.7F, 3.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        head.texOffs(33, 35).addBox(-2.3F, -1.7F, -2.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);
        head.texOffs(28, 42).addBox(8.5F, 2.5F, -6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        head.texOffs(28, 42).addBox(-9.5F, 2.5F, -6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 1.0309F, -6.6629F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.1309F, 0.0F, 0.0F);
        cube_r1.texOffs(18, 40).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, -0.7F, -3.5F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.0873F, 0.0F, 0.0F);
        cube_r2.texOffs(27, 23).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 7.0F, 0.0F, false);
        cube_r2.texOffs(38, 56).addBox(2.0F, 2.0F, -2.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r2.texOffs(38, 56).addBox(-3.0F, 2.0F, -2.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(2.0F, 1.2F, -3.0F);
        head.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.4363F, 0.0873F);
        cube_r3.texOffs(0, 0).addBox(-0.2F, -1.5F, -4.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-3.0F, 0.3F, -0.5F);
        head.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, -0.3927F, -0.0873F);
        cube_r4.texOffs(0, 0).addBox(-0.5F, -0.6F, -6.5F, 1.0F, 3.0F, 8.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(-7.0F, -1.7F, 2.0F);
        head.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.4363F, 0.7854F, -0.3491F);
        cube_r5.texOffs(18, 40).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(-8.0F, 1.3F, -2.0F);
        head.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.3054F, 0.2618F, 0.0F);
        cube_r6.texOffs(18, 40).addBox(-1.5F, -0.3F, -3.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(8.0F, 1.3F, -2.0F);
        head.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.3054F, -0.2618F, 0.0F);
        cube_r7.texOffs(18, 40).addBox(-0.5F, -0.3F, -3.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(7.0F, -1.7F, 2.0F);
        head.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.4363F, -0.7854F, 0.3491F);
        cube_r8.texOffs(18, 40).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(0.0F, -0.7F, 3.5F);
        head.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.1309F, 0.0F, 0.0F);
        cube_r9.texOffs(27, 0).addBox(-4.0F, -3.0F, -3.5F, 8.0F, 6.0F, 7.0F, 0.0F, false);
    }


    @Override
    public void setupAnim(GhostRamHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

        //this.all.xRot = headPitch/4 * ((float)Math.PI / 180F);
        //this.all.yRot = netHeadYaw/4 * ((float)Math.PI / 180F);

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        all.render(matrixStack, buffer, packedLight, packedOverlay); //this will render all the children too
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
