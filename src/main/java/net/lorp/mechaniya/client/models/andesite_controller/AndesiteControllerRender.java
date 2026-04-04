package net.lorp.mechaniya.client.models.andesite_controller;

import net.lorp.mechaniya.common.block.entity.AndesiteControllerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AndesiteControllerRender extends GeoBlockRenderer<AndesiteControllerBlockEntity> {
    /**
     * Creates a new defaulted renderer instance, using the blockentity's registered id as the file name for its assets
     *
     * @param blockEntityType
     */
    public AndesiteControllerRender(BlockEntityType<? extends AndesiteControllerBlockEntity> blockEntityType) {
        super(blockEntityType);
    }

    // АПРІОРІ БЛОК ЕНТІТІ ЯКІ Я НЕНАВИДЖУ РОБИТИ

}
// їблан, що це нахуй таке???