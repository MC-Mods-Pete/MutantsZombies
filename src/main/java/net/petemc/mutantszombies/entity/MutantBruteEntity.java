package net.petemc.mutantszombies.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.SpawnPlacements.Type;
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
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.registries.ForgeRegistries;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import org.jetbrains.annotations.NotNull;

public class MutantBruteEntity extends Monster {

    public MutantBruteEntity(EntityType<MutantBruteEntity> type, Level world) {
        super(type, world);
        this.setMaxUpStep(0.9F);
        this.xpReward = 16;
        this.setNoAi(false);
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

    public @NotNull MobType getMobType() {
        return MobType.UNDEAD;
    }

    protected void dropCustomDeathLoot(@NotNull DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);
        //TODO add drop
    }

    public SoundEvent getAmbientSound() {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.husk.ambient"));
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound((SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.rooted_dirt.step")), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.zombie.hurt"));
    }

    public @NotNull SoundEvent getDeathSound() {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.zombie.death"));
    }

    public boolean hurt(DamageSource source, float amount) {
        if (!(source.getDirectEntity() instanceof ThrownPotion) && !(source.getDirectEntity() instanceof AreaEffectCloud)) {
            if (source.is(DamageTypes.DROWN)) {
                return false;
            } else if (source.is(DamageTypes.WITHER)) {
                return false;
            } else {
                return !source.getMsgId().equals("witherSkull") && super.hurt(source, amount);
            }
        } else {
            return false;
        }
    }

    public static void init() {
        SpawnPlacements.register(ModEntities.MUTANT_BRUTE.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random)
                                && Mob.checkMobSpawnRules(entityType, world, reason, pos, random));
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.20);
        builder = builder.add(Attributes.MAX_HEALTH, (double) 120.0F);
        builder = builder.add(Attributes.ARMOR, 18.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, (double) 8.0F);
        builder = builder.add(Attributes.FOLLOW_RANGE, (double) 30.0F);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 6.0);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 6.0D);
        return builder;
    }
}
