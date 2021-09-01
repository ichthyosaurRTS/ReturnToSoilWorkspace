package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.client.entity.layer.BallFrogLayer;
import com.ichthyosaur.returntosoil.client.entity.layer.GeneralFlyingSegmentLayer;
import com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel.BallFrogModel;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BallFrogRenderer extends MobRenderer<BallFrogEntity, BallFrogModel<BallFrogEntity>> {

    //public static final Logger LOGGER = LogManager.getLogger();

    public BallFrogRenderer(EntityRendererManager manager) {
        super(manager, new BallFrogModel<>(), 0.3f);
        this.addLayer(new BallFrogLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(BallFrogEntity entity) {
        return new ResourceLocation("returntosoil:textures/entity/ball_frog/ball_frog_green_deflated.png");
    }

}
