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

        // HEAD2
        this.head2 = new ModelRenderer(this, 0, 0);
        this.head2.setRotationPoint(-13.0F, 7.0F, -8.0F);

        ModelRenderer cube_r1 = new ModelRenderer(this, 32, 109);
        cube_r1.setRotationPoint(13.0F, 18.0F, 10.0F);
        cube_r1.rotateAngleX = 2.9626F;
        cube_r1.rotateAngleY = -0.6423F;
        cube_r1.rotateAngleZ = 2.937F;
        cube_r1.addBox(-4.3511F, -22.6056F, 7.8459F, 8, 2, 8, 0.0F);
        this.head2.addChild(cube_r1);

        ModelRenderer cube_r2 = new ModelRenderer(this, 96, 95);
        cube_r2.setRotationPoint(13.0F, 18.0F, 10.0F);
        cube_r2.rotateAngleX = -2.6477F;
        cube_r2.rotateAngleY = -0.4703F;
        cube_r2.rotateAngleZ = 2.9023F;
        cube_r2.addBox(-1.8795F, -16.2629F, 19.5477F, 8, 6, 8, 0.0F);
        this.head2.addChild(cube_r2);

        // HEAD3
        this.head3 = new ModelRenderer(this, 0, 0);
        this.head3.setRotationPoint(-1.0F, 3.0F, -10.0F);

        ModelRenderer cube_r3 = new ModelRenderer(this, 109, 6);
        cube_r3.setRotationPoint(1.0F, 22.0F, 12.0F);
        cube_r3.rotateAngleX = 3.009F;
        cube_r3.rotateAngleY = 0.1129F;
        cube_r3.rotateAngleZ = -3.1296F;
        cube_r3.addBox(-1.9556F, -24.2196F, 5.3173F, 8, 2, 8, 0.0F);
        this.head3.addChild(cube_r3);

        ModelRenderer cube_r4 = new ModelRenderer(this, 32, 95);
        cube_r4.setRotationPoint(1.0F, 22.0F, 12.0F);
        cube_r4.rotateAngleX = -2.702F;
        cube_r4.rotateAngleY = 0.1186F;
        cube_r4.rotateAngleZ = -3.086F;
        cube_r4.addBox(-0.943F, -20.2629F, 17.5242F, 8, 6, 8, 0.0F);
        this.head3.addChild(cube_r4);

        // HEAD4
        this.head4 = new ModelRenderer(this, 0, 0);
        this.head4.setRotationPoint(0.0F, -6.0F, 4.0F);

        ModelRenderer cube_r5 = new ModelRenderer(this, 84, 81);
        cube_r5.setRotationPoint(0.0F, 31.0F, -2.0F);
        cube_r5.rotateAngleX = -2.5744F;
        cube_r5.rotateAngleZ = 3.1416F;
        cube_r5.addBox(-4.0F, -36.0006F, 11.6916F, 8, 6, 8, 0.0F);
        this.head4.addChild(cube_r5);

        ModelRenderer cube_r6 = new ModelRenderer(this, 0, 109);
        cube_r6.setRotationPoint(0.0F, 31.0F, -2.0F);
        cube_r6.rotateAngleX = -2.7053F;
        cube_r6.rotateAngleZ = 3.1416F;
        cube_r6.addBox(-4.0F, -31.2629F, 7.759F, 8, 2, 8, 0.0F);
        this.head4.addChild(cube_r6);

        // HEAD5
        this.head5 = new ModelRenderer(this, 0, 0);
        this.head5.setRotationPoint(12.0F, 10.0F, -6.0F);

        ModelRenderer cube_r7 = new ModelRenderer(this, 104, 64);
        cube_r7.setRotationPoint(-12.0F, 15.0F, 8.0F);
        cube_r7.rotateAngleX = 2.7981F;
        cube_r7.rotateAngleY = 1.0556F;
        cube_r7.rotateAngleZ = 2.8826F;
        cube_r7.addBox(-4.4237F, -17.0446F, 9.0093F, 8, 2, 8, 0.0F);
        this.head5.addChild(cube_r7);

        ModelRenderer cube_r8 = new ModelRenderer(this, 64, 95);
        cube_r8.setRotationPoint(-12.0F, 15.0F, 8.0F);
        cube_r8.rotateAngleX = 2.8854F;
        cube_r8.rotateAngleY = 1.0556F;
        cube_r8.rotateAngleZ = 2.8826F;
        cube_r8.addBox(-4.4237F, -22.1988F, 11.24F, 8, 6, 8, 0.0F);
        this.head5.addChild(cube_r8);

        // HEAD6 (baked rotX from PartPose)
        this.head6 = new ModelRenderer(this, 0, 0);
        this.head6.setRotationPoint(12.0F, 5.0F, 10.0F);
        this.head6.rotateAngleX = -0.0436F;

        ModelRenderer cube_r9 = new ModelRenderer(this, 0, 95);
        cube_r9.setRotationPoint(-12.0F, 20.8288F, -11.9819F);
        cube_r9.rotateAngleX = 2.6202F;
        cube_r9.rotateAngleY = 0.9349F;
        cube_r9.rotateAngleZ = 2.792F;
        cube_r9.addBox(-24.9861F, -23.7525F, -6.1784F, 8, 6, 8, 0.0F);
        this.head6.addChild(cube_r9);

        ModelRenderer cube_r10 = new ModelRenderer(this, 104, 23);
        cube_r10.setRotationPoint(-12.0F, 20.8288F, -11.9819F);
        cube_r10.rotateAngleX = 2.6734F;
        cube_r10.rotateAngleY = 0.9556F;
        cube_r10.rotateAngleZ = 2.8576F;
        cube_r10.addBox(-23.5859F, -17.906F, -6.1784F, 8, 2, 8, 0.0F);
        this.head6.addChild(cube_r10);

        // HEAD7
        this.head7 = new ModelRenderer(this, 0, 0);
        this.head7.setRotationPoint(-10.0F, -4.0F, 11.0F);

        ModelRenderer cube_r11 = new ModelRenderer(this, 0, 15);
        cube_r11.setRotationPoint(10.0F, 29.0F, -9.0F);
        cube_r11.rotateAngleX = -2.0567F;
        cube_r11.rotateAngleY = 0.2751F;
        cube_r11.rotateAngleZ = 2.4914F;
        cube_r11.addBox(-14.6813F, -21.8139F, 19.5135F, 8, 7, 2, 0.0F);
        this.head7.addChild(cube_r11);

        ModelRenderer cube_r12 = new ModelRenderer(this, 108, 75);
        cube_r12.setRotationPoint(10.0F, 29.0F, -9.0F);
        cube_r12.rotateAngleX = -2.3622F;
        cube_r12.rotateAngleY = 0.2751F;
        cube_r12.rotateAngleZ = 2.4914F;
        cube_r12.addBox(-14.6813F, -28.7175F, 14.6915F, 8, 8, 6, 0.0F);
        this.head7.addChild(cube_r12);

        // HEAD8
        this.head8 = new ModelRenderer(this, 0, 0);
        this.head8.setRotationPoint(-8.0F, 11.0F, 8.0F);

        ModelRenderer cube_r13 = new ModelRenderer(this, 101, 54);
        cube_r13.setRotationPoint(8.0F, 14.0F, -6.0F);
        cube_r13.rotateAngleX = -0.9395F;
        cube_r13.rotateAngleY = 1.1447F;
        cube_r13.rotateAngleZ = -1.2238F;
        cube_r13.addBox(-8.9696F, -17.4786F, -6.9687F, 8, 2, 8, 0.0F);
        this.head8.addChild(cube_r13);

        ModelRenderer cube_r14 = new ModelRenderer(this, 80, 0);
        cube_r14.setRotationPoint(8.0F, 14.0F, -6.0F);
        cube_r14.rotateAngleX = 0.3258F;
        cube_r14.rotateAngleY = 1.3104F;
        cube_r14.rotateAngleZ = 0.0959F;
        cube_r14.addBox(-16.9424F, -19.5751F, -6.9687F, 8, 6, 8, 0.0F);
        this.head8.addChild(cube_r14);

        // TORSO
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 5.0F, 0.0F);

        ModelRenderer cube_r15 = new ModelRenderer(this, 0, 40);
        cube_r15.setRotationPoint(0.0F, 20.0F, 2.0F);
        cube_r15.rotateAngleX = 3.1067F;
        cube_r15.rotateAngleZ = 3.1416F;
        cube_r15.addBox(-13.0F, -13.0637F, -10.3502F, 26, 5, 23, 0.0F);
        this.torso.addChild(cube_r15);

        ModelRenderer cube_r16 = new ModelRenderer(this, 0, 0);
        cube_r16.setRotationPoint(0.0F, 20.0F, 2.0F);
        cube_r16.rotateAngleX = -3.0543F;
        cube_r16.rotateAngleZ = 3.1416F;
        cube_r16.addBox(-14.0F, -25.9429F, -8.6927F, 28, 16, 24, 0.0F);
        this.torso.addChild(cube_r16);

        ModelRenderer cube_r17 = new ModelRenderer(this, 0, 68);
        cube_r17.setRotationPoint(0.0F, 20.0F, 2.0F);
        cube_r17.rotateAngleX = -2.9234F;
        cube_r17.rotateAngleZ = 3.1416F;
        cube_r17.addBox(-11.0F, -31.9982F, -3.8529F, 23, 8, 19, 0.0F);
        this.torso.addChild(cube_r17);

        // RIGHT ARM (baked rotX, rotY from PartPose)
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.setRotationPoint(-13.0F, -5.0F, 5.0F);
        this.right_arm.rotateAngleX = 0.1309F;
        this.right_arm.rotateAngleY = -0.2182F;

        ModelRenderer cube_r18 = new ModelRenderer(this, 75, 40);
        cube_r18.setRotationPoint(10.916F, 28.4299F, -11.9257F);
        cube_r18.rotateAngleX = -2.9136F;
        cube_r18.rotateAngleY = 0.1298F;
        cube_r18.rotateAngleZ = 2.6329F;
        cube_r18.addBox(-7.376F, -33.7922F, -7.9359F, 16, 6, 7, 0.0F); // 15.8→16
        this.right_arm.addChild(cube_r18);

        ModelRenderer cube_r19 = new ModelRenderer(this, 75, 53);
        cube_r19.setRotationPoint(10.916F, 28.4299F, -11.9257F);
        cube_r19.rotateAngleX = -2.9876F;
        cube_r19.rotateAngleY = 0.4358F;
        cube_r19.rotateAngleZ = 2.1879F;
        cube_r19.addBox(-10.5294F, -32.7949F, -5.3264F, 12, 4, 5, 0.0F); // 11.8→12, 4.9→5
        this.right_arm.addChild(cube_r19);

        // LEFT ARM (baked rotations from PartPose)
        this.left_arm = new ModelRenderer(this, 0, 0);
        this.left_arm.setRotationPoint(11.0F, -4.4F, 7.6F);
        this.left_arm.rotateAngleX = -0.0089F;
        this.left_arm.rotateAngleY = 0.1742F;
        this.left_arm.rotateAngleZ = -0.0498F;

        ModelRenderer cube_r20 = new ModelRenderer(this, 65, 68);
        cube_r20.setRotationPoint(-5.2277F, 29.5507F, -10.7158F);
        cube_r20.rotateAngleX = -2.948F;
        cube_r20.rotateAngleY = -0.0923F;
        cube_r20.rotateAngleZ = -2.7777F;
        cube_r20.addBox(-7.6672F, -32.9383F, -7.8704F, 16, 6, 7, 0.0F); // 15.8→16
        this.left_arm.addChild(cube_r20);

        ModelRenderer cube_r21 = new ModelRenderer(this, 80, 14);
        cube_r21.setRotationPoint(-5.2277F, 29.5507F, -10.7158F);
        cube_r21.rotateAngleX = -3.0035F;
        cube_r21.rotateAngleY = -0.3873F;
        cube_r21.rotateAngleZ = -2.3301F;
        cube_r21.addBox(-1.0144F, -31.6881F, -5.2025F, 12, 4, 5, 0.0F); // 11.8→12, 4.9→5
        this.left_arm.addChild(cube_r21);

        // LEFT LEG
        this.left_leg = new ModelRenderer(this, 0, 0);
        this.left_leg.setRotationPoint(10.0F, 16.0F, 0.0F);

        ModelRenderer cube_r22 = new ModelRenderer(this, 0, 0);
        cube_r22.setRotationPoint(-10.0F, 9.0F, 2.0F);
        cube_r22.rotateAngleX = -3.1416F;
        cube_r22.rotateAngleZ = 3.1416F;
        cube_r22.addBox(-12.0F, -10.0F, -1.0F, 5, 9, 6, 0.0F);
        this.left_leg.addChild(cube_r22);

        // RIGHT LEG
        this.right_leg = new ModelRenderer(this, 0, 0);
        this.right_leg.setRotationPoint(-10.0F, 16.0F, 0.0F);

        ModelRenderer cube_r23 = new ModelRenderer(this, 0, 40);
        cube_r23.setRotationPoint(10.0F, 9.0F, 2.0F);
        cube_r23.rotateAngleX = -3.1416F;
        cube_r23.rotateAngleZ = 3.1416F;
        cube_r23.addBox(7.0F, -10.0F, -1.0F, 5, 9, 6, 0.0F);
        this.right_leg.addChild(cube_r23);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
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
        float yRot = netHeadYaw / (180F / (float) Math.PI);
        float xRot = headPitch / (180F / (float) Math.PI);
        this.head2.rotateAngleY = yRot;
        this.head2.rotateAngleX = xRot;
        this.head3.rotateAngleY = yRot;
        this.head3.rotateAngleX = xRot;
        this.head4.rotateAngleY = yRot;
        this.head4.rotateAngleX = xRot;
        this.head5.rotateAngleY = yRot;
        this.head5.rotateAngleX = xRot;
        this.head6.rotateAngleY = yRot;
        this.head6.rotateAngleX = xRot;
        this.head7.rotateAngleY = yRot;
        this.head7.rotateAngleX = xRot;
        this.head8.rotateAngleY = yRot;
        this.head8.rotateAngleX = xRot;
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * limbSwingAmount;
    }
}
