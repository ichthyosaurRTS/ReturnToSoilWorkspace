package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Blocks;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.UUID;

//powerful attack, slow and easy to avoid
public class JudasSheepHeadEntity extends MonsterEntity {

    public static final Logger LOGGER = LogManager.getLogger();

    private final double numberOfSegments = 4;
    private final UUID[] subEntitiesUUID = new UUID[(int)numberOfSegments];

    private Entity[] segmentEntities = new Entity[(int)numberOfSegments];

    private int chargeTicks = 0;
    private int idleTicks = 0;
    private Vector3d newIdlePos;

    private double xVector;
    private double yVector;
    private double zVector;

    private double xIdleVector;
    private double yIdleVector;
    private double zIdleVector;


    public JudasSheepHeadEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    public boolean removeWhenFarAway(double p_213397_1_) {
        return false;
    }

    @Override
    public boolean canCollideWith(Entity p_241849_1_) {
        return false;
    }

    @Override
    public void push(Entity p_70108_1_) {
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ATTACK_DAMAGE, 30.0D)
                .add(Attributes.ARMOR, 20D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.5F)
                .add(Attributes.FOLLOW_RANGE, 96.0D);
    }

    protected void registerGoals() {
        //this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.0D, false));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WolfEntity.class, true));
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


    private void tickUp(){this.chargeTicks+=1;}
    private void tickZero(){this.chargeTicks=0;}
    private int getTick(){return this.chargeTicks;}
    private void setTick(int tick){this.chargeTicks=tick;}


    private void tickParts() {

        if (this.segmentEntities[0] == null && this.subEntitiesUUID[0] != null) {
            this.segmentEntities = rollChance.createSegmentList(this.subEntitiesUUID, (ServerWorld) this.getCommandSenderWorld());
        }
        else if (this.subEntitiesUUID[0] == null) {}
        else {
            for (Entity entity : this.segmentEntities) { if (entity != null) entity.tick();
            LOGGER.info("Now ticking: "+entity );}
        }

    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide()&&this.subEntitiesUUID[0]!=null) {
            this.tickParts();
        }

        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.08, 0));

        if (this.getTarget() != null) {
            if (this.getTarget().isAlive()) {



                if (this.getTick() < 10) {
                    Entity entity =  this.getTarget();
                    //this.lookAt(entity,100,100);

                    this.tickUp();
                }

                else if (this.getTick() == 10) {
                    Entity entity =  this.getTarget();
                    Vector3d entityPos = new Vector3d(entity.getX(), entity.getY(), entity.getZ());
                    //this ones instant, so good to have at least once in setting the right direction
                    this.lookAt(EntityAnchorArgument.Type.EYES,entityPos);

                    this.yVector = this.getLookAngle().y/10;
                    this.xVector = this.getLookAngle().x/10;
                    this.zVector = this.getLookAngle().z/10;

                    this.tickUp();
                }

                else if (this.getTick()<60){
                    //if we hit the y level of target slow down
                    if (this.getY() < this.getTarget().getY()+this.getTarget().getEyeHeight() && this.yVector < 0) {
                        this.yVector = 0;
                        this.xVector = this.xVector/3;
                        this.zVector = this.zVector/3;
                    }

                    //CHARGE DAMAGE SECTION
                    if (this.closerThan(this.getTarget(),1.5)) {
                        this.getTarget().setDeltaMovement(this.getTarget().getDeltaMovement().add(this.xVector*500,1,this.zVector*500));
                        this.getTarget().hurt(DamageSource.mobAttack(this),20);
                    }

                    this.lookAt(this.getTarget(),100,100);

                    this.setDeltaMovement(this.getDeltaMovement().add(this.xVector, this.yVector, this.zVector));

                    this.tickUp();
                }

                else if (this.getTick()<110) {

                    this.setDeltaMovement(this.getDeltaMovement().add(this.xVector/10, 0.01, this.zVector/10));

                    Vector3d aboveVector = new Vector3d(this.getX(),this.getY() +100,this.getZ());
                    this.lookAt(EntityAnchorArgument.Type.EYES,aboveVector);

                    this.tickUp();
                }

                else this.tickZero();
            }

        }

        else {
            this.setTick(90);

            //ADDITIONAL TARGET FINDING BECAUSE GOALS BASICALLY ONLY DO EYE HEIGHT
            this.setTarget(this.level.getNearestLoadedEntity(VillagerEntity.class,(new EntityPredicate()).range(96).selector(null),
                    this,this.getX(),this.getY(),this.getZ(), this.getBoundingBox().inflate(96, 96D, 96)));
            this.setTarget(this.level.getNearestLoadedEntity(PlayerEntity.class,(new EntityPredicate()).range(96).selector(null),
                    this,this.getX(),this.getY(),this.getZ(), this.getBoundingBox().inflate(96, 96D, 96)));
            this.setTarget(this.level.getNearestLoadedEntity(WolfEntity.class,(new EntityPredicate()).range(96).selector(null),
                    this,this.getX(),this.getY(),this.getZ(), this.getBoundingBox().inflate(96, 96D, 96)));


            //IDLE MOVEMENT START
            if (this.idleTicks == 0) {
                this.newIdlePos = this.generateAirPos(0);
                this.lookAt(EntityAnchorArgument.Type.EYES,this.newIdlePos);

                this.xIdleVector = this.getLookAngle().x/60; //why is this not changing?
                this.yIdleVector = this.getLookAngle().y/60;
                this.zIdleVector = this.getLookAngle().z/60;
                this.getLookControl().setLookAt(this.newIdlePos);

                this.idleTicks+=1;
            }
            else if (this.idleTicks < 60) {

                this.setDeltaMovement(this.getDeltaMovement().add(this.xIdleVector, this.yIdleVector, this.zIdleVector));
                this.getLookControl().setLookAt(this.newIdlePos);
                this.idleTicks+=1;
            }

            //no y movement during idle!
            else if (this.idleTicks < 200) {
                this.setDeltaMovement(this.getDeltaMovement().x,0,this.getDeltaMovement().z);
                this.idleTicks+=1;
            }

            else this.idleTicks = 0;
            //IDLE MOVEMENT END

        }

    }

    private Vector3d generateAirPos (int numberOfTries) {

        if (numberOfTries == 3) return this.position();

        Vector3d newPos = new Vector3d(
                this.getX() + (rollChance.returnRoll(31)-16),
                this.getY() + (rollChance.returnRoll(9)-7),
                this.getZ() + (rollChance.returnRoll(31)-16));
        BlockPos blockPos = new BlockPos(newPos);

        if (this.level.getBlockState(blockPos).getBlock() == Blocks.AIR || this.level.getBlockState(blockPos).getBlock() == Blocks.WATER) return newPos;
        else return generateAirPos(numberOfTries + 1);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }


    @Override
    public boolean isInvulnerableTo(DamageSource damage) {
        return  damage == DamageSource.FALL || damage == DamageSource.IN_WALL ||damage == DamageSource.CRAMMING || super.isInvulnerableTo(damage);
    }

    private void createSegments(Entity leader, int segmentNumber){
        AbstractFlyingSegmentEntity segment;
        World world = this.getCommandSenderWorld();

        if (segmentNumber == 0) {
            segment = EntityTypesInit.JUDASSHEEPBODY.get().create(world);
            segment.setSpacing(0.9);
        }

        else if (segmentNumber == 1) {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1.8);
            ((GeneralFlyingSegmentEntity) segment).setModelString("JudasSheepRibs");
        }

        else if (segmentNumber == 2) {
            segment = EntityTypesInit.JUDASSHEEPBODY.get().create(world);
            segment.setSpacing(2);
        }

        else {
            segment = EntityTypesInit.GENERALFLYINGSEGMENT.get().create(world);
            segment.setSpacing(1.3);
            ((GeneralFlyingSegmentEntity) segment).setModelString("JudasSheepButt");
        }

        segment.setLeader(leader);
        segment.moveTo((double)this.getX() + 0.5D, (double)this.getY(), (double)this.getZ() - 0.5D  , 0.0F, 0.0F);
        world.addFreshEntity(segment);

        this.subEntitiesUUID[segmentNumber] = segment.getUUID();

        if (segmentNumber<this.numberOfSegments-1) createSegments(segment,segmentNumber+1);
    }
}
