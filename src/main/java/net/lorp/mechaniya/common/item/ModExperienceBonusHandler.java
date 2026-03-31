package net.lorp.mechaniya.common.item;

import net.lorp.mechaniya.common.register.ModToolTiers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = "mechaniya")
public class ModExperienceBonusHandler {

    private static final double CHANCE = 0.3;
    private static final int BONUS_XP = 1;

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();

        if (isExperienceTool(stack)) {
            if (player.getRandom().nextDouble() < CHANCE) {
                spawnXpOrbs(event.getLevel() instanceof ServerLevel sl ? sl : null,
                        Vec3.atCenterOf(event.getPos()), BONUS_XP);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityKill(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            ItemStack stack = player.getMainHandItem();

            if (isExperienceTool(stack)) {
                if (player.getRandom().nextDouble() < CHANCE) {
                    spawnXpOrbs(event.getEntity().level() instanceof ServerLevel sl ? sl : null,
                            event.getEntity().position(), BONUS_XP + 2);
                }
            }
        }
    }

    private static void spawnXpOrbs(ServerLevel level, Vec3 pos, int amount) {
        if (level != null) {
            ExperienceOrb.award(level, pos, amount);
        }
    }

    @SubscribeEvent
    public static void onXPPickup(PlayerXpEvent.PickupXp event) {
        Player player = event.getEntity();
        int xpAmount = event.getOrb().getValue();

        repairExperienceTool(player.getMainHandItem(), xpAmount);
        repairExperienceTool(player.getOffhandItem(), xpAmount);
    }

    private static void repairExperienceTool(ItemStack stack, int xpAmount) {
        if (!stack.isEmpty() && isExperienceTool(stack) && stack.isDamaged()) {
            int repairAmount = xpAmount * 2;
            stack.setDamageValue(Math.max(0, stack.getDamageValue() - repairAmount));
        }
    }

    private static boolean isExperienceTool(ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof TieredItem tieredItem) {
            Tier tier = tieredItem.getTier();
            return tier == ModToolTiers.SUPER_EXPERIENCE_HEAP || tier == ModToolTiers.HYPER_EXPERIENCE_HEAP;
        }
        return false;
    }
}