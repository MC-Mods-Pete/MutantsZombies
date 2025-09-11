package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.client.state.ZombieBruteEntityRenderState;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;
import org.jetbrains.annotations.NotNull;

public class ZombieBruteRenderer extends MobEntityRenderer<ZombieBruteEntity, ZombieBruteEntityRenderState, ZombieBruteModel> {
    public ZombieBruteRenderer(EntityRendererFactory.Context context) {
        super(context, new ZombieBruteModel(context.getPart(ZombieBruteModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull ZombieBruteEntityRenderState createRenderState() {
        return new ZombieBruteEntityRenderState();
    }

    @Override
    public Identifier getTexture(ZombieBruteEntityRenderState renderState) {
        return renderState.skinTexture;
    }
}
