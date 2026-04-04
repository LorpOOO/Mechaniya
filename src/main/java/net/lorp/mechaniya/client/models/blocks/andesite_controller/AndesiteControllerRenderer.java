package net.lorp.mechaniya.client.models.blocks.andesite_controller;

import net.lorp.mechaniya.common.block.AndesiteControllerBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntityType;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AndesiteControllerRenderer extends GeoBlockRenderer<AndesiteControllerBlockEntity> {
    public AndesiteControllerRenderer(BlockEntityRendererProvider.Context ignorecontext) {
        super(new AndesiteControllerModel());
    }
}