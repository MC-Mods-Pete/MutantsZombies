package net.petemc.mutantszombies.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;

import java.util.Objects;

public class ModEntities {
    public static final EntityType<BlisterZombieEntity> BLISTER_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "blister_zombie"),
            EntityType.Builder.create(BlisterZombieEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(50)
                    .trackingTickInterval(3)
                    .dimensions(0.9f, 2.3f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "blister_zombie").toString()));

    public static final EntityType<CrawlerEntity> CRAWLER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "crawler"),
            EntityType.Builder.create(CrawlerEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(15)
                    .trackingTickInterval(3)
                    .dimensions(1.1f, 0.9f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "crawler").toString()));

    public static final EntityType<SpitterEntity> SPITTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "spitter"),
            EntityType.Builder.create(SpitterEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(55)
                    .trackingTickInterval(3)
                    .dimensions(1.8f, 2.7f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "spitter").toString()));

    public static final EntityType<SpitterEntityProjectile> SPITTER_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "spitter_projectile"),
            EntityType.Builder.<SpitterEntityProjectile>create(SpitterEntityProjectile::new, SpawnGroup.MISC)
                    .maxTrackingRange(64)
                    .trackingTickInterval(1)
                    .dimensions(0.5f, 0.5f)
                    .disableSummon()
                    .build(Identifier.of(MutantsZombies.MOD_ID, "spitter_projectile").toString()));

    public static final EntityType<ZombieBruteEntity> ZOMBIE_BRUTE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "zombie_brute"),
            EntityType.Builder.create(ZombieBruteEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(35)
                    .trackingTickInterval(3)
                    .dimensions(2.0f, 2.7f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "zombie_brute").toString()));

    public static final EntityType<SplitHeadZombieEntity> SPLIT_HEAD_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "split_head_zombie"),
            EntityType.Builder.create(SplitHeadZombieEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(50)
                    .trackingTickInterval(3)
                    .dimensions(0.9f, 2.5f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "split_head_zombie").toString()));

    public static final EntityType<MutantBruteEntity> MUTANT_BRUTE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "mutant_brute"),
            EntityType.Builder.create(MutantBruteEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(35)
                    .trackingTickInterval(3)
                    .dimensions(3.4f, 3.5f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "mutant_brute").toString()));

    public static final EntityType<RottenMutantEntity> ROTTEN_MUTANT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID,"rotten_mutant"),
            EntityType.Builder.create(RottenMutantEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(50)
                    .trackingTickInterval(3)
                    .dimensions(0.9F, 2.7f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "rotten_mutant").toString()));

    public static void initModEntities() {
        BlisterZombieEntity.init();
        CrawlerEntity.init();
        ZombieBruteEntity.init();
        SpitterEntity.init();
        SplitHeadZombieEntity.init();
        MutantBruteEntity.init();
        RottenMutantEntity.init();
    }
}

