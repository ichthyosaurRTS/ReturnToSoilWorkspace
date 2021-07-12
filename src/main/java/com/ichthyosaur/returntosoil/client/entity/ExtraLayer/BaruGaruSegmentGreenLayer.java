package com.ichthyosaur.returntosoil.client.entity.ExtraLayer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.BaruGaruSegmentModel;
import com.ichthyosaur.returntosoil.common.Entity.BaruGaruSegmentEntity;
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
public class BaruGaruSegmentGreenLayer<T extends BaruGaruSegmentEntity> extends LayerRenderer<T, BaruGaruSegmentModel<T>> {
    private final BaruGaruSegmentModel<T> model = new BaruGaruSegmentModel<>();

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/baru_garu_segment/baru_garu_segment_blue.png");

    public BaruGaruSegmentGreenLayer(IEntityRenderer<T, BaruGaruSegmentModel<T>> renderer) {
        super(renderer);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.isInvisible()) {
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.setupAnim(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, netHeadYaw, headPitch);
            this.model.prepareMobModel(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.eyes(TEXTURE)); //adds both textures together? always gets brighter... need deeper blue than we end with.
            this.model.renderToBuffer(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
