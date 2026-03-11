package net.petemc.mutantszombies.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SpitterEntityProjectile extends EntityTippedArrow {
    public SpitterEntityProjectile(World worldIn) {
        super(worldIn);
        this.setDamage(3.0D);
    }

    public SpitterEntityProjectile(World worldIn, EntityLivingBase shooter) {
        super(worldIn, shooter);
        this.setDamage(3.0D);
    }

    public SpitterEntityProjectile(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        this.setDamage(3.0D);
    }

    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {
        super.onHit(raytraceResultIn);
        if (raytraceResultIn.entityHit instanceof EntityLivingBase) {
            EntityLivingBase living = (EntityLivingBase) raytraceResultIn.entityHit;
            if (!living.isPotionActive(MobEffects.POISON)) {
                living.addPotionEffect(new PotionEffect(MobEffects.POISON, 10 * 20, 0));
            }
        }

        if (raytraceResultIn.typeOfHit == RayTraceResult.Type.BLOCK) {
            this.playSound(SoundEvents.BLOCK_SLIME_PLACE, 1.0F, 1.0F);
        }
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(Items.SLIME_BALL);
    }
}
