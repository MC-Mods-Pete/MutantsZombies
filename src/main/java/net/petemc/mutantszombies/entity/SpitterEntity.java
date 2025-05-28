package net.petemc.mutantszombies.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.petemc.mutantszombies.config.Config;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;

public class SpitterEntity extends Monster implements RangedAttackMob {

    public SpitterEntity(EntityType<SpitterEntity> type, Level world) {
        super(type, world);
        this.xpReward = 10;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, (double)1.25F, 50, 3.0F));
        this.goalSelector.addGoal(3, new ModMeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true, true));
    }

    protected void dropCustomDeathLoot(@NotNull ServerLevel level, @NotNull DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        this.spawnAtLocation(new ItemStack(Items.SLIME_BALL, RandomUtils.nextInt(2, 5)));
    }

    public SoundEvent getAmbientSound() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.burp"));
    }

    public void playStepSound(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.playSound((SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.basalt.step")), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.hurt"));
    }

    public @NotNull SoundEvent getDeathSound() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.husk.death"));
    }

    public boolean hurt(DamageSource damageSource, float amount) {
        if (damageSource.is(DamageTypes.IN_FIRE)) {
            this.clearFire();
            return super.hurt(damageSource, amount);
        } else if (damageSource.is(DamageTypes.ON_FIRE)) {
            this.clearFire();
            return super.hurt(damageSource, amount);
        } else {
            return !damageSource.is(DamageTypes.DROWN) && super.hurt(damageSource, amount);
        }
    }

    public void performRangedAttack(LivingEntity target, float flval) {
        SpitterEntityProjectile entityarrow = new SpitterEntityProjectile(this, this.level());
        double d0 = target.getY() + (double)target.getEyeHeight() - 1.1;
        double d1 = target.getX() - this.getX();
        double d3 = target.getZ() - this.getZ();
        entityarrow.shoot(d1, d0 - entityarrow.getY() + Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F, d3, 1.6F, 12.0F);
        this.level().addFreshEntity(entityarrow);
    }

    public static boolean checkSpitterSpawnRules(EntityType<SpitterEntity> spitterEntityType, ServerLevelAccessor serverLevel, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return Config.getSpitterZombiesSpawnNaturally()
                && !(serverLevel.getBiome(pos).is(Biomes.MUSHROOM_FIELDS))
                && serverLevel.getDifficulty() != Difficulty.PEACEFUL
                && Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                && Mob.checkMobSpawnRules(spitterEntityType, serverLevel, spawnType, pos, random);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MAX_HEALTH, 75.0D);
        builder = builder.add(Attributes.FOLLOW_RANGE, 25.0D);
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2D);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 4.0D);
        builder = builder.add(Attributes.ARMOR, 0.0D);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 3.0D);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10.0D);
        builder = builder.add(Attributes.STEP_HEIGHT, 1.0D);
        return builder;
    }
}
