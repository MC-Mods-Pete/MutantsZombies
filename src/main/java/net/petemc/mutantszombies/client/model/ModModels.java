package net.petemc.mutantszombies.client.model;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, value = {Dist.CLIENT})
public class ModModels {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SpitterModel.LAYER_LOCATION, SpitterModel::createBodyLayer);
        event.registerLayerDefinition(BlisterZombieModel.LAYER_LOCATION, BlisterZombieModel::createBodyLayer);
        event.registerLayerDefinition(CrawlerModel.LAYER_LOCATION, CrawlerModel::createBodyLayer);
        event.registerLayerDefinition(ZombieBruteModel.LAYER_LOCATION, ZombieBruteModel::createBodyLayer);
        event.registerLayerDefinition(SplitHeadZombieModel.LAYER_LOCATION, SplitHeadZombieModel::createBodyLayer);
        event.registerLayerDefinition(MutantBruteModel.LAYER_LOCATION, MutantBruteModel::createBodyLayer);
        event.registerLayerDefinition(RottenMutantModel.LAYER_LOCATION, RottenMutantModel::createBodyLayer);
    }
}
