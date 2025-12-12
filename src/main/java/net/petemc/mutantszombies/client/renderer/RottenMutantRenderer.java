package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.RottenMutantModel;
import net.petemc.mutantszombies.client.state.RottenMutantEntityRenderState;
import net.petemc.mutantszombies.entity.RottenMutantEntity;
import org.jetbrains.annotations.NotNull;

public class RottenMutantRenderer extends MobEntityRenderer<RottenMutantEntity, RottenMutantEntityRenderState, RottenMutantModel> {
    public RottenMutantRenderer(EntityRendererFactory.Context context) {
        super(context, new RottenMutantModel(context.getPart(RottenMutantModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull RottenMutantEntityRenderState createRenderState() {
        return new RottenMutantEntityRenderState();
    }

    @Override
    public Identifier getTexture(RottenMutantEntityRenderState renderState) {
        return renderState.skinTexture;
    }
}
