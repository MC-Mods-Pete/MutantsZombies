package net.petemc.mutantszombies.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.petemc.mutantszombies.entity.*;

public class ModServerEntityEvents {

    private static Entity pEntity;
    private static ServerLevel pServerLevel;

    public ModServerEntityEvents() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverLevel) -> {
            pEntity = entity;
            pServerLevel = serverLevel;
            executeLoadEntity();
        });
    }

    public static void executeLoadEntity() {
        if (!pServerLevel.isClientSide() && pServerLevel.getDifficulty() == Difficulty.PEACEFUL) {
            if (pEntity instanceof BlisterZombieEntity
                || pEntity instanceof CrawlerEntity
                || pEntity instanceof MutantBruteEntity
                || pEntity instanceof RottenMutantEntity
                || pEntity instanceof SpitterEntity
                || pEntity instanceof SplitHeadZombieEntity
                || pEntity instanceof ZombieBruteEntity) {
                    pEntity.discard();
            }
        }
    }

    public static void registerEvents() { new ModServerEntityEvents(); }
}
