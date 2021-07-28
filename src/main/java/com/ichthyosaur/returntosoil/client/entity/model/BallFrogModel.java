package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BallFrogModel<T extends BallFrogEntity> extends EntityModel<BallFrogEntity> {
    private final ModelRenderer all;
    private final ModelRenderer body;
    private final ModelRenderer legs;
    private final ModelRenderer rightleg;
    private final ModelRenderer rightleg1;
    private final ModelRenderer leftleg;
    private final ModelRenderer leftleg1;
    private final ModelRenderer rightfront;
    private final ModelRenderer rightfront1;
    private final ModelRenderer leftfront;
    private final ModelRenderer leftfront1;
    private final ModelRenderer tail;
    private final ModelRenderer tail2;
    private final ModelRenderer head;
    private final ModelRenderer sac;
    private final ModelRenderer skull;

    public BallFrogModel() {
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 24.0F, 0.0F);


        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(body);
        body.texOffs(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(legs);


        rightleg = new ModelRenderer(this);
        rightleg.setPos(-5.0F, 2.0F, 3.0F);
        legs.addChild(rightleg);
        setRotationAngle(rightleg, 0.0F, 0.3927F, 0.0F);


        rightleg1 = new ModelRenderer(this);
        rightleg1.setPos(1.0F, -3.0F, 1.0F);
        rightleg.addChild(rightleg1);
        rightleg1.texOffs(16, 36).addBox(-1.0F, -0.9F, -3.1F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(5.0F, -1.0F, 3.0F);
        legs.addChild(leftleg);
        setRotationAngle(leftleg, 0.0F, -0.3927F, 0.0F);


        leftleg1 = new ModelRenderer(this);
        leftleg1.setPos(-1.0F, 0.0F, 1.0F);
        leftleg.addChild(leftleg1);
        leftleg1.texOffs(36, 4).addBox(-1.0F, -0.9F, -3.1F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        rightfront = new ModelRenderer(this);
        rightfront.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(rightfront);


        rightfront1 = new ModelRenderer(this);
        rightfront1.setPos(-4.0F, -1.0F, -2.0F);
        rightfront.addChild(rightfront1);
        rightfront1.texOffs(11, 45).addBox(-1.5F, 0.1F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        leftfront = new ModelRenderer(this);
        leftfront.setPos(0.0F, 0.0F, 0.0F);
        legs.addChild(leftfront);


        leftfront1 = new ModelRenderer(this);
        leftfront1.setPos(4.0F, -1.0F, -2.0F);
        leftfront.addChild(leftfront1);
        leftfront1.texOffs(0, 44).addBox(-0.5F, 0.1F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(0.0F, -2.0F, 4.0F);
        body.addChild(tail);
        tail.texOffs(10, 35).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, false);
        tail.texOffs(38, 10).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        tail2 = new ModelRenderer(this);
        tail2.setPos(0.0F, 0.0F, 3.0F);
        tail.addChild(tail2);
        tail2.texOffs(0, 38).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        tail2.texOffs(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(head);


        sac = new ModelRenderer(this);
        sac.setPos(0.0F, -13.0F, -4.0F);
        head.addChild(sac);
        sac.texOffs(0, 17).addBox(-2.5F, 7.5F, -2.7802F, 5.0F, 5.0F, 4.0F, 0.0F, false);

        skull = new ModelRenderer(this);
        skull.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(skull);
        skull.texOffs(28, 37).addBox(-1.5F, -7.0F, -6.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
        skull.texOffs(35, 0).addBox(-2.0F, -6.8F, -5.7F, 4.0F, 1.0F, 1.0F, 0.0F, false);
    }


    @Override
    public void setupAnim(BallFrogEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        float rad = (float) Math.PI/180;
        float mod = (float) Math.sin(entity.tailTimer)/3;
        if (!entity.getSwimmingAnim()) {
            entity.tailTimer = entity.tailTimer<3.14 ? entity.tailTimer+=0.015 : -3.14F;
            this.all.xRot = 0;
            this.head.yRot = netHeadYaw/200;
            this.rightleg1.xRot = 0;
            this.leftleg1.xRot = 0;
            this.leftfront1.xRot = 0;
            this.rightfront1.xRot = 0;
            this.rightleg1.xRot = (float) Math.sin(limbSwing*1)*limbSwingAmount;
            this.leftleg1.xRot = (float) Math.sin(limbSwing*1)*limbSwingAmount;
            this.rightfront1.xRot = (float) Math.sin(limbSwing*-1)*limbSwingAmount;
            this.leftfront1.xRot = (float) Math.sin(limbSwing*-1)*limbSwingAmount;
            this.sac.xRot = 0;
            this.sac.xRot = mod/10;
            this.sac.zRot = 0;
            this.all.yRot = 0;

        } //needs sac sway, breathing
        if (entity.getSwimmingAnim()) { //need passive floaty movement here

            entity.tailTimer = entity.tailTimer<3.14 ? entity.tailTimer+=0.008 : -3.14F;
            this.sac.xRot = 0;
            this.sac.zRot = 0;
            this.sac.zRot = (float) Math.sin(entity.tailTimer+1)/20;
            this.sac.y = -13F;
            this.sac.y = -13F+(float)Math.sin(entity.tailTimer+1)/10;
            this.all.yRot = netHeadYaw/50;
            this.all.xRot = headPitch/100;
            this.head.yRot = 0;
            this.rightleg1.xRot = 150*rad+mod; // + swinging mod
            this.leftleg1.xRot = 150*rad+mod;
            this.leftfront1.xRot = 150*rad+mod;
            this.rightfront1.xRot = 150*rad+mod;
            this.tail.yRot = mod;
            this.tail2.yRot = (float) (Math.sin(entity.tailTimer-1)/3);
            this.all.xRot += mod/10;
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
