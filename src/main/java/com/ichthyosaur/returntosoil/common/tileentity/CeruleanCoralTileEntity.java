package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

//powered, causes living entities around it to float
public class CeruleanCoralTileEntity extends TileEntity implements ITickableTileEntity,IHoldsSpirit{

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;
    private float spiritLevel; //held info


    public CeruleanCoralTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public CeruleanCoralTileEntity() {
        this(TileEntityTypesInit.CERULEAN_CORAL_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        World world = this.level;
        BlockPos pos = this.getBlockPos();
        BlockState state = this.getBlockState();

        //this doesn't work if its only serverside...
        if (this.spiritLevel < 1 && !(world.isClientSide)) {world.setBlock(pos, state.setValue(FUEL_LEVEL, 0), 2); }

        else if (this.spiritLevel > 0){
                this.spiritLevel -= 1;
        }

        if (this.spiritLevel > 0 && !(world.isClientSide)) world.setBlock(pos, state.setValue(FUEL_LEVEL, 1), 2);

        //if (this.spiritLevel < 1 && !(this.level.isClientSide)) {world.setBlock(pos, state.setValue(FUEL_LEVEL, 0), 2); }
        //else if (this.spiritLevel > 0 && !(this.level.isClientSide)) world.setBlock(pos, state.setValue(FUEL_LEVEL, 1), 2);
    }

    public void spiritLevelAdd(float number) {this.spiritLevel+=number;}
    public float getSpiritLevel(){return this.spiritLevel;}

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


