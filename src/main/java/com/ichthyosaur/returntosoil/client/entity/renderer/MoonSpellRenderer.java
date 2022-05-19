package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.layer.BaruGaruGreenLayer;
import com.ichthyosaur.returntosoil.client.entity.model.BaruGaruModel;
import com.ichthyosaur.returntosoil.client.entity.model.spell.MoonModel;
import com.ichthyosaur.returntosoil.common.entity.BaruGaruEntity;
import com.ichthyosaur.returntosoil.common.entity.SpellEntity;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.TridentModel;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class MoonSpellRenderer extends EntityRenderer<SpellEntity> {


    public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/spell/moon/moon_blue.png");
    private final MoonModel model = new MoonModel();

    private Minecraft mc = Minecraft.getInstance();

    public MoonSpellRenderer(EntityRendererManager manager) {
        super(manager);
    }

    //places the model
    public void render(SpellEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {

        //we have to rotate/scale the matrix before we render the model/item!

        p_225623_4_.pushPose();

        p_225623_4_.translate(0,0,0);

        p_225623_4_.scale(2.0F, 2.0F, 2.0F);

        p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(
                rollChance.get360Degrees(p_225623_1_.getYRot()-90)

        ));
        p_225623_4_.mulPose(Vector3f.ZP.rotationDegrees(
                p_225623_1_.getXRot()-45
        ));



        //spins forward
        //p_225623_4_.mulPose(Vector3f.ZP.rotationDegrees(-5*p_225623_1_.tickCount));

        ItemStack stack = new ItemStack(ItemInit.MAGIC_SWORD_ITEM.get(),1);
        IBakedModel model = mc.getItemRenderer().getModel(stack, null, null);
        mc.getItemRenderer().render(stack, ItemCameraTransforms.TransformType.GROUND, true,p_225623_4_, p_225623_5_,
                200, p_225623_6_, model);

        //this stuff was for a separate model rather than an item model
        /*this.model.setupAnim(0,p_225623_1_.getYRot(),p_225623_1_.getXRot());
        IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getFoilBufferDirect(p_225623_5_, this.model.renderType(this.getTextureLocation(p_225623_1_)), false,false);
        this.model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        */

        p_225623_4_.popPose();




        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    @Override
    public ResourceLocation getTextureLocation(SpellEntity p_110775_1_) {
        return TEXTURE;
    }

}