package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.HuskLarvaeEntity;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.logging.Logger;

public abstract class RTSCropsBlock extends CropsBlock {

    IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    BooleanProperty INFESTED = RTSMain.INFESTED;
    BooleanProperty LIT = BlockStateProperties.LIT;

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D);

    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public RTSCropsBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
        this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false);
    }

    // Provides a random rotation int of 0, 1, 2 or 3
    public static Integer giveRotation() {
        Random rand = new Random();
        //ie from 0-3
        int i = rand.nextInt(4);

        Logger.getLogger("setting rotation to "+i);
        return i;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {

        if (this instanceof IPottable) {
            if (state.getValue(AGE)==7&&!state.getValue(INFESTED))  {
                ItemStack itemstack = player.getItemInHand(hand);
                Item item = itemstack.getItem();
                if (item == Items.FLOWER_POT) {
                    itemstack.shrink(1);
                    popResource(world, pos, ((IPottable) this).getPotItem());
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.use(state, world, pos, player, hand, p_225533_6_);
    }

    public BlockState nextAgeWithoutRotation(BlockState state, Integer newAge) {
        boolean infested = state.getValue(INFESTED);
        if (newAge==7&&rollChance.roll(40)) infested = true;
        BlockState block = state.setValue(AGE, newAge).setValue(INFESTED,infested); //
        return block;
    }

    // Returns a new state with the same rotation and infestation but different age
    // This is where the infestation occurs, transitioning from 6-7
    public BlockState nextAgeWithRotation(BlockState state, Integer newAge) {
        boolean infested = state.getValue(INFESTED);
        if (newAge==7&&rollChance.roll(40)) infested = true; //normally 40
        BlockState block = state.setValue(AGE, newAge).setValue(INFESTED,infested); //
        return block;
    }

    public BlockState nextAgeWithRotationWithLit(BlockState state, Integer newAge) {
        boolean infested = state.getValue(INFESTED);
        boolean lit;
        if (newAge==7&&rollChance.roll(40)) { infested = true; lit = false; }
        else lit = newAge == 6;
        BlockState block = state.setValue(AGE, newAge).setValue(INFESTED,infested).setValue(LIT,lit); //
        return block;
    }


    // From silverfish BlockModel
    public static void spawnLarvae(ServerWorld p_235505_1_, BlockPos p_235505_2_) {
        HuskLarvaeEntity huskLarvaeEntity = EntityTypesInit.HUSKLARVAE.get().create(p_235505_1_);
        huskLarvaeEntity.moveTo((double)p_235505_2_.getX() + 0.5D, (double)p_235505_2_.getY(), (double)p_235505_2_.getZ() + 0.5D, 0.0F, 0.0F);
        p_235505_1_.addFreshEntity(huskLarvaeEntity);
    }

    @ParametersAreNonnullByDefault
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false);
    }

    // Necessary! Who knows what for... Maybe the defaultBlockState function?
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.AGE_7,BlockStateProperties.ROTATION_16, RTSMain.INFESTED);
    }

    // When infested or less than 7 old, randomly ticks. Guess there's some unneeded code upstairs...
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(INFESTED)||state.getValue(AGE)<7;
    }

    public static void spawnJawBeetle(ServerWorld world, BlockPos pos) {
        JawBeetleEntity entity = EntityTypesInit.JAWBEETLE.get().create(world);
        if (entity!=null) {
            entity.moveTo((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            entity.setColourIntData();
            world.addFreshEntity(entity);
        }
        world.removeBlock(pos,false);
    }

    public static void spawnMobEntity(ServerWorld world, BlockPos pos, MobEntity entity) {
        if (entity!=null) {
            entity.moveTo((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addFreshEntity(entity);
            entity.finalizeSpawn(world, world.getCurrentDifficultyAt(pos), SpawnReason.NATURAL,null,null);
        }
        world.removeBlock(pos,false);
    }

    // despite being deprecated, still works fine..?
    @ParametersAreNonnullByDefault
    public void spawnAfterBreak(BlockState p_220062_1_, ServerWorld p_220062_2_, BlockPos p_220062_3_, ItemStack p_220062_4_) {
        super.spawnAfterBreak(p_220062_1_, p_220062_2_, p_220062_3_, p_220062_4_);
        if (p_220062_1_.getValue(INFESTED)) {
            spawnLarvae(p_220062_2_, p_220062_3_);
        }
    }

    @ParametersAreNonnullByDefault
    public void growCrops(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        world.setBlock(pos, this.nextAgeWithRotation(state,i), 2);
    }

    public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return false;
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
            else if (i == this.getMaxAge() && state.getValue(INFESTED)) this.rollPestSpawn(worldIn, pos);
        }
    }

    public void rollPestSpawn (ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnJawBeetle(worldIn, pos); //normally 10
        else if (rollChance.roll(80)) for (int j = 0; j < 10; j++) {
            spawnJawBeetle(worldIn, pos);
        } //small chance of horde normally 80
    }
}
