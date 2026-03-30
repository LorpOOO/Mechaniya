package net.lorp.mechaniya.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MachineShapes {

    public static final VoxelShape SIMPLE_ENERGY = Block.box(0, 0, 0, 16, 14, 16);

    public static final VoxelShape RUBBER = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(7, 6, 1, 15, 14, 9),
            Block.box(7, 14, 1, 15, 22, 9),
            Block.box(10, 4, 0, 16, 6, 10),
            Block.box(6, 22, 0, 16, 24, 10),
            Block.box(0, 4, 0, 10, 20, 10),
            Block.box(6.1, 2, 6, 14.1, 10, 18),
            Block.box(1.1, 2, 6, 6.1, 10, 18),
            Block.box(-3, 4, 1, 5, 16, 9),
            Block.box(1, 3, 10, 9, 19, 11),
            Block.box(2.5, 3.25, 9.25, 7.5, 17.25, 10.25),
            Block.box(1.6, 7, 8, 12.6, 8, 17)
    );

    public static final VoxelShape OIL_PIPE = Shapes.or(
            Block.box(5, 0, 5, 11, 16, 11)
    );

    public static final VoxelShape HEATPROOF = Shapes.or(
            Block.box(-3, 6, 1, 5, 18, 9),
            Block.box(1, 6, 10, 9, 21, 11),
            Block.box(0, 6, 0, 10, 22, 10),
            Block.box(7, 8, 1, 15, 24, 9),
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(10, 6, 9, 14, 15, 14),
            Block.box(10, 6, 0, 16, 8, 10),
            Block.box(6, 24, 0, 16, 26, 10)
    );

    public static final VoxelShape BRASS = Shapes.or(
            Block.box(0.1, 4.1, 0.1, 7.9, 15.9, 11.9),
            Block.box(6.1, 4.1, 3.1, 15.9, 9.9, 12.9),
            Block.box(2.1, 2.1, 10.1, 5.9, 17.9, 13.9),
            Block.box(0.1, 4.6, 8.1, 7.9, 9.4, 15.9),
            Block.box(2.6, 5.1, 3.1, 5.4, 8.9, 20.9),
            Block.box(-4.9, 5.1, 10.6, 12.9, 8.9, 13.4),
            Block.box(-1.9, 5.6, 6.1, 9.9, 8.4, 17.9),
            Block.box(0, 0, 0, 16, 3.9, 16),
            Block.box(9.1, 10.1, 5.1, 14.9, 11.9, 10.9),
            Block.box(1.1, 16.1, 3.1, 6.9, 17.9, 8.9),
            Block.box(9.1, 12.1, 5.1, 14.9, 20.9, 10.9)
    );

    public static final VoxelShape ZINC = Shapes.or(
            Block.box(0, 0, 0, 16, 9, 16),
            Block.box(2, 9, 2, 14, 23, 14)
    );

    public static final VoxelShape ANDESITE = Shapes.or(
            Block.box(0.1, 0.1, 0.1, 15.9, 15.9, 11.9),
            Block.box(3.1, 14.1, -0.9, 12.9, 17.9, 12.9),
            Block.box(6.1, 6.1, 2.1, 9.9, 9.9, 17.9),
            Block.box(-0.9, 6.6, 12.6, 16.9, 9.4, 15.4),
            Block.box(6.6, -0.9, 12.6, 9.4, 16.9, 15.4),
            Block.box(2.1, 2.1, 13.1, 13.9, 13.9, 14.9),
            Block.box(4.1, 4.1, 12.1, 11.9, 11.9, 15.9),
            Block.box(5.35, 9.1, 1.85, 20.65, 12.9, 5.65),
            Block.box(3.35, 3.1, 1.85, 18.65, 6.9, 5.65)
    );

}