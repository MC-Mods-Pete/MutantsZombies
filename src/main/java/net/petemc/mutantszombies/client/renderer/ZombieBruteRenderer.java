package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;

public class ZombieBruteRenderer extends MobRenderer<ZombieBruteEntity, ZombieBruteModel<ZombieBruteEntity>> {
    public ZombieBruteRenderer(EntityRendererProvider.Context context) {
        super(context, new ZombieBruteModel<>(context.bakeLayer(ZombieBruteModel.LAYER_LOCATION)), 1.3F);
    }

    public ResourceLocation getTextureLocation(ZombieBruteEntity entity) {
        return ResourceLocation.parse("mutantszombies:textures/entities/zombiebrute.png");
    }
}
