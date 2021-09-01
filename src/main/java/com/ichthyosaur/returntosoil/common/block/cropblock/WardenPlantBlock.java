package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
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

public class WardenPlantBlock extends RTSCropsBlock implements IPottable{
    public WardenPlantBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @ParametersAreNonnullByDefault
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        if (state.getValue(AGE)==7&&!state.getValue(INFESTED)) {
            drops.add(new ItemStack(BlockItemInit.GLASSY_EYEBALL_ITEM.get()));
        }
        return drops;
    }

    @Override
    public ItemStack getPotItem() {
        return new ItemStack(BlockItemInit.WARDEN_PLANT_POTTED_ITEM.get());
    }
}
