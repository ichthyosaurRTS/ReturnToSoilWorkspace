package com.ichthyosaur.returntosoil.common.Item.Tool;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Set;

//recharge this item by eating a fruit of some kind- searches inv then charges. for now just can always use
//teleports behind target
public class AbyssScalpelItem extends ToolItem {

    private Entity itemTarget;
    private boolean canUse = true;
    private int charges = 0;

    public AbyssScalpelItem(float p_i48512_1_, float p_i48512_2_, IItemTier p_i48512_3_, Set<Block> p_i48512_4_, Properties p_i48512_5_) {
        super(p_i48512_1_, p_i48512_2_, p_i48512_3_, p_i48512_4_, p_i48512_5_);
    }

    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity entity, LivingEntity player) {
        p_77644_1_.hurtAndBreak(2, entity, (p_220039_0_) -> {
            p_220039_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
        });
        if (entity != null) {this.itemTarget = entity;}
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
    @MethodsReturnNonnullByDefault
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (this.itemTarget != null && this.itemTarget.isAlive()) {

            if (canUse) {

                Entity target = this.itemTarget;
                double behindTargetX = target.getX() - target.getLookAngle().x*2;
                double behindTargetZ = target.getZ() - target.getLookAngle().z*2;
                player.moveTo(behindTargetX,target.getY(),behindTargetZ);

                world.playLocalSound(player.getX(), player.getY(), player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 0.3F, 0.3F, false);
                world.addParticle(ParticleTypes.WARPED_SPORE, player.getX(), player.getY(), player.getZ(), 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.WARPED_SPORE, player.getX(), player.getY()+0.1, player.getZ(), 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.WARPED_SPORE, player.getX(), player.getY()-0.1, player.getZ(), 0.0D, 0.0D, 0.0D);

                return ActionResult.pass(player.getItemInHand(hand));
            }
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }

}
