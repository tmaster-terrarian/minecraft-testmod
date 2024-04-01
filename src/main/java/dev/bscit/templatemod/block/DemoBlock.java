package dev.bscit.templatemod.block;

import dev.bscit.templatemod.TemplateMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DemoBlock extends Block implements BlockEntityProvider
{
    public static final int slots = 2;

    public DemoBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DemoBlockEntity(pos, state);
    }

    protected boolean tryFill(BlockEntity blockEntity, BlockState blockState, PlayerEntity player, Hand hand)
    {
        return tryFill(blockEntity, blockState, player, hand, 0);
    }

    private boolean tryFill(BlockEntity blockEntity, BlockState blockState, PlayerEntity player, Hand hand, int slotId)
    {
        if(slotId >= slots || slotId < 0)
        {
            DemoBlockEntity.playSound(blockEntity.getWorld(), blockEntity.getPos(), blockState, SoundEvent.of(new Identifier("minecraft", "block.decorated_pot.insert_fail")));
            return false;
        }

        Inventory inventory = (Inventory)blockEntity;

        if(inventory.getStack(slotId).isEmpty())
        {
            // Put the stack the player is holding into the inventory
            inventory.setStack(slotId, player.getStackInHand(hand).copy());
            // Remove the stack from the player's hand
            player.getStackInHand(hand).setCount(0);

            DemoBlockEntity.playSound(blockEntity.getWorld(), blockEntity.getPos(), blockState, SoundEvent.of(new Identifier("minecraft", "block.decorated_pot.insert")));

            return true;
        }
        else if(inventory.getStack(slotId).isOf(player.getStackInHand(hand).getItem()) && inventory.getStack(slotId).getCount() < inventory.getStack(slotId).getItem().getMaxCount())
        {
            int currentAmount = inventory.getStack(slotId).getCount();
            int maxAmount = inventory.getStack(slotId).getItem().getMaxCount();
            int playerAmount = player.getStackInHand(hand).getCount();

            int diff = Math.min(playerAmount, maxAmount - currentAmount);

            inventory.getStack(slotId).setCount(currentAmount + diff);
            player.getStackInHand(hand).setCount(playerAmount - diff);

            if(!player.getStackInHand(hand).isEmpty())
            {
                return tryFill(blockEntity, blockState, player, hand, slotId + 1);
            }
        }

        if(!player.getStackInHand(hand).isEmpty())
        {
            return tryFill(blockEntity, blockState, player, hand, slotId + 1);
        }

        DemoBlockEntity.playSound(blockEntity.getWorld(), blockEntity.getPos(), blockState, SoundEvent.of(new Identifier("minecraft", "block.decorated_pot.insert")));

        return false;
    }

    protected boolean tryTake(BlockEntity blockEntity, BlockState blockState, PlayerEntity player, Hand hand)
    {
        return tryTake(blockEntity, blockState, player, hand, slots - 1);
    }

    private boolean tryTake(BlockEntity blockEntity, BlockState blockState, PlayerEntity player, Hand hand, int slotId)
    {
        if(slotId >= slots || slotId < 0)
        {
            DemoBlockEntity.playSound(blockEntity.getWorld(), blockEntity.getPos(), blockState, SoundEvent.of(new Identifier("minecraft", "block.decorated_pot.insert_fail")));
            return false;
        }

        Inventory inventory = (Inventory)blockEntity;

        if(!inventory.getStack(slotId).isEmpty())
        {
            player.getInventory().offerOrDrop(inventory.getStack(slotId));
            inventory.removeStack(slotId);

            DemoBlockEntity.playSound(blockEntity.getWorld(), blockEntity.getPos(), blockState, SoundEvent.of(new Identifier("minecraft", "block.decorated_pot.insert")));

            return true;
        }
        else return tryTake(blockEntity, blockState, player, hand, slotId - 1);
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return ActionResult.SUCCESS;
        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);

        if(!player.getStackInHand(hand).isEmpty())
        {
            if(!tryFill(world.getBlockEntity(blockPos), blockState, player, hand))
            {
                // If the inventory is full
                TemplateMod.LOGGER.info("The first slot holds " + blockEntity.getStack(0) + " and the second slot holds " + blockEntity.getStack(1));
            }
        }
        else
        {
            if(!tryTake(world.getBlockEntity(blockPos), blockState, player, hand))
            {
                // If the inventory is empty
                TemplateMod.LOGGER.info("The container is empty");

                // could play a sound here idk x2
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved)
    {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}
