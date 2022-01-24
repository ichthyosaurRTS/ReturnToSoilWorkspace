package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class ErmthrusLanternBlock extends RTSCropsBlock implements IPottable{
    public ErmthrusLanternBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnMobEntity(worldIn, pos, EntityTypesInit.WARRARUPEHEAD.get().create(worldIn));
        else if (rollChance.roll(200)) for (int j = 0; j < 10; j++) spawnMobEntity(worldIn, pos, EntityTypesInit.WARRARUPEHEAD.get().create(worldIn));
    }

    @Override
    public ItemStack getPotItem() {
        return new ItemStack(ItemInit.ERMTHRUS_LANTERN_POTTED_ITEM.get());
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemInit.ERMTHRUS_LANTERN_SEED.get();
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
        return ItemInit.ORIGIN_BERRY_SEED.get();
    }
    @Override
    protected Item getSeed(){
        return ItemInit.ERMTHRUS_LANTERN_SEED.get();
    }
}
