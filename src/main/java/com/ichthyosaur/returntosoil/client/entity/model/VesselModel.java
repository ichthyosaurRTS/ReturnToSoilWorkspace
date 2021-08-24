package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.TallSnailEntity;
import com.ichthyosaur.returntosoil.common.entity.VesselEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class VesselModel<T extends VesselEntity> extends EntityModel<VesselEntity> {

    private final ModelRenderer all;
    private final ModelRenderer body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer head;
    private final ModelRenderer cube_r2;
    private final ModelRenderer legs;
    private final ModelRenderer rfront;
    private final ModelRenderer lfront;
    private final ModelRenderer rmid;
    private final ModelRenderer lmid;
    private final ModelRenderer rback;
    private final ModelRenderer lback;

    public VesselModel() {
        texWidth = 32;
        texHeight = 32;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 22.0F, -3.0F);


        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(body);
        body.texOffs(13, 14).addBox(-1.5F, -1.0F, 5.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -0.5F, 3.5F);
        body.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.0873F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 0).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 1.0F);
        body.addChild(head);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, -1.0F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0873F, 0.0F, 0.0F);
        cube_r2.texOffs(0, 9).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(legs);


        rfront = new ModelRenderer(this);
        rfront.setPos(-2.5F, 0.0F, 2.5F);
        legs.addChild(rfront);
        rfront.texOffs(0, 17).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        lfront = new ModelRenderer(this);
        lfront.setPos(2.5F, 0.0F, 2.5F);
        legs.addChild(lfront);
        lfront.texOffs(15, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        rmid = new ModelRenderer(this);
        rmid.setPos(-2.5F, 0.0F, 4.5F);
        legs.addChild(rmid);
        rmid.texOffs(12, 9).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        lmid = new ModelRenderer(this);
        lmid.setPos(2.5F, 0.0F, 4.5F);
        legs.addChild(lmid);
        lmid.texOffs(16, 9).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        rback = new ModelRenderer(this);
        rback.setPos(-1.5F, 0.0F, 6.5F);
        legs.addChild(rback);
        rback.texOffs(0, 9).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        lback = new ModelRenderer(this);
        lback.setPos(1.5F, 0.0F, 6.5F);
        legs.addChild(lback);
        lback.texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
    }


    @Override
    public void setupAnim(VesselEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float)Math.PI / 180F) / 3;
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F) / 3;

        this.lback.xRot = 0;
        this.lfront.xRot = 0;
        this.rback.xRot = 0;
        this.rfront.xRot = 0;
        this.lmid.xRot = 0;
        this.rmid.xRot = 0;

        float f4 = (float) 0.5* -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount*10;
        float f3 = (float) 0.5* -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount*10;
        this.lback.xRot = f4;//* ((float)Math.PI / 1000F);
        this.rback.xRot = f3;
        this.lmid.xRot = -f4;
        this.rmid.xRot = -f3;
        this.lfront.xRot = f4;//* ((float)Math.PI / 1000F);
        this.rfront.xRot = f3;
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
