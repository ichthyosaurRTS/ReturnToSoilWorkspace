package com.ichthyosaur.returntosoil.client.entity.partmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.PartEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GawanTailModel<T extends PartEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer tail;

    public GawanTailModel() {
        texWidth = 256;
        texHeight = 256;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 8.0F, -79.0F);

        EmptyAll.addChild(all);


        tail = new ModelRenderer(this);
        tail.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(tail);
        tail.texOffs(64, 85).addBox(0.5F, -13.5F, 64.0F, 0.0F, 21.0F, 22.0F, 0.0F, false);
        tail.texOffs(46, 51).addBox(-0.5F, -5.5F, 61.0F, 2.0F, 5.0F, 8.0F, 0.0F, false);
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

