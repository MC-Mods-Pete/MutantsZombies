package net.petemc.mutantszombies.entity;

import com.nyfaria.awcapi.ClimberHelper;
import com.nyfaria.awcapi.entity.ClimberComponent;
import com.nyfaria.awcapi.entity.IAdvancedClimber;
import com.nyfaria.awcapi.entity.movement.ClimberPathNavigator;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.petemc.mutantszombies.config.Config;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CrawlerEntity extends Monster implements IAdvancedClimber {

    private final ClimberComponent climberComponent = new ClimberComponent(this);
    private int stuckInWallTicks = 0;

    public CrawlerEntity(EntityType<CrawlerEntity> type, Level world) {
        super(type, world);
        this.xpReward = 5;
        // initClimber sets moveControl/lookControl/jumpControl and maxUpStep=0.1F
        ClimberHelper.initClimber(this);
        // 0.6F = standard mob step height: high enough for edge traversal while climbing,
        // but low enough to avoid being pushed into the opposite wall in a 2x2 shaft (0.9 blocks of clearance)
        // (1.0F was too large → entity got stuck in wall)
        this.setMaxUpStep(0.6F);
    }

    // =========================================================================
    // IAdvancedClimber – exakt wie SpiderMixin
    // =========================================================================

    @Override
    public ClimberComponent getClimberComponent() { return climberComponent; }

    @Override
    public Mob asMob() { return this; }

    @Override
    public float getMovementSpeed() {
        return (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED);
    }

    @Override
    public float getBlockSlipperiness(BlockPos pos) {
        BlockState state = this.level().getBlockState(pos);
        return state.getBlock().getFriction() * 0.91f;
    }

    @Override
    public void setLerpYRot(Float yRot) {
        this.lerpYRot = yRot != null ? yRot.doubleValue() : 0.0;
    }

    @Override
    public void setLerpXRot(Float xRot) {
        this.lerpXRot = xRot != null ? xRot.doubleValue() : 0.0;
    }

    @Override
    public void setLerpYHeadRot(Float yHeadRot) { /* awcapi handles head rotation */ }

    @Override
    public void setLerpHeadSteps(int steps) { this.lerpHeadSteps = steps; }

    // =========================================================================
    // Navigation – ClimberPathNavigator (useVanillaBehaviour=true)
    // Internally: AdvancedClimberPathNavigator(entity, level, false, true, true)
    // =========================================================================

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        // useVanillaBehaviour=FALSE → awcapi uses 3D pathfinding for walls/ceilings!
        // useVanillaBehaviour=true would fall back to 2D vanilla navigation → getting stuck on corners
        ClimberPathNavigator<CrawlerEntity> nav = new ClimberPathNavigator<>(this, level, false);
        nav.setCanFloat(true);  // true = can float/swim (SpiderMixin value)
        return nav;
    }

    // =========================================================================
     // IAdvancedPathFindingEntity – exactly like SpiderMixin
    // =========================================================================

    /** Max ticks before stuck check kicks in (SpiderMixin: bipush 40) */
    @Override
    public int getMaxStuckCheckTicks() { return 40; }

    /** Disable bridge pathing (SpiderMixin: ldc -1.0F; freturn) */
    @Override
    public float getBridgePathingMalus(@NotNull Mob mob, @NotNull BlockPos pos, @NotNull Node node) { return -1.0F; }

    /** Allow climbing on ALL blocks (SpiderMixin: !blockState.is(NON_CLIMBABLE)). Since we have no NON_CLIMBABLE tag, just return true. */
    @Override
    public boolean canClimbOnBlock(@NotNull BlockState state, @NotNull BlockPos pos) { return true; }

    /** Disable debug pathing preview */
    @Override
    public boolean shouldTrackPathingTargets() { return false; }

    /**
     * Pathfinding cost calculation – exactly like SpiderMixin:
     * - If offset.getY() == 0 (horizontal movement): return standard malus
     * - If Y != 0 (vertical movement = climbing): check if any allowed direction
     *   has a climbable block; if not → -1.0F (impassable)
     */
    @Override
    public float getPathingMalus(@NotNull BlockGetter level, @NotNull Mob mob,
                                  @NotNull BlockPathTypes pathType, @NotNull BlockPos pos,
                                  @NotNull Vec3i offset,
                                  @NotNull java.util.function.Predicate<Direction> allowedDirections) {
        if (offset.getY() != 0) {
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
            for (Direction dir : Direction.values()) {
                if (!allowedDirections.test(dir)) continue;
                mutable.set(pos.getX() + dir.getStepX(),
                            pos.getY() + dir.getStepY(),
                            pos.getZ() + dir.getStepZ());
                BlockState state = level.getBlockState(mutable);
                if (this.canClimbOnBlock(state, mutable)) {
                    return mob.getPathfindingMalus(pathType);
                }
            }
            return -1.0F;
        }
        return mob.getPathfindingMalus(pathType);
    }

    // =========================================================================
     // Physics methods – 1:1 ported from SpiderMixin bytecode
    // =========================================================================

    /**
     * onClimbable() → always false.
     * awcapi fully handles gravity and surface adhesion.
     * (SpiderMixin: iconst_0; ireturn)
     */
    @Override
    public boolean onClimbable() { return false; }

    /**
     * aiStep: call livingTickClimber BEFORE super.aiStep().
     * (SpiderMixin: invokestatic livingTickClimber → invokespecial Monster.aiStep)
     */
    /**
     * tickClimber MUST be called in tick() (corresponds to @Inject HEAD in SpiderMixin$onTick).
     * It updates prevAttachmentNormal, prevAttachmentOffset etc. for frame interpolation.
     * Without this call, preRenderClimber cannot compute correct orientation rotation
     * → entity doesn't rotate on walls/ceiling.
     */
    @Override
    public void tick() {
        ClimberHelper.tickClimber(this);
        super.tick();
        if (!this.level().isClientSide()) {
            tryRescueFromWall();
        }
    }

    /**
     * Detects if the crawler is stuck inside a solid block and ejects it.
     * This handles edge cases during wall/ceiling transitions where the hitbox
     * briefly overlaps with block geometry and the entity gets trapped.
     */
    private void tryRescueFromWall() {
        BlockPos center = this.blockPosition();
        BlockState centerState = this.level().getBlockState(center);

        if (centerState.isSuffocating(this.level(), center)) {
            stuckInWallTicks++;
            if (stuckInWallTicks >= 3) {
                stuckInWallTicks = 0;
                // Prefer ejecting away from the climbing surface, then try all directions
                Direction groundSide = getClimberComponent().getGroundSide();
                Direction[] preferred = new Direction[Direction.values().length];
                int i = 0;
                if (groundSide != null) preferred[i++] = groundSide.getOpposite();
                for (Direction d : Direction.values()) {
                    if (d != groundSide) preferred[i++] = d;
                }
                for (Direction dir : preferred) {
                    if (dir == null) continue;
                    BlockPos candidate = center.relative(dir);
                    if (!this.level().getBlockState(candidate).isSuffocating(this.level(), candidate)) {
                        this.setPos(candidate.getX() + 0.5, candidate.getY(), candidate.getZ() + 0.5);
                        this.setDeltaMovement(Vec3.ZERO);
                        break;
                    }
                }
            }
        } else {
            stuckInWallTicks = 0;
        }
    }

    @Override
    public void aiStep() {
        ClimberHelper.livingTickClimber(this);
        super.aiStep();
    }

    /**
     * lookAt: transform lookup direction into the local coordinate system of the current surface.
     * (SpiderMixin m_7618_: diff = vec - eyePos → orientation.getLocal(diff) → super.lookAt(eyePos + diff))
     * Without this override, the entity looks in wrong directions while climbing.
     */
    @Override
    public void lookAt(@NotNull EntityAnchorArgument.Anchor anchor, @NotNull Vec3 vec) {
        Vec3 diff = vec.subtract(this.getEyePosition());
        diff = this.getOrientation().getLocal(diff);
        super.lookAt(anchor, this.getEyePosition().add(diff));
    }

    /**
      * move: handleMove(true)=PRE → super.move() → handleMove(false)=POST
      * NOTE: true=pre, false=post (SpiderMixin bytecode: iconst_1 before super, iconst_0 after super)
     */
    @Override
    public void move(@NotNull MoverType type, @NotNull Vec3 delta) {
        ClimberHelper.handleMove(this, type, delta, true);   // PRE
        super.move(type, delta);
        ClimberHelper.handleMove(this, type, delta, false);  // POST
    }

    /**
     * getOnPos: corrected block position for surface detection.
     * (SpiderMixin: super.getOnPos() → ClimberHelper.getAdjustedOnPosition)
     */
    @Override
    public @NotNull BlockPos getOnPos() {
        return ClimberHelper.getAdjustedOnPosition(this, super.getOnPos());
    }

    /**
    /**
     * travel: handleTravel → if false, super.travel(); ALWAYS postTravel.
     * (SpiderMixin: handleTravel → ifne skip_super → postTravel)
     */
    @Override
    public void travel(@NotNull Vec3 travelVector) {
        if (!ClimberHelper.handleTravel(this, travelVector)) {
            super.travel(travelVector);
        }
        ClimberHelper.postTravel(this, travelVector);
    }

    /**
     * jumpFromGround: handleJump → if false, super.jumpFromGround().
     * (SpiderMixin m_6135_: handleJump → ifne skip_super)
     */
    @Override
    protected void jumpFromGround() {
        if (!ClimberHelper.handleJump(this)) {
            super.jumpFromGround();
        }
    }

    // =========================================================================
    // NBT – ClimberComponent speichern/laden (SpiderMixin: addAdditional/readAdditional)
    // =========================================================================

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (climberComponent != null) climberComponent.writeToNbt(tag);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (climberComponent != null) climberComponent.readFromNbt(tag);
    }

    // =========================================================================
     // Goals / Attributes / Sounds – unchanged
    // =========================================================================

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[]{CrawlerEntity.class}).setAlertOthers(CrawlerEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        registerCustomGoals();
    }

    protected void registerCustomGoals() {}

    @Override
    public @NotNull MobType getMobType() { return MobType.UNDEAD; }

    @Override
    protected void dropCustomDeathLoot(@NotNull DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.horse.breathe"));
    }

    @Override
    public void playStepSound(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.playSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.cave_vines.step"))), 0.15F, 1.0F);
    }

    @Override
    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.zombie.hurt")));
    }

    @Override
    public @NotNull SoundEvent getDeathSound() {
        return Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.husk.death")));
    }

    @Override
    public boolean hurt(DamageSource damageSource, float amount) {
        if (damageSource.is(DamageTypes.FALL)) return false;
        if (damageSource.is(DamageTypes.DROWN)) return false;
        if (damageSource.is(DamageTypes.WITHER)) return false;
        // Prevent suffocation: crawler crawls on walls and contacts blocks –
        // this is intentional and should not cause damage.
        if (damageSource.is(DamageTypes.IN_WALL)) return false;
        return super.hurt(damageSource, amount);
    }

    /**
     * Minecraft checks every tick whether the eye position is inside a solid block.
     * While wall climbing this is unavoidable (transition floor→wall→ceiling in tight shafts).
     * isInWall() = false prevents the check from dealing any damage.
     */
    @Override
    public boolean isInWall() {
        // While wall crawling, the crawler is intentionally
        // close to/in block geometry – disable suffocation check here.
        ClimberComponent cc = getClimberComponent();
        if (cc != null) {
            // If not on ground (DOWN), we're climbing – ignore suffocation
            Direction side = cc.getGroundSide();
            if (side != Direction.DOWN) {
                return false;
            }
        }
        return super.isInWall();
    }

    public static void init() {
        SpawnPlacements.register(ModEntities.CRAWLER.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, serverLevel, reason, pos, random) ->
                        Config.getCrawlersSpawnNaturally()
                                && !(serverLevel.getBiome(pos).is(Biomes.MUSHROOM_FIELDS))
                                && !(serverLevel.getBiome(pos).is(Biomes.DEEP_DARK))
                                && serverLevel.getDifficulty() != Difficulty.PEACEFUL
                                && Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                                && Mob.checkMobSpawnRules(entityType, serverLevel, reason, pos, random));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 6.0)
            .add(Attributes.FOLLOW_RANGE, 35.0)
            .add(Attributes.MOVEMENT_SPEED, 0.3)
            .add(Attributes.ATTACK_DAMAGE, 3.0)
            .add(Attributes.ARMOR, 0.0)
            .add(Attributes.ATTACK_KNOCKBACK, 0.0)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.0);
    }
}
