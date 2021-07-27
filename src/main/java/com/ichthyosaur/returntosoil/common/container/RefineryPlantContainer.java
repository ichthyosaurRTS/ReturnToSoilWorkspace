package com.ichthyosaur.returntosoil.common.container;


import com.ichthyosaur.returntosoil.common.tileentity.RefineryPlantTileEntity;
import com.ichthyosaur.returntosoil.core.init.ContainerTypesInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

//many things and many thing different in here...
public class RefineryPlantContainer extends Container {

    public final RefineryPlantTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;
    private BlockPos pos;

    public RefineryPlantContainer(final int windowId, final PlayerInventory playerInv, final RefineryPlantTileEntity te){
        super(ContainerTypesInit.REFINERY_PLANT_CONTAINER_TYPE.get(), windowId);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.create(Objects.requireNonNull(te.getLevel()),te.getBlockPos());
        this.pos = te.getBlockPos();

        //Tile entity
        this.addSlot(new Slot((IInventory) te, 0, 80, 50));
        this.addSlot(new Slot((IInventory) te, 1, 110, 10));
        this.addSlot(new Slot((IInventory) te, 2, 50, 10));

        //Player inv
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
            }
        }
        //Player hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142 ));
        }
    }

    public RefineryPlantContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data){
        this(windowId,playerInv,getTileEntity(playerInv,data));
    }

    private static RefineryPlantTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data){
        Objects.requireNonNull(playerInv, "Player inv cannot be null");
        Objects.requireNonNull(data, "Packet buffer cannot be null");
        final TileEntity te = playerInv.player.level.getBlockEntity(data.readBlockPos());
        if (te instanceof RefineryPlantTileEntity) return (RefineryPlantTileEntity) te;
        throw new IllegalStateException("Tile entity is not correct");
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return this.pos.distSqr(player.getX(),player.getY(),player.getZ(),false)<12;
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if (index < RefineryPlantTileEntity.slotNumber && !this.moveItemStackTo(stack1,RefineryPlantTileEntity.slotNumber,this.slots.size(),true)) {
                return ItemStack.EMPTY;
            }
            if (!this.moveItemStackTo(stack1,0,RefineryPlantTileEntity.slotNumber,false)) {
                return ItemStack.EMPTY;
            }
            if (stack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }
            else slot.setChanged();
        }
        return stack;
    }
}
