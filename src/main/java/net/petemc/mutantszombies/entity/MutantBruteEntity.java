package net.petemc.mutantszombies.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.petemc.mutantszombies.config.ModConfig;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import net.petemc.mutantszombies.sound.ModSounds;
import org.jetbrains.annotations.NotNull;

public class MutantBruteEntity extends HostileEntity {
    public MutantBruteEntity(EntityType<MutantBruteEntity> type, World world) {
        super(type, world);
        this.experiencePoints = 16;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new ModMeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, ServerPlayerEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, true, true));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
    }

    protected void dropEquipment(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        super.dropEquipment(world, source, causedByPlayer);
        //TODO add drop
    }

    public SoundEvent getAmbientSound() {
        return ModSounds.ROAR_SOUND;
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound((SoundEvent) Registries.SOUND_EVENT.get(Identifier.tryParse("block.rooted_dirt.step")), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) Registries.SOUND_EVENT.get(Identifier.tryParse("entity.husk.hurt"));
    }

    public @NotNull SoundEvent getDeathSound() {
        return (SoundEvent) Registries.SOUND_EVENT.get(Identifier.tryParse("entity.zombie.death"));
    }

    public boolean damage(ServerWorld serverWorld, DamageSource damageSource, float amount) {
        if (damageSource.isOf(DamageTypes.IN_FIRE)) {
            this.setFireTicks(0);
            return super.damage(serverWorld, damageSource, amount);
        } else if (damageSource.isOf(DamageTypes.ON_FIRE)) {
            this.setFireTicks(0);
            return super.damage(serverWorld, damageSource, amount);
        } else {
            return (!damageSource.isOf(DamageTypes.DROWN)) && super.damage(serverWorld, damageSource, amount);
        }
    }

    public static void init() {
        SpawnRestriction.register(ModEntities.MUTANT_BRUTE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        ModConfig.getMutantBrutesSpawnNaturally()
                                && !(world.getBiome(pos).matchesKey(BiomeKeys.MUSHROOM_FIELDS))
                                && world.getDifficulty() != Difficulty.PEACEFUL
                                && HostileEntity.isSpawnDark(world, pos, random)
                                && HostileEntity.canMobSpawn(entityType, world, reason, pos, random));

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER, ModEntities.MUTANT_BRUTE, 5, 1, 1);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
        .add(EntityAttributes.MAX_HEALTH, 120.0D)
        .add(EntityAttributes.FOLLOW_RANGE, 25.0D)
        .add(EntityAttributes.MOVEMENT_SPEED, 0.20D)
        .add(EntityAttributes.ATTACK_DAMAGE, 18.0D)
        .add(EntityAttributes.ARMOR, 18.0D)
        .add(EntityAttributes.ATTACK_KNOCKBACK, 6.0D)
        .add(EntityAttributes.KNOCKBACK_RESISTANCE, 6.0D);
    }
}
