package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;
import org.jetbrains.annotations.NotNull;

public class ZombieBruteRenderer extends MobRenderer<ZombieBruteEntity, ZombieBruteModel<ZombieBruteEntity>> {
    public ZombieBruteRenderer(EntityRendererProvider.Context context) {
        super(context, new ZombieBruteModel<>(context.bakeLayer(ZombieBruteModel.LAYER_LOCATION)), 1.3F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ZombieBruteEntity entity) {
        return new ResourceLocation(MutantsZombies.MOD_ID, "textures/entities/zombiebrute.png");
    }
}
