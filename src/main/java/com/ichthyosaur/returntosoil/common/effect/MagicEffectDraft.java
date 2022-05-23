package com.ichthyosaur.returntosoil.common.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;


public class MagicEffectDraft extends Effect {

    public MagicEffectDraft(EffectType p_i50391_1_, int p_i50391_2_) {
        super(p_i50391_1_, p_i50391_2_);
    }

    @Override
    public boolean isDurationEffectTick(int p_76397_1_, int p_76397_2_) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity p_76394_1_, int p_76394_2_) {
        p_76394_1_.lerpMotion(1,1,1);
        super.applyEffectTick(p_76394_1_, p_76394_2_);
    }


}

