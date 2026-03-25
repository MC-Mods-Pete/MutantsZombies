package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.MutantZombieModel;
import net.petemc.mutantszombies.entity.MutantZombieEntity;
import org.jetbrains.annotations.NotNull;

public class MutantZombieRenderer extends MobRenderer<MutantZombieEntity, MutantZombieModel<MutantZombieEntity>> {
    public MutantZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new MutantZombieModel<>(context.bakeLayer(MutantZombieModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MutantZombieEntity entity) {
        return new ResourceLocation(MutantsZombies.MOD_ID, "textures/entities/mutantzombie.png");
    }
}
