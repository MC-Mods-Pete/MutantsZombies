package net.petemc.mutantszombies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.petemc.mutantszombies.config.Config;
import net.petemc.mutantszombies.entity.*;
import net.petemc.mutantszombies.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MutantsZombies implements ModInitializer {
    public static final String MOD_ID = "mutantszombies";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        Config.init();
        ModEntities.initModEntities();
        ModItems.registerItems();
        FabricDefaultAttributeRegistry.register(ModEntities.BLISTER_ZOMBIE, BlisterZombieEntity.createHordeZombieAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER, CrawlerEntity.createHordeZombieAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ZOMBIE_BRUTE, ZombieBruteEntity.createHordeZombieAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SPITTER, SpitterEntity.createHordeZombieAttributes());
    }
}
