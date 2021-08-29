package com.ichthyosaur.returntosoil.core.init;

import com.google.common.collect.Sets;
import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.block.cropblock.*;
import com.ichthyosaur.returntosoil.common.block.functional.*;
import com.ichthyosaur.returntosoil.common.item.CustomItemTier;
import com.ichthyosaur.returntosoil.common.item.misc.LilypadLanternSeed;
import com.ichthyosaur.returntosoil.common.item.misc.VesselSacItem;
import com.ichthyosaur.returntosoil.common.item.tool.AbyssScalpelItem;
import com.ichthyosaur.returntosoil.common.item.tool.RoseBeetleAxeItem;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.ToIntFunction;

public class BlockItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RTSMain.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RTSMain.MOD_ID);


    //Origin berry
    public static final Food ORIGIN_BERRY_FOOD = (new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final RegistryObject<Item> ORIGIN_BERRY_ITEM = ITEMS.register("origin_berry_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL).food(ORIGIN_BERRY_FOOD)));
    public static final RegistryObject<Block> ORIGIN_BERRY_BLOCK = BLOCKS.register("origin_berry_block", () ->
            new OriginBerryBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> ORIGIN_BERRY_SEED = ITEMS.register("origin_berry_seed", () ->
            new BlockNamedItem(ORIGIN_BERRY_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> ORIGIN_JAM_ITEM = ITEMS.register("origin_jam_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Rarity Common (1) ----------------------------------------------------------------------

    //SpringLeaf
    public static final RegistryObject<Block> SPRING_LEAF_POTTED_BLOCK = BLOCKS.register("spring_leaf_potted_block", () ->
            new SpringLeafPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> SPRING_LEAF_POTTED_ITEM = ITEMS.register("spring_leaf_potted_item", () ->
            new BlockItem(SPRING_LEAF_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Block> SPRING_LEAF_BLOCK = BLOCKS.register("spring_leaf_block", () ->
            new SpringLeafBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> SPRING_LEAF_SEED = ITEMS.register("spring_leaf_seed", () ->
            new BlockNamedItem(SPRING_LEAF_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> SPRING_LEAF_BERRY_ITEM = ITEMS.register("spring_leaf_berry_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //lily lantern
    public static final RegistryObject<Block> LILYPAD_LANTERN_BLOCK = BLOCKS.register("lilypad_lantern_block", () ->
            new LilypadLanternBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel(litBlockEmission(12))));
    public static final RegistryObject<Item> LILYPAD_LANTERN_SEED = ITEMS.register("lilypad_lantern_seed", () -> new LilypadLanternSeed(LILYPAD_LANTERN_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //RefineryPlant
    public static final RegistryObject<Block> REFINERY_PLANT_POTTED_BLOCK = BLOCKS.register("refinery_plant_potted_block", () ->
            new RefineryPlantPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> REFINERY_PLANT_POTTED_ITEM = ITEMS.register("refinery_plant_potted_item", () ->
            new BlockItem(REFINERY_PLANT_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Block> REFINERY_PLANT_BLOCK = BLOCKS.register("refinery_plant_block", () ->
            new RefineryPlantBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> REFINERY_PLANT_SEED = ITEMS.register("refinery_plant_seed", () ->
            new BlockNamedItem(REFINERY_PLANT_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Vessel crop
    public static final RegistryObject<Block> VESSEL_VINE_BLOCK = BLOCKS.register("vessel_vine_block", () ->
            new VesselVineBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().noCollission().sound(SoundType.HONEY_BLOCK)));
    public static final RegistryObject<Block> VESSEL_SAC_BLOCK = BLOCKS.register("vessel_sac_block", () ->
            new VesselSacBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().sound(SoundType.HONEY_BLOCK)));
    public static final RegistryObject<Item> VESSEL_SEED = ITEMS.register("vessel_seed", () ->
            new BlockNamedItem(VESSEL_VINE_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> VESSEL_SAC_ITEM = ITEMS.register("vessel_sac_item", () ->
            new VesselSacItem(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //drought cactus
    public static final RegistryObject<Block> DROUGHT_CACTUS_BLOCK = BLOCKS.register("drought_cactus_block", () ->
            new DroughtCactusBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> DROUGHT_CACTUS_SEED = ITEMS.register("drought_cactus_seed", () ->
            new BlockNamedItem(DROUGHT_CACTUS_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Block> DROUGHT_CACTUS_POTTED_BLOCK = BLOCKS.register("drought_cactus_potted_block", () ->
            new DroughtCactusPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> DROUGHT_CACTUS_POTTED_ITEM = ITEMS.register("drought_cactus_potted_item", () ->
            new BlockItem(DROUGHT_CACTUS_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Rarity Spirit (2)----------------------------------------------------------------------

    //ermthrus lantern
    public static final RegistryObject<Block> ERMTHRUS_LANTERN_BLOCK = BLOCKS.register("ermthrus_lantern_block", () ->
            new ErmthrusLanternBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> ERMTHRUS_LANTERN_SEED = ITEMS.register("ermthrus_lantern_seed", () ->
            new BlockNamedItem(ERMTHRUS_LANTERN_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Block> ERMTHRUS_LANTERN_POTTED_BLOCK = BLOCKS.register("ermthrus_lantern_potted_block", () ->
            new ErmthrusLanternPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> ERMTHRUS_LANTERN_POTTED_ITEM = ITEMS.register("ermthrus_lantern_potted_item", () ->
            new BlockItem(ERMTHRUS_LANTERN_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //warden plant
    public static final RegistryObject<Block> WARDEN_PLANT_BLOCK = BLOCKS.register("warden_plant_block", () ->
            new WardenPlantBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> WARDEN_PLANT_SEED = ITEMS.register("warden_plant_seed", () ->
            new BlockNamedItem(WARDEN_PLANT_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Block> WARDEN_PLANT_POTTED_BLOCK = BLOCKS.register("warden_plant_potted_block", () ->
            new WardenPlantPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> WARDEN_PLANT_POTTED_ITEM = ITEMS.register("warden_plant_potted_item", () ->
            new BlockItem(WARDEN_PLANT_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Gemstone plant
    public static final RegistryObject<Block> GEMSTONE_PLANT_BLOCK = BLOCKS.register("gemstone_plant_block", () ->
            new GemstonePlantBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> GEMSTONE_PLANT_SEED = ITEMS.register("gemstone_plant_seed", () ->
            new BlockNamedItem(GEMSTONE_PLANT_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));


    //Rarity Abyss (3)-----------------------------------------------------------------------

    //Heavy plant
    public static final RegistryObject<Block> HEAVY_PLANT_BLOCK = BLOCKS.register("heavy_plant_block", () ->
            new HeavyPlantBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> HEAVY_PLANT_SEED = ITEMS.register("heavy_plant_seed", () ->
            new BlockNamedItem(HEAVY_PLANT_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Block> HEAVY_PLANT_POTTED_BLOCK = BLOCKS.register("heavy_plant_potted_block", () ->
            new HeavyPlantPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> HEAVY_PLANT_POTTED_ITEM = ITEMS.register("heavy_plant_potted_item", () ->
            new BlockItem(HEAVY_PLANT_POTTED_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));



    // Items ------------------------------------------------------------------

    //Jaw beetle stuffs; needs a new armour material
    public static final RegistryObject<Item> ROSE_BEETLE_ITEM = ITEMS.register("rose_beetle_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> ROSE_BEETLE_AXE = ITEMS.register("rose_beetle_axe", () ->
            new RoseBeetleAxeItem(CustomItemTier.ROSE_BEETLE, 2.5F, 1.0F, (new Item.Properties()).tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));
    public static final RegistryObject<Item> GHOST_BEETLE_ITEM = ITEMS.register("ghost_beetle_item", () ->
            new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //Standalone; Nothing personal kid
    public static final RegistryObject<Item> ABYSS_SCALPEL = ITEMS.register("abyss_scalpel", () ->
            new AbyssScalpelItem(1.0F, 1.0F, CustomItemTier.ABYSS_SCRAPINGS, Sets.newHashSet(), (new Item.Properties()).tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //HoldingStaff
    public static final RegistryObject<Block> HOLDING_STAFF_BLOCK = BLOCKS.register("holding_staff_block", () ->
            new HoldingStaffBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().sound(SoundType.WOOD)));
    public static final RegistryObject<Item> HOLDING_STAFF_ITEM = ITEMS.register("holding_staff_item", () ->
            new BlockNamedItem(HOLDING_STAFF_BLOCK.get(), new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));

    //public static final RegistryObject<item> HUSK_BUG_MEAT_ITEM = ITEMS.register("husk_bug_meat_item", () -> new item(new item.Properties().tab(ItemGroup.TAB_MISC)));
    //static Block huskSpawnBlock = new Block(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.DIRT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    //public static final RegistryObject<Block> HUSK_SPAWN_BLOCK = BLOCKS.register("husk_spawn_block", () -> huskSpawnBlock);
    //public static final RegistryObject<Item> HUSK_SPAWN_BLOCK_ITEM = ITEMS.register("husk_spawn_block_item", () -> new BlockItem(huskSpawnBlock, new Item.Properties().tab(ItemGroup.TAB_MISC)));


    private static ToIntFunction<BlockState> litBlockEmission(int lightLevel) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? lightLevel : 0;
        };
    }

}

