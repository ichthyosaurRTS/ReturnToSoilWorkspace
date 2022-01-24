package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.container.RefinementBaAdvContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, ReturnToSoil.MOD_ID);

    public static final RegistryObject<ContainerType<RefinementBaAdvContainer>> REFINEMENT_BA_ADV_CONTAINER_TYPE = CONTAINER_TYPES.register("refinement_ba_adv", () ->
            IForgeContainerType.create(RefinementBaAdvContainer::new));
}
