package net.lorp.mechaniya.common.register;

import net.lorp.mechaniya.Mechaniya;
import net.lorp.mechaniya.common.block.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Mechaniya.MOD_ID);

    // --- Machine Casings & Bases ---
    public static final DeferredBlock<Block> ANDESITE_MACHINE = registerBlock("andesite_machine",
            () -> new CustomMachineBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4f).noOcclusion(),
                    MachineShapes.ANDESITE));

    public static final DeferredBlock<Block> SMALL_ANDESITE_CONTROLLER = registerBlock("small_andesite_controller",
            () -> new FaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> OIL_PIPE = registerBlock("oil_pipe",
            () -> new CustomMachineBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(4f).noOcclusion(), MachineShapes.OIL_PIPE));

    public static final DeferredBlock<Block> BRASS_MACHINE = registerBlock("brass_machine",
            () -> new CustomMachineBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(4f).noOcclusion(), MachineShapes.BRASS));

    public static final DeferredBlock<Block> ZINC_MACHINE = registerBlock("zinc_machine",
            () -> new CustomMachineBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(4f).requiresCorrectToolForDrops().noOcclusion(),
                    MachineShapes.ZINC));

    public static final DeferredBlock<Block> RUBBER_MACHINE = registerBlock("rubber_machine",
            () -> new CustomMachineBlock(BlockBehaviour.Properties.of()
                    .strength(4f).noOcclusion().requiresCorrectToolForDrops().sound(SoundType.COPPER), MachineShapes.RUBBER));

    public static final DeferredBlock<Block> HEATPROOF_MACHINE = registerBlock("heatproof_machine",
            () -> new CustomMachineBlock(BlockBehaviour.Properties.of()
                    .strength(4f).noOcclusion().requiresCorrectToolForDrops().sound(SoundType.METAL), MachineShapes.HEATPROOF));

    public static final DeferredBlock<Block> ENDER_MACHINE = registerBlock("ender_machine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredHolder<Block, AndesiteControllerBlock> ANDESITE_CONTROLLER =
            BLOCKS.register("andesite_controller",
                    () -> new AndesiteControllerBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(3.0f)
                            .noOcclusion()
                    ));



    public static final DeferredBlock<Block> ELECTRIC_MACHINE_BLOCK = registerBlock("electric_machine_block",
            () -> new FaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> RADIANT_MACHINE = registerBlock("radiant_machine",
            () -> new FaceBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    // --- Ores and Natural Resources ---
    public static final DeferredBlock<Block> END_PLATINUM_ORE = registerBlock("end_platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> OIL_DEPOSIT = registerBlock("oil_deposit",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_GRAVEL = registerBlock("deepslate_gravel",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> ASURINE_GRAVEL = registerBlock("asurine_gravel",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> VERIDIUM_GRAVEL = registerBlock("veridium_gravel",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> END_SAND = registerBlock("end_sand",
            () -> new ModFallingBlocks(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> DEPLETED_ASURINE = registerBlock("depleted_asurine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEPLETED_VERIDIUM = registerBlock("depleted_veridium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PARAFFIN_WAX_BLOCK = registerBlock("paraffin_wax_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f).sound(SoundType.CANDLE)));

    // --- Storage Blocks ---
    public static final DeferredBlock<Block> MITHRIL_BLOCK = registerSpecificBlock("mithril_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)),
            new Item.Properties().rarity(Rarity.RARE));

    public static final DeferredBlock<Block> BLAZE_GOLD_BLOCK = registerBlock("blaze_gold_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> ENTRO_PLATINUM_BLOCK = registerBlock("entro_platinum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> HYPER_EXPERIENCE_BLOCK = registerSpecificBlock("hyper_experience_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)),
            new Item.Properties().rarity(Rarity.EPIC));

    public static final DeferredBlock<Block> STEEL_MIX_BLOCK= registerBlock("steel_mix_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(4f).requiresCorrectToolForDrops().noOcclusion()
    ));

    public static final DeferredBlock<Block> COAL_COKE_BLOCK = registerBlock("coal_coke_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(4f).requiresCorrectToolForDrops().noOcclusion()
            ));

    // --- Special & Decorative ---
    public static final DeferredBlock<Block> TROPHY = registerBlock("trophy",
            () -> new CustomShapeBlock(
                    BlockBehaviour.Properties.of().noOcclusion(),
                    Block.box(4, 0, 4, 12, 14, 12)
            ));

    // --- Fluid Blocks ---
    public static final DeferredBlock<LiquidBlock> SHIMMER_BLOCK = BLOCKS.register("shimmer_block",
            () -> new LiquidBlock(ModFluid.SOURCE_SHIMMER.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_WHITE).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> LUBRICANT_BLOCK = BLOCKS.register("lubricant_block",
            () -> new LiquidBlock(ModFluid.SOURCE_LUBRICANT.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_PINK).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> CRUDE_OIL_BLOCK = BLOCKS.register("crude_oil_block",
            () -> new LiquidBlock(ModFluid.SOURCE_CRUDE_OIL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> LATEX_BLOCK = BLOCKS.register("latex_block",
            () -> new LiquidBlock(ModFluid.SOURCE_LATEX.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> WARPED_LATEX_BLOCK = BLOCKS.register("warped_latex_block",
            () -> new LiquidBlock(ModFluid.SOURCE_WARPED_LATEX.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> STEAM_CRACKED_FUEL_BLOCK = BLOCKS.register("steam_cracked_fuel_block",
            () -> new LiquidBlock(ModFluid.SOURCE_STEAM_CRACKED_FUEL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> SULFURIC_FUEL_BLOCK = BLOCKS.register("sulfuric_fuel_block",
            () -> new LiquidBlock(ModFluid.SOURCE_SULFURIC_FUEL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> FUEL_BLOCK = BLOCKS.register("fuel_block",
            () -> new LiquidBlock(ModFluid.SOURCE_FUEL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GOLD).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> OIL_FUEL_BLOCK = BLOCKS.register("oil_fuel_block",
            () -> new LiquidBlock(ModFluid.SOURCE_OIL_FUEL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> SUPER_GLUE_BLOCK = BLOCKS.register("super_glue_block",
            () -> new LiquidBlock(ModFluid.SOURCE_SUPER_GLUE.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_BLUE).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> ETHYLENE_BLOCK = BLOCKS.register("ethylene_block",
            () -> new LiquidBlock(ModFluid.SOURCE_ETHYLENE.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SNOW).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    public static final DeferredBlock<LiquidBlock> MOLTEN_PLASTIC_BLOCK = BLOCKS.register("molten_plastic_block",
            () -> new LiquidBlock(ModFluid.SOURCE_MOLTEN_PLASTIC.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.CLAY).noCollission().strength(100.0F)
                    .pushReaction(PushReaction.DESTROY).noLootTable().noOcclusion().replaceable()));

    // --- Sulfure ---
    public static final DeferredBlock<Block> RAW_SULFUR_BLOCK = BLOCKS.register("raw_sulfur_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.COLOR_YELLOW)
                    .strength(1.5F).sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> SULFUR_BLOCK = registerBlock("sulfur_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.STONE)));

    public static final DeferredBlock<BuddingAmethystBlock> BUDDING_SULFUR = BLOCKS.register("budding_sulfur",
            () -> new BuddingSulfurBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.COLOR_YELLOW)
                    .randomTicks().strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<AmethystClusterBlock> SMALL_SULFUR_BUD = registerSulfurCluster("small_sulfur_bud", 3, 4);
    public static final DeferredBlock<AmethystClusterBlock> MEDIUM_SULFUR_BUD = registerSulfurCluster("medium_sulfur_bud", 4, 3);
    public static final DeferredBlock<AmethystClusterBlock> LARGE_SULFUR_BUD = registerSulfurCluster("large_sulfur_bud", 5, 3);
    public static final DeferredBlock<AmethystClusterBlock> SULFUR_CLUSTER = registerSulfurCluster("sulfur_cluster", 7, 3);

    // --- Helper Methods ---
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

    private static DeferredBlock<AmethystClusterBlock> registerSulfurCluster(String name, int height, int width) {
        return BLOCKS.register(name, () -> new AmethystClusterBlock(height, width,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_YELLOW)
                        .forceSolidOn()
                        .noOcclusion()
                        .randomTicks()
                        .sound(SoundType.AMETHYST_CLUSTER)
                        .strength(1.5F)
                        .lightLevel((state) -> 3)
                        .pushReaction(PushReaction.DESTROY)));
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMALL_SULFUR_BUD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_SULFUR_BUD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LARGE_SULFUR_BUD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SULFUR_CLUSTER.get(), RenderType.cutout());
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}