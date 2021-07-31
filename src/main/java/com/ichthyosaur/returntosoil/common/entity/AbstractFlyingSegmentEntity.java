package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam.GhostRamHeadEntity;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.UUID;

public abstract class AbstractFlyingSegmentEntity extends MobEntity {

    public static final Logger LOGGER = LogManager.getLogger();
    public Entity leader;
    double segmentSpaceFromLeader = 1.5;
    boolean noPhysics = true;

    protected AbstractFlyingSegmentEntity(EntityType<? extends MobEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
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

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.IN_WALL ||damage == DamageSource.FALL || super.isInvulnerableTo(damage);
    }
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isNoGravity() {
        this.noPhysics = true;
        return true;
    }

    protected void registerGoals() {}

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0D);
    }


    Vector3d oldLeader;

    @Override
    public void tick() {

        super.tick();


        if (this.getLeader()==null) this.kill();
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

            double vertRadianRotation = MathHelper.atan2(yDistance, sqrFlatDistance);
            double vertDegreeRotation = vertRadianRotation * (180F / (float) Math.PI);
            //remember has to be radians to use in equations
            LOGGER.info("yDegreeRot = " + vertDegreeRotation);


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

            newX = parentX + flatDistance;
            newZ = parentZ;


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

    }
    }

    int yDistanceOrOne(int yDist){
        if (
            Math.abs(yDist)<1 ) return 1;
        else return yDist;
    }
}


