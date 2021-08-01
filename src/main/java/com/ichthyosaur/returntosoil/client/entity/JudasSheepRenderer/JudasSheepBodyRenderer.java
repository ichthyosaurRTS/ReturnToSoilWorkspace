package com.ichthyosaur.returntosoil.client.entity.JudasSheepRenderer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.ExtraLayer.JudasSheepWoolLayer;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepBodyModel;
import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepBodyEntity;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//looks like the entity is not being given to here, but rather the class?
public class JudasSheepBodyRenderer extends MobRenderer<JudasSheepBodyEntity, JudasSheepBodyModel<JudasSheepBodyEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_body.png");
    public static final Logger LOGGER = LogManager.getLogger();

    public JudasSheepBodyRenderer(EntityRendererManager manager) {
        super(manager, new JudasSheepBodyModel<>(), 0.7f);
        this.addLayer(new JudasSheepWoolLayer<>(this)

        );
    }

    //this entity is correct but still returning false...?
    @Override
    public boolean shouldRender(JudasSheepBodyEntity p_225626_1_, ClippingHelper p_225626_2_, double p_225626_3_, double p_225626_5_, double p_225626_7_) {
        LOGGER.info(""+p_225626_1_.hasWool());
        LOGGER.info(""+p_225626_1_.getY());
        return super.shouldRender(p_225626_1_, p_225626_2_, p_225626_3_, p_225626_5_, p_225626_7_);
    }

    @Override
    public ResourceLocation getTextureLocation(JudasSheepBodyEntity p_110775_1_) { return TEXTURE; }
}
