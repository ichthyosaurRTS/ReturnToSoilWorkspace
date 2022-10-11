package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.layer.CentipedePartGreenLayer;
import com.ichthyosaur.returntosoil.client.entity.model.CentipedePartModel;
import com.ichthyosaur.returntosoil.common.entity.CentipedePartEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CentipedePartRenderer extends MobRenderer<CentipedePartEntity, CentipedePartModel<CentipedePartEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/baru_garu_segment/baru_garu_segment.png");

    public CentipedePartRenderer(EntityRendererManager manager) {
        super(manager, new CentipedePartModel<>(), 0.7f);
        this.addLayer(new CentipedePartGreenLayer<>(this));
    }


    @Override
    public ResourceLocation getTextureLocation(CentipedePartEntity p_110775_1_) { return TEXTURE; }

}
