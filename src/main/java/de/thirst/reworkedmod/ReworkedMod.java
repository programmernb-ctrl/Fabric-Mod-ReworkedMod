package de.thirst.reworkedmod;

import de.thirst.reworkedmod.block.ModBlocks;
import de.thirst.reworkedmod.item.ModItemGroups;
import de.thirst.reworkedmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReworkedMod implements ModInitializer {
	public static final String MOD_ID = "reworkedmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 1800);
    }
}