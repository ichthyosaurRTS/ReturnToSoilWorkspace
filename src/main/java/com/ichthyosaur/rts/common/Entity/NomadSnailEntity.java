package com.ichthyosaur.rts.common.Entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.UUID;

public class NomadSnailEntity extends TameableEntity implements IAngerable {


    public NomadSnailEntity(EntityType<? extends TameableEntity> p_i48569_1_, World p_i48569_2_) {
        super(p_i48569_1_, p_i48569_2_);
        this.setTame(false);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.1F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0f));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
    }

    public boolean canBreatheUnderwater() {
        return true;
    }


    public void setTame(boolean p_70903_1_) {
        super.setTame(p_70903_1_);
    }


    public ActionResultType mobInteract(PlayerEntity stack, Hand hand) {
            ItemStack itemstack = stack.getItemInHand(hand);
            Item item = itemstack.getItem();
        if (!this.isTame()&&item == Items.SEAGRASS) {
            this.tame(stack);
            this.level.broadcastEntityEvent(this, (byte)7);
            itemstack.shrink(1);
            return ActionResultType.CONSUME;
        }
        else if (this.isTame()&& item == Items.SEAGRASS)
        {this.heal((float)5); return ActionResultType.SUCCESS;}

        else if (this.isTame())
        {this.setOrderedToSit(!this.isOrderedToSit()); return ActionResultType.SUCCESS;}

        else return ActionResultType.FAIL;
    }


    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.STONE_BREAK;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return 0;
    }

    @Override
    public void setRemainingPersistentAngerTime(int p_230260_1_) {

    }


    @Override
    public UUID getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(UUID p_230259_1_) {

    }

    @Override
    public void startPersistentAngerTimer() {

    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}
