package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.GawanHeadEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GawanHeadModel<T extends GawanHeadEntity> extends EntityModel<GawanHeadEntity> {

    private final ModelRenderer all;
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer jaw;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer teeth2;
    private final ModelRenderer cube_r11;
    private final ModelRenderer teeth;
    private final ModelRenderer cube_r12;

    public GawanHeadModel() {
        texWidth = 256;
        texHeight = 256;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 24.0F, 59.0F);


        head = new ModelRenderer(this);
        head.setPos(0.0F, -6.0F, -59.0F);
        all.addChild(head);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 1.5F, -14.5F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.1309F, 0.0F, 0.0F);
        cube_r1.texOffs(17, 0).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0633F, -31.5123F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.5672F, 0.0F, 0.0F);
        cube_r2.texOffs(3, 3).addBox(-0.49F, -1.5F, -0.2877F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, 0.0F, -21.5F);
        head.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.0436F, 0.0F, 0.0F);
        cube_r3.texOffs(104, 0).addBox(-0.5F, -1.0F, -9.5F, 1.0F, 2.0F, 19.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, 1.2171F, -16.5484F);
        head.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.1745F, 0.0F, 0.0F);
        cube_r4.texOffs(54, 19).addBox(-1.0F, -1.0F, -5.5F, 2.0F, 2.0F, 10.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(0.0F, 1.5F, -12.5F);
        head.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0873F, 0.0F, 0.0F);
        cube_r5.texOffs(0, 15).addBox(-2.0F, -2.5F, -4.5F, 4.0F, 5.0F, 9.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.0F, 2.5F, -4.0F);
        head.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.0436F, 0.0F, 0.0F);
        cube_r6.texOffs(104, 21).addBox(-3.0F, -3.5F, -5.0F, 6.0F, 8.0F, 13.0F, 0.0F, false);

        jaw = new ModelRenderer(this);
        jaw.setPos(0.0025F, 3.3598F, -6.8626F);
        head.addChild(jaw);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(-0.0025F, 4.3049F, -23.7568F);
        jaw.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.5672F, 0.0F, 0.0F);
        cube_r7.texOffs(0, 0).addBox(-0.49F, -1.4647F, -0.2805F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(-0.0025F, 1.8573F, -10.1857F);
        jaw.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.2182F, 0.0F, 0.0F);
        cube_r8.texOffs(0, 46).addBox(-1.0F, -0.4171F, -5.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(-0.0025F, 1.0852F, -4.8778F);
        jaw.addChild(cube_r9);
        setRotationAngle(cube_r9, -0.0436F, 0.0F, 0.0F);
        cube_r9.texOffs(0, 0).addBox(-1.5F, -1.5F, -4.5F, 3.0F, 4.0F, 11.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(-0.0025F, 2.6345F, -14.8991F);
        jaw.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.1309F, 0.0F, 0.0F);
        cube_r10.texOffs(108, 107).addBox(-0.5F, 0.0F, -8.5F, 1.0F, 2.0F, 18.0F, 0.0F, false);

        teeth2 = new ModelRenderer(this);
        teeth2.setPos(-0.0025F, -1.3598F, 4.8626F);
        jaw.addChild(teeth2);
        setRotationAngle(teeth2, -0.1745F, 0.0F, 0.0F);


        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(0.0F, 0.5F, -8.5F);
        teeth2.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0873F, 0.0F, 0.0F);
        cube_r11.texOffs(4, 0).addBox(-1.1F, 1.9F, -4.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r11.texOffs(0, 6).addBox(0.2F, 1.9F, -4.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r11.texOffs(6, 6).addBox(0.3F, 1.9F, -2.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r11.texOffs(7, 4).addBox(-1.2F, 1.9F, -3.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        teeth = new ModelRenderer(this);
        teeth.setPos(0.0F, 1.0F, -4.0F);
        head.addChild(teeth);


        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(0.0F, 0.5F, -8.5F);
        teeth.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0873F, 0.0F, 0.0F);
        cube_r12.texOffs(4, 0).addBox(-1.4F, 1.9F, -4.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r12.texOffs(0, 6).addBox(0.4F, 1.9F, -4.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r12.texOffs(6, 6).addBox(0.8F, 1.9F, -2.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r12.texOffs(6, 2).addBox(0.9F, 1.9F, -1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r12.texOffs(3, 7).addBox(-1.9F, 1.9F, -1.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r12.texOffs(7, 4).addBox(-1.8F, 1.9F, -3.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        }

    @Override
    public void setupAnim(GawanHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

        this.jaw.xRot = entity.getMouthDegree()/1000F;
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
