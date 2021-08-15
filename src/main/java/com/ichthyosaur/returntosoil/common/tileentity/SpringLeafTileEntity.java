package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;

public class SpringLeafTileEntity extends TileEntity implements ITickableTileEntity {

    public static final IntegerProperty COOL_DOWN = RTSMain.COOL_DOWN;

    public SpringLeafTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public SpringLeafTileEntity() {
        this(TileEntityTypesInit.SPRING_LEAF_TILE_ENTITY_TYPE.get());
    }

    //I wanted the jumping tick in here but oh well (is on block events)
    @Override
    public void tick() {
    }

}
