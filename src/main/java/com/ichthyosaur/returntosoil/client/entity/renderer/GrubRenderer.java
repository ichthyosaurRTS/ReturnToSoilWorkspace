package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.model.GrubModel;
import com.ichthyosaur.returntosoil.common.entity.GrubEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GrubRenderer extends MobRenderer<GrubEntity, GrubModel<GrubEntity>> {

    public GrubRenderer(EntityRendererManager manager) {
        super(manager, new GrubModel<>(), 0.3f);

    }

    @MethodsReturnNonnullByDefault
    public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/husk_larvae/husk_larvae.png");

    @Override
    public ResourceLocation getTextureLocation(GrubEntity p_110775_1_) {
        return TEXTURE;
    }

}
