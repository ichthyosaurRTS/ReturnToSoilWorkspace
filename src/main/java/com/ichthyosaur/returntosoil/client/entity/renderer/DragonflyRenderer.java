package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.client.entity.model.DragonflyModel;
import com.ichthyosaur.returntosoil.common.entity.DragonflyEntity;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DragonflyRenderer extends MobRenderer<DragonflyEntity, DragonflyModel<DragonflyEntity>> {


    public DragonflyRenderer(EntityRendererManager manager) {
        super(manager, new DragonflyModel<>(), 0.3f);

    }

    @Override
    public ResourceLocation getTextureLocation(DragonflyEntity entity) {
        return entity.getResourceLocation();
    }
}
