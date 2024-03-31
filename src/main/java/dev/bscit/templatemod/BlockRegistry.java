package dev.bscit.templatemod;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockRegistry
{
    public static final Block COPPER_BUTTON = new ButtonBlock(BlockSetType.COPPER, 2, Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY));

    public static void Register()
    {
        TemplateMod.LOGGER.info("Registering Blocks");

        Registry.register(Registries.BLOCK, new Identifier(TemplateMod.MOD_ID, "copper_button"), COPPER_BUTTON);
    }
}
