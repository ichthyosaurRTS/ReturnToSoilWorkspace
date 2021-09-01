package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.client.entity.layer.BallFrogLayer;
import com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel.BallFrogModel;
import com.ichthyosaur.returntosoil.client.entity.model.TallSnailModel;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import com.ichthyosaur.returntosoil.common.entity.TallSnailEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TallSnailRenderer extends MobRenderer<TallSnailEntity, TallSnailModel<TallSnailEntity>> {

    //public static final Logger LOGGER = LogManager.getLogger();

    public TallSnailRenderer(EntityRendererManager manager) {
        super(manager, new TallSnailModel<>(), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(TallSnailEntity entity) {
        return new ResourceLocation("returntosoil:textures/entity/tall_snail/tall_snail.png");
    }

}
