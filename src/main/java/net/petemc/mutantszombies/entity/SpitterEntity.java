package net.petemc.mutantszombies.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.petemc.mutantszombies.config.Config;

public class SpitterEntity extends EntityMob implements IRangedAttackMob {
    private int treeBreakCooldown = 40;

    public SpitterEntity(World world) {
        super(world);
        this.stepHeight = 1.0F;
        this.experienceValue = 10;
        this.setSize(1.8F, 2.7F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new net.minecraft.entity.ai.EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackRanged(this, 1.25D, 50, 10.0F));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.1D, false));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, SpitterEntity.class));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityIronGolem.class, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<>(this, EntityVillager.class, true));
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PLAYER_BURP;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.BLOCK_STONE_STEP, 0.15F, 1.0F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HUSK_DEATH;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        super.dropFewItems(wasRecentlyHit, lootingModifier);
        this.entityDropItem(new ItemStack(Items.SLIME_BALL, 2 + this.rand.nextInt(3)), 0.0F);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source == DamageSource.DROWN || source == DamageSource.WITHER) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        SpitterEntityProjectile projectile = new SpitterEntityProjectile(this.world, this);
        double dy = target.posY + target.getEyeHeight() - 1.1D;
        double dx = target.posX - this.posX;
        double dz = target.posZ - this.posZ;
        projectile.shoot(dx, dy - projectile.posY + Math.sqrt(dx * dx + dz * dz) * 0.2D, dz, 1.6F, 12.0F);
        this.world.spawnEntity(projectile);
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!Config.getSpittersBreakLogsAndLeavesAroundThem()) {
            return;
        }

        if (treeBreakCooldown > 0) {
            treeBreakCooldown--;
            return;
        }

        if (this.world.isRemote) {
            return;
        }

        treeBreakCooldown = 40;
        BlockPos min = new BlockPos(this.posX - 2, this.posY - 1, this.posZ - 2);
        BlockPos max = new BlockPos(this.posX + 2, this.posY + 2, this.posZ + 2);

        for (BlockPos.MutableBlockPos pos : BlockPos.getAllInBoxMutable(min, max)) {
            String name = this.world.getBlockState(pos).getBlock().getRegistryName().toString();
            if (name.contains("securitycraft") && name.contains("reinforced")) {
                continue;
            }
            if (name.contains("leaves")) {
                this.world.destroyBlock(pos, false);
            } else if (name.contains("log")) {
                this.world.destroyBlock(pos, true);
            }
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(75.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
    }

    public static void init() {
        // Keep spawn hook method for compatibility with caller.
    }

    @Override
    public boolean getCanSpawnHere() {
        return Config.getSpittersSpawnNaturally()
            && this.world.getDifficulty() != net.minecraft.world.EnumDifficulty.PEACEFUL
            && this.world.getBiome(this.getPosition()) != Biomes.MUSHROOM_ISLAND
            && super.getCanSpawnHere();
    }
}
