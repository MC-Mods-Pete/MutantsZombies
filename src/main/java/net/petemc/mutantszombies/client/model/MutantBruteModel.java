package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.state.BlisterZombieEntityRenderState;
import net.petemc.mutantszombies.client.state.CrawlerEntityRenderState;
import net.petemc.mutantszombies.client.state.MutantBruteEntityRenderState;

public class MutantBruteModel extends EntityModel<MutantBruteEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of(MutantsZombies.MOD_ID, "mutant_brute"), "main");
	private final ModelPart head;
	private final ModelPart torso;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public MutantBruteModel(ModelPart root) {
        super(root);
		this.head = root.getChild("head");
		this.torso = root.getChild("torso");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
	}

	public static TexturedModelData createBodyLayer() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.origin(1.0F, -23.0F, -26.0F));
		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(0, 34).cuboid(9.0F, -4.4971F, -8.5555F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(37, 8).cuboid(8.0F, -2.4971F, -8.5555F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(38, 39).cuboid(1.0F, -3.4971F, -8.5555F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(142, 107).cuboid(-1.0F, -1.4971F, -9.5555F, 13.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 6.0F, -3.0F, 0.2558F, -0.0393F, 0.303F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-1.3946F, -9.0389F, -0.2208F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, 10.0F, -8.0F, -0.006F, -0.0393F, 0.303F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(33, 0).cuboid(-0.5979F, -9.3484F, -1.0484F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 10.0F, -4.0F, 0.2516F, -0.0612F, 0.3876F));

		ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(4, 0).cuboid(-0.6605F, -9.7518F, 0.0047F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 11.0F, -10.0F, 0.2455F, -0.0827F, 0.4724F));

		ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(27, 36).cuboid(1.0F, -32.0F, -46.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(31, 36).cuboid(-3.0F, -32.0F, -46.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(37, 0).cuboid(5.0F, -32.0F, -46.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(37, 4).cuboid(6.0F, -33.0F, -46.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(113, 50).cuboid(-6.0F, -44.0F, -47.0F, 19.0F, 13.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 39.0F, 26.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData blisterhead = head.addChild("blisterhead", ModelPartBuilder.create(), ModelTransform.origin(-1.0F, 39.0F, 26.0F));

		ModelPartData cube_r6 = blisterhead.addChild("cube_r6", ModelPartBuilder.create().uv(189, 189).cuboid(10.0F, -35.0F, -46.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
				.uv(134, 41).cuboid(13.0F, -36.0F, -44.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(149, 0).cuboid(11.0F, -45.0F, -42.0F, 6.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(70, 185).cuboid(3.0F, -47.0F, -49.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F))
				.uv(83, 75).cuboid(7.0F, -48.0F, -48.0F, 7.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData Minihead = head.addChild("Minihead", ModelPartBuilder.create().uv(150, 25).cuboid(-5.0F, -8.0F, -15.0F, 8.0F, 9.0F, 16.0F, new Dilation(0.0F))
				.uv(40, 7).cuboid(-4.0F, 1.0F, -14.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(-10.0F, 4.0F, 2.0F));

		ModelPartData cube_r7 = Minihead.addChild("cube_r7", ModelPartBuilder.create().uv(0, 41).cuboid(3.0F, -0.6019F, -9.0736F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 41).cuboid(4.0F, -1.6019F, -9.0736F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(7, 37).cuboid(-4.0F, -0.6019F, -3.0736F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(27, 29).cuboid(-4.0F, -1.6019F, -6.0736F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 38).cuboid(0.0F, -0.6019F, -9.0736F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 29).cuboid(-3.0F, 0.3981F, -10.0736F, 8.0F, 1.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 1.0F, -5.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create().uv(79, 84).cuboid(-16.0F, -49.0F, -15.0F, 13.0F, 21.0F, 37.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -55.0F, -15.0F, 23.0F, 27.0F, 44.0F, new Dilation(0.0F))
				.uv(0, 71).cuboid(-13.0F, -38.0F, 4.0F, 25.0F, 17.0F, 33.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 24.0F, -13.0F));

		ModelPartData blistertorso = torso.addChild("blistertorso", ModelPartBuilder.create().uv(142, 84).cuboid(10.0F, -40.0F, 21.0F, 12.0F, 10.0F, 13.0F, new Dilation(0.0F))
				.uv(0, 121).cuboid(14.0F, -43.0F, 29.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 29).cuboid(17.0F, -42.0F, 29.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(90, 8).cuboid(20.0F, -43.0F, 23.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(62, 136).cuboid(7.0F, -39.0F, 29.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
				.uv(179, 84).cuboid(17.0F, -39.0F, 29.0F, 7.0F, 6.0F, 7.0F, new Dilation(0.0F))
				.uv(172, 184).cuboid(14.0F, -32.0F, 29.0F, 5.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(27, 29).cuboid(18.0F, -31.0F, 26.0F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(90, 0).cuboid(20.0F, -32.0F, 19.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -8.0F, 0.0F));

		ModelPartData cube_r8 = blistertorso.addChild("cube_r8", ModelPartBuilder.create().uv(179, 107).cuboid(32.0F, -7.0F, -4.0F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 129).cuboid(24.0F, 1.0F, -12.0F, 5.0F, 5.0F, 2.0F, new Dilation(0.0F))
				.uv(128, 180).cuboid(28.0F, 0.0F, -15.0F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
				.uv(150, 180).cuboid(30.0F, -4.0F, -14.0F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
				.uv(179, 120).cuboid(34.0F, -5.0F, -8.0F, 5.0F, 6.0F, 6.0F, new Dilation(0.0F))
				.uv(47, 121).cuboid(28.0F, -2.0F, 1.0F, 9.0F, 8.0F, 7.0F, new Dilation(0.0F))
				.uv(170, 133).cuboid(28.0F, -8.0F, -12.0F, 9.0F, 11.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -35.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData bone = blistertorso.addChild("bone", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r9 = bone.addChild("cube_r9", ModelPartBuilder.create().uv(83, 93).cuboid(8.0F, -34.0F, 25.0F, 8.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 94).cuboid(9.0F, -37.0F, 25.0F, 8.0F, 5.0F, 5.0F, new Dilation(0.0F))
				.uv(142, 84).cuboid(9.0F, -40.0F, 19.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(122, 191).cuboid(13.0F, -41.0F, 19.0F, 3.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(170, 171).cuboid(4.0F, -38.0F, 21.0F, 11.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.6545F, 0.0F));

		ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.origin(-16.0F, -17.0F, -19.0F));

		ModelPartData cube_r10 = right_arm.addChild("cube_r10", ModelPartBuilder.create().uv(0, 168).cuboid(-4.0F, 0.0F, -3.0F, 10.0F, 18.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 6.0F, -3.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData left_arm2 = right_arm.addChild("left_arm2", ModelPartBuilder.create(), ModelTransform.origin(-7.0F, 6.0F, -3.0F));

		ModelPartData cube_r11 = left_arm2.addChild("cube_r11", ModelPartBuilder.create().uv(40, 168).cuboid(18.0F, 16.0F, 6.0F, 6.0F, 27.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-19.0F, -8.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData cube_r12 = left_arm2.addChild("cube_r12", ModelPartBuilder.create().uv(120, 142).cuboid(16.0F, -3.0F, -4.0F, 13.0F, 26.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-19.0F, -8.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData blisterarm = right_arm.addChild("blisterarm", ModelPartBuilder.create(), ModelTransform.origin(16.0F, -2.0F, -3.0F));

		ModelPartData cube_r13 = blisterarm.addChild("cube_r13", ModelPartBuilder.create().uv(106, 173).cuboid(-18.0F, 14.0F, 7.0F, 3.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.origin(20.0F, -17.0F, -15.0F));

		ModelPartData cube_r14 = left_arm.addChild("cube_r14", ModelPartBuilder.create().uv(0, 121).cuboid(14.0F, 11.0F, 2.0F, 16.0F, 32.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(-20.0F, -2.0F, 1.0F, -0.1355F, 0.2595F, -0.035F));

		ModelPartData cube_r15 = left_arm.addChild("cube_r15", ModelPartBuilder.create().uv(90, 0).cuboid(13.0F, -6.0F, -10.0F, 21.0F, 24.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-20.0F, -2.0F, 1.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData lfarmblister = left_arm.addChild("lfarmblister", ModelPartBuilder.create().uv(142, 84).cuboid(-7.6667F, -4.4444F, -7.6111F, 12.0F, 10.0F, 13.0F, new Dilation(0.0F))
				.uv(0, 121).cuboid(-3.6667F, -7.4444F, 0.3889F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 29).cuboid(-0.6667F, -6.4444F, 0.3889F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(179, 84).cuboid(-0.6667F, -3.4444F, 0.3889F, 7.0F, 6.0F, 7.0F, new Dilation(0.0F))
				.uv(172, 184).cuboid(-3.6667F, 3.5556F, 0.3889F, 5.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(27, 29).cuboid(0.3333F, 4.5556F, -2.6111F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(62, 136).cuboid(-10.6667F, -3.4444F, 0.3889F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
				.uv(90, 0).cuboid(2.3333F, 3.5556F, -9.6111F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(90, 8).cuboid(2.3333F, -7.4444F, -5.6111F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(9.6667F, 36.4444F, 3.6111F, -2.6517F, -0.1932F, -0.102F));

		ModelPartData cube_r16 = lfarmblister.addChild("cube_r16", ModelPartBuilder.create().uv(128, 180).cuboid(-19.1562F, -4.8107F, -12.9969F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
				.uv(150, 180).cuboid(-17.1562F, -8.8107F, -11.9969F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
				.uv(179, 120).cuboid(-13.1562F, -9.8107F, -5.9969F, 5.0F, 6.0F, 6.0F, new Dilation(0.0F))
				.uv(179, 107).cuboid(-15.1562F, -11.8107F, -1.9969F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.4896F, 24.8529F, 12.9747F, 0.8494F, -0.5163F, 0.4707F));

		ModelPartData bone2 = left_arm.addChild("bone2", ModelPartBuilder.create(), ModelTransform.of(2.5262F, 33.2F, 9.6814F, -1.0036F, 0.3747F, 0.2291F));

		ModelPartData cube_r17 = bone2.addChild("cube_r17", ModelPartBuilder.create().uv(83, 93).cuboid(8.0F, -34.0F, 25.0F, 8.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 94).cuboid(9.0F, -37.0F, 25.0F, 8.0F, 5.0F, 5.0F, new Dilation(0.0F))
				.uv(142, 84).cuboid(9.0F, -40.0F, 19.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(122, 191).cuboid(13.0F, -41.0F, 19.0F, 3.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(170, 171).cuboid(4.0F, -38.0F, 21.0F, 11.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(5.4738F, 35.8F, -26.6814F, 0.0F, -0.6545F, 0.0F));

		ModelPartData lfarmblister3 = left_arm.addChild("lfarmblister3", ModelPartBuilder.create().uv(142, 84).cuboid(-7.6667F, -4.4444F, -7.6111F, 12.0F, 10.0F, 13.0F, new Dilation(0.0F))
				.uv(0, 121).cuboid(-3.6667F, -7.4444F, 0.3889F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 29).cuboid(-0.6667F, -6.4444F, 0.3889F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(179, 84).cuboid(-0.6667F, -3.4444F, 0.3889F, 7.0F, 6.0F, 7.0F, new Dilation(0.0F))
				.uv(172, 184).cuboid(-3.6667F, 3.5556F, 0.3889F, 5.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(27, 29).cuboid(0.3333F, 4.5556F, -2.6111F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(62, 136).cuboid(-10.6667F, -3.4444F, 0.3889F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
				.uv(90, 0).cuboid(2.3333F, 3.5556F, -9.6111F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(90, 8).cuboid(2.3333F, -7.4444F, -5.6111F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(9.6667F, 33.4444F, -5.3889F, 2.5406F, -0.1932F, -0.102F));

		ModelPartData lfarmblister2 = left_arm.addChild("lfarmblister2", ModelPartBuilder.create().uv(170, 153).cuboid(-3.0F, -4.4268F, -3.1669F, 8.0F, 9.0F, 9.0F, new Dilation(0.0F))
				.uv(172, 62).cuboid(2.0F, -6.4268F, -0.1669F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(104, 142).cuboid(-1.0F, 1.5732F, -5.1669F, 8.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 33.4268F, -2.8331F, 0.0F, 1.5272F, 0.0F));

		ModelPartData cube_r18 = lfarmblister2.addChild("cube_r18", ModelPartBuilder.create().uv(87, 190).cuboid(8.0F, 6.0F, 3.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(182, 24).cuboid(7.0F, -2.0F, -4.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F))
				.uv(30, 168).cuboid(1.0F, 2.0F, -3.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -3.4268F, -3.1669F, 0.4363F, 0.0F, 0.0F));

		ModelPartData lfarmblister4 = left_arm.addChild("lfarmblister4", ModelPartBuilder.create().uv(170, 153).cuboid(-3.0F, -4.4268F, -3.1669F, 8.0F, 9.0F, 9.0F, new Dilation(0.0F))
				.uv(172, 62).cuboid(2.0F, -6.4268F, -0.1669F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(104, 142).cuboid(-1.0F, 1.5732F, -5.1669F, 8.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 26.4268F, -2.8331F, -1.0961F, 0.9286F, -1.0832F));

		ModelPartData cube_r19 = lfarmblister4.addChild("cube_r19", ModelPartBuilder.create().uv(87, 190).cuboid(8.0F, 6.0F, 3.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(182, 24).cuboid(7.0F, -2.0F, -4.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F))
				.uv(30, 168).cuboid(1.0F, 2.0F, -3.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -3.4268F, -3.1669F, 0.4363F, 0.0F, 0.0F));

		ModelPartData bone3 = left_arm.addChild("bone3", ModelPartBuilder.create().uv(170, 153).cuboid(-4.8333F, -3.4754F, -6.1219F, 8.0F, 9.0F, 9.0F, new Dilation(0.0F))
				.uv(172, 62).cuboid(0.1667F, -5.4754F, -6.1219F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(6.8333F, 20.4754F, 9.1219F, -0.2206F, -0.3207F, 0.4994F));

		ModelPartData cube_r20 = bone3.addChild("cube_r20", ModelPartBuilder.create().uv(172, 62).cuboid(-5.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(3.1667F, 1.5246F, -10.6219F, 0.0F, 1.4835F, 0.0F));

		ModelPartData cube_r21 = bone3.addChild("cube_r21", ModelPartBuilder.create().uv(87, 190).cuboid(8.0F, 6.0F, 3.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-12.8333F, -2.4754F, -6.1219F, 0.4363F, 0.0F, 0.0F));

		ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(70, 173).cuboid(-5.0F, 22.0F, 1.0F, 9.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.origin(12.0F, -1.0F, 20.0F));

		ModelPartData cube_r22 = left_leg.addChild("cube_r22", ModelPartBuilder.create().uv(166, 0).cuboid(3.0F, -4.0F, -1.0F, 9.0F, 16.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 14.0F, 1.0F, 0.4363F, 0.0F, 0.0F));

		ModelPartData cube_r23 = left_leg.addChild("cube_r23", ModelPartBuilder.create().uv(62, 142).cuboid(-4.0F, -6.6533F, -10.2527F, 13.0F, 15.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData blisterleg = left_leg.addChild("blisterleg", ModelPartBuilder.create().uv(170, 153).cuboid(8.0F, -1.0F, 0.0F, 8.0F, 9.0F, 9.0F, new Dilation(0.0F))
				.uv(172, 62).cuboid(13.0F, -3.0F, 3.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(104, 142).cuboid(10.0F, 5.0F, -2.0F, 8.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(-8.0F, 14.0F, 1.0F));

		ModelPartData cube_r24 = blisterleg.addChild("cube_r24", ModelPartBuilder.create().uv(87, 190).cuboid(8.0F, 6.0F, 3.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(182, 24).cuboid(7.0F, -2.0F, -4.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F))
				.uv(30, 168).cuboid(1.0F, 2.0F, -3.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(172, 50).cuboid(-4.0F, 24.0F, -6.0F, 8.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.origin(-13.0F, -1.0F, 20.0F));

		ModelPartData cube_r25 = right_leg.addChild("cube_r25", ModelPartBuilder.create().uv(0, 0).cuboid(-10.0F, -24.0F, -4.0F, 11.0F, 18.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 17.0F, -6.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r26 = right_leg.addChild("cube_r26", ModelPartBuilder.create().uv(0, 71).cuboid(-8.0F, -6.0F, 1.0F, 8.0F, 15.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 17.0F, -6.0F, 0.1745F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 256, 256);
	}

    @Override
    public void setAngles(MutantBruteEntityRenderState renderState) {
		this.head.yaw = renderState.relativeHeadYaw / (180F / (float)Math.PI);
		this.head.pitch = renderState.pitch / (180F / (float)Math.PI);
		this.right_arm.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * 1.0F * renderState.limbSwingAmplitude;
		this.left_leg.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * -1.0F * renderState.limbSwingAmplitude;
		this.left_arm.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * -1.0F * renderState.limbSwingAmplitude;
		this.right_leg.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * 1.0F * renderState.limbSwingAmplitude;
	}
}