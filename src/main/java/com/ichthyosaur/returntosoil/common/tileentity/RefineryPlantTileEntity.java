package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class RefineryPlantTileEntity extends TileEntity implements ITickableTileEntity {

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;
    public int refineProgress = 0;

    public RefineryPlantTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public RefineryPlantTileEntity() {
        this(TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {

        //if fueled, check the progress -> if at 200, pop resource and update state; else add to the progress
        if (this.level!=null) {
            World world = this.level;
            BlockPos pos =this.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getValue(FUEL_LEVEL)>0) {
                if (this.refineProgress >= 5000) {
                    Block.popResource(world, pos.above(), randomDropResult());

                    this.refineProgress = 0;
                    int newFuelLevel = state.getValue(FUEL_LEVEL) - 1;
                    BlockState news = state.setValue(FUEL_LEVEL,newFuelLevel);
                    world.setBlock(pos, news,2);

                }
                else this.refineProgress += 1;
            }


        }
    }


    private ItemStack randomDropResult() {
        return new ItemStack(BlockItemInit.LILYPAD_LANTERN_SEED.get(),1);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        nbt.putInt("progress",this.refineProgress);
        return nbt;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.refineProgress = nbt.getInt("progress");
    }
}
