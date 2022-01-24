package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockInit;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

public class WardenPlantBlock extends RTSCropsBlock implements IPottable{
    public WardenPlantBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemInit.WARDEN_PLANT_SEED.get();
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
        return ItemInit.GLASSY_EYEBALL_ITEM.get();
    }
    @Override
    protected Item getSeed(){
        return ItemInit.WARDEN_PLANT_SEED.get();
    }

    @Override
    public ItemStack getPotItem() {
        return new ItemStack(ItemInit.WARDEN_PLANT_POTTED_ITEM.get());
    }
}
