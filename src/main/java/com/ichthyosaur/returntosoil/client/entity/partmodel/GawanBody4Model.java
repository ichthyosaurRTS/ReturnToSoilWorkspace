package com.ichthyosaur.returntosoil.client.entity.partmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.PartEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GawanBody4Model<T extends PartEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer body4;
    private final ModelRenderer cube_r1;

    public GawanBody4Model() {
        texWidth = 256;
        texHeight = 256;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 8.0F, -39.0F);

        EmptyAll.addChild(all);


        body4 = new ModelRenderer(this);
        body4.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(body4);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.5F, -3.0F, 28.0F);
        body4.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0436F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 46).addBox(-4.0F, -6.0F, -15.0F, 8.0F, 12.0F, 30.0F, 0.0F, false);
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

