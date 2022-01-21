package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RTSMain.MOD_ID);


    public static final RegistryObject<TileEntityType<RefinementBarrelTileEntity>> REFINEMENT_BARREL_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("refinement_barrel", () ->
                    TileEntityType.Builder.of(RefinementBarrelTileEntity::new, BlockItemInit.REFINEMENT_BARREL_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<WardenPlantTileEntity>> WARDEN_PLANT_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("warden_plant", () ->
                    TileEntityType.Builder.of(WardenPlantTileEntity::new, BlockItemInit.WARDEN_PLANT_POTTED_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<ErmthrusLanternTileEntity>> ERMTHRUS_LANTERN_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("ermthrus_lantern", () ->
                    TileEntityType.Builder.of(ErmthrusLanternTileEntity::new, BlockItemInit.ERMTHRUS_LANTERN_POTTED_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<CeruleanCoralTileEntity>> CERULEAN_CORAL_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("cerulean_coral", () ->
                    TileEntityType.Builder.of(CeruleanCoralTileEntity::new, BlockItemInit.CERULEAN_CORAL_POTTED_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<RefinementBaAdvTileEntity>> REFINEMENT_BA_ADV_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("refinement_ba_adv", () ->
                    TileEntityType.Builder.of(RefinementBaAdvTileEntity::new, BlockItemInit.REFINEMENT_BARREL_ADV_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<HoldingStaffTileEntity>> HOLDING_STAFF_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("holding_staff",
                    () -> TileEntityType.Builder.of(HoldingStaffTileEntity::new, BlockItemInit.HOLDING_STAFF_BLOCK.get()).build(null));
}
