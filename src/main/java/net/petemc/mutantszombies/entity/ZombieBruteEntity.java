package net.petemc.mutantszombies.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.petemc.mutantszombies.config.Config;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import org.jetbrains.annotations.NotNull;

public class ZombieBruteEntity extends Monster {
    public ZombieBruteEntity(EntityType<ZombieBruteEntity> type, Level world) {
        super(type, world);
        this.xpReward = 15;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new ModMeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true,true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true, true));
    }

    protected void dropCustomDeathLoot(@NotNull ServerLevel level, @NotNull DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        //TODO add drop
    }

    public SoundEvent getAmbientSound() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.husk.ambient"));
    }

    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound((SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.rooted_dirt.step")), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(DamageSource ds) {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.hurt"));
    }

    public @NotNull SoundEvent getDeathSound() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.death"));
    }

    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.IN_FIRE)) {
            this.clearFire();
            return super.hurt(source, amount);
        } else if (source.is(DamageTypes.ON_FIRE)) {
            this.clearFire();
            return super.hurt(source, amount);
        } else {
            return (!source.is(DamageTypes.DROWN)) && super.hurt(source, amount);
        }
    }

    public void lavaHurt() {
        if (this.hurt(this.damageSources().lava(), 4.0F)) {
            this.playSound(SoundEvents.GENERIC_BURN, 0.4F, 2.0F + this.random.nextFloat() * 0.4F);
        }
    }

    public static boolean checkZombieBruteSpawnRules(EntityType<ZombieBruteEntity> zombieBruteEntityType, ServerLevelAccessor serverLevel, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return Config.getZombieBrutesSpawnNaturally()
                && !(serverLevel.getBiome(pos).is(Biomes.MUSHROOM_FIELDS))
                && serverLevel.getDifficulty() != Difficulty.PEACEFUL
                && Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                && Mob.checkMobSpawnRules(zombieBruteEntityType, serverLevel, spawnType, pos, random);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MAX_HEALTH, 100.0D);
        builder = builder.add(Attributes.FOLLOW_RANGE, 25.0D);
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25D);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 16.0);
        builder = builder.add(Attributes.ARMOR, 16.0D);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 6.0D);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 6.0D);
        builder = builder.add(Attributes.STEP_HEIGHT, 1.0D);
        return builder;
    }
}
