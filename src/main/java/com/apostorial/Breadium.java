package com.apostorial;

import com.apostorial.block.ModBlocks;
import com.apostorial.item.ModItemGroups;
import com.apostorial.item.ModItems;
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
		FuelRegistry.INSTANCE.add(ModItems.BREADIUM_STAR, Integer.MAX_VALUE);
		LOGGER.info("Hello Fabric world!");
	}
}