package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.petemc.mutantszombies.entity.ModEntities;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.BLISTER_ZOMBIE.get(), BlisterZombieRenderer::new);
        event.registerEntityRenderer(ModEntities.CRAWLER.get(), CrawlerRenderer::new);
        event.registerEntityRenderer(ModEntities.ZOMBIE_BRUTE.get(), ZombieBruteRenderer::new);
        event.registerEntityRenderer(ModEntities.SPITTER.get(), SpitterRenderer::new);
        event.registerEntityRenderer(ModEntities.SPITTER_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.SPLIT_HEAD_ZOMBIE.get(), SplitHeadZombieRenderer::new);
        event.registerEntityRenderer(ModEntities.MUTANT_BRUTE.get(), MutantBruteRenderer::new);
    }
}

