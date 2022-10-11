package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.layer.CentipedeGreenLayer;
import com.ichthyosaur.returntosoil.client.entity.model.CentipedeModel;
import com.ichthyosaur.returntosoil.common.entity.CentipedeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CentipedeRenderer extends MobRenderer<CentipedeEntity, CentipedeModel<CentipedeEntity>> {


    public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/baru_garu/baru_garu.png");

    public CentipedeRenderer(EntityRendererManager manager) {
        super(manager, new CentipedeModel<>(), 0.7f);
        this.addLayer(new CentipedeGreenLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(CentipedeEntity p_110775_1_) { return TEXTURE; }
}
