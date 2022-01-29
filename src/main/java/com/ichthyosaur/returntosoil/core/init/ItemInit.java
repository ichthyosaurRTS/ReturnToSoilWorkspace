package com.ichthyosaur.returntosoil.core.init;

import com.google.common.collect.Sets;
import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.item.abst.RTSArmorMaterial;
import com.ichthyosaur.returntosoil.common.item.abst.RTSDescBNItem;
import com.ichthyosaur.returntosoil.common.item.abst.RTSDescItem;
import com.ichthyosaur.returntosoil.common.item.abst.RTSItemTier;
import com.ichthyosaur.returntosoil.common.item.misc.LilypadLanternSeed;
import com.ichthyosaur.returntosoil.common.item.misc.VesselSacItem;
import com.ichthyosaur.returntosoil.common.item.tool.AbyssScalpelItem;
import com.ichthyosaur.returntosoil.common.item.wearable.BeetleBackpack;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeChest;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeHelm;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeLegs;
import com.ichthyosaur.returntosoil.core.util.ReturnToSoilItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ReturnToSoil.MOD_ID);

    private static final TextFormatting common = TextFormatting.GREEN;
    private static final TextFormatting spirit = TextFormatting.LIGHT_PURPLE;
    private static final TextFormatting abyss = TextFormatting.DARK_BLUE;
    private static final TextFormatting dark = TextFormatting.DARK_RED;


    //Crops

    //Origin Berry------------------------------------------------------------------------------------------------------

    public static final Food ORIGIN_BERRY_FOOD = (new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final RegistryObject<Item> ORIGIN_BERRY_ITEM = ITEMS.register("origin_berry_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL).food(ORIGIN_BERRY_FOOD)));
    public static final RegistryObject<Item> ORIGIN_BERRY_SEED = ITEMS.register("origin_berry_seed", () ->
            new BlockNamedItem(BlockInit.ORIGIN_BERRY_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> ORIGIN_JAM_ITEM = ITEMS.register("origin_jam_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> ORIGIN_BERRY_POTTED_ITEM = ITEMS.register("origin_berry_potted_item", () ->
            new BlockItem(BlockInit.ORIGIN_BERRY_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Rarity Common (1) ------------------------------------------------------------------------------------------------

    //crystal plant
    public static final RegistryObject<Item> CRYSTAL_PLANT_SEED = ITEMS.register("crystal_plant_seed", () ->
            new RTSDescBNItem(BlockInit.CRYSTAL_PLANT_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),common));
    public static final RegistryObject<Item> SPIRIT_CRYSTAL_ITEM = ITEMS.register("spirit_crystal_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> SPIRIT_LEAF_ITEM = ITEMS.register("spirit_leaf_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> CRYSTAL_PLANT_POTTED_ITEM = ITEMS.register("crystal_plant_potted_item", () ->
            new BlockItem(BlockInit.CRYSTAL_PLANT_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));


    //Lily lantern
    public static final RegistryObject<Item> LILYPAD_LANTERN_SEED = ITEMS.register("lilypad_lantern_seed", () ->
            new LilypadLanternSeed(BlockInit.LILYPAD_LANTERN_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> LILYPAD_FLOWER_ITEM = ITEMS.register("lilypad_flower_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Dragon-------------------------------------------------------------------------------------------------

    //Totem stalk
    public static final RegistryObject<Item> TOTEM_SHOOT_ITEM = ITEMS.register("totem_shoot_item", () ->
            new RTSDescBNItem(BlockInit.TOTEM_STALK_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),spirit));


    //Warden Plant
    public static final RegistryObject<Item> WARDEN_PLANT_POTTED_ITEM = ITEMS.register("warden_plant_potted_item", () ->
            new BlockItem(BlockInit.WARDEN_PLANT_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> GLASSY_EYEBALL_ITEM = ITEMS.register("glassy_eyeball_item", () ->
            new RTSDescItem(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),common));


    //Rarity Dark (-) --------------------------------------------------------------------------------------------------

    //Vessel Vine
    public static final RegistryObject<Item> VESSEL_SEED = ITEMS.register("vessel_seed", () ->
            new RTSDescBNItem(BlockInit.VESSEL_VINE_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL), dark));
    public static final RegistryObject<Item> VESSEL_SAC_ITEM = ITEMS.register("vessel_sac_item", () ->
            new VesselSacItem(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL), dark));

    //Functional non-plant blocks---------------------------------------------------------------------------------------

    //Refinement barrels
    public static final RegistryObject<Item> REFINEMENT_BARREL_ITEM = ITEMS.register("refinement_barrel_item", () ->
            new BlockItem(BlockInit.REFINEMENT_BARREL_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    public static final RegistryObject<Item> REFINEMENT_BARREL_ADV_ITEM = ITEMS.register("refinement_barrel_adv_item", () ->
            new BlockItem(BlockInit.REFINEMENT_BARREL_ADV_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Random Items -----------------------------------------------------------------------------------------------------

    //Spirit fuel
    public static final RegistryObject<Item> BOTTLED_SPIRIT_ITEM = ITEMS.register("bottled_spirit_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Magical Blood
    public static final RegistryObject<Item> MAGICAL_BLOOD_ITEM = ITEMS.register("magical_blood_item", () ->
            new RTSDescItem(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),dark));

    //Husk Larvae stuffs
    public static final RegistryObject<Item> GRUB_MANTLE_ITEM = ITEMS.register("grub_mantle_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Jaw beetle stuffs; needs a new armour material
    public static final RegistryObject<Item> ROSE_BEETLE_ITEM = ITEMS.register("rose_beetle_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> COOKED_BEETLE_ITEM = ITEMS.register("cooked_beetle_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> BEETLE_BACKPACK_ITEM = ITEMS.register("beetle_backpack_item", () ->
            new BeetleBackpack(RTSArmorMaterial.BEETLEBACKPACK, EquipmentSlotType.CHEST, (new Item.Properties()).tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),common));


    public static final RegistryObject<Item> GHOST_BEETLE_ITEM = ITEMS.register("ghost_beetle_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //BaruGaru stuffs
    public static final RegistryObject<Item> CENTIPEDE_HELM_ITEM = ITEMS.register("centipede_helm_item", () ->
            new CentipedeHelm(RTSArmorMaterial.CENTIPEDE_HELM, EquipmentSlotType.HEAD, (new Item.Properties()).tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),spirit));
    public static final RegistryObject<Item> CENTIPEDE_CHEST_ITEM = ITEMS.register("centipede_chest_item", () ->
            new CentipedeChest(RTSArmorMaterial.CENTIPEDE, EquipmentSlotType.CHEST, (new Item.Properties()).tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),common));
    public static final RegistryObject<Item> CENTIPEDE_LEGS_ITEM = ITEMS.register("centipede_legs_item", () ->
            new CentipedeLegs(RTSArmorMaterial.CENTIPEDE, EquipmentSlotType.LEGS, (new Item.Properties()).tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> CENTIPEDE_SEGMENT_ITEM = ITEMS.register("centipede_segment_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Standalone; Nothing personal kid
    public static final RegistryObject<Item> ABYSS_SCALPEL = ITEMS.register("abyss_scalpel", () ->
            new AbyssScalpelItem(1.0F, 1.0F, RTSItemTier.ABYSS_SCRAPINGS, Sets.newHashSet(), (new Item.Properties()).tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Holding staff
    public static final RegistryObject<Item> HOLDING_STAFF_ITEM = ITEMS.register("holding_staff_item", () ->
            new BlockNamedItem(BlockInit.HOLDING_STAFF_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
}
