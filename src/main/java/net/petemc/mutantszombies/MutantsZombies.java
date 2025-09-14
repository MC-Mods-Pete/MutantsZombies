package net.petemc.mutantszombies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.petemc.mutantszombies.config.Config;
import net.petemc.mutantszombies.entity.*;
import net.petemc.mutantszombies.item.ModItems;
import net.petemc.mutantszombies.sound.ModSounds;
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
        ModSounds.registerSounds();
        FabricDefaultAttributeRegistry.register(ModEntities.BLISTER_ZOMBIE, BlisterZombieEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER, CrawlerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ZOMBIE_BRUTE, ZombieBruteEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SPITTER, SpitterEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SPLIT_HEAD_ZOMBIE, SplitHeadZombieEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MUTANT_BRUTE, MutantBruteEntity.createAttributes());
    }
}
