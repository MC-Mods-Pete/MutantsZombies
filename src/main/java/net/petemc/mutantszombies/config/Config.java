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

    public static boolean getSpitterZombiesSpawnNaturally() {
        return INSTANCE.spitterZombiesSpawnNaturally;
    }

    public static boolean getZombieBrutesSpawnNaturally() {
        return INSTANCE.zombieBrutesSpawnNaturally;
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
    public boolean spitterZombiesSpawnNaturally = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, Zombie Brutes will spawn naturally | default: true")
    public boolean zombieBrutesSpawnNaturally = true;
}
