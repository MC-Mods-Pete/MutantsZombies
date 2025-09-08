package net.petemc.mutantszombies.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MutantsZombies.MOD_ID);

    public static final RegistryObject<Item> BLISTER_ZOMBIE_SPAWN_EGG = ITEMS.register("blister_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BLISTER_ZOMBIE, -9543345, -10987735, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CRAWLER_SPAWN_EGG = ITEMS.register("crawler_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CRAWLER, -10027264, -6684775, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> ZOMBIE_BRUTE_SPAWN_EGG = ITEMS.register("zombie_brute_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ZOMBIE_BRUTE, -16764109, -16738048, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SPITTER_SPAWN_EGG = ITEMS.register("spitter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPITTER, -10066432, -13408768, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SPLIT_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("split_head_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPLIT_HEAD_ZOMBIE, -10063432, -13428768, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> MUTANT_BRUTE_SPAWN_EGG = ITEMS.register("mutant_brute_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MUTANT_BRUTE, -10063452, -13448768, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

