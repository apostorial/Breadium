package com.example.item;

import com.example.Breadium;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_BREADIUM = register(
            "raw_breadium",
            new Item(new Item.Settings()));

    public static final Item BREADIUM_INGOT = register(
            "breadium_ingot",
            new Item(new Item.Settings()));

    public static final Item BREADIUM_STAR_FRAGMENT = register(
            "breadium_star_fragment",
            new Item(new Item.Settings()));

    public static final Item BREADIUM_STAR = register(
            "breadium_star",
            new Item(new Item.Settings()));

    public static Item register(String id, Item item) {
        Identifier itemID = Identifier.of(Breadium.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
        Breadium.LOGGER.info("Registering Breadium items");
    }
}
