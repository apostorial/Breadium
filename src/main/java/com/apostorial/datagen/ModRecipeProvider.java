package com.apostorial.datagen;

import com.apostorial.block.ModBlocks;
import com.apostorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

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
                .pattern("DFD")
                .pattern("FSF")
                .pattern("DFD")
                .input('F', ModItems.BREADIUM_STAR_FRAGMENT)
                .input('S', Items.NETHER_STAR)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.BREADIUM_STAR_FRAGMENT), conditionsFromItem(ModItems.BREADIUM_STAR_FRAGMENT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BREADIUM_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("DUD")
                .pattern("DBD")
                .pattern("DDD")
                .input('U', ModItems.BREADIUM_UPGRADE_SMITHING_TEMPLATE)
                .input('B', Items.BREAD)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.BREADIUM_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.BREADIUM_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter);

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_SWORD),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BREADIUM_SWORD)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_SWORD) + "_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_PICKAXE),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.BREADIUM_PICKAXE)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_PICKAXE) + "_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_SHOVEL),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.BREADIUM_SHOVEL)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_SHOVEL) + "_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_AXE),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.BREADIUM_AXE)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_AXE) + "_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_HOE),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.BREADIUM_HOE)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_HOE) + "_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_HELMET),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BREADIUM_HELMET)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_HELMET) + "_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_CHESTPLATE),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BREADIUM_CHESTPLATE)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_CHESTPLATE) + "_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_LEGGINGS),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BREADIUM_LEGGINGS)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_LEGGINGS) + "_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.NETHERITE_BOOTS),
                        Ingredient.ofItems(ModItems.BREADIUM_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BREADIUM_BOOTS)
                .criterion(hasItem(ModItems.BREADIUM_INGOT),
                        conditionsFromItem(ModItems.BREADIUM_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BREADIUM_BOOTS) + "_smithing"));
    }
}
