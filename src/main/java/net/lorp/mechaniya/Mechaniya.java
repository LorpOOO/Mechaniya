package net.lorp.mechaniya;

import com.mojang.logging.LogUtils;
import net.lorp.mechaniya.block.ModBlocks;
import net.lorp.mechaniya.fluid.ModFluid;
import net.lorp.mechaniya.fluid.ModFluidType;
import net.lorp.mechaniya.handler.ChatHandler;
import net.lorp.mechaniya.item.ModCreativeModeTabs;
import net.lorp.mechaniya.item.ModItems;
import net.lorp.mechaniya.chemical.MechaniyaChemicals;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
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
        MechaniyaChemicals.CHEMICALS.register(modEventBus);
        ModFluidType.register(modEventBus);
        ModFluid.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(MechaniyaModClient::onRegisterClientExtensions);
        }
    }

    @SuppressWarnings("all")
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.OVERCHARGED_RAW_LAPIS_LAZULI_CRYSTAL);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}