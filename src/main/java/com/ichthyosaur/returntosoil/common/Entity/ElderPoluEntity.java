package com.ichthyosaur.returntosoil.common.Entity;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FindWaterGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ElderPoluEntity extends MonsterEntity {


    public ElderPoluEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(7, new FindWaterGoal(this));
        //this.goalSelector.addGoal(8, new RandomSwimmingGoal(this, 1.0, 40));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1D, false)); //that float is move mod
        //this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, 0.8F));
        //this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1.0f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, true));
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.2F)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }


    private void updateSpeed() {
        if (this.isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.05D, 0.0D));
        } else {
            this.setSpeed(0.1F);
        }
    }

    public boolean isNoGravity() {
        return this.isInWater();
    }

    @Override
    public void tick() {
        if (this.getTarget() != null && this.isInWater()) {
            Entity entity =  this.getTarget();
            double yDist = entity.getY() - this.getY();
            double yMod = getMovement(yDist)*1;
            double xDist = entity.getX() - this.getX();
            double xMod = getMovement(xDist)*2;
            double zDist = entity.getZ() - this.getZ();
            double zMod = getMovement(zDist)*2;

            this.setDeltaMovement(this.getDeltaMovement().add(xMod, yMod, zMod));

            double degreeRotation = MathHelper.atan2(xDist, zDist) * (180F / (float)Math.PI);
            double yRadianRotation = MathHelper.atan2(yDist,MathHelper.sqrt(xDist*xDist + zDist*zDist));
            double yDegreeRotation = yRadianRotation * (180F / (float)Math.PI);

            this.setRot(((float) ((MathHelper.wrapDegrees(360-degreeRotation)))),(float)(MathHelper.wrapDegrees(360-yDegreeRotation)));
            this.getLookControl().setLookAt(entity.getX(), entity.getY(), entity.getZ());

        }
        else this.setDeltaMovement(this.getDeltaMovement().add(0, 0, 0) );
        super.tick();
    }

    public double getMovement (double distance) {
        if (distance >= 0) return 0.005;
        else return -0.005;
    }

    /*@Override
    public void tick() {
        super.baseTick();
        this.updateSpeed();
        if (this.getTarget() != null) this.target = this.getTarget();
    } */

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public CreatureAttribute getMobType() {
        return CreatureAttribute.WATER;
    }



    }
