package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.container.RefinementBaAdvContainer;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class RefinementBaAdvTileEntity extends LockableTileEntity implements ITickableTileEntity {

    public static int slotNumber = 3;
    protected NonNullList<ItemStack> items = NonNullList.withSize(slotNumber,ItemStack.EMPTY);

    public RefinementBaAdvTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container" + RTSMain.MOD_ID + ".refinement_ba_adv");
    }

    @Override
    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return new RefinementBaAdvContainer(p_213906_1_,p_213906_2_,this);
    }

    public RefinementBaAdvTileEntity() {

        this(TileEntityTypesInit.REFINEMENT_BA_ADV_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {

    }

    @Override
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
    }
}
