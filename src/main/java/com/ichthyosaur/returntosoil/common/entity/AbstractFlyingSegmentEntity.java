package com.ichthyosaur.returntosoil.common.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;


public abstract class AbstractFlyingSegmentEntity extends FlyingEntity {

    public static final Logger LOGGER = LogManager.getLogger();
    public Entity leader;
    double segmentSpaceFromLeader = 1.5;
    boolean noPhysics = true;
    private UUID leaderUUID;

    protected AbstractFlyingSegmentEntity(EntityType<? extends FlyingEntity> p_i48578_1_, World p_i48578_2_) {
        super(p_i48578_1_, p_i48578_2_);
    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);
        NBT.putDouble("Spacing",this.segmentSpaceFromLeader);
        if (this.getLeader()!=null) NBT.putUUID("Leader",this.getLeader().getUUID());
    }

    public boolean removeWhenFarAway(double p_213397_1_) {
        return false;
    }

    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);
        if (NBT.contains("Spacing")) this.segmentSpaceFromLeader = NBT.getDouble("Spacing");
        if (NBT.hasUUID("Leader")) {
            this.leaderUUID = NBT.getUUID("Leader");
        }
    }

    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL ||damage == DamageSource.CRAMMING || super.isInvulnerableTo(damage);
    }

    public void setSpacing (double spacing) {
        this.segmentSpaceFromLeader = spacing;
    }

    public void setLeader(Entity leader) {
        this.leader = leader;
    }

    public Entity getLeader() {
        return this.leader;
    }


    //re-rout the dmg to leader and so on
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source == DamageSource.OUT_OF_WORLD||this.getLeader()==null) return super.hurt(source,amount);
        return this.getLeader().hurt(source,amount);
    }

    //Neither of these work
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    @Override
    public boolean canCollideWith(Entity p_241849_1_) {
        return false;
    }


    public boolean isNoGravity() {
        this.noPhysics = true;
        return true;
    }

    protected SoundEvent getDeathSound() {
        return null;
    }

    protected void registerGoals() {}

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0D);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void push(Entity p_70108_1_) {
    }

    @Override
    public void tick() {

        super.tick();

        if (this.getLeader()==null) {
            if (this.leaderUUID!=null) {
                ServerWorld worldIn = (ServerWorld) this.getCommandSenderWorld();
                this.setLeader(worldIn.getEntity(this.leaderUUID));
            }
            else this.kill(); //should probably use this.remove(false) here but it needs to tick to retrieve data i think
        }

        else {
            if (!this.getLeader().isAlive()) this.kill();


            //START MOVEMENT
            double xPos = this.getX();
            double yPos = this.getY();
            double zPos = this.getZ();

            double parentX = this.getLeader().getX();
            double parentY = this.getLeader().getY();
            double parentZ = this.getLeader().getZ();


            double xDistance = parentX - xPos;
            double yDistance = parentY - yPos;
            double zDistance = parentZ - zPos;

            double sqrFullDistance = Math.sqrt(xDistance * xDistance + zDistance * zDistance + yDistance * yDistance);
            double sqrFlatDistance = Math.sqrt(xDistance * xDistance + zDistance * zDistance);


            //This should really be based on the parent so we can rotated based on their look direction but no worries for now.
            double flatRadianRotation = MathHelper.atan2(xDistance, zDistance);
            double flatDegreeRotation =  flatRadianRotation * (180F / (float) Math.PI);
            //needs to check look at of parent and see if hes looking too far away as well- change rot based on that

            double vertRadianRotation = MathHelper.atan2(yDistance, sqrFlatDistance);
            double vertDegreeRotation = vertRadianRotation * (180F / (float) Math.PI);
            //remember has to be radians to use in equations
            //LOGGER.info("yDegreeRot = " + vertDegreeRotation);


            //The full distance we want (also the hypotenuse to use)
            double fullWantedDistance = this.segmentSpaceFromLeader;

            double newZ;
            double newX;
            double newY;

            //New yDistance, essentially. If parent is below child, is negative
            double vertDistance = Math.sin(vertRadianRotation) * fullWantedDistance;

            //New flat distance, to be used as the hypotenuse for x and z finding. Always positive
            double flatDistance = Math.cos(vertRadianRotation) * fullWantedDistance;

            newY = parentY - vertDistance;

            if (flatDegreeRotation < -90) {
                double theta = flatDegreeRotation * ((float) Math.PI / 180F);  //here we take away however many 90 degree factors we need
                newZ = parentZ - (Math.cos(theta) * flatDistance);
                newX = parentX - (Math.sin(theta) * flatDistance); //minus bc in this case, the parent is above/greater than
            } else if (flatDegreeRotation >= -90 && flatDegreeRotation < 0) {
                double theta = (flatDegreeRotation - 90)* ((float) Math.PI / 180F);
                newZ = parentZ + (Math.sin(theta) * flatDistance);
                newX = parentX - (Math.cos(theta) * flatDistance);
            } else if (flatDegreeRotation >= 0 && flatDegreeRotation < 90) {
                double theta = (flatDegreeRotation - 180)* ((float) Math.PI / 180F);
                newZ = parentZ + (Math.cos(theta) * flatDistance);
                newX = parentX + (Math.sin(theta) * flatDistance);
            } else {
                double theta = (flatDegreeRotation - 270)* ((float) Math.PI / 180F);
                newZ = parentZ - (Math.sin(theta) * flatDistance);
                newX = parentX + (Math.cos(theta) * flatDistance);
            }

            this.moveTo(newX, newY, newZ);
            //END OF MOVEMENT

            //START OF ROTATION
            this.setRot(((float) ((MathHelper.wrapDegrees(360-flatDegreeRotation)))),(float)(MathHelper.wrapDegrees(360-vertDegreeRotation)));
            this.getLookControl().setLookAt(parentX, parentY, parentZ);
            //END OF ROTATION
    }
    }
}


