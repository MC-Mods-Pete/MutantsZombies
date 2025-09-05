package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.SpitterModel;
import net.petemc.mutantszombies.entity.SpitterEntity;
import org.jetbrains.annotations.NotNull;

public class SpitterRenderer extends MobRenderer<SpitterEntity, SpitterModel<SpitterEntity>> {
    public SpitterRenderer(EntityRendererProvider.Context context) {
        super(context, new SpitterModel<>(context.bakeLayer(SpitterModel.LAYER_LOCATION)), 1.3F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SpitterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "textures/entities/spitter.png");
    }
}
