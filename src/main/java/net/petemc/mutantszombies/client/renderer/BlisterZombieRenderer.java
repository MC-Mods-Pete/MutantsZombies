package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.*;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.client.model.BlisterZombieModel;
import net.petemc.mutantszombies.entity.BlisterZombieEntity;

public class BlisterZombieRenderer extends MobEntityRenderer<BlisterZombieEntity, BlisterZombieModel<BlisterZombieEntity>> {
    public BlisterZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new BlisterZombieModel<>(context.getPart(BlisterZombieModel.LAYER_LOCATION)), 0.7F);
    }

    public Identifier getTexture(BlisterZombieEntity entity) {
        return new Identifier("mutantszombies:textures/entities/blisterzombie.png");
    }
}
