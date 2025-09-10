package net.petemc.mutantszombies.client.model;

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
import net.petemc.mutantszombies.client.state.SplitHeadZombieEntityRenderState;
import net.petemc.mutantszombies.client.state.ZombieBruteEntityRenderState;
import org.jetbrains.annotations.NotNull;

public class ZombieBruteModel extends EntityModel<ZombieBruteEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "zombie_brute_layer"), "main");
    public final ModelPart head;
    public final ModelPart torso;
    public final ModelPart right_arm;
    public final ModelPart left_arm;
    public final ModelPart left_leg;
    public final ModelPart right_leg;

    public ZombieBruteModel(ModelPart root) {
        super(root);
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
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(71, 49).addBox(-6.0F, -4.0F, -7.0F, 11.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(69, 99).addBox(-5.0F, 4.0F, -6.0F, 9.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, -17.0F));
        partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -41.0F, -15.0F, 29.0F, 21.0F, 28.0F, new CubeDeformation(0.0F)).texOffs(0, 49).addBox(-13.0F, -20.0F, -9.0F, 25.0F, 7.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-20.0F, -11.0F, -7.0F));
        right_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(86, 0).addBox(-23.0F, 14.0F, 5.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
        right_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 77).addBox(-4.0F, 0.0F, -3.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(19.0F, -11.0F, -7.0F));
        left_arm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(80, 77).addBox(14.0F, 14.0F, 5.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
        left_arm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(40, 77).addBox(13.0F, 0.0F, -3.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(98, 99).addBox(-2.0F, 11.0F, -3.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 11.0F, -1.0F));
        left_leg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(104, 70).addBox(3.0F, -7.0F, 1.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 13.0F, -3.0F, 0.3927F, 0.0F, 0.0F));
        left_leg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.6533F, -3.2527F, 7.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 0.0F, -0.3054F, 0.0F, 0.0F));
        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, 11.0F, -3.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 11.0F, -2.0F));
        right_leg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 105).addBox(-9.0F, -18.0F, -4.0F, 7.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 13.0F, -3.0F, -0.3054F, 0.0F, 0.0F));
        right_leg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 49).addBox(-8.0F, -7.0F, 1.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 13.0F, -3.0F, 0.3927F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(@NotNull ZombieBruteEntityRenderState renderState) {
        this.right_arm.xRot = Mth.cos(renderState.walkAnimationPos * 0.6662F + (float)Math.PI) * renderState.walkAnimationSpeed;
        this.left_leg.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * -1.0F * renderState.walkAnimationSpeed;
        this.left_arm.xRot = Mth.cos(renderState.walkAnimationPos * 0.6662F) * renderState.walkAnimationSpeed;
        this.right_leg.xRot = Mth.cos(renderState.walkAnimationPos * 1.0F) * 1.0F * renderState.walkAnimationSpeed;
    }
}
