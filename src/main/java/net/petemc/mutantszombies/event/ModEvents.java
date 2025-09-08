package net.petemc.mutantszombies.event;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.*;

public class ModEvents {
    @EventBusSubscriber(modid = MutantsZombies.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void spawnPlacementEvent(RegisterSpawnPlacementsEvent event) {
            event.register(ModEntities.BLISTER_ZOMBIE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    BlisterZombieEntity::checkBlisterZombieSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

            event.register(ModEntities.CRAWLER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    CrawlerEntity::checkCrawlerSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

            event.register(ModEntities.SPITTER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    SpitterEntity::checkSpitterSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

            event.register(ModEntities.ZOMBIE_BRUTE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    ZombieBruteEntity::checkZombieBruteSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

            event.register(ModEntities.SPLIT_HEAD_ZOMBIE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    SplitHeadZombieEntity::checkSplitHeadZombieSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

            event.register(ModEntities.MUTANT_BRUTE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    MutantBruteEntity::checkMutantBruteSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        }
    }
}


