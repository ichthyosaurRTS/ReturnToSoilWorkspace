package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.tileentity.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ReturnToSoil.MOD_ID);


    public static final RegistryObject<TileEntityType<RefinementBarrelTileEntity>> REFINEMENT_BARREL_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("refinement_barrel", () ->
                    TileEntityType.Builder.of(RefinementBarrelTileEntity::new, BlockInit.REFINEMENT_BARREL_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<RefinementBaAdvTileEntity>> REFINEMENT_BA_ADV_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("refinement_ba_adv", () ->
                    TileEntityType.Builder.of(RefinementBaAdvTileEntity::new, BlockInit.REFINEMENT_BARREL_ADV_BLOCK.get()).build(null));

}
