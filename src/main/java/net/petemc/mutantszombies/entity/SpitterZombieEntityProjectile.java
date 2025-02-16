package net.petemc.mutantszombies.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(
        value = Dist.CLIENT,
        _interface = ItemSupplier.class
)
public class SpitterZombieEntityProjectile extends AbstractArrow implements ItemSupplier {
    public SpitterZombieEntityProjectile(EntityType<? extends SpitterZombieEntityProjectile> type, Level world) {
        super(type, world);
    }

    public SpitterZombieEntityProjectile(LivingEntity entity, Level world) {
        super(ModEntities.SPITTER_ZOMBIE_PROJECTILE.get(), entity, world);
    }

    public SpitterZombieEntityProjectile(double x, double y, double z, Level world) {
        super(ModEntities.SPITTER_ZOMBIE_PROJECTILE.get(), x, y, z, world);
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return new ItemStack(Items.SLIME_BALL);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public @NotNull ItemStack getItem() {
        return new ItemStack(Items.SLIME_BALL);
    }
}
