package net.petemc.mutantszombies.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class SpitterEntityProjectile extends PersistentProjectileEntity implements FlyingItemEntity {
    public SpitterEntityProjectile(EntityType<? extends SpitterEntityProjectile> type, World world) {
        super(type, world);
    }

    public SpitterEntityProjectile(LivingEntity entity, World world) {
        super(ModEntities.SPITTER_PROJECTILE, entity, world, new ItemStack(Items.SLIME_BALL), null);
    }

    public SpitterEntityProjectile(double x, double y, double z, World world, ItemStack pickupItemStack, ItemStack firedFromWeapon) {
        super(ModEntities.SPITTER_PROJECTILE, x, y, z, world, pickupItemStack, firedFromWeapon);
    }

    @Override
    protected @NotNull SoundEvent getHitSound() {
        return SoundEvents.BLOCK_SLIME_BLOCK_PLACE;
    }

    @Override
    protected void onBlockHit(BlockHitResult pResult) {
        super.onBlockHit(pResult);
        this.setSound(SoundEvents.BLOCK_SLIME_BLOCK_PLACE);
    }

    @Override
    protected @NotNull ItemStack asItemStack() {
        return new ItemStack(Items.SLIME_BALL);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(Items.SLIME_BALL);
    }

    @Override
    public ItemStack getStack() {
        return new ItemStack(Items.SLIME_BALL);
    }
}

