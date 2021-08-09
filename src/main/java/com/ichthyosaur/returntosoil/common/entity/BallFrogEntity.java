package com.ichthyosaur.returntosoil.common.entity;

import com.google.common.collect.Maps;
import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;

public class BallFrogEntity extends MonsterEntity {

    private int idleTicks;
    private double jumpTimer;
    private static final DataParameter<Integer> COLOUR_INT = EntityDataManager.defineId(CatEntity.class, DataSerializers.INT);
    private static final DataParameter<Boolean> INFLATED = EntityDataManager.defineId(BallFrogEntity.class, DataSerializers.BOOLEAN);
    private double xIdleVector;
    private double yIdleVector;
    private double zIdleVector;
    private Vector3d newIdlePos;

    public BallFrogEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }


    protected void registerGoals() {
        //this.goalSelector.addGoal(8, new RandomSwimmingGoal(this, 100.0, 10)); //speed mod and interval
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1D, false)); //that float is move mod
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractFishEntity.class, true));
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.0F)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }


    private void setInflated (boolean bool) {
        this.entityData.set(INFLATED, bool);
    }
    public boolean getInflated () {
        return this.entityData.get(INFLATED);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || super.isInvulnerableTo(damage);
    }

    public boolean isNoGravity() {
        return this.isInWater();
    }

    @Override
    public void tick() {
        this.setInflated(!isInWater());
        super.tick();
        if (this.getTarget() != null) this.lookAt(this.getTarget(), 100, 100);

        if (this.getTarget() != null && this.isInWater()) {
            Entity entity = this.getTarget();
            double yDist = entity.getY() - this.getY();
            double yMod = getMovement(yDist);
            if (Math.abs(yDist) < 0.5) yMod = 0;
            double xDist = entity.getX() - this.getX();
            double xMod = getMovement(xDist) * 2;
            double zDist = entity.getZ() - this.getZ();
            double zMod = getMovement(zDist) * 2;

            this.setDeltaMovement(this.getDeltaMovement().add(xMod, yMod, zMod));
        } else if (this.getTarget() != null) {

            Block below = this.getCommandSenderWorld().getBlockState(this.blockPosition().below()).getBlock();
            Block below2 = this.getCommandSenderWorld().getBlockState(this.blockPosition().below().below()).getBlock();

            if ((below != Blocks.AIR || below2 != Blocks.AIR) && this.jumpTimer >= 16) {
                this.setDeltaMovement(this.getDeltaMovement().add(this.getLookAngle().x / 10, 0.6, this.getLookAngle().z / 10));
                this.jumpTimer = 0;
            } else if ((below != Blocks.AIR || below2 != Blocks.AIR)) this.jumpTimer += 1;
            LOGGER.info("" + this.jumpTimer);

        }
    }

    private Vector3d generateWaterPos (int numberOfTries) {

        if (numberOfTries == 3) return this.position();

        Vector3d newPos = new Vector3d(
                this.getX() + (rollChance.returnRoll(31)-16),
                this.getY() + (rollChance.returnRoll(9)-5),
                this.getZ() + (rollChance.returnRoll(31)-16));
        BlockPos blockPos = new BlockPos(newPos);

        if (this.level.getBlockState(blockPos).getBlock() == Blocks.WATER || this.level.getBlockState(blockPos).getBlock() == Blocks.WATER) return newPos;
        else return generateWaterPos(numberOfTries + 1);
    }

    public double getMovement (double distance) {
        if (distance >= 0) return 0.005;
        else return -0.005;
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


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(COLOUR_INT,1);
        this.entityData.define(INFLATED,false);
    }

    public int getColourInt() {
        return this.entityData.get(COLOUR_INT);
    }

    public void setColourIntData() {
        int i;
        if (rollChance.roll(10)) i = 1;
        else if (rollChance.roll(500)) i = 2;
        else i = 0;

        this.entityData.set(COLOUR_INT, i);
    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);
        NBT.putInt("ColourNumber", this.getColourInt());
    }

    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);
        this.entityData.set(COLOUR_INT, (NBT.getInt("ColourNumber")));
    }

    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        this.setColourIntData();
        return p_213386_4_;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.SALMON_HURT;
    } //this should be attack sound

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.HONEY_BLOCK_STEP, 0.15F, 0.5F);
    }

    /*protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SALMON_FLOP, 0.15F, 0.5F);
    }*/


    }

