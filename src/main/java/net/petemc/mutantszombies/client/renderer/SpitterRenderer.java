package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.SpitterModel;
import net.petemc.mutantszombies.entity.SpitterEntity;
import org.jetbrains.annotations.NotNull;

public class SpitterRenderer extends MobEntityRenderer<SpitterEntity, SpitterModel<SpitterEntity>> {
    public SpitterRenderer(EntityRendererFactory.Context context) {
        super(context, new SpitterModel<>(context.getPart(SpitterModel.LAYER_LOCATION)), 1.3F);
    }

    public @NotNull Identifier getTexture(@NotNull SpitterEntity entity) {
        return Identifier.of("mutantszombies:textures/entities/spitter.png");
    }
}
