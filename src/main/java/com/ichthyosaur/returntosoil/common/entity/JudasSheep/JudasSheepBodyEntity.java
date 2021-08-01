package com.ichthyosaur.returntosoil.common.entity.JudasSheep;

import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JudasSheepBodyEntity extends AbstractFlyingSegmentEntity {

    public static final Logger LOGGER = LogManager.getLogger();
    private boolean hasWool = true;

    public JudasSheepBodyEntity(EntityType<? extends AbstractFlyingSegmentEntity> p_i48578_1_, World p_i48578_2_) {
        super(p_i48578_1_, p_i48578_2_);
    }

    public boolean hasWool(){return this.hasWool;} //need to do the nbts

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack.getItem() == Items.SHEARS) {
            if (!this.level.isClientSide && this.hasWool()) {
                this.hasWool = false;

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
