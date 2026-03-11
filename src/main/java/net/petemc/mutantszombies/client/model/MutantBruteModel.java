package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.petemc.mutantszombies.entity.MutantBruteEntity;

public class MutantBruteModel extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer torso;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_arm;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_leg;

    public MutantBruteModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;

        this.head = new ModelRenderer(this, 113, 50);
        this.head.setRotationPoint(1.0F, -23.0F, -26.0F);
        this.head.addBox(-7.0F, 0.0F, 5.0F, 19, 13, 21, 0.0F);

        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 24.0F, -13.0F);
        this.torso.addBox(-13.0F, -55.0F, -15.0F, 33, 34, 52, 0.0F);

        this.right_arm = new ModelRenderer(this, 120, 142);
        this.right_arm.setRotationPoint(-16.0F, -17.0F, -19.0F);
        this.right_arm.addBox(-13.0F, -3.0F, -4.0F, 13, 26, 12, 0.0F);

        this.left_arm = new ModelRenderer(this, 90, 0);
        this.left_arm.setRotationPoint(20.0F, -17.0F, -15.0F);
        this.left_arm.addBox(-7.0F, -6.0F, -10.0F, 21, 24, 17, 0.0F);

        this.left_leg = new ModelRenderer(this, 62, 142);
        this.left_leg.setRotationPoint(12.0F, -1.0F, 20.0F);
        this.left_leg.addBox(-6.0F, -4.0F, -6.0F, 13, 15, 16, 0.0F);

        this.right_leg = new ModelRenderer(this, 0, 0);
        this.right_leg.setRotationPoint(-13.0F, -1.0F, 20.0F);
        this.right_leg.addBox(-6.0F, -7.0F, -10.0F, 11, 18, 11, 0.0F);
    }

    public MutantBruteModel(Object ignoredRoot) {
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
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing) * -limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing) * limbSwingAmount;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        if (entitylivingbaseIn.getClass() == MutantBruteEntity.class) {
            MutantBruteEntity brute = (MutantBruteEntity) entitylivingbaseIn;
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
