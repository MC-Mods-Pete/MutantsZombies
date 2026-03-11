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

        this.head = new ModelRenderer(this, 71, 49);
        this.head.setRotationPoint(0.0F, -15.0F, -17.0F);
        this.head.addBox(-6.0F, -4.0F, -7.0F, 11, 9, 12, 0.0F);

        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.torso.addBox(-15.0F, -41.0F, -15.0F, 29, 21, 28, 0.0F);

        this.right_arm = new ModelRenderer(this, 0, 77);
        this.right_arm.setRotationPoint(-20.0F, -11.0F, -7.0F);
        this.right_arm.addBox(-4.0F, 0.0F, -3.0F, 10, 18, 10, 0.0F);

        this.left_arm = new ModelRenderer(this, 40, 77);
        this.left_arm.setRotationPoint(19.0F, -11.0F, -7.0F);
        this.left_arm.addBox(-6.0F, 0.0F, -3.0F, 10, 18, 10, 0.0F);

        this.left_leg = new ModelRenderer(this, 0, 0);
        this.left_leg.setRotationPoint(5.0F, 11.0F, -1.0F);
        this.left_leg.addBox(-3.0F, 0.0F, -3.0F, 7, 12, 7, 0.0F);

        this.right_leg = new ModelRenderer(this, 0, 105);
        this.right_leg.setRotationPoint(-6.0F, 11.0F, -2.0F);
        this.right_leg.addBox(-4.0F, 0.0F, -3.0F, 7, 12, 7, 0.0F);
    }

    public ZombieBruteModel(Object ignoredRoot) {
        this();
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.head.render(scale);
        this.torso.render(scale);
        this.right_arm.render(scale);
        this.left_arm.render(scale);
        this.left_leg.render(scale);
        this.right_leg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing) * -limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing) * limbSwingAmount;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        if (entitylivingbaseIn.getClass() == ZombieBruteEntity.class) {
            ZombieBruteEntity brute = (ZombieBruteEntity) entitylivingbaseIn;
            int attackTicks = brute.getAttackAnimationTick();
            if (attackTicks > 0) {
                this.right_arm.rotateAngleX = -2.0F + 1.5F * triangleWave((float) attackTicks - partialTickTime, 10.0F);
                this.left_arm.rotateAngleX = -2.0F + 1.5F * triangleWave((float) attackTicks - partialTickTime, 10.0F);
            } else {
                this.right_arm.rotateAngleX = (-0.2F + 1.5F * triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
                this.left_arm.rotateAngleX = (-0.2F - 1.5F * triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
            }
        }
    }

    private static float triangleWave(float value, float period) {
        return (Math.abs(value % period - period * 0.5F) - period * 0.25F) / (period * 0.25F);
    }
}
