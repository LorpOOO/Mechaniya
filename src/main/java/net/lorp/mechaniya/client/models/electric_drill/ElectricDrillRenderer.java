package net.lorp.mechaniya.client.models.electric_drill;

import net.lorp.mechaniya.common.item.ElectricDrillItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ElectricDrillRenderer extends GeoItemRenderer<ElectricDrillItem> {
    public ElectricDrillRenderer() {
        super(new ElectricDrillModel());

        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
