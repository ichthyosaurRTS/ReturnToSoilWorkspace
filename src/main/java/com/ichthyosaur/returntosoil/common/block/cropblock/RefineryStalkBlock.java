package com.ichthyosaur.returntosoil.common.block.cropblock;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class RefineryStalkBlock extends AbstractStalkBlock {

    public RefineryStalkBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    public BlockState getTopCropBlock(){
        return BlockItemInit.REFINERY_PLANT_BLOCK.get().getStateDefinition().any();
    }

    @Override
    public boolean nonStalkNext(){return true;}

}
