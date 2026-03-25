package net.petemc.mutantszombies.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.petemc.mutantszombies.MutantsZombies;

public class RottenMutantModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MutantsZombies.MOD_ID, "rotten_mutant_layer"), "main");
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart metalrods;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public RottenMutantModel(ModelPart root) {
        this.head = root.getChild("head");
        this.torso = root.getChild("torso");
        this.metalrods = this.torso.getChild("metalrods");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.5F, -4.5F, -0.1274F, 0.0F, 0.0436F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(15, 106).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.85F, -1.675F, -3.075F, 0.0F, -0.4363F, 1.5708F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(18, 31).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -6.5F, -0.15F, -0.436F, 0.0184F, -3.102F));

        PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(21, 105).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.5F, -4.5F, 0.0F, -0.4363F, 1.5708F));

        PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(7, 101).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -4.25F, -2.0F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(35, 27).addBox(4.0F, -1.0F, -5.0F, 0.5F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.25F, -8.975F, 0.3745F, -1.0204F, 0.1668F));

        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(1, 97).addBox(-4.5468F, -10.2426F, -10.5803F, 9.0F, 9.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 3.4451F, -4.1885F, -1.0908F, 0.0F, 0.0F));

        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 1.0F));

        PartDefinition cube_r7 = torso.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -13.9403F, -5.0F, 12.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r8 = torso.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 83).addBox(0.5F, -0.1856F, 1.1898F, 7.0F, 6.0F, 7.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-4.0F, -15.2903F, -10.903F, 0.3491F, 0.0F, 0.0F));

        PartDefinition metalrods = torso.addOrReplaceChild("metalrods", CubeListBuilder.create().texOffs(35, 27).addBox(4.0F, 1.25F, -5.0F, 0.5F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -14.0F));

        PartDefinition cube_r9 = metalrods.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(32, 24).addBox(-4.5F, -1.0F, -7.0F, 0.5F, 1.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0173F, 0.192F, -0.1791F));

        PartDefinition cube_r10 = metalrods.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(73, 0).addBox(-5.5F, -1.0F, -4.0F, 0.5F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.176F, 0.1289F, -0.0229F));

        PartDefinition cube_r11 = metalrods.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(61, 43).addBox(-4.5F, -3.7F, -7.0F, 0.5F, 0.7F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 7.0F, 3.25F, -0.3054F, 0.0F, 0.0F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(6.0F, -7.0F, -3.0F));

        PartDefinition cube_r12 = left_arm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(32, 67).addBox(0.0F, 6.0F, -2.75F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 11.75F, -5.75F, 1.5371F, 0.1248F, 0.2446F));

        PartDefinition cube_r13 = left_arm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(31, 11).addBox(0.0F, 1.0F, -9.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.0F, -2.0F, 1.7975F, 0.4542F, -0.4509F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-6.0F, -7.0F, -3.0F));

        PartDefinition cube_r14 = right_arm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(70, 20).addBox(-4.7F, -1.0F, -2.723F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.825F, 11.0F, -6.0F, 1.0898F, -0.3133F, -0.0098F));

        PartDefinition cube_r15 = right_arm.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 38).addBox(-4.0F, -1.0F, -9.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, 1.0036F, 0.0F, 0.5236F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(17, 38).addBox(-2.075F, 14.0F, -4.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offset(3.0F, 4.0F, 0.0F));

        PartDefinition cube_r16 = left_leg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(74, 55).addBox(-6.1F, -8.6F, -2.1F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(4.0F, 7.0F, -1.0F, -0.1749F, -0.0058F, 0.0013F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-3.0F, 3.0F, 0.0F));

        PartDefinition cube_r17 = right_leg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 28).addBox(-6.5F, -7.0F, -2.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(3.5F, 20.675F, -1.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r18 = right_leg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(29, 78).addBox(-5.0F, -10.5554F, -2.3915F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(2.225F, 9.0F, -0.5F, -0.1279F, 0.0093F, 0.0902F));

        return LayerDefinition.create(meshdefinition, 128, 128);
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
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.head.xRot = headPitch / (180F / (float)Math.PI);
        this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.xRot = Mth.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}