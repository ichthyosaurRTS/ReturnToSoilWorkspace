package com.ichthyosaur.returntosoil.client.entity.renderer;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.layer.BaruGaruGreenLayer;
import com.ichthyosaur.returntosoil.client.entity.model.BaruGaruModel;
import com.ichthyosaur.returntosoil.client.entity.model.spell.MoonModel;
import com.ichthyosaur.returntosoil.common.entity.BaruGaruEntity;
import com.ichthyosaur.returntosoil.common.entity.SpellEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.TridentModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

public class MoonSpellRenderer extends EntityRenderer<SpellEntity> {


    public static final ResourceLocation TEXTURE = new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/spell/moon/moon_blue.png");
    private final MoonModel model = new MoonModel();

    public MoonSpellRenderer(EntityRendererManager manager) {
        super(manager);
    }

    //places the model
    public void render(SpellEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        p_225623_4_.pushPose();

        //that 3rd one is skinniness
        p_225623_4_.scale(1.0F, 1.0F, 1.0F);

        //float f = MathHelper.rotlerp(p_225623_1_.yRotO, p_225623_1_.yRot, p_225623_3_);
        //float f1 = MathHelper.lerp(p_225623_3_, -0.78F, p_225623_1_.xRot);
        //this.model.setupAnim(0.0F, f, f1);
        //works, with degrees!
        //p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(90F));
        //p_225623_4_.mulPose(Vector3f.ZP.rotationDegrees(90F));

        //also works with degrees!
        //this.model.setupAnim(0,90,90);



        this.model.setupAnim(0,p_225623_1_.getYRot(),p_225623_1_.getXRot());

        IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getFoilBufferDirect(p_225623_5_, this.model.renderType(this.getTextureLocation(p_225623_1_)), false,true);
        this.model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        p_225623_4_.popPose();



        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    @Override
    public ResourceLocation getTextureLocation(SpellEntity p_110775_1_) {
        return TEXTURE;
    }

}
