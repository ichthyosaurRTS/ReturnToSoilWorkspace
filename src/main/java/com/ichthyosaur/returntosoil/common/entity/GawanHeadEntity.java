package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.UUID;

public class GawanHeadEntity extends AbstractContractEntity {

    public static final Logger LOGGER = LogManager.getLogger();

    private static final DataParameter<Integer> MOUTH_DEGREE = EntityDataManager.defineId(GawanHeadEntity.class, DataSerializers.INT);

    private BlockPos targetPosition;
    private int headTicker;


    private final UUID[] subEntitiesUUID = new UUID[7];
    private Entity[] segmentEntities = new Entity[7];

    public GawanHeadEntity(EntityType<? extends AbstractContractEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.5F)
                .add(Attributes.FOLLOW_RANGE, 96.0D);
    }

    public boolean isAggressiveInWild() {
        return !(this.level.getDifficulty()== Difficulty.PEACEFUL);
    }

    public int getRemainingPersistentAngerTime() {
        return 0;
    }

    @Override
    public int getMaxHeadXRot() {
        return 180;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double p_70112_1_) {
        return p_70112_1_<4000;
    }

    @Override
    public void tick() {

        this.checkAndResetUpdateChunkPos();

        super.tick();

        if (!this.level.isClientSide()&&this.subEntitiesUUID[0]!=null) {
            this.tickParts();
        }

        if (!this.level.isClientSide()) {

        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0));


        if (this.getTarget() == null || !this.getTarget().isAlive()) {

            this.closeMouth();

        this.setTarget(this.level.getNearestLoadedEntity(VillagerEntity.class,(new EntityPredicate()).range(96).selector(null),
                this,this.getX(),this.getY(),this.getZ(), this.getBoundingBox().inflate(96, 96D, 96)));


            if (this.targetPosition != null && (!this.level.isEmptyBlock(this.targetPosition) || this.targetPosition.getY() < 1)) {
                this.targetPosition = null;
            }

            else if (this.targetPosition != null) {

                double xPos = this.getX();
                double yPos = this.getY();
                double zPos = this.getZ();

                double parentX = this.targetPosition.getX();
                double parentY = this.targetPosition.getY();
                double parentZ = this.targetPosition.getZ();

                double xDistance = parentX - xPos;
                double yDistance = parentY - yPos;
                double zDistance = parentZ - zPos;

                double d3 = (double)MathHelper.sqrt(xDistance * xDistance + zDistance * zDistance);
                float f = (float)(MathHelper.atan2(zDistance, xDistance) * (double)(180F / (float)Math.PI)) - 90.0F;
                float f1 = (float)(-(MathHelper.atan2(yDistance, d3) * (double)(180F / (float)Math.PI)));

                this.getLookControl().setLookAt(parentX, parentY, parentZ, 5, 180);
                this.xRot = this.rotlerp(this.xRot, f1, 2);//prev 2
                this.yRot = this.rotlerp(this.yRot, f, 5);


                double speedMod;
                if (this.getLastHurtByMob() != null) speedMod = 40;
                else speedMod = 40;

                this.setDeltaMovement(this.getDeltaMovement().add(this.getLookAngle().x/speedMod, this.getLookAngle().y/speedMod, this.getLookAngle().z/speedMod));
            }

            if (this.targetPosition == null || this.random.nextInt(200) == 0 || this.targetPosition.closerThan(this.position(), 2.0D) ||
            this.getDeltaMovement().x()<0.01&&this.getDeltaMovement().z()<0.01&&this.getDeltaMovement().y()<0.01) {
                Double modX = (double)this.random.nextInt(14)+8;
                if (rollChance.roll(2)) modX = -modX;
                Double modY = (double)this.random.nextInt(2)+8;
                if (rollChance.roll(2)) modY = -modY;
                Double modZ = (double)this.random.nextInt(14)+8;
                if (rollChance.roll(2)) modZ = -modZ;

                this.targetPosition = new BlockPos(this.getX() + modX, this.getY() + modY, this.getZ() + modZ);


            }
        }

        if (this.getTarget() != null) {


            if (this.distanceToSqr(this.getTarget())<20) this.openMouth();
            else this.closeMouth();

            if (this.distanceToSqr(this.getTarget())<6 && this.getMouthDegree()>500) {
                this.getTarget().hurt(DamageSource.mobAttack(this), 9);
                this.biteMouth();
            }

            this.lookAt(this.getTarget(),10,100);
            this.setDeltaMovement(this.getDeltaMovement().add(this.getLookAngle().x/20, this.getLookAngle().y/40, this.getLookAngle().z/20));
        }
        }
    }


    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        createSegments(this,0);
        return p_213386_4_;
    }


    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);

        for (int i = 0; i < this.subEntitiesUUID.length; i++) {
            if (this.subEntitiesUUID[i] != null) {
                NBT.putUUID("subEntity"+i, this.subEntitiesUUID[i]);
            }
        }
    }



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MOUTH_DEGREE,0);
    }

    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);

        if(this.subEntitiesUUID[0] == null && NBT.contains("subEntity0")) {
            for (int i = 0; i < this.subEntitiesUUID.length; i++) {
                this.subEntitiesUUID[i] = NBT.getUUID("subEntity"+i); }
        }
    }

    private void tickParts() {

        if (this.segmentEntities[0] == null && this.subEntitiesUUID[0] != null) {
            this.segmentEntities = rollChance.createSegmentList(this.subEntitiesUUID, (ServerWorld) this.getCommandSenderWorld());
        }
        else if (this.subEntitiesUUID[0] == null) {}
        else {
            for ( Entity entity : this.segmentEntities) {
                if (entity != null) entity.tick();

                else { this.removeAllParts();
                this.createSegments(this,0);}
            }
        }
    }
    private void removeAllParts() {

        if (this.segmentEntities[0] == null && this.subEntitiesUUID[0] != null) {
        this.segmentEntities = rollChance.createSegmentList(this.subEntitiesUUID, (ServerWorld) this.getCommandSenderWorld());
        }
        else if (this.subEntitiesUUID[0] == null) {}
        else {
            for ( Entity entity : this.segmentEntities) { if (entity != null) entity.remove(false);
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

    //0-600
    public int getMouthDegree(){
        return this.entityData.get(MOUTH_DEGREE);
    }
    private void openMouth(){
        int degree = this.getMouthDegree();
        if (degree < 600) this.entityData.set(MOUTH_DEGREE, degree+20);
    }
    private void closeMouth(){
        int degree = this.getMouthDegree();
        if (degree > 0 ) this.entityData.set(MOUTH_DEGREE, degree-10);
    }
    private void biteMouth(){
        this.entityData.set(MOUTH_DEGREE, 0);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL ||damage == DamageSource.CRAMMING || super.isInvulnerableTo(damage);
    }

    private void createSegments(Entity leader, int segmentNumber){
        PartEntity segment;
        World world = this.getCommandSenderWorld();

        if (segmentNumber == 0) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1.1);
            segment.setModelString("GawanNeck");
        }

        else if (segmentNumber == 1) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1.2);
            segment.setModelString("GawanBody1");
        }

        else if (segmentNumber == 2) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1.6);
            segment.setModelString("GawanBody2");
        }

        else if (segmentNumber == 3) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1.6);
            segment.setModelString("GawanBody3");
        }

        else if (segmentNumber == 4) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1.6);
            segment.setModelString("GawanBody4");
        }

        else if (segmentNumber == 5) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1.6);
            segment.setModelString("GawanBody5");
        }

        else {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1);
            segment.setModelString("GawanTail");
        }

        segment.setLeader(leader);
        segment.moveTo((double)this.getX() + 0.5D, (double)this.getY(), (double)this.getZ() - 0.5D  , 0.0F, 0.0F);
        world.addFreshEntity(segment);

        this.subEntitiesUUID[segmentNumber] = segment.getUUID();

        if (segmentNumber<6) createSegments(segment,segmentNumber+1);
    }

}
