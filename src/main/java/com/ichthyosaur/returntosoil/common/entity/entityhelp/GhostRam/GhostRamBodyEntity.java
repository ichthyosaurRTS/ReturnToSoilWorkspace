package com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import net.minecraft.client.renderer.entity.layers.SheepWoolLayer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;

public class GhostRamBodyEntity extends AbstractFlyingSegmentEntity {

    public GhostRamBodyEntity(EntityType<? extends MobEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
    }

    @Override
    public void tick() {
        super.tick();
        //this.setDeltaMovement(this.getDeltaMovement().add(0, -0.002, 0));
    }
}
