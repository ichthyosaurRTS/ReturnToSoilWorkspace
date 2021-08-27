package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.HoldingStaffTileEntity;
import com.ichthyosaur.returntosoil.common.tileentity.RefineryPlantTileEntity;
import com.ichthyosaur.returntosoil.common.tileentity.SpringLeafTileEntity;
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
                    TileEntityType.Builder.of(RefineryPlantTileEntity::new, BlockItemInit.REFINERY_PLANT_POTTED_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<SpringLeafTileEntity>> SPRING_LEAF_TILE_ENTITY_TYPE =
            TILE_ENTITY_TYPE.register("spring_leaf", () ->
                    TileEntityType.Builder.of(SpringLeafTileEntity::new, BlockItemInit.SPRING_LEAF_POTTED_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<HoldingStaffTileEntity>> HOLDING_STAFF_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("holding_staff",
                    () -> TileEntityType.Builder.of(HoldingStaffTileEntity::new, BlockItemInit.HOLDING_STAFF_BLOCK.get()).build(null));
}
