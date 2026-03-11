package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class BlisterZombieModel extends ModelBase {
    public final ModelRenderer head;
    public final ModelRenderer torso;
    public final ModelRenderer left_arm;
    public final ModelRenderer right_arm;
    public final ModelRenderer left_leg;
    public final ModelRenderer right_leg;

    public BlisterZombieModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        // HEAD
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -6.0F, -9.0F);

        ModelRenderer cube_r1 = new ModelRenderer(this, 42, 0);
        cube_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
        cube_r1.addBox(-3.0F, 0.0F, -8.0F, 6, 2, 8, 0.0F);
        this.head.addChild(cube_r1);

        ModelRenderer cube_r2 = new ModelRenderer(this, 0, 22);
        cube_r2.setRotationPoint(0.0F, 2.0F, 0.0F);
        cube_r2.rotateAngleX = -0.2618F;
        cube_r2.addBox(-5.0F, -6.0F, -8.0F, 10, 8, 8, 0.0F);
        this.head.addChild(cube_r2);

        // faceplates (child of head)
        ModelRenderer faceplates = new ModelRenderer(this, 0, 0);
        faceplates.setRotationPoint(0.0F, -1.0F, -6.0F);
        this.head.addChild(faceplates);

        ModelRenderer cube_r3 = new ModelRenderer(this, 33, 0);
        cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r3.rotateAngleX = -0.2057F;
        cube_r3.rotateAngleY = 0.3023F;
        cube_r3.rotateAngleZ = 0.0186F;
        cube_r3.addBox(0.5F, -1.0F, -5.0F, 1, 4, 4, 0.0F);
        faceplates.addChild(cube_r3);

        ModelRenderer cube_r4 = new ModelRenderer(this, 63, 2);
        cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r4.rotateAngleX = -1.4983F;
        cube_r4.rotateAngleY = 0.7777F;
        cube_r4.rotateAngleZ = -0.5184F;
        cube_r4.addBox(0.5F, -2.0F, -7.0F, 1, 10, 8, 0.0F);
        faceplates.addChild(cube_r4);

        ModelRenderer cube_r5 = new ModelRenderer(this, 74, 36);
        cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r5.rotateAngleX = -1.6285F;
        cube_r5.rotateAngleY = 0.686F;
        cube_r5.rotateAngleZ = -1.2187F;
        cube_r5.addBox(0.0F, 0.0F, -7.0F, 1, 8, 7, 0.0F);
        faceplates.addChild(cube_r5);

        ModelRenderer cube_r6 = new ModelRenderer(this, 65, 80);
        cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r6.rotateAngleX = -0.7475F;
        cube_r6.rotateAngleY = 0.5719F;
        cube_r6.rotateAngleZ = -0.2274F;
        cube_r6.addBox(0.0F, -2.0F, -7.0F, 1, 6, 6, 0.0F);
        faceplates.addChild(cube_r6);

        ModelRenderer cube_r7 = new ModelRenderer(this, 79, 81);
        cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r7.rotateAngleX = -0.1589F;
        cube_r7.rotateAngleY = -0.2725F;
        cube_r7.rotateAngleZ = 0.2135F;
        cube_r7.addBox(0.5F, -2.0F, -7.0F, 1, 5, 6, 0.0F);
        faceplates.addChild(cube_r7);

        ModelRenderer cube_r8 = new ModelRenderer(this, 60, 27);
        cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r8.rotateAngleX = -0.1622F;
        cube_r8.rotateAngleY = -0.5334F;
        cube_r8.rotateAngleZ = -0.1392F;
        cube_r8.addBox(0.0F, -4.0F, -10.0F, 1, 7, 9, 0.0F);
        faceplates.addChild(cube_r8);

        ModelRenderer cube_r9 = new ModelRenderer(this, 21, 50);
        cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r9.rotateAngleX = -0.2618F;
        cube_r9.rotateAngleY = -1.0036F;
        cube_r9.addBox(0.0F, -5.0F, -10.0F, 1, 8, 9, 0.0F);
        faceplates.addChild(cube_r9);

        // sidegrips (child of head)
        ModelRenderer sidegrips = new ModelRenderer(this, 0, 72);
        sidegrips.setRotationPoint(0.0F, 0.0F, -4.0F);
        sidegrips.addBox(5.0F, -1.0F, -5.0F, 1, 1, 10, 0.0F);
        this.head.addChild(sidegrips);

        ModelRenderer cube_r10 = new ModelRenderer(this, 46, 38);
        cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r10.rotateAngleX = -0.0173F;
        cube_r10.rotateAngleY = 0.192F;
        cube_r10.rotateAngleZ = -0.1791F;
        cube_r10.addBox(-5.5F, -1.0F, -9.0F, 1, 1, 12, 0.0F);
        sidegrips.addChild(cube_r10);

        ModelRenderer cube_r11 = new ModelRenderer(this, 73, 0);
        cube_r11.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r11.rotateAngleX = -0.176F;
        cube_r11.rotateAngleY = 0.1289F;
        cube_r11.rotateAngleZ = -0.0229F;
        cube_r11.addBox(-5.5F, -1.0F, -6.0F, 1, 1, 9, 0.0F);
        sidegrips.addChild(cube_r11);

        ModelRenderer cube_r12 = new ModelRenderer(this, 61, 43);
        cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r12.rotateAngleX = -0.3054F;
        cube_r12.addBox(-5.5F, -3.7F, -7.0F, 1, 1, 11, 0.0F);
        sidegrips.addChild(cube_r12);

        ModelRenderer cube_r13 = new ModelRenderer(this, 49, 14);
        cube_r13.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r13.rotateAngleX = -0.7591F;
        cube_r13.rotateAngleY = -0.192F;
        cube_r13.rotateAngleZ = 0.1791F;
        cube_r13.addBox(5.0F, -1.0F, -10.0F, 1, 1, 12, 0.0F);
        sidegrips.addChild(cube_r13);

        ModelRenderer cube_r14 = new ModelRenderer(this, 73, 70);
        cube_r14.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r14.rotateAngleX = -0.4363F;
        cube_r14.addBox(5.0F, -4.0F, -7.0F, 1, 1, 10, 0.0F);
        sidegrips.addChild(cube_r14);

        // TORSO
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 4.0F, 1.0F);

        ModelRenderer cube_r15 = new ModelRenderer(this, 0, 0);
        cube_r15.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r15.rotateAngleX = 0.7418F;
        cube_r15.addBox(-6.0F, -13.9403F, -4.1423F, 12, 13, 9, 0.0F);
        this.torso.addChild(cube_r15);

        ModelRenderer cube_r16 = new ModelRenderer(this, 30, 32);
        cube_r16.setRotationPoint(0.0F, 10.0F, -1.0F);
        cube_r16.rotateAngleX = -0.0873F;
        cube_r16.addBox(-4.0F, -14.0F, -3.0F, 8, 12, 6, 0.0F);
        this.torso.addChild(cube_r16);

        // backplates (child of torso)
        ModelRenderer backplates = new ModelRenderer(this, 0, 0);
        backplates.setRotationPoint(0.0F, -7.0F, -1.0F);
        this.torso.addChild(backplates);

        ModelRenderer cube_r17 = new ModelRenderer(this, 52, 58);
        cube_r17.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r17.rotateAngleY = 0.5236F;
        cube_r17.addBox(2.0F, -7.0F, -2.0F, 1, 7, 9, 0.0F);
        backplates.addChild(cube_r17);

        ModelRenderer cube_r18 = new ModelRenderer(this, 63, 65);
        cube_r18.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r18.rotateAngleX = 0.1745F;
        cube_r18.rotateAngleY = 1.0472F;
        cube_r18.addBox(3.5F, -6.0F, -2.0F, 1, 6, 9, 0.0F);
        backplates.addChild(cube_r18);

        ModelRenderer cube_r19 = new ModelRenderer(this, 41, 51);
        cube_r19.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r19.rotateAngleX = -0.3491F;
        cube_r19.rotateAngleY = -0.0873F;
        cube_r19.addBox(-1.0F, -4.0F, -2.0F, 1, 7, 9, 0.0F);
        backplates.addChild(cube_r19);

        ModelRenderer cube_r20 = new ModelRenderer(this, 0, 57);
        cube_r20.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r20.rotateAngleX = 0.0057F;
        cube_r20.rotateAngleY = 0.0433F;
        cube_r20.rotateAngleZ = 0.131F;
        cube_r20.addBox(-2.5F, -7.0F, -8.0F, 1, 5, 10, 0.0F);
        backplates.addChild(cube_r20);

        ModelRenderer cube_r21 = new ModelRenderer(this, 47, 74);
        cube_r21.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r21.rotateAngleY = -0.48F;
        cube_r21.addBox(-3.75F, -3.0F, -2.0F, 1, 5, 8, 0.0F);
        backplates.addChild(cube_r21);

        ModelRenderer cube_r22 = new ModelRenderer(this, 13, 67);
        cube_r22.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r22.rotateAngleX = -0.0607F;
        cube_r22.rotateAngleY = 0.116F;
        cube_r22.rotateAngleZ = -0.4835F;
        cube_r22.addBox(2.5F, -1.0F, -2.0F, 1, 6, 9, 0.0F);
        backplates.addChild(cube_r22);

        // LEFT ARM
        this.left_arm = new ModelRenderer(this, 0, 0);
        this.left_arm.setRotationPoint(6.0F, -4.0F, -6.0F);

        ModelRenderer cube_r23 = new ModelRenderer(this, 33, 67);
        cube_r23.setRotationPoint(2.0F, 8.0F, -5.0F);
        cube_r23.rotateAngleX = 1.5007F;
        cube_r23.rotateAngleY = 0.1367F;
        cube_r23.rotateAngleZ = 0.6339F;
        cube_r23.addBox(1.0F, 3.8813F, -4.723F, 3, 3, 8, 0.0F);
        this.left_arm.addChild(cube_r23);

        ModelRenderer cube_r24 = new ModelRenderer(this, 31, 11);
        cube_r24.setRotationPoint(0.0F, -1.0F, 0.0F);
        cube_r24.rotateAngleX = 1.5901F;
        cube_r24.rotateAngleY = 0.3093F;
        cube_r24.rotateAngleZ = -0.4295F;
        cube_r24.addBox(0.0F, -2.0F, -11.0F, 4, 4, 11, 0.0F);
        this.left_arm.addChild(cube_r24);

        // RIGHT ARM
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.setRotationPoint(-6.0F, -4.0F, -5.0F);

        ModelRenderer cube_r25 = new ModelRenderer(this, 71, 20);
        cube_r25.setRotationPoint(-2.0F, 8.0F, -4.0F);
        cube_r25.rotateAngleX = 1.0898F;
        cube_r25.rotateAngleY = -0.3133F;
        cube_r25.rotateAngleZ = -0.0098F;
        cube_r25.addBox(-5.0F, -1.6187F, -4.723F, 3, 3, 8, 0.0F);
        this.right_arm.addChild(cube_r25);

        ModelRenderer cube_r26 = new ModelRenderer(this, 0, 38);
        cube_r26.setRotationPoint(0.0F, -1.0F, 1.0F);
        cube_r26.rotateAngleX = 1.0036F;
        cube_r26.rotateAngleZ = 0.5236F;
        cube_r26.addBox(-4.0F, -2.0F, -11.0F, 4, 4, 11, 0.0F);
        this.right_arm.addChild(cube_r26);

        // LEFT LEG
        this.left_leg = new ModelRenderer(this, 19, 38);
        this.left_leg.setRotationPoint(2.0F, 12.0F, 1.0F);
        this.left_leg.addBox(0.0F, 6.0F, -8.0F, 2, 6, 3, 0.0F);

        ModelRenderer cube_r27 = new ModelRenderer(this, 74, 55);
        cube_r27.setRotationPoint(5.0F, -1.0F, 0.0F);
        cube_r27.rotateAngleX = -0.7418F;
        cube_r27.addBox(-6.0F, 0.3983F, -2.0908F, 4, 10, 4, 0.0F);
        this.left_leg.addChild(cube_r27);

        // RIGHT LEG
        this.right_leg = new ModelRenderer(this, 0, 0);
        this.right_leg.setRotationPoint(-3.0F, 12.0F, 1.0F);

        ModelRenderer cube_r28 = new ModelRenderer(this, 0, 38);
        cube_r28.setRotationPoint(3.0F, 12.0F, 0.0F);
        cube_r28.rotateAngleX = 0.1745F;
        cube_r28.addBox(-6.0F, -7.0F, -2.0F, 2, 7, 3, 0.0F);
        this.right_leg.addChild(cube_r28);

        ModelRenderer cube_r29 = new ModelRenderer(this, 29, 78);
        cube_r29.setRotationPoint(3.0F, 0.0F, 0.0F);
        cube_r29.rotateAngleX = -0.2612F;
        cube_r29.rotateAngleY = 0.2699F;
        cube_r29.rotateAngleZ = 0.1488F;
        cube_r29.addBox(-5.0F, -0.5554F, -2.3915F, 4, 8, 4, 0.0F);
        this.right_leg.addChild(cube_r29);
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
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}
