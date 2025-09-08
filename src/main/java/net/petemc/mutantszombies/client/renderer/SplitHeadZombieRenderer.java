package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.SplitHeadZombieModel;
import net.petemc.mutantszombies.entity.SplitHeadZombieEntity;

public class SplitHeadZombieRenderer extends MobEntityRenderer<SplitHeadZombieEntity, SplitHeadZombieModel<SplitHeadZombieEntity>> {
    public SplitHeadZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new SplitHeadZombieModel<>(context.getPart(SplitHeadZombieModel.LAYER_LOCATION)), 1.3F);
    }

    @Override
    public Identifier getTexture(SplitHeadZombieEntity entity) {
        return Identifier.of(MutantsZombies.MOD_ID, "textures/entities/splitheadzombie.png");
    }
}
