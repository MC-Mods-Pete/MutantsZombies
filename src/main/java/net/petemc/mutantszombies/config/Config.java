package net.petemc.mutantszombies.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.petemc.mutantszombies.MutantsZombies;

@Mod.EventBusSubscriber(modid = MutantsZombies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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

    // Server Config
    private static final ForgeConfigSpec.Builder BUILDER_SERVER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue BLISTER_ZOMBIES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Blister Zombies will spawn naturally | default: true")
            .define("blisterZombiesSpawnNaturally", true);

    private static final ForgeConfigSpec.BooleanValue CRAWLERS_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Crawlers will spawn naturally | default: true")
            .define("crawlersSpawnNaturally", true);

    private static final ForgeConfigSpec.BooleanValue SPITTER_ZOMBIES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Spitter Zombies will spawn naturally | default: true")
            .define("spitterZombiesSpawnNaturally", true);

    private static final ForgeConfigSpec.BooleanValue ZOMBIE_BRUTES_SPAWN_NATURALLY = BUILDER_SERVER
            .comment("If true, Zombie Brutes will spawn naturally | default: true")
            .define("zombieBrutesSpawnNaturally", true);

   public static final ForgeConfigSpec SPEC_SERVER = BUILDER_SERVER.build();

    // Client Config
    private static final ForgeConfigSpec.Builder BUILDER_CLIENT = new ForgeConfigSpec.Builder();
    // no client config
    public static final ForgeConfigSpec SPEC_CLIENT = BUILDER_CLIENT.build();


    private static boolean blisterZombiesSpawnNaturally = true;
    private static boolean crawlersSpawnNaturally = true;
    private static boolean spitterZombiesSpawnNaturally = true;
    private static boolean zombieBrutesSpawnNaturally = true;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        if (SPEC_SERVER.isLoaded()) {
            MutantsZombies.LOGGER.info("Loading {} server config", MutantsZombies.MOD_ID);
            blisterZombiesSpawnNaturally = BLISTER_ZOMBIES_SPAWN_NATURALLY.get();
            crawlersSpawnNaturally = CRAWLERS_SPAWN_NATURALLY.get();
            spitterZombiesSpawnNaturally = SPITTER_ZOMBIES_SPAWN_NATURALLY.get();
            zombieBrutesSpawnNaturally = ZOMBIE_BRUTES_SPAWN_NATURALLY.get();
        }
        if (SPEC_CLIENT.isLoaded()) {
            MutantsZombies.LOGGER.info("Loading {} client config", MutantsZombies.MOD_ID);
           // no client config
        }
    }
}
