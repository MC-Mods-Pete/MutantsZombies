package net.petemc.mutantszombies.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MutantsZombies.MOD_ID);

    //-9543345, -10987735
    public static final DeferredHolder<Item, SpawnEggItem> BLISTER_ZOMBIE_SPAWN_EGG = ITEMS.register("blister_zombie_spawn_egg",
            () -> new SpawnEggItem(ModEntities.BLISTER_ZOMBIE.get(), (new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "blister_zombie_spawn_egg"))))));

    // -10027264, -6684775
    public static final DeferredHolder<Item, SpawnEggItem> CRAWLER_SPAWN_EGG = ITEMS.register("crawler_spawn_egg",
            () -> new SpawnEggItem(ModEntities.CRAWLER.get(), (new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "crawler_spawn_egg"))))));

    // -16764109, -16738048
    public static final DeferredHolder<Item, SpawnEggItem> ZOMBIE_BRUTE_SPAWN_EGG = ITEMS.register("zombie_brute_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ZOMBIE_BRUTE.get(), (new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "zombie_brute_spawn_egg"))))));

    // -10066432, -13408768
    public static final DeferredHolder<Item, SpawnEggItem> SPITTER_SPAWN_EGG = ITEMS.register("spitter_spawn_egg",
            () -> new SpawnEggItem(ModEntities.SPITTER.get(), (new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "spitter_spawn_egg"))))));

    // -10063432, -13428768
    public static final DeferredHolder<Item, SpawnEggItem> SPLIT_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("split_head_zombie_spawn_egg",
            () -> new SpawnEggItem(ModEntities.SPLIT_HEAD_ZOMBIE.get(), (new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "split_head_zombie_spawn_egg"))))));

    // -10063452, -13448768
    public static final DeferredHolder<Item, SpawnEggItem> MUTANT_BRUTE_SPAWN_EGG = ITEMS.register("mutant_brute_spawn_egg",
            () -> new SpawnEggItem(ModEntities.MUTANT_BRUTE.get(), (new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "mutant_brute_spawn_egg"))))));

    // -10042452, -13244638
    public static final DeferredHolder<Item, SpawnEggItem> ROTTEN_MUTANT_SPAWN_EGG = ITEMS.register("rotten_mutant_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ROTTEN_MUTANT.get(), (new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "rotten_mutant_spawn_egg"))))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
