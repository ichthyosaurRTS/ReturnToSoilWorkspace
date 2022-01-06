package com.ichthyosaur.returntosoil.client.wearable.model;

import com.ichthyosaur.returntosoil.RTSMain;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class CentipedeHelmModel extends BipedModel<LivingEntity> {

    public static final CentipedeHelmModel INSTANCE = new CentipedeHelmModel();

    private final ModelRenderer segment;
    private final ModelRenderer fakehead;
    private final ModelRenderer heead;
    private final ModelRenderer neck;
    private final ModelRenderer cube_r1;
    private final ModelRenderer skull;
    private final ModelRenderer cube_r2;
    private final ModelRenderer mouth;
    private final ModelRenderer cube_r3;
    private final ModelRenderer righthand;
    private final ModelRenderer lefthand;
    private final ModelRenderer rightarm;
    private final ModelRenderer cube_r4;
    private final ModelRenderer rightarm2;
    private final ModelRenderer cube_r5;
    private final ModelRenderer rightarm3;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer leftarm;
    private final ModelRenderer cube_r8;
    private final ModelRenderer leftarm2;
    private final ModelRenderer cube_r9;
    private final ModelRenderer leftarm3;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;

    public CentipedeHelmModel() {
        super(1.0F);
        texWidth = 128;
        texHeight = 128;

        segment = new ModelRenderer(this);
        segment.setPos(0.0F, -1.0F, 0.0F);


        fakehead = new ModelRenderer(this);
        fakehead.setPos(0.0F, -11.0F, 18.0F);
        segment.addChild(fakehead);


        heead = new ModelRenderer(this);
        heead.setPos(0.0F, -5.0F, 5.0F);
        segment.addChild(heead);


        neck = new ModelRenderer(this);
        neck.setPos(0.0F, 4.0F, 6.0F);
        heead.addChild(neck);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -4.0F, -9.0F);
        neck.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.0873F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 41).addBox(-6.0F, -3.0F, -3.0F, 12.0F, 6.0F, 6.0F, 0.0F, false);

        skull = new ModelRenderer(this);
        skull.setPos(0.0F, 0.0F, 0.0F);
        neck.addChild(skull);
        skull.texOffs(56, 16).addBox(2.0F, -3.0F, -14.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        skull.texOffs(50, 32).addBox(-4.0F, -3.0F, -14.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, -5.0F, -14.5F);
        skull.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0873F, 0.0F, 0.0F);
        cube_r2.texOffs(0, 53).addBox(-4.0F, 1.0F, -2.5F, 8.0F, 1.0F, 6.0F, 0.0F, false);
        cube_r2.texOffs(42, 22).addBox(-4.5F, -1.8F, -3.5F, 9.0F, 3.0F, 7.0F, 0.0F, false);

        mouth = new ModelRenderer(this);
        mouth.setPos(0.0F, 0.0F, 0.0F);
        skull.addChild(mouth);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, -5.0F, -14.5F);
        mouth.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0873F, 0.0F, 0.0F);
        cube_r3.texOffs(0, 0).addBox(-2.0F, 2.0F, -1.5F, 4.0F, 1.0F, 5.0F, 0.0F, false);
        cube_r3.texOffs(0, 13).addBox(-3.0F, 3.0F, 0.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);

        righthand = new ModelRenderer(this);
        righthand.setPos(0.0F, 0.0F, 0.0F);
        skull.addChild(righthand);


        lefthand = new ModelRenderer(this);
        lefthand.setPos(0.0F, 0.0F, 0.0F);
        skull.addChild(lefthand);


        rightarm = new ModelRenderer(this);
        rightarm.setPos(0.0F, 0.0F, 0.0F);
        neck.addChild(rightarm);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-5.5F, -3.0F, -12.5F);
        rightarm.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.48F, -0.1309F, -0.3054F);
        cube_r4.texOffs(34, 57).addBox(-1.5F, -1.0F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);

        rightarm2 = new ModelRenderer(this);
        rightarm2.setPos(0.0F, 0.0F, 0.0F);
        rightarm.addChild(rightarm2);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(-4.0F, -1.5F, -17.0F);
        rightarm2.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, -0.3491F, -0.2182F);
        cube_r5.texOffs(56, 32).addBox(-1.0F, -0.7F, -2.0F, 2.0F, 3.0F, 5.0F, 0.0F, false);

        rightarm3 = new ModelRenderer(this);
        rightarm3.setPos(0.0F, 0.0F, 0.0F);
        rightarm2.addChild(rightarm3);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(-2.5F, -2.0F, -19.5F);
        rightarm3.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, -1.0036F, 0.0F);
        cube_r6.texOffs(38, 7).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(-1.5F, -2.5F, -19.5F);
        rightarm3.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 1.0472F, 0.0F);
        cube_r7.texOffs(0, 2).addBox(-0.5F, 0.7F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setPos(0.0F, 0.0F, 0.0F);
        neck.addChild(leftarm);


        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(5.5F, -3.5F, -12.5F);
        leftarm.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.48F, 0.1309F, 0.3054F);
        cube_r8.texOffs(21, 53).addBox(-1.5F, -0.5F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);

        leftarm2 = new ModelRenderer(this);
        leftarm2.setPos(0.0F, 0.0F, 0.0F);
        leftarm.addChild(leftarm2);


        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(4.0F, -1.5F, -17.0F);
        leftarm2.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.3491F, 0.2182F);
        cube_r9.texOffs(0, 22).addBox(-1.0F, -0.7F, -2.0F, 2.0F, 3.0F, 5.0F, 0.0F, false);

        leftarm3 = new ModelRenderer(this);
        leftarm3.setPos(0.0F, 0.0F, 0.0F);
        leftarm2.addChild(leftarm3);


        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(1.5F, -2.5F, -19.5F);
        leftarm3.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, -1.0472F, 0.0F);
        cube_r10.texOffs(0, 0).addBox(-0.5F, 0.7F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(2.5F, -2.0F, -19.5F);
        leftarm3.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 1.0036F, 0.0F);
        cube_r11.texOffs(0, 30).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);

        head.addChild(segment);
    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        segment.zRot = head.zRot;
        segment.xRot = head.xRot;
        segment.yRot = head.yRot;

        segment.y = head.y-1;
        segment.z = head.z;

        segment.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

