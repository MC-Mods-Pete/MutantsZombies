package net.petemc.mutantszombies.entity.ai.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class ModMeleeAttackGoal extends MeleeAttackGoal {
    PathfinderMob mob;

    public ModMeleeAttackGoal(PathfinderMob mob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(mob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.mob = mob;
    }

    protected double getAttackReachSqr(LivingEntity entity) {
        return (double) (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
    }
}

