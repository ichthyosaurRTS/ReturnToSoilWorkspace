package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.common.entity.BaruGaruEntity;
import com.ichthyosaur.returntosoil.common.tileentity.RefinementBarrelTileEntity;
import com.ichthyosaur.returntosoil.core.config.RTSConfigMisc;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class OriginBerryBlock extends RTSCropsBlock {

    //IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    //BooleanProperty INFESTED = RTSMain.INFESTED;


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

            //small gacha chance
            else if (rollChance.roll(100))
                drops.add(RefinementBarrelTileEntity.randomSeedResult());
        }
        return drops;
    }

    public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return true;
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnJawBeetle(worldIn, pos); //normally 10
        else if (rollChance.roll(80)) for (int j = 0; j < 10; j++) {spawnJawBeetle(worldIn, pos);} //small chance of horde normally 80
        else if (rollChance.roll(500)) spawnBaruGaru(worldIn, pos); // normally 500
    }


    private static void spawnBaruGaru(ServerWorld world, BlockPos pos) {
        BaruGaruEntity entity = EntityTypesInit.BARUGARU.get().create(world);
        if (entity!=null) {
            entity.moveTo((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            entity.finalizeSpawn(world, world.getCurrentDifficultyAt(pos), SpawnReason.NATURAL,null,null);
            world.addFreshEntity(entity);
        }
        world.removeBlock(pos,false);
    }

    // qol interact so you don't have to replant although that might be fun in its own way
    @ParametersAreNonnullByDefault
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (state.getValue(AGE)!=7||state.getValue(INFESTED)) {
            return ActionResultType.PASS;
        }
        else {

            RTSConfigMisc.cListIncrease((p_225533_4_.getName().getString()), 1);

            if (rollChance.roll(4)) {
                ItemStack randomDrops = new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get(),1);
                popResource(world, pos, randomDrops);
            }
            else if (rollChance.roll(100))
                popResource(world, pos, RefinementBarrelTileEntity.randomSeedResult());

            ItemStack definiteDrops = new ItemStack(BlockItemInit.ORIGIN_BERRY_ITEM.get(),1);
            popResource(world, pos, definiteDrops);

            p_225533_4_.playSound(SoundEvents.CROP_PLANTED,1 ,1);
            world.setBlock(pos, this.nextAgeWithRotation(state,0), 2);

            return ActionResultType.SUCCESS;
        }
    }
}
