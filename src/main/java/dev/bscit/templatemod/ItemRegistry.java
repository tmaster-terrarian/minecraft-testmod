package dev.bscit.templatemod;

import dev.bscit.templatemod.lib.ModItemStack;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ItemRegistry
{
	private static final RegistryKey<ItemGroup> MOD_ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(TemplateMod.MOD_ID, "general"));

	public static final Item COPPER_BUTTON_ITEM = createItem("copper_button", new BlockItem(BlockRegistry.COPPER_BUTTON, new FabricItemSettings()));
	public static final Item DEMO_BLOCK_ITEM = createItem("demo_block", new BlockItem(BlockRegistry.DEMO_BLOCK, new FabricItemSettings()));
	public static final Item INFUSER_BLOCK_ITEM = createItem("infuser", new BlockItem(BlockRegistry.INFUSER_BLOCK, new FabricItemSettings()));
	public static final Item TOME_ITEM = createItem("tome", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON).fireproof()));

	protected static final Item createItem(String id, Item item)
	{
		return Registry.register(Registries.ITEM, new Identifier(TemplateMod.MOD_ID, id), item);
	}

	public static void Register()
	{
		TemplateMod.LOGGER.info("Registering Items");

		Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP, FabricItemGroup.builder()
			.displayName(Text.translatable("itemGroup." + TemplateMod.MOD_ID + ".general"))

			// .icon(() -> ItemStack.fromNbt( // really happy that this works so well
			// 	new NbtCompoundBuilder()
			// 	.putString("id", "minecraft:player_head")
			// 	.putInt("Count", 1)
			// 	.put("tag", new NbtCompoundBuilder()
			// 		.put("SkullOwner", new NbtCompoundBuilder()
			// 			.putIntArray("Id", new int[]{694128119,-24490869,-2090064117,42578109})
			// 			.put("Properties", new NbtCompoundBuilder()
			// 				.put("textures", new NbtListBuilder()
			// 					.add(new NbtCompoundBuilder()
			// 						.putString("Value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ1ZGQzOTVkYmQ2NGQ0ZGVkMTE4NzFmMDYzNmNiYzI5YjJjZTE5MjgzYjk4ZDlmNWJkY2ZmNWI0ZTFjNDFjMiJ9fX0=")
			// 					)
			// 				)
			// 			)
			// 		)
			// 	)
			// 	.nbt
			// ))

			.icon(() -> ModItemStack.of("minecraft:player_head", "{SkullOwner: {Id: [I;694128119,-24490869,-2090064117,42578109], Properties: {textures: [{Value: \"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ1ZGQzOTVkYmQ2NGQ0ZGVkMTE4NzFmMDYzNmNiYzI5YjJjZTE5MjgzYjk4ZDlmNWJkY2ZmNWI0ZTFjNDFjMiJ9fX0=\"}]}}}"))

			.entries((context, entries) -> {
				entries.add(COPPER_BUTTON_ITEM);
				entries.add(DEMO_BLOCK_ITEM);
				entries.add(INFUSER_BLOCK_ITEM);
				entries.add(TOME_ITEM);
			})
			.build()
		);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addAfter(Items.COPPER_BLOCK, COPPER_BUTTON_ITEM);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
			entries.addAfter(Items.STONE_BUTTON, COPPER_BUTTON_ITEM);
		});
	}
}
