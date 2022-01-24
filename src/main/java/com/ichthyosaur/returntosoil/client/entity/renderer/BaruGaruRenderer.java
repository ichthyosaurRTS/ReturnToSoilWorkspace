package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.layer.BaruGaruGreenLayer;
import com.ichthyosaur.returntosoil.client.entity.model.BaruGaruModel;
import com.ichthyosaur.returntosoil.common.entity.BaruGaruEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BaruGaruRenderer extends MobRenderer<BaruGaruEntity, BaruGaruModel<BaruGaruEntity>> {


    public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/baru_garu/baru_garu.png");

    public BaruGaruRenderer(EntityRendererManager manager) {
        super(manager, new BaruGaruModel<>(), 0.7f);
        this.addLayer(new BaruGaruGreenLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(BaruGaruEntity p_110775_1_) { return TEXTURE; }
}
