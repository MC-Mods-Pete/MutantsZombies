package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.petemc.mutantszombies.client.model.RottenMutantModel;
import net.petemc.mutantszombies.client.state.RottenMutantEntityRenderState;
import net.petemc.mutantszombies.entity.RottenMutantEntity;
import org.jetbrains.annotations.NotNull;

public class RottenMutantRenderer extends MobRenderer<RottenMutantEntity, RottenMutantEntityRenderState, RottenMutantModel> {
    public RottenMutantRenderer(EntityRendererProvider.Context context) {
        super(context, new RottenMutantModel(context.bakeLayer(RottenMutantModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull RottenMutantEntityRenderState createRenderState() {
        return new RottenMutantEntityRenderState();
    }

    public @NotNull Identifier getTextureLocation(@NotNull RottenMutantEntityRenderState blisterZombieEntityRenderState) {
        return blisterZombieEntityRenderState.skinTexture;
    }
}
