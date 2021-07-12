package com.ichthyosaur.returntosoil.client.entity.ExtraLayer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.BaruGaruModel;
import com.ichthyosaur.returntosoil.common.Entity.BaruGaruEntity;
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
public class BaruGaruGreenLayer<T extends BaruGaruEntity> extends LayerRenderer<T, BaruGaruModel<T>> {
    private final BaruGaruModel<T> model = new BaruGaruModel<>();

    public BaruGaruGreenLayer(IEntityRenderer<T, BaruGaruModel<T>> renderer) {
            super(renderer);
        }
        public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/baru_garu/baru_garu_blue.png");

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

