package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.client.entity.model.TallSnailModel;
import com.ichthyosaur.returntosoil.client.entity.model.VesselModel;
import com.ichthyosaur.returntosoil.common.entity.TallSnailEntity;
import com.ichthyosaur.returntosoil.common.entity.VesselEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class VesselRenderer extends MobRenderer<VesselEntity, VesselModel<VesselEntity>> {

    //public static final Logger LOGGER = LogManager.getLogger();

    public VesselRenderer(EntityRendererManager manager) {
        super(manager, new VesselModel<>(), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(VesselEntity entity) {
        return new ResourceLocation("returntosoil:textures/entity/vessel/vessel.png");
    }

}
