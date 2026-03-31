package net.lorp.mechaniya.common.item;

import net.lorp.mechaniya.common.register.ModToolTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(modid = "mechaniya")
public class ModSmartTooltip {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        if (stack.getItem() instanceof TieredItem tieredItem) {
            var tier = tieredItem.getTier();
            if (tier == ModToolTiers.SUPER_EXPERIENCE_HEAP || tier == ModToolTiers.HYPER_EXPERIENCE_HEAP) {

                List<Component> tooltip = event.getToolTip();
                boolean isShiftPressed = Screen.hasShiftDown();

                ChatFormatting purple = ChatFormatting.DARK_PURPLE;
                ChatFormatting pink = ChatFormatting.LIGHT_PURPLE;

                MutableComponent shiftKey = Component.literal("[")
                        .append(Component.literal("Shift").withStyle(isShiftPressed ? ChatFormatting.WHITE : ChatFormatting.GRAY))
                        .append("]");

                tooltip.add(1, Component.translatable("tooltip.mechaniya.hold_shift", shiftKey).withStyle(ChatFormatting.DARK_GRAY));

                if (isShiftPressed) {
                    tooltip.add(2, Component.empty());

                    Component xpOrbs = Component.translatable("tooltip.mechaniya.xp_orbs").withStyle(pink);
                    Component mending = Component.translatable("tooltip.mechaniya.mending").withStyle(pink);

                    tooltip.add(3, Component.translatable("tooltip.mechaniya.summary_line1").withStyle(purple));
                    tooltip.add(4, Component.translatable("tooltip.mechaniya.summary_line2", xpOrbs).withStyle(purple));

                    String line3Key = "tooltip.mechaniya.summary_line3";
                    String line4Key = "tooltip.mechaniya.summary_line4";

                    if (Component.translatable(line4Key).getString().equals(line4Key)) {
                        tooltip.add(5, Component.translatable(line3Key, mending).withStyle(purple));
                    } else {
                        tooltip.add(5, Component.translatable(line3Key).withStyle(purple));
                        tooltip.add(6, Component.translatable(line4Key, mending).withStyle(purple));
                    }
                }
            }
        }
    }
}