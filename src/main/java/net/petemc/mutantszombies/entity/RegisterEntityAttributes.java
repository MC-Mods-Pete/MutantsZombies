package net.petemc.mutantszombies.entity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.petemc.mutantszombies.MutantsZombies;

public class RegisterEntityAttributes {
    @EventBusSubscriber(modid = MutantsZombies.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntities.BLISTER_ZOMBIE.get(), BlisterZombieEntity.createAttributes().build());
            event.put(ModEntities.CRAWLER.get(), CrawlerEntity.createAttributes().build());
            event.put(ModEntities.SPITTER.get(), SpitterEntity.createAttributes().build());
            event.put(ModEntities.ZOMBIE_BRUTE.get(), ZombieBruteEntity.createAttributes().build());
            event.put(ModEntities.SPLIT_HEAD_ZOMBIE.get(), SplitHeadZombieEntity.createAttributes().build());
            event.put(ModEntities.MUTANT_BRUTE.get(), MutantBruteEntity.createAttributes().build());
        }
    }

}


