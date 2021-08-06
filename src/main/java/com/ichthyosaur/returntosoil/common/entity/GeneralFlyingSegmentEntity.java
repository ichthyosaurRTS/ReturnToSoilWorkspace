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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//For small hit-boxes, using layers to reduce entity ids
public class GeneralFlyingSegmentEntity extends AbstractFlyingSegmentEntity {

    public static final Logger LOGGER = LogManager.getLogger();

    private static final DataParameter<String> ENTITY_MODEL = EntityDataManager.defineId(GeneralFlyingSegmentEntity.class, DataSerializers.STRING);
    private float EntitySize = 0; //if zero then don't change the size

    public GeneralFlyingSegmentEntity(EntityType<? extends AbstractFlyingSegmentEntity> p_i48578_1_, World p_i48578_2_) {
        super(p_i48578_1_, p_i48578_2_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(ENTITY_MODEL,"empty");
    }

    public void setModelString(String modelString) {this.entityData.set(ENTITY_MODEL, modelString);}
    public void setSize(float size) {this.EntitySize = size;}

    @Override
    public EntitySize getDimensions(Pose p_213305_1_) {
        if (this.EntitySize != 0) {
            return new EntitySize(this.EntitySize,this.EntitySize,false);
        }
        //temporary since above not working
        if (this.entityData.get(ENTITY_MODEL).equals("JudasSheepRibs")) return new EntitySize(2,2,false);

        else return super.getDimensions(p_213305_1_);
    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);

        NBT.putString("EntityModel", this.getModelString());
        if (this.EntitySize!=0) NBT.putFloat("EntitySize", this.EntitySize);
    }

    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);

        this.entityData.set(ENTITY_MODEL, (NBT.getString("EntityModel")));
        if (NBT.contains("EntitySize")) this.EntitySize = NBT.getFloat("EntitySize");
    }

    public String getModelString(){return this.entityData.get(ENTITY_MODEL);}

    @Override
    public void tick() {
        super.tick();
        this.refreshDimensions();
        //LOGGER.info(""+this.EntitySize);
    }
}
