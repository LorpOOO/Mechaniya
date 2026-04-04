package net.lorp.mechaniya.common.item;

import com.enderio.enderio.api.EnderIOAPI;
import com.enderio.enderio.api.capacitor.CapacitorData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class CustomCapacitor extends Item {

    private final Supplier<CapacitorData> capacitorDataSupplier;
    private CapacitorData capacitorData;

    public CustomCapacitor(Properties properties, Supplier<CapacitorData> capacitorDataSupplier) {
        super(properties);
        this.capacitorDataSupplier = capacitorDataSupplier;
    }

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CapacitorData>> CAPACITOR_DATA_TYPE =
            DeferredHolder.create(Registries.DATA_COMPONENT_TYPE, ResourceLocation.fromNamespaceAndPath(EnderIOAPI.MOD_ID, "capacitor_data"));

    @NotNull
    public CapacitorData getCapacitorData(@NotNull ItemStack stack) {
        if (capacitorData == null) {
            capacitorData = capacitorDataSupplier.get();
        }
        return capacitorData;
    }

    @Override
    public void verifyComponentsAfterLoad(ItemStack stack) {
        if(stack.get(CAPACITOR_DATA_TYPE) == null) {
            stack.set(CAPACITOR_DATA_TYPE, getCapacitorData(stack));
        }
    }
}