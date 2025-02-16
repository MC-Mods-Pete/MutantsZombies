package net.petemc.mutantszombies.entity;

import net.minecraftforge.eventbus.api.IEventBus;
import net.petemc.mutantszombies.MutantsZombies;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//@EventBusSubscriber(
 //       bus = Bus.MOD
//)
public class ModEntities {
    //public static final DeferredRegister<EntityType<?>> REGISTRY;
    //public static final RegistryObject<EntityType<BlisterZombieEntity>> BLISTER_ZOMBIE;
    //public static final RegistryObject<EntityType<CrawlerZombieEntity>> CRAWLER_ZOMBIE;
    //public static final RegistryObject<EntityType<SpitterZombieEntity>> SPITTER_ZOMBIE;
    //public static final RegistryObject<EntityType<SpitterZombieEntityProjectile>> SPITTER_ZOMBIE_PROJECTILE;
    //public static final RegistryObject<EntityType<ZombieBruteEntity>> ZOMBIE_BRUTE;
/*
    public ModEntities() {
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    static {
        //REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MutantsZombies.MOD_ID);
        //BLISTER_ZOMBIE = register("blister_zombie", Builder.of(BlisterZombieEntity::new, MobCategory.MONSTER)
        // .setShouldReceiveVelocityUpdates(true).setTrackingRange(50).setUpdateInterval(3).fireImmune().sized(0.9F, 2.7F));
        //CRAWLER_ZOMBIE = register("crawler_zombie", Builder.of(CrawlerZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(15).setUpdateInterval(3).fireImmune().sized(0.6F, 0.8F));
        SPITTER_ZOMBIE = register("spitter_zombie", Builder.of(SpitterZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(55).setUpdateInterval(3).fireImmune().sized(2.2F, 3.0F));
        SPITTER_ZOMBIE_PROJECTILE = register("projectile_spitter_zombie", Builder.<SpitterZombieEntityProjectile>of(SpitterZombieEntityProjectile::new, MobCategory.MISC)
                .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5F, 0.5F));
        //ZOMBIE_BRUTE = register("zombie_brute", Builder.of(ZombieBruteEntity::new, MobCategory.MONSTER)
        // .setShouldReceiveVelocityUpdates(true).setTrackingRange(35).setUpdateInterval(3).fireImmune().sized(2.7F, 3.0F));
    }

 */


    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MutantsZombies.MOD_ID);

    public static final RegistryObject<EntityType<BlisterZombieEntity>> BLISTER_ZOMBIE =
            ENTITY_TYPES.register("blister_zombie", () -> EntityType.Builder.of(BlisterZombieEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(50)
                    .setUpdateInterval(3)
                    .sized(0.9F, 2.7F)
                    .build("blister_zombie"));
    public static final RegistryObject<EntityType<CrawlerZombieEntity>> CRAWLER_ZOMBIE =
            ENTITY_TYPES.register("crawler_zombie", () -> EntityType.Builder.of(CrawlerZombieEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(15)
                    .setUpdateInterval(3)
                    .sized(0.6F, 0.8F)
                    .build("crawler_zombie"));
    public static final RegistryObject<EntityType<SpitterZombieEntity>> SPITTER_ZOMBIE =
            ENTITY_TYPES.register("spitter_zombie", () -> EntityType.Builder.of(SpitterZombieEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(55)
                    .setUpdateInterval(3)
                    .sized(2.2F, 3.0F)
                    .build("spitter_zombie"));
    public static final RegistryObject<EntityType<SpitterZombieEntityProjectile>> SPITTER_ZOMBIE_PROJECTILE =
            ENTITY_TYPES.register("spitter_zombie_projectile", () ->
                    EntityType.Builder.<SpitterZombieEntityProjectile>of(SpitterZombieEntityProjectile::new, MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .sized(0.5F, 0.5F)
                    .build("spitter_zombie_projectile"));
    public static final RegistryObject<EntityType<ZombieBruteEntity>> ZOMBIE_BRUTE =
            ENTITY_TYPES.register("zombie_brute", () -> EntityType.Builder.of(ZombieBruteEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(35)
                    .setUpdateInterval(3)
                    .sized(2.7F, 3.0F)
                    .build("zombie_brute"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

