package net.petemc.mutantszombies.client.model;// Made with Blockbench 4.12.6

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.entity.MutantZombieEntity;

public class MutantZombieModel<T extends MutantZombieEntity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MutantsZombies.MOD_ID, "mutant_zombie_layer"), "main");
    private final ModelPart head;
    private final ModelPart teeth;
    private final ModelPart torso;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public MutantZombieModel(ModelPart root) {
        this.head = root.getChild("head");
        this.teeth = this.head.getChild("teeth");
        this.torso = root.getChild("torso");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 1).addBox(-4.0F, -4.75F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, -0.25F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.8F, 0.2F, 0.2182F, 0.0F, 0.0F));

        PartDefinition teeth = head.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(36, 34).addBox(2.5041F, -2.7387F, -0.6681F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 34).addBox(2.4175F, -3.9738F, -0.9991F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 34).addBox(0.7541F, -2.9887F, -0.6681F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 34).addBox(-3.7459F, -3.9887F, -0.9181F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 34).addBox(-0.8325F, -3.9738F, -0.9991F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 34).addBox(-2.3325F, -4.2238F, -0.9991F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 34).addBox(-2.3325F, -2.7238F, -0.9991F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1822F, 4.6388F, -2.0009F, 0.1309F, 0.0F, 0.0F));

        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(12, 11).addBox(-3.0F, -26.0F, -1.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(16, 32).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 2.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 2.0F, 0.0F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.head.xRot = headPitch / (180F / (float)Math.PI);
        this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}