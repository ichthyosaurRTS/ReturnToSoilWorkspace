package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public abstract class AbstractStalkBlock extends RTSCropsBlock{

    public AbstractStalkBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE)<7;
    }

    @Override
    public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos p_196260_3_) {
        BlockState above = p_196260_2_.getBlockState(p_196260_3_.above());
        Block aboveBlock = above.getBlock();

        //if fully grown, should have a crop on top!
        if (p_196260_1_.getValue(AGE) == 7) if (!(aboveBlock instanceof RTSCropsBlock)) return false;

        return super.canSurvive(p_196260_1_,p_196260_2_,p_196260_3_);
    }

    //to be overridden
    public BlockState getTopCropBlock(){
        return BlockItemInit.HEAVY_PLANT_BLOCK.get().getStateDefinition().any();
    }

    public boolean nonStalkNext(){return true;}

    @Override
    @ParametersAreNonnullByDefault
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) //that last bool is the grow chance
                {
                    if (i+1 < this.getMaxAge() ) worldIn.setBlock(pos, this.nextAgeWithRotation(state,i+1), 2);

                    else if (i+1 == this.getMaxAge() && worldIn.getBlockState(pos.above()).getBlock() instanceof AirBlock) {

                        worldIn.setBlock(pos, this.nextAgeWithRotation(state,i+1), 2);

                        if (this.nonStalkNext()){

                            BlockState topBlock = this.getTopCropBlock();

                            BlockState blockState = topBlock.setValue(ROTATION,state.getValue(ROTATION)).setValue(INFESTED,false);
                            worldIn.setBlock(pos.above(),blockState,2);
                        }
                        else worldIn.setBlock(pos.above(), this.nextAgeWithRotation(state,0), 2);
                    }

                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public void growCrops(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        if (i < this.getMaxAge() ) world.setBlock(pos, this.nextAgeWithRotation(state,i), 2);

        else if (i == this.getMaxAge() && world.getBlockState(pos.above()).getBlock() instanceof AirBlock) {

            world.setBlock(pos, this.nextAgeWithRotation(state,i), 2);

            if (this.nonStalkNext()){

                BlockState topBlock = this.getTopCropBlock();

                BlockState blockState = topBlock.setValue(ROTATION,state.getValue(ROTATION)).setValue(INFESTED,false);
                world.setBlock(pos.above(),blockState,2);
            }
            else world.setBlock(pos.above(), this.nextAgeWithRotation(state,0), 2);
        }
    }
}
