package com.ichthyosaur.returntosoil.core.util;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.client.entity.*;
import com.ichthyosaur.returntosoil.client.entity.JudasSheepBodyRenderer;
import com.ichthyosaur.returntosoil.client.entity.JudasSheepHeadRenderer;
import com.ichthyosaur.returntosoil.client.terender.HoldingStaffTileEntityRenderer;
import com.ichthyosaur.returntosoil.common.tileentity.HoldingStaffTileEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RTSMain.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        RenderTypeLookup.setRenderLayer(BlockItemInit.ORIGIN_BERRY_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.LILYPAD_LANTERN_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.REFINERY_PLANT_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.SPRING_LEAF_POTTED_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.SPRING_LEAF_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.VESSEL_VINE_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.VESSEL_SAC_BLOCK.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BlockItemInit.HEAVY_PLANT_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.DROUGHT_CACTUS_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.DROUGHT_CACTUS_POTTED_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.WARDEN_PLANT_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.WARDEN_PLANT_POTTED_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.GEMSTONE_PLANT_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.ERMTHRUS_LANTERN_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockItemInit.ERMTHRUS_LANTERN_POTTED_BLOCK.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlockItemInit.HOLDING_STAFF_BLOCK.get(), RenderType.cutout());
        ClientRegistry.bindTileEntityRenderer(TileEntityTypesInit.HOLDING_STAFF_TILE_ENTITY_TYPE.get(), HoldingStaffTileEntityRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUSKLARVAE.get(), HuskLarvaeEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.JAWBEETLE.get(), JawBeetleRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.BARUGARU.get(), BaruGaruRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.BARUGARUSEGMENT.get(), BaruGaruSegmentRenderer::new);
        //RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.FOURTAILEDFOX.get(), FourTailedFoxRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.BALLFROG.get(), BallFrogRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.TALLSNAIL.get(), TallSnailRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.VESSEL.get(), VesselRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.JUDASSHEEPHEAD.get(), JudasSheepHeadRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.JUDASSHEEPBODY.get(), JudasSheepBodyRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.GENERALFLYINGSEGMENT.get(), GeneralFlyingSegmentRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.WARRARUPEHEAD.get(), WarraRupeHeadRenderer::new);
    }
}