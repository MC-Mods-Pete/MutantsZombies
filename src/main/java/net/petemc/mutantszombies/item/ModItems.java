package net.petemc.mutantszombies.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.ModEntities;

public class ModItems {
    // -9543345, -10987735
    public static final Item BLISTER_ZOMBIE_SPAWN_EGG = registerItem("blister_zombie_spawn_egg",
            new SpawnEggItem(new Item.Properties().spawnEgg(ModEntities.BLISTER_ZOMBIE)
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "blister_zombie_spawn_egg")))));

    // -10027264, -6684775
    public static final Item CRAWLER_SPAWN_EGG = registerItem("crawler_spawn_egg",
            new SpawnEggItem(new Item.Properties().spawnEgg(ModEntities.CRAWLER)
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "crawler_spawn_egg")))));

    // -16764109, -16738048
    public static final Item ZOMBIE_BRUTE_SPAWN_EGG = registerItem("zombie_brute_spawn_egg",
            new SpawnEggItem(new Item.Properties().spawnEgg(ModEntities.ZOMBIE_BRUTE)
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "zombie_brute_spawn_egg")))));

    // -10066432, -13408768
    public static final Item SPITTER_SPAWN_EGG = registerItem("spitter_spawn_egg",
            new SpawnEggItem(new Item.Properties().spawnEgg(ModEntities.SPITTER)
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "spitter_spawn_egg")))));

    // -10063432, -13428768
    public static final Item SPLIT_HEAD_ZOMBIE_SPAWN_EGG = registerItem("split_head_zombie_spawn_egg",
            new SpawnEggItem(new Item.Properties().spawnEgg(ModEntities.SPLIT_HEAD_ZOMBIE)
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "split_head_zombie_spawn_egg")))));

    // -10063452, -13448768
    public static final Item MUTANT_BRUTE_SPAWN_EGG = registerItem("mutant_brute_spawn_egg",
            new SpawnEggItem(new Item.Properties().spawnEgg(ModEntities.MUTANT_BRUTE)
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "mutant_brute_spawn_egg")))));

    // -10042452, -13244638
    public static final Item ROTTEN_MUTANT_SPAWN_EGG = registerItem("rotten_mutant_spawn_egg",
            new SpawnEggItem(new Item.Properties().spawnEgg(ModEntities.ROTTEN_MUTANT)
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "rotten_mutant_spawn_egg")))));

    private static void addItemsToFoodDrinkItemGroup(FabricCreativeModeTabOutput output) {
        output.accept(BLISTER_ZOMBIE_SPAWN_EGG);
        output.accept(CRAWLER_SPAWN_EGG);
        output.accept(ZOMBIE_BRUTE_SPAWN_EGG);
        output.accept(SPITTER_SPAWN_EGG);
        output.accept(SPLIT_HEAD_ZOMBIE_SPAWN_EGG);
        output.accept(MUTANT_BRUTE_SPAWN_EGG);
        output.accept(ROTTEN_MUTANT_SPAWN_EGG);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, name), item);
    }

    public static void registerItems() {
        MutantsZombies.LOGGER.info("Registering Mod Items for " + MutantsZombies.MOD_ID);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(ModItems::addItemsToFoodDrinkItemGroup);
    }
}

