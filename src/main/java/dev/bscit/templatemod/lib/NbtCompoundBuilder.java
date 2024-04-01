package dev.bscit.templatemod.lib;

import java.util.UUID;

import net.minecraft.nbt.*;

public class NbtCompoundBuilder extends NbtBuilder<NbtCompound>
{
    public NbtCompoundBuilder()
    {
        this.nbt = new NbtCompound();
    }

    public NbtCompoundBuilder put(String key, NbtElement element)
    {
        this.nbt.put(key, element);
        return this;
    }

    public <T extends NbtElement> NbtCompoundBuilder put(String key, NbtBuilder<T> builder)
    {
        return this.put(key, (NbtElement)builder.nbt);
    }

    public NbtCompoundBuilder putShort(String key, short value)
    {
        return this.put(key, NbtShort.of(value));
    }

    public NbtCompoundBuilder putByte(String key, byte value)
    {
        return this.put(key, NbtByte.of(value));
    }

    public NbtCompoundBuilder putByteArray(String key, byte[] value)
    {
        return this.put(key, new NbtByteArray(value));
    }

    public NbtCompoundBuilder putInt(String key, int value)
    {
        return this.put(key, NbtInt.of(value));
    }

    public NbtCompoundBuilder putIntArray(String key, int[] value)
    {
        return this.put(key, new NbtIntArray(value));
    }

    public NbtCompoundBuilder putLong(String key, long value)
    {
        return this.put(key, NbtLong.of(value));
    }

    public NbtCompoundBuilder putLongArray(String key, long[] value)
    {
        return this.put(key, new NbtLongArray(value));
    }

    public NbtCompoundBuilder putUuid(String key, UUID value)
    {
        return this.put(key, NbtHelper.fromUuid(value));
    }

    public NbtCompoundBuilder putFloat(String key, float value)
    {
        return this.put(key, NbtFloat.of(value));
    }

    public NbtCompoundBuilder putDouble(String key, double value)
    {
        return this.put(key, NbtDouble.of(value));
    }

    public NbtCompoundBuilder putString(String key, String value)
    {
        return this.put(key, NbtString.of(value));
    }

    public NbtCompoundBuilder putBoolean(String key, boolean value)
    {
        return this.put(key, NbtByte.of(value));
    }
}
