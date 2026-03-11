package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.petemc.mutantszombies.client.model.CrawlerModel;
import net.petemc.mutantszombies.client.renderer.layer.LayerEmissive;
import net.petemc.mutantszombies.entity.CrawlerEntity;

public class CrawlerRenderer extends RenderLiving<CrawlerEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mutantszombies", "textures/entities/crawler.png");
    private static final ResourceLocation TEXTURE_EMISSIVE = new ResourceLocation("mutantszombies", "textures/entities/crawler_e.png");

    public CrawlerRenderer(RenderManager renderManager) {
        super(renderManager, new CrawlerModel(), 0.5F);
        this.addLayer(new LayerEmissive<>(this, TEXTURE_EMISSIVE));
    }

    @Override
    protected ResourceLocation getEntityTexture(CrawlerEntity entity) {
        return TEXTURE;
    }
}
