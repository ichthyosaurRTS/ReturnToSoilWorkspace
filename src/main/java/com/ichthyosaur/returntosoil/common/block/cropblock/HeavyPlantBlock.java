package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

//Rarity abyss (4) ; only grows in rain...?
public class HeavyPlantBlock extends RTSCropsBlock implements IPottable{
    public HeavyPlantBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return BlockItemInit.HEAVY_PLANT_SEED.get();
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
        return BlockItemInit.HEAVY_FRUIT_ITEM.get();
    }
    @Override
    protected Item getSeed(){
        return BlockItemInit.HEAVY_PLANT_SEED.get();
    }

    @Override
    public ItemStack getPotItem() {
        return new ItemStack(BlockItemInit.HEAVY_PLANT_POTTED_ITEM.get());
    }
}
