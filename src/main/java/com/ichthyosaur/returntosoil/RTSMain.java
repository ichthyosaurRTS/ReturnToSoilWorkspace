package com.ichthyosaur.returntosoil;


import com.ichthyosaur.returntosoil.common.entity.*;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.ContainerTypesInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("returntosoil")
public class RTSMain
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "returntosoil";

    //Who knows where this goes...
    public static final BooleanProperty INFESTED = BooleanProperty.create("infested");
    public static final IntegerProperty FUEL_LEVEL = IntegerProperty.create("fuel_level",0,7);
    public static final IntegerProperty COOL_DOWN = IntegerProperty.create("cool_down",0,60);

    public RTSMain() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        EntityTypesInit.ENTITY_TYPES.register(bus);
        BlockItemInit.ITEMS.register(bus);
        BlockItemInit.BLOCKS.register(bus);
        TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
        ContainerTypesInit.CONTAINER_TYPES.register(bus);


        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

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

}
