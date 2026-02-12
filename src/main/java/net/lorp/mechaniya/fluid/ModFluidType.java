package net.lorp.mechaniya.fluid;

import net.lorp.mechaniya.Mechaniya;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Consumer;

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
                    .supportsBoating(true) // Дозволяє плавати на човнах
            ) {
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation STILL = ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "block/shimmer_still");
                        private static final ResourceLocation FLOW = ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "block/shimmer_flow");

                        @Override public ResourceLocation getStillTexture() { return STILL; }
                        @Override public ResourceLocation getFlowingTexture() { return FLOW; }
                    });
                }
            }
    );

    public static final DeferredHolder<FluidType, FluidType> LATEX = FLUID_TYPES.register("latex",
            () -> new FluidType(FluidType.Properties.create()
                    .density(5)
                    .canSwim(true)
                    .canDrown(true)
                    .canPushEntity(true)
                    .canHydrate(false)
                    .supportsBoating(true)
            ) {
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation STILL = ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "block/latex_still");
                        private static final ResourceLocation FLOW = ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "block/latex_flow");

                        @Override public ResourceLocation getStillTexture() { return STILL; }
                        @Override public ResourceLocation getFlowingTexture() { return FLOW; }
                    });
                }
            }
    );

    public static final DeferredHolder<FluidType, FluidType> WARPED_LATEX = FLUID_TYPES.register("warped_latex",
            () -> new FluidType(FluidType.Properties.create()
                    .density(5)
                    .canSwim(true)
                    .canDrown(true)
                    .canPushEntity(true)
                    .canHydrate(false)
                    .supportsBoating(true)
            ) {
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation STILL = ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "block/warped_latex_still");
                        private static final ResourceLocation FLOW = ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "block/warped_latex_flow");

                        @Override public ResourceLocation getStillTexture() { return STILL; }
                        @Override public ResourceLocation getFlowingTexture() { return FLOW; }
                    });
                }
            }
    );

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}