package com.ichthyosaur.returntosoil.client.entity.GhostRamRenderer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepHeadModel;
import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepHeadEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class JudasSheepHeadRenderer extends MobRenderer<JudasSheepHeadEntity, JudasSheepHeadModel<JudasSheepHeadEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_head.png");

    public JudasSheepHeadRenderer(EntityRendererManager manager) {
        super(manager, new JudasSheepHeadModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(JudasSheepHeadEntity p_110775_1_) { return TEXTURE; }
}
