package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.HuskLarvaeEntityModel;
import com.ichthyosaur.returntosoil.common.entity.HuskLarvaeEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HuskLarvaeEntityRenderer extends MobRenderer<HuskLarvaeEntity, HuskLarvaeEntityModel<HuskLarvaeEntity>> {

    public HuskLarvaeEntityRenderer(EntityRendererManager manager) {
        super(manager, new HuskLarvaeEntityModel<>(), 0.3f);

    }

    @MethodsReturnNonnullByDefault
    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/husk_larvae/husk_larvae.png");

    @Override
    public ResourceLocation getTextureLocation(HuskLarvaeEntity p_110775_1_) {
        return TEXTURE;
    }

}
