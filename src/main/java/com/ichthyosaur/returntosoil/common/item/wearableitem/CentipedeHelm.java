package com.ichthyosaur.returntosoil.common.item.wearableitem;

import com.ichthyosaur.returntosoil.client.wearable.model.CentipedeHelmModel;
import com.ichthyosaur.returntosoil.common.item.itemclass.RTSWearableItem;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

//double damage to jaw beetles
public class CentipedeHelm extends RTSWearableItem {


    public CentipedeHelm(IArmorMaterial p_i48534_1_, EquipmentSlotType p_i48534_2_, Properties p_i48534_3_, TextFormatting colour) {
        super(p_i48534_1_, p_i48534_2_, p_i48534_3_, colour);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "returntosoil:textures/wearableitem/centipede_armor.png";
    }


    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) CentipedeHelmModel.INSTANCE;
    }

}
