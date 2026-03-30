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


    private static final Supplier<BaseFlowingFluid.Properties> CRUDE_OIL_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.CRUDE_OIL,
                    ModFluid.SOURCE_CRUDE_OIL,
                    ModFluid.FLOWING_CRUDE_OIL
            )
                    .block(ModBlocks.CRUDE_OIL_BLOCK)
                    .bucket(ModItems.CRUDE_OIL_BUCKET)
    );

    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_CRUDE_OIL = FLUIDS.register("crude_oil",
            () -> new BaseFlowingFluid.Source(CRUDE_OIL_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_CRUDE_OIL = FLUIDS.register("crude_oil_flow",
            () -> new BaseFlowingFluid.Flowing(CRUDE_OIL_PROPERTIES.get()));


    private static final Supplier<BaseFlowingFluid.Properties> STEAM_CRACKED_FUEL_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.STEAM_CRACKED_FUEL,
                    ModFluid.SOURCE_STEAM_CRACKED_FUEL,
                    ModFluid.FLOWING_STEAM_CRACKED_FUEL)
                    .block(ModBlocks.STEAM_CRACKED_FUEL_BLOCK)
                    .bucket(ModItems.STEAM_CRACKED_FUEL_BUCKET)
    );
    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_STEAM_CRACKED_FUEL = FLUIDS.register("steam_cracked_fuel",
            () -> new BaseFlowingFluid.Source(STEAM_CRACKED_FUEL_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_STEAM_CRACKED_FUEL = FLUIDS.register("steam_cracked_fuel_flow",
            () -> new BaseFlowingFluid.Flowing(STEAM_CRACKED_FUEL_PROPERTIES.get()));


    private static final Supplier<BaseFlowingFluid.Properties> SULFURIC_FUEL_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.SULFURIC_FUEL,
                    ModFluid.SOURCE_SULFURIC_FUEL,
                    ModFluid.FLOWING_SULFURIC_FUEL)
                    .block(ModBlocks.SULFURIC_FUEL_BLOCK)
                    .bucket(ModItems.SULFURIC_FUEL_BUCKET)
    );
    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_SULFURIC_FUEL = FLUIDS.register("sulfuric_fuel",
            () -> new BaseFlowingFluid.Source(SULFURIC_FUEL_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_SULFURIC_FUEL = FLUIDS.register("sulfuric_fuel_flow",
            () -> new BaseFlowingFluid.Flowing(SULFURIC_FUEL_PROPERTIES.get()));


    private static final Supplier<BaseFlowingFluid.Properties> FUEL_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.FUEL,
                    ModFluid.SOURCE_FUEL,
                    ModFluid.FLOWING_FUEL)
                    .block(ModBlocks.FUEL_BLOCK)
                    .bucket(ModItems.FUEL_BUCKET)
    );
    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_FUEL = FLUIDS.register("fuel",
            () -> new BaseFlowingFluid.Source(FUEL_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_FUEL = FLUIDS.register("fuel_flow",
            () -> new BaseFlowingFluid.Flowing(FUEL_PROPERTIES.get()));


    private static final Supplier<BaseFlowingFluid.Properties> OIL_FUEL_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.OIL_FUEL,
                    ModFluid.SOURCE_OIL_FUEL,
                    ModFluid.FLOWING_OIL_FUEL)
                    .block(ModBlocks.OIL_FUEL_BLOCK)
                    .bucket(ModItems.OIL_FUEL_BUCKET)
    );
    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_OIL_FUEL = FLUIDS.register("oil_fuel",
            () -> new BaseFlowingFluid.Source(OIL_FUEL_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_OIL_FUEL = FLUIDS.register("oil_fuel_flow",
            () -> new BaseFlowingFluid.Flowing(OIL_FUEL_PROPERTIES.get()));


    private static final Supplier<BaseFlowingFluid.Properties> ETHYLENE_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.ETHYLENE,
                    ModFluid.SOURCE_ETHYLENE,
                    ModFluid.FLOWING_ETHYLENE)
                    .block(ModBlocks.ETHYLENE_BLOCK)
                    .bucket(ModItems.ETHYLENE_BUCKET)
    );
    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_ETHYLENE = FLUIDS.register("ethylene",
            () -> new BaseFlowingFluid.Source(ETHYLENE_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_ETHYLENE = FLUIDS.register("ethylene_flow",
            () -> new BaseFlowingFluid.Flowing(ETHYLENE_PROPERTIES.get()));


    private static final Supplier<BaseFlowingFluid.Properties> MOLTEN_PLASTIC_PROPERTIES = Suppliers.memoize(() ->
            new BaseFlowingFluid.Properties(
                    ModFluidType.MOLTEN_PLASTIC,
                    ModFluid.SOURCE_MOLTEN_PLASTIC,
                    ModFluid.FLOWING_MOLTEN_PLASTIC)
                    .block(ModBlocks.MOLTEN_PLASTIC_BLOCK)
                    .bucket(ModItems.MOLTEN_PLASTIC_BUCKET)
    );
    public static final DeferredHolder<Fluid, BaseFlowingFluid> SOURCE_MOLTEN_PLASTIC = FLUIDS.register("molten_plastic",
            () -> new BaseFlowingFluid.Source(MOLTEN_PLASTIC_PROPERTIES.get()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_MOLTEN_PLASTIC = FLUIDS.register("molten_plastic_flow",
            () -> new BaseFlowingFluid.Flowing(MOLTEN_PLASTIC_PROPERTIES.get()));


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}