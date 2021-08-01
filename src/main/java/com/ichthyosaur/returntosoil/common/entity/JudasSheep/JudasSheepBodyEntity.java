package com.ichthyosaur.returntosoil.common.entity.JudasSheep;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;

public class JudasSheepBodyEntity extends AbstractFlyingSegmentEntity {

    public JudasSheepBodyEntity(EntityType<? extends MobEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
    }

    @Override
    public void tick() {
        super.tick();
        //this.setDeltaMovement(this.getDeltaMovement().add(0, -0.002, 0));
    }
}
