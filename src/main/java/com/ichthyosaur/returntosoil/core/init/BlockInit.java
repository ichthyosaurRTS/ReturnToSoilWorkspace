package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.block.cropblock.*;
import com.ichthyosaur.returntosoil.common.block.functional.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.ToIntFunction;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ReturnToSoil.MOD_ID);

    private static final TextFormatting common = TextFormatting.GREEN;
    private static final TextFormatting spirit = TextFormatting.LIGHT_PURPLE;
    private static final TextFormatting abyss = TextFormatting.DARK_BLUE;
    private static final TextFormatting dark = TextFormatting.DARK_RED;

    //Crops-----------------------------------------------------------

    //Origin berry
    public static final RegistryObject<Block> ORIGIN_BERRY_BLOCK = BLOCKS.register("origin_berry_block", () ->
            new OriginBerryBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> ORIGIN_BERRY_POTTED_BLOCK = BLOCKS.register("origin_berry_potted_block", () ->
            new OriginBerryPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));

    //Common ----------------------------------------------------------------------

    //crystal plant
    public static final RegistryObject<Block> CRYSTAL_PLANT_BLOCK = BLOCKS.register("crystal_plant_block", () ->
            new CrystalPlantBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> CRYSTAL_PLANT_POTTED_BLOCK = BLOCKS.register("crystal_plant_potted_block", () ->
            new CrystalPlantPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD)));

    //lily lantern
    public static final RegistryObject<Block> LILYPAD_LANTERN_BLOCK = BLOCKS.register("lilypad_lantern_block", () ->
            new LilypadLanternBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP).lightLevel(ageSixEmission(12))));

    //Dragon

    //totem stalk
    public static final RegistryObject<Block> TOTEM_STALK_BLOCK = BLOCKS.register("totem_stalk_block", () ->
            new TotemStalkBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.COLOR_BROWN).randomTicks().strength(0.5F).noCollission().sound(SoundType.WOOD).lightLevel(ageTwoEmission(10))));

    public static final RegistryObject<Block> WARDEN_PLANT_POTTED_BLOCK = BLOCKS.register("warden_plant_potted_block", () ->
            new WardenPlantPottedBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD).lightLevel(notZeroFuelEmission(6))));

    //Rarity Dark (-)
    //Vessel crop
    public static final RegistryObject<Block> VESSEL_VINE_BLOCK = BLOCKS.register("vessel_vine_block", () ->
            new VesselVineBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().noCollission().sound(SoundType.HONEY_BLOCK)));
    public static final RegistryObject<Block> VESSEL_SAC_BLOCK = BLOCKS.register("vessel_sac_block", () ->
            new VesselSacBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().sound(SoundType.HONEY_BLOCK)));

    //Functional non-plant blocks------------------------------------------------------------------------------------

    //Refinement Barrel
    public static final RegistryObject<Block> REFINEMENT_BARREL_BLOCK = BLOCKS.register("refinement_barrel_block", () ->
            new RefinementBarrelBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD).strength(0.3F)));

    public static final RegistryObject<Block> REFINEMENT_BARREL_ADV_BLOCK = BLOCKS.register("refinement_barrel_adv_block", () ->
            new RefinementBarrelAdvBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).sound(SoundType.WOOD).strength(0.3F)));

    //HoldingStaff
    public static final RegistryObject<Block> HOLDING_STAFF_BLOCK = BLOCKS.register("holding_staff_block", () ->
            new HoldingStaffBlock(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.GRASS).instabreak().sound(SoundType.WOOD)));

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
            return state.getValue(ReturnToSoil.FUEL_LEVEL)>0 ? lightLevel : 0;
        };
    }
    private static ToIntFunction<BlockState> ageSixEmission(int lightLevel) {
        return (state) -> {
            return state.getValue(BlockStateProperties.AGE_7)==6 ? lightLevel : 0;
        };
    }
    private static ToIntFunction<BlockState> ageTwoEmission(int lightLevel) {
        return (state) -> {
            return state.getValue(ReturnToSoil.AGE_8)==3 ? lightLevel : 0;
        };
    }
    private static ToIntFunction<BlockState> lit(int lightLevel) {
        return (state) -> {
            return lightLevel;
        };
    }

}

