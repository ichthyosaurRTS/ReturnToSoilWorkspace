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
        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0)); //offset gravity

        double xPos = this.getX();
        double zPos = this.getZ();
        double yPos = this.getY();

        double parentX = this.getLeader().getX();
        double parentY = this.getLeader().getY();
        double parentZ = this.getLeader().getZ();

        double zDistance = parentZ - zPos;
        double xDistance = parentX - xPos;
        double yDistance = parentY - yPos;
        double absYDistance = Math.abs(yDistance);

            double sqrFlatDistance = Math.sqrt(xDistance * xDistance + zDistance * zDistance);

        //  gets angle in radians, converts to degrees
        double wantedDistance = this.segmentSpaceFromLeader; //hypotenuse for us
        double flatDegreeRotation = MathHelper.atan2(xDistance, zDistance) * (180F / (float) Math.PI);//
        double yDegreeRotation = - MathHelper.atan2(yDistance, sqrFlatDistance) * (180F / (float) Math.PI) - 90; //apparently from -90 to 90... wtf
            //sqr flat is always positive....

        //LOGGER.info(""+yDegreeRotation);

        //  the up down rot here gets sent to the model anim, we need the 2nd float here and the setupAnim code to work. Also, miracle.
        //  the entire segment model must be a child of fake head, or acting head.
            this.lookAt(this.getLeader(),100,100);
            this.getLookControl().setLookAt(parentX, parentY, parentZ);
            this.setRot(((float) ((MathHelper.wrapDegrees(360-flatDegreeRotation)))),(float)(MathHelper.wrapDegrees( yDegreeRotation)));
            //this works dont touch unless you mess with ydegreerot as well

            double sqrDistance = Math.sqrt(xDistance * xDistance + zDistance * zDistance + yDistance * yDistance);

        // not accounting for 0,90,180,270 exact, using the 4 segment method sqrDistance > wantedDistance + 0.01 || sqrDistance < wantedDistance - 0.01 if (sqrDistance != wantedDistance)
        if (sqrDistance != wantedDistance) {
            double newZ;
            double newX;
            double newY;

            //they needs to be in radians to use idiot

            double absYDegreeRotation= Math.abs(yDegreeRotation);
            double yRadianRotation = yDegreeRotation * ((float) Math.PI / 180F); //changed this now produces neg
            double vertDistance = Math.sin(yRadianRotation) * wantedDistance;


            if (yDegreeRotation>=0) {
                newY = parentY-vertDistance;
            }
            else {
                newY = parentY+vertDistance;
            }


            double flatWantedDistance = Math.cos(yRadianRotation) * wantedDistance;

            //also needs to move based on look at
            double positiveFlatRotation = flatDegreeRotation;


            //wanted distance should be flatwanteddistance for 3d movement
            if (positiveFlatRotation < -90) {
                double theta = positiveFlatRotation * ((float) Math.PI / 180F);  //here we take away however many 90 degree factors we need
                newZ = parentZ - (Math.cos(theta) * wantedDistance);
                newX = parentX - (Math.sin(theta) * wantedDistance); //minus bc in this case, the parent is above/greater than
            } else if (positiveFlatRotation >= -90 && positiveFlatRotation < 0) {
                double theta = (positiveFlatRotation - 90)* ((float) Math.PI / 180F);
                newZ = parentZ + (Math.sin(theta) * wantedDistance);
                newX = parentX - (Math.cos(theta) * wantedDistance);
            } else if (positiveFlatRotation >= 0 && positiveFlatRotation < 90) {
                double theta = (positiveFlatRotation - 180)* ((float) Math.PI / 180F);
                newZ = parentZ + (Math.cos(theta) * wantedDistance);
                newX = parentX + (Math.sin(theta) * wantedDistance);
            } else {
                double theta = (positiveFlatRotation - 270)* ((float) Math.PI / 180F);
                newZ = parentZ - (Math.sin(theta) * wantedDistance);
                newX = parentX + (Math.cos(theta) * wantedDistance);
            }


            double newDistance = Math.sqrt(parentX-newX * parentX-newX + parentZ-newZ * parentZ-newZ + parentY-newY * parentY-newY);
            //LOGGER.info("NewDistanceCorrect: "+(newDistance<wantedDistance+0.1||newDistance>wantedDistance-0.1));
            //LOGGER.info("posFlatRot: "+positiveFlatRotation);
            //LOGGER.info("absYRot: "+absYDegreeRotation);

            this.moveTo(newX, newY, newZ);

        }
    }
    }

    int yDistanceOrOne(int yDist){
        if (
            Math.abs(yDist)<1 ) return 1;
        else return yDist;
    }
}


