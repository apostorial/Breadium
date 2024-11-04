package com.apostorial;

import com.apostorial.block.ModBlocks;
import com.apostorial.item.ModItemGroups;
import com.apostorial.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Breadium implements ModInitializer {
	public static final String MOD_ID = "breadium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModItemGroups.initialize();
		ModBlocks.initialize();
		FuelRegistry.INSTANCE.add(ModItems.BREADIUM_STAR, Integer.MAX_VALUE);
		Registry.register(Registries.FEATURE,
				Identifier.of(MOD_ID, "breadium_ore"),
				new OreFeature(OreFeatureConfig.CODEC));

		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(RegistryKeys.PLACED_FEATURE,
						Identifier.of(MOD_ID, "breadium_ore"))
		);
		LOGGER.info("Hello Fabric world!");
	}
}