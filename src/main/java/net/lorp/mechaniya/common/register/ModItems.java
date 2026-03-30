package net.lorp.mechaniya.common.register;

import net.lorp.mechaniya.Mechaniya;
import net.lorp.mechaniya.common.item.ParaffinWaxItem;
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

    // --- Special & Logos ---
    public static final DeferredItem<Item> MINESTAR_LOGO = ITEMS.register("minestar_logo",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.EPIC)
                    .component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.lore_minestar_logo"))))));

    // --- Metals: Mithril ---
    public static final DeferredItem<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE)));
    public static final DeferredItem<Item> MITHRIL_SHEET = ITEMS.register("mithril_sheet",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE)));
    public static final DeferredItem<Item> MITHRIL_NUGGET = ITEMS.register("mithril_nugget",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE)));

    // --- Metals: Blaze Gold ---
    public static final DeferredItem<Item> BLAZE_GOLD_INGOT = ITEMS.register("blaze_gold_ingot",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.UNCOMMON)));
    public static final DeferredItem<Item> BLAZE_GOLD_SHEET = ITEMS.register("blaze_gold_sheet",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.UNCOMMON)));
    public static final DeferredItem<Item> BLAZE_GOLD_NUGGET = ITEMS.register("blaze_gold_nugget",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.UNCOMMON)));

    // --- Metals: Platinum & Radiant ---
    public static final DeferredItem<Item> ENTRO_PLATINUM_INGOT = ITEMS.register("entro_platinum_ingot",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> RAW_PLATINUM_NUGGET = ITEMS.register("raw_platinum_nugget",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> RADIANT_ROD = ITEMS.register("radiant_rod",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.UNCOMMON)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final DeferredItem<Item> RADIANT_SHEET = ITEMS.register("radiant_sheet",
            () -> new Item(new Item.Properties()
                    .component(DataComponents.RARITY, Rarity.UNCOMMON)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    // --- Alloys & Other Metals ---
    public static final DeferredItem<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OVERCHARGED_ALLOY = ITEMS.register("overcharged_alloy",
            () -> new Item(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE)));

    // --- Experience Materials ---
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

    // --- Technical Components ---
    public static final DeferredItem<Item> CERTUS_QUARTZ_TUBE = ITEMS.register("certus_quartz_tube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DENSE_FABRIC = ITEMS.register("dense_fabric",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> INCOMPLETE_DENSE_FABRIC = ITEMS.register("incomplete_dense_fabric",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> WARPED_RUBBER = ITEMS.register("warped_rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CURED_WARPED_RUBBER = ITEMS.register("cured_warped_rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLASTIC_SHEET = ITEMS.register("plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BITUMEN = ITEMS.register("bitumen",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OIL_FUEL_BALL = ITEMS.register("oil_fuel_ball",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SULFUR_DUST = ITEMS.register("sulfur_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PARAFFIN_WAX = ITEMS.register("paraffin_wax",
            () -> new ParaffinWaxItem(new Item.Properties()));

    // --- Buckets ---
    public static final DeferredItem<Item> CRUDE_OIL_BUCKET = ITEMS.register("crude_oil_bucket",
            () -> new BucketItem(ModFluid.SOURCE_CRUDE_OIL.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> LATEX_BUCKET = ITEMS.register("latex_bucket",
            () -> new BucketItem(ModFluid.SOURCE_LATEX.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> WARPED_LATEX_BUCKET = ITEMS.register("warped_latex_bucket",
            () -> new BucketItem(ModFluid.SOURCE_WARPED_LATEX.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> SHIMMER_BUCKET = ITEMS.register("shimmer_bucket",
            () -> new BucketItem(ModFluid.SOURCE_SHIMMER.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> STEAM_CRACKED_FUEL_BUCKET = ITEMS.register("steam_cracked_fuel_bucket",
            () -> new BucketItem(ModFluid.SOURCE_STEAM_CRACKED_FUEL.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> SULFURIC_FUEL_BUCKET = ITEMS.register("sulfuric_fuel_bucket",
            () -> new BucketItem(ModFluid.SOURCE_SULFURIC_FUEL.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> FUEL_BUCKET = ITEMS.register("fuel_bucket",
            () -> new BucketItem(ModFluid.SOURCE_FUEL.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> OIL_FUEL_BUCKET = ITEMS.register("oil_fuel_bucket",
            () -> new BucketItem(ModFluid.SOURCE_OIL_FUEL.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> ETHYLENE_BUCKET = ITEMS.register("ethylene_bucket",
            () -> new BucketItem(ModFluid.SOURCE_ETHYLENE.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> MOLTEN_PLASTIC_BUCKET = ITEMS.register("molten_plastic_bucket",
            () -> new BucketItem(ModFluid.SOURCE_MOLTEN_PLASTIC.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    // --- Food & Consumables ---
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