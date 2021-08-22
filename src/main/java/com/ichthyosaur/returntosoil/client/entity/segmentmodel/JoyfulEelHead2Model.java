package com.ichthyosaur.returntosoil.client.entity.segmentmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class JoyfulEelHead2Model<T extends GeneralFlyingSegmentEntity> extends EmptyModel<T > {

        private final ModelRenderer all;
        private final ModelRenderer fakehead;

	public JoyfulEelHead2Model() {
        texWidth = 32;
        texHeight = 32;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 7.0F, 1.0F);

        EmptyAll.addChild(all);

        fakehead = new ModelRenderer(this);
        fakehead.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(fakehead);
        fakehead.texOffs(0, 0).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 5.0F, 7.0F, 0.0F, false);
        fakehead.texOffs(0, 12).addBox(-3.5F, -4.0F, -4.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

