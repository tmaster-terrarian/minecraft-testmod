package dev.bscit.templatemod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class InfuserBlock extends Block implements BlockEntityProvider
{
    public InfuserBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new InfuserBlockEntity(pos, state);
    }
}
