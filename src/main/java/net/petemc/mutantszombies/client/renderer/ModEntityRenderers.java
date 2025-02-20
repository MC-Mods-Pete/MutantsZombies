package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.petemc.mutantszombies.entity.ModEntities;

@EventBusSubscriber(bus = Bus.MOD, value = {Dist.CLIENT})
public class ModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.BLISTER_ZOMBIE.get(), BlisterZombieRenderer::new);
        event.registerEntityRenderer(ModEntities.CRAWLER_ZOMBIE.get(), CrawlerRenderer::new);
        event.registerEntityRenderer(ModEntities.ZOMBIE_BRUTE.get(), ZombieBruteRenderer::new);
        event.registerEntityRenderer(ModEntities.SPITTER_ZOMBIE.get(), SpitterRenderer::new);
        event.registerEntityRenderer(ModEntities.SPITTER_ZOMBIE_PROJECTILE.get(), ThrownItemRenderer::new);
    }
}

