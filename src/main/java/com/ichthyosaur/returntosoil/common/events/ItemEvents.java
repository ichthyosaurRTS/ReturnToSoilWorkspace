package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.common.item.wearable.BeetleBackpack;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeChest;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeHelm;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeLegs;
import com.ichthyosaur.returntosoil.core.config.RTSConfigMisc;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RTSMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemEvents {
 

    @SubscribeEvent
    public static void ChestItem (TickEvent.PlayerTickEvent event) {

        PlayerEntity player = event.player;
        ItemStack chest = player.getItemBySlot(EquipmentSlotType.CHEST);

        if (chest.getItem() instanceof BeetleBackpack) {

            int foodLevel = player.getFoodData().getFoodLevel();
            if (foodLevel < 11) {
                player.getFoodData().setFoodLevel(foodLevel + 10);
                chest.setDamageValue(chest.getDamageValue()+10);
                player.eat(player.level, new ItemStack(Items.COOKIE));
            }
        }
    }

    @SubscribeEvent
    public static void PlayerDamage (LivingDamageEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getEntity();
            ItemStack chest = player.getItemBySlot(EquipmentSlotType.CHEST);
            if (!player.level.isClientSide()) {
                if (chest.getItem() instanceof CentipedeChest) {
                    if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof CentipedeHelm &&
                            player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof CentipedeLegs)
                        if (event.getAmount()>10) event.setAmount(10);

                    else if (event.getAmount()>19) event.setAmount(19);
                }

            }
        }
    }

    @SubscribeEvent
    public static void invItemTick (TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ServerWorld world;

        if (!player.level.isClientSide())  world = (ServerWorld) player.level;
            for(int i = 0; i < 36; i++) {
                Item item = player.inventory.getItem(i).getItem();

                if (item == BlockItemInit.HEAVY_PLANT_SEED.get() || item == BlockItemInit.HEAVY_PLANT_POTTED_ITEM.get()
                        || item == BlockItemInit.HEAVY_FRUIT_ITEM.get()) {heavyVector(player);}

            }
    }

    private static void heavyVector(PlayerEntity player){
        float yVector;
        if ((player.getDeltaMovement().y) < 0) yVector = (float) (player.getDeltaMovement().y*1.5);
        else yVector = (float)-0.1;
        if ((player.getDeltaMovement().y) < -5) {}
        else player.setDeltaMovement(player.getDeltaMovement().x/2,player.getDeltaMovement().y+yVector,player.getDeltaMovement().z/2);
    }


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

}






