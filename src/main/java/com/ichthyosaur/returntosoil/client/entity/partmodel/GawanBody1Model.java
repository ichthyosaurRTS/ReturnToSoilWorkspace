package com.ichthyosaur.returntosoil.client.entity.partmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.PartEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GawanBody1Model<T extends PartEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer body1;
    private final ModelRenderer cube_r1;

    public GawanBody1Model() {
        texWidth = 256;
        texHeight = 256;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 8.0F, 27.0F);

        EmptyAll.addChild(all);


        body1 = new ModelRenderer(this);
        body1.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(body1);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -3.0F, -34.5F);
        body1.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0436F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 88).addBox(-4.5F, -6.0F, -11.5F, 9.0F, 12.0F, 23.0F, 0.0F, false);
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

