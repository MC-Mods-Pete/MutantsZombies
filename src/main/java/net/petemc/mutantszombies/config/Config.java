package net.petemc.mutantszombies.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.petemc.mutantszombies.MutantsZombies;

@me.shedaniel.autoconfig.annotation.Config(name = MutantsZombies.MOD_ID)
public class Config implements ConfigData
{
    public static boolean getBlisterZombiesSpawnNaturally() {
        return INSTANCE.blisterZombiesSpawnNaturally;
    }

    public static boolean getCrawlersSpawnNaturally() {
        return INSTANCE.crawlersSpawnNaturally;
    }

    public static boolean getSpittersSpawnNaturally() {
        return INSTANCE.spittersSpawnNaturally;
    }

    public static boolean getZombieBrutesSpawnNaturally() {
        return INSTANCE.zombieBrutesSpawnNaturally;
    }

    public static boolean getSplitHeadZombiesSpawnNaturally() {
        return INSTANCE.splitHeadZombiesSpawnNaturally;
    }

    public static boolean getMutantBrutesSpawnNaturally() {
        return INSTANCE.mutantBrutesSpawnNaturally;
    }

    public static boolean getRottenMutantsSpawnNaturally() {
        return INSTANCE.rottenMutantsSpawnNaturally;
    }

    public static boolean getSpittersBreakLogsAndLeavesAroundThem() {
        return INSTANCE.spittersBreakLogsAndLeavesAroundThem;
    }

    public static boolean getZombieBrutesBreakLogsAndLeavesAroundThem() {
        return INSTANCE.zombieBrutesBreakLogsAndLeavesAroundThem;
    }

    public static boolean getMutantBrutesBreakLogsAndLeavesAroundThem() {
        return INSTANCE.mutantBrutesBreakLogsAndLeavesAroundThem;
    }

    @ConfigEntry.Gui.Excluded
    public static Config INSTANCE;

    public static void init() {
        AutoConfig.register(Config.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(Config.class).getConfig();
    }

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Blister Zombies will spawn naturally | default: true")
    public boolean blisterZombiesSpawnNaturally = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Crawlers will spawn naturally | default: true")
    public boolean crawlersSpawnNaturally = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Spitter Zombies will spawn naturally | default: true")
    public boolean spittersSpawnNaturally = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Zombie Brutes will spawn naturally | default: true")
    public boolean zombieBrutesSpawnNaturally = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Split Head Zombies will spawn naturally | default: true")
    public boolean splitHeadZombiesSpawnNaturally = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Mutant Brutes will spawn naturally | default: true")
    public boolean mutantBrutesSpawnNaturally = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Rotten Mutants will spawn naturally | default: true")
    public boolean rottenMutantsSpawnNaturally = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Spitters will break logs and leaves in their path | default: false")
    public boolean spittersBreakLogsAndLeavesAroundThem = false;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Zombie Brutes will break logs and leaves in their path | default: false")
    public boolean zombieBrutesBreakLogsAndLeavesAroundThem = false;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Mutant Brutes will break logs and leaves in their path | default: false")
    public boolean mutantBrutesBreakLogsAndLeavesAroundThem = false;
}
