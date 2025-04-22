package net.petemc.mutantszombies.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.petemc.mutantszombies.config.Config;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import net.petemc.mutantszombies.entity.ai.goal.ModRangedAttackGoal;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;

public class SpitterEntity extends HostileEntity implements RangedAttackMob {

    public SpitterEntity(EntityType<SpitterEntity> type, World world) {
        super(type, world);
        this.setStepHeight(1.0F);
        this.experiencePoints = 10;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new ModRangedAttackGoal(this, 1.25F, 50, 3.0F));
        this.goalSelector.add(3, new ModMeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
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
        this.dropStack((new ItemStack(Items.SLIME_BALL, RandomUtils.nextInt(2, 5))));
    }

    public SoundEvent getAmbientSound() {
        return (SoundEvent) Registries.SOUND_EVENT.get(new Identifier("entity.player.burp"));
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound((SoundEvent) Registries.SOUND_EVENT.get(new Identifier("block.basalt.step")), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) Registries.SOUND_EVENT.get(new Identifier("entity.zombie.hurt"));
    }

    public @NotNull SoundEvent getDeathSound() {
        return (SoundEvent) Registries.SOUND_EVENT.get(new Identifier("entity.husk.death"));
    }

    public boolean damage(DamageSource damageSource, float amount) {
        if (damageSource.isOf(DamageTypes.IN_FIRE)) {
            this.setFireTicks(0);
            return super.damage(damageSource, amount);
        } else if (damageSource.isOf(DamageTypes.ON_FIRE)) {
            this.setFireTicks(0);
            return super.damage(damageSource, amount);
        } else {
            return !damageSource.isOf(DamageTypes.DROWN) && super.damage(damageSource, amount);
        }
    }

    public void setOnFireFromLava() {
        if (this.damage(this.getDamageSources().lava(), 4.0F)) {
            this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.4F, 2.0F + this.random.nextFloat() * 0.4F);
        }
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        SpitterEntityProjectile entityarrow = new SpitterEntityProjectile(this, this.getWorld());
        double d0 = target.getY() + (double)target.getStandingEyeHeight() - 1.1;
        double d1 = target.getX() - this.getX();
        double d3 = target.getZ() - this.getZ();
        entityarrow.setVelocity(d1, d0 - entityarrow.getY() + Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F, d3, 1.6F, 12.0F);
        this.getWorld().spawnEntity(entityarrow);
    }

    public static void init() {
        SpawnRestriction.register(ModEntities.SPITTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        Config.getSpitterZombiesSpawnNaturally()
                        && world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random)
                                && HostileEntity.canMobSpawn(entityType, world, reason, pos, random));

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER, ModEntities.SPITTER, 9, 1, 2);
    }

    public static DefaultAttributeContainer.Builder createHordeZombieAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 75.0D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 25.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 0.0D)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 3.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 10.0D);
    }
}
