package net.petemc.mutantszombies.client.model;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
        bus = Bus.MOD,
        value = {Dist.CLIENT}
)
public class ModModels {
    public ModModels() {
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SpitterZombieModel.LAYER_LOCATION, SpitterZombieModel::createBodyLayer);
        event.registerLayerDefinition(BlisterZombieModel.LAYER_LOCATION, BlisterZombieModel::createBodyLayer);
        event.registerLayerDefinition(CrawlerZombieModel.LAYER_LOCATION, CrawlerZombieModel::createBodyLayer);
        event.registerLayerDefinition(ZombieBruteModel.LAYER_LOCATION, ZombieBruteModel::createBodyLayer);
    }
}
