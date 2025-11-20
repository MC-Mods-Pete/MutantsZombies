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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.petemc.mutantszombies.config.Config;
import net.petemc.mutantszombies.sound.ModSounds;
import org.jetbrains.annotations.NotNull;

public class SplitHeadZombieEntity extends HostileEntity {

    public SplitHeadZombieEntity(EntityType<SplitHeadZombieEntity> type, World world) {
        super(type, world);
        this.experiencePoints = 6;
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[]{SplitHeadZombieEntity.class}).setGroupRevenge(SplitHeadZombieEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, true, true));
        initCustomGoals();
    }

    protected void initCustomGoals() {
    }

    protected void dropEquipment(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        super.dropEquipment(world, source, causedByPlayer);
        //TODO add drop
    }

    public SoundEvent getAmbientSound() {
        return ModSounds.GURGLE_SOUND;
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound(Registries.SOUND_EVENT.get(Identifier.tryParse("block.gravel.step")), 0.15F, 1.0F);
    }

    public SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return ModSounds.FLESH_SOUND;
    }

    public SoundEvent getDeathSound() {
        return Registries.SOUND_EVENT.get(Identifier.tryParse("entity.zombie.death"));
    }

    public boolean damage(DamageSource damageSource, float amount) {
        if (damageSource.isOf(DamageTypes.DROWN)) {
            return false;
        } else if (damageSource.isOf(DamageTypes.WITHER)) {
            return false;
        }
        return super.damage(damageSource, amount);
    }

    public static void init() {
        SpawnRestriction.register(ModEntities.SPLIT_HEAD_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        Config.getSplitHeadZombiesSpawnNaturally()
                                && !(world.getBiome(pos).matchesKey(BiomeKeys.MUSHROOM_FIELDS))
                                && !(world.getBiome(pos).matchesKey(BiomeKeys.DEEP_DARK))
                                && world.getDifficulty() != Difficulty.PEACEFUL
                                && HostileEntity.isSpawnDark(world, pos, random)
                                && HostileEntity.canMobSpawn(entityType, world, reason, pos, random));

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER, ModEntities.SPLIT_HEAD_ZOMBIE, 12, 1, 2);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 24.0)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
            .add(EntityAttributes.GENERIC_ARMOR, 0.5)
            .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.1)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.1)
            .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.0);
    }
}
