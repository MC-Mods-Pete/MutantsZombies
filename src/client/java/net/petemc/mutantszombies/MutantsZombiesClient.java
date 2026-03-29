package net.petemc.mutantszombies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.petemc.mutantszombies.entity.ModEntities;
import net.petemc.mutantszombies.model.*;
import net.petemc.mutantszombies.renderer.*;

public class MutantsZombiesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
        EntityRenderers.register(ModEntities.BLISTER_ZOMBIE, BlisterZombieRenderer::new);
		ModelLayerRegistry.registerModelLayer(BlisterZombieModel.LAYER_LOCATION, BlisterZombieModel::createBodyLayer);

		EntityRenderers.register(ModEntities.CRAWLER, CrawlerRenderer::new);
		ModelLayerRegistry.registerModelLayer(CrawlerModel.LAYER_LOCATION, CrawlerModel::createBodyLayer);

		EntityRenderers.register(ModEntities.ZOMBIE_BRUTE, ZombieBruteRenderer::new);
		ModelLayerRegistry.registerModelLayer(ZombieBruteModel.LAYER_LOCATION, ZombieBruteModel::createBodyLayer);

		EntityRenderers.register(ModEntities.SPITTER, SpitterRenderer::new);
		ModelLayerRegistry.registerModelLayer(SpitterModel.LAYER_LOCATION, SpitterModel::createBodyLayer);
		EntityRenderers.register(ModEntities.SPITTER_PROJECTILE, ThrownItemRenderer::new);

        EntityRenderers.register(ModEntities.SPLIT_HEAD_ZOMBIE, SplitHeadZombieRenderer::new);
        ModelLayerRegistry.registerModelLayer(SplitHeadZombieModel.LAYER_LOCATION, SplitHeadZombieModel::createBodyLayer);

        EntityRenderers.register(ModEntities.MUTANT_BRUTE, MutantBruteRenderer::new);
        ModelLayerRegistry.registerModelLayer(MutantBruteModel.LAYER_LOCATION, MutantBruteModel::createBodyLayer);

        EntityRenderers.register(ModEntities.ROTTEN_MUTANT, RottenMutantRenderer::new);
        ModelLayerRegistry.registerModelLayer(RottenMutantModel.LAYER_LOCATION, RottenMutantModel::createBodyLayer);
	}
}