package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.client.entity.model.ElderPoluModel;
import com.ichthyosaur.returntosoil.common.Entity.ElderPoluEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ElderPoluRenderer extends MobRenderer<ElderPoluEntity, ElderPoluModel<ElderPoluEntity>> {

    public ElderPoluRenderer(EntityRendererManager manager) {
        super(manager, new ElderPoluModel<>(), 0.7f);

    }

    @Override
    public ResourceLocation getTextureLocation(ElderPoluEntity entity) {
        return entity.getResourceLocation();
    }

}
