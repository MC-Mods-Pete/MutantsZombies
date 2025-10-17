package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.RottenMutantModel;
import net.petemc.mutantszombies.entity.RottenMutantEntity;
import org.jetbrains.annotations.NotNull;

public class RottenMutantRenderer extends MobRenderer<RottenMutantEntity, RottenMutantModel<RottenMutantEntity>> {
    public RottenMutantRenderer(EntityRendererProvider.Context context) {
        super(context, new RottenMutantModel<>(context.bakeLayer(RottenMutantModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull RottenMutantEntity entity) {
        return new ResourceLocation(MutantsZombies.MOD_ID, "textures/entities/rottenmutant.png");
    }
}
