package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;

public class ZombieBruteRenderer extends MobEntityRenderer<ZombieBruteEntity, ZombieBruteModel<ZombieBruteEntity>> {
    public ZombieBruteRenderer(EntityRendererFactory.Context context) {
        super(context, new ZombieBruteModel<>(context.getPart(ZombieBruteModel.LAYER_LOCATION)), 1.3F);
    }

    @Override
    public Identifier getTexture(ZombieBruteEntity entity) {
        return Identifier.of(MutantsZombies.MOD_ID,"textures/entities/zombiebrute.png");
    }
}
