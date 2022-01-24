package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class CrystalPlantBlock extends RTSCropsBlock implements IPottable{
    public CrystalPlantBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemInit.CRYSTAL_PLANT_SEED.get();
    }
    @Override
    protected boolean rollReplant(){
        return rollChance.roll(2);
    }
    @Override
    protected boolean useSeedDrop(){
        return false;
    }
    @Override
    protected Item getNonSeedDrop(){
        return ItemInit.SPIRIT_CRYSTAL_ITEM.get();
    }
    @Override
    protected Item getSeed(){
        return ItemInit.CRYSTAL_PLANT_SEED.get();
    }
    @Override
    protected SoundEvent getHarvestSound(){return SoundEvents.CROP_PLANTED;}

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnMobEntity(worldIn, pos, EntityTypesInit.DRAGONFLY.get().create(worldIn));
        else if (rollChance.roll(200)) for (int j = 0; j < 10; j++) spawnMobEntity(worldIn, pos, EntityTypesInit.DRAGONFLY.get().create(worldIn));
    }


    @Override
    public ItemStack getPotItem() {
        return new ItemStack(ItemInit.CRYSTAL_PLANT_POTTED_ITEM.get());
    }
}
