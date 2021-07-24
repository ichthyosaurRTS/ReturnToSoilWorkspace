package com.ichthyosaur.returntosoil.common.Entity;

import com.google.common.collect.Maps;
import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Map;

public class ElderPoluEntity extends MonsterEntity {

    private boolean swimmingAnim;
    public float tailTimer = -3.14F;
    private static final DataParameter<Integer> COLOUR_INT = EntityDataManager.defineId(CatEntity.class, DataSerializers.INT);

    public ElderPoluEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    protected void registerGoals() {
        //this.goalSelector.addGoal(8, new RandomSwimmingGoal(this, 100.0, 10)); //speed mod and inerval
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1D, false)); //that float is move mod
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
                .add(Attributes.MOVEMENT_SPEED, (double)0.1F)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }


    private void setSwimmingAnim (boolean bool) {
        this.swimmingAnim = bool;
    }
    public boolean getSwimmingAnim () {
        return this.swimmingAnim;
    }

    public boolean isNoGravity() {
        return this.isInWater();
    }

    @Override
    public void tick() {
        this.setSwimmingAnim(isInWater());
        super.tick();
        if (this.getTarget() != null)  this.lookAt(this.getTarget(),100,100);

        if (this.getTarget() != null && this.isInWater()) {
            Entity entity =  this.getTarget();
            double yDist = entity.getY() - this.getY();
            double yMod = getMovement(yDist); if (Math.abs(yDist) < 0.5) yMod = 0;
            double xDist = entity.getX() - this.getX();
            double xMod = getMovement(xDist)*2;
            double zDist = entity.getZ() - this.getZ();
            double zMod = getMovement(zDist)*2;

            this.setDeltaMovement(this.getDeltaMovement().add(xMod, yMod, zMod));
        }
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
    }

    private int getColourInt() {
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

    public ResourceLocation getResourceLocation() {
        return COLOUR_BY_INT.getOrDefault(this.getColourInt(),new ResourceLocation(RTSMain.MOD_ID, "textures/entity/elder_polu/elder_polu_green.png") );
    }

    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        this.setColourIntData();
        return p_213386_4_;
    }

    public static final Map<Integer, ResourceLocation> COLOUR_BY_INT = Util.make(Maps.newHashMap(), (map) -> {
        map.put(0, new ResourceLocation("returntosoil:textures/entity/elder_polu/elder_polu_green.png"));
        map.put(1, new ResourceLocation("returntosoil:textures/entity/elder_polu/elder_polu_crimson.png"));
        map.put(2, new ResourceLocation("returntosoil:textures/entity/elder_polu/elder_polu_purple.png"));
    });

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

