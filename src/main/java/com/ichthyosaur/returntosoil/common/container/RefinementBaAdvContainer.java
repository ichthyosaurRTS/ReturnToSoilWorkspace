package com.ichthyosaur.returntosoil.common.container;

import com.ichthyosaur.returntosoil.common.tileentity.RefinementBaAdvTileEntity;
import com.ichthyosaur.returntosoil.core.init.ContainerTypesInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

public class RefinementBaAdvContainer extends Container {

    public final RefinementBaAdvTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;
    private BlockPos pos;

    public RefinementBaAdvContainer(final int windowId, final PlayerInventory playerInv, final RefinementBaAdvTileEntity te){
        super(ContainerTypesInit.REFINEMENT_BA_ADV_CONTAINER_TYPE.get(), windowId);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.create(Objects.requireNonNull(te.getLevel()),te.getBlockPos());
        this.pos = te.getBlockPos();

        //Tile entity
        this.addSlot(new Slot((IInventory) te, 1, 80, 50));
        this.addSlot(new Slot((IInventory) te, 0, 80, 10));

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

    public RefinementBaAdvContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data){
        this(windowId,playerInv,getTileEntity(playerInv,data));
    }

    private static RefinementBaAdvTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data){
        Objects.requireNonNull(playerInv, "Player inv cannot be null");
        Objects.requireNonNull(data, "Packet buffer cannot be null");
        final TileEntity te = playerInv.player.level.getBlockEntity(data.readBlockPos());
        if (te instanceof RefinementBaAdvTileEntity) return (RefinementBaAdvTileEntity) te;
        throw new IllegalStateException("Tile entity is not correct");
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return this.pos.distSqr(player.getX(),player.getY(),player.getZ(),false)<50;
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if (index < RefinementBaAdvTileEntity.slotNumber && !this.moveItemStackTo(stack1,RefinementBaAdvTileEntity.slotNumber,this.slots.size(),true)) {
                return ItemStack.EMPTY;
            }
            if (!this.moveItemStackTo(stack1,1,RefinementBaAdvTileEntity.slotNumber,false)) {
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
