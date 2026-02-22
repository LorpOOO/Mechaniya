package net.lorp.mechaniya.common.register;

import net.lorp.mechaniya.Mechaniya;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemLore;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mechaniya.MOD_ID);

    public static final DeferredItem<Item> NETHERITE_ENERGY_MECHANISM = ITEMS.register("netherite_energy_mechanism",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> RAW_PLATINUM_NUGGET = ITEMS.register("raw_platinum_nugget",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> DENSE_FABRIC = ITEMS.register("dense_fabric",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> INCOMPLETE_DENSE_FABRIC = ITEMS.register("incomplete_dense_fabric",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> STEEL_MECHANISM = ITEMS.register("steel_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAINBOW_ALLOY = ITEMS.register("rainbow_alloy",
            () -> new Item(new Item.Properties()
                    .fireResistant()
                    .component(DataComponents.RARITY, Rarity.EPIC)
                    .component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.lore_rainbow_alloy"))))));

    public static final DeferredItem<Item> INCOMPLETE_STEEL_MECHANISM = ITEMS.register("incomplete_steel_mechanism",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> SUPERCONDUCTOR_SHEET = ITEMS.register("superconductor_sheet",
            () -> new Item(new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final DeferredItem<Item> SUPERCONDUCTOR_INGOT = ITEMS.register("superconductor_ingot",
            () -> new Item(new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final DeferredItem<Item> SUPERCONDUCTOR_WIRE = ITEMS.register("superconductor_wire",
            () -> new Item(new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final DeferredItem<Item> SUPERCONDUCTOR_NUGGET = ITEMS.register("superconductor_nugget",
            () -> new Item(new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    public static final DeferredItem<Item> ENRICHED_BLAZE = ITEMS.register("enriched_blaze",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OVERCHARGED_RAW_LAPIS_LAZULI_CRYSTAL = ITEMS.register("overcharged_raw_lapis_lazuli_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_LAPIS_LAZULI_CRYSTAL = ITEMS.register("raw_lapis_lazuli_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OVERCHARGED_ALLOY = ITEMS.register("overcharged_alloy",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE)));
    public static final DeferredItem<Item> OSMIUM_SHEET = ITEMS.register("osmium_sheet",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_ELITE_CONTROL_CIRCUIT = ITEMS.register("incomplete_elite_control_circuit",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_ADVANCED_CONTROL_CIRCUIT = ITEMS.register("incomplete_advanced_control_circuit",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_ULTIMATE_CONTROL_CIRCUIT = ITEMS.register("incomplete_ultimate_control_circuit",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_BASIC_CONTROL_CIRCUIT = ITEMS.register("incomplete_basic_control_circuit",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SUPER_EXPERIENCE_HEAP = ITEMS.register("super_experience_heap",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.RARE)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final DeferredItem<Item> HUPER_EXPERIENCE_HEAP = ITEMS.register("huper_experience_heap",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.EPIC)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final DeferredItem<Item> HUPER_EXPERIENCE_NUGGET = ITEMS.register("huper_experience_nugget",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.EPIC)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    public static final DeferredItem<Item> BLAZE_GOLD_SHEET = ITEMS.register("blaze_gold_sheet",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.UNCOMMON)));
    public static final DeferredItem<Item> BLAZE_GOLD_INGOT = ITEMS.register("blaze_gold_ingot",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.UNCOMMON)));
    public static final DeferredItem<Item> BLAZE_GOLD_NUGGET = ITEMS.register("blaze_gold_nugget",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.UNCOMMON)));

    public static final DeferredItem<Item> SHIMMER_BUCKET = ITEMS.register("shimmer_bucket",
            () -> new BucketItem(ModFluid.SOURCE_SHIMMER.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                            .component(DataComponents.RARITY, Rarity.EPIC)));

    public static final DeferredItem<Item> LATEX_BUCKET = ITEMS.register("latex_bucket",
            () -> new BucketItem(ModFluid.SOURCE_LATEX.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredItem<Item> WARPED_LATEX_BUCKET = ITEMS.register("warped_latex_bucket",
            () -> new BucketItem(ModFluid.SOURCE_WARPED_LATEX.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredItem<Item> MITHRIL_SHEET = ITEMS.register("mithril_sheet",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE)));
    public static final DeferredItem<Item> MITHRIL_NUGGET = ITEMS.register("mithril_nugget",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE)));
    public static final DeferredItem<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE)));

    public static final DeferredItem<Item> STEEL_MIX = ITEMS.register("steel_mix",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_LAPIS_LAZULI_CRYSTAL = ITEMS.register("polished_lapis_lazuli_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WARPED_RUBBER = ITEMS.register("warped_rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CURED_WARPED_RUBBER = ITEMS.register("cured_warped_rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENRICHED_ZINC = ITEMS.register("enriched_zinc",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_NETHERITE_ENERGY_MECHANISM = ITEMS.register("incomplete_netherite_energy_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CERTUS_QUARTZ_TUBE = ITEMS.register("certus_quartz_tube",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MINESTAR_LOGO = ITEMS.register("minestar_logo",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.EPIC)
                    .component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.lore_minestar_logo"))))));

    public static final DeferredItem<Item> RADIANT_ROD = ITEMS.register("radiant_rod",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.UNCOMMON)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    public static final DeferredItem<Item> ROLL_OF_ROLLS = ITEMS.register("roll_of_rolls",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(25).saturationModifier(9.9f)
                            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 2), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6000, 2), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 300, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 6000, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)
                            .fast().build())
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .component(DataComponents.RARITY, Rarity.EPIC)
                    .component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.lore_roll_of_rolls"))))));

    public static final DeferredItem<Item> RADIANT_SHEET = ITEMS.register("radiant_sheet",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.UNCOMMON)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    public static final DeferredItem<Item> LEDOK = ITEMS.register("ledok",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(25).saturationModifier(9.9f)
                            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 6000, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 6000, 3), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 6000, 2), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 3), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 6000, 2), 1.0f)
                            .fast().build())
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .component(DataComponents.RARITY, Rarity.RARE)
                    .component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.lore_ledok"))))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}