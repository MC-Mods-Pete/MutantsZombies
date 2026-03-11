package net.petemc.mutantszombies.config;

import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.petemc.mutantszombies.MutantsZombies;

@net.minecraftforge.common.config.Config(modid = MutantsZombies.MOD_ID)
@Mod.EventBusSubscriber(modid = MutantsZombies.MOD_ID)
public class Config {
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

    public static boolean getRottenMutantSpawnNaturally() {
        return rottenMutantSpawnNaturally;
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

    @net.minecraftforge.common.config.Config.Name("blisterZombiesSpawnNaturally")
    @net.minecraftforge.common.config.Config.Comment("If true, Blister Zombies will spawn naturally | default: true")
    public static boolean blisterZombiesSpawnNaturally = true;

    @net.minecraftforge.common.config.Config.Name("crawlersSpawnNaturally")
    @net.minecraftforge.common.config.Config.Comment("If true, Crawlers will spawn naturally | default: true")
    public static boolean crawlersSpawnNaturally = true;

    @net.minecraftforge.common.config.Config.Name("spitterZombiesSpawnNaturally")
    @net.minecraftforge.common.config.Config.Comment("If true, Spitter Zombies will spawn naturally | default: true")
    public static boolean spittersSpawnNaturally = true;

    @net.minecraftforge.common.config.Config.Name("zombieBrutesSpawnNaturally")
    @net.minecraftforge.common.config.Config.Comment("If true, Zombie Brutes will spawn naturally | default: true")
    public static boolean zombieBrutesSpawnNaturally = true;

    @net.minecraftforge.common.config.Config.Name("splitHeadZombieSpawnNaturally")
    @net.minecraftforge.common.config.Config.Comment("If true, Split Head Zombies will spawn naturally | default: true")
    public static boolean splitHeadZombieSpawnNaturally = true;

    @net.minecraftforge.common.config.Config.Name("mutantBrutesSpawnNaturally")
    @net.minecraftforge.common.config.Config.Comment("If true, Mutant Brutes will spawn naturally | default: true")
    public static boolean mutantBrutesSpawnNaturally = true;

    @net.minecraftforge.common.config.Config.Name("rottenMutantSpawnNaturally")
    @net.minecraftforge.common.config.Config.Comment("If true, Rotten Mutants will spawn naturally | default: true")
    public static boolean rottenMutantSpawnNaturally = true;

    @net.minecraftforge.common.config.Config.Name("spittersBreakLogsAndLeavesAroundThem")
    @net.minecraftforge.common.config.Config.Comment("If true, Spitters will break logs and leaves in their path | default: false")
    public static boolean spittersBreakLogsAndLeavesAroundThem = false;

    @net.minecraftforge.common.config.Config.Name("zombieBrutesBreakLogsAndLeavesAroundThem")
    @net.minecraftforge.common.config.Config.Comment("If true, Zombie Brutes will break logs and leaves in their path | default: false")
    public static boolean zombieBrutesBreakLogsAndLeavesAroundThem = false;

    @net.minecraftforge.common.config.Config.Name("mutantBrutesBreakLogsAndLeavesAroundThem")
    @net.minecraftforge.common.config.Config.Comment("If true, Mutant Brutes will break logs and leaves in their path | default: false")
    public static boolean mutantBrutesBreakLogsAndLeavesAroundThem = false;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (MutantsZombies.MOD_ID.equals(event.getModID())) {
            ConfigManager.sync(MutantsZombies.MOD_ID, net.minecraftforge.common.config.Config.Type.INSTANCE);
            MutantsZombies.LOGGER.info("Synced {} config", MutantsZombies.MOD_ID);
        }
    }
}
