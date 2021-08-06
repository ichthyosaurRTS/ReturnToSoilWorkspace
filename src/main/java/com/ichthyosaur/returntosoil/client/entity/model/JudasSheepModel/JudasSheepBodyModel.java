package com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel;

import com.ichthyosaur.returntosoil.common.entity.JudasSheepBodyEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.util.logging.Logger;

public class JudasSheepBodyModel<T extends JudasSheepBodyEntity> extends EntityModel<T> {
    Logger logger = Logger.getLogger("logger");;

    private double counter = -3.14;

    public final ModelRenderer all;
    private final ModelRenderer spine;
    private final ModelRenderer ribs;
    private final ModelRenderer rib9;
    private final ModelRenderer rib5;
    private final ModelRenderer rib8;
    private final ModelRenderer rib2;
    private final ModelRenderer rib4;
    private final ModelRenderer rib3;
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
        spine.texOffs(27, 0).addBox(-2.0F, 0.5F, -9.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);
        spine.texOffs(17, 24).addBox(-1.0F, -1.0F, -11.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        spine.texOffs(0, 20).addBox(-2.0F, -9.1F, -12.0F, 4.0F, 4.0F, 9.0F, 0.0F, false);
        spine.texOffs(18, 25).addBox(-1.5F, -8.5F, 4.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);

        ribs = new ModelRenderer(this);
        ribs.setPos(0.0F, 5.0F, 0.0F);
        all.addChild(ribs);


        rib9 = new ModelRenderer(this);
        rib9.setPos(0.0F, 0.0F, -2.0F);
        ribs.addChild(rib9);
        rib9.texOffs(40, 32).addBox(1.0F, -16.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib9.texOffs(32, 40).addBox(-9.0F, -16.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib9.texOffs(32, 44).addBox(1.0F, -14.0F, -9.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
        rib9.texOffs(0, 20).addBox(-3.0F, -14.0F, -9.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
        rib9.texOffs(24, 36).addBox(9.0F, -16.0F, -9.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
        rib9.texOffs(16, 36).addBox(-11.0F, -16.0F, -9.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
        rib9.texOffs(39, 20).addBox(1.0F, -1.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib9.texOffs(32, 36).addBox(-9.0F, -1.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        rib5 = new ModelRenderer(this);
        rib5.setPos(0.0F, 0.0F, 18.0F);
        ribs.addChild(rib5);
        rib5.texOffs(40, 32).addBox(1.0F, -16.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib5.texOffs(32, 40).addBox(-9.0F, -16.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib5.texOffs(32, 44).addBox(1.0F, -14.0F, -9.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
        rib5.texOffs(0, 20).addBox(-3.0F, -14.0F, -9.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
        rib5.texOffs(24, 36).addBox(9.0F, -16.0F, -9.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
        rib5.texOffs(16, 36).addBox(-11.0F, -16.0F, -9.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
        rib5.texOffs(39, 20).addBox(1.0F, -1.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib5.texOffs(32, 36).addBox(-9.0F, -1.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        rib8 = new ModelRenderer(this);
        rib8.setPos(0.0F, 0.0F, -2.0F);
        ribs.addChild(rib8);
        rib8.texOffs(8, 33).addBox(-12.0F, -17.0F, -5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);
        rib8.texOffs(32, 28).addBox(-10.0F, -17.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib8.texOffs(42, 13).addBox(-3.0F, -15.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        rib8.texOffs(42, 0).addBox(1.0F, -15.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        rib8.texOffs(32, 24).addBox(-10.0F, 0.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib8.texOffs(27, 9).addBox(1.0F, 0.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib8.texOffs(17, 20).addBox(1.0F, -17.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib8.texOffs(0, 33).addBox(10.0F, -17.0F, -5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);

        rib2 = new ModelRenderer(this);
        rib2.setPos(0.0F, 0.0F, 2.0F);
        ribs.addChild(rib2);
        rib2.texOffs(8, 33).addBox(-12.0F, -17.0F, -5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);
        rib2.texOffs(32, 28).addBox(-10.0F, -17.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib2.texOffs(42, 13).addBox(-3.0F, -15.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        rib2.texOffs(42, 0).addBox(1.0F, -15.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        rib2.texOffs(32, 24).addBox(-10.0F, 0.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib2.texOffs(27, 9).addBox(1.0F, 0.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib2.texOffs(17, 20).addBox(1.0F, -17.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib2.texOffs(0, 33).addBox(10.0F, -17.0F, -5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);

        rib4 = new ModelRenderer(this);
        rib4.setPos(0.0F, 0.0F, 10.0F);
        ribs.addChild(rib4);
        rib4.texOffs(8, 33).addBox(-12.0F, -17.0F, -5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);
        rib4.texOffs(32, 28).addBox(-10.0F, -17.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib4.texOffs(42, 13).addBox(-3.0F, -15.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        rib4.texOffs(42, 0).addBox(1.0F, -15.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        rib4.texOffs(32, 24).addBox(-10.0F, 0.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib4.texOffs(27, 9).addBox(1.0F, 0.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib4.texOffs(17, 20).addBox(1.0F, -17.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib4.texOffs(0, 33).addBox(10.0F, -17.0F, -5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);

        rib3 = new ModelRenderer(this);
        rib3.setPos(0.0F, 0.0F, 6.0F);
        ribs.addChild(rib3);
        rib3.texOffs(8, 33).addBox(-12.0F, -17.0F, -5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);
        rib3.texOffs(32, 28).addBox(-10.0F, -17.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib3.texOffs(42, 13).addBox(-3.0F, -15.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        rib3.texOffs(42, 0).addBox(1.0F, -15.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        rib3.texOffs(32, 24).addBox(-10.0F, 0.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib3.texOffs(27, 9).addBox(1.0F, 0.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib3.texOffs(17, 20).addBox(1.0F, -17.0F, -5.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib3.texOffs(0, 33).addBox(10.0F, -17.0F, -5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(legs);


        rightleg = new ModelRenderer(this);
        rightleg.setPos(-5.5F, 7.0F, -2.5F);
        legs.addChild(rightleg);
        setRotationAngle(rightleg, 0.7854F, 0.0F, 0.0F);
        rightleg.texOffs(52, 53).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(5.5F, 7.0F, -2.5F);
        legs.addChild(leftleg);
        setRotationAngle(leftleg, 0.7854F, 0.0F, 0.0F);
        leftleg.texOffs(52, 53).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(JudasSheepBodyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.all.xRot = headPitch * ((float)Math.PI / 180F);
        this.all.yRot = netHeadYaw * ((float)Math.PI / 180F);

        this.rightleg.xRot = 0.7854F;
        this.leftleg.xRot = 0.7854F;

        if (this.counter < 3.14) {
            this.counter += 0.001;

            this.rightleg.xRot = (float) (0.7854F +(Math.sin(this.counter+1)/2));
            this.leftleg.xRot = (float) (0.7854F +(Math.sin(this.counter+1.5)/2));
        }
        else this.counter = -3.14;
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
