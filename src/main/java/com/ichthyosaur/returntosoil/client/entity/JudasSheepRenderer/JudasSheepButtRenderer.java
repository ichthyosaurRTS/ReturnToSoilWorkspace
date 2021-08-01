package com.ichthyosaur.returntosoil.client.entity.JudasSheepRenderer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepButtModel;
import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepButtEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class JudasSheepButtRenderer extends MobRenderer<JudasSheepButtEntity, JudasSheepButtModel<JudasSheepButtEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_body.png");

    public JudasSheepButtRenderer(EntityRendererManager manager) {
        super(manager, new JudasSheepButtModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(JudasSheepButtEntity p_110775_1_) { return TEXTURE; }
}
