package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.layer.JudasSheepWoolLayer;
import com.ichthyosaur.returntosoil.client.entity.model.JoyfulEelHeadModel;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepBodyModel;
import com.ichthyosaur.returntosoil.common.entity.JoyfulEelHeadEntity;
import com.ichthyosaur.returntosoil.common.entity.JudasSheepBodyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class JoyfulEelHeadRenderer extends MobRenderer<JoyfulEelHeadEntity, JoyfulEelHeadModel<JoyfulEelHeadEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/joyful_eel/joyful_eel_head.png");
    public static final Logger LOGGER = LogManager.getLogger();

    public JoyfulEelHeadRenderer(EntityRendererManager manager) {
        super(manager, new JoyfulEelHeadModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(JoyfulEelHeadEntity p_110775_1_) { return TEXTURE; }
}
