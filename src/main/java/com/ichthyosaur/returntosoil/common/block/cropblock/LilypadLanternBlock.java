package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LilypadLanternBlock extends RTSCropsBlock{

    public LilypadLanternBlock (AbstractBlock.Properties properties) {
        super(properties);
    }

    protected boolean mayPlaceOn(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        FluidState fluidstate = p_200014_2_.getFluidState(p_200014_3_);
        FluidState fluidstate1 = p_200014_2_.getFluidState(p_200014_3_.above());
        return (fluidstate.getType() == Fluids.WATER || p_200014_1_.getMaterial() == Material.ICE) && fluidstate1.getType() == Fluids.EMPTY;
    }

    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnMobEntity(worldIn, pos,EntityTypesInit.BALLFROG.get().create(worldIn)); //normally 10
        else if (rollChance.roll(80)) for (int j = 0; j < 10; j++) spawnMobEntity(worldIn, pos,EntityTypesInit.BALLFROG.get().create(worldIn)); //small chance of horde normally 80
    }

    public boolean canSurvive(BlockState state, IWorldReader worldReader, BlockPos pos) {
        if (worldReader.getBlockState(pos.below()).is(Blocks.FARMLAND)) {return false;}
        else return super.canSurvive(state,worldReader,pos);
    }

    @ParametersAreNonnullByDefault
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        if (state.getValue(AGE)==7&&!state.getValue(INFESTED)) {
            drops.add(new ItemStack(BlockItemInit.LILYPAD_FLOWER_ITEM.get()));
        }
        return drops;
    }


    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {
        if (state.getValue(AGE)!=6) {
            return ActionResultType.PASS;
        }
        else {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (item == Items.GLASS_BOTTLE) {
                itemstack.shrink(1);
                ItemStack definiteDrops = new ItemStack(BlockItemInit.BOTTLED_SPIRIT_ITEM.get(), 1);
                player.inventory.add(definiteDrops);
                world.setBlock(pos, state.setValue(AGE,7), 1);

                player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP,1,1 );
                return ActionResultType.SUCCESS;
            }
            else  return ActionResultType.PASS;
        }
    }

}
