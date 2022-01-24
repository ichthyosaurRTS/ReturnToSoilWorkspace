package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
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
        return new ItemStack(BlockItemInit.ERMTHRUS_LANTERN_POTTED_ITEM.get());
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return BlockItemInit.ERMTHRUS_LANTERN_SEED.get();
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
        return BlockItemInit.ORIGIN_BERRY_SEED.get();
    }
    @Override
    protected Item getSeed(){
        return BlockItemInit.ERMTHRUS_LANTERN_SEED.get();
    }
}
