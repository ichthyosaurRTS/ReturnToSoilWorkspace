package com.ichthyosaur.rts.client.entity;

import com.ichthyosaur.rts.RTSMain;
import com.ichthyosaur.rts.client.entity.model.HuskLarvaeEntityModel;
import com.ichthyosaur.rts.common.Entity.HuskLarvaeEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HuskLarvaeEntityRenderer extends MobRenderer<HuskLarvaeEntity, HuskLarvaeEntityModel<HuskLarvaeEntity>> {

    public HuskLarvaeEntityRenderer(EntityRendererManager manager) {
        super(manager, new HuskLarvaeEntityModel<>(), 0.7f);

    }

    @MethodsReturnNonnullByDefault
    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/husk_larvae/husk_larvae.png");

    @Override
    public ResourceLocation getTextureLocation(HuskLarvaeEntity p_110775_1_) {
        return TEXTURE;
    }

}
