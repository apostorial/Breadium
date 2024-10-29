package com.example.item;

import com.example.Breadium;
import com.example.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BREADIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Breadium.MOD_ID, "breadium_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BREADIUM_INGOT))
                    .displayName(Text.translatable("itemgroup.breadium.breadium_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_BREADIUM);
                        entries.add(ModItems.BREADIUM_INGOT);
                        entries.add(ModItems.BREADIUM_STAR_FRAGMENT);
                        entries.add(ModItems.BREADIUM_STAR);
                        entries.add(ModBlocks.RAW_BREADIUM_BLOCK);
                        entries.add(ModBlocks.BREADIUM_BLOCK);
                        entries.add(ModBlocks.BREADIUM_ORE);
                        entries.add(ModBlocks.BREADIUM_DEEPSLATE_ORE);
                        entries.add(ModBlocks.BREADIUM_STAR_CORE);
                        entries.add(ModBlocks.BREADIUM_STAR_EXTRACTOR);
                    }).build());

    public static void initialize() {
        Breadium.LOGGER.info("Registering Mod Item Groups");
    }
}
