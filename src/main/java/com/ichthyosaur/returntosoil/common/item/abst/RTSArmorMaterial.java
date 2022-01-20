package com.ichthyosaur.returntosoil.common.item.abst;

import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum RTSArmorMaterial implements IArmorMaterial {

    //0 durability mod will last forever
    //infinite dur on the helm?? since its used as a tribute too...
    //1 name, 2 durability mod, 3 protection for each slot, 4 enchantment-ability, 5 equip sound, 6 toughness, 7 knock-back res, repair ingredient
    CENTIPEDE("centipede", 60, new int[]{0, 6, 7, 0}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 4.0F, () -> {
        return Ingredient.of(BlockItemInit.CENTIPEDE_SEGMENT_ITEM.get()); }),
    CENTIPEDE_HELM("centipede_helm", 0, new int[]{0, 0, 0, 0}, 0, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
        return Ingredient.of(BlockItemInit.CENTIPEDE_SEGMENT_ITEM.get());
    }),
    BEETLEBACKPACK("beetle_backpack", 15, new int[]{0, 0, 2, 0}, 0, SoundEvents.HORSE_SADDLE, 0.0F, 0.0F, () -> {
        return Ingredient.of(BlockItemInit.COOKED_BEETLE_ITEM.get()); })
    ;

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairIngredient;

    private RTSArmorMaterial(String p_i231593_3_, int p_i231593_4_, int[] p_i231593_5_, int p_i231593_6_, SoundEvent p_i231593_7_, float p_i231593_8_, float p_i231593_9_, Supplier<Ingredient> p_i231593_10_) {
        this.name = p_i231593_3_;
        this.durabilityMultiplier = p_i231593_4_;
        this.slotProtections = p_i231593_5_;
        this.enchantmentValue = p_i231593_6_;
        this.sound = p_i231593_7_;
        this.toughness = p_i231593_8_;
        this.knockbackResistance = p_i231593_9_;
        this.repairIngredient = new LazyValue<>(p_i231593_10_);
    }

    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
        return HEALTH_PER_SLOT[p_200896_1_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
        return this.slotProtections[p_200902_1_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
