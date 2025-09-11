package net.petemc.mutantszombies.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;

public class ModEntities {
    public static final EntityType<BlisterZombieEntity> BLISTER_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "blister_zombie"),
            EntityType.Builder.create(BlisterZombieEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(50)
                    .trackingTickInterval(3)
                    .dimensions(0.9f, 2.3f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MutantsZombies.MOD_ID, "blister_zombie"))));

    public static final EntityType<CrawlerEntity> CRAWLER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "crawler"),
            EntityType.Builder.create(CrawlerEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(15)
                    .trackingTickInterval(3)
                    .dimensions(1.1f, 0.9f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MutantsZombies.MOD_ID, "crawler"))));

    public static final EntityType<SpitterEntity> SPITTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "spitter"),
            EntityType.Builder.create(SpitterEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(55)
                    .trackingTickInterval(3)
                    .dimensions(1.8f, 2.7f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MutantsZombies.MOD_ID, "spitter"))));

    public static final EntityType<SpitterEntityProjectile> SPITTER_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "spitter_projectile"),
            EntityType.Builder.<SpitterEntityProjectile>create(SpitterEntityProjectile::new, SpawnGroup.MISC)
                    .maxTrackingRange(64)
                    .trackingTickInterval(1)
                    .dimensions(0.5f, 0.5f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MutantsZombies.MOD_ID, "spitter_projectile"))));

    public static final EntityType<ZombieBruteEntity> ZOMBIE_BRUTE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "zombie_brute"),
            EntityType.Builder.create(ZombieBruteEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(35)
                    .trackingTickInterval(3)
                    .dimensions(2.0f, 2.7f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MutantsZombies.MOD_ID, "zombie_brute"))));

    public static final EntityType<SplitHeadZombieEntity> SPLIT_HEAD_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "split_head_zombie"),
            EntityType.Builder.create(SplitHeadZombieEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(50)
                    .trackingTickInterval(3)
                    .dimensions(0.9f, 2.5f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MutantsZombies.MOD_ID, "split_head_zombie"))));

    public static final EntityType<MutantBruteEntity> MUTANT_BRUTE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "mutant_brute"),
            EntityType.Builder.create(MutantBruteEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(35)
                    .trackingTickInterval(3)
                    .dimensions(3.4f, 3.5f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MutantsZombies.MOD_ID, "mutant_brute"))));

    public static void initModEntities() {
        BlisterZombieEntity.init();
        CrawlerEntity.init();
        ZombieBruteEntity.init();
        SpitterEntity.init();
        SplitHeadZombieEntity.init();
        MutantBruteEntity.init();
    }
}

