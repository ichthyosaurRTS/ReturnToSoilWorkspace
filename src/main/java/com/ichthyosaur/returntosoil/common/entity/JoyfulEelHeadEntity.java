package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

public class JoyfulEelHeadEntity extends CreatureEntity {

    private BlockPos targetPosition;

    private final UUID[] subEntitiesUUID = new UUID[7];
    private Entity[] segmentEntities = new Entity[7];

    public JoyfulEelHeadEntity(EntityType<? extends CreatureEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.5F)
                .add(Attributes.FOLLOW_RANGE, 96.0D);
    }




    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide()&&this.subEntitiesUUID[0]!=null) {
            this.tickParts();
        }
        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0));

        if (this.getTarget() == null || !this.getTarget().isAlive()) {
        this.setTarget(this.level.getNearestLoadedEntity(BatEntity.class,(new EntityPredicate()).range(96).selector(null),
                this,this.getX(),this.getY(),this.getZ(), this.getBoundingBox().inflate(96, 96D, 96)));


            //Bat code
            if (this.targetPosition != null && (!this.level.isEmptyBlock(this.targetPosition) || this.targetPosition.getY() < 1)) {
                this.targetPosition = null;
            }

            if (this.targetPosition == null || this.random.nextInt(30) == 0 || this.targetPosition.closerThan(this.position(), 4.0D)) {
                Double modX = (double)this.random.nextInt(14)+8;
                if (rollChance.roll(2)) modX = -modX;
                Double modY = (double)this.random.nextInt(8)+2;
                if (rollChance.roll(2)) modY = -modY;
                Double modZ = (double)this.random.nextInt(14)+8;
                if (rollChance.roll(2)) modZ = -modZ;

                this.targetPosition = new BlockPos(this.getX() + modX, this.getY() + modY, this.getZ() + modZ);
            }

            double d2 = (double)this.targetPosition.getX() + 0.5D - this.getX();
            double d0 = (double)this.targetPosition.getY() + 0.1D - this.getY();
            double d1 = (double)this.targetPosition.getZ() + 0.5D - this.getZ();
            Vector3d vector3d = this.getDeltaMovement();
            Vector3d vector3d1 = vector3d.add((Math.signum(d2) * 0.5D - vector3d.x) * (double)0.1F, (Math.signum(d0) * (double)0.7F - vector3d.y) * (double)0.1F, (Math.signum(d1) * 0.5D - vector3d.z) * (double)0.1F);
            this.setDeltaMovement(vector3d1);
            float f = (float)(MathHelper.atan2(vector3d1.z, vector3d1.x) * (double)(180F / (float)Math.PI)) - 90.0F;
            float f1 = MathHelper.wrapDegrees(f - this.yRot);
            this.zza = 0.5F;
            this.yRot += f1;
        }

        if (this.getTarget() != null) {

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

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL ||damage == DamageSource.CRAMMING || super.isInvulnerableTo(damage);
    }

    private void createSegments(Entity leader, int segmentNumber){
        GeneralFlyingSegmentEntity segment;
        World world = this.getCommandSenderWorld();

        if (segmentNumber == 0) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.5);
            segment.setModelString("JoyfulEelHead");
        }

        else if (segmentNumber == 1) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.5);
            segment.setModelString("JoyfulEelNeck");
        }

        else if (segmentNumber == 2) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.7);
            segment.setModelString("JoyfulEelBody1");
        }

        else if (segmentNumber == 3) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.6);
            segment.setModelString("JoyfulEelBody2");
        }

        else if (segmentNumber == 4) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.5);
            segment.setModelString("JoyfulEelTail1");
        }

        else if (segmentNumber == 5) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.4);
            segment.setModelString("JoyfulEelTail1");
        }

        else {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(0.4);
            segment.setModelString("JoyfulEelTail2");
        }

        segment.setLeader(leader);
        segment.moveTo((double)this.getX() + 0.5D, (double)this.getY(), (double)this.getZ() - 0.5D  , 0.0F, 0.0F);
        world.addFreshEntity(segment);

        this.subEntitiesUUID[segmentNumber] = segment.getUUID();

        if (segmentNumber<6) createSegments(segment,segmentNumber+1);
    }

}
