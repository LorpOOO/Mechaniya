package net.lorp.mechaniya.handler;

import dev.ftb.mods.ftbessentials.util.FTBEPlayerData;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.ServerChatEvent;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static net.lorp.mechaniya.Mechaniya.LOGGER;

@SuppressWarnings("all")
public class ChatHandler {

    private static final char GLOBAL_PREFIX = '!';
    private static final double LOCAL_RADIUS = 50.0;
    private static final double LOCAL_RADIUS_SQUARED = LOCAL_RADIUS * LOCAL_RADIUS;

    @SubscribeEvent
    public static void onServerChat(ServerChatEvent event) {
        try {

            ServerPlayer sender = event.getPlayer();
            String rawMessage = event.getRawText().trim();

            if (rawMessage.isEmpty()) {
                return;
            }

            boolean isMuted = FTBEPlayerData.getOrCreate(sender)
                    .map(FTBEPlayerData::isMuted)
                    .orElse(false);

            if(isMuted) {
                event.setCanceled(true);
                Component messageMute = Component.literal("§cВи в муті.");
                sender.sendSystemMessage(messageMute);

                return;
            }

            event.setCanceled(true);

            if (rawMessage.charAt(0) == GLOBAL_PREFIX) {
                handleGlobalChat(sender, rawMessage);
            } else {
                handleLocalChat(sender, rawMessage);
            }

        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred in the chat handler:", e);
        }
    }

    private static void handleGlobalChat(ServerPlayer sender, String rawMessage) {
        String content = rawMessage.substring(1).trim();
        MinecraftServer server = sender.getServer();

        if (server == null) {
            LOGGER.error("Could not handle global chat: Server instance was null for player {}.", sender.getGameProfile().getName());
            return;
        }

        if (content.isEmpty()) {
            sender.sendSystemMessage(Component.literal("Порожнє глобальне повідомлення.").withStyle(ChatFormatting.RED));
            logGlobal(sender, content, List.of());
            return;
        }

        Component messageComponent = Component.literal("")
                .append(sender.getDisplayName())
                .append(Component.literal(": ").withStyle(ChatFormatting.WHITE))
                .append(Component.literal(content).withStyle(ChatFormatting.WHITE));

        List<ServerPlayer> recipients = server.getPlayerList().getPlayers();
        recipients.forEach(player -> player.sendSystemMessage(messageComponent));

        logGlobal(sender, content, recipients);
    }

    private static void handleLocalChat(ServerPlayer sender, String content) {
        MinecraftServer server = sender.getServer();

        if (server == null) {
            LOGGER.error("Could not handle local chat: Server instance was null for player {}.", sender.getGameProfile().getName());
            return;
        }

        List<ServerPlayer> nearbyPlayers = server.getPlayerList().getPlayers().stream()
                .filter(player -> player.level().dimension().equals(sender.level().dimension()))
                .filter(player -> player.distanceToSqr(sender) <= LOCAL_RADIUS_SQUARED)
                .collect(Collectors.toList());

        if (nearbyPlayers.size() <= 1) {
            Component noFoundNearbyPlayers = Component.literal("§7Вас ніхто не чує. Постав §r§f!§r§7 на початку, щоб написати в глобальний чат.");

            sender.sendSystemMessage(noFoundNearbyPlayers);

            logLocalNobody(sender, content);
            return;
        }

        Component messageComponent = Component.literal("")
                .append(sender.getDisplayName())
                .append(Component.literal(": ").withStyle(ChatFormatting.GRAY))
                .append(Component.literal(content).withStyle(ChatFormatting.GRAY));

        nearbyPlayers.forEach(player -> player.sendSystemMessage(messageComponent));

        logLocal(sender, content, nearbyPlayers);
    }


    private static void logGlobal(ServerPlayer sender, String message, List<ServerPlayer> recipients) {
        String recList = recipients.stream().map(p -> p.getGameProfile().getName()).collect(Collectors.joining(", "));
        if (recList.isEmpty()) recList = "none";
        Vec3 pos = sender.position();

        String logMessage = String.format(Locale.US, "[GLOBAL] %s (%s) @%s pos=%.1f %.1f %.1f -> \"%s\" recipients=[%s]",
                sender.getGameProfile().getName(), sender.getUUID(), sender.level().dimension().location(),
                pos.x, pos.y, pos.z, message, recList);
        LOGGER.info(logMessage);
    }

    private static void logLocal(ServerPlayer sender, String message, List<ServerPlayer> recipients) {
        String recList = recipients.stream().map(p -> p.getGameProfile().getName()).collect(Collectors.joining(", "));
        Vec3 pos = sender.position();

        String logMessage = String.format(Locale.US, "[LOCAL] %s (%s) @%s pos=%.1f %.1f %.1f -> \"%s\" recipients=[%s]",
                sender.getGameProfile().getName(), sender.getUUID(), sender.level().dimension().location(),
                pos.x, pos.y, pos.z, message, recList);
        LOGGER.info(logMessage);
    }

    private static void logLocalNobody(ServerPlayer sender, String message) {
        Vec3 pos = sender.position();

        String logMessage = String.format(Locale.US, "[LOCAL] %s (%s) @%s pos=%.1f %.1f %.1f -> \"%s\" NOBODY_HEARD",
                sender.getGameProfile().getName(), sender.getUUID(), sender.level().dimension().location(),
                pos.x, pos.y, pos.z, message);
        LOGGER.info(logMessage);
    }
}
