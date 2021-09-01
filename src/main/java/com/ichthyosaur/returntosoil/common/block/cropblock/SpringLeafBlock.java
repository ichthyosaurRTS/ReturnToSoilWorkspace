package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.common.entity.TallSnailEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpringLeafBlock extends RTSCropsBlock implements IPottable{

    public SpringLeafBlock(Properties properties) {
        super(properties);
    }

    @ParametersAreNonnullByDefault
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        if (state.getValue(INFESTED)) return drops;


        if (state.getValue(AGE)==7) {
            drops.add(new ItemStack(BlockItemInit.SPRING_LEAF_BERRY_ITEM.get()));
        }

        return drops;
    }


    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnMobEntity(worldIn, pos,EntityTypesInit.TALLSNAIL.get().create(worldIn)); //normally 10
        else if (rollChance.roll(80)) for (int j = 0; j < 3; j++) spawnMobEntity(worldIn, pos,EntityTypesInit.TALLSNAIL.get().create(worldIn)); //small chance of horde normally 80
    }

    @Override
    public ItemStack getPotItem() {
        return new ItemStack(BlockItemInit.SPRING_LEAF_POTTED_ITEM.get());
    }
}
