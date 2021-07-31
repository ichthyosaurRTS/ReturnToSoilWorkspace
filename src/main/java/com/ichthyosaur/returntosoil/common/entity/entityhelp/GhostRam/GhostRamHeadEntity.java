package com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.List;

//powerful attack, slow and easy to avoid
public class GhostRamHeadEntity extends MonsterEntity {

    public static final Logger LOGGER = LogManager.getLogger();

    boolean hasSegments = false;
    private final double numberOfSegments = 8;

    private int chargeTicks = 0;

    private double xVector;
    private double yVector;
    private double zVector;

    private double spiralX;
    private double spiralZ;

    public GhostRamHeadEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 20D)
                .add(Attributes.MOVEMENT_SPEED, (double)0F)
                .add(Attributes.FOLLOW_RANGE, 96.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.0D, false));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
    }

    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        //createSegments(this,0);
        return p_213386_4_;
    }

    private void tickUp(){this.chargeTicks+=1;}
    private void tickZero(){this.chargeTicks=0;}
    private int getTick(){return this.chargeTicks;}
    private void setTick(int tick){this.chargeTicks=tick;}

    @Override
    public void tick() {
        super.tick();
        if (!hasSegments) {
            this.createSegments(this, (int)0);
            this.hasSegments = true;
        }

        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0));

        if (this.getTarget() != null && this.getTick() < 10) {
            Entity entity =  this.getTarget();
            this.lookAt(entity,100,100);

            this.tickUp();
        }

        else if (this.getTarget() != null && this.getTick() == 10) {
            Entity entity =  this.getTarget();
            this.lookAt(entity,100,100);

            this.yVector = this.getLookAngle().y/10;
            this.xVector = this.getLookAngle().x/10;
            this.zVector = this.getLookAngle().z/10;

            this.tickUp();
        }


        else if (this.getTarget() != null && this.getTick()<90){

            //if we hit the y level of target bounce back
            if (this.getY()<this.getTarget().getY() && this.yVector < 0) {
                this.yVector = -this.yVector/6;
                this.xVector = -this.xVector/6;
                this.zVector = -this.zVector/6;
            }

            this.setDeltaMovement(this.getDeltaMovement().add(this.xVector, this.yVector, this.zVector));
            this.tickUp();
        }


        else if (this.getTarget() != null && this.getTick()<130) {

            if(this.spiralX >= 3.14) this.spiralX = 0;
            else this.spiralX += 0.5;

            double flatMod = Math.sin(spiralX);

            this.setDeltaMovement(this.getDeltaMovement().add(flatMod/100, 0.01, flatMod/100));

            Vector3d aboveVector = new Vector3d(this.getX(),this.getY() +100,this.getZ());
            this.lookAt(EntityAnchorArgument.Type.EYES,aboveVector);

            this.tickUp();
        }


        else if (this.getTarget() != null && this.getTick()>=130) this.tickZero();


        else this.setTick(91);


        LOGGER.info("x move vector : "+this.xVector);
        //LOGGER.info("charge ticks: "+this.getTick());
        //LOGGER.info("target: "+ this.getTarget());

    }

    public double getMovement (double distance) {
        if (distance >= 0) return 0.05;
        else return -0.05;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL ||damage == DamageSource.CRAMMING || super.isInvulnerableTo(damage);
    }

    private void createSegments(Entity leader, int segmentNumber){
        AbstractFlyingSegmentEntity segment;
        World world = this.getCommandSenderWorld();

        if (segmentNumber == 0) {
            segment = EntityTypesInit.GHOSTRAMBODY.get().create(world);
            segment.setSpacing(0.8);
        }

        else if (segmentNumber<this.numberOfSegments) {
            segment = EntityTypesInit.GHOSTRAMBODY.get().create(world);
            segment.setSpacing(1);
        }

        else {
            segment = EntityTypesInit.GHOSTRAMBUTT.get().create(world);
            segment.setSpacing(1);
        }

        segment.setLeader(leader);
        segment.moveTo((double)this.getX() + 0.5D, (double)this.getY(), (double)this.getZ() - 0.5D  , 0.0F, 0.0F);
        world.addFreshEntity(segment);

        if (segmentNumber<this.numberOfSegments) createSegments(segment,segmentNumber+1);
    }
}
