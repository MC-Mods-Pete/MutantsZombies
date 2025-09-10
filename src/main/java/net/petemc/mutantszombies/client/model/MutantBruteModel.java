package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.state.MutantBruteEntityRenderState;
import org.jetbrains.annotations.NotNull;

public class MutantBruteModel extends EntityModel<MutantBruteEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "mutant_brute"), "main");
	private final ModelPart head;
	//private final ModelPart blisterhead;
	//private final ModelPart Minihead;
	private final ModelPart torso;
	//private final ModelPart blistertorso;
	//private final ModelPart bone;
	private final ModelPart right_arm;
	//private final ModelPart left_arm2;
	//private final ModelPart blisterarm;
	private final ModelPart left_arm;
	//private final ModelPart lfarmblister;
	//private final ModelPart bone2;
	//private final ModelPart lfarmblister3;
	//private final ModelPart lfarmblister2;
	//private final ModelPart lfarmblister4;
	//private final ModelPart bone3;
	private final ModelPart left_leg;
	//private final ModelPart blisterleg;
	private final ModelPart right_leg;

	public MutantBruteModel(ModelPart root) {
        super(root);
		this.head = root.getChild("head");
		//this.blisterhead = root.getChild("blisterhead");
		//this.Minihead = root.getChild("Minihead");
		this.torso = root.getChild("torso");
		//this.blistertorso = root.getChild("blistertorso");
		//this.bone = root.getChild("bone");
		this.right_arm = root.getChild("right_arm");
		//this.left_arm2 = root.getChild("left_arm2");
		//this.blisterarm = root.getChild("blisterarm");
		this.left_arm = root.getChild("left_arm");
		//this.lfarmblister = root.getChild("lfarmblister");
		//this.bone2 = root.getChild("bone2");
		//this.lfarmblister3 = root.getChild("lfarmblister3");
		//this.lfarmblister2 = root.getChild("lfarmblister2");
		//this.lfarmblister4 = root.getChild("lfarmblister4");
		//this.bone3 = root.getChild("bone3");
		this.left_leg = root.getChild("left_leg");
		//this.blisterleg = root.getChild("blisterleg");
		this.right_leg = root.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(1.0F, -23.0F, -26.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 34).addBox(9.0F, -4.4971F, -8.5555F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(37, 8).addBox(8.0F, -2.4971F, -8.5555F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 39).addBox(1.0F, -3.4971F, -8.5555F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(142, 107).addBox(-1.0F, -1.4971F, -9.5555F, 13.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 6.0F, -3.0F, 0.2558F, -0.0393F, 0.303F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.3946F, -9.0389F, -0.2208F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 10.0F, -8.0F, -0.006F, -0.0393F, 0.303F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 0).addBox(-0.5979F, -9.3484F, -1.0484F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 10.0F, -4.0F, 0.2516F, -0.0612F, 0.3876F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 0).addBox(-0.6605F, -9.7518F, 0.0047F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 11.0F, -10.0F, 0.2455F, -0.0827F, 0.4724F));

		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(27, 36).addBox(1.0F, -32.0F, -46.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(31, 36).addBox(-3.0F, -32.0F, -46.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(37, 0).addBox(5.0F, -32.0F, -46.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(37, 4).addBox(6.0F, -33.0F, -46.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(113, 50).addBox(-6.0F, -44.0F, -47.0F, 19.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 39.0F, 26.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition blisterhead = head.addOrReplaceChild("blisterhead", CubeListBuilder.create(), PartPose.offset(-1.0F, 39.0F, 26.0F));

		PartDefinition cube_r6 = blisterhead.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(189, 189).addBox(10.0F, -35.0F, -46.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(134, 41).addBox(13.0F, -36.0F, -44.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(149, 0).addBox(11.0F, -45.0F, -42.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(70, 185).addBox(3.0F, -47.0F, -49.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 75).addBox(7.0F, -48.0F, -48.0F, 7.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Minihead = head.addOrReplaceChild("Minihead", CubeListBuilder.create().texOffs(150, 25).addBox(-5.0F, -8.0F, -15.0F, 8.0F, 9.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(40, 7).addBox(-4.0F, 1.0F, -14.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 4.0F, 2.0F));

		PartDefinition cube_r7 = Minihead.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 41).addBox(3.0F, -0.6019F, -9.0736F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 41).addBox(4.0F, -1.6019F, -9.0736F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 37).addBox(-4.0F, -0.6019F, -3.0736F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(27, 29).addBox(-4.0F, -1.6019F, -6.0736F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 38).addBox(0.0F, -0.6019F, -9.0736F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 29).addBox(-3.0F, 0.3981F, -10.0736F, 8.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, -5.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(79, 84).addBox(-16.0F, -49.0F, -15.0F, 13.0F, 21.0F, 37.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.0F, -55.0F, -15.0F, 23.0F, 27.0F, 44.0F, new CubeDeformation(0.0F))
				.texOffs(0, 71).addBox(-13.0F, -38.0F, 4.0F, 25.0F, 17.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -13.0F));

		PartDefinition blistertorso = torso.addOrReplaceChild("blistertorso", CubeListBuilder.create().texOffs(142, 84).addBox(10.0F, -40.0F, 21.0F, 12.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 121).addBox(14.0F, -43.0F, 29.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 29).addBox(17.0F, -42.0F, 29.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(90, 8).addBox(20.0F, -43.0F, 23.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(62, 136).addBox(7.0F, -39.0F, 29.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(179, 84).addBox(17.0F, -39.0F, 29.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(172, 184).addBox(14.0F, -32.0F, 29.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(27, 29).addBox(18.0F, -31.0F, 26.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(90, 0).addBox(20.0F, -32.0F, 19.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition cube_r8 = blistertorso.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(179, 107).addBox(32.0F, -7.0F, -4.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 129).addBox(24.0F, 1.0F, -12.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(128, 180).addBox(28.0F, 0.0F, -15.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(150, 180).addBox(30.0F, -4.0F, -14.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(179, 120).addBox(34.0F, -5.0F, -8.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(47, 121).addBox(28.0F, -2.0F, 1.0F, 9.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(170, 133).addBox(28.0F, -8.0F, -12.0F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -35.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone = blistertorso.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r9 = bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(83, 93).addBox(8.0F, -34.0F, 25.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 94).addBox(9.0F, -37.0F, 25.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(142, 84).addBox(9.0F, -40.0F, 19.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(122, 191).addBox(13.0F, -41.0F, 19.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(170, 171).addBox(4.0F, -38.0F, 21.0F, 11.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6545F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-16.0F, -17.0F, -19.0F));

		PartDefinition cube_r10 = right_arm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 168).addBox(-4.0F, 0.0F, -3.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 6.0F, -3.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition left_arm2 = right_arm.addOrReplaceChild("left_arm2", CubeListBuilder.create(), PartPose.offset(-7.0F, 6.0F, -3.0F));

		PartDefinition cube_r11 = left_arm2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(40, 168).addBox(18.0F, 16.0F, 6.0F, 6.0F, 27.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -8.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r12 = left_arm2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(120, 142).addBox(16.0F, -3.0F, -4.0F, 13.0F, 26.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -8.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition blisterarm = right_arm.addOrReplaceChild("blisterarm", CubeListBuilder.create(), PartPose.offset(16.0F, -2.0F, -3.0F));

		PartDefinition cube_r13 = blisterarm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(106, 173).addBox(-18.0F, 14.0F, 7.0F, 3.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(20.0F, -17.0F, -15.0F));

		PartDefinition cube_r14 = left_arm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 121).addBox(14.0F, 11.0F, 2.0F, 16.0F, 32.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -2.0F, 1.0F, -0.1355F, 0.2595F, -0.035F));

		PartDefinition cube_r15 = left_arm.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(90, 0).addBox(13.0F, -6.0F, -10.0F, 21.0F, 24.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -2.0F, 1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition lfarmblister = left_arm.addOrReplaceChild("lfarmblister", CubeListBuilder.create().texOffs(142, 84).addBox(-7.6667F, -4.4444F, -7.6111F, 12.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 121).addBox(-3.6667F, -7.4444F, 0.3889F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 29).addBox(-0.6667F, -6.4444F, 0.3889F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(179, 84).addBox(-0.6667F, -3.4444F, 0.3889F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(172, 184).addBox(-3.6667F, 3.5556F, 0.3889F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(27, 29).addBox(0.3333F, 4.5556F, -2.6111F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(62, 136).addBox(-10.6667F, -3.4444F, 0.3889F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(90, 0).addBox(2.3333F, 3.5556F, -9.6111F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(90, 8).addBox(2.3333F, -7.4444F, -5.6111F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.6667F, 36.4444F, 3.6111F, -2.6517F, -0.1932F, -0.102F));

		PartDefinition cube_r16 = lfarmblister.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(128, 180).addBox(-19.1562F, -4.8107F, -12.9969F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(150, 180).addBox(-17.1562F, -8.8107F, -11.9969F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(179, 120).addBox(-13.1562F, -9.8107F, -5.9969F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(179, 107).addBox(-15.1562F, -11.8107F, -1.9969F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4896F, 24.8529F, 12.9747F, 0.8494F, -0.5163F, 0.4707F));

		PartDefinition bone2 = left_arm.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5262F, 33.2F, 9.6814F, -1.0036F, 0.3747F, 0.2291F));

		PartDefinition cube_r17 = bone2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(83, 93).addBox(8.0F, -34.0F, 25.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 94).addBox(9.0F, -37.0F, 25.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(142, 84).addBox(9.0F, -40.0F, 19.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(122, 191).addBox(13.0F, -41.0F, 19.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(170, 171).addBox(4.0F, -38.0F, 21.0F, 11.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4738F, 35.8F, -26.6814F, 0.0F, -0.6545F, 0.0F));

		PartDefinition lfarmblister3 = left_arm.addOrReplaceChild("lfarmblister3", CubeListBuilder.create().texOffs(142, 84).addBox(-7.6667F, -4.4444F, -7.6111F, 12.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 121).addBox(-3.6667F, -7.4444F, 0.3889F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 29).addBox(-0.6667F, -6.4444F, 0.3889F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(179, 84).addBox(-0.6667F, -3.4444F, 0.3889F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(172, 184).addBox(-3.6667F, 3.5556F, 0.3889F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(27, 29).addBox(0.3333F, 4.5556F, -2.6111F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(62, 136).addBox(-10.6667F, -3.4444F, 0.3889F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(90, 0).addBox(2.3333F, 3.5556F, -9.6111F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(90, 8).addBox(2.3333F, -7.4444F, -5.6111F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.6667F, 33.4444F, -5.3889F, 2.5406F, -0.1932F, -0.102F));

		PartDefinition lfarmblister2 = left_arm.addOrReplaceChild("lfarmblister2", CubeListBuilder.create().texOffs(170, 153).addBox(-3.0F, -4.4268F, -3.1669F, 8.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(172, 62).addBox(2.0F, -6.4268F, -0.1669F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(104, 142).addBox(-1.0F, 1.5732F, -5.1669F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 33.4268F, -2.8331F, 0.0F, 1.5272F, 0.0F));

		PartDefinition cube_r18 = lfarmblister2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(87, 190).addBox(8.0F, 6.0F, 3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(182, 24).addBox(7.0F, -2.0F, -4.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(30, 168).addBox(1.0F, 2.0F, -3.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -3.4268F, -3.1669F, 0.4363F, 0.0F, 0.0F));

		PartDefinition lfarmblister4 = left_arm.addOrReplaceChild("lfarmblister4", CubeListBuilder.create().texOffs(170, 153).addBox(-3.0F, -4.4268F, -3.1669F, 8.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(172, 62).addBox(2.0F, -6.4268F, -0.1669F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(104, 142).addBox(-1.0F, 1.5732F, -5.1669F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 26.4268F, -2.8331F, -1.0961F, 0.9286F, -1.0832F));

		PartDefinition cube_r19 = lfarmblister4.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(87, 190).addBox(8.0F, 6.0F, 3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(182, 24).addBox(7.0F, -2.0F, -4.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(30, 168).addBox(1.0F, 2.0F, -3.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -3.4268F, -3.1669F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bone3 = left_arm.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(170, 153).addBox(-4.8333F, -3.4754F, -6.1219F, 8.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(172, 62).addBox(0.1667F, -5.4754F, -6.1219F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8333F, 20.4754F, 9.1219F, -0.2206F, -0.3207F, 0.4994F));

		PartDefinition cube_r20 = bone3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(172, 62).addBox(-5.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1667F, 1.5246F, -10.6219F, 0.0F, 1.4835F, 0.0F));

		PartDefinition cube_r21 = bone3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(87, 190).addBox(8.0F, 6.0F, 3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.8333F, -2.4754F, -6.1219F, 0.4363F, 0.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(70, 173).addBox(-5.0F, 22.0F, 1.0F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -1.0F, 20.0F));

		PartDefinition cube_r22 = left_leg.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(166, 0).addBox(3.0F, -4.0F, -1.0F, 9.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 14.0F, 1.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r23 = left_leg.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(62, 142).addBox(-4.0F, -6.6533F, -10.2527F, 13.0F, 15.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition blisterleg = left_leg.addOrReplaceChild("blisterleg", CubeListBuilder.create().texOffs(170, 153).addBox(8.0F, -1.0F, 0.0F, 8.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(172, 62).addBox(13.0F, -3.0F, 3.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(104, 142).addBox(10.0F, 5.0F, -2.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 14.0F, 1.0F));

		PartDefinition cube_r24 = blisterleg.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(87, 190).addBox(8.0F, 6.0F, 3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(182, 24).addBox(7.0F, -2.0F, -4.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(30, 168).addBox(1.0F, 2.0F, -3.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(172, 50).addBox(-4.0F, 24.0F, -6.0F, 8.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -1.0F, 20.0F));

		PartDefinition cube_r25 = right_leg.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -24.0F, -4.0F, 11.0F, 18.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 17.0F, -6.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r26 = right_leg.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 71).addBox(-8.0F, -6.0F, 1.0F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 17.0F, -6.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

    @Override
    public void setupAnim(@NotNull MutantBruteEntityRenderState renderState) {
		this.head.yRot = renderState.yRot / (180F / (float)Math.PI);
		this.head.xRot = renderState.xRot / (180F / (float)Math.PI);
		this.right_arm.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * 1.0F * renderState.walkAnimationSpeed;
		this.left_leg.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * -1.0F * renderState.walkAnimationSpeed;
		this.left_arm.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * -1.0F * renderState.walkAnimationSpeed;
		this.right_leg.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * 1.0F * renderState.walkAnimationSpeed;
	}
}
