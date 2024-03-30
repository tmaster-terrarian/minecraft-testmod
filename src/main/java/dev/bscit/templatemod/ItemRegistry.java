package dev.bscit.templatemod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    private static final RegistryKey<ItemGroup> MOD_ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(TemplateMod.MOD_ID, "test_group"));

    public static final Item WOODEN_CRATE_ITEM = new BlockItem(BlockRegistry.COPPER_BUTTON, new Item.Settings());

    public static void Register()
    {
        Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP, FabricItemGroup.builder()
	        .displayName(Text.translatable("itemGroup." + TemplateMod.MOD_ID + ".general"))
	        .icon(() -> new ItemStack(Items.DIAMOND))
	        .entries((context, entries) -> {
	            entries.add(WOODEN_CRATE_ITEM);
	        })
	        .build()
	    );
    }
}
