package net.petemc.mutantszombies.entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.petemc.mutantszombies.MutantsZombies;

import java.util.ArrayList;
import java.util.List;

public class ModEntities {
    private static int nextEntityId = 1;

    public static void register(Object ignoredEventBus) {
        registerEntity("blister_zombie",      BlisterZombieEntity.class,      50, 3, true);
        registerEntity("crawler",             CrawlerEntity.class,            15, 3, true);
        registerEntity("spitter",             SpitterEntity.class,            55, 3, true);
        registerEntity("spitter_projectile",  SpitterEntityProjectile.class,  64, 1, true);
        registerEntity("zombie_brute",        ZombieBruteEntity.class,        35, 3, true);
        registerEntity("split_head_zombie",   SplitHeadZombieEntity.class,    50, 3, true);
        registerEntity("mutant_brute",        MutantBruteEntity.class,        35, 3, true);
        registerEntity("rotten_mutant",       RottenMutantEntity.class,       50, 3, true);
    }

    /**
     * Registriert natürliche Spawn-Einträge für alle Overworld-Biome.
     * Muss in FMLInitializationEvent aufgerufen werden, damit BiomeDictionary
     * bereits befüllt ist.
     *
     * Hinweis: BiomeDictionary.Type.OVERWORLD existiert in 1.12.2 nicht.
     * Stattdessen werden alle registrierten Biome verwendet, die weder
     * NETHER noch END sind – entspricht "#minecraft:is_overworld" aus dem
     * forge:add_spawns JSON-System (erst ab Forge 1.18.2 verfügbar).
     */
    public static void registerSpawns() {
        List<Biome> overworldList = new ArrayList<>();
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.END)) {
                overworldList.add(biome);
            }
        }
        Biome[] overworld = overworldList.toArray(new Biome[0]);

        EntityRegistry.addSpawn(BlisterZombieEntity.class,   12, 1, 3, EnumCreatureType.MONSTER, overworld);
        EntityRegistry.addSpawn(CrawlerEntity.class,         10, 1, 3, EnumCreatureType.MONSTER, overworld);
        EntityRegistry.addSpawn(SpitterEntity.class,          9, 1, 2, EnumCreatureType.MONSTER, overworld);
        EntityRegistry.addSpawn(ZombieBruteEntity.class,      8, 1, 2, EnumCreatureType.MONSTER, overworld);
        EntityRegistry.addSpawn(SplitHeadZombieEntity.class, 12, 1, 2, EnumCreatureType.MONSTER, overworld);
        EntityRegistry.addSpawn(MutantBruteEntity.class,      5, 1, 1, EnumCreatureType.MONSTER, overworld);
        EntityRegistry.addSpawn(RottenMutantEntity.class,    12, 1, 3, EnumCreatureType.MONSTER, overworld);
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

