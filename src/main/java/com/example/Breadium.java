package com.example;

import com.example.block.ModBlocks;
import com.example.item.ModItemGroups;
import com.example.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
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
		FuelRegistry.INSTANCE.add(ModItems.BREADIUM_STAR, 631138504); // 631,138,504.32 ticks exactly, 31,556,925.216 seconds, 365.24219 days, 1 solar year
		LOGGER.info("Hello Fabric world!");
	}
}