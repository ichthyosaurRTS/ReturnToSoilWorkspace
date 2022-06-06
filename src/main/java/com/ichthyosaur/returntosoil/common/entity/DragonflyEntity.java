package com.ichthyosaur.returntosoil.common.entity;

import com.google.common.collect.Maps;
import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;

public class DragonflyEntity extends MonsterEntity {


    private BlockPos targetPosition;
    private static final DataParameter<Integer> COLOUR_INT = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> WING_DEGREE = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> TAIL_DEGREE1 = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> TAIL_DEGREE2 = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> TAIL_DEGREE3 = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);

    public DragonflyEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 22.0D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.1F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 4.0D, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PigEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, true));
    }

    @Override
    public void tick() {

        super.tick();

        this.updateWingDegree();

        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0));

        if(!this.level.isClientSide()) {

            if (this.getTarget() == null || !this.getTarget().isAlive()) {

                if (this.targetPosition != null && (!this.level.isEmptyBlock(this.targetPosition) || this.targetPosition.getY() < 1)) {
                    this.targetPosition = null;
                }

                if (this.targetPosition == null || this.random.nextInt(20) == 0 || this.targetPosition.closerThan(this.position(), 2.0D) ||
                        this.getDeltaMovement().x() < 0.01 && this.getDeltaMovement().z() < 0.01 && this.getDeltaMovement().y() < 0.01) {
                    double modX = (double) this.random.nextInt(8) + 4;
                    if (rollChance.roll(2)) modX = -modX;
                    double modY;
                    double modZ = (double) this.random.nextInt(8) + 4;
                    if (rollChance.roll(2)) modZ = -modZ;


                    BlockPos below = this.getOnPos();
                if (this.level.getBlockState(below).getBlock()== Blocks.AIR &&
                        this.level.getBlockState(below.below(1)).getBlock()== Blocks.AIR &&
                        this.level.getBlockState(below.below(2)).getBlock()== Blocks.AIR &&
                        this.level.getBlockState(below.below(3)).getBlock()== Blocks.AIR)
                    modY = -0.5;
                else modY = 1.0;

                    this.targetPosition = new BlockPos(this.getX() + modX, this.getY() + modY, this.getZ() + modZ);
                }
            }

            if (this.getTarget() != null) {
                Vector3d v = this.getTarget().getEyePosition(1);
                this.targetPosition = new BlockPos(v.x(), v.y(), v.z());
            }

            if (this.targetPosition != null) {

                double d2 = (double) this.targetPosition.getX() + 0.5D - this.getX();
                double d0 = (double) this.targetPosition.getY() + 0.1D - this.getY();
                double d1 = (double) this.targetPosition.getZ() + 0.5D - this.getZ();
                Vector3d vector3d = this.getDeltaMovement();
                Vector3d vector3d1 = vector3d.add((Math.signum(d2) * 0.5D - vector3d.x) * (double) 0.1F, (Math.signum(d0) * (double) 0.7F - vector3d.y) * (double) 0.1F, (Math.signum(d1) * 0.5D - vector3d.z) * (double) 0.1F);
                this.setDeltaMovement(vector3d1);
                float f = (float) (MathHelper.atan2(vector3d1.z, vector3d1.x) * (double) (180F / (float) Math.PI)) - 90.0F;
                float f1 = MathHelper.wrapDegrees(f - this.yRot);
                this.zza = 0.5F;
                this.yRot += f1;

                double xDistance = this.targetPosition.getX() - this.getX();
                double yDistance = this.targetPosition.getY() - this.getY();
                double zDistance = this.targetPosition.getZ() - this.getZ();

                double d3 = (double) MathHelper.sqrt(xDistance * xDistance + zDistance * zDistance);
                float f4 = (float) (-(MathHelper.atan2(yDistance, d3) * (double) (180F / (float) Math.PI)));
                this.xRot = this.rotlerp(this.xRot, f4, 20);//prev 2
            }
        }
    }

    private float rotlerp(float p_70663_1_, float p_70663_2_, float p_70663_3_) {
        float f = MathHelper.wrapDegrees(p_70663_2_ - p_70663_1_);
        if (f > p_70663_3_) {
            f = p_70663_3_;
        }

        if (f < -p_70663_3_) {
            f = -p_70663_3_;
        }

        return p_70663_1_ + f;
    }

    private void updateWingDegree(){
        int deg = this.entityData.get(WING_DEGREE);
        if (deg>165) this.entityData.set(WING_DEGREE, 0);
        else this.entityData.set(WING_DEGREE, deg+20);

        int deg2 = this.entityData.get(TAIL_DEGREE1);
        if (deg2>174) this.entityData.set(TAIL_DEGREE1, -180);
        else this.entityData.set(TAIL_DEGREE1, deg2+6);

        int deg3 = this.entityData.get(TAIL_DEGREE2);
        if (deg3>174) this.entityData.set(TAIL_DEGREE2, -180);
        else this.entityData.set(TAIL_DEGREE2, deg3+6);

        int deg4 = this.entityData.get(TAIL_DEGREE3);
        if (deg4>174) this.entityData.set(TAIL_DEGREE3, -180);
        else this.entityData.set(TAIL_DEGREE3, deg4+6);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL || super.isInvulnerableTo(damage);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(COLOUR_INT,1);
        this.entityData.define(WING_DEGREE, 0);
        this.entityData.define(TAIL_DEGREE1, 0);
        this.entityData.define(TAIL_DEGREE2, 0);
        this.entityData.define(TAIL_DEGREE3, 0);
    }

    private int getColourInt() {
        return this.entityData.get(COLOUR_INT);
    }

    public int getWingDegree() {
        int deg = this.entityData.get(WING_DEGREE);

        if (deg<45) return deg;
        else if (deg<135) return 90-deg;
        else return deg-180;
    }
    public int[] getTailDegree() {
        int[] array = new int[3];
        int[] tailDeg = new int[] {this.entityData.get(TAIL_DEGREE1), this.entityData.get(TAIL_DEGREE2), this.entityData.get(TAIL_DEGREE3)};

        return tailDeg;
        /*
        for(int i=0;i<3;i++) {
            int deg = tailDeg[i];

            if (deg<45) array[i] = deg;
            else if (deg<91) array[i] = 90-deg;
            else if (deg<135) array[i] = 90-deg;
            else array[i] = deg-180;
        }

        return array;*/
    }

    public void setColourIntData() {
        this.entityData.set(COLOUR_INT, (int)rollChance.returnRoll(3)-1);
    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);
        NBT.putInt("ColourNumber", this.getColourInt());
        NBT.putInt("WingDegree", this.entityData.get(WING_DEGREE));
        NBT.putInt("TailDegree1", this.entityData.get(TAIL_DEGREE1));
        NBT.putInt("TailDegree2", this.entityData.get(TAIL_DEGREE2));
        NBT.putInt("TailDegree3", this.entityData.get(TAIL_DEGREE3));
    }
    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);
        this.entityData.set(COLOUR_INT, (NBT.getInt("ColourNumber")));
        this.entityData.set(WING_DEGREE, (NBT.getInt("WingDegree")));
        this.entityData.set(TAIL_DEGREE1, (NBT.getInt("TailDegree1")));
        this.entityData.set(TAIL_DEGREE2, (NBT.getInt("TailDegree2")));
        this.entityData.set(TAIL_DEGREE3, (NBT.getInt("TailDegree3")));
    }

    public ResourceLocation getResourceLocation() {
        return COLOUR_BY_INT.getOrDefault(this.getColourInt(),new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/dragonfly/dragonfly_1.png") );
    }

    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        this.setColourIntData();
        this.entityData.set(TAIL_DEGREE1, 60);
        this.entityData.set(TAIL_DEGREE2, 30);
        this.entityData.set(TAIL_DEGREE3, 0);
        return p_213386_4_;
    }

    public static final Map<Integer, ResourceLocation> COLOUR_BY_INT = Util.make(Maps.newHashMap(), (map) -> {
        map.put(0, new ResourceLocation("returntosoil:textures/entity/dragonfly/dragonfly_0.png"));
        map.put(1, new ResourceLocation("returntosoil:textures/entity/dragonfly/dragonfly_1.png"));
        map.put(2, new ResourceLocation("returntosoil:textures/entity/dragonfly/dragonfly_2.png"));
    });

}
