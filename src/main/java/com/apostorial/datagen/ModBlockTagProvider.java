package com.apostorial.datagen;

import com.apostorial.block.ModBlocks;
import com.apostorial.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BREADIUM_BLOCK)
                .add(ModBlocks.RAW_BREADIUM_BLOCK)
                .add(ModBlocks.BREADIUM_ORE)
                .add(ModBlocks.BREADIUM_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BREADIUM_BLOCK)
                .add(ModBlocks.RAW_BREADIUM_BLOCK)
                .add(ModBlocks.BREADIUM_ORE)
                .add(ModBlocks.BREADIUM_DEEPSLATE_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_BREADIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
