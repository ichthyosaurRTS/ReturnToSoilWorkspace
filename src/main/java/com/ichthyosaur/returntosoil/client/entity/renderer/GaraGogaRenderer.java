package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.client.entity.model.GaraGogaModel;
import com.ichthyosaur.returntosoil.common.entity.GaraGogaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GaraGogaRenderer extends MobRenderer<GaraGogaEntity, GaraGogaModel<GaraGogaEntity>> {


    public GaraGogaRenderer(EntityRendererManager manager) {
        super(manager, new GaraGogaModel<>(), 0.3f);

    }


    @Override
    public ResourceLocation getTextureLocation(GaraGogaEntity entity) {
        return new ResourceLocation("returntosoil:textures/entity/gara_goga/gara_goga.png");
    }
}

