package de.thirst.reworkedmod.item;

import de.thirst.reworkedmod.ReworkedMod;
import de.thirst.reworkedmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BLUE_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReworkedMod.MOD_ID, "blue_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLUE_GARNET))
                    .displayName(Text.translatable("itemgroup.reworkedmod.blue_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLUE_GARNET);
                        entries.add(ModItems.RAW_BLUE_GARNET);

                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.CAULIFLOWER);

                        entries.add(ModItems.STARLIGHT_ASHES);
                    }).build());

    public static final ItemGroup BLUE_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReworkedMod.MOD_ID, "blue_garnet_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BLUE_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.reworkedmod.blue_garnet_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BLUE_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_BLUE_GARNET_BLOCK);

                        entries.add(ModBlocks.BLUE_GARNET_ORE);
                        entries.add(ModBlocks.BLUE_GARNET_DEEPSLATE_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                    }).build());

    public static void registerItemGroups() {
        ReworkedMod.LOGGER.info("Registering Item Groups for " + ReworkedMod.MOD_ID);
    }
}
