package net.lorp.mechaniya;

import com.mojang.logging.LogUtils;
import net.lorp.mechaniya.common.register.ModBlocks;
import net.lorp.mechaniya.common.register.ModFluid;
import net.lorp.mechaniya.common.register.ModFluidType;
import net.lorp.mechaniya.server.handler.ChatHandler;
import net.lorp.mechaniya.common.register.ModCreativeModeTabs;
import net.lorp.mechaniya.common.register.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

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
        modEventBus.addListener(this::onClientSetup);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(MechaniyaModClient::onRegisterClientExtensions);
        }
    }


    private void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Кажемо грі: "Ці блоки мають прозорі частини, не малюй їх чорним!"
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