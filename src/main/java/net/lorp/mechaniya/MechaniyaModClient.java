package net.lorp.mechaniya;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.lorp.mechaniya.common.register.ModFluidType;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class MechaniyaModClient {

    public MechaniyaModClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        registerFluidRender(event, ModFluidType.SHIMMER.get(), "shimmer");
        registerFluidRender(event, ModFluidType.LATEX.get(), "latex");
        registerFluidRender(event, ModFluidType.WARPED_LATEX.get(), "warped_latex");
    }

    private static void registerFluidRender(RegisterClientExtensionsEvent event, FluidType type, String textureName) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            private final ResourceLocation STILL = ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "block/" + textureName + "_still");
            private final ResourceLocation FLOW = ResourceLocation.fromNamespaceAndPath(Mechaniya.MOD_ID, "block/" + textureName + "_flow");

            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return FLOW;
            }

            @Override
            public @NotNull Vector3f modifyFogColor(@NotNull Camera camera, float partialTick, @NotNull ClientLevel level, int renderDistance, float darkenWorldAmount, @NotNull Vector3f fluidFogColor) {

                if (textureName.contains("warped_latex")) {
                     return new Vector3f(0.0f, 1.0f, 0.8f);
                }

                if (textureName.contains("shimmer")) {
                    return new Vector3f(1.0f, 0.6f, 0.85f);
                }

                if (textureName.contains("latex")) {
                    return new Vector3f(0.991111111111f,0.502222222222f , 0.149019607843f);
                }

                return fluidFogColor;
            }

            @Override
            public void modifyFogRender(@NotNull Camera camera, FogRenderer.@NotNull FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, @NotNull FogShape shape) {

                RenderSystem.setShaderFogStart(0.0f);
                RenderSystem.setShaderFogEnd(6.0f);
            }
        }, type);
    }
}