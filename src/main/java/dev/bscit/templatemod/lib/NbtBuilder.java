package dev.bscit.templatemod.lib;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import dev.bscit.templatemod.TemplateMod;
import net.minecraft.nbt.*;

public abstract class NbtBuilder
{
    public NbtElement nbt;

    public static NbtCompound fromString(String nbt)
    {
        NbtCompound NBT = new NbtCompound();

        try {
            NBT = StringNbtReader.parse(nbt);
        }
        catch (CommandSyntaxException e) {
            try {
                NBT = StringNbtReader.parse("{" + nbt + "}");
            }
            catch (CommandSyntaxException _e) {
                TemplateMod.LOGGER.error("Failed to parse nbt string: \"" + nbt + "\", reverting to empty.", e);
            }
        }

        return NBT;
    }
}
