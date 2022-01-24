package com.ichthyosaur.returntosoil.common.item.tool;

import com.ichthyosaur.returntosoil.core.init.BlockInit;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;


//Hitting a target charges the axe (2). Right click with fuel in inv to launch towards target.
public class RoseBeetleAxeItem extends AxeItem {

    private Entity itemTarget;
    private boolean canUse = false;
    private int charges = 0;

    public RoseBeetleAxeItem(IItemTier p_i48530_1_, float p_i48530_2_, float p_i48530_3_, Properties p_i48530_4_) {
        super(p_i48530_1_, p_i48530_2_, p_i48530_3_, p_i48530_4_);
    }

    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity entity, LivingEntity player) {
        p_77644_1_.hurtAndBreak(2, entity, (p_220039_0_) -> {
            p_220039_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
        });
        if (entity != null) {this.itemTarget = entity; this.fillCharges();}
        return true;
    }

    private void removeCharge () {
        this.charges -= 1;
        if (this.charges == 0) this.canUse = false;;
    }
    private void fillCharges () {
        this.charges = 3;
        this.canUse = true;
    }

    //needs fuel items added
    @MethodsReturnNonnullByDefault
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (this.itemTarget != null && this.itemTarget.isAlive()) {

            double fuelSlot = rollChance.containsItem(ItemInit.ORIGIN_BERRY_ITEM.get(),player);

            if (fuelSlot != 1000 && canUse) {
                double movementMod = 0.6;

                Entity target = this.itemTarget;
                double xDist = (target.getX() - player.getX());
                double yDist = (target.getY() - player.getY());
                double zDist = (target.getZ() - player.getZ());
                double fullDist = Math.sqrt(xDist*xDist+zDist*zDist+yDist*yDist);
                if (yDist < 0.5) yDist = 0.1;
                double noGravity = 0.3;
                player.setDeltaMovement(player.getDeltaMovement().add(xDist/fullDist*movementMod, yDist/fullDist*movementMod+noGravity, zDist/fullDist*movementMod));

                player.inventory.removeItem((int)fuelSlot, 1);
                this.removeCharge();

                world.playLocalSound(player.getX(), player.getY(), player.getZ(), SoundEvents.WITHER_SHOOT, SoundCategory.PLAYERS, 0.3F, 0.3F, false);
                world.addParticle(ParticleTypes.FLAME, player.getX(), player.getY(), player.getZ(), 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.FLAME, player.getX(), player.getY()+0.01, player.getZ(), 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.FLAME, player.getX(), player.getY()-0.01, player.getZ(), 0.0D, 0.0D, 0.0D);

                return ActionResult.pass(player.getItemInHand(hand));
            }
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }



}
