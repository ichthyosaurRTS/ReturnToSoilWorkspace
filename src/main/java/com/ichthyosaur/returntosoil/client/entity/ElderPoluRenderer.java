package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.ElderPoluModel;
import com.ichthyosaur.returntosoil.client.entity.model.JawBeetleModel;
import com.ichthyosaur.returntosoil.common.Entity.ElderPoluEntity;
import com.ichthyosaur.returntosoil.common.Entity.NomadSnailEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ElderPoluRenderer extends MobRenderer<ElderPoluEntity, ElderPoluModel<ElderPoluEntity>> {

    public ElderPoluRenderer(EntityRendererManager manager) {
        super(manager, new ElderPoluModel<>(), 0.7f);

    }
    @MethodsReturnNonnullByDefault
    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/elder_polu/elder_polu_green.png");

    @Override
    public ResourceLocation getTextureLocation(ElderPoluEntity p_110775_1_) {
        return TEXTURE;
    }

}
