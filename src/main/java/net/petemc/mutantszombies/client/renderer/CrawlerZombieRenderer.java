package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.CrawlerZombieModel;
import net.petemc.mutantszombies.entity.CrawlerZombieEntity;

public class CrawlerZombieRenderer extends MobRenderer<CrawlerZombieEntity, CrawlerZombieModel<CrawlerZombieEntity>> {
    public CrawlerZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new CrawlerZombieModel<>(context.bakeLayer(CrawlerZombieModel.LAYER_LOCATION)), 0.5F);
    }

    public ResourceLocation getTextureLocation(CrawlerZombieEntity entity) {
        return new ResourceLocation("mutantszombies:textures/entities/crawler.png");
    }
}

