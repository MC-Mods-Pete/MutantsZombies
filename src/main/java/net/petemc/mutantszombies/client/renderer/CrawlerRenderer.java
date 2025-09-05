package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.CrawlerModel;
import net.petemc.mutantszombies.entity.CrawlerEntity;
import org.jetbrains.annotations.NotNull;

public class CrawlerRenderer extends MobRenderer<CrawlerEntity, CrawlerModel<CrawlerEntity>> {
    public CrawlerRenderer(EntityRendererProvider.Context context) {
        super(context, new CrawlerModel<>(context.bakeLayer(CrawlerModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull CrawlerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "textures/entities/crawler.png");
    }
}

