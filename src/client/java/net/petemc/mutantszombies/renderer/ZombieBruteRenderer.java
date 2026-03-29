package net.petemc.mutantszombies.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.petemc.mutantszombies.model.ZombieBruteModel;
import net.petemc.mutantszombies.state.ZombieBruteEntityRenderState;
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

    public @NotNull Identifier getTextureLocation(@NotNull ZombieBruteEntityRenderState mutantBruteEntityRenderState) {
        return mutantBruteEntityRenderState.skinTexture;
    }

    public void extractRenderState(@NotNull ZombieBruteEntity zombieBruteEntity, @NotNull ZombieBruteEntityRenderState renderState, float partialTick) {
        super.extractRenderState(zombieBruteEntity, renderState, partialTick);
        renderState.attackTicksRemaining = zombieBruteEntity.getAttackAnimationTick() > 0.0F ? zombieBruteEntity.getAttackAnimationTick() - partialTick : 0.0F;
    }
}
