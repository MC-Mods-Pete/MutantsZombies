package net.petemc.mutantszombies.client.model;

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
import net.petemc.mutantszombies.entity.BlisterZombieEntity;

public class BlisterZombieModel<T extends BlisterZombieEntity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "blister_zombie_layer"), "main");
    public final ModelPart head;
    public final ModelPart torso;
    public final ModelPart left_arm;
    public final ModelPart right_arm;
    public final ModelPart left_leg;
    public final ModelPart right_leg;

    public BlisterZombieModel(ModelPart root) {
        this.head = root.getChild("head");
        this.torso = root.getChild("torso");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -9.0F));
        head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(42, 0).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 22).addBox(-5.0F, -6.0F, -8.0F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
        PartDefinition faceplates = head.addOrReplaceChild("faceplates", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -6.0F));
        faceplates.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 0).addBox(0.5F, -1.0F, -5.0F, 0.5F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2057F, 0.3023F, 0.0186F));
        faceplates.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(63, 2).addBox(0.5F, -2.0F, -7.0F, 0.5F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.4983F, 0.7777F, -0.5184F));
        faceplates.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(74, 36).addBox(0.0F, 0.0F, -7.0F, 1.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.6285F, 0.686F, -1.2187F));
        faceplates.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(65, 80).addBox(0.0F, -2.0F, -7.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7475F, 0.5719F, -0.2274F));
        faceplates.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(79, 81).addBox(0.5F, -2.0F, -7.0F, 0.5F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1589F, -0.2725F, 0.2135F));
        faceplates.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(60, 27).addBox(0.0F, -4.0F, -10.0F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1622F, -0.5334F, -0.1392F));
        faceplates.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(21, 50).addBox(0.0F, -5.0F, -10.0F, 1.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -1.0036F, 0.0F));
        PartDefinition sidegrips = head.addOrReplaceChild("sidegrips", CubeListBuilder.create().texOffs(0, 72).addBox(5.0F, -1.0F, -5.0F, 0.5F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));
        sidegrips.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(46, 38).addBox(-5.5F, -1.0F, -9.0F, 0.5F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0173F, 0.192F, -0.1791F));
        sidegrips.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(73, 0).addBox(-5.5F, -1.0F, -6.0F, 0.5F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.176F, 0.1289F, -0.0229F));
        sidegrips.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(61, 43).addBox(-5.5F, -3.7F, -7.0F, 0.5F, 0.7F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));
        sidegrips.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(49, 14).addBox(5.0F, -1.0F, -10.0F, 0.5F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7591F, -0.192F, 0.1791F));
        sidegrips.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(73, 70).addBox(5.0F, -4.0F, -7.0F, 0.5F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 1.0F));
        torso.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -13.9403F, -4.1423F, 12.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));
        torso.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(30, 32).addBox(-4.0F, -14.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, -1.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition backplates = torso.addOrReplaceChild("backplates", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, -1.0F));
        backplates.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(52, 58).addBox(2.0F, -7.0F, -2.0F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));
        backplates.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(63, 65).addBox(3.5F, -6.0F, -2.0F, 0.5F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 1.0472F, 0.0F));
        backplates.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(41, 51).addBox(-1.0F, -4.0F, -2.0F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, -0.0873F, 0.0F));
        backplates.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 57).addBox(-2.5F, -7.0F, -8.0F, 0.5F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0057F, 0.0433F, 0.131F));
        backplates.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(47, 74).addBox(-3.75F, -3.0F, -2.0F, 0.75F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.48F, 0.0F));
        backplates.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(13, 67).addBox(2.5F, -1.0F, -2.0F, 0.5F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0607F, 0.116F, -0.4835F));
        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(6.0F, -4.0F, -6.0F));
        left_arm.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(33, 67).addBox(1.0F, 3.8813F, -4.723F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 8.0F, -5.0F, 1.5007F, 0.1367F, 0.6339F));
        left_arm.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(31, 11).addBox(0.0F, -2.0F, -11.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 1.5901F, 0.3093F, -0.4295F));
        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-6.0F, -4.0F, -5.0F));
        right_arm.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(71, 20).addBox(-5.0F, -1.6187F, -4.723F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 8.0F, -4.0F, 1.0898F, -0.3133F, -0.0098F));
        right_arm.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 38).addBox(-4.0F, -2.0F, -11.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 1.0036F, 0.0F, 0.5236F));
        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(19, 38).addBox(0.0F, 6.0F, -8.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 1.0F));
        left_leg.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(74, 55).addBox(-6.0F, 0.3983F, -2.0908F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -1.0F, 0.0F, -0.7418F, 0.0F, 0.0F));
        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-3.0F, 12.0F, 1.0F));
        right_leg.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 38).addBox(-6.0F, -7.0F, -2.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
        right_leg.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(29, 78).addBox(-5.0F, -0.5554F, -2.3915F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, -0.2612F, 0.2699F, 0.1488F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.head.xRot = headPitch / (180F / (float)Math.PI);
        this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}

