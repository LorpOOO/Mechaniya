package net.lorp.mechaniya.common.register;

import mekanism.api.chemical.Chemical;
import mekanism.api.text.EnumColor;
import mekanism.common.registration.impl.ChemicalDeferredRegister;
import mekanism.common.registration.impl.DeferredChemical;
import mekanism.common.registration.impl.SlurryRegistryObject;
import mekanism.common.resource.PrimaryResource;
import mekanism.common.util.EnumUtils;
import net.lorp.mechaniya.Mechaniya;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

// REASONE: There's nothing to use here, but the warnings are confusing me.
@SuppressWarnings("all")
public class ModChemicals {
    public static final ChemicalDeferredRegister CHEMICALS = new ChemicalDeferredRegister(Mechaniya.MOD_ID);

    public static final DeferredChemical<Chemical> BLAZE = CHEMICALS.registerInfuse("blaze", 0xFFA300);
    public static final DeferredChemical<Chemical> ZINC = CHEMICALS.registerInfuse("zinc", 0xB9E9C1);
    public static final DeferredChemical<Chemical> LAPIS_LAZULI = CHEMICALS.registerInfuse("liquefied_lapis_lazuli", 0x1A3D8F);

    public static Map<EnumColor, DeferredChemical<Chemical>> PIGMENT_COLOR_LOOKUP = new EnumMap<>(EnumColor.class);
    public static final Map<PrimaryResource, SlurryRegistryObject<Chemical, Chemical>> PROCESSED_RESOURCES = new LinkedHashMap<>();

    static {
        for (EnumColor color : EnumUtils.COLORS) {
            PIGMENT_COLOR_LOOKUP.put(color, registerPigment(color));
        }
        for (PrimaryResource resource : EnumUtils.PRIMARY_RESOURCES) {
            PROCESSED_RESOURCES.put(resource, CHEMICALS.registerSlurry(resource));
        }
    }

    private static DeferredChemical<Chemical> registerPigment(EnumColor color) {
        int[] rgb = color.getRgbCode();
        int tint = rgb[0] << 16;
        tint |= rgb[1] << 8;
        tint |= rgb[2];
        return CHEMICALS.registerPigment(color.getRegistryPrefix(), tint);
    }
}
