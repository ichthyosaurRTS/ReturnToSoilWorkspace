package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.model.spell.MoonModel;
import com.ichthyosaur.returntosoil.common.entity.SpellEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class MoonSpellRenderer extends EntityRenderer<SpellEntity> {


    public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/particle/light_ball/light_ball_0.png");
    private final MoonModel model = new MoonModel();

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(ReturnToSoil.MOD_ID,"textures/particle/light_ball/light_ball_3.png");
    private static final RenderType RENDER_TYPE = RenderType.entityTranslucent(TEXTURE_LOCATION);

    private Minecraft mc = Minecraft.getInstance();

    public MoonSpellRenderer(EntityRendererManager manager) {
        super(manager);
    }

    //places the model
    public void render(SpellEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {

        //we have to rotate/scale the matrix before we render the model/item!

        /*p_225623_4_.pushPose();
        p_225623_4_.translate(0,0,0);
        p_225623_4_.scale(2.0F, 2.0F, 2.0F);
        p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(
                rollChance.get360Degrees(p_225623_1_.getYRot()-90)
        ));
        p_225623_4_.mulPose(Vector3f.ZP.rotationDegrees(
                p_225623_1_.getXRot()-45
        ));

        ItemStack stack = new ItemStack(ItemInit.MAGIC_SWORD_ITEM.get(),1);
        IBakedModel model = mc.getItemRenderer().getModel(stack, null, null);
        //that 3rd last int sees to do lighting and or opacity... 400 is see thru, 200 is normal and 20 is super dark
        mc.getItemRenderer().render(stack, ItemCameraTransforms.TransformType.GROUND, true,p_225623_4_, p_225623_5_,
                230, p_225623_6_, model);
        p_225623_4_.popPose();


        //spins forward
        //p_225623_4_.mulPose(Vector3f.ZP.rotationDegrees(-5*p_225623_1_.tickCount));


        //this stuff was for a separate model rather than an item model
        /*this.model.setupAnim(0,p_225623_1_.getYRot(),p_225623_1_.getXRot());
        IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getFoilBufferDirect(p_225623_5_, this.model.renderType(this.getTextureLocation(p_225623_1_)), false,false);
        this.model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        */



        //looks like we can push 2 separate poses without trouble. could definitely use this for ball spell if we wanted.

        p_225623_4_.pushPose();
        p_225623_4_.translate(0,-0.2,0);
        p_225623_4_.scale(0.3F, 0.3F, 0.3F);
        //since its clientside, just make the model face the player like a particle does. now how to do opacity....
        p_225623_4_.mulPose(this.entityRenderDispatcher.cameraOrientation());
        p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(180.0F));

        //if the texture is cut out, make sure the model matches up correctly to the texture.
        IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getFoilBufferDirect(p_225623_5_, RENDER_TYPE, false,false);
        this.model.renderToBuffer(p_225623_4_, ivertexbuilder, 240, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        p_225623_4_.popPose();


        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }


    @Override
    public ResourceLocation getTextureLocation(SpellEntity p_110775_1_) {
        return TEXTURE;
    }

}
