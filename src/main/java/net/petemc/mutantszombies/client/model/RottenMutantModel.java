package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class RottenMutantModel extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer torso;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_leg;

    public RottenMutantModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.head = new ModelRenderer(this, 1, 97);
        this.head.setRotationPoint(0.0F, -8.5F, -4.5F);
        this.head.addBox(-4.5F, -8.0F, -8.0F, 9, 9, 8, 0.25F);

        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 4.0F, 1.0F);
        this.torso.addBox(-6.0F, -14.0F, -5.0F, 12, 14, 9, 0.0F);

        this.left_arm = new ModelRenderer(this, 31, 11);
        this.left_arm.setRotationPoint(6.0F, -7.0F, -3.0F);
        this.left_arm.addBox(0.0F, 1.0F, -9.0F, 4, 4, 11, 0.0F);

        this.right_arm = new ModelRenderer(this, 0, 38);
        this.right_arm.setRotationPoint(-6.0F, -7.0F, -3.0F);
        this.right_arm.addBox(-4.0F, -1.0F, -9.0F, 4, 4, 11, 0.0F);

        this.left_leg = new ModelRenderer(this, 17, 38);
        this.left_leg.setRotationPoint(3.0F, 4.0F, 0.0F);
        this.left_leg.addBox(-2.0F, 14.0F, -4.0F, 4, 6, 3, 0.25F);

        this.right_leg = new ModelRenderer(this, 29, 78);
        this.right_leg.setRotationPoint(-3.0F, 3.0F, 0.0F);
        this.right_leg.addBox(-2.0F, 9.0F, -3.0F, 4, 16, 4, 0.5F);
    }

    public RottenMutantModel(Object ignoredRoot) {
        this();
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.head.render(scale);
        this.torso.render(scale);
        this.left_arm.render(scale);
        this.right_arm.render(scale);
        this.left_leg.render(scale);
        this.right_leg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI) * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing) * -limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing) * limbSwingAmount;
    }
}