package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.SpitterZombieModel;
import net.petemc.mutantszombies.entity.SpitterZombieEntity;
import org.jetbrains.annotations.NotNull;

public class SpitterZombieRenderer extends MobRenderer<SpitterZombieEntity, SpitterZombieModel<SpitterZombieEntity>> {
    public SpitterZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new SpitterZombieModel<>(context.bakeLayer(SpitterZombieModel.LAYER_LOCATION)), 1.3F);
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull SpitterZombieEntity entity) {
        return new ResourceLocation("mutantszombies:textures/entities/spitter.png");
    }
}
