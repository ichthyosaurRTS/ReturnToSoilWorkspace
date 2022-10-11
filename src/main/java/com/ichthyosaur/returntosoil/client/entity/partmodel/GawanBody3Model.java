package com.ichthyosaur.returntosoil.client.entity.partmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.PartEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GawanBody3Model<T extends PartEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer body3;
    private final ModelRenderer cube_r1;

    public GawanBody3Model() {
        texWidth = 256;
        texHeight = 256;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 8.0F, -16.0F);

        EmptyAll.addChild(all);


        body3 = new ModelRenderer(this);
        body3.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(body3);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.5F, -3.0F, 6.0F);
        body3.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.0436F, 0.0F, 0.0F);
        cube_r1.texOffs(58, 18).addBox(-4.5F, -6.5F, -14.0F, 9.0F, 13.0F, 28.0F, 0.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public void setupAnim(PartEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
	    super.setupAnim(entity,limbSwing, limbSwingAmount, ageInTicks,  netHeadYaw,  headPitch);
    }

}

