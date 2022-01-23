package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.common.tileentity.RefinementBarrelTileEntity;
import com.ichthyosaur.returntosoil.core.config.RTSConfigMisc;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class CrystalPlantBlock extends RTSCropsBlock{
    public CrystalPlantBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @ParametersAreNonnullByDefault
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        if (state.getValue(AGE)==7&&!state.getValue(INFESTED)) {
            drops.add(new ItemStack(BlockItemInit.SPIRIT_CRYSTAL_ITEM.get()));
        }
        return drops;
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnMobEntity(worldIn, pos, EntityTypesInit.DRAGONFLY.get().create(worldIn));
        else if (rollChance.roll(200)) for (int j = 0; j < 10; j++) spawnMobEntity(worldIn, pos, EntityTypesInit.DRAGONFLY.get().create(worldIn));
    }

    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (state.getValue(AGE)!=7||state.getValue(INFESTED)) {
            return ActionResultType.PASS;
        }
        else {

            if (!world.isClientSide()) {
            if (rollChance.roll(100)) RTSConfigMisc.cListIncrease((p_225533_4_.getName().getString()), 100);

            if (rollChance.roll(100))
                popResource(world, pos, RefinementBarrelTileEntity.randomSeedResult());

            boolean safe = rollChance.roll(4);

            ItemStack definiteDrops = new ItemStack(BlockItemInit.SPIRIT_CRYSTAL_ITEM.get(),1);
            popResource(world, pos, definiteDrops);

            if (safe) world.setBlock(pos, this.nextAgeWithRotation(state,0), 2);
            else world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
            }

            else p_225533_4_.playSound(SoundEvents.CROP_PLANTED,1 ,1);

            return ActionResultType.SUCCESS;
        }
    }

}
