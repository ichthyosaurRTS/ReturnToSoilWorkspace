package com.ichthyosaur.returntosoil.core.util;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.renderer.*;
import com.ichthyosaur.returntosoil.client.particle.GoneParticle;
import com.ichthyosaur.returntosoil.client.particle.LightBallParticle;
import com.ichthyosaur.returntosoil.client.screen.RefinementBaAdvScreen;
import com.ichthyosaur.returntosoil.client.terender.HoldingStaffTileEntityRenderer;
import com.ichthyosaur.returntosoil.core.init.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ReturnToSoil.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        ScreenManager.register(ContainerTypesInit.REFINEMENT_BA_ADV_CONTAINER_TYPE.get(), RefinementBaAdvScreen::new);

        RenderTypeLookup.setRenderLayer(BlockInit.ORIGIN_BERRY_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.ORIGIN_BERRY_POTTED_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.LILYPAD_LANTERN_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.VESSEL_VINE_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.VESSEL_SAC_BLOCK.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BlockInit.WARDEN_PLANT_POTTED_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.CRYSTAL_PLANT_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.CRYSTAL_PLANT_POTTED_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.TOTEM_STALK_BLOCK.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlockInit.HOLDING_STAFF_BLOCK.get(), RenderType.cutout());
        ClientRegistry.bindTileEntityRenderer(TileEntityTypesInit.HOLDING_STAFF_TILE_ENTITY_TYPE.get(), HoldingStaffTileEntityRenderer::new);
        
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUSKLARVAE.get(), HuskLarvaeEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.JAWBEETLE.get(), JawBeetleRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.DRAGONFLY.get(), DragonflyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.BARUGARU.get(), BaruGaruRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.BARUGARUSEGMENT.get(), BaruGaruSegmentRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.VESSEL.get(), VesselRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.GENERALFLYINGSEGMENT.get(), GeneralFlyingSegmentRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.WARRARUPEHEAD.get(), WarraRupeHeadRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.GAWANHEAD.get(), GawanHeadRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.GARAGOGA.get(), GaraGogaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.CANNONMOLLUSC.get(), CannonMolluscRenderer::new);

        //links entity to renderer
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.SPELL.get(), MoonSpellRenderer::new);

    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleTypesInit.GONE_PARTICLE.get(), GoneParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleTypesInit.LIGHT_BALL_PARTICLE.get(), LightBallParticle.Factory::new);
    }
}