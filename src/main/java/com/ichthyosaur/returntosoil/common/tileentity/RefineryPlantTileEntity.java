package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.block.functional.RefineryPlantPottedBlock;
import com.ichthyosaur.returntosoil.common.container.RefineryPlantContainer;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

public class RefineryPlantTileEntity extends TileEntity implements ITickableTileEntity {

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;
    public int refineProgress = 0;

    public RefineryPlantTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container" + RTSMain.MOD_ID + ".refinery_plant");
    }

    public RefineryPlantTileEntity() {
        this(TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {

        //if lit, check the progress -> if at 200, pop resource and set a new block down; else add to the progress
        //should kill off the tile entity if the block is removed right...?
        if (this.level!=null) {
            World world = this.level;
            BlockPos pos =this.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getValue(BlockStateProperties.LIT)) {
                if (this.refineProgress >= 200 && state.getValue(FUEL_LEVEL)>0) {
                    Block.popResource(world, pos.above(), randomDropResult());
                    int newFuelLevel = state.getValue(FUEL_LEVEL) - 1;
                    world.setBlock(pos, RefineryPlantPottedBlock.newState(newFuelLevel),2);

                    //RefineryPlantTileEntity newEntity = TileEntityTypesInit.REFINERY_PLANT_TILE_ENTITY_TYPE.get().create();
                    //newEntity.setLevelAndPosition(world, pos);
                    //world.addBlockEntity(newEntity);


                    //world.setBlockEntity(pos, new RefineryPlantTileEntity());
                    //world.blockEntityChanged(pos, new RefineryPlantTileEntity());
                }
                else {
                    this.refineProgress += 1;
                    world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            pos.getX()+0.5, pos.getY()+0.8, pos.getZ()+0.5, 0.0D, 0.03D, 0.0D);
                }
            }


        }
    }


    private ItemStack randomDropResult() {
        return new ItemStack(BlockItemInit.LILYPAD_LANTERN_SEED.get(),1);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        nbt.putInt("progress",this.refineProgress);
        return nbt;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.refineProgress = nbt.getInt("progress");
    }

    /*@Override
    public int getContainerSize() {
        return slotNumber;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int p_70301_1_) {
        return this.items.get(p_70301_1_);
    }

    @Override
    public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
        ItemStack item = this.items.get(p_70298_1_);
        this.items.set(p_70298_1_,ItemStack.EMPTY);
        return item;
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_70304_1_) {
        return null;
    }


    //doesn't account for empty hand taking item
    @Override
    public void setItem(int p_70299_1_, ItemStack itemStack) {
        this.items.set(p_70299_1_,itemStack);

    }

    @Override
    public boolean stillValid(PlayerEntity p_70300_1_) {
        return false;
    }

    @Override
    public void clearContent() {

    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        ItemStackHelper.saveAllItems(nbt,this.items);

        return nbt;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(getContainerSize(),ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt,this.items);
    }*/
}
