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
import net.petemc.mutantszombies.client.state.SplitHeadZombieEntityRenderState;

public class SplitHeadZombieModel extends EntityModel<SplitHeadZombieEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of(MutantsZombies.MOD_ID, "split_head_zombie"), "main");
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

	public static TexturedModelData createBodyLayer() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData head1 = modelPartData.addChild("head1", ModelPartBuilder.create(), ModelTransform.of(0.75F, 2.5F, 2.0F, 0.0F, 0.0F, -0.2182F));

		ModelPartData cube_r1 = head1.addChild("cube_r1", ModelPartBuilder.create().uv(38, 18).cuboid(4.1724F, -2.9897F, -4.7701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 29).cuboid(4.1724F, -6.9897F, -0.7701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 5).cuboid(4.1724F, -3.9897F, -0.7701F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(55, 18).cuboid(4.1724F, -3.9897F, -2.7701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 55).cuboid(4.1724F, -4.9897F, 0.2299F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 37).cuboid(4.1724F, -5.9897F, -3.7701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 13).cuboid(4.1724F, -5.9897F, -1.7701F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 13).cuboid(4.1724F, -4.9897F, -4.7701F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(45, 30).cuboid(4.1724F, -6.9897F, 0.2299F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(55, 44).cuboid(4.1724F, -6.9897F, -4.7701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 21).cuboid(2.4224F, -2.2397F, -3.2701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(26, 0).cuboid(0.4224F, -2.7397F, -3.2701F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(23, 56).cuboid(-0.5776F, -2.4897F, -3.2701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(-1.8276F, -6.9897F, -4.7701F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-6.3855F, -8.7303F, -4.5F, -0.1433F, 0.0571F, -0.3029F));

		ModelPartData cube_r2 = head1.addChild("cube_r2", ModelPartBuilder.create().uv(12, 39).cuboid(3.4964F, -0.009F, -2.3775F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 53).cuboid(3.4964F, 2.991F, 1.6225F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 53).cuboid(3.4964F, 1.991F, -1.3775F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 25).cuboid(3.4964F, 0.991F, 1.6225F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 27).cuboid(3.4964F, -0.009F, 0.6225F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 53).cuboid(3.4964F, -1.009F, -1.3775F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(38, 23).cuboid(3.4964F, 4.991F, 1.6225F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(38, 2).cuboid(3.4964F, 2.991F, -0.3775F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(43, 24).cuboid(3.4964F, 0.991F, -0.3775F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 30).cuboid(3.4964F, -1.009F, 0.6225F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 19).cuboid(0.4964F, -1.259F, -2.1275F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(54, 51).cuboid(1.9964F, -1.259F, -2.1275F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 25).cuboid(-1.2536F, -1.759F, -2.1275F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 32).cuboid(-1.5036F, -1.009F, -2.3775F, 5.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-5.9855F, -9.0803F, -4.5F, 0.8166F, 0.0571F, -0.3029F));

		ModelPartData bone3 = head1.addChild("bone3", ModelPartBuilder.create(), ModelTransform.of(-1.6355F, 5.5197F, -0.25F, 0.0F, 0.0F, -0.2182F));

		ModelPartData cube_r3 = bone3.addChild("cube_r3", ModelPartBuilder.create().uv(53, 28).cuboid(1.0519F, -2.1027F, 3.7548F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(43, 1).cuboid(1.8013F, -4.1012F, 6.4378F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 44).cuboid(1.8013F, -2.6012F, 6.4378F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 46).cuboid(1.8013F, -1.1012F, 6.4378F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 19).cuboid(-3.1128F, -6.1985F, -0.0299F, 6.0F, 6.0F, 7.0F, new Dilation(0.0F))
		.uv(12, 37).cuboid(1.8872F, -2.9485F, 0.2201F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 15).cuboid(1.8872F, -2.9485F, 2.9701F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 34).cuboid(1.8872F, -4.9485F, 1.4701F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(38, 0).cuboid(1.8872F, -4.9485F, 5.4701F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 17).cuboid(1.8872F, -5.9485F, 3.4701F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 50).cuboid(-4.1128F, -3.1985F, 1.9701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 13).cuboid(-5.1128F, -5.1985F, 2.9701F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 52).cuboid(-4.1128F, -4.1985F, 3.9701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(52, 45).cuboid(-4.1128F, -5.1985F, 1.9701F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.5F, -2.75F, 0.1747F, 0.043F, 0.0076F));

		ModelPartData head2 = modelPartData.addChild("head2", ModelPartBuilder.create(), ModelTransform.origin(0.5F, 2.25F, 2.0F));

		ModelPartData cube_r4 = head2.addChild("cube_r4", ModelPartBuilder.create().uv(28, 47).cuboid(0.9811F, 4.0112F, -4.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.15F, -10.1F, -4.0F, 0.9002F, 0.0829F, -0.3843F));

		ModelPartData cube_r5 = head2.addChild("cube_r5", ModelPartBuilder.create().uv(48, 23).cuboid(-3.5637F, -0.5999F, -0.919F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(54, 32).cuboid(-2.5637F, -3.5999F, -3.919F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 55).cuboid(-2.5637F, -2.5999F, -4.919F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(28, 45).cuboid(-3.5637F, -1.5999F, -4.919F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(55, 12).cuboid(-2.5637F, -2.5999F, -3.919F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(47, 44).cuboid(-3.5637F, -4.5999F, -3.919F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(55, 14).cuboid(-2.5637F, -4.5999F, -2.919F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 55).cuboid(-2.5637F, -0.5999F, -2.919F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(47, 46).cuboid(-3.5637F, -2.5999F, -1.919F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(55, 16).cuboid(-2.5637F, -2.5999F, -0.919F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(54, 49).cuboid(-2.5637F, -1.5999F, 0.081F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 32).cuboid(-4.5637F, -3.5999F, 0.081F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 11).cuboid(-3.5637F, -4.5999F, -0.919F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(15, 56).cuboid(2.1863F, 0.4001F, -3.419F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 23).cuboid(0.9363F, -0.0999F, -3.419F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 56).cuboid(-1.0637F, -0.0999F, -3.419F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(26, 7).cuboid(-1.5637F, -4.5999F, -4.919F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(5.75F, -10.0F, -4.0F, 0.0275F, -0.0829F, 0.3843F));

		ModelPartData cube_r6 = head2.addChild("cube_r6", ModelPartBuilder.create().uv(54, 47).cuboid(-2.0003F, 1.9651F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(54, 53).cuboid(-2.0003F, 0.9651F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(54, 34).cuboid(-2.0003F, 4.9651F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 55).cuboid(-2.0003F, 1.9651F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(45, 28).cuboid(-3.0003F, 4.9651F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(33, 46).cuboid(-3.0003F, 2.9651F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(-3.0003F, 2.9651F, -3.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 28).cuboid(-3.0003F, -0.0349F, -2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 55).cuboid(-2.0003F, 0.9651F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(53, 30).cuboid(2.4997F, -0.5349F, -3.75F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 54).cuboid(-0.5003F, -0.5349F, -3.75F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(39, 32).cuboid(-1.0003F, -0.0349F, -4.0F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(5.35F, -10.05F, -4.0F, 0.7693F, -0.0829F, 0.3843F));

		ModelPartData bone4 = head2.addChild("bone4", ModelPartBuilder.create(), ModelTransform.of(-0.5F, 6.75F, -1.0F, 0.0F, 0.0F, 0.3054F));

		ModelPartData cube_r7 = bone4.addChild("cube_r7", ModelPartBuilder.create().uv(38, 20).cuboid(-1.7326F, -1.5998F, 6.3278F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 39).cuboid(-1.7326F, -3.0998F, 6.3278F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 5).cuboid(-1.7326F, -4.5998F, 6.3278F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(53, 22).cuboid(-0.9229F, -2.5677F, 3.707F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(53, 26).cuboid(-2.6467F, -6.6971F, 2.8601F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 53).cuboid(-2.6467F, -2.6971F, 5.8601F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(53, 20).cuboid(-2.6467F, -4.6971F, 3.8601F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 15).cuboid(-3.6467F, -3.6971F, 4.8601F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 17).cuboid(-3.6467F, -6.6971F, 5.8601F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 48).cuboid(-2.6467F, -4.6971F, -0.1399F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 13).cuboid(-1.6467F, -6.6971F, -0.1399F, 6.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, -2.0F, 0.1747F, 0.043F, 0.0948F));

		ModelPartData cube_r8 = bone4.addChild("cube_r8", ModelPartBuilder.create().uv(53, 24).cuboid(1.0771F, -3.8177F, 0.207F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(54, 55).cuboid(1.3533F, -3.6971F, 2.8601F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 0).cuboid(1.3533F, -5.6971F, 2.8601F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(45, 26).cuboid(1.3533F, -5.6971F, 0.8601F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 2).cuboid(1.3533F, -6.6971F, 1.8601F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -6.0F, -1.0F, 0.1747F, 0.043F, 0.0948F));

		ModelPartData cube_r9 = bone4.addChild("cube_r9", ModelPartBuilder.create().uv(0, 0).cuboid(-0.8559F, -2.235F, -3.2203F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -5.1974F, 0.206F, -1.0076F, 0.0749F, -0.0202F));
		ModelPartData cube_r10 = bone4.addChild("cube_r10", ModelPartBuilder.create().uv(0, 3).cuboid(-0.8559F, 2.0142F, -4.3678F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -5.1974F, 0.206F, -2.1857F, 0.0749F, -0.0202F));
		ModelPartData cube_r11 = bone4.addChild("cube_r11", ModelPartBuilder.create().uv(19, 15).cuboid(-0.8559F, -1.1463F, -7.0477F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -5.1974F, 0.206F, -1.4876F, 0.0749F, -0.0202F));
		ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 3.0F, 3.0F));

		ModelPartData cube_r12 = torso.addChild("cube_r12", ModelPartBuilder.create().uv(44, 11).cuboid(-0.5F, -14.25F, 5.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.5F, -14.0F, -0.5F, 10.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 13.0F, -3.0F, 0.0F, 0.0873F, 0.0F));
		ModelPartData leftleg = modelPartData.addChild("leftleg", ModelPartBuilder.create(), ModelTransform.of(4.5F, 7.5F, 0.5F, -0.2618F, -0.2182F, 0.0F));
		ModelPartData cube_r13 = leftleg.addChild("cube_r13", ModelPartBuilder.create().uv(38, 18).cuboid(1.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.7026F, 16.192F, 1.4063F, 0.3054F, 0.0F, 0.0F));
		ModelPartData cube_r14 = leftleg.addChild("cube_r14", ModelPartBuilder.create().uv(35, 44).cuboid(1.0F, -9.25F, -3.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.7026F, 9.192F, 1.4063F, -0.1309F, 0.0F, 0.0F));
		ModelPartData cube_r15 = leftleg.addChild("cube_r15", ModelPartBuilder.create().uv(16, 45).cuboid(1.0F, 0.0F, -3.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.7026F, 9.192F, 1.4063F, 0.6109F, 0.0F, 0.0F));
		ModelPartData rightleg = modelPartData.addChild("rightleg", ModelPartBuilder.create().uv(26, 0).cuboid(-2.3154F, 14.5F, -3.4603F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, 8.5F, 2.0F, 0.0F, 0.4363F, 0.0F));
		ModelPartData cube_r16 = rightleg.addChild("cube_r16", ModelPartBuilder.create().uv(44, 0).cuboid(-5.0F, 0.0F, -3.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.6846F, 8.5F, -2.4603F, 0.6109F, 0.0F, 0.0F));
		ModelPartData cube_r17 = rightleg.addChild("cube_r17", ModelPartBuilder.create().uv(0, 37).cuboid(-5.0F, -9.25F, -3.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.6846F, 8.5F, -2.4603F, -0.4363F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

    @Override
    public void setAngles(SplitHeadZombieEntityRenderState renderState) {
		this.head1.yaw = renderState.relativeHeadYaw / (180F / (float)Math.PI);
		this.head1.pitch = renderState.pitch / (180F / (float)Math.PI);
		this.head2.yaw = renderState.relativeHeadYaw / (180F / (float)Math.PI);
		this.head2.pitch = renderState.pitch / (180F / (float)Math.PI);
		//this.right_arm.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * 1.0F * renderState.limbSwingAmplitude;
		this.left_leg.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * -1.0F * renderState.limbSwingAmplitude;
		//this.left_arm.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * -1.0F * renderState.limbSwingAmplitude;
		this.right_leg.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * 1.0F * renderState.limbSwingAmplitude;
	}
}