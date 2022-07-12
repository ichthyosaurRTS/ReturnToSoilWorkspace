package com.ichthyosaur.returntosoil.common.item.wearable;

import com.ichthyosaur.returntosoil.client.wearable.model.CentipedeChestModel;
import com.ichthyosaur.returntosoil.client.wearable.model.CentipedeHelmModel;
import com.ichthyosaur.returntosoil.common.item.abst.RTSDescWBItem;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

//Limits damage to 19
public class CentipedeChest extends RTSDescWBItem {


    public CentipedeChest(IArmorMaterial p_i48534_1_, EquipmentSlotType p_i48534_2_, Properties p_i48534_3_, TextFormatting colour) {
        super(p_i48534_1_, p_i48534_2_, p_i48534_3_, colour);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        //just testing
        //player.lerpMotion(1,1,1);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "returntosoil:textures/wearable/centipede_armor.png";
    }


    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) CentipedeChestModel.INSTANCE;
    }
}


