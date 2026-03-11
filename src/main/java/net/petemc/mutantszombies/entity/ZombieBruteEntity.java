package net.petemc.mutantszombies.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.petemc.mutantszombies.config.Config;
import net.petemc.mutantszombies.sound.ModSounds;

public class ZombieBruteEntity extends EntityMob {
    private int attackTicksLeft;
    private int treeBreakCooldown = 40;

    public ZombieBruteEntity(World world) {
        super(world);
        this.stepHeight = 1.0F;
        this.experienceValue = 15;
        this.setSize(2.0F, 2.7F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new net.minecraft.entity.ai.EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.1D, false));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, ZombieBruteEntity.class));
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
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.BLOCK_GRAVEL_STEP, 0.15F, 1.0F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source == DamageSource.DROWN || source == DamageSource.WITHER) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        boolean hit = super.attackEntityAsMob(target);
        this.attackTicksLeft = 10;
        this.world.setEntityState(this, (byte) 4);
        this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
        return hit;
    }

    @Override
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            this.attackTicksLeft = 10;
            this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.attackTicksLeft > 0) {
            this.attackTicksLeft--;
        }

        if (!Config.getZombieBrutesBreakLogsAndLeavesAroundThem() || this.world.isRemote) {
            return;
        }

        if (treeBreakCooldown > 0) {
            treeBreakCooldown--;
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

    public int getAttackAnimationTick() {
        return this.attackTicksLeft;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.21D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
    }

    public static void init() {
        // Keep spawn hook method for compatibility with caller.
    }

    @Override
    public boolean getCanSpawnHere() {
        return Config.getZombieBrutesSpawnNaturally()
            && this.world.getDifficulty() != net.minecraft.world.EnumDifficulty.PEACEFUL
            && this.world.getBiome(this.getPosition()) != Biomes.MUSHROOM_ISLAND
            && super.getCanSpawnHere();
    }
}
