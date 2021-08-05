package com.ichthyosaur.returntosoil.client.entity.JudasSheepRenderer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepButtModelold;
import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepButtEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class JudasSheepButtRenderer extends MobRenderer<JudasSheepButtEntity, JudasSheepButtModelold<JudasSheepButtEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_butt.png");

    public JudasSheepButtRenderer(EntityRendererManager manager) {
        super(manager, new JudasSheepButtModelold<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(JudasSheepButtEntity p_110775_1_) { return TEXTURE; }
}
