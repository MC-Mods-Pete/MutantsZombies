package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.MutantBruteModel;
import net.petemc.mutantszombies.entity.MutantBruteEntity;

public class MutantBruteRenderer extends MobEntityRenderer<MutantBruteEntity, MutantBruteModel<MutantBruteEntity>> {
    public MutantBruteRenderer(EntityRendererFactory.Context context) {
        super(context, new MutantBruteModel<>(context.getPart(MutantBruteModel.LAYER_LOCATION)), 1.3F);
    }

    @Override
    public Identifier getTexture(MutantBruteEntity entity) {
        return Identifier.of(MutantsZombies.MOD_ID, "textures/entities/mutantbrute.png");
    }
}
