package net.lorp.mechaniya.common.register;

import com.google.common.base.Suppliers;
import net.lorp.mechaniya.Mechaniya;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluid {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, Mechaniya.MOD_ID);

    private static final Supplier<BaseFlowingFluid.Properties> SHIMMER_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.SHIMMER,
                    ModFluid.SOURCE_SHIMMER,
                    ModFluid.FLOWING_SHIMMER
            )
                    .block(ModBlocks.SHIMMER_BLOCK)
                    .bucket(ModItems.SHIMMER_BUCKET)
    );

    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_SHIMMER = FLUIDS.register("shimmer",
            () -> new BaseFlowingFluid.Source(SHIMMER_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_SHIMMER = FLUIDS.register("shimmer_flow",
            () -> new BaseFlowingFluid.Flowing(SHIMMER_PROPERTIES.get()));

    private static final Supplier<BaseFlowingFluid.Properties> PROPYLENE_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.PROPYLENE,
                    ModFluid.SOURCE_PROPYLENE,
                    ModFluid.FLOWING_PROPYLENE
            )
                    .block(ModBlocks.PROPYLENE_BLOCK)
                    .bucket(ModItems.PROPYLENE_BUCKET)
    );

    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_PROPYLENE = FLUIDS.register("propylene",
            () -> new BaseFlowingFluid.Source(PROPYLENE_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_PROPYLENE = FLUIDS.register("propylene_flow",
            () -> new BaseFlowingFluid.Flowing(PROPYLENE_PROPERTIES.get()));

    private static final Supplier<BaseFlowingFluid.Properties> LATEX_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.LATEX,
                    ModFluid.SOURCE_LATEX,
                    ModFluid.FLOWING_LATEX
            )
                    .block(ModBlocks.LATEX_BLOCK)
                    .bucket(ModItems.LATEX_BUCKET)
    );

    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_LATEX = FLUIDS.register("latex",
            () -> new BaseFlowingFluid.Source(LATEX_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_LATEX = FLUIDS.register("latex_flow",
            () -> new BaseFlowingFluid.Flowing(LATEX_PROPERTIES.get()));


    private static final Supplier<BaseFlowingFluid.Properties> WARPED_LATEX_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.WARPED_LATEX,
                    ModFluid.SOURCE_WARPED_LATEX,
                    ModFluid.FLOWING_WARPED_LATEX
            )
                    .block(ModBlocks.WARPED_LATEX_BLOCK)
                    .bucket(ModItems.WARPED_LATEX_BUCKET)
    );

    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_WARPED_LATEX = FLUIDS.register("warped_latex",
            () -> new BaseFlowingFluid.Source(WARPED_LATEX_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_WARPED_LATEX = FLUIDS.register("warped_latex_flow",
            () -> new BaseFlowingFluid.Flowing(WARPED_LATEX_PROPERTIES.get()));


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}