package net.lorp.mechaniya.common.register;

import net.lorp.mechaniya.Mechaniya;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mechaniya.MOD_ID);

    @SuppressWarnings("all")
    public static final Supplier<CreativeModeTab> MECHANIYA_TAB = CREATIVE_MODE_TAB.register("mechaniya_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OVERCHARGED_RAW_LAPIS_LAZULI_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.mechaniya.mechaniya_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Кубок
                        output.accept(ModBlocks.TROPHY.get());
                        // Механізми
                        output.accept(ModItems.CERTUS_QUARTZ_TUBE.get());

                        // Корпуси машин
                        output.accept(ModBlocks.ANDESITE_MACHINE.get());
                        output.accept(ModBlocks.BRASS_MACHINE.get());
                        output.accept(ModBlocks.ZINC_MACHINE.get());
                        output.accept(ModBlocks.RUBBER_MACHINE.get());
                        output.accept(ModBlocks.HEATPROOF_MACHINE.get());
                        output.accept(ModBlocks.ENDER_MACHINE.get());
                        output.accept(ModBlocks.RADIANT_MACHINE.get());

                        // Незавершені штуки
                        output.accept(ModItems.INCOMPLETE_DENSE_FABRIC.get());


                        // Руди та гравій
                        output.accept(ModBlocks.END_PLATINUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_GRAVEL.get());
                        output.accept(ModBlocks.VERIDIUM_GRAVEL.get());
                        output.accept(ModBlocks.ASURINE_GRAVEL.get());
                        output.accept(ModBlocks.DEEPLEETED_VERIDIUM.get());
                        output.accept(ModBlocks.DEEPLEETED_ASURINE.get());
                        output.accept(ModBlocks.END_SAND.get());

                        // Метали та сплави
                        output.accept(ModItems.MITHRIL_INGOT.get());
                        output.accept(ModItems.MITHRIL_SHEET.get());
                        output.accept(ModItems.MITHRIL_NUGGET.get());
                        output.accept(ModBlocks.MITHRIL_BLOCK.get());
                        output.accept(ModItems.BLAZE_GOLD_INGOT.get());
                        output.accept(ModItems.BLAZE_GOLD_SHEET.get());
                        output.accept(ModItems.BLAZE_GOLD_NUGGET.get());
                        output.accept(ModBlocks.BLAZE_GOLD_BLOCK.get());
                        output.accept(ModItems.ENDERIUM_INGOT.get());
                        output.accept(ModItems.SUPER_EXPERIENCE_HEAP.get());
                        output.accept(ModItems.HUPER_EXPERIENCE_HEAP.get());
                        output.accept(ModItems.HUPER_EXPERIENCE_NUGGET.get());
                        output.accept(ModBlocks.HUPER_EXPERIENCE_BLOCK.get());
                        output.accept(ModItems.OVERCHARGED_ALLOY.get());
                        output.accept(ModItems.RAW_PLATINUM_NUGGET.get());

                        // Кристали та спец. ресурси
                        output.accept(ModItems.RAW_LAPIS_LAZULI_CRYSTAL.get());
                        output.accept(ModItems.POLISHED_LAPIS_LAZULI_CRYSTAL.get());
                        output.accept(ModItems.OVERCHARGED_RAW_LAPIS_LAZULI_CRYSTAL.get());
                        output.accept(ModItems.RADIANT_ROD.get());
                        output.accept(ModItems.RADIANT_SHEET.get());
                        output.accept(ModItems.ENTRO_PLATINUM_INGOT.get());
                        output.accept(ModBlocks.ENTRO_PLATINUM_BLOCK.get());
                        output.accept(ModItems.DENSE_FABRIC.get());

                        // Гума
                        output.accept(ModItems.WARPED_RUBBER.get());
                        output.accept(ModItems.CURED_WARPED_RUBBER.get());

                        // Відра з рідинами
                        output.accept(ModItems.LATEX_BUCKET.get());
                        output.accept(ModItems.WARPED_LATEX_BUCKET.get());
                        output.accept(ModItems.SHIMMER_BUCKET.get());
                        output.accept(ModItems.CRUDE_OIL_BUCKET.get());

                        // Інше
                        output.accept(ModItems.LEDOK.get());
                        output.accept(ModItems.ROLL_OF_ROLLS.get());
                        output.accept(ModItems.MINESTAR_LOGO.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}