package net.petemc.mutantszombies.entity;

import net.minecraftforge.eventbus.api.IEventBus;
import net.petemc.mutantszombies.MutantsZombies;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MutantsZombies.MOD_ID);

    public static final RegistryObject<EntityType<BlisterZombieEntity>> BLISTER_ZOMBIE =
            ENTITY_TYPES.register("blister_zombie", () -> EntityType.Builder.of(BlisterZombieEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(50)
                    .setUpdateInterval(3)
                    .sized(0.9F, 2.3F)
                    .build("blister_zombie"));
    public static final RegistryObject<EntityType<CrawlerEntity>> CRAWLER =
            ENTITY_TYPES.register("crawler", () -> EntityType.Builder.of(CrawlerEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(15)
                    .setUpdateInterval(3)
                    .sized(1.1F, 0.9F)
                    .build("crawler"));
    public static final RegistryObject<EntityType<SpitterEntity>> SPITTER =
            ENTITY_TYPES.register("spitter", () -> EntityType.Builder.of(SpitterEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(55)
                    .setUpdateInterval(3)
                    .sized(1.8F, 2.7F)
                    .build("spitter"));
    public static final RegistryObject<EntityType<SpitterEntityProjectile>> SPITTER_PROJECTILE =
            ENTITY_TYPES.register("spitter_projectile", () ->
                    EntityType.Builder.<SpitterEntityProjectile>of(SpitterEntityProjectile::new, MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .sized(0.5F, 0.5F)
                    .noSummon()
                    .build("spitter_projectile"));
    public static final RegistryObject<EntityType<ZombieBruteEntity>> ZOMBIE_BRUTE =
            ENTITY_TYPES.register("zombie_brute", () -> EntityType.Builder.of(ZombieBruteEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(35)
                    .setUpdateInterval(3)
                    .sized(2.0F, 2.7F)
                    .build("zombie_brute"));
    public static final RegistryObject<EntityType<SplitHeadZombieEntity>> SPLIT_HEAD_ZOMBIE =
            ENTITY_TYPES.register("split_head_zombie", () -> EntityType.Builder.of(SplitHeadZombieEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(50)
                    .setUpdateInterval(3)
                    .sized(0.9F, 2.5F)
                    .build("split_head_zombie"));
    public static final RegistryObject<EntityType<MutantBruteEntity>> MUTANT_BRUTE =
            ENTITY_TYPES.register("mutant_brute", () -> EntityType.Builder.of(MutantBruteEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(35)
                    .setUpdateInterval(3)
                    .sized(3.4F, 3.5F)
                    .build("mutant_brute"));
    public static final RegistryObject<EntityType<RottenMutantEntity>> ROTTEN_MUTANT =
            ENTITY_TYPES.register("rotten_mutant", () -> EntityType.Builder.of(RottenMutantEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(50)
                    .setUpdateInterval(3)
                    .sized(0.9F, 2.7F)
                    .build("rotten_mutant"));

    public static void initModEntities() {
        BlisterZombieEntity.init();
        CrawlerEntity.init();
        ZombieBruteEntity.init();
        SpitterEntity.init();
        SplitHeadZombieEntity.init();
        MutantBruteEntity.init();
        RottenMutantEntity.init();
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

