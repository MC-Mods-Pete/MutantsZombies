package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.client.state.ZombieBruteEntityRenderState;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;
import org.jetbrains.annotations.NotNull;

public class ZombieBruteRenderer extends MobRenderer<ZombieBruteEntity, ZombieBruteEntityRenderState, ZombieBruteModel> {
    public ZombieBruteRenderer(EntityRendererProvider.Context context) {
        super(context, new ZombieBruteModel(context.bakeLayer(ZombieBruteModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public @NotNull ZombieBruteEntityRenderState createRenderState() {
        return new ZombieBruteEntityRenderState();
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull ZombieBruteEntityRenderState mutantBruteEntityRenderState) {
        return mutantBruteEntityRenderState.skinTexture;
    }
}
