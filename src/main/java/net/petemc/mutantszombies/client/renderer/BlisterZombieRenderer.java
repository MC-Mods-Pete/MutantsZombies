package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.*;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.BlisterZombieModel;
import net.petemc.mutantszombies.client.state.BlisterZombieEntityRenderState;
import net.petemc.mutantszombies.entity.BlisterZombieEntity;
import org.jetbrains.annotations.NotNull;

public class BlisterZombieRenderer extends MobEntityRenderer<BlisterZombieEntity, BlisterZombieEntityRenderState, BlisterZombieModel> {
    public BlisterZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new BlisterZombieModel(context.getPart(BlisterZombieModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull BlisterZombieEntityRenderState createRenderState() {
        return new BlisterZombieEntityRenderState();
    }

    @Override
    public Identifier getTexture(BlisterZombieEntityRenderState renderState) {
        return renderState.skinTexture;
    }
}
