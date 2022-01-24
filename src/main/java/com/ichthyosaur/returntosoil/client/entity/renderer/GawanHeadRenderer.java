package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.model.GawanHeadModel;
import com.ichthyosaur.returntosoil.common.entity.GawanHeadEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GawanHeadRenderer extends MobRenderer<GawanHeadEntity, GawanHeadModel<GawanHeadEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/gawan/gawan_fullbody.png");
    public static final Logger LOGGER = LogManager.getLogger();

    public GawanHeadRenderer(EntityRendererManager manager) {
        super(manager, new GawanHeadModel<>(), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(GawanHeadEntity p_110775_1_) { return TEXTURE; }
}
