package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.common.entity.BaruGaruEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OriginBerryBlock extends RTSCropsBlock {

    //IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    //BooleanProperty INFESTED = RTSMain.INFESTED;


    // I'm lazy alright?
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public OriginBerryBlock (AbstractBlock.Properties properties) {
        super(properties);
        this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false);
    }

    //Not sure whether I need this but it hasn't crashed yet...
    /*public BlockState getStateForAge(int newAge) {
        return this.defaultBlockState().setValue(AGE,newAge).setValue(ROTATION, giveRotation()).setValue(INFESTED,false);
    }*/

    @ParametersAreNonnullByDefault
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        if (state.getValue(INFESTED)) return drops;

        drops.add(new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get()));

        if (state.getValue(AGE)==7) {
            drops.add(new ItemStack(BlockItemInit.ORIGIN_BERRY_ITEM.get()));

            if (rollChance.roll(4))
            drops.add(new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get()));
        }
        return drops;
    }

    // Necessary! Who knows what for... Maybe the defaultBlockState function?
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.AGE_7,BlockStateProperties.ROTATION_16, RTSMain.INFESTED);
    }

    // Called when block put down
    @ParametersAreNonnullByDefault
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false);
    }



    // When infested or less than 7 old, randomly ticks. Guess there's some unneeded code upstairs...
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(INFESTED)||state.getValue(AGE)<7;
    }

    // This seems to be triggered much more consistently..? like *20 or so more than randomTicks
    @ParametersAreNonnullByDefault
    public void growCrops(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        world.setBlock(pos, this.nextAgeWithRotation(state,i), 2);
    }

    //think tis has to be in this class bc of whether it uses rotation or not
    @ParametersAreNonnullByDefault
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) //that last bool is the grow chance
                {
                    worldIn.setBlock(pos, this.nextAgeWithRotation(state,i+1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
            else if (i == this.getMaxAge() && state.getValue(INFESTED)){
                this.rollPestSpawn(worldIn, pos);
            }
        }
    }

    private void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnJawBeetle(worldIn, pos); //normally 10
        else if (rollChance.roll(80)) for (int j = 0; j < 10; j++) {spawnJawBeetle(worldIn, pos);} //small chance of horde normally 80
        else if (rollChance.roll(500)) spawnBaruGaru(worldIn, pos); // normally 500
    }


    private static void spawnBaruGaru(ServerWorld world, BlockPos pos) {
        BaruGaruEntity entity = EntityTypesInit.BARUGARU.get().create(world);
        if (entity!=null) {
            entity.moveTo((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addFreshEntity(entity);
        }
        world.removeBlock(pos,false);
    }

    // qol interact so you don't have to replant although that might be fun in its own way
    @ParametersAreNonnullByDefault
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (state.getValue(AGE)!=7&&!state.getValue(INFESTED)) {
            return ActionResultType.PASS;
        }
        else {
            if (giveRotation() == 3) {
                ItemStack randomDrops = new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get(),1);
                popResource(world, pos, randomDrops);
            }

            ItemStack definiteDrops = new ItemStack(BlockItemInit.ORIGIN_BERRY_ITEM.get(),1);
            popResource(world, pos, definiteDrops);

            world.setBlock(pos, this.nextAgeWithRotation(state,0), 2);

            return ActionResultType.SUCCESS;
        }
    }
}
