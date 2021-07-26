package com.ichthyosaur.returntosoil.common.entity;


import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


public class BaruGaruSegmentEntity extends CreatureEntity {

    //  careful, only one will have torsoParent not null, rest will have parent not null
    public BaruGaruSegmentEntity parent;
    public BaruGaruEntity torsoParent;
    public BaruGaruEntity mainBody;
    public boolean first = true;
    public boolean tick = false;
    boolean noPhysics = true;

    //has main body as parent by default to avoid null point (since we create the segment then assign the parent, in that space theres a nullpointer)
    public BaruGaruSegmentEntity(EntityType<? extends CreatureEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
        this.torsoParent = this.mainBody;
    }



    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.ARMOR, 10D);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.IN_WALL ||damage == DamageSource.FALL || super.isInvulnerableTo(damage);
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
    }

    public boolean isSilent() {return true;}

    //  here is where we want to set distance and rotation control... right?
    public void tick() {
        super.tick();

        if (this.mainBody == null) this.kill();// this works fine
        else if (!this.mainBody.isAlive()) this.kill();

        if (this.tick) {

            double xDistance;
            double zDistance;
            double yDistance;

            double xPos = this.getX();
            double zPos = this.getZ();
            double yPos = this.getY();

            double parentZ;
            double parentX;
            double parentY;

            //ie z2-z1, x2 - x1 ; this is to get the theta rotation
            if (this.first) {
                parentZ = this.torsoParent.getZ();
                parentX = this.torsoParent.getX();
                parentY = this.torsoParent.getY();
                if (!this.mainBody.isAlive()) this.kill();
            } else {
                parentZ = this.parent.getZ();
                parentX = this.parent.getX();
                parentY = this.parent.getY();
                if (!this.parent.isAlive()) this.kill();
            }
            zDistance = parentZ - zPos;
            xDistance = parentX - xPos;
            yDistance = parentY - yPos;


            // gimme the crows flight distance to mum (ignoring the y dimension)
            //double segmentSpace = Math.sqrt(xDistance*xDistance+zDistance*zDistance);
            double segmentSpace = Math.sqrt(xDistance*xDistance+zDistance*zDistance+yDistance*yDistance);


            //  gets angle in radians, converts to degrees
            double wantedSpace = BaruGaruEntity.segmentDistance; //hypotenuse for us
            double radianRotation = MathHelper.atan2(xDistance, zDistance); // having this backwards makes them spaz out
            double degreeRotation = radianRotation * (180F / (float)Math.PI);//

            double yRadianRotation = MathHelper.atan2(yDistance,wantedSpace);
            double yDegreeRotation = yRadianRotation * (180F / (float)Math.PI);//this is probably backwards

            //  the up down rot here gets sent to the model anim, we need the 2nd float here and the setupAnim code to work. Also, miracle.
            //  the entire segment model must be a child of fake head, or acting head.
            this.setRot(((float) ((MathHelper.wrapDegrees(360-degreeRotation)))),(float)(MathHelper.wrapDegrees(360-yDegreeRotation)));
            this.getLookControl().setLookAt(parentX, parentY, parentZ); // w/o this, when not moving, will look away and then body will follow
            
            // not accounting for 0,90,180,270 exact, using the 4 segment method segmentSpace > wantedSpace + 0.01 || segmentSpace < wantedSpace - 0.01
            if (segmentSpace != wantedSpace) {
                double newZ;
                double newX;
                double newY;
                if (degreeRotation < 90) {
                    double theta = degreeRotation * ((float) Math.PI / 180F);  //here we take away however many 90 degree factors we need
                    newZ = parentZ - (Math.cos(theta) * wantedSpace);
                    newX = parentX - (Math.sin(theta) * wantedSpace); //minus bc in this case, the parent is above/greater than
                } else if (degreeRotation > 90 && degreeRotation < 180) {
                    double theta = (degreeRotation - 90) * ((float) Math.PI / 180F);
                    newZ = parentZ + (Math.sin(theta) * wantedSpace);
                    newX = parentX - (Math.cos(theta) * wantedSpace);
                } else if (degreeRotation > 180 && degreeRotation < 270) {
                    double theta = (degreeRotation - 180) * ((float) Math.PI / 180F);
                    newZ = parentZ + (Math.cos(theta) * wantedSpace);
                    newX = parentX + (Math.sin(theta) * wantedSpace);
                } else {
                    double theta = (degreeRotation - 270) * ((float) Math.PI / 180F);
                    newZ = parentZ - (Math.sin(theta) * wantedSpace);
                    newX = parentX + (Math.cos(theta) * wantedSpace);
                }

                //newY = yPos;
                if (yDistance > 1.3) {yPos=parentY-0.3;}  // if the pieces fall too far away they bring them back up/down
                else if (yDistance < -1.3) {yPos=parentY+0.3;}

                this.getNavigation().moveTo(newX, parentY, newZ,0.2); // that float seems to be the vector force, otherwise this controls jumping
                this.moveTo(newX, yPos, newZ);


                // this is to prevent the strange hanging
                BlockPos pos = new BlockPos(xPos,yPos,zPos);
                BlockPos oneBelow = pos.below();
                if (this.level.getBlockState(pos.below()).getBlock()== Blocks.AIR)
                    if (this.level.getBlockState(oneBelow.below()).getBlock()== Blocks.AIR &&
                        this.level.getBlockState(pos).getBlock()== Blocks.AIR && this.level.getBlockState(pos.east()).getBlock()== Blocks.AIR &&
                        this.level.getBlockState(pos.west()).getBlock()== Blocks.AIR && this.level.getBlockState(pos.south()).getBlock()== Blocks.AIR &&
                        this.level.getBlockState(pos.north()).getBlock()== Blocks.AIR && this.level.getBlockState(oneBelow.east()).getBlock()== Blocks.AIR &&
                        this.level.getBlockState(oneBelow.west()).getBlock()== Blocks.AIR && this.level.getBlockState(oneBelow.south()).getBlock()== Blocks.AIR &&
                        this.level.getBlockState(oneBelow.north()).getBlock()== Blocks.AIR)
                    this.mainBody.summonSegmentsToHead();
                if (Math.abs(yDistance) > 7) this.mainBody.summonSegmentsToHead();
            }
            }
            }
        }



