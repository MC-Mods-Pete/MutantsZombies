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

public class SpitterModel<T extends Entity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of(MutantsZombies.MOD_ID, "spitter_layer"), "main");
    public final ModelPart head2;
    public final ModelPart head3;
    public final ModelPart head4;
    public final ModelPart head5;
    public final ModelPart head6;
    public final ModelPart head7;
    public final ModelPart head8;
    public final ModelPart torso;
    public final ModelPart right_arm;
    public final ModelPart left_arm;
    public final ModelPart left_leg;
    public final ModelPart right_leg;

    public SpitterModel(ModelPart root) {
        this.head2 = root.getChild("head2");
        this.head3 = root.getChild("head3");
        this.head4 = root.getChild("head4");
        this.head5 = root.getChild("head5");
        this.head6 = root.getChild("head6");
        this.head7 = root.getChild("head7");
        this.head8 = root.getChild("head8");
        this.torso = root.getChild("torso");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head2 = modelPartData.addChild("head2", ModelPartBuilder.create(), ModelTransform.pivot(-13.0F, 7.0F, -8.0F));
        head2.addChild("cube_r1", ModelPartBuilder.create().uv(32, 109).cuboid(-4.3511F, -22.6056F, 7.8459F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(13.0F, 18.0F, 10.0F, 2.9626F, -0.6423F, 2.937F));
        head2.addChild("cube_r2", ModelPartBuilder.create().uv(96, 95).cuboid(-1.8795F, -16.2629F, 19.5477F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(13.0F, 18.0F, 10.0F, -2.6477F, -0.4703F, 2.9023F));
        ModelPartData head3 = modelPartData.addChild("head3", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 3.0F, -10.0F));
        head3.addChild("cube_r3", ModelPartBuilder.create().uv(109, 6).cuboid(-1.9556F, -24.2196F, 5.3173F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 22.0F, 12.0F, 3.009F, 0.1129F, -3.1296F));
        head3.addChild("cube_r4", ModelPartBuilder.create().uv(32, 95).cuboid(-0.943F, -20.2629F, 17.5242F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 22.0F, 12.0F, -2.702F, 0.1186F, -3.086F));
        ModelPartData head4 = modelPartData.addChild("head4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, 4.0F));
        head4.addChild("cube_r5", ModelPartBuilder.create().uv(84, 81).cuboid(-4.0F, -36.0006F, 11.6916F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 31.0F, -2.0F, -2.5744F, 0.0F, 3.1416F));
        head4.addChild("cube_r6", ModelPartBuilder.create().uv(0, 109).cuboid(-4.0F, -31.2629F, 7.759F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 31.0F, -2.0F, -2.7053F, 0.0F, 3.1416F));
        ModelPartData head5 = modelPartData.addChild("head5", ModelPartBuilder.create(), ModelTransform.pivot(12.0F, 10.0F, -6.0F));
        head5.addChild("cube_r7", ModelPartBuilder.create().uv(104, 64).cuboid(-4.4237F, -17.0446F, 9.0093F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 15.0F, 8.0F, 2.7981F, 1.0556F, 2.8826F));
        head5.addChild("cube_r8", ModelPartBuilder.create().uv(64, 95).cuboid(-4.4237F, -22.1988F, 11.24F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 15.0F, 8.0F, 2.8854F, 1.0556F, 2.8826F));
        ModelPartData head6 = modelPartData.addChild("head6", ModelPartBuilder.create(), ModelTransform.of(12.0F, 5.0F, 10.0F, -0.0436F, 0.0F, 0.0F));
        head6.addChild("cube_r9", ModelPartBuilder.create().uv(0, 95).cuboid(-24.9861F, -23.7525F, -6.1784F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 20.8288F, -11.9819F, 2.6202F, 0.9349F, 2.792F));
        head6.addChild("cube_r10", ModelPartBuilder.create().uv(104, 23).cuboid(-23.5859F, -17.906F, -6.1784F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 20.8288F, -11.9819F, 2.6734F, 0.9556F, 2.8576F));
        ModelPartData head7 = modelPartData.addChild("head7", ModelPartBuilder.create(), ModelTransform.pivot(-10.0F, -4.0F, 11.0F));
        head7.addChild("cube_r11", ModelPartBuilder.create().uv(0, 15).cuboid(-14.6813F, -21.8139F, 19.5135F, 8.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, 29.0F, -9.0F, -2.0567F, 0.2751F, 2.4914F));
        head7.addChild("cube_r12", ModelPartBuilder.create().uv(108, 75).cuboid(-14.6813F, -28.7175F, 14.6915F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, 29.0F, -9.0F, -2.3622F, 0.2751F, 2.4914F));
        ModelPartData head8 = modelPartData.addChild("head8", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 11.0F, 8.0F));
        head8.addChild("cube_r13", ModelPartBuilder.create().uv(101, 54).cuboid(-8.9696F, -17.4786F, -6.9687F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 14.0F, -6.0F, -0.9395F, 1.1447F, -1.2238F));
        head8.addChild("cube_r14", ModelPartBuilder.create().uv(80, 0).cuboid(-16.9424F, -19.5751F, -6.9687F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 14.0F, -6.0F, 0.3258F, 1.3104F, 0.0959F));
        ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, 0.0F));
        torso.addChild("cube_r15", ModelPartBuilder.create().uv(0, 40).cuboid(-13.0F, -13.0637F, -10.3502F, 26.0F, 5.0F, 23.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 20.0F, 2.0F, 3.1067F, 0.0F, 3.1416F));
        torso.addChild("cube_r16", ModelPartBuilder.create().uv(0, 0).cuboid(-14.0F, -25.9429F, -8.6927F, 28.0F, 16.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 20.0F, 2.0F, -3.0543F, 0.0F, 3.1416F));
        torso.addChild("cube_r17", ModelPartBuilder.create().uv(0, 68).cuboid(-11.0F, -31.9982F, -3.8529F, 23.0F, 8.0F, 19.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 20.0F, 2.0F, -2.9234F, 0.0F, 3.1416F));
        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.of(-13.0F, -5.0F, 5.0F, 0.1309F, -0.2182F, 0.0F));
        right_arm.addChild("cube_r18", ModelPartBuilder.create().uv(75, 40).cuboid(-7.376F, -33.7922F, -7.9359F, 15.8F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(10.916F, 28.4299F, -11.9257F, -2.9136F, 0.1298F, 2.6329F));
        right_arm.addChild("cube_r19", ModelPartBuilder.create().uv(75, 53).cuboid(-10.5294F, -32.7949F, -5.3264F, 11.8F, 4.0F, 4.9F, new Dilation(0.0F)), ModelTransform.of(10.916F, 28.4299F, -11.9257F, -2.9876F, 0.4358F, 2.1879F));
        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.of(11.0F, -4.4F, 7.6F, -0.0089F, 0.1742F, -0.0498F));
        left_arm.addChild("cube_r20", ModelPartBuilder.create().uv(65, 68).cuboid(-7.6672F, -32.9383F, -7.8704F, 15.8F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-5.2277F, 29.5507F, -10.7158F, -2.948F, -0.0923F, -2.7777F));
        left_arm.addChild("cube_r21", ModelPartBuilder.create().uv(80, 14).cuboid(-1.0144F, -31.6881F, -5.2025F, 11.8F, 4.0F, 4.9F, new Dilation(0.0F)), ModelTransform.of(-5.2277F, 29.5507F, -10.7158F, -3.0035F, -0.3873F, -2.3301F));
        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(10.0F, 16.0F, 0.0F));
        left_leg.addChild("cube_r22", ModelPartBuilder.create().uv(0, 0).cuboid(-12.0F, -10.0F, -1.0F, 5.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, 9.0F, 2.0F, -3.1416F, 0.0F, 3.1416F));
        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-10.0F, 16.0F, 0.0F));
        right_leg.addChild("cube_r23", ModelPartBuilder.create().uv(0, 40).cuboid(7.0F, -10.0F, -1.0F, 5.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, 9.0F, 2.0F, -3.1416F, 0.0F, 3.1416F));
        return TexturedModelData.of(modelData, 256, 256);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.head2.render(matrices, vertices, light, overlay, color);
        this.head3.render(matrices, vertices, light, overlay, color);
        this.head4.render(matrices, vertices, light, overlay, color);
        this.head5.render(matrices, vertices, light, overlay, color);
        this.head6.render(matrices, vertices, light, overlay, color);
        this.head7.render(matrices, vertices, light, overlay, color);
        this.head8.render(matrices, vertices, light, overlay, color);
        this.torso.render(matrices, vertices, light, overlay, color);
        this.right_arm.render(matrices, vertices, light, overlay, color);
        this.left_arm.render(matrices, vertices, light, overlay, color);
        this.left_leg.render(matrices, vertices, light, overlay, color);
        this.right_leg.render(matrices, vertices, light, overlay, color);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head8.yaw = netHeadYaw / (180F / (float)Math.PI);
        this.head8.pitch = headPitch / (180F / (float)Math.PI);
        this.right_arm.pitch = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
        this.left_leg.pitch = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.pitch = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.pitch = MathHelper.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.head2.yaw = netHeadYaw / (180F / (float)Math.PI);
        this.head2.pitch = headPitch / (180F / (float)Math.PI);
        this.head3.yaw = netHeadYaw / (180F / (float)Math.PI);
        this.head3.pitch = headPitch / (180F / (float)Math.PI);
        this.head4.yaw = netHeadYaw / (180F / (float)Math.PI);
        this.head4.pitch = headPitch / (180F / (float)Math.PI);
        this.head5.yaw = netHeadYaw / (180F / (float)Math.PI);
        this.head5.pitch = headPitch / (180F / (float)Math.PI);
        this.head6.yaw = netHeadYaw / (180F / (float)Math.PI);
        this.head6.pitch = headPitch / (180F / (float)Math.PI);
        this.head7.yaw = netHeadYaw / (180F / (float)Math.PI);
        this.head7.pitch = headPitch / (180F / (float)Math.PI);
    }
}
