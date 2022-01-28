package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.common.entity.BaruGaruEntity;
import com.ichthyosaur.returntosoil.core.init.BlockInit;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

//the beginning of many things, forgotten to the world.
public class OriginBerryBlock extends RTSCropsBlock implements IPottable{

    //IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    //BooleanProperty INFESTED = ReturnToSoil.INFESTED;


    public OriginBerryBlock (AbstractBlock.Properties properties) {
        super(properties);
        this.defaultBlockState().setValue(AGE,0).setValue(ROTATION, giveRotation()).setValue(INFESTED,false);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemInit.ORIGIN_BERRY_SEED.get();
    }
    @Override
    protected boolean rollReplant(){
        return true;
    }
    @Override
    protected boolean useSeedDrop(){
        return rollChance.roll(4);
    }
    @Override
    protected Item getNonSeedDrop(){
        return ItemInit.ORIGIN_BERRY_ITEM.get();
    }
    @Override
    protected Item getSeed(){
        return ItemInit.ORIGIN_BERRY_SEED.get();
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
        spawnMobEntity(world, pos, entity);
    }

    @Override
    public ItemStack getPotItem() {
        return new ItemStack (ItemInit.ORIGIN_BERRY_POTTED_ITEM.get());
    }
}
