package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.SpitterModel;
import net.petemc.mutantszombies.client.state.SpitterEntityRenderState;
import net.petemc.mutantszombies.entity.SpitterEntity;
import org.jetbrains.annotations.NotNull;

public class SpitterRenderer extends MobRenderer<SpitterEntity, SpitterEntityRenderState, SpitterModel> {
    public SpitterRenderer(EntityRendererProvider.Context context) {
        super(context, new SpitterModel(context.bakeLayer(SpitterModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public @NotNull SpitterEntityRenderState createRenderState() {
        return new SpitterEntityRenderState();
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull SpitterEntityRenderState mutantBruteEntityRenderState) {
        return mutantBruteEntityRenderState.skinTexture;
    }
}
