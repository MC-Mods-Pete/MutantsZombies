package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.petemc.mutantszombies.client.model.CrawlerModel;
import net.petemc.mutantszombies.client.state.CrawlerEntityRenderState;
import net.petemc.mutantszombies.entity.CrawlerEntity;
import org.jetbrains.annotations.NotNull;

public class CrawlerRenderer extends MobRenderer<CrawlerEntity, CrawlerEntityRenderState, CrawlerModel> {
    public CrawlerRenderer(EntityRendererProvider.Context context) {
        super(context, new CrawlerModel(context.bakeLayer(CrawlerModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public @NotNull CrawlerEntityRenderState createRenderState() {
        return new CrawlerEntityRenderState();
    }

    public @NotNull Identifier getTextureLocation(@NotNull CrawlerEntityRenderState crawlerEntityRenderState) {
        return crawlerEntityRenderState.skinTexture;
    }
}

