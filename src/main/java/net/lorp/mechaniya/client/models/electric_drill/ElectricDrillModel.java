package net.lorp.mechaniya.client.models.electric_drill;

import net.lorp.mechaniya.Mechaniya;
import net.lorp.mechaniya.common.item.ElectricDrillItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ElectricDrillModel extends GeoModel<ElectricDrillItem> {
    @Override
    public ResourceLocation getModelResource(ElectricDrillItem electricDrillItem) {
        return ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "geo/electric_drill.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ElectricDrillItem electricDrillItem) {
         return ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "textures/item/portable_electric_drill.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ElectricDrillItem electricDrillItem) {
         return ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "animations/electric_drill.animation.json");
    }
}
