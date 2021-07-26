package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.FourTailedFoxModel;
import com.ichthyosaur.returntosoil.common.entity.FourTailedFoxEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FourTailedFoxRenderer extends MobRenderer<FourTailedFoxEntity, FourTailedFoxModel<FourTailedFoxEntity>> {

    public FourTailedFoxRenderer(EntityRendererManager manager) {
        super(manager, new FourTailedFoxModel<>(), 0.7f);
    }

    @Override
    @MethodsReturnNonnullByDefault
    public ResourceLocation getTextureLocation(FourTailedFoxEntity p_110775_1_) {
        return TEXTURE;
    }
    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/four_tailed_fox/four_tailed_fox.png");

}
