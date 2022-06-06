package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.GaraGogaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GaraGogaModel<T extends GaraGogaEntity> extends EntityModel<T> {

    private final ModelRenderer redfish;
    private final ModelRenderer mainbody;
    private final ModelRenderer neckbase;
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer leftflap;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer rightflap;
    private final ModelRenderer cube_r6;
    private final ModelRenderer horns;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer tailbase;
    private final ModelRenderer cube_r9;
    private final ModelRenderer tailmid;
    private final ModelRenderer tailend;
    private final ModelRenderer wings;
    private final ModelRenderer frolef;
    private final ModelRenderer baclef;
    private final ModelRenderer bacrig;
    private final ModelRenderer frorig;

    public GaraGogaModel() {
        texWidth = 128;
        texHeight = 128;

        redfish = new ModelRenderer(this);
        redfish.setPos(0.0F, 20.0F, -1.0F);


        mainbody = new ModelRenderer(this);
        mainbody.setPos(-1.5F, -3.9219F, -15.6915F);
        redfish.addChild(mainbody);
        mainbody.texOffs(0, 0).addBox(-1.0F, -0.2755F, 8.7976F, 6.0F, 9.0F, 13.0F, 0.0F, false);

        neckbase = new ModelRenderer(this);
        neckbase.setPos(2.0F, 3.5F, 9.5F);
        mainbody.addChild(neckbase);
        neckbase.texOffs(0, 22).addBox(-2.5F, -3.5F, -8.5F, 5.0F, 7.0F, 11.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, -0.9468F, -8.3645F);
        neckbase.addChild(head);
        head.texOffs(50, 8).addBox(-1.5F, -1.6313F, -7.4439F, 3.0F, 2.0F, 5.0F, 0.0F, false);
        head.texOffs(30, 49).addBox(-1.5F, 0.3687F, -7.4439F, 3.0F, 1.0F, 5.0F, 0.0F, false);
        head.texOffs(0, 2).addBox(1.0F, -1.1313F, -5.9439F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head.texOffs(0, 0).addBox(-2.0F, -1.1313F, -5.9439F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 2.2939F, -0.4732F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.1745F, 0.0F, 0.0F);
        cube_r1.texOffs(47, 33).addBox(-1.5F, -2.0F, -3.5F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 1.0911F, -4.2881F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.3054F, 0.0F, 0.0F);
        cube_r2.texOffs(50, 25).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, -1.1313F, -0.4439F);
        head.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.1309F, 0.0F, 0.0F);
        cube_r3.texOffs(41, 16).addBox(-2.0F, -1.5F, -3.0F, 4.0F, 4.0F, 5.0F, 0.0F, false);
        cube_r3.texOffs(0, 9).addBox(-1.0F, -1.5F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

        leftflap = new ModelRenderer(this);
        leftflap.setPos(2.017F, -0.154F, -3.7224F);
        head.addChild(leftflap);
        setRotationAngle(leftflap, 0.0F, 0.0436F, 0.0F);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-0.017F, 0.5228F, 2.2785F);
        leftflap.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.1745F, 0.3054F, 0.0F);
        cube_r4.texOffs(0, 27).addBox(-0.4F, 2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(0.0522F, 1.0152F, 2.1656F);
        leftflap.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.1745F, 0.3054F, 0.0F);
        cube_r5.texOffs(22, 49).addBox(-0.5F, -1.5F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);

        rightflap = new ModelRenderer(this);
        rightflap.setPos(-2.017F, -0.154F, -3.7224F);
        head.addChild(rightflap);
        setRotationAngle(rightflap, 0.0F, -0.0436F, 0.0F);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.017F, 0.5228F, 2.2785F);
        rightflap.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.1745F, -0.3054F, 0.0F);
        cube_r6.texOffs(0, 22).addBox(-0.6F, 2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r6.texOffs(14, 46).addBox(-0.6F, -1.0F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);

        horns = new ModelRenderer(this);
        horns.setPos(-2.0F, -2.5532F, -1.1355F);
        head.addChild(horns);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(0.0F, 0.0F, 0.0F);
        horns.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.2182F, -0.1745F, 0.0F);
        cube_r7.texOffs(45, 0).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(4.0F, 0.0F, 0.0F);
        horns.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.2182F, 0.1745F, 0.0F);
        cube_r8.texOffs(43, 42).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

        tailbase = new ModelRenderer(this);
        tailbase.setPos(2.0F, 3.8035F, 21.9088F);
        mainbody.addChild(tailbase);
        tailbase.texOffs(22, 31).addBox(-2.0F, -3.935F, -2.6155F, 4.0F, 8.0F, 10.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(0.0F, 14.1041F, 36.4525F);
        tailbase.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0873F, 0.0F, 0.0F);
        cube_r9.texOffs(0, 29).addBox(0.0F, -14.0F, -37.5F, 0.0F, 6.0F, 11.0F, 0.0F, false);

        tailmid = new ModelRenderer(this);
        tailmid.setPos(0.0F, -1.3959F, 6.9525F);
        tailbase.addChild(tailmid);
        tailmid.texOffs(0, 0).addBox(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 4.0F, 0.0F, false);

        tailend = new ModelRenderer(this);
        tailend.setPos(0.0F, 0.0F, 3.5F);
        tailmid.addChild(tailend);
        tailend.texOffs(0, 39).addBox(0.0F, -5.5F, -0.5F, 0.0F, 9.0F, 7.0F, 0.0F, false);

        wings = new ModelRenderer(this);
        wings.setPos(0.0F, 0.0F, 0.0F);
        mainbody.addChild(wings);


        frolef = new ModelRenderer(this);
        frolef.setPos(5.0F, 2.0F, 9.5F);
        wings.addChild(frolef);
        frolef.texOffs(31, 9).addBox(0.0F, 0.0F, -3.5F, 6.0F, 0.0F, 7.0F, 0.0F, false);

        baclef = new ModelRenderer(this);
        baclef.setPos(5.0F, 0.0F, 21.5F);
        wings.addChild(baclef);
        baclef.texOffs(12, 22).addBox(0.0F, 0.0F, -4.5F, 10.0F, 0.0F, 9.0F, 0.0F, false);

        bacrig = new ModelRenderer(this);
        bacrig.setPos(-1.0F, 0.0F, 21.5F);
        wings.addChild(bacrig);
        bacrig.texOffs(16, 0).addBox(-10.0F, 0.0F, -4.5F, 10.0F, 0.0F, 9.0F, 0.0F, false);

        frorig = new ModelRenderer(this);
        frorig.setPos(-1.0F, 2.0F, 9.5F);
        wings.addChild(frorig);
        frorig.texOffs(33, 31).addBox(-6.0F, 0.0F, -3.5F, 6.0F, 0.0F, 7.0F, 0.0F, false);
    }



    public void setupAnim(GaraGogaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

        //this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = -netHeadYaw * ((float)Math.PI / 180F);
        //this.neckbase.xRot = headPitch * ((float)Math.PI / 180F);
        this.neckbase.yRot = -netHeadYaw * ((float)Math.PI / 180F);
        /*this.dbody.xRot = -headPitch * ((float)Math.PI / 360F);
        this.dbody.yRot = -netHeadYaw * ((float)Math.PI / 360F);*/

        //this.tailbase.xRot = headPitch * ((float)Math.PI / 180F);
        this.tailbase.yRot = netHeadYaw * ((float)Math.PI / 180F);
        //this.tailmid.xRot = headPitch * ((float)Math.PI / 180F);
        this.tailmid.yRot = netHeadYaw * ((float)Math.PI / 180F);
        //this.tailend.xRot = headPitch * ((float)Math.PI / 180F);
        this.tailend.yRot = netHeadYaw * ((float)Math.PI / 180F);

        this.redfish.xRot = entity.xRot * ((float)Math.PI / 180F);



        this.frorig.zRot = -entity.getWingDegree() * ((float)Math.PI / 180F);
        this.frolef.zRot = entity.getWingDegree() * ((float)Math.PI / 180F);

        this.bacrig.zRot = entity.getWingDegree() * ((float)Math.PI / 180F);
        this.baclef.zRot = -entity.getWingDegree() * ((float)Math.PI / 180F);

    }


    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        redfish.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

