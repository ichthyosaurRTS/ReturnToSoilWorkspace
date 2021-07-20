package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.Block.CropBlock.LilypadLanternBlock;
import com.ichthyosaur.returntosoil.common.Block.CropBlock.OriginBerryBlock;
import com.ichthyosaur.returntosoil.common.Item.Misc.LilypadLanternSeed;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
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


    //Origin berry stuffs
    public static final Food ORIGIN_BERRY_FOOD = (new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final RegistryObject<Item> ORIGIN_BERRY_ITEM = ITEMS.register("origin_berry_item", () -> new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL).food(ORIGIN_BERRY_FOOD)));
    static Block originBerryBlock = new OriginBerryBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    public static final RegistryObject<Block> ORIGIN_BERRY_BLOCK = BLOCKS.register("origin_berry_block", () -> originBerryBlock);
    public static final RegistryObject<Item> ORIGIN_BERRY_SEED = ITEMS.register("origin_berry_seed", () -> new BlockNamedItem(originBerryBlock, new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));


    //lily lantern stuffs
    static Block lilypadLanternBlock = new LilypadLanternBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel(litBlockEmission(12)));
    public static final RegistryObject<Block> LILYPAD_LANTERN_BLOCK = BLOCKS.register("lilypad_lantern_block", () -> lilypadLanternBlock);
    public static final RegistryObject<Item> LILYPAD_LANTERN_SEED = ITEMS.register("lilypad_lantern_seed", () -> new LilypadLanternSeed(lilypadLanternBlock, new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL)));


    public static Item roseBeetleItem= new Item(new Item.Properties().tab(ReturnToSoilItemGroup.RETURN_TO_SOIL));
    public static final RegistryObject<Item> ROSE_BEETLE_ITEM = ITEMS.register("rose_beetle_item", () -> roseBeetleItem);

    //public static final RegistryObject<Item> HUSK_BUG_MEAT_ITEM = ITEMS.register("husk_bug_meat_item", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    //static Block huskSpawnBlock = new Block(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.DIRT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    //public static final RegistryObject<Block> HUSK_SPAWN_BLOCK = BLOCKS.register("husk_spawn_block", () -> huskSpawnBlock);
    //public static final RegistryObject<Item> HUSK_SPAWN_BLOCK_ITEM = ITEMS.register("husk_spawn_block_item", () -> new BlockItem(huskSpawnBlock, new Item.Properties().tab(ItemGroup.TAB_MISC)));


    private static ToIntFunction<BlockState> litBlockEmission(int lightLevel) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? lightLevel : 0;
        };
    }

}

