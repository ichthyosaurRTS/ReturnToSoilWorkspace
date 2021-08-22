package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.common.entity.JoyfulEelHeadEntity;
import com.ichthyosaur.returntosoil.common.entity.JudasSheepHeadEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class JoyfulEelHeadModel<T extends JoyfulEelHeadEntity> extends EntityModel<JoyfulEelHeadEntity> {

        private final ModelRenderer all;
        private final ModelRenderer fakehead;

        public JoyfulEelHeadModel() {
            texWidth = 32;
            texHeight = 32;

            all = new ModelRenderer(this);
            all.setPos(0.0F, 23.0F, 1.0F);


            fakehead = new ModelRenderer(this);
            fakehead.setPos(0.0F, 0.0F, 0.0F);
            all.addChild(fakehead);
            fakehead.texOffs(0, 0).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 5.0F, 7.0F, 0.0F, false);
            fakehead.texOffs(0, 12).addBox(-3.5F, -4.0F, -4.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
        }

    @Override
    public void setupAnim(JoyfulEelHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.all.xRot = headPitch * ((float)Math.PI / 180F);
        this.all.yRot = netHeadYaw * ((float)Math.PI / 180F);
    }

        @Override
        public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
            all.render(matrixStack, buffer, packedLight, packedOverlay);
        }

        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.xRot = x;
            modelRenderer.yRot = y;
            modelRenderer.zRot = z;
        }
    }
