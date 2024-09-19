package de.thirst.reworkedmod.item;

import de.thirst.reworkedmod.ReworkedMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLUE_GARNET = registerItem("blue_garnet", new Item(new Item.Settings()));
    public static final Item RAW_BLUE_GARNET = registerItem("raw_blue_garnet", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ReworkedMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ReworkedMod.LOGGER.info("Registering Mod Items for " + ReworkedMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BLUE_GARNET);
            entries.add(RAW_BLUE_GARNET);
        });
    }
}