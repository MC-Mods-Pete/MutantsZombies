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
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
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
import net.minecraft.world.phys.AABB;
import net.petemc.mutantszombies.config.Config;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;

public class SpitterEntity extends Monster implements RangedAttackMob {
    private int treeBreakCooldown = 40;

    public SpitterEntity(EntityType<SpitterEntity> type, Level world) {
        super(type, world);
        this.xpReward = 10;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.25F, 50, 3.0F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.1, false));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[]{SpitterEntity.class}).setAlertOthers(SpitterEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true, true));
        registerCustomGoals();
    }

    protected void registerCustomGoals() {
    }

    @Override
    protected void dropCustomDeathLoot(@NotNull ServerLevel serverLevel, @NotNull DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(serverLevel, damageSource, recentlyHit);
        this.spawnAtLocation(serverLevel, new ItemStack(Items.SLIME_BALL, RandomUtils.nextInt(2, 5)));
    }

    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.burp")).orElseThrow().value();
    }

    public void playStepSound(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.basalt.step")).orElseThrow().value(), 0.15F, 1.0F);
    }

    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.hurt")).orElseThrow().value();
    }

    public @NotNull SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.husk.death")).orElseThrow().value();
    }

    public boolean hurtServer(@NotNull ServerLevel serverLevel, @NotNull DamageSource damageSource, float amount) {
        if (damageSource.is(DamageTypes.DROWN)) {
            return false;
        } else if (damageSource.is(DamageTypes.WITHER)) {
            return false;
        }
        return super.hurtServer(serverLevel, damageSource, amount);
    }

    public void performRangedAttack(LivingEntity target, float flval) {
        SpitterEntityProjectile projectile = new SpitterEntityProjectile(this, this.level());
        double d0 = target.getY() + (double)target.getEyeHeight() - 1.1;
        double d1 = target.getX() - this.getX();
        double d3 = target.getZ() - this.getZ();
        projectile.shoot(d1, d0 - projectile.getY() + Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F, d3, 1.6F, 12.0F);
        this.level().addFreshEntity(projectile);
    }

    @Override
    public void tick() {
        super.tick();
        if (Config.getSpittersBreakLogsAndLeavesAroundThem()) {
            if (treeBreakCooldown > 0) {
                treeBreakCooldown--;
            } else {
                if (!this.level().isClientSide()) {
                    treeBreakCooldown = 40;

                    AABB box = new AABB(this.position(), this.position());
                    box = box.inflate(3);
                    box = box.inflate(0,1,0);

                    BlockPos.MutableBlockPos.betweenClosedStream(box)
                            .filter(c -> ((level().getBlockState(c).getBlock().toString().contains("leaves")) ||
                                    (level().getBlockState(c).getBlock().toString().contains("log"))))
                            .forEach(c -> {
                                String blockName = level().getBlockState(c).getBlock().toString();
                                if (!(blockName.contains("securitycraft") && blockName.contains("reinforced"))) {

                                    if (blockName.contains("leaves")) {
                                        this.level().destroyBlock(c, false);
                                    }
                                    if (blockName.contains("log")) {
                                        this.level().destroyBlock(c, true);
                                    }
                                }
                            });
                }
            }
        }
    }

    public static boolean checkSpitterSpawnRules(EntityType<SpitterEntity> spitterEntityType, ServerLevelAccessor serverLevel, EntitySpawnReason entitySpawnReason, BlockPos pos, RandomSource random) {
        return Config.getSpittersSpawnNaturally()
                && !(serverLevel.getBiome(pos).is(Biomes.MUSHROOM_FIELDS))
                && serverLevel.getDifficulty() != Difficulty.PEACEFUL
                && Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                && Mob.checkMobSpawnRules(spitterEntityType, serverLevel, entitySpawnReason, pos, random);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 75.0)
            .add(Attributes.FOLLOW_RANGE, 25.0)
            .add(Attributes.MOVEMENT_SPEED, 0.2)
            .add(Attributes.ATTACK_DAMAGE, 4.0)
            .add(Attributes.ARMOR, 5.0)
            .add(Attributes.ATTACK_KNOCKBACK, 0.0)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
            .add(Attributes.STEP_HEIGHT, 1.0);
    }
}
