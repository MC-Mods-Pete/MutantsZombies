package net.petemc.mutantszombies.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.petemc.mutantszombies.config.Config;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import net.petemc.mutantszombies.sound.ModSounds;
import org.jetbrains.annotations.NotNull;

public class MutantBruteEntity extends Monster {

    public MutantBruteEntity(EntityType<MutantBruteEntity> type, Level world) {
        super(type, world);
        this.xpReward = 16;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new ModMeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0F));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this, ServerPlayer.class));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new FloatGoal(this));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ServerPlayer.class, true, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, Villager.class, true, true));
    }

    @Override
    protected void dropCustomDeathLoot(@NotNull ServerLevel level, @NotNull DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        //TODO add drop
    }

    public SoundEvent getAmbientSound() {
        return ModSounds.ROAR_SOUND.get();
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.rooted_dirt.step")).orElseThrow().value(), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.husk.hurt")).orElseThrow().value();
    }

    public @NotNull SoundEvent getDeathSound() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.death")).orElseThrow().value();
    }

    public boolean hurtServer(@NotNull ServerLevel serverLevel, @NotNull DamageSource damageSource, float amount) {
        if (damageSource.is(DamageTypes.DROWN)) {
                return false;
        } else if (damageSource.is(DamageTypes.WITHER)) {
            return false;
        } else {
            return !damageSource.getMsgId().equals("witherSkull") && super.hurtServer(serverLevel, damageSource, amount);
        }
    }

    public static boolean checkMutantBruteSpawnRules(EntityType<MutantBruteEntity> mutantBruteEntityType, ServerLevelAccessor serverLevel, EntitySpawnReason entitySpawnReason, BlockPos pos, RandomSource random) {
        return Config.getMutantBrutesSpawnNaturally()
                && !(serverLevel.getBiome(pos).is(Biomes.MUSHROOM_FIELDS))
                && serverLevel.getDifficulty() != Difficulty.PEACEFUL
                && Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                && Mob.checkMobSpawnRules(mutantBruteEntityType, serverLevel, entitySpawnReason, pos, random);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MAX_HEALTH, 120.0D);
        builder = builder.add(Attributes.FOLLOW_RANGE, 25.0D);
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.20D);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 18.0D);
        builder = builder.add(Attributes.ARMOR, 18.0D);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 6.0D);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 6.0D);
        return builder;
    }
}
