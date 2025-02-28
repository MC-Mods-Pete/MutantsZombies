package net.petemc.mutantszombies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.petemc.mutantszombies.client.model.BlisterZombieModel;
import net.petemc.mutantszombies.client.model.CrawlerModel;
import net.petemc.mutantszombies.client.model.SpitterModel;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.client.renderer.BlisterZombieRenderer;
import net.petemc.mutantszombies.client.renderer.CrawlerRenderer;
import net.petemc.mutantszombies.client.renderer.SpitterRenderer;
import net.petemc.mutantszombies.client.renderer.ZombieBruteRenderer;
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
	}
}