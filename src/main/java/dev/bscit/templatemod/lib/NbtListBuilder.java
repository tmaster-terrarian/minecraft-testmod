package dev.bscit.templatemod.lib;

import java.util.UUID;
import net.minecraft.nbt.*;

public class NbtListBuilder extends NbtBuilder
{
    public NbtList nbt;

    public NbtListBuilder()
    {
        this.nbt = new NbtList();
    }

    public NbtListBuilder add(NbtElement element)
    {
        this.nbt.add(this.nbt.size(), element);
        return this;
    }

    public NbtListBuilder add(NbtCompoundBuilder builder)
    {
        return this.add((NbtElement)builder.nbt);
    }

    public NbtListBuilder add(NbtListBuilder builder)
    {
        return this.add((NbtElement)builder.nbt);
    }

    public NbtListBuilder addShort(short value)
    {
        return this.add(NbtShort.of(value));
    }

    public NbtListBuilder addByte(byte value)
    {
        return this.add(NbtByte.of(value));
    }

    public NbtListBuilder addByteArray(byte[] value)
    {
        return this.add(new NbtByteArray(value));
    }

    public NbtListBuilder addInt(int value)
    {
        return this.add(NbtInt.of(value));
    }

    public NbtListBuilder addIntArray(int[] value)
    {
        return this.add(new NbtIntArray(value));
    }

    public NbtListBuilder addLong(long value)
    {
        return this.add(NbtLong.of(value));
    }

    public NbtListBuilder addLongArray(long[] value)
    {
        return this.add(new NbtLongArray(value));
    }

    public NbtListBuilder addUuid(UUID value)
    {
        return this.add(NbtHelper.fromUuid(value));
    }

    public NbtListBuilder addFloat(float value)
    {
        return this.add(NbtFloat.of(value));
    }

    public NbtListBuilder addDouble(double value)
    {
        return this.add(NbtDouble.of(value));
    }

    public NbtListBuilder addString(String value)
    {
        return this.add(NbtString.of(value));
    }

    public NbtListBuilder addBoolean(boolean value)
    {
        return this.add(NbtByte.of(value));
    }
}
