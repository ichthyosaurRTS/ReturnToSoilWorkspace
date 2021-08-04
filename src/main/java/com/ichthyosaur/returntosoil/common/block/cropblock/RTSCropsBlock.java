package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.HuskLarvaeEntity;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.logging.Logger;

public abstract class RTSCropsBlock extends CropsBlock {

    IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    BooleanProperty INFESTED = RTSMain.INFESTED;
    BooleanProperty LIT = BlockStateProperties.LIT;

    public RTSCropsBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    // Provides a random rotation int of 0, 1, 2 or 3
    public static Integer giveRotation() {
        Random rand = new Random();
        //ie from 0-3
        int i = rand.nextInt(4);

        Logger.getLogger("setting rotation to "+i);
        return i;
    }

    public BlockState nextAgeWithoutRotation(BlockState state, Integer newAge) {
        boolean infested = state.getValue(INFESTED);
        if (newAge==7&&rollChance.roll(40)) infested = true;
        BlockState block = this.defaultBlockState().setValue(AGE, newAge).setValue(INFESTED,infested); //
        return block;
    }

    // Returns a new state with the same rotation and infestation but different age
    // This is where the infestation occurs, transitioning from 6-7
    public BlockState nextAgeWithRotation(BlockState state, Integer newAge) {
        Integer i = state.getValue(ROTATION);
        boolean infested = state.getValue(INFESTED);
        if (newAge==7&&rollChance.roll(40)) infested = true; //normally 40
        BlockState block = this.defaultBlockState().setValue(AGE, newAge).setValue(ROTATION, i).setValue(INFESTED,infested); //
        return block;
    }

    public BlockState nextAgeWithRotationWithLit(BlockState state, Integer newAge) {
        Integer i = state.getValue(ROTATION);
        boolean infested = state.getValue(INFESTED);
        boolean lit = false;
        if (newAge==7&&rollChance.roll(40)) { infested = true; lit = false; }
        else lit = newAge == 6;
        BlockState block = this.defaultBlockState().setValue(AGE, newAge).setValue(ROTATION, i).setValue(INFESTED,infested).setValue(LIT,lit); //
        return block;
    }


    // From silverfish block
    public static void spawnLarvae(ServerWorld p_235505_1_, BlockPos p_235505_2_) {
        HuskLarvaeEntity huskLarvaeEntity = EntityTypesInit.HUSKLARVAE.get().create(p_235505_1_);
        huskLarvaeEntity.moveTo((double)p_235505_2_.getX() + 0.5D, (double)p_235505_2_.getY(), (double)p_235505_2_.getZ() + 0.5D, 0.0F, 0.0F);
        p_235505_1_.addFreshEntity(huskLarvaeEntity);
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

    // despite being deprecated, still works fine..?
    @ParametersAreNonnullByDefault
    public void spawnAfterBreak(BlockState p_220062_1_, ServerWorld p_220062_2_, BlockPos p_220062_3_, ItemStack p_220062_4_) {
        super.spawnAfterBreak(p_220062_1_, p_220062_2_, p_220062_3_, p_220062_4_);
        if (p_220062_1_.getValue(INFESTED)) {
            spawnLarvae(p_220062_2_, p_220062_3_);
        }
    }

}
