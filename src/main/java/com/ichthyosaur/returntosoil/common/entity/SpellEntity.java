package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.particle.LightBallParticle;
import com.ichthyosaur.returntosoil.core.init.ParticleTypesInit;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpellEntity extends AbstractSpellEntity{

    LightBallParticle lb;

    private static final DataParameter<Integer> ANIMATION_TICK = EntityDataManager.defineId(SpellEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> Y_ROT = EntityDataManager.defineId(SpellEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> X_ROT = EntityDataManager.defineId(SpellEntity.class, DataSerializers.INT);

    public SpellEntity(EntityType<? extends AbstractSpellEntity> p_i48546_1_, World p_i48546_2_) {
        super(p_i48546_1_, p_i48546_2_);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ANIMATION_TICK,0);
        this.entityData.define(Y_ROT,0);
        this.entityData.define(X_ROT,0);
    }

    public int getAnimTick(){return this.entityData.get(ANIMATION_TICK);}
    public int getYRot(){return this.entityData.get(Y_ROT);}
    public void setYRot(int num){this.entityData.set(Y_ROT, num);}
    public int getXRot(){return this.entityData.get(X_ROT);}
    public void setXRot(int num){this.entityData.set(X_ROT, num);}

    @Override
    public void tick() {
        int animTick = this.entityData.get(ANIMATION_TICK);
        int animNextTick;
        if (animTick > 1000) animNextTick = 0;
        else animNextTick = animTick + 1;
        this.entityData.set(ANIMATION_TICK, animNextTick);

        if (this.tickCount>200) this.remove(false);


        /*if (this.level.isClientSide() && this.firstTick) {
            this.level.addParticle(ParticleTypesInit.LIGHT_BALL_PARTICLE.get(),
                    this.getX(), this.getY()+0.4, this.getZ(), this.getDeltaMovement().x(), this.getDeltaMovement().y(), this.getDeltaMovement().z());
        }*/
        //if (this.level.isClientSide()) this.lb.setPos(this.getX(), this.getY()+0.2, this.getZ());

        if (this.level.isClientSide() && this.getAnimTick()%5==0)
        this.level.addParticle(ParticleTypesInit.LIGHT_BALL_PARTICLE.get(),
                this.getX(), this.getY()+0.2, this.getZ(), this.getDeltaMovement().x(), this.getDeltaMovement().y(), this.getDeltaMovement().z());
        /*if (this.level.isClientSide() && this.getAnimTick()%10==0)
            this.level.addParticle(ParticleTypesInit.LIGHT_BALL_PARTICLE.get(),
                    this.getX(), this.getY()+0.4, this.getZ(),0,0,0);*/

        super.tick();

    }



    @Override
    protected float getInertia() {
        return 1.0F;
    }

    protected IParticleData getTrailParticle() {
        return ParticleTypesInit.GONE_PARTICLE.get();
    }
}




