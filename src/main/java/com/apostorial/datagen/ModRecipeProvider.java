package com.apostorial.datagen;

import com.apostorial.block.ModBlocks;
import com.apostorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> BREADIUM_INGOT_SMELTABLES = List.of(ModItems.RAW_BREADIUM, ModBlocks.BREADIUM_ORE, ModBlocks.BREADIUM_DEEPSLATE_ORE);

        offerSmelting(exporter, BREADIUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.BREADIUM_INGOT, 1f, 250, "breadium_ingot");
        offerBlasting(exporter, BREADIUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.BREADIUM_INGOT, 1f, 125, "breadium_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BREADIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.BREADIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_BREADIUM, RecipeCategory.DECORATIONS, ModBlocks.RAW_BREADIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BREADIUM_STAR)
                .pattern(" F ")
                .pattern("FSF")
                .pattern(" F ")
                .input('F', ModItems.BREADIUM_STAR_FRAGMENT)
                .input('S', Items.NETHER_STAR)
                .criterion(hasItem(ModItems.BREADIUM_STAR_FRAGMENT), conditionsFromItem(ModItems.BREADIUM_STAR_FRAGMENT))
                .offerTo(exporter);
    }
}
