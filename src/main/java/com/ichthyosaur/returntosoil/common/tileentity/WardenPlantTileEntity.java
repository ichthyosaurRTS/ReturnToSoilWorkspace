package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;

public class WardenPlantTileEntity extends TileEntity implements ITickableTileEntity{

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;
    private float spiritLevel;

    public WardenPlantTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public WardenPlantTileEntity() {
        this(TileEntityTypesInit.WARDEN_PLANT_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        World world = this.level;
        BlockPos pos = this.getBlockPos();
        BlockState state = this.getBlockState();

        if (this.spiritLevel == 0) world.setBlock(pos, state.setValue(FUEL_LEVEL, 0), 2);

        else {
            this.spiritLevel -= 1;
        }


    }

    public void spiritLevelAdd(float number) {this.spiritLevel+=number;}

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putFloat("spirit_level",this.spiritLevel);
        return super.save(nbt);
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT nbt) {
        super.load(p_230337_1_, nbt);
        if (nbt.contains("spirit_level")) this.spiritLevel = nbt.getFloat("spirit_level");
    }

}


