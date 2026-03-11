package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CrawlerModel extends ModelBase {
    public final ModelRenderer head;
    public final ModelRenderer torso;
    public final ModelRenderer left_arm;
    public final ModelRenderer right_arm;
    public final ModelRenderer left_leg;
    public final ModelRenderer right_leg;

    public CrawlerModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 31, 0);
        this.head.setRotationPoint(0.0F, 15.0F, -4.0F);
        this.head.addBox(-3.0F, -3.0F, -6.0F, 6, 4, 6, 0.0F);

        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 19.0F, 2.0F);
        this.torso.addBox(-4.0F, -4.0F, -7.0F, 8, 4, 15, 0.0F);

        this.left_arm = new ModelRenderer(this, 37, 36);
        this.left_arm.setRotationPoint(4.0F, 16.0F, -3.0F);
        this.left_arm.addBox(0.0F, 0.0F, -3.0F, 3, 3, 6, 0.0F);

        this.right_arm = new ModelRenderer(this, 11, 43);
        this.right_arm.setRotationPoint(-4.0F, 16.0F, -3.0F);
        this.right_arm.addBox(-3.0F, 0.0F, -3.0F, 3, 3, 6, 0.0F);

        this.left_leg = new ModelRenderer(this, 22, 33);
        this.left_leg.setRotationPoint(4.0F, 17.0F, 9.0F);
        this.left_leg.addBox(-1.0F, 0.0F, -2.0F, 3, 3, 7, 0.0F);

        this.right_leg = new ModelRenderer(this, 0, 31);
        this.right_leg.setRotationPoint(-4.0F, 17.0F, 9.0F);
        this.right_leg.addBox(-2.0F, 0.0F, -2.0F, 3, 3, 7, 0.0F);
    }

    public CrawlerModel(Object ignoredRoot) {
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
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing) * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing) * -limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing) * -limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing) * limbSwingAmount;
    }
}
