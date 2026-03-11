package net.petemc.mutantszombies.entity.ai.goal;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class ModMeleeAttackGoal extends EntityAIAttackMelee {
    private final EntityCreature mob;

    public ModMeleeAttackGoal(EntityCreature mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
        super(mob, speedModifier, followingTargetEvenIfNotSeen);
        this.mob = mob;
    }

    @Override
    protected double getAttackReachSqr(EntityLivingBase entity) {
        return this.mob.width * this.mob.width + entity.width;
    }
}
