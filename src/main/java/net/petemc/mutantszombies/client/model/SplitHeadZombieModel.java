package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SplitHeadZombieModel extends ModelBase {
    public final ModelRenderer head1;
    public final ModelRenderer head2;
    public final ModelRenderer torso;
    public final ModelRenderer left_leg;
    public final ModelRenderer right_leg;

    public SplitHeadZombieModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        // HEAD 1 (baked rotZ from PartPose)
        this.head1 = new ModelRenderer(this, 0, 0);
        this.head1.setRotationPoint(0.75F, 2.5F, 2.0F);
        this.head1.rotateAngleZ = -0.2182F;

        // cube_r1 (many boxes)
        ModelRenderer cube_r1 = new ModelRenderer(this, 0, 0);
        cube_r1.setRotationPoint(-6.3855F, -8.7303F, -4.5F);
        cube_r1.rotateAngleX = -0.1433F;
        cube_r1.rotateAngleY = 0.0571F;
        cube_r1.rotateAngleZ = -0.3029F;
        cube_r1.setTextureOffset(38, 18);  cube_r1.addBox(4.1724F, -2.9897F, -4.7701F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(50, 29);  cube_r1.addBox(4.1724F, -6.9897F, -0.7701F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(32, 5);   cube_r1.addBox(4.1724F, -3.9897F, -0.7701F, 3, 1, 1, 0.0F);
        cube_r1.setTextureOffset(55, 18);  cube_r1.addBox(4.1724F, -3.9897F, -2.7701F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(31, 55);  cube_r1.addBox(4.1724F, -4.9897F, 0.2299F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(0, 37);   cube_r1.addBox(4.1724F, -5.9897F, -3.7701F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(0, 13);   cube_r1.addBox(4.1724F, -5.9897F, -1.7701F, 2, 1, 1, 0.0F);
        cube_r1.setTextureOffset(50, 13);  cube_r1.addBox(4.1724F, -4.9897F, -4.7701F, 2, 1, 1, 0.0F);
        cube_r1.setTextureOffset(45, 30);  cube_r1.addBox(4.1724F, -6.9897F, 0.2299F, 2, 1, 1, 0.0F);
        cube_r1.setTextureOffset(55, 44);  cube_r1.addBox(4.1724F, -6.9897F, -4.7701F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(56, 21);  cube_r1.addBox(2.4224F, -2.2397F, -3.2701F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(26, 0);   cube_r1.addBox(0.4224F, -2.7397F, -3.2701F, 1, 2, 1, 0.0F);
        cube_r1.setTextureOffset(23, 56);  cube_r1.addBox(-0.5776F, -2.4897F, -3.2701F, 1, 1, 1, 0.0F);
        cube_r1.setTextureOffset(0, 26);   cube_r1.addBox(-1.8276F, -6.9897F, -4.7701F, 6, 5, 6, 0.0F);
        this.head1.addChild(cube_r1);

        // cube_r2 (many boxes)
        ModelRenderer cube_r2 = new ModelRenderer(this, 0, 0);
        cube_r2.setRotationPoint(-5.9855F, -9.0803F, -4.5F);
        cube_r2.rotateAngleX = 0.8166F;
        cube_r2.rotateAngleY = 0.0571F;
        cube_r2.rotateAngleZ = -0.3029F;
        cube_r2.setTextureOffset(12, 39);  cube_r2.addBox(3.4964F, -0.009F, -2.3775F, 2, 1, 1, 0.0F);
        cube_r2.setTextureOffset(0, 53);   cube_r2.addBox(3.4964F, 2.991F, 1.6225F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(4, 53);   cube_r2.addBox(3.4964F, 1.991F, -1.3775F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(50, 25);  cube_r2.addBox(3.4964F, 0.991F, 1.6225F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(50, 27);  cube_r2.addBox(3.4964F, -0.009F, 0.6225F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(8, 53);   cube_r2.addBox(3.4964F, -1.009F, -1.3775F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(38, 23);  cube_r2.addBox(3.4964F, 4.991F, 1.6225F, 2, 1, 1, 0.0F);
        cube_r2.setTextureOffset(38, 2);   cube_r2.addBox(3.4964F, 2.991F, -0.3775F, 2, 1, 1, 0.0F);
        cube_r2.setTextureOffset(43, 24);  cube_r2.addBox(3.4964F, 0.991F, -0.3775F, 2, 1, 1, 0.0F);
        cube_r2.setTextureOffset(0, 30);   cube_r2.addBox(3.4964F, -1.009F, 0.6225F, 2, 1, 1, 0.0F);
        cube_r2.setTextureOffset(50, 19);  cube_r2.addBox(0.4964F, -1.259F, -2.1275F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(54, 51);  cube_r2.addBox(1.9964F, -1.259F, -2.1275F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(56, 25);  cube_r2.addBox(-1.2536F, -1.759F, -2.1275F, 1, 1, 1, 0.0F);
        cube_r2.setTextureOffset(19, 32);  cube_r2.addBox(-1.5036F, -1.009F, -2.3775F, 5, 8, 5, 0.0F);
        this.head1.addChild(cube_r2);

        // bone3 (child of head1, baked rotZ)
        ModelRenderer bone3 = new ModelRenderer(this, 0, 0);
        bone3.setRotationPoint(-1.6355F, 5.5197F, -0.25F);
        bone3.rotateAngleZ = -0.2182F;
        this.head1.addChild(bone3);

        // cube_r3 inside bone3
        ModelRenderer cube_r3 = new ModelRenderer(this, 0, 0);
        cube_r3.setRotationPoint(0.0F, -5.5F, -2.75F);
        cube_r3.rotateAngleX = 0.1747F;
        cube_r3.rotateAngleY = 0.043F;
        cube_r3.rotateAngleZ = 0.0076F;
        cube_r3.setTextureOffset(53, 28);  cube_r3.addBox(1.0519F, -2.1027F, 3.7548F, 1, 1, 1, 0.0F);
        cube_r3.setTextureOffset(43, 1);   cube_r3.addBox(1.8013F, -4.1012F, 6.4378F, 1, 1, 1, 0.0F);
        cube_r3.setTextureOffset(16, 44);  cube_r3.addBox(1.8013F, -2.6012F, 6.4378F, 1, 1, 1, 0.0F);
        cube_r3.setTextureOffset(16, 46);  cube_r3.addBox(1.8013F, -1.1012F, 6.4378F, 1, 1, 1, 0.0F);
        cube_r3.setTextureOffset(19, 19);  cube_r3.addBox(-3.1128F, -6.1985F, -0.0299F, 6, 6, 7, 0.0F);
        cube_r3.setTextureOffset(12, 37);  cube_r3.addBox(1.8872F, -2.9485F, 0.2201F, 2, 1, 1, 0.0F);
        cube_r3.setTextureOffset(50, 15);  cube_r3.addBox(1.8872F, -2.9485F, 2.9701F, 2, 1, 1, 0.0F);
        cube_r3.setTextureOffset(34, 34);  cube_r3.addBox(1.8872F, -4.9485F, 1.4701F, 3, 1, 1, 0.0F);
        cube_r3.setTextureOffset(38, 0);   cube_r3.addBox(1.8872F, -4.9485F, 5.4701F, 2, 1, 1, 0.0F);
        cube_r3.setTextureOffset(50, 17);  cube_r3.addBox(1.8872F, -5.9485F, 3.4701F, 2, 1, 1, 0.0F);
        cube_r3.setTextureOffset(51, 50);  cube_r3.addBox(-4.1128F, -3.1985F, 1.9701F, 1, 1, 1, 0.0F);
        cube_r3.setTextureOffset(19, 13);  cube_r3.addBox(-5.1128F, -5.1985F, 2.9701F, 2, 1, 1, 0.0F);
        cube_r3.setTextureOffset(51, 52);  cube_r3.addBox(-4.1128F, -4.1985F, 3.9701F, 1, 1, 1, 0.0F);
        cube_r3.setTextureOffset(52, 45);  cube_r3.addBox(-4.1128F, -5.1985F, 1.9701F, 1, 1, 1, 0.0F);
        bone3.addChild(cube_r3);

        // HEAD 2
        this.head2 = new ModelRenderer(this, 0, 0);
        this.head2.setRotationPoint(0.5F, 2.25F, 2.0F);

        ModelRenderer cube_r4 = new ModelRenderer(this, 28, 47);
        cube_r4.setRotationPoint(0.15F, -10.1F, -4.0F);
        cube_r4.rotateAngleX = 0.9002F;
        cube_r4.rotateAngleY = 0.0829F;
        cube_r4.rotateAngleZ = -0.3843F;
        cube_r4.addBox(0.9811F, 4.0112F, -4.0F, 2, 1, 1, 0.0F);
        this.head2.addChild(cube_r4);

        // cube_r5 (many boxes)
        ModelRenderer cube_r5 = new ModelRenderer(this, 0, 0);
        cube_r5.setRotationPoint(5.75F, -10.0F, -4.0F);
        cube_r5.rotateAngleX = 0.0275F;
        cube_r5.rotateAngleY = -0.0829F;
        cube_r5.rotateAngleZ = 0.3843F;
        cube_r5.setTextureOffset(48, 23);  cube_r5.addBox(-3.5637F, -0.5999F, -0.919F, 2, 1, 1, 0.0F);
        cube_r5.setTextureOffset(54, 32);  cube_r5.addBox(-2.5637F, -3.5999F, -3.919F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(12, 55);  cube_r5.addBox(-2.5637F, -2.5999F, -4.919F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(28, 45);  cube_r5.addBox(-3.5637F, -1.5999F, -4.919F, 2, 1, 1, 0.0F);
        cube_r5.setTextureOffset(55, 12);  cube_r5.addBox(-2.5637F, -2.5999F, -3.919F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(47, 44);  cube_r5.addBox(-3.5637F, -4.5999F, -3.919F, 2, 1, 1, 0.0F);
        cube_r5.setTextureOffset(55, 14);  cube_r5.addBox(-2.5637F, -4.5999F, -2.919F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(8, 55);   cube_r5.addBox(-2.5637F, -0.5999F, -2.919F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(47, 46);  cube_r5.addBox(-3.5637F, -2.5999F, -1.919F, 2, 1, 1, 0.0F);
        cube_r5.setTextureOffset(55, 16);  cube_r5.addBox(-2.5637F, -2.5999F, -0.919F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(54, 49);  cube_r5.addBox(-2.5637F, -1.5999F, 0.081F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(34, 32);  cube_r5.addBox(-4.5637F, -3.5999F, 0.081F, 3, 1, 1, 0.0F);
        cube_r5.setTextureOffset(50, 11);  cube_r5.addBox(-3.5637F, -4.5999F, -0.919F, 2, 1, 1, 0.0F);
        cube_r5.setTextureOffset(15, 56);  cube_r5.addBox(2.1863F, 0.4001F, -3.419F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(56, 23);  cube_r5.addBox(0.9363F, -0.0999F, -3.419F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(19, 56);  cube_r5.addBox(-1.0637F, -0.0999F, -3.419F, 1, 1, 1, 0.0F);
        cube_r5.setTextureOffset(26, 7);   cube_r5.addBox(-1.5637F, -4.5999F, -4.919F, 6, 5, 6, 0.0F);
        this.head2.addChild(cube_r5);

        // cube_r6 (many boxes)
        ModelRenderer cube_r6 = new ModelRenderer(this, 0, 0);
        cube_r6.setRotationPoint(5.35F, -10.05F, -4.0F);
        cube_r6.rotateAngleX = 0.7693F;
        cube_r6.rotateAngleY = -0.0829F;
        cube_r6.rotateAngleZ = 0.3843F;
        cube_r6.setTextureOffset(54, 47);  cube_r6.addBox(-2.0003F, 1.9651F, 0.0F, 1, 1, 1, 0.0F);
        cube_r6.setTextureOffset(54, 53);  cube_r6.addBox(-2.0003F, 0.9651F, -1.0F, 1, 1, 1, 0.0F);
        cube_r6.setTextureOffset(54, 34);  cube_r6.addBox(-2.0003F, 4.9651F, -2.0F, 1, 1, 1, 0.0F);
        cube_r6.setTextureOffset(0, 55);   cube_r6.addBox(-2.0003F, 1.9651F, -2.0F, 1, 1, 1, 0.0F);
        cube_r6.setTextureOffset(45, 28);  cube_r6.addBox(-3.0003F, 4.9651F, 0.0F, 2, 1, 1, 0.0F);
        cube_r6.setTextureOffset(33, 46);  cube_r6.addBox(-3.0003F, 2.9651F, -1.0F, 2, 1, 1, 0.0F);
        cube_r6.setTextureOffset(0, 26);   cube_r6.addBox(-3.0003F, 2.9651F, -3.0F, 2, 1, 1, 0.0F);
        cube_r6.setTextureOffset(0, 28);   cube_r6.addBox(-3.0003F, -0.0349F, -2.0F, 2, 1, 1, 0.0F);
        cube_r6.setTextureOffset(4, 55);   cube_r6.addBox(-2.0003F, 0.9651F, -4.0F, 1, 1, 1, 0.0F);
        cube_r6.setTextureOffset(53, 30);  cube_r6.addBox(2.4997F, -0.5349F, -3.75F, 1, 1, 1, 0.0F);
        cube_r6.setTextureOffset(51, 54);  cube_r6.addBox(-0.5003F, -0.5349F, -3.75F, 1, 1, 1, 0.0F);
        cube_r6.setTextureOffset(39, 32);  cube_r6.addBox(-1.0003F, -0.0349F, -4.0F, 5, 7, 5, 0.0F);
        this.head2.addChild(cube_r6);

        // bone4 (child of head2, baked rotZ)
        ModelRenderer bone4 = new ModelRenderer(this, 0, 0);
        bone4.setRotationPoint(-0.5F, 6.75F, -1.0F);
        bone4.rotateAngleZ = 0.3054F;
        this.head2.addChild(bone4);

        ModelRenderer cube_r7 = new ModelRenderer(this, 0, 0);
        cube_r7.setRotationPoint(0.0F, -6.0F, -2.0F);
        cube_r7.rotateAngleX = 0.1747F;
        cube_r7.rotateAngleY = 0.043F;
        cube_r7.rotateAngleZ = 0.0948F;
        cube_r7.setTextureOffset(38, 20);  cube_r7.addBox(-1.7326F, -1.5998F, 6.3278F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(0, 39);   cube_r7.addBox(-1.7326F, -3.0998F, 6.3278F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(40, 5);   cube_r7.addBox(-1.7326F, -4.5998F, 6.3278F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(53, 22);  cube_r7.addBox(-0.9229F, -2.5677F, 3.707F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(53, 26);  cube_r7.addBox(-2.6467F, -6.6971F, 2.8601F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(12, 53);  cube_r7.addBox(-2.6467F, -2.6971F, 5.8601F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(53, 20);  cube_r7.addBox(-2.6467F, -4.6971F, 3.8601F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(0, 15);   cube_r7.addBox(-3.6467F, -3.6971F, 4.8601F, 2, 1, 1, 0.0F);
        cube_r7.setTextureOffset(0, 17);   cube_r7.addBox(-3.6467F, -6.6971F, 5.8601F, 2, 1, 1, 0.0F);
        cube_r7.setTextureOffset(51, 48);  cube_r7.addBox(-2.6467F, -4.6971F, -0.1399F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(0, 13);   cube_r7.addBox(-1.6467F, -6.6971F, -0.1399F, 6, 6, 7, 0.0F);
        bone4.addChild(cube_r7);

        ModelRenderer cube_r8 = new ModelRenderer(this, 0, 0);
        cube_r8.setRotationPoint(3.0F, -6.0F, -1.0F);
        cube_r8.rotateAngleX = 0.1747F;
        cube_r8.rotateAngleY = 0.043F;
        cube_r8.rotateAngleZ = 0.0948F;
        cube_r8.setTextureOffset(53, 24);  cube_r8.addBox(1.0771F, -3.8177F, 0.207F, 1, 1, 1, 0.0F);
        cube_r8.setTextureOffset(54, 55);  cube_r8.addBox(1.3533F, -3.6971F, 2.8601F, 1, 1, 1, 0.0F);
        cube_r8.setTextureOffset(56, 0);   cube_r8.addBox(1.3533F, -5.6971F, 2.8601F, 1, 1, 1, 0.0F);
        cube_r8.setTextureOffset(45, 26);  cube_r8.addBox(1.3533F, -5.6971F, 0.8601F, 2, 1, 1, 0.0F);
        cube_r8.setTextureOffset(56, 2);   cube_r8.addBox(1.3533F, -6.6971F, 1.8601F, 1, 1, 1, 0.0F);
        bone4.addChild(cube_r8);

        ModelRenderer cube_r9 = new ModelRenderer(this, 0, 0);
        cube_r9.setRotationPoint(6.0F, -5.1974F, 0.206F);
        cube_r9.rotateAngleX = -1.0076F;
        cube_r9.rotateAngleY = 0.0749F;
        cube_r9.rotateAngleZ = -0.0202F;
        cube_r9.setTextureOffset(0, 0);
        cube_r9.addBox(-0.8559F, -2.235F, -3.2203F, 1, 1, 2, 0.0F);
        bone4.addChild(cube_r9);

        ModelRenderer cube_r10 = new ModelRenderer(this, 0, 3);
        cube_r10.setRotationPoint(6.0F, -5.1974F, 0.206F);
        cube_r10.rotateAngleX = -2.1857F;
        cube_r10.rotateAngleY = 0.0749F;
        cube_r10.rotateAngleZ = -0.0202F;
        cube_r10.addBox(-0.8559F, 2.0142F, -4.3678F, 1, 1, 2, 0.0F);
        bone4.addChild(cube_r10);

        ModelRenderer cube_r11 = new ModelRenderer(this, 19, 15);
        cube_r11.setRotationPoint(6.0F, -5.1974F, 0.206F);
        cube_r11.rotateAngleX = -1.4876F;
        cube_r11.rotateAngleY = 0.0749F;
        cube_r11.rotateAngleZ = -0.0202F;
        cube_r11.addBox(-0.8559F, -1.1463F, -7.0477F, 1, 1, 3, 0.0F);
        bone4.addChild(cube_r11);

        // TORSO
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 3.0F, 3.0F);

        ModelRenderer cube_r12 = new ModelRenderer(this, 0, 0);
        cube_r12.setRotationPoint(0.0F, 13.0F, -3.0F);
        cube_r12.rotateAngleY = 0.0873F;
        cube_r12.setTextureOffset(44, 11);
        cube_r12.addBox(-0.5F, -14.25F, 5.0F, 2, 1, 1, 0.0F);
        cube_r12.setTextureOffset(0, 0);
        cube_r12.addBox(-4.5F, -14.0F, -0.5F, 10, 7, 6, 0.0F);
        this.torso.addChild(cube_r12);

        // LEFT LEG (baked rotations from PartPose)
        this.left_leg = new ModelRenderer(this, 0, 0);
        this.left_leg.setRotationPoint(4.5F, 7.5F, 0.5F);
        this.left_leg.rotateAngleX = -0.2618F;
        this.left_leg.rotateAngleY = -0.2182F;

        ModelRenderer cube_r13 = new ModelRenderer(this, 38, 18);
        cube_r13.setRotationPoint(-2.7026F, 16.192F, 1.4063F);
        cube_r13.rotateAngleX = 0.3054F;
        cube_r13.addBox(1.0F, -0.5F, -1.0F, 4, 1, 4, 0.0F);
        this.left_leg.addChild(cube_r13);

        ModelRenderer cube_r14 = new ModelRenderer(this, 35, 44);
        cube_r14.setRotationPoint(-2.7026F, 9.192F, 1.4063F);
        cube_r14.rotateAngleX = -0.1309F;
        cube_r14.addBox(1.0F, -9.25F, -3.0F, 4, 12, 4, 0.0F);
        this.left_leg.addChild(cube_r14);

        ModelRenderer cube_r15 = new ModelRenderer(this, 16, 45);
        cube_r15.setRotationPoint(-2.7026F, 9.192F, 1.4063F);
        cube_r15.rotateAngleX = 0.6109F;
        cube_r15.addBox(1.0F, 0.0F, -3.0F, 4, 7, 4, 0.0F);
        this.left_leg.addChild(cube_r15);

        // RIGHT LEG (baked rotY from PartPose)
        this.right_leg = new ModelRenderer(this, 26, 0);
        this.right_leg.setRotationPoint(-3.25F, 8.5F, 2.0F);
        this.right_leg.rotateAngleY = 0.4363F;
        this.right_leg.addBox(-2.3154F, 14.5F, -3.4603F, 4, 1, 4, 0.0F);

        ModelRenderer cube_r16 = new ModelRenderer(this, 44, 0);
        cube_r16.setRotationPoint(2.6846F, 8.5F, -2.4603F);
        cube_r16.rotateAngleX = 0.6109F;
        cube_r16.addBox(-5.0F, 0.0F, -3.0F, 4, 7, 4, 0.0F);
        this.right_leg.addChild(cube_r16);

        ModelRenderer cube_r17 = new ModelRenderer(this, 0, 37);
        cube_r17.setRotationPoint(2.6846F, 8.5F, -2.4603F);
        cube_r17.rotateAngleX = -0.4363F;
        cube_r17.addBox(-5.0F, -9.25F, -3.0F, 4, 12, 4, 0.0F);
        this.right_leg.addChild(cube_r17);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.head1.render(scale);
        this.head2.render(scale);
        this.torso.render(scale);
        this.left_leg.render(scale);
        this.right_leg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head1.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
        this.head1.rotateAngleX = headPitch / (180F / (float) Math.PI);
        this.head2.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
        this.head2.rotateAngleX = headPitch / (180F / (float) Math.PI);
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * limbSwingAmount;
    }
}