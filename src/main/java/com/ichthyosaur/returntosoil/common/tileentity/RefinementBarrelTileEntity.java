package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;


public class RefinementBarrelTileEntity extends TileEntity implements ITickableTileEntity {

    public static final IntegerProperty FUEL_LEVEL = ReturnToSoil.FUEL_LEVEL;
    public int refineProgress = 0;

    private int blueSmokeAmount = 0;
    //normally 0
    private int spiritRemaining = 1000;

    public RefinementBarrelTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public RefinementBarrelTileEntity() {
        this(TileEntityTypesInit.REFINEMENT_BARREL_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {


        if (this.level!=null) {
            World world = this.level;
            BlockPos pos =this.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getValue(FUEL_LEVEL)>0 && state.getValue(FUEL_LEVEL)<5) {
                if (this.refineProgress >= 5000) {
                    Block.popResource(world, pos.above(), randomSeedResult());

                    this.refineProgress = 0;
                    int newFuelLevel = state.getValue(FUEL_LEVEL) - 1;
                    BlockState news = state.setValue(FUEL_LEVEL,newFuelLevel);
                    world.setBlock(pos, news,2);

                }
                else {
                    this.refineProgress += 1;
                }

                if (rollChance.roll(15)) world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        pos.getX()+0.5, pos.getY()+0.8, pos.getZ()+0.5, 0.0D, 0.03D, 0.0D);
            }
            //if fuel level 5-> if we finish refinement, check whether too much smoke was produced, reward if good enough
            else if (state.getValue(FUEL_LEVEL)==5){

                if (this.refineProgress >= 1000) {

                    if (this.blueSmokeAmount < 250) {
                        for(int i=1;i<5;i++) Block.popResource(world, pos.above(), randomSeedResult());
                    }
                    else Block.popResource(world, pos.above(), new ItemStack(Blocks.DIRT));

                    this.resetProgress();

                    BlockState news = state.setValue(FUEL_LEVEL,0);
                    world.setBlock(pos, news,2);
                }
                //if bubbling, roll chance to see whether it stops/ if not, add to the smoke counter
                else {
                    this.refineProgress += 1;
                }

                double bubbleOffsetX = (rollChance.returnRoll(10) - 5) / 30;
                double bubbleOffsetZ = (rollChance.returnRoll(10) - 5) / 30;
                world.addParticle(ParticleTypes.EFFECT,
                        pos.getX() + 0.5 + bubbleOffsetX, pos.getY() + 0.8, pos.getZ() + 0.5 + bubbleOffsetZ, 0.0D, 0.03D, 0.0D);


            }
            else if (state.getValue(FUEL_LEVEL)==6){
                if (this.refineProgress >= 50000) {
                    this.resetProgress();

                    BlockState news = state.setValue(FUEL_LEVEL,7);
                    world.setBlock(pos, news,2);
                }
                else {
                    this.refineProgress += 1;
                }

                double bubbleOffsetX = (rollChance.returnRoll(10) - 5) / 30;
                double bubbleOffsetZ = (rollChance.returnRoll(10) - 5) / 30;
                if (rollChance.roll(15))
                    world.addParticle(ParticleTypes.SMOKE,
                            pos.getX() + 0.5 + bubbleOffsetX, pos.getY() + 0.8, pos.getZ() + 0.5 + bubbleOffsetZ, 0.0D, 0.03D, 0.0D);

            }
        }
    }


    public static ItemStack randomSeedResult() {

        int i = (int) rollChance.returnRoll(100);
        if (i == 1) return new ItemStack(ItemInit.VESSEL_SEED.get());  //1%

        else if (i < 22) return new ItemStack(ItemInit.LILYPAD_LANTERN_SEED.get()); //15%

        else return new ItemStack(ItemInit.ORIGIN_BERRY_SEED.get(),1);// 39%

    }

    private Item randomItem(int count){
        Item item = Item.byId((int)rollChance.returnRoll(3000));
        if (count > 50) return Items.WHEAT_SEEDS;
        else if (item != null) return item;
        else return randomItem(count + 1);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        nbt.putInt("progress",this.refineProgress);
        nbt.putInt("smoking",this.blueSmokeAmount);
        nbt.putInt("spirit",this.spiritRemaining);
        return nbt;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.refineProgress = nbt.getInt("progress");
        this.blueSmokeAmount = nbt.getInt("smoking");
        this.spiritRemaining = nbt.getInt("spirit");

    }

    public boolean addSpirit(){
        if (this.spiritRemaining<1) {
            this.spiritRemaining = 1000;
            return true;
        }
        else return false;
    }

    public void ruinPot () {
        this.blueSmokeAmount = 1001;
    }

    public void resetProgress(){
        this.refineProgress = 0;
        this.spiritRemaining = 0;
        this.blueSmokeAmount = 0;
    }

}
