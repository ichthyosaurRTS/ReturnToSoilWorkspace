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

    //lily lantern
    public static final RegistryObject<Block> LILYPAD_LANTERN_BLOCK = BLOCKS.register("lilypad_lantern_block", () ->
            new LilypadLanternBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.CROP).lightLevel(ageSixEmission(12))));

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

