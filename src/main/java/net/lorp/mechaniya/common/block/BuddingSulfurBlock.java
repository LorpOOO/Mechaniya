package net.lorp.mechaniya.common.block;

import net.lorp.mechaniya.common.register.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class BuddingSulfurBlock extends BuddingAmethystBlock {
    public BuddingSulfurBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
            BlockPos targetPos = pos.relative(direction);
            BlockState targetState = level.getBlockState(targetPos);

            Block block = null;
            if (targetState.isAir() || targetState.is(Blocks.WATER)) {
                block = ModBlocks.SMALL_SULFUR_BUD.get();
            } else if (targetState.is(ModBlocks.SMALL_SULFUR_BUD.get()) && targetState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_SULFUR_BUD.get();
            } else if (targetState.is(ModBlocks.MEDIUM_SULFUR_BUD.get()) && targetState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_SULFUR_BUD.get();
            } else if (targetState.is(ModBlocks.LARGE_SULFUR_BUD.get()) && targetState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.SULFUR_CLUSTER.get();
            }

            if (block != null) {
                BlockState newState = block.defaultBlockState()
                        .setValue(AmethystClusterBlock.FACING, direction)
                        .setValue(AmethystClusterBlock.WATERLOGGED, targetState.getFluidState().getType() == Fluids.WATER);
                level.setBlockAndUpdate(targetPos, newState);
            }
        }
    }
}