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

        // HEAD
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 15.0F, -4.0F);

        ModelRenderer bottomjaw_r1 = new ModelRenderer(this, 37, 28);
        bottomjaw_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
        bottomjaw_r1.rotateAngleX = 0.48F;
        bottomjaw_r1.addBox(-3.0F, 0.0F, -5.0F, 6, 1, 5, 0.0F);
        this.head.addChild(bottomjaw_r1);

        ModelRenderer topjaw_r1 = new ModelRenderer(this, 31, 0);
        topjaw_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
        topjaw_r1.rotateAngleX = -0.48F;
        topjaw_r1.addBox(-3.0F, -4.0F, -6.0F, 6, 4, 6, 0.0F);
        this.head.addChild(topjaw_r1);

        // teeth → bottomteeth → cube_r1
        ModelRenderer teeth = new ModelRenderer(this, 0, 0);
        teeth.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.head.addChild(teeth);

        ModelRenderer bottomteeth = new ModelRenderer(this, 0, 0);
        bottomteeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        teeth.addChild(bottomteeth);

        ModelRenderer cube_r1 = new ModelRenderer(this, 0, 0);
        cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r1.rotateAngleX = 0.48F;
        cube_r1.setTextureOffset(3, 12);
        cube_r1.addBox(-1.0F, -1.0F, -5.0F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(11, 12);
        cube_r1.addBox(-3.0F, -1.0F, -5.0F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(4, 4);
        cube_r1.addBox(1.0F, -1.0F, -5.0F, 2, 1, 1, 0.0F);
        bottomteeth.addChild(cube_r1);

        ModelRenderer topteeth = new ModelRenderer(this, 0, 0);
        topteeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        teeth.addChild(topteeth);

        ModelRenderer cube_r2 = new ModelRenderer(this, 0, 0);
        cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r2.rotateAngleX = -0.48F;
        cube_r2.setTextureOffset(8, 11);
        cube_r2.addBox(1.0F, 0.0F, -6.0F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(7, 0);
        cube_r2.addBox(-2.0F, 0.0F, -6.0F, 1, 2, 1, 0.0F);
        topteeth.addChild(cube_r2);

        // rightcheek
        ModelRenderer rightcheek = new ModelRenderer(this, 0, 0);
        rightcheek.setRotationPoint(-3.0F, 3.0F, -4.0F);
        this.head.addChild(rightcheek);

        ModelRenderer cube_r3 = new ModelRenderer(this, 11, 0);
        cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r3.rotateAngleX = -0.3924F;
        cube_r3.rotateAngleY = 0.0167F;
        cube_r3.rotateAngleZ = 0.0403F;
        cube_r3.addBox(0.0F, -4.0053F, -0.5374F, 1, 4, 1, 0.0F);
        rightcheek.addChild(cube_r3);

        ModelRenderer cube_r4 = new ModelRenderer(this, 9, 5);
        cube_r4.setRotationPoint(3.0F, -2.0F, 3.0F);
        cube_r4.rotateAngleX = 0.1308F;
        cube_r4.rotateAngleY = -0.0057F;
        cube_r4.rotateAngleZ = 0.0433F;
        cube_r4.addBox(-3.0F, -4.0F, -4.0F, 1, 6, 1, 0.0F);
        rightcheek.addChild(cube_r4);

        // leftcheek
        ModelRenderer leftcheek = new ModelRenderer(this, 0, 0);
        leftcheek.setRotationPoint(3.0F, 3.0F, -4.0F);
        this.head.addChild(leftcheek);

        ModelRenderer cube_r5 = new ModelRenderer(this, 0, 7);
        cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r5.rotateAngleX = -0.3957F;
        cube_r5.rotateAngleY = 0.1209F;
        cube_r5.rotateAngleZ = -0.0503F;
        cube_r5.addBox(-0.5F, -5.0053F, -0.5374F, 1, 5, 1, 0.0F);
        leftcheek.addChild(cube_r5);

        ModelRenderer cube_r6 = new ModelRenderer(this, 5, 6);
        cube_r6.setRotationPoint(-3.0F, -2.0F, 3.0F);
        cube_r6.rotateAngleX = 0.218F;
        cube_r6.rotateAngleY = 0.0094F;
        cube_r6.rotateAngleZ = -0.0426F;
        cube_r6.addBox(2.5F, -4.5F, -4.0F, 1, 6, 1, 0.0F);
        leftcheek.addChild(cube_r6);

        // tounge
        ModelRenderer tounge = new ModelRenderer(this, 0, 0);
        tounge.setRotationPoint(0.0F, 2.0F, -8.0F);
        this.head.addChild(tounge);

        ModelRenderer cube_r7 = new ModelRenderer(this, 0, 4);
        cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r7.rotateAngleX = 0.6988F;
        cube_r7.rotateAngleY = 0.0859F;
        cube_r7.rotateAngleZ = 0.0152F;
        cube_r7.addBox(-0.4F, 0.0307F, -2.0984F, 1, 1, 2, 0.0F);
        tounge.addChild(cube_r7);

        ModelRenderer cube_r8 = new ModelRenderer(this, 0, 0);
        cube_r8.setRotationPoint(-1.0F, 0.0F, 2.0F);
        cube_r8.rotateAngleX = 0.3917F;
        cube_r8.rotateAngleY = -0.3564F;
        cube_r8.rotateAngleZ = -0.151F;
        cube_r8.addBox(-0.5F, -0.6166F, -2.3061F, 2, 1, 3, 0.0F);
        tounge.addChild(cube_r8);

        ModelRenderer cube_r9 = new ModelRenderer(this, 46, 10);
        cube_r9.setRotationPoint(0.0F, -1.0F, 7.0F);
        cube_r9.rotateAngleX = 0.1772F;
        cube_r9.rotateAngleY = 0.1719F;
        cube_r9.rotateAngleZ = 0.0306F;
        cube_r9.addBox(-1.0F, -0.5F, -5.0F, 2, 1, 6, 0.0F);
        tounge.addChild(cube_r9);

        // TORSO
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 19.0F, 2.0F);

        ModelRenderer cube_r10 = new ModelRenderer(this, 0, 0);
        cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r10.rotateAngleX = -0.1745F;
        cube_r10.setTextureOffset(0, 0);
        cube_r10.addBox(-4.0F, -4.0F, -7.0F, 8, 3, 15, 0.0F);
        cube_r10.setTextureOffset(30, 18);
        cube_r10.addBox(-4.0F, -5.0F, -7.0F, 8, 1, 7, 0.0F);
        this.torso.addChild(cube_r10);

        // LEFT ARM
        this.left_arm = new ModelRenderer(this, 0, 0);
        this.left_arm.setRotationPoint(4.0F, 16.0F, -3.0F);

        ModelRenderer cube_r11 = new ModelRenderer(this, 37, 36);
        cube_r11.setRotationPoint(0.0F, 3.0F, -1.0F);
        cube_r11.rotateAngleX = 0.897F;
        cube_r11.rotateAngleY = 0.3093F;
        cube_r11.rotateAngleZ = 0.4295F;
        cube_r11.addBox(3.0F, -1.0F, -5.0F, 2, 2, 7, 0.0F);
        this.left_arm.addChild(cube_r11);

        ModelRenderer cube_r12 = new ModelRenderer(this, 0, 41);
        cube_r12.setRotationPoint(0.0F, 3.0F, -1.0F);
        cube_r12.rotateAngleX = 0.9964F;
        cube_r12.rotateAngleY = -0.3332F;
        cube_r12.rotateAngleZ = -0.468F;
        cube_r12.addBox(0.0F, -2.0F, -3.0F, 3, 3, 6, 0.0F);
        this.left_arm.addChild(cube_r12);

        // RIGHT ARM
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.setRotationPoint(-4.0F, 16.0F, -3.0F);

        ModelRenderer cube_r13 = new ModelRenderer(this, 11, 43);
        cube_r13.setRotationPoint(0.0F, 3.0F, -1.0F);
        cube_r13.rotateAngleX = 0.897F;
        cube_r13.rotateAngleY = -0.3093F;
        cube_r13.rotateAngleZ = -0.4295F;
        cube_r13.addBox(-5.0F, -1.0F, -5.0F, 2, 2, 7, 0.0F);
        this.right_arm.addChild(cube_r13);

        ModelRenderer cube_r14 = new ModelRenderer(this, 29, 45);
        cube_r14.setRotationPoint(0.0F, 3.0F, -1.0F);
        cube_r14.rotateAngleX = 0.9964F;
        cube_r14.rotateAngleY = 0.3332F;
        cube_r14.rotateAngleZ = 0.468F;
        cube_r14.addBox(-3.0F, -2.0F, -3.0F, 3, 3, 6, 0.0F);
        this.right_arm.addChild(cube_r14);

        // LEFT LEG
        this.left_leg = new ModelRenderer(this, 0, 0);
        this.left_leg.setRotationPoint(4.0F, 17.0F, 10.0F);

        ModelRenderer cube_r15 = new ModelRenderer(this, 15, 20);
        cube_r15.setRotationPoint(-4.0F, 2.0F, -1.0F);
        cube_r15.rotateAngleX = -0.3491F;
        cube_r15.rotateAngleZ = -0.3491F;
        cube_r15.addBox(4.25F, 3.0F, -3.0F, 2, 2, 11, 0.0F);
        this.left_leg.addChild(cube_r15);

        ModelRenderer cube_r16 = new ModelRenderer(this, 22, 33);
        cube_r16.setRotationPoint(0.0F, 1.0F, -1.0F);
        cube_r16.rotateAngleX = -2.4871F;
        cube_r16.rotateAngleZ = -0.3491F;
        cube_r16.addBox(-0.5F, -1.7934F, -2.3912F, 4, 3, 7, 0.0F);
        this.left_leg.addChild(cube_r16);

        // RIGHT LEG
        this.right_leg = new ModelRenderer(this, 0, 0);
        this.right_leg.setRotationPoint(-4.0F, 17.0F, 9.0F);

        ModelRenderer cube_r17 = new ModelRenderer(this, 0, 18);
        cube_r17.setRotationPoint(4.0F, 2.0F, 0.0F);
        cube_r17.rotateAngleX = -0.3491F;
        cube_r17.rotateAngleZ = 0.3491F;
        cube_r17.addBox(-6.25F, 3.0F, -3.0F, 2, 2, 11, 0.0F);
        this.right_leg.addChild(cube_r17);

        ModelRenderer cube_r18 = new ModelRenderer(this, 0, 31);
        cube_r18.setRotationPoint(0.0F, 1.0F, 0.0F);
        cube_r18.rotateAngleX = -2.4871F;
        cube_r18.rotateAngleZ = 0.3491F;
        cube_r18.addBox(-3.0F, -1.7934F, -2.3912F, 4, 3, 7, 0.0F);
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
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * limbSwingAmount;
    }
}
