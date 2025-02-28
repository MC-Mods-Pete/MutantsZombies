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

public class BlisterZombieModel<T extends Entity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(MutantsZombies.MOD_ID, "blister_zombie_layer"), "main");
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

    public static TexturedModelData createBodyLayer() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, -9.0F));
        head.addChild("cube_r1", ModelPartBuilder.create().uv(42, 0).cuboid(-3.0F, 0.0F, -8.0F, 6.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        head.addChild("cube_r2", ModelPartBuilder.create().uv(0, 22).cuboid(-5.0F, -6.0F, -8.0F, 10.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
        ModelPartData faceplates = head.addChild("faceplates", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -6.0F));
        faceplates.addChild("cube_r3", ModelPartBuilder.create().uv(33, 0).cuboid(0.5F, -1.0F, -5.0F, 0.5F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2057F, 0.3023F, 0.0186F));
        faceplates.addChild("cube_r4", ModelPartBuilder.create().uv(63, 2).cuboid(0.5F, -2.0F, -7.0F, 0.5F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.4983F, 0.7777F, -0.5184F));
        faceplates.addChild("cube_r5", ModelPartBuilder.create().uv(74, 36).cuboid(0.0F, 0.0F, -7.0F, 1.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.6285F, 0.686F, -1.2187F));
        faceplates.addChild("cube_r6", ModelPartBuilder.create().uv(65, 80).cuboid(0.0F, -2.0F, -7.0F, 1.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7475F, 0.5719F, -0.2274F));
        faceplates.addChild("cube_r7", ModelPartBuilder.create().uv(79, 81).cuboid(0.5F, -2.0F, -7.0F, 0.5F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1589F, -0.2725F, 0.2135F));
        faceplates.addChild("cube_r8", ModelPartBuilder.create().uv(60, 27).cuboid(0.0F, -4.0F, -10.0F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1622F, -0.5334F, -0.1392F));
        faceplates.addChild("cube_r9", ModelPartBuilder.create().uv(21, 50).cuboid(0.0F, -5.0F, -10.0F, 1.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, -1.0036F, 0.0F));
        ModelPartData sidegrips = head.addChild("sidegrips", ModelPartBuilder.create().uv(0, 72).cuboid(5.0F, -1.0F, -5.0F, 0.5F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -4.0F));
        sidegrips.addChild("cube_r10", ModelPartBuilder.create().uv(46, 38).cuboid(-5.5F, -1.0F, -9.0F, 0.5F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0173F, 0.192F, -0.1791F));
        sidegrips.addChild("cube_r11", ModelPartBuilder.create().uv(73, 0).cuboid(-5.5F, -1.0F, -6.0F, 0.5F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.176F, 0.1289F, -0.0229F));
        sidegrips.addChild("cube_r12", ModelPartBuilder.create().uv(61, 43).cuboid(-5.5F, -3.7F, -7.0F, 0.5F, 0.7F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));
        sidegrips.addChild("cube_r13", ModelPartBuilder.create().uv(49, 14).cuboid(5.0F, -1.0F, -10.0F, 0.5F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7591F, -0.192F, 0.1791F));
        sidegrips.addChild("cube_r14", ModelPartBuilder.create().uv(73, 70).cuboid(5.0F, -4.0F, -7.0F, 0.5F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
        ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 4.0F, 1.0F));
        torso.addChild("cube_r15", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -13.9403F, -4.1423F, 12.0F, 13.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));
        torso.addChild("cube_r16", ModelPartBuilder.create().uv(30, 32).cuboid(-4.0F, -14.0F, -3.0F, 8.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.0F, -1.0F, -0.0873F, 0.0F, 0.0F));
        ModelPartData backplates = torso.addChild("backplates", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -7.0F, -1.0F));
        backplates.addChild("cube_r17", ModelPartBuilder.create().uv(52, 58).cuboid(2.0F, -7.0F, -2.0F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));
        backplates.addChild("cube_r18", ModelPartBuilder.create().uv(63, 65).cuboid(3.5F, -6.0F, -2.0F, 0.5F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 1.0472F, 0.0F));
        backplates.addChild("cube_r19", ModelPartBuilder.create().uv(41, 51).cuboid(-1.0F, -4.0F, -2.0F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, -0.0873F, 0.0F));
        backplates.addChild("cube_r20", ModelPartBuilder.create().uv(0, 57).cuboid(-2.5F, -7.0F, -8.0F, 0.5F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0057F, 0.0433F, 0.131F));
        backplates.addChild("cube_r21", ModelPartBuilder.create().uv(47, 74).cuboid(-3.75F, -3.0F, -2.0F, 0.75F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.48F, 0.0F));
        backplates.addChild("cube_r22", ModelPartBuilder.create().uv(13, 67).cuboid(2.5F, -1.0F, -2.0F, 0.5F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0607F, 0.116F, -0.4835F));
        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(6.0F, -4.0F, -6.0F));
        left_arm.addChild("cube_r23", ModelPartBuilder.create().uv(33, 67).cuboid(1.0F, 3.8813F, -4.723F, 3.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 8.0F, -5.0F, 1.5007F, 0.1367F, 0.6339F));
        left_arm.addChild("cube_r24", ModelPartBuilder.create().uv(31, 11).cuboid(0.0F, -2.0F, -11.0F, 4.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 1.5901F, 0.3093F, -0.4295F));
        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, -4.0F, -5.0F));
        right_arm.addChild("cube_r25", ModelPartBuilder.create().uv(71, 20).cuboid(-5.0F, -1.6187F, -4.723F, 3.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 8.0F, -4.0F, 1.0898F, -0.3133F, -0.0098F));
        right_arm.addChild("cube_r26", ModelPartBuilder.create().uv(0, 38).cuboid(-4.0F, -2.0F, -11.0F, 4.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 1.0F, 1.0036F, 0.0F, 0.5236F));
        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(19, 38).cuboid(0.0F, 6.0F, -8.0F, 2.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 12.0F, 1.0F));
        left_leg.addChild("cube_r27", ModelPartBuilder.create().uv(74, 55).cuboid(-6.0F, 0.3983F, -2.0908F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -1.0F, 0.0F, -0.7418F, 0.0F, 0.0F));
        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 12.0F, 1.0F));
        right_leg.addChild("cube_r28", ModelPartBuilder.create().uv(0, 38).cuboid(-6.0F, -7.0F, -2.0F, 2.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
        right_leg.addChild("cube_r29", ModelPartBuilder.create().uv(29, 78).cuboid(-5.0F, -0.5554F, -2.3915F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, 0.0F, -0.2612F, 0.2699F, 0.1488F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.torso.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.left_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.right_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.yaw = headYaw / (180F / (float)Math.PI);
        this.head.pitch = headPitch / (180F / (float)Math.PI);
        this.right_arm.pitch = MathHelper.cos(limbAngle * 0.6662F + (float)Math.PI) * limbDistance;
        this.left_leg.pitch = MathHelper.cos(limbAngle * 1.0F) * -1.0F * limbDistance;
        this.left_arm.pitch = MathHelper.cos(limbAngle * 0.6662F) * limbDistance;
        this.right_leg.pitch = MathHelper.cos(limbAngle * 1.0F) * 1.0F * limbDistance;
    }
}

