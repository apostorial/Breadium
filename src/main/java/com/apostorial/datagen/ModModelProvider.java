package com.apostorial.datagen;

import com.apostorial.block.ModBlocks;
import com.apostorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BREADIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BREADIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BREADIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BREADIUM_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BREADIUM_STAR_CORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BREADIUM_STAR_EXTRACTOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BREADIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BREADIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BREADIUM_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BREADIUM_STAR_FRAGMENT, Models.GENERATED);
    }
}
