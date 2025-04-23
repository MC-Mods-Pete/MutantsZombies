package net.petemc.mutantszombies.event;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.*;

public class GameEvents {
    @EventBusSubscriber(modid = MutantsZombies.MOD_ID)
    public static class ForgeGameEvents {
        @SubscribeEvent
        public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
            if (!event.getLevel().isClientSide()) {
                //MutantsZombies.LOGGER.info("ENTITY LOADED: {}", event.getEntity().getName().getString());
                if (event.getEntity().getName().getString().contains("Blister")) {
                    MutantsZombies.LOGGER.info("ENTITY LOADED: BLISTER ZOMBIE");
                }

            }
        }

    }
}


