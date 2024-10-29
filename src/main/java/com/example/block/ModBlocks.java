package com.example.block;

import com.example.Breadium;
import com.example.block.custom.BreadiumStarExtractorBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block RAW_BREADIUM_BLOCK = registerBlock(
            "raw_breadium_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(35.0F, 1200.0F)
                    .requiresTool()));

    public static final Block BREADIUM_BLOCK = registerBlock(
            "breadium_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(55.0F, 1200.0F)
                    .requiresTool()));

    public static final Block BREADIUM_ORE = registerBlock(
            "breadium_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(25.0F, 1200.0F)
                    .requiresTool()));

    public static final Block BREADIUM_DEEPSLATE_ORE = registerBlock(
            "breadium_deepslate_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(30.0F, 1200.0F)
                    .requiresTool()));

    public static final Block BREADIUM_STAR_CORE = registerBlock(
            "breadium_star_core",
            new Block(AbstractBlock.Settings.create()
                    .strength(-1.0F, 3600000.0F)
                    .dropsNothing()));

    public static final Block BREADIUM_STAR_EXTRACTOR = registerBlock(
            "breadium_star_extractor",
            new BreadiumStarExtractorBlock(AbstractBlock.Settings.create()
                    .strength(20.0F, 1200.0F)
                    .requiresTool()));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Breadium.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Breadium.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void initialize() {
        Breadium.LOGGER.info("Registering Breadium blocks");
    }
}
