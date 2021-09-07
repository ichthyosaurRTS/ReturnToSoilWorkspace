package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.entity.PartEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.UUID;

public class WarraRupeHeadEntity extends AbstractContractEntity {

    public static final Logger LOGGER = LogManager.getLogger();

    private BlockPos targetPosition;


    private final UUID[] subEntitiesUUID = new UUID[6];
    private Entity[] segmentEntities = new Entity[6];

    public WarraRupeHeadEntity(EntityType<? extends AbstractContractEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.5F)
                .add(Attributes.FOLLOW_RANGE, 96.0D);
    }

    public boolean isAggressiveInWild() {
        return false;
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

        super.tick();

        if (!this.level.isClientSide()&&this.subEntitiesUUID[0]!=null) {
            this.tickParts();
        }
        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0));

        if (this.getTarget() == null || !this.getTarget().isAlive()) {
        //this.setTarget(this.level.getNearestLoadedEntity(BatEntity.class,(new EntityPredicate()).range(96).selector(null),
                //this,this.getX(),this.getY(),this.getZ(), this.getBoundingBox().inflate(96, 96D, 96)));

            //Bat code (some)
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
                this.xRot = this.rotlerp(this.xRot, f1, 2);
                this.yRot = this.rotlerp(this.yRot, f, 10);//that last one is definitely turn speed/ rot speed
                this.getLookControl().setLookAt(parentX, parentY, parentZ, 10, 180);

                double speedMod;
                if (this.getLastHurtByMob() != null) speedMod = 15;
                else speedMod = 30;

                this.setDeltaMovement(this.getDeltaMovement().add(this.getLookAngle().x/speedMod, this.getLookAngle().y/speedMod, this.getLookAngle().z/speedMod));
            }

            if (this.targetPosition == null || this.random.nextInt(200) == 0 || this.targetPosition.closerThan(this.position(), 2.0D) ||
            this.getDeltaMovement().x()<0.01&&this.getDeltaMovement().z()<0.01&&this.getDeltaMovement().y()<0.01) {
                Double modX = (double)this.random.nextInt(14)+8;
                if (rollChance.roll(2)) modX = -modX;
                Double modY = (double)this.random.nextInt(10);
                if (rollChance.roll(2)) modY = -modY;
                Double modZ = (double)this.random.nextInt(14)+8;
                if (rollChance.roll(2)) modZ = -modZ;

                this.targetPosition = new BlockPos(this.getX() + modX, this.getY() + modY, this.getZ() + modZ);
            }
        }

        if (this.getTarget() != null) {

            this.lookAt(this.getTarget(),10,100);
            this.setDeltaMovement(this.getDeltaMovement().add(this.getLookAngle().x/30, this.getLookAngle().y/30, this.getLookAngle().z/30));
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
            for (Entity entity : this.segmentEntities) { if (entity != null) entity.tick();
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

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL ||damage == DamageSource.CRAMMING || super.isInvulnerableTo(damage);
    }

    private void createSegments(Entity leader, int segmentNumber){
        GeneralFlyingSegmentEntity segment;
        World world = this.getCommandSenderWorld();

        if (segmentNumber == 0) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.7);
            segment.setModelString("WarraRupeNeck");
        }

        else if (segmentNumber == 1) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.7);
            segment.setModelString("WarraRupeBody1");
        }

        else if (segmentNumber == 2) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.7);
            segment.setModelString("WarraRupeBody2");
        }

        else if (segmentNumber == 3) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.4);
            segment.setModelString("WarraRupeTail1");
        }

        else if (segmentNumber == 4) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.4);
            segment.setModelString("WarraRupeTail1");
        }

        else {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.4);
            segment.setModelString("WarraRupeTail2");
        }

        segment.setLeader(leader);
        segment.moveTo((double)this.getX() + 0.5D, (double)this.getY(), (double)this.getZ() - 0.5D  , 0.0F, 0.0F);
        world.addFreshEntity(segment);

        this.subEntitiesUUID[segmentNumber] = segment.getUUID();

        if (segmentNumber<5) createSegments(segment,segmentNumber+1);
    }

}
