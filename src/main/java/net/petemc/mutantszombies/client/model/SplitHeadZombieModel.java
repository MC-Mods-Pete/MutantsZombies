package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SplitHeadZombieModel extends ModelBase {
    private final ModelRenderer head1;
    private final ModelRenderer head2;
    private final ModelRenderer torso;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_leg;

    public SplitHeadZombieModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.head1 = new ModelRenderer(this, 0, 26);
        this.head1.setRotationPoint(1.0F, 3.0F, 2.0F);
        this.head1.addBox(-7.0F, -8.0F, -7.0F, 6, 5, 6, 0.0F);

        this.head2 = new ModelRenderer(this, 26, 7);
        this.head2.setRotationPoint(-1.0F, 3.0F, 2.0F);
        this.head2.addBox(1.0F, -8.0F, -7.0F, 6, 5, 6, 0.0F);

        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.torso.addBox(-4.5F, -7.0F, -3.5F, 10, 7, 6, 0.0F);

        this.left_leg = new ModelRenderer(this, 35, 44);
        this.left_leg.setRotationPoint(4.5F, 7.5F, 0.5F);
        this.left_leg.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);

        this.right_leg = new ModelRenderer(this, 0, 37);
        this.right_leg.setRotationPoint(-3.25F, 8.5F, 2.0F);
        this.right_leg.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    }

    public SplitHeadZombieModel(Object ignoredRoot) {
        this();
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.head1.render(scale);
        this.head2.render(scale);
        this.torso.render(scale);
        this.left_leg.render(scale);
        this.right_leg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float yaw = netHeadYaw * 0.017453292F;
        float pitch = headPitch * 0.017453292F;

        this.head1.rotateAngleY = yaw;
        this.head1.rotateAngleX = pitch;
        this.head2.rotateAngleY = yaw;
        this.head2.rotateAngleX = pitch;

        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing) * -limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing) * limbSwingAmount;
    }
}