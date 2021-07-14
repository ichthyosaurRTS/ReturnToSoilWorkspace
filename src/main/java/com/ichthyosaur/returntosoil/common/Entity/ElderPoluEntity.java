package com.ichthyosaur.returntosoil.common.Entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class ElderPoluEntity extends MonsterEntity {

    public Entity target;

    public ElderPoluEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    protected void registerGoals() {
        //this.goalSelector.addGoal(7, new FindWaterGoal(this));
        //this.goalSelector.addGoal(8, new RandomSwimmingGoal(this, 1.0, 40));
        //this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 4.0D, false)); //that float is move speed or atleast a mod
        //this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new SwimMeleeGoal(this));
        //this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, 0.8F));
        //this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1.0f));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, true));
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.1F);
    }



    private void updateSpeed() {
        if (this.isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.05D, 0.0D));
        } else {
            this.setSpeed(0.1F);
        }

    }

    @Override
    public void tick() {
        super.baseTick();
        this.updateSpeed();
        if (this.getTarget() != null) this.target = this.getTarget();
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public CreatureAttribute getMobType() {
        return CreatureAttribute.WATER;
    }

    static class SwimMeleeGoal extends Goal{
        private ElderPoluEntity polu;

        public SwimMeleeGoal(ElderPoluEntity polu) {
            this.polu = polu;

            if (polu.target != null) {

                double tx = polu.target.getX();
                double ty = polu.target.getY();
                double tz = polu.target.getZ();

                Vector3d vector3d = new Vector3d(polu.getX() - tx, polu.getY() - ty, polu.getZ() - tz);
                polu.moveTo(tx, ty, tz);
            }
        }

        public boolean canUse() { return this.polu.isInWater(); }
    }


    }
