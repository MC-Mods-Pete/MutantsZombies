package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.BlisterZombieModel;
import net.petemc.mutantszombies.client.model.CrawlerModel;
import net.petemc.mutantszombies.client.state.BlisterZombieEntityRenderState;
import net.petemc.mutantszombies.client.state.CrawlerEntityRenderState;
import net.petemc.mutantszombies.entity.BlisterZombieEntity;
import net.petemc.mutantszombies.entity.CrawlerEntity;
import org.jetbrains.annotations.NotNull;

public class CrawlerRenderer extends MobEntityRenderer<CrawlerEntity, CrawlerEntityRenderState, CrawlerModel> {
    public CrawlerRenderer(EntityRendererFactory.Context context) {
        super(context, new CrawlerModel(context.getPart(CrawlerModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull CrawlerEntityRenderState createRenderState() {
        return new CrawlerEntityRenderState();
    }

    @Override
    public Identifier getTexture(CrawlerEntityRenderState renderState) {
        return renderState.skinTexture;
    }
}
