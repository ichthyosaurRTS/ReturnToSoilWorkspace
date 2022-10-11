package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.CentipedeEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CentipedeModel<T extends CentipedeEntity> extends EntityModel<T> {

    public static final Logger LOGGER = LogManager.getLogger();

    private final ModelRenderer segment;
    private final ModelRenderer fakehead;
    private final ModelRenderer body;
    private final ModelRenderer flesh;
    private final ModelRenderer legleft;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer legright;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer shell;
    private final ModelRenderer cube_r5;
    private final ModelRenderer gem;
    private final ModelRenderer cube_r6;
    private final ModelRenderer head;
    private final ModelRenderer neck;
    private final ModelRenderer cube_r7;
    private final ModelRenderer legleftfront;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer legrightfront;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer skull;
    private final ModelRenderer cube_r12;
    private final ModelRenderer mouth;
    private final ModelRenderer cube_r13;
    private final ModelRenderer righthand;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer lefthand;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer rightarm;
    private final ModelRenderer cube_r18;
    private final ModelRenderer rightarm2;
    private final ModelRenderer cube_r19;
    private final ModelRenderer rightarm3;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer leftarm;
    private final ModelRenderer cube_r22;
    private final ModelRenderer leftarm2;
    private final ModelRenderer cube_r23;
    private final ModelRenderer leftarm3;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;

    public CentipedeModel() {
        texWidth = 128;
        texHeight = 128;

        segment = new ModelRenderer(this);
        segment.setPos(0.0F, 24.0F, 0.0F);


        fakehead = new ModelRenderer(this);
        fakehead.setPos(0.0F, -10.0F, 7.0F);
        segment.addChild(fakehead);


        body = new ModelRenderer(this);
        body.setPos(0.0F, 10.0F, 0.0F);
        fakehead.addChild(body);


        flesh = new ModelRenderer(this);
        flesh.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(flesh);
        flesh.texOffs(38, 0).addBox(-6.0F, -4.0F, -13.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);

        legleft = new ModelRenderer(this);
        legleft.setPos(6.0F, -1.0F, -6.0F);
        body.addChild(legleft);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(3.0F, -3.0F, 1.0F);
        legleft.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -0.3491F);
        cube_r1.texOffs(0, 41).addBox(-0.5F, -0.3164F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        legleft.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7418F);
        cube_r2.texOffs(38, 0).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        legright = new ModelRenderer(this);
        legright.setPos(-6.0F, -1.0F, -6.0F);
        body.addChild(legright);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-3.5F, -2.5F, 0.0F);
        legright.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 0.3491F);
        cube_r3.texOffs(30, 41).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(1.0F, 0.0F, 0.0F);
        legright.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7418F);
        cube_r4.texOffs(42, 29).addBox(-2.0F, -5.8F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        shell = new ModelRenderer(this);
        shell.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(shell);
        shell.texOffs(0, 0).addBox(-5.0F, -4.9F, -16.0F, 10.0F, 4.0F, 18.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(0.0F, -4.5F, -7.0F);
        shell.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0873F, 0.0F, 0.0F);
        cube_r5.texOffs(0, 22).addBox(-7.0F, -2.5F, -7.0F, 14.0F, 5.0F, 14.0F, 0.0F, false);

        gem = new ModelRenderer(this);
        gem.setPos(0.0F, -6.5F, -7.0F);
        body.addChild(gem);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.0F, -1.0F, 0.0F);
        gem.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.1309F, 0.0F, 0.0F);
        cube_r6.texOffs(0, 6).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, -4.0F, -6.0F);
        segment.addChild(head);


        neck = new ModelRenderer(this);
        neck.setPos(1.0F, 15.0F, -3.0F);
        head.addChild(neck);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(-1.0F, -15.0F, 0.0F);
        neck.addChild(cube_r7);
        setRotationAngle(cube_r7, -0.0873F, 0.0F, 0.0F);
        cube_r7.texOffs(0, 41).addBox(-6.0F, -3.0F, -3.0F, 12.0F, 6.0F, 6.0F, 0.0F, false);

        legleftfront = new ModelRenderer(this);
        legleftfront.setPos(4.0F, -12.0F, 1.0F);
        neck.addChild(legleftfront);


        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(3.0F, -3.0F, 1.0F);
        legleftfront.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, -0.3491F);
        cube_r8.texOffs(0, 41).addBox(-0.5F, -0.3164F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(0.0F, 0.0F, 0.0F);
        legleftfront.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.0F, 0.7418F);
        cube_r9.texOffs(38, 0).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        legrightfront = new ModelRenderer(this);
        legrightfront.setPos(-6.0F, -12.0F, 1.0F);
        neck.addChild(legrightfront);


        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(-3.5F, -2.5F, 0.0F);
        legrightfront.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, 0.3491F);
        cube_r10.texOffs(30, 41).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(1.0F, 0.0F, 0.0F);
        legrightfront.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, -0.7418F);
        cube_r11.texOffs(42, 29).addBox(-2.0F, -5.8F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        skull = new ModelRenderer(this);
        skull.setPos(-1.0F, -16.0F, -1.0F);
        neck.addChild(skull);
        skull.texOffs(38, 7).addBox(2.0F, 2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        skull.texOffs(38, 7).addBox(-4.0F, 2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(0.0F, 0.0F, -4.5F);
        skull.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0873F, 0.0F, 0.0F);
        cube_r12.texOffs(42, 22).addBox(-4.0F, 1.0F, -2.5F, 8.0F, 1.0F, 6.0F, 0.0F, false);
        cube_r12.texOffs(36, 41).addBox(-4.5F, -1.8F, -3.5F, 9.0F, 3.0F, 7.0F, 0.0F, false);

        mouth = new ModelRenderer(this);
        mouth.setPos(0.0F, 5.0F, 10.0F);
        skull.addChild(mouth);


        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(0.0F, -5.0F, -14.5F);
        mouth.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.0873F, 0.0F, 0.0F);
        cube_r13.texOffs(0, 0).addBox(-2.0F, 2.0F, -1.5F, 4.0F, 1.0F, 5.0F, 0.0F, false);
        cube_r13.texOffs(0, 13).addBox(-3.0F, 3.0F, 0.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);

        righthand = new ModelRenderer(this);
        righthand.setPos(0.0F, 5.0F, 10.0F);
        skull.addChild(righthand);


        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(-1.5F, -2.0F, -16.0F);
        righthand.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.0F, -1.1781F, 0.0F);
        cube_r14.texOffs(12, 6).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(-2.5F, -2.0F, -15.0F);
        righthand.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, -0.2182F, -0.3491F);
        cube_r15.texOffs(5, 32).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        lefthand = new ModelRenderer(this);
        lefthand.setPos(0.0F, 5.0F, 10.0F);
        skull.addChild(lefthand);


        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(2.5F, -2.0F, -15.0F);
        lefthand.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.0F, 0.2182F, 0.3491F);
        cube_r16.texOffs(5, 32).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(1.5F, -2.0F, -16.0F);
        lefthand.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0F, 1.1781F, 0.0F);
        cube_r17.texOffs(12, 6).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setPos(-1.0F, -11.0F, 9.0F);
        neck.addChild(rightarm);


        cube_r18 = new ModelRenderer(this);
        cube_r18.setPos(-5.5F, -3.0F, -12.5F);
        rightarm.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.48F, -0.1309F, -0.3054F);
        cube_r18.texOffs(29, 51).addBox(-1.5F, -2.0F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);

        rightarm2 = new ModelRenderer(this);
        rightarm2.setPos(0.0F, 0.0F, 0.0F);
        rightarm.addChild(rightarm2);


        cube_r19 = new ModelRenderer(this);
        cube_r19.setPos(-4.0F, -1.5F, -17.0F);
        rightarm2.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.0F, -0.3491F, -0.2182F);
        cube_r19.texOffs(0, 22).addBox(-1.0F, -1.7F, -2.0F, 2.0F, 3.0F, 5.0F, 0.0F, false);

        rightarm3 = new ModelRenderer(this);
        rightarm3.setPos(0.0F, 0.0F, 0.0F);
        rightarm2.addChild(rightarm3);


        cube_r20 = new ModelRenderer(this);
        cube_r20.setPos(-2.5F, -2.0F, -19.5F);
        rightarm3.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.0F, -1.0036F, 0.0F);
        cube_r20.texOffs(0, 30).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);

        cube_r21 = new ModelRenderer(this);
        cube_r21.setPos(-1.5F, -2.5F, -19.5F);
        rightarm3.addChild(cube_r21);
        setRotationAngle(cube_r21, 0.0F, 1.0472F, 0.0F);
        cube_r21.texOffs(0, 0).addBox(-0.5F, -0.3F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setPos(-1.0F, -11.0F, 9.0F);
        neck.addChild(leftarm);


        cube_r22 = new ModelRenderer(this);
        cube_r22.setPos(5.5F, -3.5F, -12.5F);
        leftarm.addChild(cube_r22);
        setRotationAngle(cube_r22, 0.48F, 0.1309F, 0.3054F);
        cube_r22.texOffs(29, 51).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);

        leftarm2 = new ModelRenderer(this);
        leftarm2.setPos(0.0F, 0.0F, 0.0F);
        leftarm.addChild(leftarm2);


        cube_r23 = new ModelRenderer(this);
        cube_r23.setPos(4.0F, -1.5F, -17.0F);
        leftarm2.addChild(cube_r23);
        setRotationAngle(cube_r23, 0.0F, 0.3491F, 0.2182F);
        cube_r23.texOffs(0, 22).addBox(-1.0F, -1.7F, -2.0F, 2.0F, 3.0F, 5.0F, 0.0F, false);

        leftarm3 = new ModelRenderer(this);
        leftarm3.setPos(0.0F, 0.0F, 0.0F);
        leftarm2.addChild(leftarm3);


        cube_r24 = new ModelRenderer(this);
        cube_r24.setPos(1.5F, -2.5F, -19.5F);
        leftarm3.addChild(cube_r24);
        setRotationAngle(cube_r24, 0.0F, -1.0472F, 0.0F);
        cube_r24.texOffs(0, 0).addBox(-0.5F, -0.3F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r25 = new ModelRenderer(this);
        cube_r25.setPos(2.5F, -2.0F, -19.5F);
        leftarm3.addChild(cube_r25);
        setRotationAngle(cube_r25, 0.0F, 1.0036F, 0.0F);
        cube_r25.texOffs(0, 30).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);
    }



    public void setupAnim(CentipedeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.head.yRot = netHeadYaw/4 * ((float)Math.PI / 180F);
        this.skull.yRot = netHeadYaw/8 * ((float)Math.PI / 180F);

        this.legleft.yRot = 0;
        this.legleftfront.yRot = 0;
        this.legright.yRot = 0;
        this.legrightfront.yRot = 0;

        float f4 = (float) 0.5* -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount*10;
        float f3 = (float) 0.5* -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount*10;
        this.legleft.yRot += f4;//* ((float)Math.PI / 1000F);
        this.legright.yRot += f3;
        this.legleftfront.yRot -= f4;
        this.legrightfront.yRot -= f3;
    }


    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        segment.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

