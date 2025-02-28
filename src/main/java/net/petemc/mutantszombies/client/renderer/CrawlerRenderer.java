package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.CrawlerModel;
import net.petemc.mutantszombies.entity.CrawlerEntity;

public class CrawlerRenderer extends MobEntityRenderer<CrawlerEntity, CrawlerModel<CrawlerEntity>> {
    public CrawlerRenderer(EntityRendererFactory.Context context) {
        super(context, new CrawlerModel<>(context.getPart(CrawlerModel.LAYER_LOCATION)), 0.5F);
    }

    public Identifier getTexture(CrawlerEntity entity) {
        return new Identifier("mutantszombies:textures/entities/crawler.png");
    }
}
