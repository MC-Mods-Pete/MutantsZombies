package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.SplitHeadZombieModel;
import net.petemc.mutantszombies.client.model.SplitHeadZombieModel;
import net.petemc.mutantszombies.client.state.SplitHeadZombieEntityRenderState;
import net.petemc.mutantszombies.entity.SplitHeadZombieEntity;
import net.petemc.mutantszombies.entity.SplitHeadZombieEntity;
import org.jetbrains.annotations.NotNull;

public class SplitHeadZombieRenderer extends MobEntityRenderer<SplitHeadZombieEntity, SplitHeadZombieEntityRenderState, SplitHeadZombieModel> {
    public SplitHeadZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new SplitHeadZombieModel(context.getPart(SplitHeadZombieModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull SplitHeadZombieEntityRenderState createRenderState() {
        return new SplitHeadZombieEntityRenderState();
    }

    @Override
    public Identifier getTexture(SplitHeadZombieEntityRenderState renderState) {
        return renderState.skinTexture;
    }
}
