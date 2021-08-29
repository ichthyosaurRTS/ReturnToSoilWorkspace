package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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
import java.util.Random;

public class RefineryPlantBlock extends RTSCropsBlock{

    // I'm lazy alright?

    public RefineryPlantBlock (AbstractBlock.Properties properties) {
        super(properties);
        this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.AGE_7,BlockStateProperties.ROTATION_16, RTSMain.INFESTED);
    }

    @ParametersAreNonnullByDefault
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(INFESTED)||state.getValue(AGE)<7;
    }


    //needs custom mob
    public static void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnJawBeetle(worldIn, pos); //normally 10
        else if (rollChance.roll(80)) for (int j = 0; j < 10; j++) {spawnJawBeetle(worldIn, pos);} //small chance of horde normally 80
    }

    //potting function needed
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {
        if (state.getValue(AGE)!=7||state.getValue(INFESTED)) {
            return ActionResultType.PASS;
        }
        else {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (item == Items.FLOWER_POT) {

                itemstack.shrink(1);

                ItemStack definiteDrops = new ItemStack(BlockItemInit.REFINERY_PLANT_POTTED_ITEM.get(), 1);
                popResource(world, pos, definiteDrops);

                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);

                return ActionResultType.SUCCESS;
            }
            else  return ActionResultType.PASS;
        }
    }

    public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return false;
    }

}
