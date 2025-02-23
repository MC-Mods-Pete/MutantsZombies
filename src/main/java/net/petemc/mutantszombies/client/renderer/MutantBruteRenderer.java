package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.client.model.MutantBruteModel;
import net.petemc.mutantszombies.entity.MutantBruteEntity;
import org.jetbrains.annotations.NotNull;

public class MutantBruteRenderer extends MobRenderer<MutantBruteEntity, MutantBruteModel<MutantBruteEntity>> {
    public MutantBruteRenderer(EntityRendererProvider.Context context) {
        super(context, new MutantBruteModel<>(context.bakeLayer(MutantBruteModel.LAYER_LOCATION)), 1.3F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MutantBruteEntity pEntity) {
        return new ResourceLocation("mutantszombies:textures/entities/mutantbrute.png");
    }
}
