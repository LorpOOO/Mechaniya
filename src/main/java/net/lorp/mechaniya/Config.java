package net.lorp.mechaniya;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.lorp.mechaniya.Mechaniya.LOGGER;


@EventBusSubscriber(modid = Mechaniya.MOD_ID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_COOLDOWNS;
    public static final ModConfigSpec.DoubleValue HEXADECIMAL_BOOST;
    public static final ModConfigSpec SPEC;

    public static final Map<ResourceLocation, Float> COOLDOWN_MAP = new HashMap<>();

    static {
        BUILDER.push("FTBUltimine Cooldown Settings");
        ITEM_COOLDOWNS = BUILDER
                .comment("Divide the value by what is indicated here")
                .defineListAllowEmpty("item_cooldowns",
                        List.of("mechaniya:portable_electric_drill;0"),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        BUILDER.pop();

        BUILDER.push("Capacitor Settings");
        HEXADECIMAL_BOOST = BUILDER
                .defineInRange("hexadecimal_boost", 4.0, 1.0, Float.MAX_VALUE);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    public static void parseConfig() {
        COOLDOWN_MAP.clear();
        for (String entry : ITEM_COOLDOWNS.get()) {
            String[] parts = entry.split(";");
            if (parts.length == 2) {
                try {
                    ResourceLocation itemId = ResourceLocation.parse(parts[0].trim());
                    float percent = Float.parseFloat(parts[1].trim());
                    COOLDOWN_MAP.put(itemId, percent / 100f);
                } catch (Exception e) {
                    LOGGER.info("No correct value for config: " + entry);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onConfigLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == Config.SPEC) {
            Config.parseConfig();
            LOGGER.info("Mechaniya config loaded");
        }
    }

    @SubscribeEvent
    public static void onConfigReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == Config.SPEC) {
            Config.parseConfig();
            LOGGER.info("Mechaniya config reloaded");
        }
    }
}