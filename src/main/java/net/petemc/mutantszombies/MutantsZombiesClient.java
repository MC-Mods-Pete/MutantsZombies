package net.petemc.mutantszombies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.petemc.mutantszombies.client.model.*;
import net.petemc.mutantszombies.client.renderer.*;
import net.petemc.mutantszombies.entity.ModEntities;

public class MutantsZombiesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.BLISTER_ZOMBIE, BlisterZombieRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(BlisterZombieModel.LAYER_LOCATION, BlisterZombieModel::createBodyLayer);

		EntityRendererRegistry.register(ModEntities.CRAWLER, CrawlerRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(CrawlerModel.LAYER_LOCATION, CrawlerModel::createBodyLayer);

		EntityRendererRegistry.register(ModEntities.ZOMBIE_BRUTE, ZombieBruteRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ZombieBruteModel.LAYER_LOCATION, ZombieBruteModel::createBodyLayer);

		EntityRendererRegistry.register(ModEntities.SPITTER, SpitterRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(SpitterModel.LAYER_LOCATION, SpitterModel::createBodyLayer);
		EntityRendererRegistry.register(ModEntities.SPITTER_PROJECTILE, FlyingItemEntityRenderer::new);

        EntityRendererRegistry.register(ModEntities.SPLIT_HEAD_ZOMBIE, SplitHeadZombieRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SplitHeadZombieModel.LAYER_LOCATION, SplitHeadZombieModel::createBodyLayer);

        EntityRendererRegistry.register(ModEntities.MUTANT_BRUTE, MutantBruteRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MutantBruteModel.LAYER_LOCATION, MutantBruteModel::createBodyLayer);

        EntityRendererRegistry.register(ModEntities.ROTTEN_MUTANT, RottenMutantRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(RottenMutantModel.LAYER_LOCATION, RottenMutantModel::createBodyLayer);
	}
}