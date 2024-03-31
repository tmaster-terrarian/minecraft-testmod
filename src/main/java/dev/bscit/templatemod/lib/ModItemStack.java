package dev.bscit.templatemod.lib;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemStack
{
    public static ItemStack of(String id, String nbt, int count)
    {
        ItemStack itemStack = ItemStack.fromNbt(NbtBuilder.fromString("{id: \"" + id + "\", Count: " + count + ", tag: " + nbt + "}"));
        return itemStack;
    }
    public static ItemStack of(String id, String nbt)
    {
        return ModItemStack.of(id, nbt, 1);
    }
    public static ItemStack of(String id)
    {
        return ModItemStack.of(id, "{}", 1);
    }

    public static ItemStack of(Identifier id, String nbt, int count)
    {
        return ModItemStack.of(id.toString(), nbt, count);
    }
    public static ItemStack of(Identifier id, String nbt)
    {
        return ModItemStack.of(id.toString(), nbt, 1);
    }
    public static ItemStack of(Identifier id)
    {
        return ModItemStack.of(id.toString(), "{}", 1);
    }
}
