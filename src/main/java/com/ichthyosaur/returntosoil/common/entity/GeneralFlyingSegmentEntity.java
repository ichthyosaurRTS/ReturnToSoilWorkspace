package com.ichthyosaur.returntosoil.common.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//For small hit-boxes, using layers to reduce entity ids
public class GeneralFlyingSegmentEntity extends AbstractFlyingSegmentEntity {

    public static final Logger LOGGER = LogManager.getLogger();

    private boolean hasRefreshed = false;
    private static final DataParameter<String> ENTITY_MODEL = EntityDataManager.defineId(GeneralFlyingSegmentEntity.class, DataSerializers.STRING);

    public GeneralFlyingSegmentEntity(EntityType<? extends AbstractFlyingSegmentEntity> p_i48578_1_, World p_i48578_2_) {
        super(p_i48578_1_, p_i48578_2_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(ENTITY_MODEL,"empty");
    }

    public void setModelString(String modelString) {this.entityData.set(ENTITY_MODEL, modelString);}

    @Override
    public EntitySize getDimensions(Pose p_213305_1_) {
        if (this.entityData.get(ENTITY_MODEL).contains("GawanTail")) return new EntitySize(0.3F,0.3F,false);
        else if (this.entityData.get(ENTITY_MODEL).contains("Gawan")) return new EntitySize(0.8F,0.8F,false);


        else return super.getDimensions(p_213305_1_);
    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);

        NBT.putString("EntityModel", this.getModelString());
    }

    @Override
    public boolean isSilent() {
        return true;
    }

    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);

        this.entityData.set(ENTITY_MODEL, (NBT.getString("EntityModel")));
    }

    @Override
    protected ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        if (this.getLeader() instanceof GeneralFlyingSegmentEntity) return ((GeneralFlyingSegmentEntity)this.getLeader()).mobInteract(p_230254_1_, p_230254_2_);
        else if (this.getLeader() instanceof AbstractContractEntity) return ((AbstractContractEntity)this.getLeader()).mobInteract(p_230254_1_, p_230254_2_);
        else return super.mobInteract(p_230254_1_, p_230254_2_);
    }

    public String getModelString(){return this.entityData.get(ENTITY_MODEL);}

    @Override
    public boolean shouldRenderAtSqrDistance(double p_70112_1_) {
        return p_70112_1_<4000;
    }

    @Override
    public void tick() {
        super.tick();

        if (!hasRefreshed) {
        this.refreshDimensions();
        this.hasRefreshed = true;
        }
        //LOGGER.info(""+this.EntitySize);
    }
}
