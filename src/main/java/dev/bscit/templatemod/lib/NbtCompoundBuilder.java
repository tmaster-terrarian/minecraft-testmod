package dev.bscit.templatemod.lib;

import java.util.UUID;
import net.minecraft.nbt.*;

public class NbtCompoundBuilder extends NbtBuilder
{
    public NbtCompound nbt;

    public NbtCompoundBuilder()
    {
        this.nbt = new NbtCompound();
    }

    public NbtCompoundBuilder put(String key, NbtElement element)
    {
        this.nbt.put(key, element);
        return this;
    }

    public NbtCompoundBuilder put(String key, NbtCompoundBuilder builder)
    {
        this.nbt.put(key, builder.nbt);
        return this;
    }
    public NbtCompoundBuilder put(String key, NbtListBuilder builder)
    {
        this.nbt.put(key, builder.nbt);
        return this;
    }

    public NbtCompoundBuilder putShort(String key, short value)
    {
        this.nbt.putShort(key, value);
        return this;
    }

    public NbtCompoundBuilder putByte(String key, byte value)
    {
        this.nbt.putByte(key, value);
        return this;
    }

    public NbtCompoundBuilder putByteArray(String key, byte[] value)
    {
        this.nbt.putByteArray(key, value);
        return this;
    }

    public NbtCompoundBuilder putInt(String key, int value)
    {
        this.nbt.putInt(key, value);
        return this;
    }

    public NbtCompoundBuilder putIntArray(String key, int[] value)
    {
        this.nbt.putIntArray(key, value);
        return this;
    }

    public NbtCompoundBuilder putLong(String key, long value)
    {
        this.nbt.putLong(key, value);
        return this;
    }

    public NbtCompoundBuilder putLongArray(String key, long[] value)
    {
        this.nbt.putLongArray(key, value);
        return this;
    }

    public NbtCompoundBuilder putUuid(String key, UUID value)
    {
        this.nbt.putUuid(key, value);
        return this;
    }

    public NbtCompoundBuilder putFloat(String key, float value)
    {
        this.nbt.putFloat(key, value);
        return this;
    }

    public NbtCompoundBuilder putDouble(String key, double value)
    {
        this.nbt.putDouble(key, value);
        return this;
    }

    public NbtCompoundBuilder putString(String key, String value)
    {
        this.nbt.putString(key, value);
        return this;
    }

    public NbtCompoundBuilder putBoolean(String key, boolean value)
    {
        this.nbt.putBoolean(key, value);
        return this;
    }
}
