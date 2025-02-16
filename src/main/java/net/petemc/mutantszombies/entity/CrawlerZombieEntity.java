package net.petemc.mutantszombies.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnPlacements;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.registries.ForgeRegistries;
import net.petemc.mutantszombies.entity.ai.goal.ModMeleeAttackGoal;
import org.jetbrains.annotations.NotNull;

public class CrawlerZombieEntity extends Monster {
    public CrawlerZombieEntity(EntityType<CrawlerZombieEntity> type, Level world) {
        super(type, world);
        this.maxUpStep = 100.0F;
        this.xpReward = 2;
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

    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);
        this.spawnAtLocation(new ItemStack(Items.QUARTZ));
    }

    public SoundEvent getAmbientSound() {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.breathe"));
    }

    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound((SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.cave_vines.step")), 0.15F, 1.0F);
    }

    public SoundEvent getHurtSound(DamageSource ds) {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.hurt"));
    }

    public SoundEvent getDeathSound() {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.husk.death"));
    }

    public boolean hurt(DamageSource source, float amount) {
        if (source == DamageSource.IN_FIRE) { // f_19315_
            return false;
        } else if (source == DamageSource.FALL) { // f_19314_
            return false;
        } else if (source == DamageSource.DROWN) {
            return false;
        } else if (source == DamageSource.WITHER) {
            return false;
        } else {
            return !source.getMsgId().equals("witherSkull") && super.hurt(source, amount);
        }
    }

    public static void init() {
        SpawnPlacements.register((EntityType) ModEntities.CRAWLER_ZOMBIE.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, 
                (entityType, world, reason, pos, random) -> 
                        world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) 
                                && Mob.checkMobSpawnRules(entityType, world, reason, pos, random));
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
        builder = builder.add(Attributes.MAX_HEALTH, (double)6.0F);
        builder = builder.add(Attributes.ARMOR, (double)0.0F);
        builder = builder.add(Attributes.ATTACK_DAMAGE, (double)3.0F);
        builder = builder.add(Attributes.FOLLOW_RANGE, (double)20.0F);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, (double)0.5F);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
        return builder;
    }
}
