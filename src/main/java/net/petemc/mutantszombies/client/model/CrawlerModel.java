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
import net.minecraft.world.entity.Entity;
import net.petemc.mutantszombies.MutantsZombies;

public class CrawlerModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MutantsZombies.MOD_ID, "crawler_zombie_layer"), "main");
    public final ModelPart head;
    public final ModelPart torso;
    public final ModelPart left_arm;
    public final ModelPart right_arm;
    public final ModelPart left_leg;
    public final ModelPart right_leg;

    public CrawlerModel(ModelPart root) {
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
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, -4.0F));
        head.addOrReplaceChild("bottomjaw_r1", CubeListBuilder.create().texOffs(37, 28).addBox(-3.0F, 0.0F, -5.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.48F, 0.0F, 0.0F));
        head.addOrReplaceChild("topjaw_r1", CubeListBuilder.create().texOffs(31, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.48F, 0.0F, 0.0F));
        PartDefinition teeth = head.addOrReplaceChild("teeth", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -1.0F));
        PartDefinition bottomteeth = teeth.addOrReplaceChild("bottomteeth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        bottomteeth.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 12).addBox(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(11, 12).addBox(-3.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 4).addBox(1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F));
        PartDefinition topteeth = teeth.addOrReplaceChild("topteeth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        topteeth.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 11).addBox(1.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 0).addBox(-2.0F, 0.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));
        PartDefinition rightcheek = head.addOrReplaceChild("rightcheek", CubeListBuilder.create(), PartPose.offset(-3.0F, 3.0F, -4.0F));
        rightcheek.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(11, 0).addBox(0.0F, -4.0053F, -0.5374F, 0.5F, 4.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3924F, 0.0167F, 0.0403F));
        rightcheek.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(9, 5).addBox(-3.0F, -4.0F, -4.0F, 0.5F, 6.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 3.0F, 0.1308F, -0.0057F, 0.0433F));
        PartDefinition leftcheek = head.addOrReplaceChild("leftcheek", CubeListBuilder.create(), PartPose.offset(3.0F, 3.0F, -4.0F));
        leftcheek.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, -5.0053F, -0.5374F, 0.5F, 5.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3957F, 0.1209F, -0.0503F));
        leftcheek.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(5, 6).addBox(2.5F, -4.5F, -4.0F, 0.5F, 6.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 3.0F, 0.218F, 0.0094F, -0.0426F));
        PartDefinition tounge = head.addOrReplaceChild("tounge", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -8.0F));
        tounge.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 4).addBox(-0.4F, 0.0307F, -2.0984F, 1.0F, 0.5F, 2.2F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6988F, 0.0859F, 0.0152F));
        tounge.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.6166F, -2.3061F, 1.5F, 0.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 2.0F, 0.3917F, -0.3564F, -0.151F));
        tounge.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(46, 10).addBox(-1.0F, -0.5F, -5.0F, 2.0F, 0.5F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 7.0F, 0.1772F, 0.1719F, 0.0306F));
        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 2.0F));
        torso.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(30, 18).addBox(-4.0F, -5.0F, -7.0F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(4.0F, 16.0F, -3.0F));
        left_arm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(37, 36).addBox(3.0F, -1.0F, -5.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, 0.897F, 0.3093F, 0.4295F));
        left_arm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, 0.9964F, -0.3332F, -0.468F));
        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-4.0F, 16.0F, -3.0F));
        right_arm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(11, 43).addBox(-5.0F, -1.0F, -5.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, 0.897F, -0.3093F, -0.4295F));
        right_arm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(29, 45).addBox(-3.0F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, 0.9964F, 0.3332F, 0.468F));
        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(4.0F, 17.0F, 10.0F));
        left_leg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(15, 20).addBox(4.25F, 3.0F, -3.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, -1.0F, -0.3491F, 0.0F, -0.3491F));
        left_leg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(22, 33).addBox(-0.5F, -1.7934F, -2.3912F, 3.5F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -2.4871F, 0.0F, -0.3491F));
        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-4.0F, 17.0F, 9.0F));
        right_leg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 18).addBox(-6.25F, 3.0F, -3.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0F, 0.0F, -0.3491F, 0.0F, 0.3491F));
        right_leg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 31).addBox(-3.0F, -1.7934F, -2.3912F, 3.5F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -2.4871F, 0.0F, 0.3491F));
        return LayerDefinition.create(meshdefinition, 64, 64);
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
        this.right_arm.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}
