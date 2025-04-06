package net.petemc.mutantszombies.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class ModMeleeAttackGoal extends MeleeAttackGoal {
    PathAwareEntity mob;

    public ModMeleeAttackGoal(PathAwareEntity mob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(mob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.mob = mob;
    }

    protected double getSquaredMaxAttackDistance(LivingEntity entity) {
        return (double) (this.mob.getWidth() * this.mob.getWidth() + entity.getWidth());
    }
}

