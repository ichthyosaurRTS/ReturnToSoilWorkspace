package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.client.entity.model.BeetleModel;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BeetleRenderer extends MobRenderer<JawBeetleEntity, BeetleModel<JawBeetleEntity>> {


    public BeetleRenderer(EntityRendererManager manager) {
        super(manager, new BeetleModel<>(), 0.4f);

    }

    @Override
    public ResourceLocation getTextureLocation(JawBeetleEntity entity) {
        return entity.getResourceLocation();
    }
}
