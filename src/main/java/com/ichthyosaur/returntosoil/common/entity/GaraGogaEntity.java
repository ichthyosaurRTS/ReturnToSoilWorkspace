package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class GaraGogaEntity extends MonsterEntity {

    private BlockPos targetPosition;

    private static final DataParameter<Integer> WING_DEGREE = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> TAIL_DEGREE1 = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> TAIL_DEGREE2 = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> TAIL_DEGREE3 = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> X_BODY_ROT = EntityDataManager.defineId(DragonflyEntity.class, DataSerializers.INT);

    public GaraGogaEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 20.0D)
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

        this.setNoGravity(true);

        super.tick();

        if (this.targetPosition!=null)this.level.addParticle(ParticleTypes.FLAME,
                this.targetPosition.getX(), this.targetPosition.getY(), this.targetPosition.getZ(), 0, 0, 0);


        if (!this.level.isClientSide()) {

            //this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0));


            if (this.getTarget() == null || !this.getTarget().isAlive()) {


                if (this.targetPosition != null && (!this.level.isEmptyBlock(this.targetPosition) || this.targetPosition.getY() < 1)) {
                    this.targetPosition = null;
                }

                else if (this.targetPosition != null) {


                    double d2 = (double) this.targetPosition.getX() + 0.5D - this.getX();
                    double d0 = (double) this.targetPosition.getY() + 0.1D - this.getY();
                    if (Math.abs(d0)<1.0) d0 = 0;
                    double d1 = (double) this.targetPosition.getZ() + 0.5D - this.getZ();
                    Vector3d vector3d = this.getDeltaMovement();
                    double moveMult = 0.5;
                    Vector3d vector3d1 = vector3d.add((Math.signum(d2) * 0.5D - vector3d.x) * (double) 0.1F * moveMult, (Math.signum(d0) * (double) 0.7F - vector3d.y) * (double) 0.1F * moveMult, (Math.signum(d1) * 0.5D - vector3d.z) * (double) 0.1F * moveMult);
                    this.setDeltaMovement(vector3d1);
                    float f = (float) (MathHelper.atan2(vector3d1.z, vector3d1.x) * (double) (180F / (float) Math.PI)) - 90.0F;
                    float f1 = MathHelper.wrapDegrees(f - this.yRot);
                    this.zza = 0.5F;

                    //this.setDeltaMovement(this.getDeltaMovement().add(this.getLookAngle().x/20, this.getLookAngle().y/40, this.getLookAngle().z/20));
                    //this.yRot += f1;

                    double xDistance = this.targetPosition.getX() - this.getX();
                    double yDistance = this.targetPosition.getY() - this.getY();
                    double zDistance = this.targetPosition.getZ() - this.getZ();

                    double d3 = (double) MathHelper.sqrt(xDistance * xDistance + zDistance * zDistance);
                    float f4 = (float) (-(MathHelper.atan2(yDistance, d3) * (double) (180F / (float) Math.PI)));

                    if (!this.targetPosition.closerThan(this.position(), 8.0D) )
                        this.setRot(this.yRot += f1, (float) (f4*1.2));


                    //this.xRot = this.rotlerp(this.xRot, f4, 20);//prev 2
                }


                if (this.targetPosition == null || this.random.nextInt(200) == 0 || this.targetPosition.closerThan(this.position(), 4.0D) ||
                        this.getDeltaMovement().x()<0.01&&this.getDeltaMovement().z()<0.01&&this.getDeltaMovement().y()<0.01) {
                    this.targetPosition = this.getNewTargetPosition();
                }
            }

            if (this.getTarget() != null) {

                //this.targetPosition=new BlockPos (this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ());
                this.lookAt(this.getTarget(),10,100);
                this.setDeltaMovement(this.getDeltaMovement().add(this.getLookAngle().x/20, this.getLookAngle().y/40, this.getLookAngle().z/20));
            }
        }
    }

    private BlockPos getNewTargetPosition(){
        double modX = (double)this.random.nextInt(14)+8;
        if (rollChance.roll(2)) modX = -modX;
        double modY = - ((double)this.random.nextInt(2)+8);
        if (rollChance.roll(3)) modY = modY;
        double modZ = (double)this.random.nextInt(14)+8;
        if (rollChance.roll(2)) modZ = -modZ;

        BlockPos below = this.getOnPos();

        for (int i = 0; i<7;i++ ) {
            if (this.level.getBlockState(below.below(i)).getBlock() != Blocks.AIR) modY = rollChance.returnRoll(4);
        }


        return new BlockPos(this.getX() + modX, this.getY() + modY, this.getZ() + modZ);
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
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WING_DEGREE, 0);
        this.entityData.define(TAIL_DEGREE1, 0);
        this.entityData.define(TAIL_DEGREE2, 0);
        this.entityData.define(TAIL_DEGREE3, 0);
        this.entityData.define(X_BODY_ROT, 0);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL || super.isInvulnerableTo(damage);
    }

    public int getWingDegree() {
        int deg = this.entityData.get(WING_DEGREE);

        if (deg<45) return deg;
        else if (deg<135) return 90-deg;
        else return deg-180;
    }
    public int[] getTailDegree() {
        int[] tailDeg = new int[] {this.entityData.get(TAIL_DEGREE1), this.entityData.get(TAIL_DEGREE2), this.entityData.get(TAIL_DEGREE3)};

        return tailDeg;
    }
    public int getXBodyRot() {
        return this.entityData.get(X_BODY_ROT);
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
}
