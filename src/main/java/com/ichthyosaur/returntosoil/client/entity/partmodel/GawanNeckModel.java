package com.ichthyosaur.returntosoil.client.entity.partmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.PartEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GawanNeckModel<T extends PartEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer neck;
    private final ModelRenderer cube_r1;
    private final ModelRenderer finleft;
    private final ModelRenderer cube_r2;
    private final ModelRenderer finright;
    private final ModelRenderer cube_r3;

    public GawanNeckModel() {
        texWidth = 256;
        texHeight = 256;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 8.0F, 43.0F);

        EmptyAll.addChild(all);


        neck = new ModelRenderer(this);
        neck.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(neck);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -2.9F, -49.5F);
        neck.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.0436F, 0.0F, 0.0F);
        cube_r1.texOffs(94, 74).addBox(-3.5F, -4.3F, -11.5F, 7.0F, 10.0F, 23.0F, 0.0F, false);

        finleft = new ModelRenderer(this);
        finleft.setPos(0.0F, 0.0F, 0.0F);
        neck.addChild(finleft);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(6.5F, -1.0F, -49.5F);
        finleft.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.3927F, 1.0472F);
        cube_r2.texOffs(69, 59).addBox(-0.5F, 2.0F, -9.5F, 9.0F, 0.0F, 19.0F, 0.0F, false);

        finright = new ModelRenderer(this);
        finright.setPos(0.0F, 0.0F, 0.0F);
        neck.addChild(finright);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-6.5F, -1.0F, -49.5F);
        finright.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, -0.3927F, -1.0472F);
        cube_r3.texOffs(35, 0).addBox(-8.5F, 2.0F, -9.5F, 9.0F, 0.0F, 19.0F, 0.0F, false);
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

