package com.apostorial.item;

import com.apostorial.Breadium;
import com.apostorial.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {
    public static final Item RAW_BREADIUM = register(
            "raw_breadium",
            new Item(new Item.Settings()
                    .rarity(Rarity.UNCOMMON)));

    public static final Item BREADIUM_INGOT = register(
            "breadium_ingot",
            new Item(new Item.Settings()
                    .rarity(Rarity.UNCOMMON)));

    public static final Item BREADIUM_STAR_FRAGMENT = register(
            "breadium_star_fragment",
            new Item(new Item.Settings()
                    .fireproof()
                    .rarity(Rarity.RARE)));

    public static final Item BREADIUM_STAR = register(
            "breadium_star",
            new BreadiumStarItem(new Item.Settings()
                    .fireproof()
                    .rarity(Rarity.EPIC)
                    .maxCount(1)) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.breadium.breadium_star"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item BREADIUM_SWORD = register(
            "breadium_sword",
            new BreadiumSwordItem(ModToolMaterials.BREADIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BREADIUM, 4, -2.4f))) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.breadium.breadium_sword"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item BREADIUM_PICKAXE = register(
            "breadium_pickaxe",
            new BreadiumPickaxeItem(ModToolMaterials.BREADIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BREADIUM, 1.5f, -2.8f))) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.breadium.breadium_pickaxe"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item BREADIUM_SHOVEL = register(
            "breadium_shovel",
            new BreadiumShovelItem(ModToolMaterials.BREADIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BREADIUM, 2.0f, -3.0f))));

    public static final Item BREADIUM_AXE = register(
            "breadium_axe",
            new BreadiumAxeItem(ModToolMaterials.BREADIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BREADIUM, 6, -3.0f))) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.breadium.breadium_axe"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item BREADIUM_HOE = register(
            "breadium_hoe",
            new BreadiumHoeItem(ModToolMaterials.BREADIUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BREADIUM, -4.5f, 0.0f))));

    public static Item register(String id, Item item) {
        Identifier itemID = Identifier.of(Breadium.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
        Breadium.LOGGER.info("Registering Breadium items");
    }
}
