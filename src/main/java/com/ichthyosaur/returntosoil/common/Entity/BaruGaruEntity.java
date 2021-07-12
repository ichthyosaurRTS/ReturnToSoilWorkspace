package com.ichthyosaur.returntosoil.common.Entity;

import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.logging.Logger;

public class BaruGaruEntity extends TameableEntity {

    //Lets use uuids next time rather than removing and respawning the segments every time the world restarts
    public static final double segmentDistance = 0.7D;
    static final int segmentMaxNumber = 10;
    private BaruGaruSegmentEntity[] segmentList = new BaruGaruSegmentEntity[segmentMaxNumber];
    public boolean builtSegments = false; // on tick, will build the body.

    public BaruGaruEntity(EntityType<? extends TameableEntity> p_i48574_1_, World p_i48574_2_) {
        super(p_i48574_1_, p_i48574_2_);
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 48.0D)
                .add(Attributes.ATTACK_KNOCKBACK)
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 20.0D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F);
    }




    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false)); //that float is move speed
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, JawBeetleEntity.class, true));

    }

    public void tick() {
       super.tick();

       //if (this.builtSegments&&this.segmentList[0] == null) this.builtSegments = false;

       if(!this.builtSegments) {
           for (int i = 0; i < segmentMaxNumber; i++) {

               BaruGaruSegmentEntity segment;

               World world = this.getCommandSenderWorld(); //not super sure about this one...

               segment = EntityTypesInit.BARUGARUSEGMENT.get().create(world);

               //if (i == 0) { segment.torsoParent = this; segment.first = true; } //if the 1st segment, make the torso the parent
               if (i > 0) { segment.parent = this.segmentList[i-1]; segment.first = false;}//if another segment, make the previous segment the parent, set first segment to false
               else segment.torsoParent = this;
               segment.mainBody = this;

               segment.tick = true; // only tick after we've added the parent and stuff

               segment.moveTo((double)this.getX() + 0.5D, (double)this.getY(), (double)this.getZ() - 0.5D  , 0.0F, 0.0F);
               world.addFreshEntity(segment);

               this.segmentList[i] = segment;

               Logger.getLogger("Created segment#"+i);
           }
           this.builtSegments = true;
       }
    }

    public void summonSegmentsToHead() {
        for (int i = 0; i < segmentMaxNumber; i++) {
            if (this.segmentList[i] == null) {}
            else {
                BaruGaruSegmentEntity segment = this.segmentList[i];
                segment.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            }
        }
    }


    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}
