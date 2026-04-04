package net.lorp.mechaniya.client.models.blocks.andesite_controller;

import net.lorp.mechaniya.common.block.AndesiteControllerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import static net.lorp.mechaniya.Mechaniya.MOD_ID;

public class AndesiteControllerModel extends GeoModel<AndesiteControllerBlockEntity> {
    @Override
    public ResourceLocation getModelResource(AndesiteControllerBlockEntity andesiteControllerBlock) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "geo/andesite_controller.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AndesiteControllerBlockEntity andesiteControllerBlock) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/block/andesite_controller.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AndesiteControllerBlockEntity andesiteControllerBlock) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "animations/empty.animation.json");
    }
}
