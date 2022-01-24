package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.layer.GeneralFlyingSegmentLayer;
import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GeneralFlyingSegmentRenderer extends MobRenderer<GeneralFlyingSegmentEntity, EmptyModel<GeneralFlyingSegmentEntity>> {

    public GeneralFlyingSegmentRenderer(EntityRendererManager manager) {
        super(manager, new EmptyModel<>(), 0.3f);
        this.addLayer(new GeneralFlyingSegmentLayer<>(this));
    }


    public ResourceLocation getTextureLocation(GeneralFlyingSegmentEntity p_110775_1_) {
        //LOGGER.info(""+p_110775_1_.hasWool());
        return new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/judas_sheep/judas_sheep_body.png"); } //this don't matter

}
