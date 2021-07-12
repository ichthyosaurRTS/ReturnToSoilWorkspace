package com.ichthyosaur.rts.core.init;

import com.ichthyosaur.rts.RTSMain;
import com.ichthyosaur.rts.common.Block.CropBlock.OriginBerryBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RTSMain.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RTSMain.MOD_ID);




    public static final Food ORIGIN_BERRY_FOOD = (new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final RegistryObject<Item> ORIGIN_BERRY_ITEM = ITEMS.register("origin_berry_item", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(ORIGIN_BERRY_FOOD)));

    //public static final RegistryObject<Item> HUSK_BUG_MEAT_ITEM = ITEMS.register("husk_bug_meat_item", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    static Block originBerryBlock = new OriginBerryBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    public static final RegistryObject<Block> ORIGIN_BERRY_BLOCK = BLOCKS.register("origin_berry_block", () -> originBerryBlock);
    public static final RegistryObject<Item> ORIGIN_BERRY_SEED = ITEMS.register("origin_berry_seed", () -> new BlockNamedItem(originBerryBlock, new Item.Properties().tab(ItemGroup.TAB_FOOD)));


    //static Block huskSpawnBlock = new Block(AbstractBlock.Properties.of(Material.BAMBOO, MaterialColor.DIRT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    //public static final RegistryObject<Block> HUSK_SPAWN_BLOCK = BLOCKS.register("husk_spawn_block", () -> huskSpawnBlock);
    //public static final RegistryObject<Item> HUSK_SPAWN_BLOCK_ITEM = ITEMS.register("husk_spawn_block_item", () -> new BlockItem(huskSpawnBlock, new Item.Properties().tab(ItemGroup.TAB_MISC)));






}

