package net.petemc.mutantszombies.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.ModEntities;

public class ModItems {
    public static final Item BLISTER_ZOMBIE_SPAWN_EGG = registerItem("blister_zombie_spawn_egg", new SpawnEggItem(ModEntities.BLISTER_ZOMBIE, -9543345, -10987735, (new Item.Settings())));
    public static final Item CRAWLER_SPAWN_EGG = registerItem("crawler_spawn_egg", new SpawnEggItem(ModEntities.CRAWLER, -10027264, -6684775, (new Item.Settings())));
    public static final Item ZOMBIE_BRUTE_SPAWN_EGG = registerItem("zombie_brute_spawn_egg", new SpawnEggItem(ModEntities.ZOMBIE_BRUTE, -16764109, -16738048, (new Item.Settings())));
    public static final Item SPITTER_SPAWN_EGG = registerItem("spitter_spawn_egg", new SpawnEggItem(ModEntities.SPITTER, -10066432, -13408768, (new Item.Settings())));
    public static final Item SPLIT_HEAD_ZOMBIE_SPAWN_EGG = registerItem("split_head_zombie_spawn_egg", new SpawnEggItem(ModEntities.SPLIT_HEAD_ZOMBIE, -10063432, -13428768, (new Item.Settings())));
    public static final Item MUTANT_BRUTE_SPAWN_EGG = registerItem("mutant_brute_spawn_egg", new SpawnEggItem(ModEntities.MUTANT_BRUTE, -10063452, -13448768, (new Item.Settings())));

    private static void addItemsToFoodDrinkItemGroup(FabricItemGroupEntries entries) {
        entries.add(BLISTER_ZOMBIE_SPAWN_EGG);
        entries.add(CRAWLER_SPAWN_EGG);
        entries.add(ZOMBIE_BRUTE_SPAWN_EGG);
        entries.add(SPITTER_SPAWN_EGG);
        entries.add(SPLIT_HEAD_ZOMBIE_SPAWN_EGG);
        entries.add(MUTANT_BRUTE_SPAWN_EGG);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MutantsZombies.MOD_ID, name), item);
    }

    public static void registerItems() {
        MutantsZombies.LOGGER.info("Registering Mod Items for " + MutantsZombies.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToFoodDrinkItemGroup);
    }
}

