package net.lorp.mechaniya;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Mechaniya.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Mechaniya.MOD_ID, value = Dist.CLIENT)
public class MechaniyaModClient {
    public MechaniyaModClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
 }