package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.SplitHeadZombieModel;
import net.petemc.mutantszombies.entity.SplitHeadZombieEntity;
import org.jetbrains.annotations.NotNull;

public class SplitHeadZombieRenderer extends MobRenderer<SplitHeadZombieEntity, SplitHeadZombieModel<SplitHeadZombieEntity>> {
    public SplitHeadZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new SplitHeadZombieModel<>(context.bakeLayer(SplitHeadZombieModel.LAYER_LOCATION)), 1.3F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SplitHeadZombieEntity pEntity) {
        return new ResourceLocation("mutantszombies:textures/entities/splitheadzombie.png");
    }
}
