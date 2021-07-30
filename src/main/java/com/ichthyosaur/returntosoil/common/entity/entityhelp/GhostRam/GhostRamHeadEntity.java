package com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class GhostRamHeadEntity extends MonsterEntity {

    boolean hasSegments = false;
    private final double numberOfSegments = 4;

    public GhostRamHeadEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 20D)
                .add(Attributes.MOVEMENT_SPEED, (double)1F)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, BatEntity.class, true));
    }

    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        //createSegments(this,0);
        return p_213386_4_;
    }

    @Override
    public void tick() {
        super.tick();
        if (!hasSegments) {
            this.createSegments(this, (int)0);
            this.hasSegments = true;
        }

        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0));

        if (this.getTarget() != null)  this.lookAt(this.getTarget(),100,100);

        if (this.getTarget() != null) {
            Entity entity =  this.getTarget();
            double yDist = entity.getY() - this.getY();
            double yMod = getMovement(yDist)*3;
            double xDist = entity.getX() - this.getX();
            double xMod = getMovement(xDist)*3;
            double zDist = entity.getZ() - this.getZ();
            double zMod = getMovement(zDist)*3;

            this.setDeltaMovement(this.getDeltaMovement().add(xMod, yMod, zMod));
        }

    }

    public double getMovement (double distance) {
        if (distance >= 0) return 0.005;
        else return -0.005;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL ||damage == DamageSource.CRAMMING || super.isInvulnerableTo(damage);
    }

    private void createSegments(Entity leader, int segmentNumber){
        AbstractFlyingSegmentEntity segment;
        World world = this.getCommandSenderWorld();

        if (segmentNumber<this.numberOfSegments) {
        segment = EntityTypesInit.GHOSTRAMBODY.get().create(world); }

        else { segment = EntityTypesInit.GHOSTRAMBUTT.get().create(world); }

        segment.setSpacing(2);
        segment.setLeader(leader);
        segment.moveTo((double)this.getX() + 0.5D, (double)this.getY(), (double)this.getZ() - 0.5D  , 0.0F, 0.0F);
        world.addFreshEntity(segment);

        if (segmentNumber<this.numberOfSegments) createSegments(segment,segmentNumber+1);
    }
}
