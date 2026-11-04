package net.petemc.mutantszombies.event;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.*;

@EventBusSubscriber(modid = MutantsZombies.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void spawnPlacementEvent(RegisterSpawnPlacementsEvent event) {
        event.register(
                ModEntities.BLISTER_ZOMBIE.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BlisterZombieEntity::checkBlisterZombieSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.CRAWLER.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                CrawlerEntity::checkCrawlerSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.SPITTER.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SpitterEntity::checkSpitterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.ZOMBIE_BRUTE.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ZombieBruteEntity::checkZombieBruteSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.SPLIT_HEAD_ZOMBIE.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SplitHeadZombieEntity::checkSplitHeadZombieSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.MUTANT_BRUTE.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MutantBruteEntity::checkMutantBruteSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.ROTTEN_MUTANT.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                RottenMutantEntity::checkRottenMutantSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
