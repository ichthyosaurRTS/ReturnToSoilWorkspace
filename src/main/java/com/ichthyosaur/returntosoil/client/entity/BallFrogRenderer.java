package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BallFrogRenderer extends MobRenderer<BallFrogEntity, BallFrogModel<BallFrogEntity>> {

    public BallFrogRenderer(EntityRendererManager manager) {
        super(manager, new BallFrogModel<>(), 0.3f);

    }

    @Override
    public ResourceLocation getTextureLocation(BallFrogEntity entity) {
        return entity.getResourceLocation();
    }

}
