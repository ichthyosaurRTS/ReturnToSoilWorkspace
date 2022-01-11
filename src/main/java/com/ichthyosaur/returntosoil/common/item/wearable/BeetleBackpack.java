package com.ichthyosaur.returntosoil.common.item.wearable;

import com.ichthyosaur.returntosoil.client.wearable.model.BeetleBackpackModel;
import com.ichthyosaur.returntosoil.common.item.abst.RTSDescWBItem;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

//nibble from your roasted beetle while you farm!

public class BeetleBackpack extends RTSDescWBItem {


    public BeetleBackpack(IArmorMaterial p_i48534_1_, EquipmentSlotType p_i48534_2_, Properties p_i48534_3_, TextFormatting colour) {
        super(p_i48534_1_, p_i48534_2_, p_i48534_3_, colour);
    }

    //or up here
    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "returntosoil:textures/wearable/beetle_backpack.png";
    }


    //could probably check entity here to see what cultivation level they are-> change backpack colour or model base on that
    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) BeetleBackpackModel.INSTANCE;
    }

}
