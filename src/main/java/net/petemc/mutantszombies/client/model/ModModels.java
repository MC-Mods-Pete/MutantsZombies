package net.petemc.mutantszombies.client.model;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(value = {Dist.CLIENT})
public class ModModels {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BlisterZombieModel.LAYER_LOCATION, BlisterZombieModel::createBodyLayer);
        event.registerLayerDefinition(CrawlerModel.LAYER_LOCATION, CrawlerModel::createBodyLayer);
        event.registerLayerDefinition(SpitterModel.LAYER_LOCATION, SpitterModel::createBodyLayer);
        event.registerLayerDefinition(ZombieBruteModel.LAYER_LOCATION, ZombieBruteModel::createBodyLayer);
        event.registerLayerDefinition(SplitHeadZombieModel.LAYER_LOCATION, SplitHeadZombieModel::createBodyLayer);
        event.registerLayerDefinition(MutantBruteModel.LAYER_LOCATION, MutantBruteModel::createBodyLayer);
        event.registerLayerDefinition(RottenMutantModel.LAYER_LOCATION, RottenMutantModel::createBodyLayer);
    }
}
