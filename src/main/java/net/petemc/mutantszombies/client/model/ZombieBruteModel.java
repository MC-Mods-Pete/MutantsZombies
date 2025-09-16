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
import net.petemc.mutantszombies.client.state.ZombieBruteEntityRenderState;

public class ZombieBruteModel extends EntityModel<ZombieBruteEntityRenderState> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of(MutantsZombies.MOD_ID, "zombie_brute_layer"), "main");
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

    public static TexturedModelData createBodyLayer() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(71, 49).cuboid(-6.0F, -4.0F, -7.0F, 11.0F, 9.0F, 12.0F, new Dilation(0.0F)).uv(69, 99).cuboid(-5.0F, 4.0F, -6.0F, 9.0F, 3.0F, 11.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -15.0F, -17.0F));
        modelPartData.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-15.0F, -41.0F, -15.0F, 29.0F, 21.0F, 28.0F, new Dilation(0.0F)).uv(0, 49).cuboid(-13.0F, -20.0F, -9.0F, 25.0F, 7.0F, 21.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 24.0F, 0.0F));
        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.origin(-20.0F, -11.0F, -7.0F));
        right_arm.addChild("cube_r1", ModelPartBuilder.create().uv(86, 0).cuboid(-23.0F, 14.0F, 5.0F, 8.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(20.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
        right_arm.addChild("cube_r2", ModelPartBuilder.create().uv(0, 77).cuboid(-4.0F, 0.0F, -3.0F, 10.0F, 18.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.origin(19.0F, -11.0F, -7.0F));
        left_arm.addChild("cube_r3", ModelPartBuilder.create().uv(80, 77).cuboid(14.0F, 14.0F, 5.0F, 8.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-19.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
        left_arm.addChild("cube_r4", ModelPartBuilder.create().uv(40, 77).cuboid(13.0F, 0.0F, -3.0F, 10.0F, 18.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-19.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(98, 99).cuboid(-2.0F, 11.0F, -3.0F, 5.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(5.0F, 11.0F, -1.0F));
        left_leg.addChild("cube_r5", ModelPartBuilder.create().uv(104, 70).cuboid(3.0F, -7.0F, 1.0F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 13.0F, -3.0F, 0.3927F, 0.0F, 0.0F));
        left_leg.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -5.6533F, -3.2527F, 7.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 1.0F, 0.0F, -0.3054F, 0.0F, 0.0F));
        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0, 19).cuboid(-2.0F, 11.0F, -3.0F, 5.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(-6.0F, 11.0F, -2.0F));
        right_leg.addChild("cube_r7", ModelPartBuilder.create().uv(0, 105).cuboid(-9.0F, -18.0F, -4.0F, 7.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, 13.0F, -3.0F, -0.3054F, 0.0F, 0.0F));
        right_leg.addChild("cube_r8", ModelPartBuilder.create().uv(0, 49).cuboid(-8.0F, -7.0F, 1.0F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, 13.0F, -3.0F, 0.3927F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(ZombieBruteEntityRenderState renderState) {
        float f = renderState.attackTicksRemaining;
        float f1 = renderState.limbSwingAmplitude;
        float f2 = renderState.limbSwingAnimationProgress;
        if (f > 0.0F) {
            this.right_arm.pitch = -2.0F + 1.5F * MathHelper.wrap(f, 10.0F);
            this.left_arm.pitch = -2.0F + 1.5F * MathHelper.wrap(f, 10.0F);
        } else {
            this.right_arm.pitch = (-0.2F + 1.5F * MathHelper.wrap(f2, 13.0F)) * f1;
            this.left_arm.pitch = (-0.2F - 1.5F * MathHelper.wrap(f2, 13.0F)) * f1;
        }
        //this.right_arm.pitch = MathHelper.cos(f2 * 1.0F) * 1.0F * f1;
        this.left_leg.pitch = MathHelper.cos(f2 * 1.0F) * -1.0F * f1;
        //this.left_arm.pitch = MathHelper.cos(f2 * 1.0F) * -1.0F * f1;
        this.right_leg.pitch = MathHelper.cos(f2 * 1.0F) * 1.0F * f1;
    }
}
