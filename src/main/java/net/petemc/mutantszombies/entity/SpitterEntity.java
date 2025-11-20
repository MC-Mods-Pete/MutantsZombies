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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.petemc.mutantszombies.config.Config;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;

public class SpitterEntity extends HostileEntity implements RangedAttackMob {
    private int treeBreakCooldown = 40;

    public SpitterEntity(EntityType<SpitterEntity> type, World world) {
        super(type, world);
        this.experiencePoints = 10;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.25F, 50, 3.0F));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.1, false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[]{SpitterEntity.class}).setGroupRevenge(SpitterEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, true, true));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
    }

    protected void dropEquipment(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        super.dropEquipment(world, source, causedByPlayer);
        this.dropStack((new ItemStack(Items.SLIME_BALL, RandomUtils.nextInt(2, 5))));
    }

    public SoundEvent getAmbientSound() {
        return Registries.SOUND_EVENT.get(Identifier.of("entity.player.burp"));
    }

    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound(Registries.SOUND_EVENT.get(Identifier.of("block.basalt.step")), 0.15F, 1.0F);
    }

    public SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return Registries.SOUND_EVENT.get(Identifier.of("entity.zombie.hurt"));
    }

    public SoundEvent getDeathSound() {
        return Registries.SOUND_EVENT.get(Identifier.of("entity.husk.death"));
    }

    public boolean damage(DamageSource damageSource, float amount) {
        if (damageSource.isOf(DamageTypes.DROWN)) {
            return false;
        } else if (damageSource.isOf(DamageTypes.WITHER)) {
            return false;
        }
        return super.damage(damageSource, amount);
    }

    public void setOnFireFromLava() {
        if (this.damage(this.getDamageSources().lava(), 4.0F)) {
            this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.4F, 2.0F + this.random.nextFloat() * 0.4F);
        }
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        SpitterEntityProjectile projectile = new SpitterEntityProjectile(this, this.getWorld());
        double d0 = target.getY() + (double)target.getStandingEyeHeight() - 1.1;
        double d1 = target.getX() - this.getX();
        double d3 = target.getZ() - this.getZ();
        projectile.setVelocity(d1, d0 - projectile.getY() + Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F, d3, 1.6F, 12.0F);
        this.getWorld().spawnEntity(projectile);
    }

    @Override
    public void tick() {
        super.tick();
        if (Config.getSpittersBreakLogsAndLeavesAroundThem()) {
            if (treeBreakCooldown > 0) {
                treeBreakCooldown--;
            } else {
                if (!this.getWorld().isClient()) {
                    treeBreakCooldown = 40;

                    Box box = new Box(this.getPos(), this.getPos());
                    box = box.expand(3);
                    box = box.expand(0,1,0);

                    BlockPos.Mutable.stream(box)
                        .filter(c -> ((getWorld().getBlockState(c).getBlock().toString().contains("leaves")) ||
                                (getWorld().getBlockState(c).getBlock().toString().contains("log"))))
                        .forEach(c -> {
                            String blockName = getWorld().getBlockState(c).getBlock().toString();
                            if (!(blockName.contains("securitycraft") && blockName.contains("reinforced"))) {

                                if (blockName.contains("leaves")) {
                                    this.getWorld().breakBlock(c, false);
                                }
                                if (blockName.contains("log")) {
                                    this.getWorld().breakBlock(c, true);
                                }
                            }
                        });
                }
            }
        }
    }

    public static void init() {
        SpawnRestriction.register(ModEntities.SPITTER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        Config.getSpittersSpawnNaturally()
                                && !(world.getBiome(pos).matchesKey(BiomeKeys.MUSHROOM_FIELDS))
                                && !(world.getBiome(pos).matchesKey(BiomeKeys.DEEP_DARK))
                                && world.getDifficulty() != Difficulty.PEACEFUL
                                && HostileEntity.isSpawnDark(world, pos, random)
                                && HostileEntity.canMobSpawn(entityType, world, reason, pos, random));

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER, ModEntities.SPITTER, 9, 1, 2);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 75.0)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 25.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
            .add(EntityAttributes.GENERIC_ARMOR, 5.0)
            .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
            .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.0);
    }
}
