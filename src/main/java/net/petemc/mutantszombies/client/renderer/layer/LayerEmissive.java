package net.petemc.mutantszombies.client.renderer.layer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

/**
 * Rendert eine emissive (_e.png) Textur über das normale Model.
 * Die Textur leuchtet unabhängig vom Umgebungslicht (wie Glut-Augen, Enderman-Augen etc.).
 * Transparente Pixel der _e.png werden übersprungen – nur die eingefärbten Bereiche leuchten.
 */
public class LayerEmissive<T extends EntityLiving> implements LayerRenderer<T> {

    private final RenderLiving<T> renderer;
    private final ResourceLocation emissiveTexture;

    public LayerEmissive(RenderLiving<T> renderer, ResourceLocation emissiveTexture) {
        this.renderer = renderer;
        this.emissiveTexture = emissiveTexture;
    }

    @Override
    public void doRenderLayer(T entity, float limbSwing, float limbSwingAmount,
                              float partialTicks, float ageInTicks,
                              float netHeadYaw, float headPitch, float scale) {

        // Emissive-Textur binden
        renderer.bindTexture(emissiveTexture);

        // Beleuchtung deaktivieren → Textur wird immer mit voller Helligkeit gerendert
        GlStateManager.disableLighting();

        // Lightmap auf Maximum setzen (entspricht "leuchtend" wie Glow-Squid / Enderman-Augen)
        float prevLightmapX = OpenGlHelper.lastBrightnessX;
        float prevLightmapY = OpenGlHelper.lastBrightnessY;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);

        // Alpha-Blending für transparente Pixel der _e.png aktivieren
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA,
                GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        // Model mit der emissiven Textur rendern
        renderer.getMainModel().render(entity, limbSwing, limbSwingAmount,
                ageInTicks, netHeadYaw, headPitch, scale);

        // GL-Zustand wiederherstellen
        GlStateManager.disableBlend();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLightmapX, prevLightmapY);
        GlStateManager.enableLighting();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}


