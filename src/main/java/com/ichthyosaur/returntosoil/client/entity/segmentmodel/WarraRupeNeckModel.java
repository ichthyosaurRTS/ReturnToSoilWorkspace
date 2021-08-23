package com.ichthyosaur.returntosoil.client.entity.segmentmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class WarraRupeNeckModel<T extends GeneralFlyingSegmentEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer head;

    public WarraRupeNeckModel() {
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 3.5F, 0.0F);
        EmptyAll.addChild(all);


        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(head);
        head.texOffs(0, 0).addBox(-2.5F, -4.0F, -8.0F, 5.0F, 5.0F, 13.0F, 0.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

