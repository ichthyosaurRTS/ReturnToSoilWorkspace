package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.WorraRupeHeadModel;
import com.ichthyosaur.returntosoil.common.entity.WarraRupeHeadEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WarraRupeHeadRenderer extends MobRenderer<WarraRupeHeadEntity, WorraRupeHeadModel<WarraRupeHeadEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/warra_rupe/warra_rupe_head.png");
    public static final Logger LOGGER = LogManager.getLogger();

    public WarraRupeHeadRenderer(EntityRendererManager manager) {
        super(manager, new WorraRupeHeadModel<>(), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(WarraRupeHeadEntity p_110775_1_) { return TEXTURE; }
}
