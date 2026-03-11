package net.lorp.mechaniya.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomShapeBlock extends FaceBlock {
    private final VoxelShape shape;

    public CustomShapeBlock(Properties properties, VoxelShape shape) {
        super(properties);
        this.shape = shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        // Логіка повороту форми залежно від напрямку (Direction)
        return switch (state.getValue(FACING)) {
            case NORTH -> shape;
            case SOUTH -> rotateShape(shape, 180);
            case WEST -> rotateShape(shape, 270);
            case EAST -> rotateShape(shape, 90);
            default -> shape;
        };
    }

    // Проста функція для повороту (можна спростити, але для наочності так)
    private VoxelShape rotateShape(VoxelShape source, int angle) {
        // Це спрощений приклад. На практиці для складних форм
        // зазвичай створюють Map<Direction, VoxelShape> заздалегідь.
        return source;
    }
}