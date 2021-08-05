package com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel;

import com.ichthyosaur.returntosoil.common.entity.JudasSheepBodyEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class JudasSheepWoolModel<T extends JudasSheepBodyEntity> extends JudasSheepBodyModel<T> {

    public static final Logger LOGGER = LogManager.getLogger();
    private final ModelRenderer wool;

    public JudasSheepWoolModel() {
        texWidth = 128;
        texHeight = 128;

        wool = new ModelRenderer(this);
        wool.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(wool);
        wool.texOffs(0, 0).addBox(-10.0F, -8.0F, -11.0F, 20.0F, 17.0F, 21.0F, 0.0F, false);
        wool.texOffs(0, 17).addBox(10.0F, 9.0F, -11.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
        wool.texOffs(0, 40).addBox(-10.0F, 9.0F, -11.0F, 20.0F, 2.0F, 0.0F, 0.0F, false);
        wool.texOffs(0, 40).addBox(-10.0F, 9.0F, 10.0F, 20.0F, 2.0F, 0.0F, 0.0F, false);
        wool.texOffs(0, 17).addBox(-10.0F, 9.0F, -11.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
    }

}
