package net.lorp.mechaniya;

import com.mojang.logging.LogUtils;
import net.lorp.mechaniya.common.item.ElectricDrillItem;
import net.lorp.mechaniya.common.register.ModBlocks;
import net.lorp.mechaniya.common.register.ModFluid;
import net.lorp.mechaniya.common.register.ModFluidType;
import net.lorp.mechaniya.server.handler.ChatHandler;
import net.lorp.mechaniya.common.register.ModCreativeModeTabs;
import net.lorp.mechaniya.common.register.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(Mechaniya.MOD_ID)
public class Mechaniya {
    public static final String MOD_ID = "mechaniya";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Mechaniya(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(ChatHandler.class);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFluidType.register(modEventBus);
        ModFluid.register(modEventBus);

        modEventBus.addListener(this::registerCapabilities);

        modEventBus.addListener(this::onClientSetup);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(MechaniyaModClient::onRegisterClientExtensions);
        }
    }

    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(Capabilities.EnergyStorage.ITEM, (stack, context) -> {
            return new EnergyStorage(ElectricDrillItem.ENERGY_CAPACITY) {
                @Override
                public int getEnergyStored() {
                    return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
                            .getUnsafe().getInt("energy");
                }

                @Override
                public int getMaxEnergyStored() {
                    return ElectricDrillItem.ENERGY_CAPACITY;
                }

                @Override
                public int receiveEnergy(int maxReceive, boolean simulate) {
                    int stored = getEnergyStored();
                    int toReceive = Math.min(getMaxEnergyStored() - stored, maxReceive);

                    if (!simulate && toReceive > 0) {
                        int newEnergy = stored + toReceive;
                        stack.update(DataComponents.CUSTOM_DATA, CustomData.EMPTY, customData ->
                                customData.update(tag -> tag.putInt("energy", newEnergy)));
                    }
                    return toReceive;
                }

                @Override
                public int extractEnergy(int maxExtract, boolean simulate) {
                    return 0; // Тільки споживаємо
                }

                @Override
                public boolean canExtract() {
                    return false;
                }

                @Override
                public boolean canReceive() {
                    return true;
                }
            };
        }, ModItems.PORTABLE_ELECTRIC_DRILL.get());
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMALL_SULFUR_BUD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_SULFUR_BUD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LARGE_SULFUR_BUD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SULFUR_CLUSTER.get(), RenderType.cutout());
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}