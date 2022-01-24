package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.common.tileentity.RefinementBarrelTileEntity;
import com.ichthyosaur.returntosoil.core.config.RTSConfigMisc;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class CrystalPlantBlock extends RTSCropsBlock{
    public CrystalPlantBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return BlockItemInit.CRYSTAL_PLANT_SEED.get();
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
        return BlockItemInit.SPIRIT_CRYSTAL_ITEM.get();
    }
    @Override
    protected Item getSeed(){
        return BlockItemInit.CRYSTAL_PLANT_SEED.get();
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnMobEntity(worldIn, pos, EntityTypesInit.DRAGONFLY.get().create(worldIn));
        else if (rollChance.roll(200)) for (int j = 0; j < 10; j++) spawnMobEntity(worldIn, pos, EntityTypesInit.DRAGONFLY.get().create(worldIn));
    }


}
