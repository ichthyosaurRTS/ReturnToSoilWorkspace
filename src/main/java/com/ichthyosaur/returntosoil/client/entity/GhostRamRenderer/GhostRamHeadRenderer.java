package com.ichthyosaur.returntosoil.client.entity.GhostRamRenderer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.ExtraLayer.BaruGaruGreenLayer;
import com.ichthyosaur.returntosoil.client.entity.model.BaruGaruModel;
import com.ichthyosaur.returntosoil.client.entity.model.GhostRamModel.GhostRamHeadModel;
import com.ichthyosaur.returntosoil.common.entity.BaruGaruEntity;
import com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam.GhostRamHeadEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class GhostRamHeadRenderer extends MobRenderer<GhostRamHeadEntity, GhostRamHeadModel<GhostRamHeadEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/baru_garu_segment/baru_garu_segment.png");

    public GhostRamHeadRenderer(EntityRendererManager manager) {
        super(manager, new GhostRamHeadModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(GhostRamHeadEntity p_110775_1_) { return TEXTURE; }
}
