package dev.bscit.templatemod.lib;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import dev.bscit.templatemod.TemplateMod;

import net.minecraft.nbt.*;

public abstract class NbtBuilder<T extends NbtElement>
{
    public T nbt;

    public static final NbtCompound fromString(String nbt)
    {
        NbtCompound NBT = new NbtCompound();

        try {
            NBT = StringNbtReader.parse(nbt);
        }
        catch (CommandSyntaxException e) {
            boolean fixSucceeded = true;

            try {
                NBT = StringNbtReader.parse("{" + nbt + "}");
            }
            catch (CommandSyntaxException _e) {
                TemplateMod.LOGGER.error("Error: Failed to parse nbt string: '" + nbt + "', reverting to empty!", e.getMessage(), e.getStackTrace());
                fixSucceeded = false;
            }

            if(!fixSucceeded) {
                TemplateMod.LOGGER.warn("Warning: the nbt string '" + nbt + "' was missing enclosing brackets!");
            }
        }

        return NBT;
    }
}
