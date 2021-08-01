package com.ichthyosaur.returntosoil.common.entity.JudasSheep;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;

public class JudasSheepButtEntity extends AbstractFlyingSegmentEntity {


    public JudasSheepButtEntity(EntityType<? extends AbstractFlyingSegmentEntity> p_i48578_1_, World p_i48578_2_) {
        super(p_i48578_1_, p_i48578_2_);
    }

    @Override
    public void tick() {
        super.tick();
        //this.setDeltaMovement(this.getDeltaMovement().add(0, -0.002, 0));
    }
}
