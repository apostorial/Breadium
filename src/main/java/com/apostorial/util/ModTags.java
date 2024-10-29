package com.apostorial.util;

import com.apostorial.Breadium;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_BREADIUM_TOOL = create("needs_breadium_tool");
        public static final TagKey<Block> INCORRECT_FOR_BREADIUM_TOOL = create("incorrect_for_breadium_tool");

        private static TagKey<Block> create(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Breadium.MOD_ID ,name));
        }
    }

    public static class Items {
        private static TagKey<Item> create(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Breadium.MOD_ID ,name));
        }
    }
}
