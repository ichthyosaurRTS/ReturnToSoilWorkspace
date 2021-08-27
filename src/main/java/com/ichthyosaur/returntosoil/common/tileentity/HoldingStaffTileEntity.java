package com.ichthyosaur.returntosoil.common.tileentity;

import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

public class HoldingStaffTileEntity  extends LockableLootTileEntity {

    protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    protected HoldingStaffTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public HoldingStaffTileEntity() {
        this(TileEntityTypesInit.HOLDING_STAFF_TILE_ENTITY_TYPE.get());
    }

    @Override
    protected ITextComponent getDefaultName() {
        return null;
    }

    @Override
    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return null;
    }


    public int getSizeInventory() {
        return 1;
    }
    public boolean hasItem() {
        if (this.getItems().get(0).equals(ItemStack.EMPTY)) return false;
        else return true;
    }
    public Item holdingItem() {return this.getItems().get(0).getItem();}

    public void giveItem(Item item) {this.setItems(NonNullList.withSize(1, new ItemStack(item)));}

    public void dropItem() {

        if (this.getLevel() == null) {}
        else if (!this.getLevel().isClientSide()) {
            Block.popResource(this.getLevel(), this.getBlockPos(), this.getItems().get(0));
            this.setItems(NonNullList.withSize(1,ItemStack.EMPTY));}
    }





    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }
    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }


    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        if(!this.trySaveLootTable(compound)) {
            ItemStackHelper.saveAllItems(compound, this.items);
        }

        return compound;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.items);
        }
    }

    @Override
    public int getContainerSize() {
        return 1;
    }
}
