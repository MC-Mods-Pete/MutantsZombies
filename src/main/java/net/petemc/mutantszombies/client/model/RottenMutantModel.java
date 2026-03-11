package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class RottenMutantModel extends ModelBase {
    public final ModelRenderer head;
    public final ModelRenderer torso;
    public final ModelRenderer metalrods;
    public final ModelRenderer left_arm;
    public final ModelRenderer right_arm;
    public final ModelRenderer left_leg;
    public final ModelRenderer right_leg;

    public RottenMutantModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        // HEAD (baked rotation from PartPose)
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -8.5F, -4.5F);
        this.head.rotateAngleX = -0.1274F;
        this.head.rotateAngleZ = 0.0436F;

        ModelRenderer cube_r1 = new ModelRenderer(this, 15, 106);
        cube_r1.setRotationPoint(0.85F, -1.675F, -3.075F);
        cube_r1.rotateAngleY = -0.4363F;
        cube_r1.rotateAngleZ = 1.5708F;
        cube_r1.addBox(-1.0F, -3.0F, -3.0F, 2, 3, 4, 0.0F);
        this.head.addChild(cube_r1);

        ModelRenderer cube_r2 = new ModelRenderer(this, 18, 31);
        cube_r2.setRotationPoint(4.75F, -6.5F, -0.15F);
        cube_r2.rotateAngleX = -0.436F;
        cube_r2.rotateAngleY = 0.0184F;
        cube_r2.rotateAngleZ = -3.102F;
        cube_r2.addBox(-1.0F, -3.0F, -3.0F, 2, 3, 4, 0.0F);
        this.head.addChild(cube_r2);

        ModelRenderer cube_r3 = new ModelRenderer(this, 21, 105);
        cube_r3.setRotationPoint(1.0F, -8.5F, -4.5F);
        cube_r3.rotateAngleY = -0.4363F;
        cube_r3.rotateAngleZ = 1.5708F;
        cube_r3.addBox(-1.0F, -3.0F, -3.0F, 2, 4, 5, 0.0F);
        this.head.addChild(cube_r3);

        ModelRenderer cube_r4 = new ModelRenderer(this, 7, 101);
        cube_r4.setRotationPoint(-5.0F, -4.25F, -2.0F);
        cube_r4.rotateAngleX = 0.48F;
        cube_r4.addBox(-1.0F, -3.0F, -3.0F, 2, 5, 5, 0.0F);
        this.head.addChild(cube_r4);

        ModelRenderer cube_r5 = new ModelRenderer(this, 35, 27);
        cube_r5.setRotationPoint(4.0F, -3.25F, -8.975F);
        cube_r5.rotateAngleX = 0.3745F;
        cube_r5.rotateAngleY = -1.0204F;
        cube_r5.rotateAngleZ = 0.1668F;
        cube_r5.addBox(4.0F, -1.0F, -5.0F, 1, 1, 23, 0.0F); // 0.5w→1
        this.head.addChild(cube_r5);

        ModelRenderer cube_r6 = new ModelRenderer(this, 1, 97);
        cube_r6.setRotationPoint(0.0F, 3.4451F, -4.1885F);
        cube_r6.rotateAngleX = -1.0908F;
        cube_r6.addBox(-4.5468F, -10.2426F, -10.5803F, 9, 9, 8, 0.25F);
        this.head.addChild(cube_r6);

        // TORSO
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 4.0F, 1.0F);

        ModelRenderer cube_r7 = new ModelRenderer(this, 0, 0);
        cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r7.rotateAngleX = 0.3491F;
        cube_r7.addBox(-6.0F, -13.9403F, -5.0F, 12, 14, 9, 0.0F);
        this.torso.addChild(cube_r7);

        ModelRenderer cube_r8 = new ModelRenderer(this, 0, 83);
        cube_r8.setRotationPoint(-4.0F, -15.2903F, -10.903F);
        cube_r8.rotateAngleX = 0.3491F;
        cube_r8.addBox(0.5F, -0.1856F, 1.1898F, 7, 6, 7, -0.75F);
        this.torso.addChild(cube_r8);

        // metalrods (child of torso)
        this.metalrods = new ModelRenderer(this, 35, 27);
        this.metalrods.setRotationPoint(0.0F, -10.0F, -14.0F);
        this.metalrods.addBox(4.0F, 1.25F, -5.0F, 1, 1, 23, 0.0F); // 0.5w→1
        this.torso.addChild(this.metalrods);

        ModelRenderer cube_r9 = new ModelRenderer(this, 32, 24);
        cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r9.rotateAngleX = -0.0173F;
        cube_r9.rotateAngleY = 0.192F;
        cube_r9.rotateAngleZ = -0.1791F;
        cube_r9.addBox(-4.5F, -1.0F, -7.0F, 1, 1, 26, 0.0F); // 0.5w→1
        this.metalrods.addChild(cube_r9);

        ModelRenderer cube_r10 = new ModelRenderer(this, 73, 0);
        cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r10.rotateAngleX = -0.176F;
        cube_r10.rotateAngleY = 0.1289F;
        cube_r10.rotateAngleZ = -0.0229F;
        cube_r10.addBox(-5.5F, -1.0F, -4.0F, 1, 1, 9, 0.0F); // 0.5w→1
        this.metalrods.addChild(cube_r10);

        ModelRenderer cube_r11 = new ModelRenderer(this, 61, 43);
        cube_r11.setRotationPoint(1.25F, 7.0F, 3.25F);
        cube_r11.rotateAngleX = -0.3054F;
        cube_r11.addBox(-4.5F, -3.7F, -7.0F, 1, 1, 11, 0.0F); // 0.5w,0.7h→1,1
        this.metalrods.addChild(cube_r11);

        // LEFT ARM
        this.left_arm = new ModelRenderer(this, 0, 0);
        this.left_arm.setRotationPoint(6.0F, -7.0F, -3.0F);

        ModelRenderer cube_r12 = new ModelRenderer(this, 32, 67);
        cube_r12.setRotationPoint(2.0F, 11.75F, -5.75F);
        cube_r12.rotateAngleX = 1.5371F;
        cube_r12.rotateAngleY = 0.1248F;
        cube_r12.rotateAngleZ = 0.2446F;
        cube_r12.addBox(0.0F, 6.0F, -2.75F, 4, 3, 8, 0.0F);
        this.left_arm.addChild(cube_r12);

        ModelRenderer cube_r13 = new ModelRenderer(this, 31, 11);
        cube_r13.setRotationPoint(-0.5F, 3.0F, -2.0F);
        cube_r13.rotateAngleX = 1.7975F;
        cube_r13.rotateAngleY = 0.4542F;
        cube_r13.rotateAngleZ = -0.4509F;
        cube_r13.addBox(0.0F, 1.0F, -9.0F, 4, 4, 11, 0.0F);
        this.left_arm.addChild(cube_r13);

        // RIGHT ARM
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.setRotationPoint(-6.0F, -7.0F, -3.0F);

        ModelRenderer cube_r14 = new ModelRenderer(this, 70, 20);
        cube_r14.setRotationPoint(-1.825F, 11.0F, -6.0F);
        cube_r14.rotateAngleX = 1.0898F;
        cube_r14.rotateAngleY = -0.3133F;
        cube_r14.rotateAngleZ = -0.0098F;
        cube_r14.addBox(-4.7F, -1.0F, -2.723F, 4, 3, 8, 0.0F);
        this.right_arm.addChild(cube_r14);

        ModelRenderer cube_r15 = new ModelRenderer(this, 0, 38);
        cube_r15.setRotationPoint(0.0F, 2.0F, -1.0F);
        cube_r15.rotateAngleX = 1.0036F;
        cube_r15.rotateAngleZ = 0.5236F;
        cube_r15.addBox(-4.0F, -1.0F, -9.0F, 4, 4, 11, 0.0F);
        this.right_arm.addChild(cube_r15);

        // LEFT LEG
        this.left_leg = new ModelRenderer(this, 17, 38);
        this.left_leg.setRotationPoint(3.0F, 4.0F, 0.0F);
        this.left_leg.addBox(-2.075F, 14.0F, -4.0F, 4, 6, 3, 0.25F);

        ModelRenderer cube_r16 = new ModelRenderer(this, 74, 55);
        cube_r16.setRotationPoint(4.0F, 7.0F, -1.0F);
        cube_r16.rotateAngleX = -0.1749F;
        cube_r16.rotateAngleY = -0.0058F;
        cube_r16.rotateAngleZ = 0.0013F;
        cube_r16.addBox(-6.1F, -8.6F, -2.1F, 4, 16, 4, 0.5F);
        this.left_leg.addChild(cube_r16);

        // RIGHT LEG
        this.right_leg = new ModelRenderer(this, 0, 0);
        this.right_leg.setRotationPoint(-3.0F, 3.0F, 0.0F);

        ModelRenderer cube_r17 = new ModelRenderer(this, 0, 28);
        cube_r17.setRotationPoint(3.5F, 20.675F, -1.0F);
        cube_r17.rotateAngleZ = -0.0436F;
        cube_r17.addBox(-6.5F, -7.0F, -2.0F, 4, 7, 3, 0.25F);
        this.right_leg.addChild(cube_r17);

        ModelRenderer cube_r18 = new ModelRenderer(this, 29, 78);
        cube_r18.setRotationPoint(2.225F, 9.0F, -0.5F);
        cube_r18.rotateAngleX = -0.1279F;
        cube_r18.rotateAngleY = 0.0093F;
        cube_r18.rotateAngleZ = 0.0902F;
        cube_r18.addBox(-5.0F, -10.5554F, -2.3915F, 4, 16, 4, 0.5F);
        this.right_leg.addChild(cube_r18);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.head.render(scale);
        this.torso.render(scale);
        this.left_arm.render(scale);
        this.right_arm.render(scale);
        this.left_leg.render(scale);
        this.right_leg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
        this.head.rotateAngleX = headPitch / (180F / (float) Math.PI);
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI) * limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * limbSwingAmount;
    }
}