package net.petemc.mutantszombies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.EntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.petemc.mutantszombies.client.model.*;
import net.petemc.mutantszombies.client.renderer.*;
import net.petemc.mutantszombies.entity.ModEntities;

public class MutantsZombiesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
        EntityRendererFactories.register(ModEntities.BLISTER_ZOMBIE, BlisterZombieRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(BlisterZombieModel.LAYER_LOCATION, BlisterZombieModel::createBodyLayer);

		EntityRendererFactories.register(ModEntities.CRAWLER, CrawlerRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(CrawlerModel.LAYER_LOCATION, CrawlerModel::createBodyLayer);

		EntityRendererFactories.register(ModEntities.ZOMBIE_BRUTE, ZombieBruteRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ZombieBruteModel.LAYER_LOCATION, ZombieBruteModel::createBodyLayer);

		EntityRendererFactories.register(ModEntities.SPITTER, SpitterRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(SpitterModel.LAYER_LOCATION, SpitterModel::createBodyLayer);
		EntityRendererFactories.register(ModEntities.SPITTER_PROJECTILE, FlyingItemEntityRenderer::new);

        EntityRendererFactories.register(ModEntities.SPLIT_HEAD_ZOMBIE, SplitHeadZombieRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SplitHeadZombieModel.LAYER_LOCATION, SplitHeadZombieModel::createBodyLayer);

        EntityRendererFactories.register(ModEntities.MUTANT_BRUTE, MutantBruteRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MutantBruteModel.LAYER_LOCATION, MutantBruteModel::createBodyLayer);

        EntityRendererFactories.register(ModEntities.ROTTEN_MUTANT, RottenMutantRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(RottenMutantModel.LAYER_LOCATION, RottenMutantModel::createBodyLayer);
	}
}