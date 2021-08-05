package com.ichthyosaur.returntosoil.client.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.layer.JudasSheepWoolLayer;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepBodyModel;
import com.ichthyosaur.returntosoil.common.entity.JudasSheepBodyEntity;
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
        this.addLayer(new JudasSheepWoolLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(JudasSheepBodyEntity p_110775_1_) {
        //LOGGER.info(""+p_110775_1_.hasWool());
        return TEXTURE; }
}
