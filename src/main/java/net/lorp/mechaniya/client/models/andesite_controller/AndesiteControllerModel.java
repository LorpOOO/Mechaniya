package net.lorp.mechaniya.client.models.andesite_controller;

import net.lorp.mechaniya.common.block.AndesiteControllerBlock;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import static net.lorp.mechaniya.Mechaniya.MOD_ID;

public class AndesiteControllerModel extends GeoModel<AndesiteControllerBlock> {
    /**
     * @param andesiteControllerBlock
     * @deprecated
     */
    @Override
    public ResourceLocation getModelResource(AndesiteControllerBlock andesiteControllerBlock) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "geo/andesite_controller.geo.json");
    }

    /**
     * @param andesiteControllerBlock
     * @deprecated
     */
    @Override
    public ResourceLocation getTextureResource(AndesiteControllerBlock andesiteControllerBlock) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "block/andesite_controller.png"); // далбойоб на лорпі вирішив НЕ відділяти текстуру для спецблока папкою, а якийсь трофей отримав, браво
    } // треба пояснити чому ТРЕБА розділяти текстури для СПЕЦІАЛЬНИХ блоків папкою, а для звичайних ні, бо це ж так логічно

    @Override
    public ResourceLocation getAnimationResource(AndesiteControllerBlock andesiteControllerBlock) {
        return null; // нахуй не треба бо анімації німа
    }
//    @Override
//    public ResourceLocation getModelResource(BlockEntity animatable) {
//        return new ResourceLocation(Mechaniya.MOD_ID, "geo/andesite_controller.geo.json");
//    }
//
//    @Override
//    public ResourceLocation getTextureResource(BlockEntity animatable) {
//        return new ResourceLocation(Mechaniya.MOD_ID, "textures/block/andesite_controller.png");
//    }


}
