package net.lorp.mechaniya.fluid;

import com.google.common.base.Suppliers;
import net.lorp.mechaniya.Mechaniya;
import net.lorp.mechaniya.block.ModBlocks;
import net.lorp.mechaniya.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluid {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, Mechaniya.MOD_ID);

    // SHIMMER
    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_SHIMMER = FLUIDS.register("shimmer",
            () -> new BaseFlowingFluid.Source(ModFluid.SHIMMER_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_SHIMMER = FLUIDS.register("shimmer_flow",
            () -> new BaseFlowingFluid.Flowing(ModFluid.SHIMMER_PROPERTIES.get()));

    private static final Supplier<BaseFlowingFluid.Properties> SHIMMER_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(ModFluidType.SHIMMER, SOURCE_SHIMMER, FLOWING_SHIMMER)
                    .block(ModBlocks.SHIMMER_BLOCK)
                    .bucket(ModItems.SHIMMER_BUCKET)
    );

    // LATEX
    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_LATEX = FLUIDS.register("latex",
            () -> new BaseFlowingFluid.Source(ModFluid.LATEX_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_LATEX = FLUIDS.register("latex_flow",
            () -> new BaseFlowingFluid.Flowing(ModFluid.LATEX_PROPERTIES.get()));

    private static final Supplier<BaseFlowingFluid.Properties> LATEX_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(ModFluidType.LATEX, SOURCE_LATEX, FLOWING_LATEX)
                    .block(ModBlocks.LATEX_BLOCK)
                    .bucket(ModItems.LATEX_BUCKET)
    );

    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_WARPED_LATEX = FLUIDS.register("warped_latex",
            () -> new BaseFlowingFluid.Source(ModFluid.WARPED_LATEX_PROPERTIES.get()));

    // WARPED LATEX
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_WARPED_LATEX = FLUIDS.register("warped_latex_flow",
            () -> new BaseFlowingFluid.Flowing(ModFluid.WARPED_LATEX_PROPERTIES.get()));

    private static final Supplier<BaseFlowingFluid.Properties> WARPED_LATEX_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(ModFluidType.WARPED_LATEX, SOURCE_WARPED_LATEX, FLOWING_WARPED_LATEX)
                    .block(ModBlocks.WARPED_LATEX_BLOCK)
                    .bucket(ModItems.WARPED_LATEX_BUCKET)
    );

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}