package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;


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
                    Block.popResource(world, pos.above(), randomSeedResult());

                    this.refineProgress = 0;
                    int newFuelLevel = state.getValue(FUEL_LEVEL) - 1;
                    BlockState news = state.setValue(FUEL_LEVEL,newFuelLevel);
                    world.setBlock(pos, news,2);

                }
                else this.refineProgress += 1;
            }


        }
    }


    public static ItemStack randomSeedResult() {

        int i = (int) rollChance.returnRoll(100);
        //we bump this up as we add shit
        if (i < 4) {
            switch (i) {
                case 1:  return new ItemStack(BlockItemInit.LILYPAD_LANTERN_SEED.get(),1);
                case 2:  return new ItemStack(BlockItemInit.SPRING_LEAF_SEED.get(),1);
                case 3:  return new ItemStack(BlockItemInit.VESSEL_SEED.get(),1);
                }
        }
        else if (i < 40) return new ItemStack(Items.WHEAT_SEEDS,1);
        else if (i < 75) return new ItemStack(Items.SWEET_BERRIES,1);
        else if (i < 80) return new ItemStack(Items.BEETROOT_SEEDS,1);
        else if (i < 85) return new ItemStack(Items.CARROT,1);
        else if (i < 90) return new ItemStack(Items.PUMPKIN_SEEDS,1);
        else if (i < 95) return new ItemStack(Items.POTATO,1);
        else return new ItemStack(Items.MELON_SEEDS,1);

        return new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get(),1);
    }

    private Item randomItem(int count){
        Item item = Item.byId((int)rollChance.returnRoll(3000));
        if (count > 50) return Items.WHEAT_SEEDS;
        else if (item != null) return item;
        else return randomItem(count + 1);
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
