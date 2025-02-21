package net.petemc.mutantszombies.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.registries.ForgeRegistries;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;

public class SpitterEntity extends Monster implements RangedAttackMob {

    public SpitterEntity(EntityType<SpitterEntity> type, Level world) {
        super(type, world);
        this.setMaxUpStep(0.6F);
        this.xpReward = 5;
        this.setNoAi(false);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, (double)1.25F, 50, 3.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ServerPlayer.class, true, true));
        this.goalSelector.addGoal(4, new ModMeleeAttackGoal(this, 1.2, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Villager.class, true, true));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0F));
        this.targetSelector.addGoal(7, new HurtByTargetGoal(this, ServerPlayer.class));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(9, new FloatGoal(this));
    }

    public @NotNull MobType getMobType() {
        return MobType.UNDEAD;
    }

    protected void dropCustomDeathLoot(@NotNull DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);
        this.spawnAtLocation(new ItemStack(Items.SLIME_BALL, RandomUtils.nextInt(2, 5)));
    }

    public SoundEvent getAmbientSound() {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp"));
    }

    public void playStepSound(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.playSound((SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.step")), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.hurt"));
    }

    public @NotNull SoundEvent getDeathSound() {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.husk.death"));
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

    public static void init() {
        SpawnPlacements.register((EntityType) ModEntities.SPITTER.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random)
                                && Mob.checkMobSpawnRules(entityType, world, reason, pos, random));
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
        builder = builder.add(Attributes.MAX_HEALTH, (double)75.0F);
        builder = builder.add(Attributes.ARMOR, (double)0.0F);
        builder = builder.add(Attributes.ATTACK_DAMAGE, (double)4.0F);
        builder = builder.add(Attributes.FOLLOW_RANGE, (double)20.0F);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, (double)10.0F);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, (double)3.0F);
        return builder;
    }
}
