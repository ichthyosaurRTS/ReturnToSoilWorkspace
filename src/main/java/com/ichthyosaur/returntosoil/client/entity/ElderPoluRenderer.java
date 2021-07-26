package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.client.entity.model.ElderPoluModel;
import com.ichthyosaur.returntosoil.common.entity.ElderPoluEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ElderPoluRenderer extends MobRenderer<ElderPoluEntity, ElderPoluModel<ElderPoluEntity>> {

    public ElderPoluRenderer(EntityRendererManager manager) {
        super(manager, new ElderPoluModel<>(), 0.3f);

    }

    @Override
    public ResourceLocation getTextureLocation(ElderPoluEntity entity) {
        return entity.getResourceLocation();
    }

}
