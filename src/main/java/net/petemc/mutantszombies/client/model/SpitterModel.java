package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SpitterModel extends ModelBase {
    public final ModelRenderer head2;
    public final ModelRenderer head3;
    public final ModelRenderer head4;
    public final ModelRenderer head5;
    public final ModelRenderer head6;
    public final ModelRenderer head7;
    public final ModelRenderer head8;
    public final ModelRenderer torso;
    public final ModelRenderer right_arm;
    public final ModelRenderer left_arm;
    public final ModelRenderer left_leg;
    public final ModelRenderer right_leg;

    public SpitterModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;

        this.head2 = new ModelRenderer(this, 96, 95);
        this.head2.setRotationPoint(-13.0F, 7.0F, -8.0F);
        this.head2.addBox(-4.0F, -2.0F, -2.0F, 8, 6, 8, 0.0F);

        this.head3 = new ModelRenderer(this, 32, 95);
        this.head3.setRotationPoint(-1.0F, 3.0F, -10.0F);
        this.head3.addBox(-4.0F, -2.0F, -2.0F, 8, 6, 8, 0.0F);

        this.head4 = new ModelRenderer(this, 84, 81);
        this.head4.setRotationPoint(0.0F, -6.0F, 4.0F);
        this.head4.addBox(-4.0F, -2.0F, -2.0F, 8, 6, 8, 0.0F);

        this.head5 = new ModelRenderer(this, 64, 95);
        this.head5.setRotationPoint(12.0F, 10.0F, -6.0F);
        this.head5.addBox(-4.0F, -2.0F, -2.0F, 8, 6, 8, 0.0F);

        this.head6 = new ModelRenderer(this, 0, 95);
        this.head6.setRotationPoint(12.0F, 5.0F, 10.0F);
        this.head6.addBox(-4.0F, -2.0F, -2.0F, 8, 6, 8, 0.0F);

        this.head7 = new ModelRenderer(this, 108, 75);
        this.head7.setRotationPoint(-10.0F, -4.0F, 11.0F);
        this.head7.addBox(-4.0F, -2.0F, -2.0F, 8, 8, 6, 0.0F);

        this.head8 = new ModelRenderer(this, 80, 0);
        this.head8.setRotationPoint(-8.0F, 11.0F, 8.0F);
        this.head8.addBox(-4.0F, -2.0F, -2.0F, 8, 6, 8, 0.0F);

        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.torso.addBox(-14.0F, -16.0F, -10.0F, 28, 16, 24, 0.0F);

        this.right_arm = new ModelRenderer(this, 75, 53);
        this.right_arm.setRotationPoint(-13.0F, -5.0F, 5.0F);
        this.right_arm.addBox(-6.0F, 0.0F, -3.0F, 12, 4, 5, 0.0F);

        this.left_arm = new ModelRenderer(this, 80, 14);
        this.left_arm.setRotationPoint(11.0F, -4.4F, 7.6F);
        this.left_arm.addBox(-6.0F, 0.0F, -3.0F, 12, 4, 5, 0.0F);

        this.left_leg = new ModelRenderer(this, 0, 0);
        this.left_leg.setRotationPoint(10.0F, 16.0F, 0.0F);
        this.left_leg.addBox(-2.0F, 0.0F, -1.0F, 5, 9, 6, 0.0F);

        this.right_leg = new ModelRenderer(this, 0, 40);
        this.right_leg.setRotationPoint(-10.0F, 16.0F, 0.0F);
        this.right_leg.addBox(-3.0F, 0.0F, -1.0F, 5, 9, 6, 0.0F);
    }

    public SpitterModel(Object ignoredRoot) {
        this();
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.head2.render(scale);
        this.head3.render(scale);
        this.head4.render(scale);
        this.head5.render(scale);
        this.head6.render(scale);
        this.head7.render(scale);
        this.head8.render(scale);
        this.torso.render(scale);
        this.right_arm.render(scale);
        this.left_arm.render(scale);
        this.left_leg.render(scale);
        this.right_leg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float yaw = netHeadYaw * 0.017453292F;
        float pitch = headPitch * 0.017453292F;

        this.head2.rotateAngleY = yaw;
        this.head2.rotateAngleX = pitch;
        this.head3.rotateAngleY = yaw;
        this.head3.rotateAngleX = pitch;
        this.head4.rotateAngleY = yaw;
        this.head4.rotateAngleX = pitch;
        this.head5.rotateAngleY = yaw;
        this.head5.rotateAngleX = pitch;
        this.head6.rotateAngleY = yaw;
        this.head6.rotateAngleX = pitch;
        this.head7.rotateAngleY = yaw;
        this.head7.rotateAngleX = pitch;
        this.head8.rotateAngleY = yaw;
        this.head8.rotateAngleX = pitch;

        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing) * -limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing) * limbSwingAmount;
    }
}
