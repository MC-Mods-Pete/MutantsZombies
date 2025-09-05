package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.BlisterZombieModel;
import net.petemc.mutantszombies.entity.BlisterZombieEntity;
import org.jetbrains.annotations.NotNull;

public class BlisterZombieRenderer extends MobRenderer<BlisterZombieEntity, BlisterZombieModel<BlisterZombieEntity>> {
    public BlisterZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new BlisterZombieModel<>(context.bakeLayer(BlisterZombieModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BlisterZombieEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "textures/entities/blisterzombie.png");
    }
}
