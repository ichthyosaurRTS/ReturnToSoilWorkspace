package com.ichthyosaur.returntosoil.client.entity.GhostRamRenderer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepBodyModel;
import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepBodyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class JudasSheepBodyRenderer extends MobRenderer<JudasSheepBodyEntity, JudasSheepBodyModel<JudasSheepBodyEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_body.png");

    public JudasSheepBodyRenderer(EntityRendererManager manager) {
        super(manager, new JudasSheepBodyModel<>(), 0.7f
        );
    }

    @Override
    public ResourceLocation getTextureLocation(JudasSheepBodyEntity p_110775_1_) { return TEXTURE; }
}
