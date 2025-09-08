package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.*;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.BlisterZombieModel;
import net.petemc.mutantszombies.entity.BlisterZombieEntity;

public class BlisterZombieRenderer extends MobEntityRenderer<BlisterZombieEntity, BlisterZombieModel<BlisterZombieEntity>> {
    public BlisterZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new BlisterZombieModel<>(context.getPart(BlisterZombieModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public Identifier getTexture(BlisterZombieEntity entity) {
        return Identifier.of(MutantsZombies.MOD_ID,"textures/entities/blisterzombie.png");
    }
}
