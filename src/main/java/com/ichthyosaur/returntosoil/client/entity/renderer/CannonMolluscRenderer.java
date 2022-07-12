package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.client.entity.model.CannonMolluscModel;
import com.ichthyosaur.returntosoil.client.entity.model.DragonflyModel;
import com.ichthyosaur.returntosoil.common.entity.CannonMolluscEntity;
import com.ichthyosaur.returntosoil.common.entity.DragonflyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CannonMolluscRenderer extends MobRenderer<CannonMolluscEntity, CannonMolluscModel<CannonMolluscEntity>> {


    public CannonMolluscRenderer(EntityRendererManager manager) {
        super(manager, new CannonMolluscModel<>(), 0.3f);

    }

    @Override
    public ResourceLocation getTextureLocation(CannonMolluscEntity entity) {
        return new ResourceLocation("returntosoil:textures/entity/cannon_mollusc/cannon_mollusc.png");
    }
}
