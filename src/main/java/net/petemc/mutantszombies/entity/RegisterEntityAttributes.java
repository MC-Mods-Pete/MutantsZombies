package net.petemc.mutantszombies.entity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.petemc.mutantszombies.MutantsZombies;

public class RegisterEntityAttributes {
    @Mod.EventBusSubscriber(modid = MutantsZombies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntities.BLISTER_ZOMBIE.get(), BlisterZombieEntity.createAttributes().build());
            event.put(ModEntities.CRAWLER.get(), CrawlerEntity.createAttributes().build());
            event.put(ModEntities.SPITTER.get(), SpitterEntity.createAttributes().build());
            event.put(ModEntities.ZOMBIE_BRUTE.get(), ZombieBruteEntity.createAttributes().build());
            event.put(ModEntities.SPLIT_HEAD_ZOMBIE.get(), SplitHeadZombieEntity.createAttributes().build());
            event.put(ModEntities.MUTANT_BRUTE.get(), MutantBruteEntity.createAttributes().build());
            event.put(ModEntities.ROTTEN_MUTANT.get(), RottenMutantEntity.createAttributes().build());
            event.put(ModEntities.MUTANT_ZOMBIE.get(), MutantZombieEntity.createAttributes().build());
        }
    }

}


