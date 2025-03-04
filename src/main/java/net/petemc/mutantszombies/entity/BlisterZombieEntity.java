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
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import org.jetbrains.annotations.NotNull;

public class BlisterZombieEntity extends HostileEntity {

    public BlisterZombieEntity(EntityType<BlisterZombieEntity> type, World world) {
        super(type, world);
        this.experiencePoints = 6;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new ModMeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0));
        this.targetSelector.add(3, new RevengeGoal(this, ServerPlayerEntity.class));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new SwimGoal(this));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, PlayerEntity.class, true, true));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, ServerPlayerEntity.class, true, true));
        this.targetSelector.add(8, new ActiveTargetGoal<>(this, IronGolemEntity.class, true, true));
        this.targetSelector.add(9, new ActiveTargetGoal<>(this, VillagerEntity.class, true, true));
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
        return (SoundEvent) Registries.SOUND_EVENT.get(new Identifier("block.sculk_shrieker.shriek"));
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound((SoundEvent) Registries.SOUND_EVENT.get(new Identifier("block.gravel.step")), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) Registries.SOUND_EVENT.get(new Identifier("entity.zombie.hurt"));
    }

    public @NotNull SoundEvent getDeathSound() {
        return (SoundEvent) Registries.SOUND_EVENT.get(new Identifier("entity.husk.death"));
    }

    public boolean damage(DamageSource source, float amount) {
        if (!(source.getSource() instanceof ThrownEntity) && !(source.getSource() instanceof AreaEffectCloudEntity)) {
            if (source.isOf(DamageTypes.DROWN)) {
                return false;
            } else if (source.isOf(DamageTypes.WITHER)) {
                return false;
            } else {
                return !source.getName().equals("witherSkull") && super.damage(source, amount);
            }
        } else {
            return false;
        }
    }

    public static void init() {
        SpawnRestriction.register(ModEntities.BLISTER_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random)
                                && HostileEntity.canMobSpawn(entityType, world, reason, pos, random));

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER, ModEntities.BLISTER_ZOMBIE, 12, 1, 3);
    }

    public static DefaultAttributeContainer.Builder createHordeZombieAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 24.0D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 0.6D)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.7D);
    }
}
