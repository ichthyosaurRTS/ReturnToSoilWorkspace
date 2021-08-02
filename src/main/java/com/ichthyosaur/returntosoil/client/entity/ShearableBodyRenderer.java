package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel;
import com.ichthyosaur.returntosoil.client.entity.model.ShearableBodyModel;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import com.ichthyosaur.returntosoil.common.entity.ShearableBodyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShearableBodyRenderer extends MobRenderer<ShearableBodyEntity, ShearableBodyModel<ShearableBodyEntity>> {

    public static final Logger LOGGER = LogManager.getLogger();

    public ShearableBodyRenderer(EntityRendererManager manager) {
        super(manager, new ShearableBodyModel<>(), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(ShearableBodyEntity entity) {
        //LOGGER.info(""+entity.hasWool());
        return new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_body.png");
    }
}
