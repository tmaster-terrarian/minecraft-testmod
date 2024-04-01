package dev.bscit.templatemod;

import dev.bscit.templatemod.block.DemoBlock;
import dev.bscit.templatemod.block.DemoBlockEntity;
import dev.bscit.templatemod.block.InfuserBlock;
import dev.bscit.templatemod.block.InfuserBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockRegistry
{
    public static final Block COPPER_BUTTON = new ButtonBlock(BlockSetType.COPPER, 2, FabricBlockSettings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block DEMO_BLOCK = new DemoBlock(FabricBlockSettings.copy(Blocks.STONE));
    public static final Block INFUSER_BLOCK = new InfuserBlock(FabricBlockSettings.copy(Blocks.CRAFTING_TABLE).sounds(BlockSoundGroup.LANTERN));

    public static final BlockEntityType<DemoBlockEntity> DEMO_BLOCK_ENTITY = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        new Identifier(TemplateMod.MOD_ID, "demo_block_entity"),
        FabricBlockEntityTypeBuilder.create(DemoBlockEntity::new, DEMO_BLOCK).build()
    );

    public static final BlockEntityType<InfuserBlockEntity> INFUSER_BLOCK_ENTITY = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        new Identifier(TemplateMod.MOD_ID, "infuser_block_entity"),
        FabricBlockEntityTypeBuilder.create(InfuserBlockEntity::new, INFUSER_BLOCK).build()
    );

    public static void Register()
    {
        TemplateMod.LOGGER.info("Registering Blocks");

        Registry.register(Registries.BLOCK, new Identifier(TemplateMod.MOD_ID, "copper_button"), COPPER_BUTTON);
        Registry.register(Registries.BLOCK, new Identifier(TemplateMod.MOD_ID, "demo_block"), DEMO_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(TemplateMod.MOD_ID, "infuser"), INFUSER_BLOCK);
    }
}
