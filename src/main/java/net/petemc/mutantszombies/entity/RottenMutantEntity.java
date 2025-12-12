package net.petemc.mutantszombies.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.petemc.mutantszombies.config.Config;
import org.jetbrains.annotations.NotNull;

public class RottenMutantEntity extends Monster {

    public RottenMutantEntity(EntityType<RottenMutantEntity> type, Level world) {
        super(type, world);
        this.xpReward = 6;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.1, false));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[]{RottenMutantEntity.class}).setAlertOthers(RottenMutantEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true, true));
        registerCustomGoals();
    }

    protected void registerCustomGoals() {
    }

    protected void dropCustomDeathLoot(@NotNull ServerLevel level, @NotNull DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        //TODO add drop
    }

    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(Identifier.parse("entity.husk.ambient")).orElseThrow().value();
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound(BuiltInRegistries.SOUND_EVENT.get(Identifier.parse("block.gravel.step")).orElseThrow().value(), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return BuiltInRegistries.SOUND_EVENT.get(Identifier.parse("entity.husk.hurt")).orElseThrow().value();
    }

    public @NotNull SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(Identifier.parse("entity.husk.death")).orElseThrow().value();
    }

    @Override
    public boolean hurtServer(@NotNull ServerLevel serverLevel, DamageSource damageSource, float amount) {
        if (damageSource.is(DamageTypes.DROWN)) {
            return false;
        } else if (damageSource.is(DamageTypes.WITHER)) {
            return false;
        }
        return super.hurtServer(serverLevel, damageSource, amount);
    }

    public static boolean checkRottenMutantSpawnRules(EntityType<RottenMutantEntity> rottenMutantEntityType, ServerLevelAccessor serverLevel, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return Config.getRottenMutantsSpawnNaturally()
                && !(serverLevel.getBiome(pos).is(Biomes.MUSHROOM_FIELDS))
                && serverLevel.getDifficulty() != Difficulty.PEACEFUL
                && Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                && Mob.checkMobSpawnRules(rottenMutantEntityType, serverLevel, spawnReason, pos, random);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 30.0)
            .add(Attributes.FOLLOW_RANGE, 30.0)
            .add(Attributes.MOVEMENT_SPEED, 0.18)
            .add(Attributes.ATTACK_DAMAGE, 7.0)
            .add(Attributes.ARMOR, 0.6)
            .add(Attributes.ATTACK_KNOCKBACK, 0.1)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.1)
            .add(Attributes.STEP_HEIGHT, 1.0);
    }
}
