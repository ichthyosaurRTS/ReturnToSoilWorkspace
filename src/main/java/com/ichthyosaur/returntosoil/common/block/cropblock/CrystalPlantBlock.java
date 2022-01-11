package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class CrystalPlantBlock extends RTSCropsBlock{
    public CrystalPlantBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    public void rollPestSpawn(ServerWorld worldIn, BlockPos pos) {
        if (rollChance.roll(10)) spawnMobEntity(worldIn, pos, EntityTypesInit.WARRARUPEHEAD.get().create(worldIn));
        else if (rollChance.roll(200)) for (int j = 0; j < 10; j++) spawnMobEntity(worldIn, pos, EntityTypesInit.WARRARUPEHEAD.get().create(worldIn));
    }

}
