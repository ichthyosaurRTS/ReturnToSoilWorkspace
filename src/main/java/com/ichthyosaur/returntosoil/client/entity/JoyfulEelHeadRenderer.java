package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.JawBeetleModel;
import com.ichthyosaur.returntosoil.client.entity.model.JoyfulEelHeadModel;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.common.entity.JoyfulEelHeadEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class JoyfulEelHeadRenderer extends MobRenderer<JoyfulEelHeadEntity, JoyfulEelHeadModel<JoyfulEelHeadEntity>> {

    private static final ResourceLocation EEL_HEAD_TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/joyful_eel/empty.png");

    public JoyfulEelHeadRenderer(EntityRendererManager manager) {
        super(manager, new JoyfulEelHeadModel<>(), 0.4f);

    }

    @Override
    public ResourceLocation getTextureLocation(JoyfulEelHeadEntity entity) {
        return EEL_HEAD_TEXTURE;
    }
}
