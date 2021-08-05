package com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel;

import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepBodyEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.util.logging.Logger;

public class JudasSheepBodyModel<T extends JudasSheepBodyEntity> extends EntityModel<T> {
    Logger logger = Logger.getLogger("logger");;

    public final ModelRenderer all;
    private final ModelRenderer spine;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer ribs;
    private final ModelRenderer rib1;
    private final ModelRenderer rib2;
    private final ModelRenderer rib3;
    private final ModelRenderer rib4;
    private final ModelRenderer rib5;
    private final ModelRenderer rib6;
    private final ModelRenderer rib7;
    private final ModelRenderer rib9;
    private final ModelRenderer rib10;
    private final ModelRenderer rib8;
    private final ModelRenderer legs;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;

    public JudasSheepBodyModel() {
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 19.0F, 0.0F);


        spine = new ModelRenderer(this);
        spine.setPos(0.0F, 5.0F, 0.0F);
        all.addChild(spine);
        spine.texOffs(0, 0).addBox(-3.0F, -10.0F, -8.0F, 6.0F, 5.0F, 15.0F, 0.0F, false);
        spine.texOffs(27, 0).addBox(-2.0F, 1.0F, -8.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);
        spine.texOffs(0, 20).addBox(-1.0F, 0.0F, -10.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -7.0F, 7.5F);
        spine.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.2618F, 0.0F, 0.0F);
        cube_r1.texOffs(18, 25).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 3.0F, 8.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, -7.0F, -7.5F);
        spine.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.2618F, 0.0F, 0.0F);
        cube_r2.texOffs(0, 20).addBox(-2.0F, -2.0F, -6.5F, 4.0F, 4.0F, 9.0F, 0.0F, false);

        ribs = new ModelRenderer(this);
        ribs.setPos(0.0F, 5.0F, 0.0F);
        all.addChild(ribs);


        rib1 = new ModelRenderer(this);
        rib1.setPos(0.0F, 0.0F, 0.0F);
        ribs.addChild(rib1);
        rib1.texOffs(44, 39).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib1.texOffs(49, 6).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(55, 1).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(55, 3).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(48, 46).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(48, 48).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(48, 50).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(0, 48).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib2 = new ModelRenderer(this);
        rib2.setPos(0.0F, 0.0F, 2.0F);
        ribs.addChild(rib2);
        rib2.texOffs(44, 24).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib2.texOffs(48, 44).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(51, 54).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(47, 54).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(48, 42).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(48, 40).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(48, 35).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(44, 9).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib3 = new ModelRenderer(this);
        rib3.setPos(0.0F, 0.0F, 4.0F);
        ribs.addChild(rib3);
        rib3.texOffs(40, 35).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib3.texOffs(48, 33).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(43, 54).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(36, 51).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(48, 31).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(48, 29).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(48, 27).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(40, 20).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib4 = new ModelRenderer(this);
        rib4.setPos(0.0F, 0.0F, 6.0F);
        ribs.addChild(rib4);
        rib4.texOffs(36, 36).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib4.texOffs(48, 25).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(39, 50).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(12, 48).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(48, 20).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(48, 18).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(48, 16).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(32, 36).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib5 = new ModelRenderer(this);
        rib5.setPos(0.0F, 0.0F, 8.0F);
        ribs.addChild(rib5);
        rib5.texOffs(28, 36).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib5.texOffs(48, 14).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(40, 12).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(40, 10).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(12, 53).addBox(-8.0F, 1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(48, 52).addBox(3.0F, 1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(48, 12).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(24, 36).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib6 = new ModelRenderer(this);
        rib6.setPos(0.0F, 0.0F, 10.0F);
        ribs.addChild(rib6);
        rib6.texOffs(20, 36).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib6.texOffs(48, 10).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(30, 4).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(30, 2).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(24, 51).addBox(-8.0F, 1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(12, 51).addBox(3.0F, 1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(48, 8).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(16, 36).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib7 = new ModelRenderer(this);
        rib7.setPos(0.0F, 0.0F, 12.0F);
        ribs.addChild(rib7);
        rib7.texOffs(12, 33).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib7.texOffs(47, 38).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(27, 5).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(4, 27).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(34, 53).addBox(-8.0F, 1.0F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(24, 53).addBox(4.0F, 1.0F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(47, 23).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(8, 33).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib9 = new ModelRenderer(this);
        rib9.setPos(0.0F, 0.0F, -2.0F);
        ribs.addChild(rib9);
        rib9.texOffs(27, 9).addBox(1.0F, -11.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib9.texOffs(17, 22).addBox(-7.0F, -11.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib9.texOffs(27, 0).addBox(1.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        rib9.texOffs(21, 26).addBox(-2.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        rib9.texOffs(8, 48).addBox(7.0F, -11.0F, -8.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
        rib9.texOffs(4, 48).addBox(-8.0F, -11.0F, -8.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
        rib9.texOffs(27, 11).addBox(1.0F, 0.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib9.texOffs(17, 20).addBox(-7.0F, 0.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        rib10 = new ModelRenderer(this);
        rib10.setPos(0.0F, 0.0F, 16.0F);
        ribs.addChild(rib10);
        rib10.texOffs(0, 13).addBox(1.0F, -11.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib10.texOffs(0, 11).addBox(-7.0F, -11.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib10.texOffs(17, 26).addBox(1.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        rib10.texOffs(9, 0).addBox(-2.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        rib10.texOffs(36, 20).addBox(7.0F, -11.0F, -8.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
        rib10.texOffs(32, 20).addBox(-8.0F, -11.0F, -8.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
        rib10.texOffs(0, 25).addBox(4.0F, 0.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        rib10.texOffs(17, 24).addBox(-7.0F, 0.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        rib8 = new ModelRenderer(this);
        rib8.setPos(0.0F, 0.0F, -2.0F);
        ribs.addChild(rib8);
        rib8.texOffs(4, 33).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib8.texOffs(42, 4).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(27, 3).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(0, 27).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(42, 2).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(42, 0).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(27, 13).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(0, 33).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(legs);


        rightleg = new ModelRenderer(this);
        rightleg.setPos(-5.5F, 7.0F, -2.5F);
        legs.addChild(rightleg);
        setRotationAngle(rightleg, 0.7854F, 0.0F, 0.0F);
        rightleg.texOffs(0, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(5.5F, 7.0F, -2.5F);
        legs.addChild(leftleg);
        setRotationAngle(leftleg, 0.7854F, 0.0F, 0.0F);
        leftleg.texOffs(0, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
    }
    @Override
    public void setupAnim(JudasSheepBodyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.all.xRot = headPitch * ((float)Math.PI / 180F);
        this.all.yRot = netHeadYaw * ((float)Math.PI / 180F);

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
