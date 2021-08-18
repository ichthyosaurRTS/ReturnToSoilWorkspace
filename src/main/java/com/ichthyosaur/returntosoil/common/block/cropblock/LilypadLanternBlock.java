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
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
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
        this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false).setValue(LIT,false);
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

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.AGE_7,BlockStateProperties.ROTATION_16, RTSMain.INFESTED, BlockStateProperties.LIT);
    }

    @ParametersAreNonnullByDefault
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false).setValue(LIT,false);
    }

    @ParametersAreNonnullByDefault
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) //that last bool is the grow chance
                {
                    worldIn.setBlock(pos, this.nextAgeWithRotationWithLit(state,i+1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
            if (i == this.getMaxAge() && state.getValue(INFESTED)){
                if (rollChance.roll(10)) spawnBallFrog(worldIn, pos); //normally 10
                else if (rollChance.roll(80)) for (int j = 0; j < 10; j++) {spawnBallFrog(worldIn, pos);} //small chance of horde
                //else if (rollChance(300)) spawnBaruGaru(worldIn, pos);
            }
        }
    }

    public boolean canSurvive(BlockState state, IWorldReader worldReader, BlockPos pos) {
        if (worldReader.getBlockState(pos.below()).is(Blocks.FARMLAND)) {return false;}
        else return super.canSurvive(state,worldReader,pos);
    }

    @ParametersAreNonnullByDefault
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        if (state.getValue(INFESTED)) return drops;

        if (state.getValue(AGE)==6) {}//for glowing fruit
        else if (state.getValue(AGE)==7)  {
            if (rollChance.roll(4)) drops.add(new ItemStack(BlockItemInit.LILYPAD_LANTERN_SEED.get())); }//+non glowing fruit
        else drops.add(new ItemStack(BlockItemInit.LILYPAD_LANTERN_SEED.get()));

        return drops;
    }

    @ParametersAreNonnullByDefault
    public void growCrops(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        if (world.getBlockState(pos.below()).is(Blocks.FARMLAND)) {world.removeBlock(pos,false);
            popResource(world, pos, new ItemStack(BlockItemInit.LILYPAD_LANTERN_SEED.get(),1));} //destroy the block if on farmland
        else world.setBlock(pos, this.nextAgeWithRotationWithLit(state,i), 2);

    }

    public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return false;
    }

    private static void spawnBallFrog(ServerWorld world, BlockPos pos) {
        BallFrogEntity entity = EntityTypesInit.BALLFROG.get().create(world);
        if (entity!=null) {
            entity.moveTo((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            entity.setColourIntData();
            world.addFreshEntity(entity);
        }
        world.removeBlock(pos,false);
    }


    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(INFESTED)||state.getValue(AGE)<7;
    }
}
