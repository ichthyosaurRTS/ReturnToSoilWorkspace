package com.ichthyosaur.returntosoil.common.block.machine;

import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class RefineryPlantBlock extends Block {
    public RefineryPlantBlock() {
        super(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.BAMBOO));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get().create();
    }
}
