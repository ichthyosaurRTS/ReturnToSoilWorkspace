package com.ichthyosaur.returntosoil.client.entity.ExtraLayer;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.model.BaruGaruSegmentModel;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepBodyModel;
import com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel.JudasSheepWoolModel;
import com.ichthyosaur.returntosoil.common.entity.BaruGaruSegmentEntity;
import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepBodyEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;

public class JudasSheepWoolLayer<T extends JudasSheepBodyEntity> extends LayerRenderer<T, JudasSheepBodyModel<T>> {

    private static final ResourceLocation SHEEP_FUR_LOCATION = new ResourceLocation(RTSMain.MOD_ID, "textures/entity/judas_sheep/judas_sheep_wool.png");
    private final JudasSheepWoolModel<T> model = new JudasSheepWoolModel<T>();

    public JudasSheepWoolLayer(IEntityRenderer<T, JudasSheepBodyModel<T>> renderer) {
        super(renderer);
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {

        float f;
        float f1;
        float f2;

        if (p_225628_4_.hasWool() && !p_225628_4_.isInvisible()) {

            float[] afloat = SheepEntity.getColorArray(DyeColor.GRAY);
            f = afloat[0];
            f1 = afloat[1];
            f2 = afloat[2];

            coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, SHEEP_FUR_LOCATION, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, f, f1, f2);
        }
    }

}

