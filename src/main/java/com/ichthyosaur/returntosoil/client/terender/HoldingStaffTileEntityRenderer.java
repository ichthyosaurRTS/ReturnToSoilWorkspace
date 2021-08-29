package com.ichthyosaur.returntosoil.client.terender;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.HoldingStaffTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;

public class HoldingStaffTileEntityRenderer extends TileEntityRenderer<HoldingStaffTileEntity> {

    private Minecraft mc = Minecraft.getInstance();

    public HoldingStaffTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    public void render(HoldingStaffTileEntity te, float partialTicks, MatrixStack matrixStackIn,
                       IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {


        if (!te.hasItem()) {
            RTSMain.LOGGER.info("NO ITEM TO RENDER");
            //return;
        }

        int lightLevel = getLightLevel(te.getLevel(), te.getBlockPos().above());

        renderItem(new ItemStack(te.holdingItem()), new double[] { 0.5d, 1d, 0.5d },
                Vector3f.YP.rotationDegrees(90), matrixStackIn, bufferIn, partialTicks,
                combinedOverlayIn, lightLevel, 0.8f);

        RTSMain.LOGGER.info("NOW TRYING TO RENDER: "+te.holdingItem());

    }

    private void renderItem(ItemStack stack, double[] translation, Quaternion rotation, MatrixStack matrixStack,
                            IRenderTypeBuffer buffer, float partialTicks, int combinedOverlay, int lightLevel, float scale) {
        matrixStack.pushPose();
        matrixStack.translate(translation[0], translation[1], translation[2]);
        matrixStack.mulPose(rotation);
        matrixStack.scale(scale, scale, scale);

        IBakedModel model = mc.getItemRenderer().getModel(stack, null, null);
        mc.getItemRenderer().render(stack, ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer,
                lightLevel, combinedOverlay, model);
        matrixStack.popPose();
    }


    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightEmission(pos);
        int sLight = world.getLightEmission(pos);
        return LightTexture.pack(bLight, sLight);
    }

}
