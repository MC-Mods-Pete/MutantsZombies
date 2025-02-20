package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.CrawlerModel;
import net.petemc.mutantszombies.entity.CrawlerEntity;

public class CrawlerRenderer extends MobRenderer<CrawlerEntity, CrawlerModel<CrawlerEntity>> {
    public CrawlerRenderer(EntityRendererProvider.Context context) {
        super(context, new CrawlerModel<>(context.bakeLayer(CrawlerModel.LAYER_LOCATION)), 0.5F);
    }

    public ResourceLocation getTextureLocation(CrawlerEntity entity) {
        return new ResourceLocation("mutantszombies:textures/entities/crawler.png");
    }
}

