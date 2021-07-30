package com.ichthyosaur.returntosoil.client.entity.GhostRamRenderer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.GhostRamModel.GhostRamBodyModel;
import com.ichthyosaur.returntosoil.client.entity.model.GhostRamModel.GhostRamHeadModel;
import com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam.GhostRamBodyEntity;
import com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam.GhostRamHeadEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class GhostRamBodyRenderer extends MobRenderer<GhostRamBodyEntity, GhostRamBodyModel<GhostRamBodyEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/baru_garu_segment/baru_garu_segment.png");

    public GhostRamBodyRenderer(EntityRendererManager manager) {
        super(manager, new GhostRamBodyModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(GhostRamBodyEntity p_110775_1_) { return TEXTURE; }
}
