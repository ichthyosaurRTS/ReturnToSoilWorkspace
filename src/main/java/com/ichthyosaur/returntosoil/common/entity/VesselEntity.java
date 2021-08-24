package com.ichthyosaur.returntosoil.common.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class VesselEntity extends CreatureEntity {
    //needs multiplayer testing!

    public static final Logger LOGGER = LogManager.getLogger();

    public LivingEntity owner = null;
    private UUID ownerUUID;

    public VesselEntity(EntityType<? extends CreatureEntity> p_i48576_1_, World p_i48576_2_) {
        super(p_i48576_1_, p_i48576_2_);
    }
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.1F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1f));
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide()) {
            ServerWorld worldIn = (ServerWorld) this.level;

            if (this.getOwner() == null) {
                if (this.ownerUUID != null) {
                    if (worldIn.getEntity(this.ownerUUID) != null) {
                        this.setOwner( (LivingEntity) worldIn.getEntity(this.ownerUUID) );
                    }
                }
            }
        }

    }

    @Override
    public void die(DamageSource p_70645_1_) {

        if (this.getOwner() == null) { }
        else if (this.getOwner() != null && this.getOwner().isAlive()) this.getOwner().moveTo(this.getPosition(1));
        super.die(p_70645_1_);
    }

    @Override
    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {

        if (this.getOwner() == null ) return super.hurt(p_70097_1_, p_70097_2_);
        else if (this.getOwner() != null && this.getOwner().isAlive()) this.getOwner().hurt(p_70097_1_, p_70097_2_*2);
        return super.hurt(p_70097_1_, p_70097_2_);
    }


    public void setOwner(LivingEntity owner) {
        this.owner = owner;
    }

    public LivingEntity getOwner() {
        if (this.owner != null) return this.owner;
        else return null;
    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);

        if (this.getOwner()!=null) NBT.putUUID("Owner",this.getOwner().getUUID());
    }

    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);

        if (NBT.hasUUID("Owner")) {
            this.ownerUUID = NBT.getUUID("Owner");
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.GHAST_SCREAM;
    }

}
