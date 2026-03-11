package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;

public class ZombieBruteModel extends ModelBase {
    public final ModelRenderer head;
    public final ModelRenderer torso;
    public final ModelRenderer right_arm;
    public final ModelRenderer left_arm;
    public final ModelRenderer left_leg;
    public final ModelRenderer right_leg;

    public ZombieBruteModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        // HEAD (two boxes, different texture offsets)
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -15.0F, -17.0F);
        this.head.setTextureOffset(71, 49);
        this.head.addBox(-6.0F, -4.0F, -7.0F, 11, 9, 12, 0.0F);
        this.head.setTextureOffset(69, 99);
        this.head.addBox(-5.0F, 4.0F, -6.0F, 9, 3, 11, 0.0F);

        // TORSO (two boxes, different texture offsets)
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.torso.setTextureOffset(0, 0);
        this.torso.addBox(-15.0F, -41.0F, -15.0F, 29, 21, 28, 0.0F);
        this.torso.setTextureOffset(0, 49);
        this.torso.addBox(-13.0F, -20.0F, -9.0F, 25, 7, 21, 0.0F);

        // RIGHT ARM
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.setRotationPoint(-20.0F, -11.0F, -7.0F);

        ModelRenderer cube_r1 = new ModelRenderer(this, 86, 0);
        cube_r1.setRotationPoint(20.0F, 0.0F, 0.0F);
        cube_r1.rotateAngleX = -0.1309F;
        cube_r1.addBox(-23.0F, 14.0F, 5.0F, 8, 14, 8, 0.0F);
        this.right_arm.addChild(cube_r1);

        ModelRenderer cube_r2 = new ModelRenderer(this, 0, 77);
        cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r2.rotateAngleX = 0.3491F;
        cube_r2.addBox(-4.0F, 0.0F, -3.0F, 10, 18, 10, 0.0F);
        this.right_arm.addChild(cube_r2);

        // LEFT ARM
        this.left_arm = new ModelRenderer(this, 0, 0);
        this.left_arm.setRotationPoint(19.0F, -11.0F, -7.0F);

        ModelRenderer cube_r3 = new ModelRenderer(this, 80, 77);
        cube_r3.setRotationPoint(-19.0F, 0.0F, 0.0F);
        cube_r3.rotateAngleX = -0.1309F;
        cube_r3.addBox(14.0F, 14.0F, 5.0F, 8, 14, 8, 0.0F);
        this.left_arm.addChild(cube_r3);

        ModelRenderer cube_r4 = new ModelRenderer(this, 40, 77);
        cube_r4.setRotationPoint(-19.0F, 0.0F, 0.0F);
        cube_r4.rotateAngleX = 0.3491F;
        cube_r4.addBox(13.0F, 0.0F, -3.0F, 10, 18, 10, 0.0F);
        this.left_arm.addChild(cube_r4);

        // LEFT LEG
        this.left_leg = new ModelRenderer(this, 98, 99);
        this.left_leg.setRotationPoint(5.0F, 11.0F, -1.0F);
        this.left_leg.addBox(-2.0F, 11.0F, -3.0F, 5, 2, 6, 0.0F);

        ModelRenderer cube_r5 = new ModelRenderer(this, 104, 70);
        cube_r5.setRotationPoint(-5.0F, 13.0F, -3.0F);
        cube_r5.rotateAngleX = 0.3927F;
        cube_r5.addBox(3.0F, -7.0F, 1.0F, 5, 7, 5, 0.0F);
        this.left_leg.addChild(cube_r5);

        ModelRenderer cube_r6 = new ModelRenderer(this, 0, 0);
        cube_r6.setRotationPoint(1.0F, 1.0F, 0.0F);
        cube_r6.rotateAngleX = -0.3054F;
        cube_r6.addBox(-4.0F, -5.6533F, -3.2527F, 7, 12, 7, 0.0F);
        this.left_leg.addChild(cube_r6);

        // RIGHT LEG
        this.right_leg = new ModelRenderer(this, 0, 19);
        this.right_leg.setRotationPoint(-6.0F, 11.0F, -2.0F);
        this.right_leg.addBox(-2.0F, 11.0F, -3.0F, 5, 2, 6, 0.0F);

        ModelRenderer cube_r7 = new ModelRenderer(this, 0, 105);
        cube_r7.setRotationPoint(6.0F, 13.0F, -3.0F);
        cube_r7.rotateAngleX = -0.3054F;
        cube_r7.addBox(-9.0F, -18.0F, -4.0F, 7, 12, 7, 0.0F);
        this.right_leg.addChild(cube_r7);

        ModelRenderer cube_r8 = new ModelRenderer(this, 0, 49);
        cube_r8.setRotationPoint(6.0F, 13.0F, -3.0F);
        cube_r8.rotateAngleX = 0.3927F;
        cube_r8.addBox(-8.0F, -7.0F, 1.0F, 5, 7, 5, 0.0F);
        this.right_leg.addChild(cube_r8);
    }

    private static float triangleWave(float x, float period) {
        return (Math.abs(x % period - period * 0.5F) - period * 0.25F) / (period * 0.25F);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.head.render(scale);
        this.torso.render(scale);
        this.right_arm.render(scale);
        this.left_arm.render(scale);
        this.left_leg.render(scale);
        this.right_leg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * limbSwingAmount;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTick) {
        ZombieBruteEntity zombieBrute = (ZombieBruteEntity) entity;
        int i = zombieBrute.getAttackAnimationTick();
        if (i > 0) {
            this.right_arm.rotateAngleX = -2.0F + 1.5F * triangleWave((float) i - partialTick, 10.0F);
            this.left_arm.rotateAngleX = -2.0F + 1.5F * triangleWave((float) i - partialTick, 10.0F);
        } else {
            this.right_arm.rotateAngleX = (-0.2F + 1.5F * triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
            this.left_arm.rotateAngleX = (-0.2F - 1.5F * triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
        }
    }
}
