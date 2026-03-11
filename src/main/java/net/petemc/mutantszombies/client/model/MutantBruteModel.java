package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.petemc.mutantszombies.entity.MutantBruteEntity;

public class MutantBruteModel extends ModelBase {
    public final ModelRenderer head;
    public final ModelRenderer torso;
    public final ModelRenderer right_arm;
    public final ModelRenderer left_arm;
    public final ModelRenderer left_leg;
    public final ModelRenderer right_leg;

    public MutantBruteModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;

        // ===== HEAD =====
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(1.0F, -23.0F, -26.0F);

        ModelRenderer cube_r1 = new ModelRenderer(this, 0, 0);
        cube_r1.setRotationPoint(-4.0F, 6.0F, -3.0F);
        cube_r1.rotateAngleX = 0.2558F;
        cube_r1.rotateAngleY = -0.0393F;
        cube_r1.rotateAngleZ = 0.303F;
        cube_r1.setTextureOffset(0, 34);    cube_r1.addBox(9.0F, -4.4971F, -8.5555F, 2, 3, 1, 0.0F);
        cube_r1.setTextureOffset(37, 8);    cube_r1.addBox(8.0F, -2.4971F, -8.5555F, 1, 2, 1, 0.0F);
        cube_r1.setTextureOffset(38, 39);   cube_r1.addBox(1.0F, -3.4971F, -8.5555F, 2, 2, 1, 0.0F);
        cube_r1.setTextureOffset(142, 107); cube_r1.addBox(-1.0F, -1.4971F, -9.5555F, 13, 2, 11, 0.0F);
        this.head.addChild(cube_r1);

        ModelRenderer cube_r2 = new ModelRenderer(this, 0, 0);
        cube_r2.setRotationPoint(9.0F, 10.0F, -8.0F);
        cube_r2.rotateAngleX = -0.006F;
        cube_r2.rotateAngleY = -0.0393F;
        cube_r2.rotateAngleZ = 0.303F;
        cube_r2.setTextureOffset(0, 0);
        cube_r2.addBox(-1.3946F, -9.0389F, -0.2208F, 1, 10, 1, 0.0F);
        this.head.addChild(cube_r2);

        ModelRenderer cube_r3 = new ModelRenderer(this, 33, 0);
        cube_r3.setRotationPoint(8.0F, 10.0F, -4.0F);
        cube_r3.rotateAngleX = 0.2516F;
        cube_r3.rotateAngleY = -0.0612F;
        cube_r3.rotateAngleZ = 0.3876F;
        cube_r3.addBox(-0.5979F, -9.3484F, -1.0484F, 1, 9, 1, 0.0F);
        this.head.addChild(cube_r3);

        ModelRenderer cube_r4 = new ModelRenderer(this, 4, 0);
        cube_r4.setRotationPoint(8.0F, 11.0F, -10.0F);
        cube_r4.rotateAngleX = 0.2455F;
        cube_r4.rotateAngleY = -0.0827F;
        cube_r4.rotateAngleZ = 0.4724F;
        cube_r4.addBox(-0.6605F, -9.7518F, 0.0047F, 1, 10, 1, 0.0F);
        this.head.addChild(cube_r4);

        ModelRenderer cube_r5 = new ModelRenderer(this, 0, 0);
        cube_r5.setRotationPoint(-1.0F, 39.0F, 26.0F);
        cube_r5.rotateAngleX = -0.1309F;
        cube_r5.setTextureOffset(27, 36);  cube_r5.addBox(1.0F, -32.0F, -46.0F, 2, 2, 1, 0.0F);
        cube_r5.setTextureOffset(31, 36);  cube_r5.addBox(-3.0F, -32.0F, -46.0F, 2, 3, 1, 0.0F);
        cube_r5.setTextureOffset(37, 0);   cube_r5.addBox(5.0F, -32.0F, -46.0F, 1, 3, 1, 0.0F);
        cube_r5.setTextureOffset(37, 4);   cube_r5.addBox(6.0F, -33.0F, -46.0F, 2, 3, 1, 0.0F);
        cube_r5.setTextureOffset(113, 50); cube_r5.addBox(-6.0F, -44.0F, -47.0F, 19, 13, 21, 0.0F);
        this.head.addChild(cube_r5);

        // blisterhead (child of head)
        ModelRenderer blisterhead = new ModelRenderer(this, 0, 0);
        blisterhead.setRotationPoint(-1.0F, 39.0F, 26.0F);
        this.head.addChild(blisterhead);

        ModelRenderer cube_r6 = new ModelRenderer(this, 0, 0);
        cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r6.rotateAngleX = -0.1309F;
        cube_r6.setTextureOffset(189, 189); cube_r6.addBox(10.0F, -35.0F, -46.0F, 5, 5, 5, 0.0F);
        cube_r6.setTextureOffset(134, 41);  cube_r6.addBox(13.0F, -36.0F, -44.0F, 3, 4, 4, 0.0F);
        cube_r6.setTextureOffset(149, 0);   cube_r6.addBox(11.0F, -45.0F, -42.0F, 6, 4, 4, 0.0F);
        cube_r6.setTextureOffset(70, 185);  cube_r6.addBox(3.0F, -47.0F, -49.0F, 6, 5, 5, 0.0F);
        cube_r6.setTextureOffset(83, 75);   cube_r6.addBox(7.0F, -48.0F, -48.0F, 7, 9, 9, 0.0F);
        blisterhead.addChild(cube_r6);

        // Minihead (child of head)
        ModelRenderer Minihead = new ModelRenderer(this, 0, 0);
        Minihead.setRotationPoint(-10.0F, 4.0F, 2.0F);
        Minihead.setTextureOffset(150, 25); Minihead.addBox(-5.0F, -8.0F, -15.0F, 8, 9, 16, 0.0F);
        Minihead.setTextureOffset(40, 7);   Minihead.addBox(-4.0F, 1.0F, -14.0F, 2, 1, 1, 0.0F);
        this.head.addChild(Minihead);

        ModelRenderer cube_r7 = new ModelRenderer(this, 0, 0);
        cube_r7.setRotationPoint(1.0F, 1.0F, -5.0F);
        cube_r7.rotateAngleX = 0.1309F;
        cube_r7.setTextureOffset(0, 41);  cube_r7.addBox(3.0F, -0.6019F, -9.0736F, 1, 1, 1, 0.0F);
        cube_r7.setTextureOffset(0, 41);  cube_r7.addBox(4.0F, -1.6019F, -9.0736F, 1, 2, 1, 0.0F);
        cube_r7.setTextureOffset(7, 37);  cube_r7.addBox(-4.0F, -0.6019F, -3.0736F, 1, 2, 1, 0.0F);
        cube_r7.setTextureOffset(27, 29); cube_r7.addBox(-4.0F, -1.6019F, -6.0736F, 1, 3, 1, 0.0F);
        cube_r7.setTextureOffset(0, 38);  cube_r7.addBox(0.0F, -0.6019F, -9.0736F, 2, 1, 1, 0.0F);
        cube_r7.setTextureOffset(0, 29);  cube_r7.addBox(-3.0F, 0.3981F, -10.0736F, 8, 1, 11, 0.0F);
        Minihead.addChild(cube_r7);

        // ===== TORSO =====
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 24.0F, -13.0F);
        this.torso.setTextureOffset(79, 84);  this.torso.addBox(-16.0F, -49.0F, -15.0F, 13, 21, 37, 0.0F);
        this.torso.setTextureOffset(0, 0);    this.torso.addBox(-3.0F, -55.0F, -15.0F, 23, 27, 44, 0.0F);
        this.torso.setTextureOffset(0, 71);   this.torso.addBox(-13.0F, -38.0F, 4.0F, 25, 17, 33, 0.0F);

        // blistertorso (child of torso)
        ModelRenderer blistertorso = new ModelRenderer(this, 0, 0);
        blistertorso.setRotationPoint(0.0F, -8.0F, 0.0F);
        blistertorso.setTextureOffset(142, 84);  blistertorso.addBox(10.0F, -40.0F, 21.0F, 12, 10, 13, 0.0F);
        blistertorso.setTextureOffset(0, 121);   blistertorso.addBox(14.0F, -43.0F, 29.0F, 3, 4, 4, 0.0F);
        blistertorso.setTextureOffset(0, 29);    blistertorso.addBox(17.0F, -42.0F, 29.0F, 3, 3, 2, 0.0F);
        blistertorso.setTextureOffset(90, 8);    blistertorso.addBox(20.0F, -43.0F, 23.0F, 3, 4, 4, 0.0F);
        blistertorso.setTextureOffset(62, 136);  blistertorso.addBox(7.0F, -39.0F, 29.0F, 3, 4, 3, 0.0F);
        blistertorso.setTextureOffset(179, 84);  blistertorso.addBox(17.0F, -39.0F, 29.0F, 7, 6, 7, 0.0F);
        blistertorso.setTextureOffset(172, 184); blistertorso.addBox(14.0F, -32.0F, 29.0F, 5, 4, 6, 0.0F);
        blistertorso.setTextureOffset(27, 29);   blistertorso.addBox(18.0F, -31.0F, 26.0F, 5, 3, 4, 0.0F);
        blistertorso.setTextureOffset(90, 0);    blistertorso.addBox(20.0F, -32.0F, 19.0F, 3, 4, 4, 0.0F);
        this.torso.addChild(blistertorso);

        ModelRenderer cube_r8 = new ModelRenderer(this, 0, 0);
        cube_r8.setRotationPoint(0.0F, -35.0F, -1.0F);
        cube_r8.rotateAngleX = 0.3491F;
        cube_r8.setTextureOffset(179, 107); cube_r8.addBox(32.0F, -7.0F, -4.0F, 5, 5, 6, 0.0F);
        cube_r8.setTextureOffset(0, 129);   cube_r8.addBox(24.0F, 1.0F, -12.0F, 5, 5, 2, 0.0F);
        cube_r8.setTextureOffset(128, 180); cube_r8.addBox(28.0F, 0.0F, -15.0F, 4, 4, 7, 0.0F);
        cube_r8.setTextureOffset(150, 180); cube_r8.addBox(30.0F, -4.0F, -14.0F, 5, 5, 6, 0.0F);
        cube_r8.setTextureOffset(179, 120); cube_r8.addBox(34.0F, -5.0F, -8.0F, 5, 6, 6, 0.0F);
        cube_r8.setTextureOffset(47, 121);  cube_r8.addBox(28.0F, -2.0F, 1.0F, 9, 8, 7, 0.0F);
        cube_r8.setTextureOffset(170, 133); cube_r8.addBox(28.0F, -8.0F, -12.0F, 9, 11, 9, 0.0F);
        blistertorso.addChild(cube_r8);

        // bone (child of blistertorso)
        ModelRenderer bone = new ModelRenderer(this, 0, 0);
        bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        blistertorso.addChild(bone);

        ModelRenderer cube_r9 = new ModelRenderer(this, 0, 0);
        cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r9.rotateAngleY = -0.6545F;
        cube_r9.setTextureOffset(83, 93);   cube_r9.addBox(8.0F, -34.0F, 25.0F, 8, 4, 6, 0.0F);
        cube_r9.setTextureOffset(0, 94);    cube_r9.addBox(9.0F, -37.0F, 25.0F, 8, 5, 5, 0.0F);
        cube_r9.setTextureOffset(142, 84);  cube_r9.addBox(9.0F, -40.0F, 19.0F, 3, 3, 3, 0.0F);
        cube_r9.setTextureOffset(122, 191); cube_r9.addBox(13.0F, -41.0F, 19.0F, 3, 4, 6, 0.0F);
        cube_r9.setTextureOffset(170, 171); cube_r9.addBox(4.0F, -38.0F, 21.0F, 11, 6, 7, 0.0F);
        bone.addChild(cube_r9);

        // ===== RIGHT ARM =====
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.setRotationPoint(-16.0F, -17.0F, -19.0F);

        ModelRenderer cube_r10 = new ModelRenderer(this, 0, 168);
        cube_r10.setRotationPoint(-4.0F, 6.0F, -3.0F);
        cube_r10.rotateAngleX = 0.3491F;
        cube_r10.addBox(-4.0F, 0.0F, -3.0F, 10, 18, 10, 0.0F);
        this.right_arm.addChild(cube_r10);

        // left_arm2 (child of right_arm)
        ModelRenderer left_arm2 = new ModelRenderer(this, 0, 0);
        left_arm2.setRotationPoint(-7.0F, 6.0F, -3.0F);
        this.right_arm.addChild(left_arm2);

        ModelRenderer cube_r11 = new ModelRenderer(this, 40, 168);
        cube_r11.setRotationPoint(-19.0F, -8.0F, 0.0F);
        cube_r11.rotateAngleX = -0.1309F;
        cube_r11.addBox(18.0F, 16.0F, 6.0F, 6, 27, 9, 0.0F);
        left_arm2.addChild(cube_r11);

        ModelRenderer cube_r12 = new ModelRenderer(this, 120, 142);
        cube_r12.setRotationPoint(-19.0F, -8.0F, 0.0F);
        cube_r12.rotateAngleX = 0.3491F;
        cube_r12.addBox(16.0F, -3.0F, -4.0F, 13, 26, 12, 0.0F);
        left_arm2.addChild(cube_r12);

        // blisterarm (child of right_arm)
        ModelRenderer blisterarm = new ModelRenderer(this, 0, 0);
        blisterarm.setRotationPoint(16.0F, -2.0F, -3.0F);
        this.right_arm.addChild(blisterarm);

        ModelRenderer cube_r13 = new ModelRenderer(this, 106, 173);
        cube_r13.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r13.rotateAngleX = -0.1309F;
        cube_r13.addBox(-18.0F, 14.0F, 7.0F, 3, 14, 8, 0.0F);
        blisterarm.addChild(cube_r13);

        // ===== LEFT ARM =====
        this.left_arm = new ModelRenderer(this, 0, 0);
        this.left_arm.setRotationPoint(20.0F, -17.0F, -15.0F);

        ModelRenderer cube_r14 = new ModelRenderer(this, 0, 121);
        cube_r14.setRotationPoint(-20.0F, -2.0F, 1.0F);
        cube_r14.rotateAngleX = -0.1355F;
        cube_r14.rotateAngleY = 0.2595F;
        cube_r14.rotateAngleZ = -0.035F;
        cube_r14.addBox(14.0F, 11.0F, 2.0F, 16, 32, 15, 0.0F);
        this.left_arm.addChild(cube_r14);

        ModelRenderer cube_r15 = new ModelRenderer(this, 90, 0);
        cube_r15.setRotationPoint(-20.0F, -2.0F, 1.0F);
        cube_r15.rotateAngleX = 0.3491F;
        cube_r15.addBox(13.0F, -6.0F, -10.0F, 21, 24, 17, 0.0F);
        this.left_arm.addChild(cube_r15);

        // lfarmblister (child of left_arm)
        ModelRenderer lfarmblister = new ModelRenderer(this, 0, 0);
        lfarmblister.setRotationPoint(9.6667F, 36.4444F, 3.6111F);
        lfarmblister.rotateAngleX = -2.6517F;
        lfarmblister.rotateAngleY = -0.1932F;
        lfarmblister.rotateAngleZ = -0.102F;
        lfarmblister.setTextureOffset(142, 84);  lfarmblister.addBox(-7.6667F, -4.4444F, -7.6111F, 12, 10, 13, 0.0F);
        lfarmblister.setTextureOffset(0, 121);   lfarmblister.addBox(-3.6667F, -7.4444F, 0.3889F, 3, 4, 4, 0.0F);
        lfarmblister.setTextureOffset(0, 29);    lfarmblister.addBox(-0.6667F, -6.4444F, 0.3889F, 3, 3, 2, 0.0F);
        lfarmblister.setTextureOffset(179, 84);  lfarmblister.addBox(-0.6667F, -3.4444F, 0.3889F, 7, 6, 7, 0.0F);
        lfarmblister.setTextureOffset(172, 184); lfarmblister.addBox(-3.6667F, 3.5556F, 0.3889F, 5, 4, 6, 0.0F);
        lfarmblister.setTextureOffset(27, 29);   lfarmblister.addBox(0.3333F, 4.5556F, -2.6111F, 5, 3, 4, 0.0F);
        lfarmblister.setTextureOffset(62, 136);  lfarmblister.addBox(-10.6667F, -3.4444F, 0.3889F, 3, 4, 3, 0.0F);
        lfarmblister.setTextureOffset(90, 0);    lfarmblister.addBox(2.3333F, 3.5556F, -9.6111F, 3, 4, 4, 0.0F);
        lfarmblister.setTextureOffset(90, 8);    lfarmblister.addBox(2.3333F, -7.4444F, -5.6111F, 3, 4, 4, 0.0F);
        this.left_arm.addChild(lfarmblister);

        ModelRenderer cube_r16 = new ModelRenderer(this, 0, 0);
        cube_r16.setRotationPoint(3.4896F, 24.8529F, 12.9747F);
        cube_r16.rotateAngleX = 0.8494F;
        cube_r16.rotateAngleY = -0.5163F;
        cube_r16.rotateAngleZ = 0.4707F;
        cube_r16.setTextureOffset(128, 180); cube_r16.addBox(-19.1562F, -4.8107F, -12.9969F, 4, 4, 7, 0.0F);
        cube_r16.setTextureOffset(150, 180); cube_r16.addBox(-17.1562F, -8.8107F, -11.9969F, 5, 5, 6, 0.0F);
        cube_r16.setTextureOffset(179, 120); cube_r16.addBox(-13.1562F, -9.8107F, -5.9969F, 5, 6, 6, 0.0F);
        cube_r16.setTextureOffset(179, 107); cube_r16.addBox(-15.1562F, -11.8107F, -1.9969F, 5, 5, 6, 0.0F);
        lfarmblister.addChild(cube_r16);

        // bone2 (child of left_arm)
        ModelRenderer bone2 = new ModelRenderer(this, 0, 0);
        bone2.setRotationPoint(2.5262F, 33.2F, 9.6814F);
        bone2.rotateAngleX = -1.0036F;
        bone2.rotateAngleY = 0.3747F;
        bone2.rotateAngleZ = 0.2291F;
        this.left_arm.addChild(bone2);

        ModelRenderer cube_r17 = new ModelRenderer(this, 0, 0);
        cube_r17.setRotationPoint(5.4738F, 35.8F, -26.6814F);
        cube_r17.rotateAngleY = -0.6545F;
        cube_r17.setTextureOffset(83, 93);   cube_r17.addBox(8.0F, -34.0F, 25.0F, 8, 4, 6, 0.0F);
        cube_r17.setTextureOffset(0, 94);    cube_r17.addBox(9.0F, -37.0F, 25.0F, 8, 5, 5, 0.0F);
        cube_r17.setTextureOffset(142, 84);  cube_r17.addBox(9.0F, -40.0F, 19.0F, 3, 3, 3, 0.0F);
        cube_r17.setTextureOffset(122, 191); cube_r17.addBox(13.0F, -41.0F, 19.0F, 3, 4, 6, 0.0F);
        cube_r17.setTextureOffset(170, 171); cube_r17.addBox(4.0F, -38.0F, 21.0F, 11, 6, 7, 0.0F);
        bone2.addChild(cube_r17);

        // lfarmblister3 (child of left_arm) – same boxes as lfarmblister, different pose
        ModelRenderer lfarmblister3 = new ModelRenderer(this, 0, 0);
        lfarmblister3.setRotationPoint(9.6667F, 33.4444F, -5.3889F);
        lfarmblister3.rotateAngleX = 2.5406F;
        lfarmblister3.rotateAngleY = -0.1932F;
        lfarmblister3.rotateAngleZ = -0.102F;
        lfarmblister3.setTextureOffset(142, 84);  lfarmblister3.addBox(-7.6667F, -4.4444F, -7.6111F, 12, 10, 13, 0.0F);
        lfarmblister3.setTextureOffset(0, 121);   lfarmblister3.addBox(-3.6667F, -7.4444F, 0.3889F, 3, 4, 4, 0.0F);
        lfarmblister3.setTextureOffset(0, 29);    lfarmblister3.addBox(-0.6667F, -6.4444F, 0.3889F, 3, 3, 2, 0.0F);
        lfarmblister3.setTextureOffset(179, 84);  lfarmblister3.addBox(-0.6667F, -3.4444F, 0.3889F, 7, 6, 7, 0.0F);
        lfarmblister3.setTextureOffset(172, 184); lfarmblister3.addBox(-3.6667F, 3.5556F, 0.3889F, 5, 4, 6, 0.0F);
        lfarmblister3.setTextureOffset(27, 29);   lfarmblister3.addBox(0.3333F, 4.5556F, -2.6111F, 5, 3, 4, 0.0F);
        lfarmblister3.setTextureOffset(62, 136);  lfarmblister3.addBox(-10.6667F, -3.4444F, 0.3889F, 3, 4, 3, 0.0F);
        lfarmblister3.setTextureOffset(90, 0);    lfarmblister3.addBox(2.3333F, 3.5556F, -9.6111F, 3, 4, 4, 0.0F);
        lfarmblister3.setTextureOffset(90, 8);    lfarmblister3.addBox(2.3333F, -7.4444F, -5.6111F, 3, 4, 4, 0.0F);
        this.left_arm.addChild(lfarmblister3);

        // lfarmblister2 (child of left_arm)
        ModelRenderer lfarmblister2 = new ModelRenderer(this, 0, 0);
        lfarmblister2.setRotationPoint(-2.0F, 33.4268F, -2.8331F);
        lfarmblister2.rotateAngleY = 1.5272F;
        lfarmblister2.setTextureOffset(170, 153); lfarmblister2.addBox(-3.0F, -4.4268F, -3.1669F, 8, 9, 9, 0.0F);
        lfarmblister2.setTextureOffset(172, 62);  lfarmblister2.addBox(2.0F, -6.4268F, -0.1669F, 6, 4, 5, 0.0F);
        lfarmblister2.setTextureOffset(104, 142); lfarmblister2.addBox(-1.0F, 1.5732F, -5.1669F, 8, 6, 6, 0.0F);
        this.left_arm.addChild(lfarmblister2);

        ModelRenderer cube_r18 = new ModelRenderer(this, 0, 0);
        cube_r18.setRotationPoint(-11.0F, -3.4268F, -3.1669F);
        cube_r18.rotateAngleX = 0.4363F;
        cube_r18.setTextureOffset(87, 190);  cube_r18.addBox(8.0F, 6.0F, 3.0F, 5, 4, 5, 0.0F);
        cube_r18.setTextureOffset(182, 24);  cube_r18.addBox(7.0F, -2.0F, -4.0F, 6, 5, 5, 0.0F);
        cube_r18.setTextureOffset(30, 168);  cube_r18.addBox(1.0F, 2.0F, -3.0F, 5, 4, 4, 0.0F);
        lfarmblister2.addChild(cube_r18);

        // lfarmblister4 (child of left_arm)
        ModelRenderer lfarmblister4 = new ModelRenderer(this, 0, 0);
        lfarmblister4.setRotationPoint(-3.0F, 26.4268F, -2.8331F);
        lfarmblister4.rotateAngleX = -1.0961F;
        lfarmblister4.rotateAngleY = 0.9286F;
        lfarmblister4.rotateAngleZ = -1.0832F;
        lfarmblister4.setTextureOffset(170, 153); lfarmblister4.addBox(-3.0F, -4.4268F, -3.1669F, 8, 9, 9, 0.0F);
        lfarmblister4.setTextureOffset(172, 62);  lfarmblister4.addBox(2.0F, -6.4268F, -0.1669F, 6, 4, 5, 0.0F);
        lfarmblister4.setTextureOffset(104, 142); lfarmblister4.addBox(-1.0F, 1.5732F, -5.1669F, 8, 6, 6, 0.0F);
        this.left_arm.addChild(lfarmblister4);

        ModelRenderer cube_r19 = new ModelRenderer(this, 0, 0);
        cube_r19.setRotationPoint(-11.0F, -3.4268F, -3.1669F);
        cube_r19.rotateAngleX = 0.4363F;
        cube_r19.setTextureOffset(87, 190);  cube_r19.addBox(8.0F, 6.0F, 3.0F, 5, 4, 5, 0.0F);
        cube_r19.setTextureOffset(182, 24);  cube_r19.addBox(7.0F, -2.0F, -4.0F, 6, 5, 5, 0.0F);
        cube_r19.setTextureOffset(30, 168);  cube_r19.addBox(1.0F, 2.0F, -3.0F, 5, 4, 4, 0.0F);
        lfarmblister4.addChild(cube_r19);

        // bone3 (child of left_arm)
        ModelRenderer bone3 = new ModelRenderer(this, 0, 0);
        bone3.setRotationPoint(6.8333F, 20.4754F, 9.1219F);
        bone3.rotateAngleX = -0.2206F;
        bone3.rotateAngleY = -0.3207F;
        bone3.rotateAngleZ = 0.4994F;
        bone3.setTextureOffset(170, 153); bone3.addBox(-4.8333F, -3.4754F, -6.1219F, 8, 9, 9, 0.0F);
        bone3.setTextureOffset(172, 62);  bone3.addBox(0.1667F, -5.4754F, -6.1219F, 6, 4, 5, 0.0F);
        this.left_arm.addChild(bone3);

        ModelRenderer cube_r20 = new ModelRenderer(this, 172, 62);
        cube_r20.setRotationPoint(3.1667F, 1.5246F, -10.6219F);
        cube_r20.rotateAngleY = 1.4835F;
        cube_r20.addBox(-5.0F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
        bone3.addChild(cube_r20);

        ModelRenderer cube_r21 = new ModelRenderer(this, 87, 190);
        cube_r21.setRotationPoint(-12.8333F, -2.4754F, -6.1219F);
        cube_r21.rotateAngleX = 0.4363F;
        cube_r21.addBox(8.0F, 6.0F, 3.0F, 5, 4, 5, 0.0F);
        bone3.addChild(cube_r21);

        // ===== LEFT LEG =====
        this.left_leg = new ModelRenderer(this, 70, 173);
        this.left_leg.setRotationPoint(12.0F, -1.0F, 20.0F);
        this.left_leg.addBox(-5.0F, 22.0F, 1.0F, 9, 3, 9, 0.0F);

        ModelRenderer cube_r22 = new ModelRenderer(this, 166, 0);
        cube_r22.setRotationPoint(-8.0F, 14.0F, 1.0F);
        cube_r22.rotateAngleX = 0.4363F;
        cube_r22.addBox(3.0F, -4.0F, -1.0F, 9, 16, 8, 0.0F);
        this.left_leg.addChild(cube_r22);

        ModelRenderer cube_r23 = new ModelRenderer(this, 62, 142);
        cube_r23.setRotationPoint(-2.0F, 2.0F, 4.0F);
        cube_r23.addBox(-4.0F, -6.6533F, -10.2527F, 13, 15, 16, 0.0F);
        this.left_leg.addChild(cube_r23);

        // blisterleg (child of left_leg)
        ModelRenderer blisterleg = new ModelRenderer(this, 0, 0);
        blisterleg.setRotationPoint(-8.0F, 14.0F, 1.0F);
        blisterleg.setTextureOffset(170, 153); blisterleg.addBox(8.0F, -1.0F, 0.0F, 8, 9, 9, 0.0F);
        blisterleg.setTextureOffset(172, 62);  blisterleg.addBox(13.0F, -3.0F, 3.0F, 6, 4, 5, 0.0F);
        blisterleg.setTextureOffset(104, 142); blisterleg.addBox(10.0F, 5.0F, -2.0F, 8, 6, 6, 0.0F);
        this.left_leg.addChild(blisterleg);

        ModelRenderer cube_r24 = new ModelRenderer(this, 0, 0);
        cube_r24.setRotationPoint(0.0F, 0.0F, 0.0F);
        cube_r24.rotateAngleX = 0.4363F;
        cube_r24.setTextureOffset(87, 190);  cube_r24.addBox(8.0F, 6.0F, 3.0F, 5, 4, 5, 0.0F);
        cube_r24.setTextureOffset(182, 24);  cube_r24.addBox(7.0F, -2.0F, -4.0F, 6, 5, 5, 0.0F);
        cube_r24.setTextureOffset(30, 168);  cube_r24.addBox(1.0F, 2.0F, -3.0F, 5, 4, 4, 0.0F);
        blisterleg.addChild(cube_r24);

        // ===== RIGHT LEG =====
        this.right_leg = new ModelRenderer(this, 172, 50);
        this.right_leg.setRotationPoint(-13.0F, -1.0F, 20.0F);
        this.right_leg.addBox(-4.0F, 24.0F, -6.0F, 8, 2, 10, 0.0F);

        ModelRenderer cube_r25 = new ModelRenderer(this, 0, 0);
        cube_r25.setRotationPoint(4.0F, 17.0F, -6.0F);
        cube_r25.rotateAngleX = -0.3054F;
        cube_r25.addBox(-10.0F, -24.0F, -4.0F, 11, 18, 11, 0.0F);
        this.right_leg.addChild(cube_r25);

        ModelRenderer cube_r26 = new ModelRenderer(this, 0, 71);
        cube_r26.setRotationPoint(4.0F, 17.0F, -6.0F);
        cube_r26.rotateAngleX = 0.1745F;
        cube_r26.addBox(-8.0F, -6.0F, 1.0F, 8, 15, 8, 0.0F);
        this.right_leg.addChild(cube_r26);
    }

    private static float triangleWave(float x, float period) {
        return (Math.abs(x % period - period * 0.5F) - period * 0.25F) / (period * 0.25F);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.head.render(scale);
        this.torso.render(scale);
        this.right_arm.render(scale);
        this.left_arm.render(scale);
        this.left_leg.render(scale);
        this.right_leg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
        this.head.rotateAngleX = headPitch / (180F / (float) Math.PI);
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * limbSwingAmount;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTick) {
        MutantBruteEntity mutantBrute = (MutantBruteEntity) entity;
        int i = mutantBrute.getAttackAnimationTick();
        if (i > 0) {
            this.right_arm.rotateAngleX = -2.0F + 1.5F * triangleWave((float) i - partialTick, 10.0F);
            this.left_arm.rotateAngleX = -2.0F + 1.5F * triangleWave((float) i - partialTick, 10.0F);
        } else {
            this.right_arm.rotateAngleX = (-0.2F + 1.5F * triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
            this.left_arm.rotateAngleX = (-0.2F - 1.5F * triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
        }
    }
}
