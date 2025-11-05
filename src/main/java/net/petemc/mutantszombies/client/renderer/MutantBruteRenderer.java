package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.MutantBruteModel;
import net.petemc.mutantszombies.client.state.MutantBruteEntityRenderState;
import net.petemc.mutantszombies.entity.MutantBruteEntity;
import org.jetbrains.annotations.NotNull;

public class MutantBruteRenderer extends MobRenderer<MutantBruteEntity, MutantBruteEntityRenderState, MutantBruteModel> {
    public MutantBruteRenderer(EntityRendererProvider.Context context) {
        super(context, new MutantBruteModel(context.bakeLayer(MutantBruteModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public @NotNull MutantBruteEntityRenderState createRenderState() {
        return new MutantBruteEntityRenderState();
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull MutantBruteEntityRenderState mutantBruteEntityRenderState) {
        return mutantBruteEntityRenderState.skinTexture;
    }

    public void extractRenderState(@NotNull MutantBruteEntity mutantBruteEntity, @NotNull MutantBruteEntityRenderState renderState, float partialTick) {
        super.extractRenderState(mutantBruteEntity, renderState, partialTick);
        renderState.attackTicksRemaining = mutantBruteEntity.getAttackAnimationTick() > 0.0F ? mutantBruteEntity.getAttackAnimationTick() - partialTick : 0.0F;
    }
}
