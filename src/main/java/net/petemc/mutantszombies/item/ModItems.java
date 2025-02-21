package net.petemc.mutantszombies.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister<Item> REGISTRY;
    public static final RegistryObject<Item> BLISTER_ZOMBIE_SPAWN_EGG;
    public static final RegistryObject<Item> CRAWLER_SPAWN_EGG;
    public static final RegistryObject<Item> ZOMBIE_BRUTE_SPAWN_EGG;
    public static final RegistryObject<Item> SPITTER_SPAWN_EGG;

    public ModItems() {
    }

    static {
        REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MutantsZombies.MOD_ID);
        BLISTER_ZOMBIE_SPAWN_EGG = REGISTRY.register("blister_zombie_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.BLISTER_ZOMBIE, -9543345, -10987735, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));
        CRAWLER_SPAWN_EGG = REGISTRY.register("crawler_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CRAWLER, -10027264, -6684775, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));
        ZOMBIE_BRUTE_SPAWN_EGG = REGISTRY.register("zombie_brute_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.ZOMBIE_BRUTE, -16764109, -16738048, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));
        SPITTER_SPAWN_EGG = REGISTRY.register("spitter_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SPITTER, -10066432, -13408768, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));
    }
}

