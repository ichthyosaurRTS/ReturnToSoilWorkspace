package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.container.RefineryPlantContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, RTSMain.MOD_ID);

    public static final RegistryObject<ContainerType<RefineryPlantContainer>> REFINERY_PLANT_CONTAINER_TYPE = CONTAINER_TYPES.register("refinery_plant", () ->
            IForgeContainerType.create(RefineryPlantContainer::new));

}
