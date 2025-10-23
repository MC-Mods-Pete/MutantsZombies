package net.petemc.mutantszombies.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.createItems(MutantsZombies.MOD_ID);

    public static final DeferredHolder<Item, DeferredSpawnEggItem> BLISTER_ZOMBIE_SPAWN_EGG = ITEMS.register("blister_zombie_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.BLISTER_ZOMBIE, -9543345, -10987735, (new Item.Properties())));

    public static final DeferredHolder<Item, DeferredSpawnEggItem> CRAWLER_SPAWN_EGG = ITEMS.register("crawler_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.CRAWLER, -10027264, -6684775, (new Item.Properties())));

    public static final DeferredHolder<Item, DeferredSpawnEggItem> ZOMBIE_BRUTE_SPAWN_EGG = ITEMS.register("zombie_brute_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.ZOMBIE_BRUTE, -16764109, -16738048, (new Item.Properties())));

    public static final DeferredHolder<Item, DeferredSpawnEggItem> SPITTER_SPAWN_EGG = ITEMS.register("spitter_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.SPITTER, -10066432, -13408768, (new Item.Properties())));

    public static final DeferredHolder<Item, DeferredSpawnEggItem> SPLIT_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("split_head_zombie_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.SPLIT_HEAD_ZOMBIE, -10063432, -13428768, (new Item.Properties())));

    public static final DeferredHolder<Item, DeferredSpawnEggItem> MUTANT_BRUTE_SPAWN_EGG = ITEMS.register("mutant_brute_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.MUTANT_BRUTE, -10063452, -13448768, (new Item.Properties())));

    public static final DeferredHolder<Item, DeferredSpawnEggItem> ROTTEN_MUTANT_SPAWN_EGG = ITEMS.register("rotten_mutant_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.ROTTEN_MUTANT, -10042452, -13244638, (new Item.Properties())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
