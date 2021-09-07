package com.ichthyosaur.returntosoil.client.entity.segmentmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GawanBody2Model<T extends GeneralFlyingSegmentEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer body2;
    private final ModelRenderer cube_r1;

    public GawanBody2Model() {
        texWidth = 256;
        texHeight = 256;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 24.0F, 4.0F);


        body2 = new ModelRenderer(this);
        body2.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(body2);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -3.0F, -16.0F);
        body2.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0436F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 0).addBox(-5.5F, -7.3F, -16.0F, 11.0F, 14.0F, 32.0F, 0.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public void setupAnim(GeneralFlyingSegmentEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
	    super.setupAnim(entity,limbSwing, limbSwingAmount, ageInTicks,  netHeadYaw,  headPitch);
    }

}

