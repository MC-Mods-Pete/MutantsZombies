package net.petemc.mutantszombies.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.petemc.mutantszombies.MutantsZombies;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, MutantsZombies.MOD_ID);

    public static final Supplier<EntityType<BlisterZombieEntity>> BLISTER_ZOMBIE =
            ENTITY_TYPES.register("blister_zombie", () -> EntityType.Builder.of(BlisterZombieEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(50)
                    .setUpdateInterval(3)
                    .sized(0.9F, 2.3F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "blister_zombie"))));
    public static final Supplier<EntityType<CrawlerEntity>> CRAWLER =
            ENTITY_TYPES.register("crawler", () -> EntityType.Builder.of(CrawlerEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(15)
                    .setUpdateInterval(3)
                    .sized(1.1F, 0.9F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "crawler"))));
    public static final Supplier<EntityType<SpitterEntity>> SPITTER =
            ENTITY_TYPES.register("spitter", () -> EntityType.Builder.of(SpitterEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(55)
                    .setUpdateInterval(3)
                    .sized(1.8F, 2.7F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "spitter"))));
    public static final Supplier<EntityType<SpitterEntityProjectile>> SPITTER_PROJECTILE =
            ENTITY_TYPES.register("spitter_projectile", () ->
                    EntityType.Builder.<SpitterEntityProjectile>of(SpitterEntityProjectile::new, MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .sized(0.5F, 0.5F)
                            .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "spitter_projectile"))));
    public static final Supplier<EntityType<ZombieBruteEntity>> ZOMBIE_BRUTE =
            ENTITY_TYPES.register("zombie_brute", () -> EntityType.Builder.of(ZombieBruteEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(35)
                    .setUpdateInterval(3)
                    .sized(2.0F, 2.7F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "zombie_brute"))));
    public static final Supplier<EntityType<SplitHeadZombieEntity>> SPLIT_HEAD_ZOMBIE =
            ENTITY_TYPES.register("split_head_zombie", () -> EntityType.Builder.of(SplitHeadZombieEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(50)
                    .setUpdateInterval(3)
                    .sized(0.9F, 2.5F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "split_head_zombie"))));
    public static final Supplier<EntityType<MutantBruteEntity>> MUTANT_BRUTE =
            ENTITY_TYPES.register("mutant_brute", () -> EntityType.Builder.of(MutantBruteEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(35)
                    .setUpdateInterval(3)
                    .sized(3.4F, 3.5F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "mutant_brute"))));

    public static void initModEntities() {
        //BlisterZombieEntity.init();
        //CrawlerEntity.init();
        //ZombieBruteEntity.init();
        //SpitterEntity.init();
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

