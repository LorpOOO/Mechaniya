package net.lorp.mechaniya.common.register;

import net.lorp.mechaniya.Mechaniya;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SUPER_EXPERIENCE_TOOL = createTag("needs_super_experience_tool");
        public static final TagKey<Block> INCORRECT_FOR_SUPER_EXPEREINCE_TOOL = createTag("incorrect_for_super_experience_tool");

        public static final TagKey<Block> NEEDS_HYPER_EXPERIENCE_TOOL = createTag("needs_hyper_experience_tool");
        public static final TagKey<Block> INCORRECT_FOR_HYPER_EXPEREINCE_TOOL = createTag("incorrect_for_hyper_experience_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, name));
        }
    }
}