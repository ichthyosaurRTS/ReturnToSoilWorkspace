package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.core.config.RTSConfigMisc;
import com.ichthyosaur.returntosoil.core.util.ServerMagicEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = ReturnToSoil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

    @SubscribeEvent
    public static void CultivationDefenseBonus (LivingDamageEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getEntity();
            if (!player.level.isClientSide()) {
                int cLvl = RTSConfigMisc.cListGetLvl(player.getName().getString());
                double dmgMod = 1.0;
                if (cLvl<10000) {}
                else if (cLvl<20000) dmgMod = 1.25;
                else if (cLvl<40000) dmgMod = 1.5;
                else if (cLvl<70000) dmgMod = 1.75;
                else if (cLvl<100000) dmgMod = 2;
                else dmgMod = 2.5;

                event.setAmount( (float) (event.getAmount()/dmgMod));
            }
        }
    }

    @SubscribeEvent
    public static void CultivationOffensePenalty (LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getSource().getEntity();
            if (!player.level.isClientSide()) {
                int cLvl = RTSConfigMisc.cListGetLvl(player.getName().getString());
                double dmgMod = 1.0;
                if (cLvl<10000) {}
                else if (cLvl<20000) dmgMod = 1.25;
                else if (cLvl<40000) dmgMod = 1.5;
                else if (cLvl<70000) dmgMod = 1.75;
                else if (cLvl<100000) dmgMod = 2;
                else dmgMod = 2.5;

                float newAmount = (float) (event.getAmount()/dmgMod);
                //if (newAmount < 1) event.setAmount(1);
                event.setAmount(newAmount);
            }
        }
    }

    //just for proof of concept, doesn't go here.
    @SubscribeEvent
    public static void WorldTick (TickEvent.WorldTickEvent event) {
        if (!event.world.isClientSide()) {
            ServerMagicEffects.tickMagicEffectList((ServerWorld) event.world);
        }
    }

    @SubscribeEvent
    public static void ServerStart (FMLServerAboutToStartEvent event) {

        ServerMagicEffects.createList();
    }

}
