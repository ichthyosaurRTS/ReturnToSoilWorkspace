package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.NomadSnailModel;
import com.ichthyosaur.returntosoil.common.entity.NomadSnailEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class NomadSnailRenderer extends MobRenderer<NomadSnailEntity, NomadSnailModel<NomadSnailEntity>> {

    public NomadSnailRenderer(EntityRendererManager manager) {
        super(manager, new NomadSnailModel<>(), 0.7f);

    }
    @MethodsReturnNonnullByDefault
    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/nomad_snail/nomad_snail.png");

    @Override
    public ResourceLocation getTextureLocation(NomadSnailEntity p_110775_1_) {
        return TEXTURE;
    }
}
