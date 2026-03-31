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

    public static final DeferredHolder<FluidType, FluidType> LUBRICANT = FLUID_TYPES.register("lubricant",
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

    public static final DeferredHolder<FluidType, FluidType> CRUDE_OIL = FLUID_TYPES.register("crude_oil",
            () -> new FluidType(FluidType.Properties.create()
                    .motionScale(0.002)
                    .viscosity(5000)
                    .density(2000)
                    .canSwim(false)
                    .canDrown(true)
                    .canPushEntity(true)
                    .canHydrate(false)
                    .supportsBoating(true)
            )
    );

    public static final DeferredHolder<FluidType, FluidType> STEAM_CRACKED_FUEL = FLUID_TYPES.register("steam_cracked_fuel",
            () -> new FluidType(FluidType.Properties.create()
                    .motionScale(0.007)
                    .viscosity(1000)
                    .density(800)
                    .canSwim(false)
                    .canDrown(true)
                    .canPushEntity(true)
                    .supportsBoating(true))
    );

    public static final DeferredHolder<FluidType, FluidType> SULFURIC_FUEL = FLUID_TYPES.register("sulfuric_fuel",
            () -> new FluidType(FluidType.Properties.create()
                    .motionScale(0.005)
                    .viscosity(2000)
                    .density(1200)
                    .canSwim(false)
                    .canDrown(true)
                    .canPushEntity(true)
                    .supportsBoating(true))
    );

    public static final DeferredHolder<FluidType, FluidType> FUEL = FLUID_TYPES.register("fuel",
            () -> new FluidType(FluidType.Properties.create()
                    .motionScale(0.008)
                    .viscosity(800)
                    .density(700)
                    .canSwim(false)
                    .canDrown(true)
                    .canPushEntity(true)
                    .supportsBoating(true))
    );

    public static final DeferredHolder<FluidType, FluidType> OIL_FUEL = FLUID_TYPES.register("oil_fuel",
            () -> new FluidType(FluidType.Properties.create()
                    .motionScale(0.004)
                    .viscosity(4000)
                    .density(1500)
                    .canSwim(false)
                    .canDrown(true)
                    .canPushEntity(true)
                    .supportsBoating(true))
    );

    public static final DeferredHolder<FluidType, FluidType> ETHYLENE = FLUID_TYPES.register("ethylene",
            () -> new FluidType(FluidType.Properties.create()
                    .motionScale(0.01)
                    .viscosity(200)
                    .density(500)
                    .canSwim(false)
                    .canDrown(true)
                    .canPushEntity(true)
                    .supportsBoating(false))
    );

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_PLASTIC = FLUID_TYPES.register("molten_plastic",
            () -> new FluidType(FluidType.Properties.create()
                    .motionScale(0.001)
                    .viscosity(8000)
                    .density(3000)
                    .canSwim(false)
                    .canDrown(true)
                    .canPushEntity(true)
                    .supportsBoating(false))
    );

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}