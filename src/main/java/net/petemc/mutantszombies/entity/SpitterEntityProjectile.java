package net.petemc.mutantszombies.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class SpitterEntityProjectile extends AbstractArrow implements ItemSupplier {
    public SpitterEntityProjectile(EntityType<? extends SpitterEntityProjectile> type, Level world) {
        super(type, world);
        this.setBaseDamage(3);
    }

    public SpitterEntityProjectile(LivingEntity entity, Level level) {
        super(ModEntities.SPITTER_PROJECTILE.get(), entity, level, new ItemStack(Items.SLIME_BALL), null);
        this.setBaseDamage(3);
    }

    public SpitterEntityProjectile(EntityType<? extends SpitterEntityProjectile> type, double x, double y, double z, Level level, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.SPITTER_PROJECTILE.get(), x, y, z, level, pickupItemStack, null);
        this.setBaseDamage(3);
    }

    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.SLIME_BLOCK_PLACE;
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity livingEntity) {
            if (!livingEntity.hasEffect(MobEffects.POISON)) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 10 * 20, 0));
            }
        }
    }

    protected void onHitBlock(@NotNull BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.setSoundEvent(SoundEvents.SLIME_BLOCK_PLACE);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.SLIME_BALL);
    }

    @Override
    public @NotNull ItemStack getItem() {
        return new ItemStack(Items.SLIME_BALL);
    }
}
