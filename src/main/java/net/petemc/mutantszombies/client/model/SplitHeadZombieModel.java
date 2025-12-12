package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.state.SplitHeadZombieEntityRenderState;
import org.jetbrains.annotations.NotNull;

public class SplitHeadZombieModel extends EntityModel<SplitHeadZombieEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "split_head_zombie"), "main");
	private final ModelPart head1;
	//private final ModelPart bone3;
	private final ModelPart head2;
	//private final ModelPart bone4;
	private final ModelPart torso;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public SplitHeadZombieModel(ModelPart root) {
        super(root);
		this.head1 = root.getChild("head1");
		//this.bone3 = root.getChild("bone3");
		this.head2 = root.getChild("head2");
		//this.bone4 = root.getChild("bone4");
		this.torso = root.getChild("torso");
		this.left_leg = root.getChild("leftleg");
		this.right_leg = root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head1 = partdefinition.addOrReplaceChild("head1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, 2.5F, 2.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r1 = head1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 18).addBox(4.1724F, -2.9897F, -4.7701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 29).addBox(4.1724F, -6.9897F, -0.7701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 5).addBox(4.1724F, -3.9897F, -0.7701F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 18).addBox(4.1724F, -3.9897F, -2.7701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 55).addBox(4.1724F, -4.9897F, 0.2299F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 37).addBox(4.1724F, -5.9897F, -3.7701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(4.1724F, -5.9897F, -1.7701F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 13).addBox(4.1724F, -4.9897F, -4.7701F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(45, 30).addBox(4.1724F, -6.9897F, 0.2299F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 44).addBox(4.1724F, -6.9897F, -4.7701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 21).addBox(2.4224F, -2.2397F, -3.2701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(0.4224F, -2.7397F, -3.2701F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 56).addBox(-0.5776F, -2.4897F, -3.2701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-1.8276F, -6.9897F, -4.7701F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3855F, -8.7303F, -4.5F, -0.1433F, 0.0571F, -0.3029F));

		PartDefinition cube_r2 = head1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 39).addBox(3.4964F, -0.009F, -2.3775F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 53).addBox(3.4964F, 2.991F, 1.6225F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 53).addBox(3.4964F, 1.991F, -1.3775F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 25).addBox(3.4964F, 0.991F, 1.6225F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 27).addBox(3.4964F, -0.009F, 0.6225F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 53).addBox(3.4964F, -1.009F, -1.3775F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 23).addBox(3.4964F, 4.991F, 1.6225F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 2).addBox(3.4964F, 2.991F, -0.3775F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(43, 24).addBox(3.4964F, 0.991F, -0.3775F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(3.4964F, -1.009F, 0.6225F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(0.4964F, -1.259F, -2.1275F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 51).addBox(1.9964F, -1.259F, -2.1275F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 25).addBox(-1.2536F, -1.759F, -2.1275F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 32).addBox(-1.5036F, -1.009F, -2.3775F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9855F, -9.0803F, -4.5F, 0.8166F, 0.0571F, -0.3029F));

		PartDefinition bone3 = head1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.6355F, 5.5197F, -0.25F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(53, 28).addBox(1.0519F, -2.1027F, 3.7548F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(43, 1).addBox(1.8013F, -4.1012F, 6.4378F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 44).addBox(1.8013F, -2.6012F, 6.4378F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 46).addBox(1.8013F, -1.1012F, 6.4378F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 19).addBox(-3.1128F, -6.1985F, -0.0299F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(12, 37).addBox(1.8872F, -2.9485F, 0.2201F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 15).addBox(1.8872F, -2.9485F, 2.9701F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 34).addBox(1.8872F, -4.9485F, 1.4701F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 0).addBox(1.8872F, -4.9485F, 5.4701F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 17).addBox(1.8872F, -5.9485F, 3.4701F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(51, 50).addBox(-4.1128F, -3.1985F, 1.9701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 13).addBox(-5.1128F, -5.1985F, 2.9701F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(51, 52).addBox(-4.1128F, -4.1985F, 3.9701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 45).addBox(-4.1128F, -5.1985F, 1.9701F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, -2.75F, 0.1747F, 0.043F, 0.0076F));

		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(0.5F, 2.25F, 2.0F));

		PartDefinition cube_r4 = head2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(28, 47).addBox(0.9811F, 4.0112F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.15F, -10.1F, -4.0F, 0.9002F, 0.0829F, -0.3843F));

		PartDefinition cube_r5 = head2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 23).addBox(-3.5637F, -0.5999F, -0.919F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 32).addBox(-2.5637F, -3.5999F, -3.919F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(-2.5637F, -2.5999F, -4.919F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 45).addBox(-3.5637F, -1.5999F, -4.919F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 12).addBox(-2.5637F, -2.5999F, -3.919F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(47, 44).addBox(-3.5637F, -4.5999F, -3.919F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 14).addBox(-2.5637F, -4.5999F, -2.919F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 55).addBox(-2.5637F, -0.5999F, -2.919F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(47, 46).addBox(-3.5637F, -2.5999F, -1.919F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 16).addBox(-2.5637F, -2.5999F, -0.919F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 49).addBox(-2.5637F, -1.5999F, 0.081F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 32).addBox(-4.5637F, -3.5999F, 0.081F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 11).addBox(-3.5637F, -4.5999F, -0.919F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 56).addBox(2.1863F, 0.4001F, -3.419F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 23).addBox(0.9363F, -0.0999F, -3.419F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 56).addBox(-1.0637F, -0.0999F, -3.419F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 7).addBox(-1.5637F, -4.5999F, -4.919F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, -10.0F, -4.0F, 0.0275F, -0.0829F, 0.3843F));

		PartDefinition cube_r6 = head2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(54, 47).addBox(-2.0003F, 1.9651F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 53).addBox(-2.0003F, 0.9651F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 34).addBox(-2.0003F, 4.9651F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).addBox(-2.0003F, 1.9651F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(45, 28).addBox(-3.0003F, 4.9651F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(33, 46).addBox(-3.0003F, 2.9651F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-3.0003F, 2.9651F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-3.0003F, -0.0349F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 55).addBox(-2.0003F, 0.9651F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(53, 30).addBox(2.4997F, -0.5349F, -3.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(51, 54).addBox(-0.5003F, -0.5349F, -3.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(39, 32).addBox(-1.0003F, -0.0349F, -4.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.35F, -10.05F, -4.0F, 0.7693F, -0.0829F, 0.3843F));

		PartDefinition bone4 = head2.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 6.75F, -1.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition cube_r7 = bone4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(38, 20).addBox(-1.7326F, -1.5998F, 6.3278F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 39).addBox(-1.7326F, -3.0998F, 6.3278F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 5).addBox(-1.7326F, -4.5998F, 6.3278F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(53, 22).addBox(-0.9229F, -2.5677F, 3.707F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(53, 26).addBox(-2.6467F, -6.6971F, 2.8601F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 53).addBox(-2.6467F, -2.6971F, 5.8601F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(53, 20).addBox(-2.6467F, -4.6971F, 3.8601F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-3.6467F, -3.6971F, 4.8601F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-3.6467F, -6.6971F, 5.8601F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(51, 48).addBox(-2.6467F, -4.6971F, -0.1399F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-1.6467F, -6.6971F, -0.1399F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -2.0F, 0.1747F, 0.043F, 0.0948F));

		PartDefinition cube_r8 = bone4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(53, 24).addBox(1.0771F, -3.8177F, 0.207F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 55).addBox(1.3533F, -3.6971F, 2.8601F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 0).addBox(1.3533F, -5.6971F, 2.8601F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(45, 26).addBox(1.3533F, -5.6971F, 0.8601F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 2).addBox(1.3533F, -6.6971F, 1.8601F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -6.0F, -1.0F, 0.1747F, 0.043F, 0.0948F));

		PartDefinition cube_r9 = bone4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-0.8559F, -2.235F, -3.2203F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -5.1974F, 0.206F, -1.0076F, 0.0749F, -0.0202F));
		PartDefinition cube_r10 = bone4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 3).addBox(-0.8559F, 2.0142F, -4.3678F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -5.1974F, 0.206F, -2.1857F, 0.0749F, -0.0202F));
		PartDefinition cube_r11 = bone4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(19, 15).addBox(-0.8559F, -1.1463F, -7.0477F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -5.1974F, 0.206F, -1.4876F, 0.0749F, -0.0202F));
		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 3.0F));

		PartDefinition cube_r12 = torso.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(44, 11).addBox(-0.5F, -14.25F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.5F, -14.0F, -0.5F, 10.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, -3.0F, 0.0F, 0.0873F, 0.0F));
		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, 7.5F, 0.5F, -0.2618F, -0.2182F, 0.0F));
		PartDefinition cube_r13 = leftleg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(38, 18).addBox(1.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7026F, 16.192F, 1.4063F, 0.3054F, 0.0F, 0.0F));
		PartDefinition cube_r14 = leftleg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(35, 44).addBox(1.0F, -9.25F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7026F, 9.192F, 1.4063F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r15 = leftleg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(16, 45).addBox(1.0F, 0.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7026F, 9.192F, 1.4063F, 0.6109F, 0.0F, 0.0F));
		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(26, 0).addBox(-2.3154F, 14.5F, -3.4603F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, 8.5F, 2.0F, 0.0F, 0.4363F, 0.0F));
		PartDefinition cube_r16 = rightleg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(44, 0).addBox(-5.0F, 0.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6846F, 8.5F, -2.4603F, 0.6109F, 0.0F, 0.0F));
		PartDefinition cube_r17 = rightleg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 37).addBox(-5.0F, -9.25F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6846F, 8.5F, -2.4603F, -0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public void setupAnim(@NotNull SplitHeadZombieEntityRenderState renderState) {
		this.head1.yRot = renderState.yRot / (180F / (float)Math.PI);
		this.head1.xRot = renderState.xRot / (180F / (float)Math.PI);
		this.head2.yRot = renderState.yRot / (180F / (float)Math.PI);
		this.head2.xRot = renderState.xRot / (180F / (float)Math.PI);
		//this.right_arm.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * 1.0F * renderState.walkAnimationSpeed;
		this.left_leg.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * -1.0F * renderState.walkAnimationSpeed;
		//this.left_arm.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * -1.0F * renderState.walkAnimationSpeed;
		this.right_leg.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * 1.0F * renderState.walkAnimationSpeed;
	}
}
