package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.Entity.NomadSnailEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;

public class NomadSnailModel <T extends NomadSnailEntity> extends EntityModel<T> {

    private float breathing = 0.009F;
    private float breathing2 = -0.004F;
    private boolean increasing;
    private boolean increasing2;

    private final ModelRenderer all;
    private final ModelRenderer shell;
    private final ModelRenderer shellbase;
    private final ModelRenderer butt_r1;
    private final ModelRenderer rightbottom_r1;
    private final ModelRenderer leftbottom_r1;
    private final ModelRenderer shellbasetilted_r1;
    private final ModelRenderer snail;
    private final ModelRenderer foot;
    private final ModelRenderer lowerneck;
    private final ModelRenderer lowerneck_r1;
    private final ModelRenderer upperneck;
    private final ModelRenderer head_r1;
    private final ModelRenderer upperneck_r1;
    private final ModelRenderer antenna;
    private final ModelRenderer rightant;
    private final ModelRenderer rightantbase;
    private final ModelRenderer rightantbase_r1;
    private final ModelRenderer rightantmid;
    private final ModelRenderer rightantmid_r1;
    private final ModelRenderer rightantend;
    private final ModelRenderer rightantend_r1;
    private final ModelRenderer leftant;
    private final ModelRenderer leftantbase;
    private final ModelRenderer leftantbase_r1;
    private final ModelRenderer leftantmid;
    private final ModelRenderer leftantmid_r1;
    private final ModelRenderer leftantend;
    private final ModelRenderer leftantend_r1;






    public NomadSnailModel() {
        texWidth = 128;
        texHeight = 128;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 24.0F, 0.0F);


        shell = new ModelRenderer(this);
        shell.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(shell);


        shellbase = new ModelRenderer(this);
        shellbase.setPos(0.0F, 0.0F, 0.0F);
        shell.addChild(shellbase);


        butt_r1 = new ModelRenderer(this);
        butt_r1.setPos(0.5F, -5.5F, 7.0F);
        shellbase.addChild(butt_r1);
        setRotationAngle(butt_r1, -0.2182F, 0.3054F, 0.6981F);
        butt_r1.texOffs(34, 37).addBox(-3.5F, -3.5F, -3.0F, 7.0F, 7.0F, 7.0F, 0.0F, false);

        rightbottom_r1 = new ModelRenderer(this);
        rightbottom_r1.setPos(-3.0F, -3.0F, 2.5F);
        shellbase.addChild(rightbottom_r1);
        setRotationAngle(rightbottom_r1, 0.0F, 0.0F, 0.2182F);
        rightbottom_r1.texOffs(0, 31).addBox(-2.0F, -3.0F, -5.5F, 6.0F, 6.0F, 11.0F, 0.0F, false);

        leftbottom_r1 = new ModelRenderer(this);
        leftbottom_r1.setPos(3.0F, -3.0F, 2.5F);
        shellbase.addChild(leftbottom_r1);
        setRotationAngle(leftbottom_r1, 0.0F, 0.0F, -0.2618F);
        leftbottom_r1.texOffs(33, 20).addBox(-4.0F, -3.0F, -5.5F, 6.0F, 6.0F, 11.0F, 0.0F, false);

        shellbasetilted_r1 = new ModelRenderer(this);
        shellbasetilted_r1.setPos(0.0F, -6.5F, 3.0F);
        shellbase.addChild(shellbasetilted_r1);
        setRotationAngle(shellbasetilted_r1, 0.0873F, 0.0873F, -0.7854F);
        shellbasetilted_r1.texOffs(0, 0).addBox(-4.0F, -3.5F, -7.0F, 8.0F, 8.0F, 11.0F, 0.0F, false);

        snail = new ModelRenderer(this);
        snail.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(snail);


        foot = new ModelRenderer(this);
        foot.setPos(0.0F, 0.0F, 0.0F);
        snail.addChild(foot);
        foot.texOffs(0, 19).addBox(-6.0F, -1.0F, -4.0F, 12.0F, 2.0F, 10.0F, 0.0F, false);

        lowerneck = new ModelRenderer(this);
        lowerneck.setPos(0.0F, 0.0F, 0.0F);
        snail.addChild(lowerneck);


        lowerneck_r1 = new ModelRenderer(this);
        lowerneck_r1.setPos(-0.5F, -2.5F, -4.0F);
        lowerneck.addChild(lowerneck_r1);
        setRotationAngle(lowerneck_r1, -0.3491F, 0.0F, 0.0F);
        lowerneck_r1.texOffs(27, 0).addBox(-3.0F, -1.5F, -3.0F, 7.0F, 5.0F, 5.0F, 0.0F, false);

        upperneck = new ModelRenderer(this);
        upperneck.setPos(0.0F, 0.0F, 0.0F);
        lowerneck.addChild(upperneck);


        head_r1 = new ModelRenderer(this);
        head_r1.setPos(0.0F, -5.0F, -11.0F);
        upperneck.addChild(head_r1);
        setRotationAngle(head_r1, -0.3054F, 0.0F, 0.0F);
        head_r1.texOffs(46, 0).addBox(-3.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

        upperneck_r1 = new ModelRenderer(this);
        upperneck_r1.setPos(0.0F, -3.5F, -8.0F);
        upperneck.addChild(upperneck_r1);
        setRotationAngle(upperneck_r1, 0.6545F, 0.0F, 0.0F);
        upperneck_r1.texOffs(47, 6).addBox(-2.0F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

        antenna = new ModelRenderer(this);
        antenna.setPos(0.0F, 0.0F, 0.0F);
        upperneck.addChild(antenna);


        rightant = new ModelRenderer(this);
        rightant.setPos(-3.0F, -4.0F, -11.0F);
        antenna.addChild(rightant);


        rightantbase = new ModelRenderer(this);
        rightantbase.setPos(0.25F, -0.75F, -0.75F);
        rightant.addChild(rightantbase);


        rightantbase_r1 = new ModelRenderer(this);
        rightantbase_r1.setPos(-0.75F, -0.75F, 0.75F);
        rightantbase.addChild(rightantbase_r1);
        setRotationAngle(rightantbase_r1, -0.3927F, 0.0F, -0.2618F);
        rightantbase_r1.texOffs(0, 0).addBox(-0.5F, -4.5F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        rightantmid = new ModelRenderer(this);
        rightantmid.setPos(-1.25F, -4.25F, 1.75F);
        rightantbase.addChild(rightantmid);


        rightantmid_r1 = new ModelRenderer(this);
        rightantmid_r1.setPos(-0.5F, 0.0F, 0.0F);
        rightantmid.addChild(rightantmid_r1);
        setRotationAngle(rightantmid_r1, 0.3054F, 0.0F, 0.0F);
        rightantmid_r1.texOffs(0, 48).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

        rightantend = new ModelRenderer(this);
        rightantend.setPos(0.0F, -2.0F, 5.0F);
        rightantmid.addChild(rightantend);


        rightantend_r1 = new ModelRenderer(this);
        rightantend_r1.setPos(-0.5F, 0.0F, -0.5F);
        rightantend.addChild(rightantend_r1);
        setRotationAngle(rightantend_r1, 0.1309F, 0.0F, 0.0F);
        rightantend_r1.texOffs(22, 48).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

        leftant = new ModelRenderer(this);
        leftant.setPos(3.0F, -5.0F, -11.0F);
        antenna.addChild(leftant);


        leftantbase = new ModelRenderer(this);
        leftantbase.setPos(0.0F, 0.0F, 0.0F);
        leftant.addChild(leftantbase);


        leftantbase_r1 = new ModelRenderer(this);
        leftantbase_r1.setPos(0.5F, -0.4779F, -0.4658F);
        leftantbase.addChild(leftantbase_r1);
        setRotationAngle(leftantbase_r1, 1.1781F, 0.0F, 0.2618F);
        leftantbase_r1.texOffs(34, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

        leftantmid = new ModelRenderer(this);
        leftantmid.setPos(1.25F, -3.9511F, 1.4306F);
        leftantbase.addChild(leftantmid);


        leftantmid_r1 = new ModelRenderer(this);
        leftantmid_r1.setPos(0.25F, -0.9511F, 2.4306F);
        leftantmid.addChild(leftantmid_r1);
        setRotationAngle(leftantmid_r1, 0.3054F, 0.0F, 0.0F);
        leftantmid_r1.texOffs(23, 31).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

        leftantend = new ModelRenderer(this);
        leftantend.setPos(-0.25F, -2.0489F, 4.5694F);
        leftantmid.addChild(leftantend);


        leftantend_r1 = new ModelRenderer(this);
        leftantend_r1.setPos(-8.5F, 0.0F, -0.5F);
        leftantend.addChild(leftantend_r1);
        setRotationAngle(leftantend_r1, 0.1309F, 0.0F, 0.0F);
        leftantend_r1.texOffs(10, 48).addBox(8.5F, -0.5F, 0.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);
    }

    public void setupAnim(NomadSnailEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.lowerneck.yRot = netHeadYaw * ((float)Math.PI / 3000F);
        this.upperneck.yRot = netHeadYaw * ((float)Math.PI / 1000F);
        this.upperneck.xRot = netHeadYaw * ((float)Math.PI / 5000F);
        //this.head.xRot = netHeadYaw * ((float)Math.PI / 2000F);

        if (this.increasing) {this.rightant.xRot += 0.0005; this.breathing+=0.0001;
            this.rightantmid.xRot += 0.0005; this.rightantend.xRot += 0.0005;}
        else {this.rightant.xRot -= 0.0005; this.breathing-=0.0001;
        this.rightantmid.xRot -= 0.0005; this.rightantend.xRot -= 0.0005;}

        if (this.increasing2) {this.leftant.xRot += 0.0005; this.breathing2+=0.0001;
        this.leftantmid.xRot += 0.0005;this.leftantend.xRot += 0.0005;}
        else {this.leftant.xRot -= 0.0005; this.breathing2-=0.0001;
            this.leftantmid.xRot -= 0.0005;this.leftantend.xRot -= 0.0005;}

        if (this.breathing>0.01) {this.increasing = false;}
        else if (this.breathing<-0.01) {this.increasing = true;}
        if (this.breathing2>0.01) {this.increasing2 = false;}
        else if (this.breathing2<-0.01) {this.increasing2 = true;}

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
