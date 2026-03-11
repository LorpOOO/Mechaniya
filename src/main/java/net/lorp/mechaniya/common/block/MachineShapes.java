package net.lorp.mechaniya.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MachineShapes {

    // SIMPLE ENERGY — Просто блок висотою 14 пікселів (16x14x16)
    public static final VoxelShape SIMPLE_ENERGY = Block.box(0, 0, 0, 16, 14, 16);

    // RUBBER MACHINE — Точна копія JSON, розгорнута на 180 градусів
    public static final VoxelShape RUBBER = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),          // Основа (без змін при 180°)
            Block.box(7, 6, 1, 15, 14, 9),          // Труба нижня (була 1,7,9 -> 15,9,7)
            Block.box(7, 14, 1, 15, 22, 9),         // Труба верхня
            Block.box(10, 4, 0, 16, 6, 10),         // Нижній виступ
            Block.box(6, 22, 0, 16, 24, 10),        // Верхній виступ
            Block.box(0, 4, 0, 10, 20, 10),         // Основний бак
            Block.box(6.1, 2, 6, 14.1, 10, 18),     // Передня панель ліва (тепер ззаду, виліт 18)
            Block.box(1.1, 2, 6, 6.1, 10, 18),      // Передня панель права (виліт 18)
            Block.box(-3, 4, 1, 5, 16, 9),          // Котушка (тепер зліва, виліт -3)
            Block.box(1, 3, 10, 9, 19, 11),         // Вікно бака
            Block.box(2.5, 3.25, 9.25, 7.5, 17.25, 10.25), // Рама вікна
            Block.box(1.6, 7, 8, 12.6, 8, 17)       // Горизонтальна деталь (виліт 17)
    );

    // HEATPROOF MACHINE — Точна копія за JSON, розгорнута на 180 градусів
    public static final VoxelShape HEATPROOF = Shapes.or(
            Block.box(-3, 6, 1, 5, 18, 9),           // Котушка (була X:11-19, Z:7-15 -> стала X:-3-5, Z:1-9)
            Block.box(1, 6, 10, 9, 21, 11),          // Вікно (було X:7-15, Z:5-6 -> стало X:1-9, Z:10-11)
            Block.box(0, 6, 0, 10, 22, 10),          // Основна колона (була X:6-16, Z:6-16 -> стала X:0-10, Z:0-10)
            Block.box(7, 8, 1, 15, 24, 9),           // Труба висока (була X:1-9, Z:7-15 -> стала X:7-15, Z:1-9)
            Block.box(0, 0, 0, 16, 6, 16),           // Основа плита (без змін)
            Block.box(10, 6, 9, 14, 15, 14),         // Мала труба (була X:2-6, Z:2-7 -> стала X:10-14, Z:9-14)
            Block.box(10, 6, 0, 16, 8, 10),          // Бічна опора (була X:0-6, Z:6-16 -> стала X:10-16, Z:0-10)
            Block.box(6, 24, 0, 16, 26, 10)          // Верхній елемент (був X:0-10, Z:6-16 -> став X:6-16, Z:0-10)
    );

    // BRASS MACHINE — 180° розворот + зменшені на 0.1px куби для плавності
    public static final VoxelShape BRASS = Shapes.or(
            Block.box(0.1, 4.1, 0.1, 7.9, 15.9, 11.9),     // Основний корпус (Element 0)
            Block.box(6.1, 4.1, 3.1, 15.9, 9.9, 12.9),    // Бічний блок (Element 1)
            Block.box(2.1, 2.1, 10.1, 5.9, 17.9, 13.9),   // Pole2Core
            Block.box(0.1, 4.6, 8.1, 7.9, 9.4, 15.9),     // GearCaseOuter

            // ШЕСТЕРНІ (Gears 5, 6, 7) — враховано їх виліт та нахил 22.5° з JSON
            Block.box(2.6, 5.1, 3.1, 5.4, 8.9, 20.9),     // Gear5/6 (виліт на 21)
            Block.box(-4.9, 5.1, 10.6, 12.9, 8.9, 13.4),  // Gear7 (виліт на -5)
            Block.box(-1.9, 5.6, 6.1, 9.9, 8.4, 17.9),    // GearCaseInner

            Block.box(0, 0, 0, 16, 3.9, 16),              // Base (база трохи нижча для плавності)
            Block.box(9.1, 10.1, 5.1, 14.9, 11.9, 10.9),  // Connector1
            Block.box(1.1, 16.1, 3.1, 6.9, 17.9, 8.9),    // Connector2
            Block.box(9.1, 12.1, 5.1, 14.9, 20.9, 10.9)   // Tube1
    );

    // ZINC MACHINE
    public static final VoxelShape ZINC = Shapes.or(
            Block.box(0, 0, 0, 16, 9, 16),
            Block.box(2, 9, 2, 14, 23, 14)
    );

    // ANDESITE MACHINE — Повна копія за JSON, розгорнута на 180° з мікро-корекцією
    public static final VoxelShape ANDESITE = Shapes.or(
            Block.box(0.1, 0.1, 0.1, 15.9, 15.9, 11.9),     // Основний корпус (Andesite Casing)
            Block.box(3.1, 14.1, -0.9, 12.9, 17.9, 12.9),  // Верхня частина (Funnel/Top)
            Block.box(6.1, 6.1, 2.1, 9.9, 9.9, 17.9),       // Центральна вісь (Axis)

            // ШЕСТЕРНІ (Gears) — Зведені в об'ємні рамки (AABB)
            Block.box(-0.9, 6.6, 12.6, 16.9, 9.4, 15.4),    // Горизонтальна шестерня
            Block.box(6.6, -0.9, 12.6, 9.4, 16.9, 15.4),    // Вертикальна шестерня

            // КОРПУС ШЕСТЕРНІ
            Block.box(2.1, 2.1, 13.1, 13.9, 13.9, 14.9),    // GearCaseInner
            Block.box(4.1, 4.1, 12.1, 11.9, 11.9, 15.9),    // GearCaseOuter

            // СТРИЖНІ (Poles) — Виліт за межі блоку враховано
            Block.box(5.35, 9.1, 1.85, 20.65, 12.9, 5.65),  // Pole1 (виліт до 20.6)
            Block.box(3.35, 3.1, 1.85, 18.65, 6.9, 5.65)    // Pole2 (виліт до 18.6)
    );
}