package dev.bscit.templatemod.block;

import dev.bscit.templatemod.BlockRegistry;
import dev.bscit.templatemod.lib.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DemoBlockEntity extends BlockEntity implements ImplementedInventory
{
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(DemoBlock.slots, ItemStack.EMPTY);

    public DemoBlockEntity(BlockPos pos, BlockState state)
    {
        super(BlockRegistry.DEMO_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, items);
    }

    static void playSound(World world, BlockPos pos, BlockState state, SoundEvent soundEvent)
    {
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.5;
        double f = (double)pos.getZ() + 0.5;

        world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.BLOCKS, 1F, world.random.nextFloat() * 0.1F + 0.9F);
    }
}
