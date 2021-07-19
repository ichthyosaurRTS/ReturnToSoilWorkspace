package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.JawBeetleModel;
import com.ichthyosaur.returntosoil.common.Entity.JawBeetleEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class JawBeetleRenderer extends MobRenderer<JawBeetleEntity, JawBeetleModel<JawBeetleEntity>> {


    public JawBeetleRenderer(EntityRendererManager manager) {
        super(manager, new JawBeetleModel<>(), 0.4f);

    }

    @Override
    public ResourceLocation getTextureLocation(JawBeetleEntity entity) {
        return entity.getResourceLocation();
    }
}
