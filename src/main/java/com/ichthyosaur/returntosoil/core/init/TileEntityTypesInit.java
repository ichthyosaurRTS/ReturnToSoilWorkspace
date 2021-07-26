package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.RefineryPlantTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class TileEntityTypesInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RTSMain.MOD_ID);


    public static final RegistryObject<TileEntityType<RefineryPlantTileEntity>> REFINERY_PLANT_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("refinery_plant", () ->
                    TileEntityType.Builder.of(RefineryPlantTileEntity::new, BlockItemInit.REFINERY_PLANT_GROWN_BLOCK.get()).build(null));


}
