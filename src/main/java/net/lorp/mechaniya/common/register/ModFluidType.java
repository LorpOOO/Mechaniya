package net.lorp.mechaniya.common.register;

import net.lorp.mechaniya.Mechaniya;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluidType {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Mechaniya.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> SHIMMER = FLUID_TYPES.register("shimmer",
            () -> new FluidType(FluidType.Properties.create()
                    .density(1)
                    .canSwim(true)
                    .canDrown(true)
                    .canPushEntity(true)
                    .canHydrate(false)
                    .supportsBoating(true)
            )

    );

    public static final DeferredHolder<FluidType, FluidType> LATEX = FLUID_TYPES.register("latex",
            () -> new FluidType(FluidType.Properties.create()
                    .density(5)
                    .canSwim(true)
                    .canDrown(true)
                    .canPushEntity(true)
                    .canHydrate(false)
                    .supportsBoating(true)
            )


    );

    public static final DeferredHolder<FluidType, FluidType> WARPED_LATEX = FLUID_TYPES.register("warped_latex",
            () -> new FluidType(FluidType.Properties.create()
                    .density(5)
                    .canSwim(true)
                    .canDrown(true)
                    .canPushEntity(true)
                    .canHydrate(false)
                    .supportsBoating(true)
            )

    );

    public static final DeferredHolder<FluidType, FluidType> PROPYLENE = FLUID_TYPES.register("propylene",
            () -> new FluidType(FluidType.Properties.create()
                    .density(1)
                    .canSwim(true)
                    .canDrown(true)
                    .canPushEntity(true)
                    .canHydrate(false)
                    .supportsBoating(true)
            )

    );

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}