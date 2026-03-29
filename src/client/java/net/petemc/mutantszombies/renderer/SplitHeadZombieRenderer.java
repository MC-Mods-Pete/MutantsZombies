package net.petemc.mutantszombies.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.petemc.mutantszombies.model.SplitHeadZombieModel;
import net.petemc.mutantszombies.state.SplitHeadZombieEntityRenderState;
import net.petemc.mutantszombies.entity.SplitHeadZombieEntity;
import org.jetbrains.annotations.NotNull;

public class SplitHeadZombieRenderer extends MobRenderer<SplitHeadZombieEntity, SplitHeadZombieEntityRenderState, SplitHeadZombieModel> {
    public SplitHeadZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new SplitHeadZombieModel(context.bakeLayer(SplitHeadZombieModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public @NotNull SplitHeadZombieEntityRenderState createRenderState() {
        return new SplitHeadZombieEntityRenderState();
    }

    public @NotNull Identifier getTextureLocation(@NotNull SplitHeadZombieEntityRenderState splitHeadZombieEntityRenderState) {
        return splitHeadZombieEntityRenderState.skinTexture;
    }
}
