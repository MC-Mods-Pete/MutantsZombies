package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.BlisterZombieModel;
import net.petemc.mutantszombies.entity.BlisterZombieEntity;

public class BlisterZombieRenderer extends MobRenderer<BlisterZombieEntity, BlisterZombieModel<BlisterZombieEntity>> {
    public BlisterZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new BlisterZombieModel<>(context.bakeLayer(BlisterZombieModel.LAYER_LOCATION)), 0.7F);
    }

    public ResourceLocation getTextureLocation(BlisterZombieEntity entity) {
        return new ResourceLocation("mutantszombies:textures/entities/blisterzombie.png");
    }
}
