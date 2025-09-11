package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.SpitterModel;
import net.petemc.mutantszombies.client.model.SpitterModel;
import net.petemc.mutantszombies.client.state.SpitterEntityRenderState;
import net.petemc.mutantszombies.entity.SpitterEntity;
import net.petemc.mutantszombies.entity.SpitterEntity;
import org.jetbrains.annotations.NotNull;

public class SpitterRenderer extends MobEntityRenderer<SpitterEntity, SpitterEntityRenderState, SpitterModel> {
    public SpitterRenderer(EntityRendererFactory.Context context) {
        super(context, new SpitterModel(context.getPart(SpitterModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull SpitterEntityRenderState createRenderState() {
        return new SpitterEntityRenderState();
    }

    @Override
    public Identifier getTexture(SpitterEntityRenderState renderState) {
        return renderState.skinTexture;
    }
}
