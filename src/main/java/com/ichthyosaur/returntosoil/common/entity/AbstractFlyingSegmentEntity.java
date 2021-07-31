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
        this.setDeltaMovement(this.getDeltaMovement().add(0, 0, 0)); //offset gravity


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



        /*

            double sqrFlatDistance = Math.sqrt(xDistance * xDistance + zDistance * zDistance);

        //  gets angle in radians, converts to degrees
        double wantedDistance = this.segmentSpaceFromLeader; //hypotenuse for us
        double flatDegreeRotation = MathHelper.atan2(xDistance, zDistance) * (180F / (float) Math.PI);//
        double yDegreeRotation = - MathHelper.atan2(yDistance, sqrFlatDistance) * (180F / (float) Math.PI); //apparently from -90 to 90... wtf
            //if (yDistance<0) yDegreeRotation = -90 - yDegreeRotation;
            //else yDegreeRotation = 90 - yDegreeRotation;
            //sqr flat is always positive....

            if (yDegreeRotation<0) {
                if (this.getLeader().getDeltaMovement().y > 0) {yDegreeRotation+=10;} //moving up, looking down
                else {yDegreeRotation-=10;}
            }
            else {
                if (this.getLeader().getDeltaMovement().y > 0) {yDegreeRotation-=10;} //moving up, looking up
                else {yDegreeRotation+=10;}
            }

            LOGGER.info("yDegreeRot = " + yDegreeRotation);

        LOGGER.info(""+yDegreeRotation);

        //  the up down rot here gets sent to the model anim, we need the 2nd float here and the setupAnim code to work. Also, miracle.
        //  the entire segment model must be a child of fake head, or acting head.
            //this.lookAt(this.getLeader(),100,100);
            //this.getLookControl().setLookAt(parentX, parentY, parentZ);
            //this.setRot(((float) ((MathHelper.wrapDegrees(360-flatDegreeRotation)))),(float)(MathHelper.wrapDegrees( yDegreeRotation)));
            //this works dont touch unless you mess with ydegreerot as well

            double sqrDistance = Math.sqrt(xDistance * xDistance + zDistance * zDistance + yDistance * yDistance);

        // not accounting for 0,90,180,270 exact, using the 4 segment method sqrDistance > wantedDistance + 0.01 || sqrDistance < wantedDistance - 0.01 if (sqrDistance != wantedDistance)
        if (sqrDistance > wantedDistance+1) {
            double newZ;
            double newX;
            double newY;

            //they needs to be in radians to use idiot

            double vertDistance;
            double absYDegreeRotation= Math.abs(yDegreeRotation);
            double yRadianRotation = yDegreeRotation * ((float) Math.PI / 180F); //changed this now produces neg

            vertDistance = Math.cos(yRadianRotation) * wantedDistance; // just changed this now   AHH IS IT COS OR SIN
            double flatWantedDistance = Math.sin(yRadianRotation) * wantedDistance; //changed this and vert


            //can he not move closer & thus down because of x and z ?
            //look at vectors and manipulate the ydegree rotation a little base on that?

            if (yDegreeRotation>=0) {
                newY = parentY+vertDistance;
            }
            else {
                newY = parentY+vertDistance;
            }




            //also needs to move based on look at
            double positiveFlatRotation = flatDegreeRotation;

            double absYDistance = Math.abs(yDistance);

           //lets try calculating x and y first i guess?
            //well when z pushes towards z it pushes the whole entity too so i shouldnt be surprised...?
            //may need to consider y in a completely different light...



            //wanted distance should be flatwanteddistance for 3d movement
            if (positiveFlatRotation < -90) {
                double theta = positiveFlatRotation * ((float) Math.PI / 180F);  //here we take away however many 90 degree factors we need
                newZ = parentZ - (Math.cos(theta) * flatWantedDistance);
                newX = parentX - (Math.sin(theta) * flatWantedDistance); //minus bc in this case, the parent is above/greater than
            } else if (positiveFlatRotation >= -90 && positiveFlatRotation < 0) {
                double theta = (positiveFlatRotation - 90)* ((float) Math.PI / 180F);
                newZ = parentZ + (Math.sin(theta) * flatWantedDistance);
                newX = parentX - (Math.cos(theta) * flatWantedDistance);
            } else if (positiveFlatRotation >= 0 && positiveFlatRotation < 90) {
                double theta = (positiveFlatRotation - 180)* ((float) Math.PI / 180F);
                newZ = parentZ + (Math.cos(theta) * flatWantedDistance);
                newX = parentX + (Math.sin(theta) * flatWantedDistance);
            } else {
                double theta = (positiveFlatRotation - 270)* ((float) Math.PI / 180F);
                newZ = parentZ - (Math.sin(theta) * flatWantedDistance);
                newX = parentX + (Math.cos(theta) * flatWantedDistance);
            }


            double newDistance = Math.sqrt((parentX-newX) * (parentX-newX) + (parentZ-newZ) * (parentZ-newZ) + (parentY-newY) * (parentY-newY));
            LOGGER.info("NewDistanceCorrect: "+(newDistance<wantedDistance+0.1||newDistance>wantedDistance-0.1));
            //LOGGER.info("NewDist: "+newDistance + "   WantedDist: "+wantedDistance);
            //LOGGER.info("posFlatRot: "+positiveFlatRotation);
            //LOGGER.info("absYRot: "+absYDegreeRotation);

            this.moveTo(newX, newY, newZ);

        } */
    }
    }

    int yDistanceOrOne(int yDist){
        if (
            Math.abs(yDist)<1 ) return 1;
        else return yDist;
    }
}


