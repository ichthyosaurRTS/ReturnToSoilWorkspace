package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.block.cropblock.RTSCropsBlock;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;

//powered, can infest plants early or blow up infested
public class WardenPlantTileEntity extends TileEntity implements ITickableTileEntity{

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;
    private float spiritLevel; //held info
    private int mode = 1; //evil or not
    private float speedDenominator;
    private float coolDown;

    public WardenPlantTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public WardenPlantTileEntity() {
        this(TileEntityTypesInit.WARDEN_PLANT_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        World world = this.level;
        BlockPos pos = this.getBlockPos();
        BlockState state = this.getBlockState();



        if (this.spiritLevel < 1 && !(this.level.isClientSide)) {world.setBlock(pos, state.setValue(FUEL_LEVEL, 0), 2);
        RTSMain.LOGGER.info("spirit lower than 1!");}

        else if (this.spiritLevel > 0){

            RTSMain.LOGGER.info(""+this.spiritLevel);
            RTSMain.LOGGER.info(""+this.mode);

            if (this.speedDenominator > 10) {
                this.spiritLevel -= 1;
                this.speedDenominator = 0;
            }
            else this.speedDenominator+=1;

            if (this.coolDown > 1000) {
                this.coolDown = 0;
                this.doWardenFunction();
            }
            else this.coolDown+=1;


        }

        if (this.spiritLevel > 0 && !(this.level.isClientSide)) world.setBlock(pos, state.setValue(FUEL_LEVEL, this.mode), 2);

    }

    public void spiritLevelAdd(float number) {this.spiritLevel+=number;}
    public float getSpiritLevel(){return this.spiritLevel;}
    public void switchMode(){ this.mode = 3-this.mode; }

    private void doWardenFunction(){
        World world = this.level;
        BlockPos pos = this.getBlockPos();
        BlockState state = this.getBlockState();
        BlockPos targetPos;
        BlockState targetState;

        for (int x = -2; x < 3; x++) {
            for (int z = -2; z < 3; z++) {
                if (x==0&&z==0) {}
                else {
                    targetPos = new BlockPos(pos.getX()+x,pos.getY(),pos.getZ()+z);
                    if (world.getBlockState(targetPos).getBlock() instanceof RTSCropsBlock ) {

                        //Breeding infested
                        targetState = world.getBlockState(targetPos);
                        if (this.mode == 2) {
                            if (targetState.getValue(BlockStateProperties.AGE_7)==6|| targetState.getValue(BlockStateProperties.AGE_7)==5
                            && rollChance.roll(50)) {
                                world.setBlock(targetPos,targetState.setValue(RTSMain.INFESTED, true),2);}
                        }
                        //Destroying infested
                        else {
                            if (targetState.getValue(RTSMain.INFESTED)) {
                                world.destroyBlock(targetPos, false);

                                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                                        targetPos.getX()+0.4, targetPos.getY()+0.6, targetPos.getZ()+0.6, 0.0D, 0.0D, 0.0D);
                                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                                        targetPos.getX()+0.6, targetPos.getY()+0.4, targetPos.getZ()+0.4, 0.0D, 0.0D, 0.0D);
                                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                                        targetPos.getX()+0.4, targetPos.getY()+0.6, targetPos.getZ()+0.4, 0.0D, 0.0D, 0.0D);

                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putFloat("spirit_level",this.spiritLevel);
        nbt.putInt("mode",this.mode);
        return super.save(nbt);
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT nbt) {
        super.load(p_230337_1_, nbt);
        if (nbt.contains("spirit_level")) this.spiritLevel = nbt.getFloat("spirit_level");
        if (nbt.contains("mode")) this.mode = nbt.getInt("mode");
    }

}


