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

    public static boolean getSpittersSpawnNaturally() {
        return spittersSpawnNaturally;
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

    public static boolean getRottenMutantsSpawnNaturally() {
        return rottenMutantsSpawnNaturally;
    }

    public static boolean getSpittersBreakLogsAndLeavesAroundThem() {
        return spittersBreakLogsAndLeavesAroundThem;
    }

    public static boolean getZombieBrutesBreakLogsAndLeavesAroundThem() {
        return zombieBrutesBreakLogsAndLeavesAroundThem;
    }

    public static boolean getMutantBrutesBreakLogsAndLeavesAroundThem() {
        return mutantBrutesBreakLogsAndLeavesAroundThem;
    }

    // Server Config
    private static final ModConfigSpec.Builder BUILDER_SERVER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue BLISTER_ZOMBIES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Blister Zombies will spawn naturally | default: true")
            .define("blisterZombiesSpawnNaturally", true);

    private static final ModConfigSpec.BooleanValue CRAWLERS_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Crawlers will spawn naturally | default: true")
            .define("crawlersSpawnNaturally", true);

    private static final ModConfigSpec.BooleanValue SPITTERS_SPAWN_NATURALLY = BUILDER_SERVER
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

    private static final ModConfigSpec.BooleanValue ROTTEN_MUTANTS_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Rotten Mutants will spawn naturally | default: true")
            .define("rottenMutantSpawnNaturally", true);

    private static final ModConfigSpec.BooleanValue SPITTERS_BREAK_LOGS_AND_LEAVES = BUILDER_SERVER
            .comment("If true, Spitters will break logs and leaves in their path | default: false")
            .define("spittersBreakLogsAndLeavesAroundThem", false);

    private static final ModConfigSpec.BooleanValue ZOMBIE_BRUTES_BREAK_LOGS_AND_LEAVES = BUILDER_SERVER
            .comment("If true, Zombie Brutes will break logs and leaves in their path | default: false")
            .define("zombieBrutesBreakLogsAndLeavesAroundThem", false);

    private static final ModConfigSpec.BooleanValue MUTANT_BRUTES_BREAK_LOGS_AND_LEAVES = BUILDER_SERVER
            .comment("If true, Mutant Brutes will break logs and leaves in their path | default: false")
            .define("mutantBrutesBreakLogsAndLeavesAroundThem", false);

   public static final ModConfigSpec SPEC_SERVER = BUILDER_SERVER.build();

    // Client Config
    private static final ModConfigSpec.Builder BUILDER_CLIENT = new ModConfigSpec.Builder();
    // no client config
    public static final ModConfigSpec SPEC_CLIENT = BUILDER_CLIENT.build();


    private static boolean blisterZombiesSpawnNaturally = true;
    private static boolean crawlersSpawnNaturally = true;
    private static boolean spittersSpawnNaturally = true;
    private static boolean zombieBrutesSpawnNaturally = true;
    private static boolean splitHeadZombieSpawnNaturally = true;
    private static boolean mutantBrutesSpawnNaturally = true;
    private static boolean rottenMutantsSpawnNaturally = true;
    private static boolean spittersBreakLogsAndLeavesAroundThem = false;
    private static boolean zombieBrutesBreakLogsAndLeavesAroundThem = false;
    private static boolean mutantBrutesBreakLogsAndLeavesAroundThem = false;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        if (SPEC_SERVER.isLoaded()) {
            MutantsZombies.LOGGER.info("Loading {} server config", MutantsZombies.MOD_ID);
            blisterZombiesSpawnNaturally = BLISTER_ZOMBIES_SPAWN_NATURALLY.get();
            crawlersSpawnNaturally = CRAWLERS_SPAWN_NATURALLY.get();
            spittersSpawnNaturally = SPITTERS_SPAWN_NATURALLY.get();
            zombieBrutesSpawnNaturally = ZOMBIE_BRUTES_SPAWN_NATURALLY.get();
            splitHeadZombieSpawnNaturally = SPLIT_HEAD_ZOMBIES_SPAWN_NATURALLY.get();
            mutantBrutesSpawnNaturally = MUTANT_BRUTES_SPAWN_NATURALLY.get();
            rottenMutantsSpawnNaturally = ROTTEN_MUTANTS_SPAWN_NATURALLY.get();
            spittersBreakLogsAndLeavesAroundThem = SPITTERS_BREAK_LOGS_AND_LEAVES.get();
            zombieBrutesBreakLogsAndLeavesAroundThem = ZOMBIE_BRUTES_BREAK_LOGS_AND_LEAVES.get();
            mutantBrutesBreakLogsAndLeavesAroundThem = MUTANT_BRUTES_BREAK_LOGS_AND_LEAVES.get();
        }
        if (SPEC_CLIENT.isLoaded()) {
            MutantsZombies.LOGGER.info("Loading {} client config", MutantsZombies.MOD_ID);
           // no client config
        }
    }
}
