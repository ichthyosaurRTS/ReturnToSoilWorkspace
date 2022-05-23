package com.ichthyosaur.returntosoil;


import com.ichthyosaur.returntosoil.client.entity.renderer.MoonSpellRenderer;
import com.ichthyosaur.returntosoil.common.entity.*;
import com.ichthyosaur.returntosoil.core.config.RTSConfig;
import com.ichthyosaur.returntosoil.core.init.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod("returntosoil")
public class ReturnToSoil
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "returntosoil";

    //Who knows where this goes...
    public static final BooleanProperty INFESTED = BooleanProperty.create("infested");
    public static final IntegerProperty FUEL_LEVEL = IntegerProperty.create("fuel_level",0,7);
    public static final IntegerProperty ROTATION_4 = IntegerProperty.create("rotation", 0, 3);
    public static final IntegerProperty AGE_8 = IntegerProperty.create("age", 0, 8);

    public ReturnToSoil() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ParticleTypesInit.PARTICLES.register(bus);
        EntityTypesInit.ENTITY_TYPES.register(bus);
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
        ContainerTypesInit.CONTAINER_TYPES.register(bus);
        EffectInit.EFFECTS.register(bus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RTSConfig.SPEC, "returntosoil-common.toml");

        MinecraftForge.EVENT_BUS.register(this);

    }


    @SuppressWarnings("deprecation")
    private void setup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {

            GlobalEntityTypeAttributes.put(EntityTypesInit.HUSKLARVAE.get(), HuskLarvaeEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.JAWBEETLE.get(), JawBeetleEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.DRAGONFLY.get(), DragonflyEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.BARUGARU.get(), BaruGaruEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.BARUGARUSEGMENT.get(), BaruGaruSegmentEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.VESSEL.get(), VesselEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.GENERALFLYINGSEGMENT.get(), AbstractFlyingSegmentEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.WARRARUPEHEAD.get(), WarraRupeHeadEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.GAWANHEAD.get(), GawanHeadEntity.setCustomAttributes().build());

        });
    }

    // no clue what this does
    /*private void registerEntityModels(Supplier<Minecraft> minecraft) {

        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.SPELL.get(), (renderManager) -> new MoonSpellRenderer(renderManager));
    }*/
}
