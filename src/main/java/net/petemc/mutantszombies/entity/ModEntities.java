package net.petemc.mutantszombies.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.petemc.mutantszombies.MutantsZombies;

public class ModEntities {
    public static final EntityType<BlisterZombieEntity> BLISTER_ZOMBIE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "blister_zombie"),
            FabricEntityType.Builder.createMob(BlisterZombieEntity::new, MobCategory.MONSTER,
                            mob -> mob.spawnPlacement(SpawnPlacementTypes.ON_GROUND,
                                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                                    Monster::checkMonsterSpawnRules))
                    .clientTrackingRange(50)
                    .updateInterval(3)
                    .sized(0.9f, 2.3f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "blister_zombie"))));

    public static final EntityType<CrawlerEntity> CRAWLER = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "crawler"),
            FabricEntityType.Builder.createMob(CrawlerEntity::new, MobCategory.MONSTER,
                            mob -> mob.spawnPlacement(SpawnPlacementTypes.ON_GROUND,
                                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                                    Monster::checkMonsterSpawnRules))
                    .clientTrackingRange(15)
                    .updateInterval(3)
                    .sized(1.1f, 0.9f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "crawler"))));

    public static final EntityType<SpitterEntity> SPITTER = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "spitter"),
            FabricEntityType.Builder.createMob(SpitterEntity::new, MobCategory.MONSTER,
                            mob -> mob.spawnPlacement(SpawnPlacementTypes.ON_GROUND,
                                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                                    Monster::checkMonsterSpawnRules))
                    .clientTrackingRange(55)
                    .updateInterval(3)
                    .sized(1.8f, 2.7f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "spitter"))));

    public static final EntityType<SpitterEntityProjectile> SPITTER_PROJECTILE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "spitter_projectile"),
            EntityType.Builder.<SpitterEntityProjectile>of(SpitterEntityProjectile::new, MobCategory.MISC)
                    .clientTrackingRange(64)
                    .updateInterval(1)
                    .sized(0.5f, 0.5f)
                    .noSummon()
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "spitter_projectile"))));

    public static final EntityType<ZombieBruteEntity> ZOMBIE_BRUTE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "zombie_brute"),
            FabricEntityType.Builder.createMob(ZombieBruteEntity::new, MobCategory.MONSTER,
                            mob -> mob.spawnPlacement(SpawnPlacementTypes.ON_GROUND,
                                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                                    Monster::checkMonsterSpawnRules))
                    .clientTrackingRange(35)
                    .updateInterval(3)
                    .sized(2.0f, 2.7f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "zombie_brute"))));

    public static final EntityType<SplitHeadZombieEntity> SPLIT_HEAD_ZOMBIE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "split_head_zombie"),
            FabricEntityType.Builder.createMob(SplitHeadZombieEntity::new, MobCategory.MONSTER,
                            mob -> mob.spawnPlacement(SpawnPlacementTypes.ON_GROUND,
                                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                                    Monster::checkMonsterSpawnRules))
                    .clientTrackingRange(50)
                    .updateInterval(3)
                    .sized(0.9f, 2.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "split_head_zombie"))));

    public static final EntityType<MutantBruteEntity> MUTANT_BRUTE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "mutant_brute"),
            FabricEntityType.Builder.createMob(MutantBruteEntity::new, MobCategory.MONSTER,
                            mob -> mob.spawnPlacement(SpawnPlacementTypes.ON_GROUND,
                                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                                    Monster::checkMonsterSpawnRules))
                    .clientTrackingRange(35)
                    .updateInterval(3)
                    .sized(3.4f, 3.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "mutant_brute"))));

    public static final EntityType<RottenMutantEntity> ROTTEN_MUTANT = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID,"rotten_mutant"),
            FabricEntityType.Builder.createMob(RottenMutantEntity::new, MobCategory.MONSTER,
                            mob -> mob.spawnPlacement(SpawnPlacementTypes.ON_GROUND,
                                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                                    Monster::checkMonsterSpawnRules))
                    .clientTrackingRange(50)
                    .updateInterval(3)
                    .sized(0.9F, 2.7f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "rotten_mutant"))));


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
