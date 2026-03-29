package net.lorp.mechaniya.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

public class CustomMachineBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private final Map<Direction, VoxelShape> shapes = new EnumMap<>(Direction.class);

    public CustomMachineBlock(Properties properties, VoxelShape baseShape) {
        super(properties);

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));

        shapes.put(Direction.NORTH, calculateRotation(baseShape, Direction.NORTH));
        shapes.put(Direction.SOUTH, calculateRotation(baseShape, Direction.SOUTH));
        shapes.put(Direction.WEST, calculateRotation(baseShape, Direction.WEST));
        shapes.put(Direction.EAST, calculateRotation(baseShape, Direction.EAST));
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(FACING, mirror.mirror(state.getValue(FACING)));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return shapes.getOrDefault(state.getValue(FACING), shapes.get(Direction.NORTH));
    }

    private VoxelShape calculateRotation(VoxelShape baseShape, Direction direction) {
        VoxelShape result = Shapes.empty();

        for (var box : baseShape.toAabbs()) {
            double minX = box.minX;
            double maxX = box.maxX;
            double minY = box.minY;
            double maxY = box.maxY;
            double minZ = box.minZ;
            double maxZ = box.maxZ;

            switch (direction) {
                case SOUTH -> result = Shapes.or(result, Shapes.box(minX, minY, minZ, maxX, maxY, maxZ));
                case NORTH -> result = Shapes.or(result, Shapes.box(1.0 - maxX, minY, 1.0 - maxZ, 1.0 - minX, maxY, 1.0 - minZ));
                case WEST -> result = Shapes.or(result, Shapes.box(1.0 - maxZ, minY, minX, 1.0 - minZ, maxY, maxX));
                case EAST -> result = Shapes.or(result, Shapes.box(minZ, minY, 1.0 - maxX, maxZ, maxY, 1.0 - minX));
            }
        }

        return result.optimize();
    }
}