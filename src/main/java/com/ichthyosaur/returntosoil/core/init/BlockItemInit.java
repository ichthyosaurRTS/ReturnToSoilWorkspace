package com.ichthyosaur.returntosoil.core.init;

import com.google.common.collect.Sets;
import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.block.cropblock.*;
import com.ichthyosaur.returntosoil.common.block.functional.*;
import com.ichthyosaur.returntosoil.common.item.abst.RTSItemTier;
import com.ichthyosaur.returntosoil.common.item.abst.RTSArmorMaterial;
import com.ichthyosaur.returntosoil.common.item.abst.RTSDescBNItem;
import com.ichthyosaur.returntosoil.common.item.abst.RTSDescItem;
import com.ichthyosaur.returntosoil.common.item.misc.LilypadLanternSeed;
import com.ichthyosaur.returntosoil.common.item.misc.VesselSacItem;
import com.ichthyosaur.returntosoil.common.item.tool.AbyssScalpelItem;
import com.ichthyosaur.returntosoil.common.item.tool.RoseBeetleAxeItem;
import com.ichthyosaur.returntosoil.common.item.wearable.BeetleBackpack;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeChest;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeHelm;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeLegs;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.ToIntFunction;

public class BlockItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RTSMain.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RTSMain.MOD_ID);

    private static final TextFormatting common = TextFormatting.GREEN;
    private static final TextFormatting spirit = TextFormatting.LIGHT_PURPLE;
    private static final TextFormatting abyss = TextFormatting.DARK_BLUE;
    private static final TextFormatting dark = TextFormatting.DARK_RED;

    //Crops-----------------------------------------------------------

    //Origin berry
    public static final Food ORIGIN_BERRY_FOOD = (new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final RegistryObject<Item> ORIGIN_BERRY_ITEM = ITEMS.register("origin_berry_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL).food(ORIGIN_BERRY_FOOD)));
    public static final RegistryObject<Block> ORIGIN_BERRY_BLOCK = BLOCKS.register("origin_berry_block", () ->
            new OriginBerryBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Item> ORIGIN_BERRY_SEED = ITEMS.register("origin_berry_seed", () ->
            new BlockNamedItem(ORIGIN_BERRY_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> ORIGIN_JAM_ITEM = ITEMS.register("origin_jam_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Rarity Common (1) ----------------------------------------------------------------------

    //crystal plant
    public static final RegistryObject<Block> CRYSTAL_PLANT_BLOCK = BLOCKS.register("crystal_plant_block", () ->
            new CrystalPlantBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Item> CRYSTAL_PLANT_SEED = ITEMS.register("crystal_plant_seed", () ->
            new RTSDescBNItem(CRYSTAL_PLANT_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),common));
    public static final RegistryObject<Item> SPIRIT_CRYSTAL_ITEM = ITEMS.register("spirit_crystal_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //lily lantern
    public static final RegistryObject<Block> LILYPAD_LANTERN_BLOCK = BLOCKS.register("lilypad_lantern_block", () ->
            new LilypadLanternBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP).lightLevel(ageSixEmission(12))));
    public static final RegistryObject<Item> LILYPAD_LANTERN_SEED = ITEMS.register("lilypad_lantern_seed", () ->
            new LilypadLanternSeed(LILYPAD_LANTERN_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> LILYPAD_FLOWER_ITEM = ITEMS.register("lilypad_flower_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));


    //Rarity Spirit (2)----------------------------------------------------------------------

    //ermthrus lantern
    public static final RegistryObject<Block> ERMTHRUS_LANTERN_BLOCK = BLOCKS.register("ermthrus_lantern_block", () ->
            new ErmthrusLanternBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Item> ERMTHRUS_LANTERN_SEED = ITEMS.register("ermthrus_lantern_seed", () ->
            new RTSDescBNItem(ERMTHRUS_LANTERN_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),spirit));
    public static final RegistryObject<Block> ERMTHRUS_LANTERN_POTTED_BLOCK = BLOCKS.register("ermthrus_lantern_potted_block", () ->
            new ErmthrusLanternPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD).randomTicks().lightLevel(notZeroFuelEmission(15))));
    public static final RegistryObject<Item> ERMTHRUS_LANTERN_POTTED_ITEM = ITEMS.register("ermthrus_lantern_potted_item", () ->
            new BlockItem(ERMTHRUS_LANTERN_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //warden plant
    public static final RegistryObject<Block> WARDEN_PLANT_BLOCK = BLOCKS.register("warden_plant_block", () ->
            new WardenPlantBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Item> WARDEN_PLANT_SEED = ITEMS.register("warden_plant_seed", () ->
            new RTSDescBNItem(WARDEN_PLANT_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),spirit));
    public static final RegistryObject<Block> WARDEN_PLANT_POTTED_BLOCK = BLOCKS.register("warden_plant_potted_block", () ->
            new WardenPlantPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD).lightLevel(notZeroFuelEmission(6))));
    public static final RegistryObject<Item> WARDEN_PLANT_POTTED_ITEM = ITEMS.register("warden_plant_potted_item", () ->
            new BlockItem(WARDEN_PLANT_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> GLASSY_EYEBALL_ITEM = ITEMS.register("glassy_eyeball_item", () ->
            new RTSDescItem(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),common));

    //cerulean coral
    public static final RegistryObject<Block> CERULEAN_CORAL_POTTED_BLOCK = BLOCKS.register("cerulean_coral_potted_block", () ->
            new CeruleanCoralPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD).lightLevel(notZeroFuelEmission(4))));
    public static final RegistryObject<Item> CERULEAN_CORAL_POTTED_ITEM = ITEMS.register("cerulean_coral_potted_item", () ->
            new BlockItem(CERULEAN_CORAL_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Rarity Abyss (3)-----------------------------------------------------------------------

    //Heavy plant
    public static final RegistryObject<Block> HEAVY_PLANT_BLOCK = BLOCKS.register("heavy_plant_block", () ->
            new HeavyPlantBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Item> HEAVY_PLANT_SEED = ITEMS.register("heavy_plant_seed", () ->
            new RTSDescBNItem(HEAVY_PLANT_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),abyss));
    public static final RegistryObject<Block> HEAVY_PLANT_POTTED_BLOCK = BLOCKS.register("heavy_plant_potted_block", () ->
            new HeavyPlantPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD).randomTicks().lightLevel(lit(3))));
    public static final RegistryObject<Item> HEAVY_PLANT_POTTED_ITEM = ITEMS.register("heavy_plant_potted_item", () ->
            new BlockItem(HEAVY_PLANT_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> HEAVY_FRUIT_ITEM = ITEMS.register("heavy_fruit_item", () ->
            new RTSDescItem(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL),spirit));

    //Rarity Dark (-)
    //Vessel crop
    public static final RegistryObject<Block> VESSEL_VINE_BLOCK = BLOCKS.register("vessel_vine_block", () ->
            new VesselVineBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().noCollission().sound(SoundType.HONEY_BLOCK)));
    public static final RegistryObject<Block> VESSEL_SAC_BLOCK = BLOCKS.register("vessel_sac_block", () ->
            new VesselSacBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().sound(SoundType.HONEY_BLOCK)));
    public static final RegistryObject<Item> VESSEL_SEED = ITEMS.register("vessel_seed", () ->
            new RTSDescBNItem(VESSEL_VINE_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL), dark));
    public static final RegistryObject<Item> VESSEL_SAC_ITEM = ITEMS.register("vessel_sac_item", () ->
            new VesselSacItem(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL), dark));

    //Functional non-plant blocks------------------------------------------------------------------------------------

    //Refinement Barrel
    public static final RegistryObject<Block> REFINEMENT_BARREL_BLOCK = BLOCKS.register("refinement_barrel_block", () ->
            new RefinementBarrelBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> REFINEMENT_BARREL_ITEM = ITEMS.register("refinement_barrel_item", () ->
            new BlockItem(REFINEMENT_BARREL_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    public static final RegistryObject<Block> REFINEMENT_BARREL_L_BLOCK = BLOCKS.register("refinement_barrel_l_block", () ->
            new RefinementBarrelLBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> L_REFINEMENT_BARREL_ITEM = ITEMS.register("refinement_barrel_l_item", () ->
            new BlockItem(REFINEMENT_BARREL_L_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));


    // Items ------------------------------------------------------------------

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

    public static final RegistryObject<Item> ROSE_BEETLE_AXE = ITEMS.register("rose_beetle_axe", () ->
            new RoseBeetleAxeItem(RTSItemTier.ROSE_BEETLE, 2.5F, 1.0F, (new Item.Properties()).tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
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

    //HoldingStaff
    public static final RegistryObject<Block> HOLDING_STAFF_BLOCK = BLOCKS.register("holding_staff_block", () ->
            new HoldingStaffBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().sound(SoundType.WOOD)));
    public static final RegistryObject<Item> HOLDING_STAFF_ITEM = ITEMS.register("holding_staff_item", () ->
            new BlockNamedItem(HOLDING_STAFF_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //public static final RegistryObject<item> HUSK_BUG_MEAT_ITEM = ITEMS.register("husk_bug_meat_item", () -> new item(new item.Properties().tab(ItemGroup.TAB_MISC)));
    //static Bulk huskSpawnBlock = new Bulk(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.DIRT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
    //public static final RegistryObject<Bulk> HUSK_SPAWN_BLOCK = BLOCKS.register("husk_spawn_block", () -> huskSpawnBlock);
    //public static final RegistryObject<Item> HUSK_SPAWN_BLOCK_ITEM = ITEMS.register("husk_spawn_block_item", () -> new BlockItem(huskSpawnBlock, new Item.Properties().tab(ItemGroup.TAB_MISC)));


    private static ToIntFunction<BlockState> litBlockEmission(int lightLevel) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? lightLevel : 0;
        };
    }
    private static ToIntFunction<BlockState> notZeroFuelEmission(int lightLevel) {
        return (state) -> {
            return state.getValue(RTSMain.FUEL_LEVEL)>0 ? lightLevel : 0;
        };
    }
    private static ToIntFunction<BlockState> ageSixEmission(int lightLevel) {
        return (state) -> {
            return state.getValue(BlockStateProperties.AGE_7)==6 ? lightLevel : 0;
        };
    }
    private static ToIntFunction<BlockState> lit(int lightLevel) {
        return (state) -> {
            return lightLevel;
        };
    }

}

