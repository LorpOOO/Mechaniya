package net.lorp.mechaniya.common.register;

import net.lorp.mechaniya.common.block.AndesiteControllerBlockEntity;
import net.lorp.mechaniya.common.block.FluidMithrilSmelterBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.lorp.mechaniya.Mechaniya.MOD_ID;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AndesiteControllerBlockEntity>> ANDESITE_CONTROLLER_BLOCK_ENTITY =
            BLOCK_ENTITY.register("andesite_controller",
                    () -> BlockEntityType.Builder.of(AndesiteControllerBlockEntity::new, ModBlocks.ANDESITE_CONTROLLER.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidMithrilSmelterBlockEntity>> FLUID_MITHRIL_SMELTER =
            BLOCK_ENTITY.register("fluid_mithril_smelter",
                    () -> BlockEntityType.Builder.of(FluidMithrilSmelterBlockEntity::new, ModBlocks.FLUID_MITHRIL_SMELTER.get()).build(null));
}