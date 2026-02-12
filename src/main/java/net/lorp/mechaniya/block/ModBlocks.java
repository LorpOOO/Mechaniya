package net.lorp.mechaniya.block;

import net.lorp.mechaniya.Mechaniya;
import net.lorp.mechaniya.fluid.ModFluid;
import net.lorp.mechaniya.item.ModItems; // Імпортуємо клас, а не поле
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Mechaniya.MOD_ID);

    public static final DeferredBlock<Block> ANDESITE_MACHINE = registerBlock("andesite_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> RUBBER_MACHINE = registerBlock("rubber_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.COPPER).noOcclusion()));

    public static final DeferredBlock<Block> BRASS_MACHINE = registerBlock("brass_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> END_PLATINUM_ORE = registerBlock("end_platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BLAZE_GOLD_BLOCK = registerBlock("blaze_gold_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> MITHRIL_BLOCK = registerSpecificBlock("mithril_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)),
            new Item.Properties().rarity(Rarity.RARE));

    public static final DeferredBlock<Block> SUPERCONDUCTOR_BLOCK = registerBlock("superconductor_block",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> HUPER_EXPERIENCE_BLOCK = registerSpecificBlock("huper_experience_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)),
            new Item.Properties().rarity(Rarity.EPIC));

    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> HEATPROOF_MACHINE = registerBlock("heatproof_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> DEEPSLATE_GRAVEL = registerBlock("deepslate_gravel",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ASURINE_GRAVEL = registerBlock("asurine_gravel",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> END_SAND = registerBlock("end_sand",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> VERIDIUM_GRAVEL = registerBlock("veridium_gravel",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> ZINC_MACHINE = registerBlock("zinc_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> DEEPLEETED_ASURINE = registerBlock("deepleeted_asurine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPLEETED_VERIDIUM = registerBlock("deepleeted_veridium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ENDER_MACHINE = registerBlock("ender_machine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> STEEL_MIX_BLOCK = registerBlock("steel_mix_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> BASIC_ENERGY_MACHINE = registerBlock("basic_energy_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> ADVANCED_ENERGY_MACHINE = registerBlock("advanced_energy_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> ELITE_ENERGY_MACHINE = registerBlock("elite_energy_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> ULTIMATE_ENERGY_MACHINE = registerBlock("ultimate_energy_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> ROCKET_MACHINE = registerBlock("rocket_machine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> ENDERIAM_ENERGY_MACHINE = registerBlock("enderiam_energy_machine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> RADIANT_MACHINE = registerBlock("radiant_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> SIMPLE_ENERGY_MACHINE = registerBlock("simple_energy_machine",
            () -> new ModFaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<LiquidBlock> SHIMMER_BLOCK = BLOCKS.register("shimmer_block",
            () -> new LiquidBlock(
                    ModFluid.SOURCE_SHIMMER.get(), // Перевірте, щоб тут було саме SOURCE
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WATER)
                            .noCollission()
                            .strength(100.0F)
                            .pushReaction(PushReaction.DESTROY)
                            .noLootTable()
                            .replaceable()
            ));

    public static final DeferredBlock<LiquidBlock> LATEX_BLOCK = BLOCKS.register("latex_block",
            () -> new LiquidBlock(
                    ModFluid.SOURCE_LATEX.get(),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOL)
                            .noCollission()
                            .strength(100.0F)
                            .pushReaction(PushReaction.DESTROY)
                            .noLootTable()
                            .replaceable()
            ));

    public static final DeferredBlock<LiquidBlock> WARPED_LATEX_BLOCK = BLOCKS.register("warped_latex_block",
            () -> new LiquidBlock(
                    ModFluid.SOURCE_WARPED_LATEX.get(),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_CYAN)
                            .noCollission()
                            .strength(100.0F)
                            .pushReaction(PushReaction.DESTROY)
                            .noLootTable()
                            .replaceable()
            ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerSpecificBlock(String name, Supplier<T> blockSupplier, Item.Properties itemProperties) {
        DeferredBlock<T> block = BLOCKS.register(name, blockSupplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
        return block;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}