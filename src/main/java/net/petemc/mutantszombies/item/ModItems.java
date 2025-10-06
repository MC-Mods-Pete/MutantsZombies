package net.petemc.mutantszombies.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.ModEntities;

public class ModItems {
    // -9543345, -10987735
    public static final Item BLISTER_ZOMBIE_SPAWN_EGG = registerItem("blister_zombie_spawn_egg",
            new SpawnEggItem(new Item.Settings().spawnEgg(ModEntities.BLISTER_ZOMBIE)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MutantsZombies.MOD_ID, "blister_zombie_spawn_egg")))));

    // -10027264, -6684775
    public static final Item CRAWLER_SPAWN_EGG = registerItem("crawler_spawn_egg",
            new SpawnEggItem(new Item.Settings().spawnEgg(ModEntities.CRAWLER)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MutantsZombies.MOD_ID, "crawler_spawn_egg")))));

    // -16764109, -16738048
    public static final Item ZOMBIE_BRUTE_SPAWN_EGG = registerItem("zombie_brute_spawn_egg",
            new SpawnEggItem(new Item.Settings().spawnEgg(ModEntities.ZOMBIE_BRUTE)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MutantsZombies.MOD_ID, "zombie_brute_spawn_egg")))));

    // -10066432, -13408768
    public static final Item SPITTER_SPAWN_EGG = registerItem("spitter_spawn_egg",
            new SpawnEggItem(new Item.Settings().spawnEgg(ModEntities.SPITTER)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MutantsZombies.MOD_ID, "spitter_spawn_egg")))));

    // -10063432, -13428768
    public static final Item SPLIT_HEAD_ZOMBIE_SPAWN_EGG = registerItem("split_head_zombie_spawn_egg",
            new SpawnEggItem(new Item.Settings().spawnEgg(ModEntities.SPLIT_HEAD_ZOMBIE)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MutantsZombies.MOD_ID, "split_head_zombie_spawn_egg")))));

    // -10063452, -13448768
    public static final Item MUTANT_BRUTE_SPAWN_EGG = registerItem("mutant_brute_spawn_egg",
            new SpawnEggItem(new Item.Settings().spawnEgg(ModEntities.MUTANT_BRUTE)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MutantsZombies.MOD_ID, "mutant_brute_spawn_egg")))));

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

