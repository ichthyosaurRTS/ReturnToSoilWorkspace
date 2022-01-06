package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.common.tileentity.RefineryPlantTileEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
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
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class DroughtCactusBlock extends RTSCropsBlock implements IPottable{

    public DroughtCactusBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @ParametersAreNonnullByDefault
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        if (state.getValue(INFESTED)) return drops;

        if (state.getValue(AGE)==7) {
            drops.add(new ItemStack(BlockItemInit.DROUGHT_TUBER_ITEM.get()));
        }
        return drops;
    }

    @Override
    public ItemStack getPotItem() {
        return new ItemStack(BlockItemInit.DROUGHT_CACTUS_POTTED_ITEM.get());
    }
}
