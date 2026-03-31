package net.lorp.mechaniya.common.register;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier SUPER_EXPERIENCE_HEAP = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SUPER_EXPEREINCE_TOOL,
            540, 10f, 3.5f, 32, () -> Ingredient.of(ModItems.SUPER_EXPERIENCE_HEAP));

    public static final Tier HYPER_EXPERIENCE_HEAP = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_HYPER_EXPEREINCE_TOOL,
            1080, 20f, 6f, 36, () -> Ingredient.of(ModItems.HYPER_EXPERIENCE_HEAP));

}