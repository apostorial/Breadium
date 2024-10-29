package com.apostorial.datagen;

import com.apostorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BREADIUM_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BREADIUM_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BREADIUM_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BREADIUM_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BREADIUM_HOE);

        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.BREADIUM_SWORD);

        getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(ModItems.BREADIUM_SWORD);

        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.BREADIUM_SWORD)
                .add(ModItems.BREADIUM_AXE);

        getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModItems.BREADIUM_SWORD)
                .add(ModItems.BREADIUM_AXE);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.BREADIUM_PICKAXE)
                .add(ModItems.BREADIUM_SHOVEL)
                .add(ModItems.BREADIUM_AXE)
                .add(ModItems.BREADIUM_HOE);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.BREADIUM_PICKAXE)
                .add(ModItems.BREADIUM_SHOVEL)
                .add(ModItems.BREADIUM_AXE)
                .add(ModItems.BREADIUM_HOE);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.BREADIUM_SWORD)
                .add(ModItems.BREADIUM_PICKAXE)
                .add(ModItems.BREADIUM_SHOVEL)
                .add(ModItems.BREADIUM_AXE)
                .add(ModItems.BREADIUM_HOE);
    }
}
