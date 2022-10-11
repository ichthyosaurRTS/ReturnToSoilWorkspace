package com.ichthyosaur.returntosoil.common.event;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.item.wearable.BeetleBackpack;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeChest;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeHelm;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeLegs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ReturnToSoil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemEvents {


    @SubscribeEvent
    public static void ChestItem(TickEvent.PlayerTickEvent event) {

        PlayerEntity player = event.player;
        ItemStack chest = player.getItemBySlot(EquipmentSlotType.CHEST);

        if (chest.getItem() instanceof BeetleBackpack) {

            int foodLevel = player.getFoodData().getFoodLevel();
            if (foodLevel < 11) {
                player.getFoodData().setFoodLevel(foodLevel + 10);
                chest.setDamageValue(chest.getDamageValue() + 10);
                player.eat(player.level, new ItemStack(Items.COOKIE));
            }
        }

    }

    @SubscribeEvent
    public static void PlayerDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            ItemStack chest = player.getItemBySlot(EquipmentSlotType.CHEST);
            if (!player.level.isClientSide()) {
                if (chest.getItem() instanceof CentipedeChest) {
                    if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof CentipedeHelm &&
                            player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof CentipedeLegs)
                        if (event.getAmount() > 10) event.setAmount(10);

                        else if (event.getAmount() > 19) event.setAmount(19);
                }

            }
        }
    }

}






