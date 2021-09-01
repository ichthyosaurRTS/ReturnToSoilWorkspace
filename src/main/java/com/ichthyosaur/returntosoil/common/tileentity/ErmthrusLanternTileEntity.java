package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.block.cropblock.RTSCropsBlock;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

//powered, can infest plants early or blow up infested
public class ErmthrusLanternTileEntity extends TileEntity implements ITickableTileEntity,IHoldsSpirit{

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;
    private float spiritLevel; //held info

    public ErmthrusLanternTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public ErmthrusLanternTileEntity() {
        this(TileEntityTypesInit.ERMTHRUS_LANTERN_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        World world = this.level;
        BlockPos pos = this.getBlockPos();
        BlockState state = this.getBlockState();

        if (!(this.level.isClientSide)) {

            if (this.spiritLevel < 1) {
                world.setBlock(pos, state.setValue(FUEL_LEVEL, 0), 2);
            } else if (this.spiritLevel > 0) {
                world.setBlock(pos, state.setValue(FUEL_LEVEL, 1), 2);
                this.spiritLevel -= 1;
                if (this.spiritLevel%100==0) doErmthrusFunction((ServerWorld)world, pos);
            }
        }

    }

    public void spiritLevelAdd(float number) {this.spiritLevel+=number;}
    public float getSpiritLevel(){return this.spiritLevel;}

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putFloat("spirit_level",this.spiritLevel);
        return super.save(nbt);
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT nbt) {
        super.load(p_230337_1_, nbt);
        if (nbt.contains("spirit_level")) this.spiritLevel = nbt.getFloat("spirit_level");
    }

    private void doErmthrusFunction(ServerWorld world, BlockPos pos){
        BlockPos targetPos;
        BlockState targetState;
        Random random = new Random();

        for (int x = -4; x < 5; x++) {
            for (int z = -4; z < 5; z++) {
                if (!(x==0&&z==0)) {
                    targetPos = new BlockPos(pos.getX()+x,pos.getY(),pos.getZ()+z);
                    if (world.getBlockState(targetPos).getBlock() instanceof CropsBlock) {

                        targetState = world.getBlockState(targetPos);
                        if (targetState.getValue(BlockStateProperties.AGE_7)!=7 && rollChance.roll(30)) //normally 15

                            targetState.randomTick(world, targetPos, random);

                    }
                }
            }
        }
    }
}


