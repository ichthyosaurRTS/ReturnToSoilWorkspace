package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class RefineryPlantTileEntity extends TileEntity implements ITickableTileEntity {

    public RefineryPlantTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public RefineryPlantTileEntity() {
        this(TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {

    }
}
