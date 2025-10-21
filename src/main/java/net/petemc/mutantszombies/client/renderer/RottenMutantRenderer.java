package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.RottenMutantModel;
import net.petemc.mutantszombies.entity.RottenMutantEntity;

public class RottenMutantRenderer extends MobEntityRenderer<RottenMutantEntity, RottenMutantModel<RottenMutantEntity>> {
    public RottenMutantRenderer(EntityRendererFactory.Context context) {
        super(context, new RottenMutantModel<>(context.getPart(RottenMutantModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public Identifier getTexture(RottenMutantEntity entity) {
        return Identifier.of(MutantsZombies.MOD_ID,"textures/entities/rottenmutant.png");
    }
}
