package com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel;

import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepBodyEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class JudasSheepWoolModel<T extends JudasSheepBodyEntity> extends JudasSheepBodyModel<T> {

    public static final Logger LOGGER = LogManager.getLogger();

    public JudasSheepWoolModel() {
        super();
        texWidth = 128;
        texHeight = 128;


        ModelRenderer wool = new ModelRenderer(this);
        wool.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(wool);
        wool.texOffs(0, 0).addBox(-10.0F, -8.0F, -11.0F, 20.0F, 14.0F, 24.0F, 0.0F, false);

    }

}
