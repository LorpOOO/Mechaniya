package net.lorp.mechaniya.mixin;

import dev.ftb.mods.ftbultimine.CooldownTracker;
import net.lorp.mechaniya.Config;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CooldownTracker.class, remap = false)
public class CooldownTrackerMixin {

    @Inject(method = "getUltimineCooldown", at = @At("RETURN"), cancellable = true)
    private static void onGetUltimineCooldown(Player player, CallbackInfoReturnable<Long> cir) {
        long originalCooldown = cir.getReturnValue();
        if (originalCooldown <= 0) return;

        ItemStack stack = player.getMainHandItem();
        if (stack.isEmpty()) return;

        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(stack.getItem());

        if (Config.COOLDOWN_MAP.containsKey(itemId)) {
            float multiplier = Config.COOLDOWN_MAP.get(itemId);

            long newCooldown = (long) (originalCooldown * multiplier);
            cir.setReturnValue(newCooldown);
        }
    }
}