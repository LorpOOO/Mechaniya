package net.lorp.mechaniya.client.models.andesite_controller;

import net.lorp.mechaniya.Mechaniya;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import software.bernie.geckolib.model.GeoModel;

public class AndesiteControllerModel extends GeoModel<AndesiteControllerBlock> {
    @Override
    public ResourceLocation getModelResource(BlockEntity animatable) {
        return new ResourceLocation(Mechaniya.MOD_ID, "geo/andesite_controller.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlockEntity animatable) {
        return new ResourceLocation(Mechaniya.MOD_ID, "textures/block/andesite_controller.png");
    }
}
