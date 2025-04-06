package net.petemc.mutantszombies.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;

public class ModEntities {
    public static final EntityType<BlisterZombieEntity> BLISTER_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "blister_zombie"),
            EntityType.Builder.create(BlisterZombieEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(50)
                    .trackingTickInterval(3)
                    .dimensions(0.9f, 2.7f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "blister_zombie").toString()));

    public static final EntityType<CrawlerEntity> CRAWLER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "crawler"),
            EntityType.Builder.create(CrawlerEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(15)
                    .trackingTickInterval(3)
                    .dimensions(0.6f, 0.8f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "crawler").toString()));

    public static final EntityType<SpitterEntity> SPITTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "spitter"),
            EntityType.Builder.create(SpitterEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(55)
                    .trackingTickInterval(3)
                    .dimensions(2.2f, 3.0f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "spitter").toString()));

    public static final EntityType<SpitterEntityProjectile> SPITTER_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "spitter_projectile"),
            EntityType.Builder.<SpitterEntityProjectile>create(SpitterEntityProjectile::new, SpawnGroup.MISC)
                    .maxTrackingRange(64)
                    .trackingTickInterval(1)
                    .dimensions(0.5f, 0.5f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "spitter_projectile").toString()));

    public static final EntityType<ZombieBruteEntity> ZOMBIE_BRUTE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MutantsZombies.MOD_ID, "zombie_brute"),
            EntityType.Builder.create(ZombieBruteEntity::new, SpawnGroup.MONSTER)
                    .maxTrackingRange(35)
                    .trackingTickInterval(3)
                    .dimensions(2.7f, 3.0f)
                    .build(Identifier.of(MutantsZombies.MOD_ID, "zombie_brute").toString()));

    public static void initModEntities() {
        BlisterZombieEntity.init();
        CrawlerEntity.init();
        ZombieBruteEntity.init();
        SpitterEntity.init();
    }
}

