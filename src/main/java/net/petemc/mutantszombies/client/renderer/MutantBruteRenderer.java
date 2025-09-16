package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.MutantBruteModel;
import net.petemc.mutantszombies.client.state.MutantBruteEntityRenderState;
import net.petemc.mutantszombies.entity.MutantBruteEntity;
import org.jetbrains.annotations.NotNull;

public class MutantBruteRenderer extends MobEntityRenderer<MutantBruteEntity, MutantBruteEntityRenderState, MutantBruteModel> {
    public MutantBruteRenderer(EntityRendererFactory.Context context) {
        super(context, new MutantBruteModel(context.getPart(MutantBruteModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull MutantBruteEntityRenderState createRenderState() {
        return new MutantBruteEntityRenderState();
    }

    @Override
    public Identifier getTexture(MutantBruteEntityRenderState renderState) {
        return renderState.skinTexture;
    }

    public void updateRenderState(@NotNull MutantBruteEntity mutantBruteEntity, @NotNull MutantBruteEntityRenderState renderState, float partialTick) {
        super.updateRenderState(mutantBruteEntity, renderState, partialTick);
        renderState.attackTicksRemaining = mutantBruteEntity.getAttackAnimationTick() > 0.0F ? mutantBruteEntity.getAttackAnimationTick() - partialTick : 0.0F;
    }
}
