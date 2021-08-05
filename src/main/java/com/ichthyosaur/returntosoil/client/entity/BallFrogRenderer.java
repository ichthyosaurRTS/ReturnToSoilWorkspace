package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallFrogRenderer extends MobRenderer<BallFrogEntity, BallFrogModel<BallFrogEntity>> {

    //public static final Logger LOGGER = LogManager.getLogger();

    public BallFrogRenderer(EntityRendererManager manager) {
        super(manager, new BallFrogModel<>(), 0.3f);

    }


    @Override
    public ResourceLocation getTextureLocation(BallFrogEntity entity) {
        //LOGGER.info(""+entity.getColourInt());
        return entity.getResourceLocation();
    }

}
