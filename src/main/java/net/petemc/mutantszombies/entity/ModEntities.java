package net.petemc.mutantszombies.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.petemc.mutantszombies.MutantsZombies;

public class ModEntities {
    private static int nextEntityId = 1;

    public static void register(Object ignoredEventBus) {
        registerEntity("blister_zombie", BlisterZombieEntity.class, 50, 3, true);
        registerEntity("crawler", CrawlerEntity.class, 15, 3, true);
        registerEntity("spitter", SpitterEntity.class, 55, 3, true);
        registerEntity("spitter_projectile", SpitterEntityProjectile.class, 64, 1, true);
        registerEntity("zombie_brute", ZombieBruteEntity.class, 35, 3, true);
        registerEntity("split_head_zombie", SplitHeadZombieEntity.class, 50, 3, true);
        registerEntity("mutant_brute", MutantBruteEntity.class, 35, 3, true);
        registerEntity("rotten_mutant", RottenMutantEntity.class, 50, 3, true);
    }

    public static void initModEntities() {
        BlisterZombieEntity.init();
        CrawlerEntity.init();
        ZombieBruteEntity.init();
        SpitterEntity.init();
        SplitHeadZombieEntity.init();
        MutantBruteEntity.init();
        RottenMutantEntity.init();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void registerEntity(String name, Class entityClass, int trackingRange, int updateInterval, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(
            new ResourceLocation(MutantsZombies.MOD_ID, name),
            entityClass,
            name,
            nextEntityId++,
            MutantsZombies.MOD_ID,
            trackingRange,
            updateInterval,
            sendsVelocityUpdates
        );
    }
}
