package com.ichthyosaur.returntosoil.client.entity.segmentmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class JoyfulEelTail2Model<T extends GeneralFlyingSegmentEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;

    public JoyfulEelTail2Model() {
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 6.0F, 0.0F);


        EmptyAll.addChild(all);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(head);
        head.texOffs(0, 15).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 3.0F, 10.0F, 0.0F, false);
        head.texOffs(18, 15).addBox(-1.5F, -2.0F, 2.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
        head.texOffs(0, 0).addBox(-7.0F, -1.51F, 2.0F, 14.0F, 0.0F, 15.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(2.0F, -1.5F, 2.5F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, -0.5236F, 0.0F);
        cube_r1.texOffs(27, 27).addBox(-1.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(-2.0F, -1.5F, 2.5F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.5236F, 0.0F);
        cube_r2.texOffs(0, 28).addBox(-6.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

