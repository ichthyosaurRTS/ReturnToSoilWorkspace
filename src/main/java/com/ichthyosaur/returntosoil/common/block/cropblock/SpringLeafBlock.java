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

public class SpringLeafBlock extends RTSCropsBlock{

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


    public static void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnTallSnail(worldIn, pos); //normally 10
        else if (rollChance.roll(80)) for (int j = 0; j < 3; j++) {spawnTallSnail(worldIn, pos);} //small chance of horde normally 80
    }

    public static void spawnTallSnail(ServerWorld world, BlockPos pos) {
        TallSnailEntity entity = EntityTypesInit.TALLSNAIL.get().create(world);
        if (entity!=null) {
            entity.moveTo((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addFreshEntity(entity);
        }
        world.removeBlock(pos,false);
    }

    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {
        if (state.getValue(AGE)!=7||state.getValue(INFESTED)) {
            return ActionResultType.PASS;
        }
        else {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (item == Items.FLOWER_POT) {

                itemstack.shrink(1);

                ItemStack definiteDrops = new ItemStack(BlockItemInit.SPRING_LEAF_POTTED_BLOCK_ITEM.get(), 1);
                popResource(world, pos, definiteDrops);
                ItemStack berry = new ItemStack(BlockItemInit.SPRING_LEAF_BERRY_ITEM.get(), 1);
                popResource(world, pos, berry);

                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);

                return ActionResultType.SUCCESS;
            }
            else  return ActionResultType.PASS;
        }
    }
}
