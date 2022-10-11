package com.ichthyosaur.returntosoil.client.entity.layer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.model.CentipedeModel;
import com.ichthyosaur.returntosoil.common.entity.CentipedeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class CentipedeGreenLayer<T extends CentipedeEntity> extends LayerRenderer<T, CentipedeModel<T>> {
    private final CentipedeModel<T> model = new CentipedeModel<>();

    public CentipedeGreenLayer(IEntityRenderer<T, CentipedeModel<T>> renderer) {
            super(renderer);
        }
        public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/baru_garu/baru_garu_blue.png");

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entityLivingBaseIN, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entityLivingBaseIN.isInvisible()) {
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.setupAnim(entityLivingBaseIN, limbSwing, limbSwingAmount, partialTicks, netHeadYaw, headPitch);
            this.model.prepareMobModel(entityLivingBaseIN, limbSwing, limbSwingAmount, ageInTicks);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.eyes(TEXTURE)); //adds both textures together? always gets brighter... need deeper blue than we end with.
            this.model.renderToBuffer(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }

