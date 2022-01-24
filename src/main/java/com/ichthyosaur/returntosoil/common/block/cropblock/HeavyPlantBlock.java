package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockInit;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

//Rarity abyss (4) ; only grows in rain...?
public class HeavyPlantBlock extends RTSCropsBlock implements IPottable{
    public HeavyPlantBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemInit.HEAVY_PLANT_SEED.get();
    }
    @Override
    protected boolean rollReplant(){
        return false;
    }
    @Override
    protected boolean useSeedDrop(){
        return false;
    }
    @Override
    protected Item getNonSeedDrop(){
        return ItemInit.HEAVY_FRUIT_ITEM.get();
    }
    @Override
    protected Item getSeed(){
        return ItemInit.HEAVY_PLANT_SEED.get();
    }

    @Override
    public ItemStack getPotItem() {
        return new ItemStack(ItemInit.HEAVY_PLANT_POTTED_ITEM.get());
    }
}
