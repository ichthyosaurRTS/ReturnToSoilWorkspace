package com.ichthyosaur.returntosoil.client.entity.model;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepButtEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class EmptyModel <T extends GeneralFlyingSegmentEntity> extends EntityModel<T> {

    public static final Logger LOGGER = LogManager.getLogger();
    public final ModelRenderer EmptyAll;

    public EmptyModel() {
        texWidth = 16;
        texHeight = 16;

        EmptyAll = new ModelRenderer(this);
        EmptyAll.setPos(0.0F, 16.0F, 0.0F);
    }

    @Override
    public void setupAnim(GeneralFlyingSegmentEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.EmptyAll.xRot = headPitch * ((float)Math.PI / 180F);
        this.EmptyAll.yRot = netHeadYaw * ((float)Math.PI / 180F);

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        EmptyAll.render(matrixStack, buffer, packedLight, packedOverlay); //this will render all the children too
    }
}
