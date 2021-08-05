package com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel;

import com.ichthyosaur.returntosoil.common.entity.JudasSheepHeadEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.util.logging.Logger;

public class JudasSheepHeadModel<T extends JudasSheepHeadEntity> extends EntityModel<T> {
    Logger logger = Logger.getLogger("logger");;

    private final ModelRenderer all;
    private final ModelRenderer movedforward;
    private final ModelRenderer block;
    private final ModelRenderer cube_r1;
    private final ModelRenderer bottomjaw;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer horns;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;

    public JudasSheepHeadModel() {
        texWidth = 128;
        texHeight = 128;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 17.0F, -1.0F);


        movedforward = new ModelRenderer(this);
        movedforward.setPos(0.0F, 0.0F, -4.0F);
        all.addChild(movedforward);


        block = new ModelRenderer(this);
        block.setPos(0.0F, 7.0F, 0.0F);
        movedforward.addChild(block);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -8.5F, 5.5F);
        block.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.1745F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 24).addBox(-4.5F, -3.5F, -4.5F, 9.0F, 8.0F, 8.0F, 0.0F, false);

        bottomjaw = new ModelRenderer(this);
        bottomjaw.setPos(0.0F, -1.5F, 5.5F);
        movedforward.addChild(bottomjaw);
        bottomjaw.texOffs(29, 8).addBox(-5.0F, -0.4F, -11.5F, 10.0F, 5.0F, 6.0F, 0.0F, false);
        bottomjaw.texOffs(35, 19).addBox(-4.0F, 6.6F, -11.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);
        bottomjaw.texOffs(34, 52).addBox(-4.0F, 5.6F, -11.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        bottomjaw.texOffs(34, 52).addBox(3.0F, 5.6F, -11.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        bottomjaw.texOffs(0, 40).addBox(-2.0F, -2.5F, -10.5F, 4.0F, 6.0F, 7.0F, 0.0F, false);
        bottomjaw.texOffs(18, 52).addBox(-2.0F, 0.5F, -13.5F, 4.0F, 5.0F, 4.0F, 0.0F, false);
        bottomjaw.texOffs(25, 31).addBox(-2.5F, 6.5F, -12.0F, 5.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 5.5F, -2.0F);
        bottomjaw.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.1309F, 0.0F, 0.0F);
        cube_r2.texOffs(22, 42).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, 7.5F, -14.0F);
        bottomjaw.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.1309F, 0.0F, 0.0F);
        cube_r3.texOffs(58, 15).addBox(-1.5F, -1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.texOffs(58, 15).addBox(0.5F, -1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.texOffs(58, 15).addBox(-1.5F, -0.5F, -1.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r3.texOffs(58, 15).addBox(0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, 3.5F, -15.0F);
        bottomjaw.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.1309F, 0.0F, 0.0F);
        cube_r4.texOffs(0, 0).addBox(-1.5F, 1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r4.texOffs(0, 0).addBox(0.5F, 1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r4.texOffs(57, 27).addBox(0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 4.0F, 0.0F, false);
        cube_r4.texOffs(57, 27).addBox(-1.5F, -1.5F, -1.5F, 1.0F, 3.0F, 4.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(0.0F, 1.5F, -12.0F);
        bottomjaw.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.9163F, 0.0F, 0.0F);
        cube_r5.texOffs(0, 53).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(4.5F, 4.6F, -8.5F);
        bottomjaw.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.1745F, 0.0F, 0.0F);
        cube_r6.texOffs(55, 2).addBox(-0.7F, -1.0F, -2.8F, 1.0F, 2.0F, 6.0F, 0.0F, false);
        cube_r6.texOffs(55, 2).addBox(-9.3F, -1.0F, -2.8F, 1.0F, 2.0F, 6.0F, 0.0F, false);

        horns = new ModelRenderer(this);
        horns.setPos(0.0F, 7.0F, 0.0F);
        movedforward.addChild(horns);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(0.0F, -10.0F, 6.0F);
        horns.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.2182F, 0.0F, 0.0F);
        cube_r7.texOffs(46, 42).addBox(-12.5F, 2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        cube_r7.texOffs(46, 42).addBox(8.5F, 2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        cube_r7.texOffs(50, 52).addBox(-12.5F, 4.0F, -6.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        cube_r7.texOffs(50, 52).addBox(8.5F, 4.0F, -6.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        cube_r7.texOffs(0, 0).addBox(-12.5F, -2.0F, -2.0F, 25.0F, 4.0F, 4.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(10.5F, -4.0F, 0.5F);
        horns.addChild(cube_r8);
        setRotationAngle(cube_r8, -0.2182F, 0.0F, 0.0F);
        cube_r8.texOffs(44, 27).addBox(-22.5F, -2.0F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);
        cube_r8.texOffs(44, 27).addBox(-1.5F, -2.0F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);
    }



    @Override
    public void setupAnim(JudasSheepHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.all.xRot = headPitch * ((float)Math.PI / 180F);
        this.all.yRot = netHeadYaw * ((float)Math.PI / 180F);

        //this.all.xRot = headPitch/4 * ((float)Math.PI / 180F);
        //this.all.yRot = netHeadYaw/4 * ((float)Math.PI / 180F);

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        all.render(matrixStack, buffer, packedLight, packedOverlay); //this will render all the children too
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
