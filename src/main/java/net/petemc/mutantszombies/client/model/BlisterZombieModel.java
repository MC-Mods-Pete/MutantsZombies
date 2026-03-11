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

        this.head = new ModelRenderer(this);
        this.head.setRotationPoint(0.0F, -6.0F, -9.0F);

        ModelRenderer cube_r1 = new ModelRenderer(this, 42, 0);
        cube_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.head.addChild(cube_r1);
        cube_r1.addBox(-3.0F, 0.0F, -8.0F, 6, 2, 8, 0.0F);

        ModelRenderer cube_r2 = new ModelRenderer(this, 0, 22);
        cube_r2.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.head.addChild(cube_r2);
        setRotateAngle(cube_r2, -0.2618F, 0.0F, 0.0F);
        cube_r2.addBox(-5.0F, -6.0F, -8.0F, 10, 8, 8, 0.0F);

        ModelRenderer faceplates = new ModelRenderer(this);
        faceplates.setRotationPoint(0.0F, -1.0F, -6.0F);
        this.head.addChild(faceplates);

        ModelRenderer cube_r3 = new ModelRenderer(this, 33, 0);
        faceplates.addChild(cube_r3);
        setRotateAngle(cube_r3, -0.2057F, 0.3023F, 0.0186F);
        cube_r3.addBox(0.5F, -1.0F, -5.0F, 1, 4, 4, 0.0F);

        ModelRenderer cube_r4 = new ModelRenderer(this, 63, 2);
        faceplates.addChild(cube_r4);
        setRotateAngle(cube_r4, -1.4983F, 0.7777F, -0.5184F);
        cube_r4.addBox(0.5F, -2.0F, -7.0F, 1, 10, 8, 0.0F);

        ModelRenderer cube_r5 = new ModelRenderer(this, 74, 36);
        faceplates.addChild(cube_r5);
        setRotateAngle(cube_r5, -1.6285F, 0.686F, -1.2187F);
        cube_r5.addBox(0.0F, 0.0F, -7.0F, 1, 8, 7, 0.0F);

        ModelRenderer cube_r6 = new ModelRenderer(this, 65, 80);
        faceplates.addChild(cube_r6);
        setRotateAngle(cube_r6, -0.7475F, 0.5719F, -0.2274F);
        cube_r6.addBox(0.0F, -2.0F, -7.0F, 1, 6, 6, 0.0F);

        ModelRenderer cube_r7 = new ModelRenderer(this, 79, 81);
        faceplates.addChild(cube_r7);
        setRotateAngle(cube_r7, -0.1589F, -0.2725F, 0.2135F);
        cube_r7.addBox(0.5F, -2.0F, -7.0F, 1, 5, 6, 0.0F);

        ModelRenderer cube_r8 = new ModelRenderer(this, 60, 27);
        faceplates.addChild(cube_r8);
        setRotateAngle(cube_r8, -0.1622F, -0.5334F, -0.1392F);
        cube_r8.addBox(0.0F, -4.0F, -10.0F, 1, 7, 9, 0.0F);

        ModelRenderer cube_r9 = new ModelRenderer(this, 21, 50);
        faceplates.addChild(cube_r9);
        setRotateAngle(cube_r9, -0.2618F, -1.0036F, 0.0F);
        cube_r9.addBox(0.0F, -5.0F, -10.0F, 1, 8, 9, 0.0F);

        ModelRenderer sidegrips = new ModelRenderer(this, 0, 72);
        sidegrips.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.head.addChild(sidegrips);
        sidegrips.addBox(5.0F, -1.0F, -5.0F, 1, 1, 10, 0.0F);

        ModelRenderer cube_r10 = new ModelRenderer(this, 46, 38);
        sidegrips.addChild(cube_r10);
        setRotateAngle(cube_r10, -0.0173F, 0.192F, -0.1791F);
        cube_r10.addBox(-5.5F, -1.0F, -9.0F, 1, 1, 12, 0.0F);

        ModelRenderer cube_r11 = new ModelRenderer(this, 73, 0);
        sidegrips.addChild(cube_r11);
        setRotateAngle(cube_r11, -0.176F, 0.1289F, -0.0229F);
        cube_r11.addBox(-5.5F, -1.0F, -6.0F, 1, 1, 9, 0.0F);

        ModelRenderer cube_r12 = new ModelRenderer(this, 61, 43);
        sidegrips.addChild(cube_r12);
        setRotateAngle(cube_r12, -0.3054F, 0.0F, 0.0F);
        cube_r12.addBox(-5.5F, -3.7F, -7.0F, 1, 1, 11, 0.0F);

        ModelRenderer cube_r13 = new ModelRenderer(this, 49, 14);
        sidegrips.addChild(cube_r13);
        setRotateAngle(cube_r13, -0.7591F, -0.192F, 0.1791F);
        cube_r13.addBox(5.0F, -1.0F, -10.0F, 1, 1, 12, 0.0F);

        ModelRenderer cube_r14 = new ModelRenderer(this, 73, 70);
        sidegrips.addChild(cube_r14);
        setRotateAngle(cube_r14, -0.4363F, 0.0F, 0.0F);
        cube_r14.addBox(5.0F, -4.0F, -7.0F, 1, 1, 10, 0.0F);

        this.torso = new ModelRenderer(this);
        this.torso.setRotationPoint(0.0F, 4.0F, 1.0F);

        ModelRenderer cube_r15 = new ModelRenderer(this, 0, 0);
        this.torso.addChild(cube_r15);
        setRotateAngle(cube_r15, 0.7418F, 0.0F, 0.0F);
        cube_r15.addBox(-6.0F, -13.9403F, -4.1423F, 12, 13, 9, 0.0F);

        ModelRenderer cube_r16 = new ModelRenderer(this, 30, 32);
        cube_r16.setRotationPoint(0.0F, 10.0F, -1.0F);
        this.torso.addChild(cube_r16);
        setRotateAngle(cube_r16, -0.0873F, 0.0F, 0.0F);
        cube_r16.addBox(-4.0F, -14.0F, -3.0F, 8, 12, 6, 0.0F);

        ModelRenderer backplates = new ModelRenderer(this);
        backplates.setRotationPoint(0.0F, -7.0F, -1.0F);
        this.torso.addChild(backplates);

        ModelRenderer cube_r17 = new ModelRenderer(this, 52, 58);
        backplates.addChild(cube_r17);
        setRotateAngle(cube_r17, 0.0F, 0.5236F, 0.0F);
        cube_r17.addBox(2.0F, -7.0F, -2.0F, 1, 7, 9, 0.0F);

        ModelRenderer cube_r18 = new ModelRenderer(this, 63, 65);
        backplates.addChild(cube_r18);
        setRotateAngle(cube_r18, 0.1745F, 1.0472F, 0.0F);
        cube_r18.addBox(3.5F, -6.0F, -2.0F, 1, 6, 9, 0.0F);

        ModelRenderer cube_r19 = new ModelRenderer(this, 41, 51);
        backplates.addChild(cube_r19);
        setRotateAngle(cube_r19, -0.3491F, -0.0873F, 0.0F);
        cube_r19.addBox(-1.0F, -4.0F, -2.0F, 1, 7, 9, 0.0F);

        ModelRenderer cube_r20 = new ModelRenderer(this, 0, 57);
        backplates.addChild(cube_r20);
        setRotateAngle(cube_r20, 0.0057F, 0.0433F, 0.131F);
        cube_r20.addBox(-2.5F, -7.0F, -8.0F, 1, 5, 10, 0.0F);

        ModelRenderer cube_r21 = new ModelRenderer(this, 47, 74);
        backplates.addChild(cube_r21);
        setRotateAngle(cube_r21, 0.0F, -0.48F, 0.0F);
        cube_r21.addBox(-3.75F, -3.0F, -2.0F, 1, 5, 8, 0.0F);

        ModelRenderer cube_r22 = new ModelRenderer(this, 13, 67);
        backplates.addChild(cube_r22);
        setRotateAngle(cube_r22, -0.0607F, 0.116F, -0.4835F);
        cube_r22.addBox(2.5F, -1.0F, -2.0F, 1, 6, 9, 0.0F);

        this.left_arm = new ModelRenderer(this);
        this.left_arm.setRotationPoint(6.0F, -4.0F, -6.0F);

        ModelRenderer cube_r23 = new ModelRenderer(this, 33, 67);
        cube_r23.setRotationPoint(2.0F, 8.0F, -5.0F);
        this.left_arm.addChild(cube_r23);
        setRotateAngle(cube_r23, 1.5007F, 0.1367F, 0.6339F);
        cube_r23.addBox(1.0F, 3.8813F, -4.723F, 3, 3, 8, 0.0F);

        ModelRenderer cube_r24 = new ModelRenderer(this, 31, 11);
        cube_r24.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.left_arm.addChild(cube_r24);
        setRotateAngle(cube_r24, 1.5901F, 0.3093F, -0.4295F);
        cube_r24.addBox(0.0F, -2.0F, -11.0F, 4, 4, 11, 0.0F);

        this.right_arm = new ModelRenderer(this);
        this.right_arm.setRotationPoint(-6.0F, -4.0F, -5.0F);

        ModelRenderer cube_r25 = new ModelRenderer(this, 71, 20);
        cube_r25.setRotationPoint(-2.0F, 8.0F, -4.0F);
        this.right_arm.addChild(cube_r25);
        setRotateAngle(cube_r25, 1.0898F, -0.3133F, -0.0098F);
        cube_r25.addBox(-5.0F, -1.6187F, -4.723F, 3, 3, 8, 0.0F);

        ModelRenderer cube_r26 = new ModelRenderer(this, 0, 38);
        cube_r26.setRotationPoint(0.0F, -1.0F, 1.0F);
        this.right_arm.addChild(cube_r26);
        setRotateAngle(cube_r26, 1.0036F, 0.0F, 0.5236F);
        cube_r26.addBox(-4.0F, -2.0F, -11.0F, 4, 4, 11, 0.0F);

        this.left_leg = new ModelRenderer(this, 19, 38);
        this.left_leg.setRotationPoint(2.0F, 12.0F, 1.0F);
        this.left_leg.addBox(0.0F, 6.0F, -8.0F, 2, 6, 3, 0.0F);

        ModelRenderer cube_r27 = new ModelRenderer(this, 74, 55);
        cube_r27.setRotationPoint(5.0F, -1.0F, 0.0F);
        this.left_leg.addChild(cube_r27);
        setRotateAngle(cube_r27, -0.7418F, 0.0F, 0.0F);
        cube_r27.addBox(-6.0F, 0.3983F, -2.0908F, 4, 10, 4, 0.0F);

        this.right_leg = new ModelRenderer(this);
        this.right_leg.setRotationPoint(-3.0F, 12.0F, 1.0F);

        ModelRenderer cube_r28 = new ModelRenderer(this, 0, 38);
        cube_r28.setRotationPoint(3.0F, 12.0F, 0.0F);
        this.right_leg.addChild(cube_r28);
        setRotateAngle(cube_r28, 0.1745F, 0.0F, 0.0F);
        cube_r28.addBox(-6.0F, -7.0F, -2.0F, 2, 7, 3, 0.0F);

        ModelRenderer cube_r29 = new ModelRenderer(this, 29, 78);
        cube_r29.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.right_leg.addChild(cube_r29);
        setRotateAngle(cube_r29, -0.2612F, 0.2699F, 0.1488F);
        cube_r29.addBox(-5.0F, -0.5554F, -2.3915F, 4, 8, 4, 0.0F);
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
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing) * -1.0F * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing) * limbSwingAmount;
    }

    private static void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
