package com.ichthyosaur.returntosoil.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpellEntity extends AbstractSpellEntity{

    private static final DataParameter<Integer> ANIMATION_TICK = EntityDataManager.defineId(SpellEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> X_ROT = EntityDataManager.defineId(SpellEntity.class, DataSerializers.INT);

    public SpellEntity(EntityType<? extends AbstractSpellEntity> p_i48546_1_, World p_i48546_2_) {
        super(p_i48546_1_, p_i48546_2_);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ANIMATION_TICK,0);
        this.entityData.define(X_ROT,0);
    }

    public int getAnimTick(){return this.entityData.get(ANIMATION_TICK);}
    public int getXRot(){return this.entityData.get(X_ROT);}

    @Override
    public void tick() {
        int animTick = this.entityData.get(ANIMATION_TICK);
        int animNextTick;
        if (animTick > 1000) animNextTick = 0;
        else animNextTick = animTick + 1;
        this.entityData.set(ANIMATION_TICK, animNextTick);

        this.entityData.set(X_ROT, (int)this.xRot);

        super.tick();


    }

}




