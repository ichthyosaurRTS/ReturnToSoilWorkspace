package com.ichthyosaur.returntosoil.client.entity.segmentmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class WarraRupeBody2Model<T extends GeneralFlyingSegmentEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer wingleft;
    private final ModelRenderer cube_r1;
    private final ModelRenderer wingleft2;
    private final ModelRenderer cube_r2;
    private final ModelRenderer wingright;
    private final ModelRenderer cube_r3;
    private final ModelRenderer wingright2;
    private final ModelRenderer cube_r4;

    public WarraRupeBody2Model() {
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 5.5F, 0.0F);

        EmptyAll.addChild(all);


        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(head);


        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(body);
        body.texOffs(0, 0).addBox(-3.0F, -4.0F, -9.0F, 6.0F, 5.0F, 13.0F, 0.0F, false);

        wingleft = new ModelRenderer(this);
        wingleft.setPos(3.0F, -1.0F, -9.0F);
        body.addChild(wingleft);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(1.0F, -0.5F, 1.5F);
        wingleft.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, -0.2618F, -0.2182F);
        cube_r1.texOffs(0, 18).addBox(-1.0F, 0.0F, 1.5F, 6.0F, 0.0F, 9.0F, 0.0F, false);
        cube_r1.texOffs(25, 9).addBox(-1.0F, -0.5F, 0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        wingleft2 = new ModelRenderer(this);
        wingleft2.setPos(-3.0F, 1.0F, 9.0F);
        wingleft.addChild(wingleft2);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(10.5F, -3.4F, -5.0F);
        wingleft2.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, -0.5236F, 0.0873F);
        cube_r2.texOffs(23, 18).addBox(-2.5F, 1.1F, 1.5F, 4.0F, 0.0F, 6.0F, 0.0F, false);
        cube_r2.texOffs(0, 0).addBox(-2.5F, 0.6F, 0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        wingright = new ModelRenderer(this);
        wingright.setPos(-3.0F, -1.0F, -9.0F);
        body.addChild(wingright);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-1.0F, -0.5F, 1.5F);
        wingright.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.2618F, 0.2182F);
        cube_r3.texOffs(16, 0).addBox(-5.0F, 0.0F, 1.5F, 6.0F, 0.0F, 9.0F, 0.0F, false);
        cube_r3.texOffs(21, 24).addBox(-5.0F, -0.5F, 0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        wingright2 = new ModelRenderer(this);
        wingright2.setPos(-4.0F, -1.0F, 2.0F);
        wingright.addChild(wingright2);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-3.5F, -1.4F, 2.0F);
        wingright2.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.5236F, -0.0873F);
        cube_r4.texOffs(15, 18).addBox(-1.5F, 1.1F, 1.5F, 4.0F, 0.0F, 6.0F, 0.0F, false);
        cube_r4.texOffs(0, 2).addBox(-2.5F, 0.6F, 0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);}

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

