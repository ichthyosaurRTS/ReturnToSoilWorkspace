package com.ichthyosaur.rts.client.entity;

import com.ichthyosaur.rts.RTSMain;
import com.ichthyosaur.rts.client.entity.ExtraLayer.BaruGaruSegmentGreenLayer;
import com.ichthyosaur.rts.client.entity.model.BaruGaruSegmentModel;
import com.ichthyosaur.rts.common.Entity.BaruGaruSegmentEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BaruGaruSegmentRenderer extends MobRenderer<BaruGaruSegmentEntity, BaruGaruSegmentModel<BaruGaruSegmentEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/baru_garu_segment/baru_garu_segment.png");

    public BaruGaruSegmentRenderer(EntityRendererManager manager) {
        super(manager, new BaruGaruSegmentModel<>(), 0.7f);
        this.addLayer(new BaruGaruSegmentGreenLayer<>(this));
    }


    @Override
    public ResourceLocation getTextureLocation(BaruGaruSegmentEntity p_110775_1_) { return TEXTURE; }

}
