package com.ichthyosaur.returntosoil.common.entity;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;


//For small hit-boxes, using layers to reduce entity ids
public class GeneralFlyingSegmentEntity extends AbstractFlyingSegmentEntity{

    private static final DataParameter<String> ENTITY_MODEL = EntityDataManager.defineId(GeneralFlyingSegmentEntity.class, DataSerializers.STRING);

    public GeneralFlyingSegmentEntity(EntityType<? extends FlyingEntity> p_i48578_1_, World p_i48578_2_) {
        super(p_i48578_1_, p_i48578_2_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ENTITY_MODEL,"empty");
    }


    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);
        NBT.putString("EntityModel", this.getModelString());
    }

    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);
        this.entityData.set(ENTITY_MODEL, (NBT.getString("EntityModel")));
    }

    public String getModelString(){return this.entityData.get(ENTITY_MODEL);}
}
