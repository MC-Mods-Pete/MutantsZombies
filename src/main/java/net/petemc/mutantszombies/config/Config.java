package net.petemc.mutantszombies.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.petemc.mutantszombies.MutantsZombies;

@EventBusSubscriber(modid = MutantsZombies.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    public static boolean getBlisterZombiesSpawnNaturally() {
        return blisterZombiesSpawnNaturally;
    }

    public static boolean getCrawlersSpawnNaturally() {
        return crawlersSpawnNaturally;
    }

    public static boolean getSpitterZombiesSpawnNaturally() {
        return spitterZombiesSpawnNaturally;
    }

    public static boolean getZombieBrutesSpawnNaturally() {
        return zombieBrutesSpawnNaturally;
    }

    public static boolean getSplitHeadZombiesSpawnNaturally() {
        return splitHeadZombieSpawnNaturally;
    }

    public static boolean getMutantBrutesSpawnNaturally() {
        return mutantBrutesSpawnNaturally;
    }

    // Server Config
    private static final ModConfigSpec.Builder BUILDER_SERVER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue BLISTER_ZOMBIES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Blister Zombies will spawn naturally | default: true")
            .define("blisterZombiesSpawnNaturally", true);

    private static final ModConfigSpec.BooleanValue CRAWLERS_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Crawlers will spawn naturally | default: true")
            .define("crawlersSpawnNaturally", true);

    private static final ModConfigSpec.BooleanValue SPITTER_ZOMBIES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Spitter Zombies will spawn naturally | default: true")
            .define("spitterZombiesSpawnNaturally", true);

    private static final ModConfigSpec.BooleanValue ZOMBIE_BRUTES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Zombie Brutes will spawn naturally | default: true")
            .define("zombieBrutesSpawnNaturally", true);

    private static final ModConfigSpec.BooleanValue SPLIT_HEAD_ZOMBIES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Split Head Zombies will spawn naturally | default: true")
            .define("splitHeadZombieSpawnNaturally", true);

    private static final ModConfigSpec.BooleanValue MUTANT_BRUTES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Mutant Brutes will spawn naturally | default: true")
            .define("mutantBrutesSpawnNaturally", true);

   public static final ModConfigSpec SPEC_SERVER = BUILDER_SERVER.build();

    // Client Config
    private static final ModConfigSpec.Builder BUILDER_CLIENT = new ModConfigSpec.Builder();
    // no client config
    public static final ModConfigSpec SPEC_CLIENT = BUILDER_CLIENT.build();


    private static boolean blisterZombiesSpawnNaturally = true;
    private static boolean crawlersSpawnNaturally = true;
    private static boolean spitterZombiesSpawnNaturally = true;
    private static boolean zombieBrutesSpawnNaturally = true;
    private static boolean splitHeadZombieSpawnNaturally = true;
    private static boolean mutantBrutesSpawnNaturally = true;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        if (SPEC_SERVER.isLoaded()) {
            MutantsZombies.LOGGER.info("Loading {} server config", MutantsZombies.MOD_ID);
            blisterZombiesSpawnNaturally = BLISTER_ZOMBIES_SPAWN_NATURALLY.get();
            crawlersSpawnNaturally = CRAWLERS_SPAWN_NATURALLY.get();
            spitterZombiesSpawnNaturally = SPITTER_ZOMBIES_SPAWN_NATURALLY.get();
            zombieBrutesSpawnNaturally = ZOMBIE_BRUTES_SPAWN_NATURALLY.get();
            splitHeadZombieSpawnNaturally = SPLIT_HEAD_ZOMBIES_SPAWN_NATURALLY.get();
            mutantBrutesSpawnNaturally = MUTANT_BRUTES_SPAWN_NATURALLY.get();
        }
        if (SPEC_CLIENT.isLoaded()) {
            MutantsZombies.LOGGER.info("Loading {} client config", MutantsZombies.MOD_ID);
           // no client config
        }
    }
}
