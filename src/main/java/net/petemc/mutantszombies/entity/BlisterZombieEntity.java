package net.petemc.mutantszombies.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
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
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.petemc.mutantszombies.config.Config;
import org.jetbrains.annotations.NotNull;

public class BlisterZombieEntity extends HostileEntity {

    public BlisterZombieEntity(EntityType<BlisterZombieEntity> type, World world) {
        super(type, world);
        this.setStepHeight(1.0F);
        this.experiencePoints = 6;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[]{BlisterZombieEntity.class}).setGroupRevenge(BlisterZombieEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, true, true));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
    }

    public @NotNull EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);
        //TODO add drop
    }

    public SoundEvent getAmbientSound() {
        return Registries.SOUND_EVENT.get(new Identifier("block.sculk_shrieker.shriek"));
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound(Registries.SOUND_EVENT.get(new Identifier("block.gravel.step")), 0.15F, 1.0F);
    }

    public SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return Registries.SOUND_EVENT.get(new Identifier("entity.zombie.hurt"));
    }

    public SoundEvent getDeathSound() {
        return Registries.SOUND_EVENT.get(new Identifier("entity.husk.death"));
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
        SpawnRestriction.register(ModEntities.BLISTER_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        Config.getBlisterZombiesSpawnNaturally()
                                && !(world.getBiome(pos).matchesKey(BiomeKeys.MUSHROOM_FIELDS))
                                && world.getDifficulty() != Difficulty.PEACEFUL
                                && HostileEntity.isSpawnDark(world, pos, random)
                                && HostileEntity.canMobSpawn(entityType, world, reason, pos, random));

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER, ModEntities.BLISTER_ZOMBIE, 12, 1, 3);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 24.0)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0)
            .add(EntityAttributes.GENERIC_ARMOR, 0.6)
            .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.1)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.1);
    }
}
