package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

public class JudasSheepBodyEntity extends AbstractFlyingSegmentEntity {

    public static final Logger LOGGER = LogManager.getLogger();
    private static final DataParameter<Integer> HAS_WOOL = EntityDataManager.defineId(CatEntity.class, DataSerializers.INT);

    public JudasSheepBodyEntity(EntityType<? extends AbstractFlyingSegmentEntity> p_i48578_1_, World p_i48578_2_) {
        super(p_i48578_1_, p_i48578_2_);
    }

    public int hasWool(){return this.entityData.get(HAS_WOOL);}

    public boolean hasWoolBool(){return this.entityData.get(HAS_WOOL)==1;}

    public void setHasWool(int i) {
        this.entityData.set(HAS_WOOL, i);
    }

    //Necessary - syncs entity data (data parameters) with the world (i think) crashes without
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HAS_WOOL,1);
    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);
        NBT.putInt("HasWool", this.hasWool());
    }


    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);
        this.entityData.set(HAS_WOOL, (NBT.getInt("HasWool")));
    }

    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        this.setHasWool(1);
        return p_213386_4_;
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack.getItem() == Items.SHEARS) {
            if (!this.level.isClientSide && this.hasWool()==1) {
                this.setHasWool(0);

                this.level.playSound(null, this, SoundEvents.SHEEP_SHEAR, SoundCategory.AMBIENT, 1.0F, 1.0F);

                ItemEntity itementity = this.spawnAtLocation(Blocks.GRAY_WOOL); //Rotten Wool when I make it
                if (itementity != null) {
                    itementity.setDeltaMovement(itementity.getDeltaMovement().add((double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F), (double)(this.random.nextFloat() * 0.05F), (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
                }
                itemstack.hurtAndBreak(1, p_230254_1_, (p_213613_1_) -> {
                    p_213613_1_.broadcastBreakEvent(p_230254_2_);
                });
                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.CONSUME;
            }
        } else {
            return super.mobInteract(p_230254_1_, p_230254_2_);
        }
    }

    @Override
    public void tick() {
        super.tick();

        //LOGGER.info(""+this.isSheared());
    }
}
