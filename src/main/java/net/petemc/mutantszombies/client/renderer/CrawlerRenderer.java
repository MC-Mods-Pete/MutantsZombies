package net.petemc.mutantszombies.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nyfaria.awcapi.ClientClimberHelper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.model.CrawlerModel;
import net.petemc.mutantszombies.entity.CrawlerEntity;
import org.jetbrains.annotations.NotNull;

public class CrawlerRenderer extends MobRenderer<CrawlerEntity, CrawlerModel<CrawlerEntity>> {

    public CrawlerRenderer(EntityRendererProvider.Context context) {
        super(context, new CrawlerModel<>(context.bakeLayer(CrawlerModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull CrawlerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "textures/entities/crawler.png");
    }

    /**
     * Orientation rotation: apply pre BEFORE super.render(), post AFTER super.render().
     * This exactly matches the behavior of MixinLivingRenderer (AT HEAD / AT RETURN).
     * DO NOT call in setupRotations() – that would be inside super.render() and
     * the PoseStack state would be incorrect.
     */
    @Override
    public void render(@NotNull CrawlerEntity entity, float entityYaw, float partialTicks,
                       @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        ClientClimberHelper.preRenderClimber(entity, partialTicks, poseStack);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        ClientClimberHelper.postRenderClimber(entity, partialTicks, poseStack, buffer);
    }
}
