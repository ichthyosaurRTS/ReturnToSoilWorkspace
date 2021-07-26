package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.BaruGaruSegmentEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import java.util.logging.Logger;

public class BaruGaruSegmentModel<T extends BaruGaruSegmentEntity> extends EntityModel<T> {
    Logger logger = Logger.getLogger("logger");;

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

    public BaruGaruSegmentModel() {
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
        cube_r1.texOffs(4, 22).addBox(-0.5F, -0.3164F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        legleft.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7418F);
        cube_r2.texOffs(8, 7).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        legright = new ModelRenderer(this);
        legright.setPos(-6.0F, -1.0F, -6.0F);
        body.addChild(legright);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-3.5F, -2.5F, 0.0F);
        legright.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 0.3491F);
        cube_r3.texOffs(0, 22).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(1.0F, 0.0F, 0.0F);
        legright.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7418F);
        cube_r4.texOffs(0, 7).addBox(-2.0F, -5.8F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

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
        cube_r6.texOffs(0, 0).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
    }


    @Override
    public void setupAnim(BaruGaruSegmentEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        float headX = headPitch * ((float)Math.PI / 180F); //actually refers to segments up down rot
        this.fakehead.xRot = headX; //headX is radians, headPitch is degrees
        //z starts 7 back (z=7) at 180 degrees, the head will be brought forward by (180/20 =) 9; otherwise sits into child on upward slope
        if (headPitch<0) fakehead.z = 7 + (headPitch/10);  //apparently negative head pitch is looking up, and positive z is forwards
        if (headPitch>0) fakehead.z = 7 - (headPitch/7);  //these 2 just move the segment forward a little on slopes, otherwise they're embedded in blocks
        else fakehead.z = 7; //remember headPitch is a negative value on the way up!

        if (headPitch<0) fakehead.y =  -10+(headPitch/40); //move it up a little depending on the pitch
        else if (headPitch>0) fakehead.y =  -10+(headPitch/20);
        else fakehead.y = -10;

        //logger.info("headx"+headX);
        //logger.info("headpitch"+headPitch);

        this.legleft.yRot = 0F;
        this.legright.yRot = 0F;

        float f4 =(float) 0.5* -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount*10;
        float f3 =(float) 0.5* -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount*10;
        this.legright.yRot += f4;
        this.legleft.yRot += f3;

        this.shell.zRot = f4/8;

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        segment.render(matrixStack, buffer, packedLight, packedOverlay); //this will render all the children too
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
