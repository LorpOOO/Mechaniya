package net.lorp.mechaniya.common.item;

import com.enderio.enderio.api.capacitor.CapacitorData;
import net.lorp.mechaniya.Config;

public class ModCapacitor {
    public static CapacitorData HEXADECIMAL_CAPACITOR_DATA() {
        return CapacitorData.simple(Config.HEXADECIMAL_BOOST.get().floatValue());
    }
}