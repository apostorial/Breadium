package com.apostorial.datagen;

import com.apostorial.block.ModBlocks;
import com.apostorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BREADIUM_BLOCK);
        addDrop(ModBlocks.RAW_BREADIUM_BLOCK);

        addDrop(ModBlocks.BREADIUM_ORE, oreDrops(ModBlocks.BREADIUM_ORE, ModItems.RAW_BREADIUM));
        addDrop(ModBlocks.BREADIUM_DEEPSLATE_ORE, oreDrops(ModBlocks.BREADIUM_DEEPSLATE_ORE, ModItems.RAW_BREADIUM));
    }
}
