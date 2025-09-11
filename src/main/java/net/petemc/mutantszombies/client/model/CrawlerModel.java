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

public class CrawlerModel extends EntityModel<CrawlerEntityRenderState> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of(MutantsZombies.MOD_ID, "crawler_layer"), "main");
    public final ModelPart head;
    public final ModelPart torso;
    public final ModelPart left_arm;
    public final ModelPart right_arm;
    public final ModelPart left_leg;
    public final ModelPart right_leg;

    public CrawlerModel(ModelPart root) {
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
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 15.0F, -4.0F));
        head.addChild("bottomjaw_r1", ModelPartBuilder.create().uv(37, 28).cuboid(-3.0F, 0.0F, -5.0F, 6.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -1.0F, 0.48F, 0.0F, 0.0F));
        head.addChild("topjaw_r1", ModelPartBuilder.create().uv(31, 0).cuboid(-3.0F, -4.0F, -6.0F, 6.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -1.0F, -0.48F, 0.0F, 0.0F));
        ModelPartData teeth = head.addChild("teeth", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 1.0F, -1.0F));
        ModelPartData bottomteeth = teeth.addChild("bottomteeth", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 0.0F, 0.0F));
        bottomteeth.addChild("cube_r1", ModelPartBuilder.create().uv(3, 12).cuboid(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(11, 12).cuboid(-3.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 4).cuboid(1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F));
        ModelPartData topteeth = teeth.addChild("topteeth", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 0.0F, 0.0F));
        topteeth.addChild("cube_r2", ModelPartBuilder.create().uv(8, 11).cuboid(1.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(7, 0).cuboid(-2.0F, 0.0F, -6.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));
        ModelPartData rightcheek = head.addChild("rightcheek", ModelPartBuilder.create(), ModelTransform.origin(-3.0F, 3.0F, -4.0F));
        rightcheek.addChild("cube_r3", ModelPartBuilder.create().uv(11, 0).cuboid(0.0F, -4.0053F, -0.5374F, 0.5F, 4.0F, 0.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3924F, 0.0167F, 0.0403F));
        rightcheek.addChild("cube_r4", ModelPartBuilder.create().uv(9, 5).cuboid(-3.0F, -4.0F, -4.0F, 0.5F, 6.0F, 0.5F, new Dilation(0.0F)), ModelTransform.of(3.0F, -2.0F, 3.0F, 0.1308F, -0.0057F, 0.0433F));
        ModelPartData leftcheek = head.addChild("leftcheek", ModelPartBuilder.create(), ModelTransform.origin(3.0F, 3.0F, -4.0F));
        leftcheek.addChild("cube_r5", ModelPartBuilder.create().uv(0, 7).cuboid(-0.5F, -5.0053F, -0.5374F, 0.5F, 5.0F, 0.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3957F, 0.1209F, -0.0503F));
        leftcheek.addChild("cube_r6", ModelPartBuilder.create().uv(5, 6).cuboid(2.5F, -4.5F, -4.0F, 0.5F, 6.0F, 0.5F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -2.0F, 3.0F, 0.218F, 0.0094F, -0.0426F));
        ModelPartData tounge = head.addChild("tounge", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 2.0F, -8.0F));
        tounge.addChild("cube_r7", ModelPartBuilder.create().uv(0, 4).cuboid(-0.4F, 0.0307F, -2.0984F, 1.0F, 0.5F, 2.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.6988F, 0.0859F, 0.0152F));
        tounge.addChild("cube_r8", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -0.6166F, -2.3061F, 1.5F, 0.5F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 2.0F, 0.3917F, -0.3564F, -0.151F));
        tounge.addChild("cube_r9", ModelPartBuilder.create().uv(46, 10).cuboid(-1.0F, -0.5F, -5.0F, 2.0F, 0.5F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 7.0F, 0.1772F, 0.1719F, 0.0306F));
        ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 19.0F, 2.0F));
        torso.addChild("cube_r10", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -7.0F, 8.0F, 3.0F, 15.0F, new Dilation(0.0F)).uv(30, 18).cuboid(-4.0F, -5.0F, -7.0F, 8.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.origin(4.0F, 16.0F, -3.0F));
        left_arm.addChild("cube_r11", ModelPartBuilder.create().uv(37, 36).cuboid(3.0F, -1.0F, -5.0F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -1.0F, 0.897F, 0.3093F, 0.4295F));
        left_arm.addChild("cube_r12", ModelPartBuilder.create().uv(0, 41).cuboid(0.0F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -1.0F, 0.9964F, -0.3332F, -0.468F));
        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.origin(-4.0F, 16.0F, -3.0F));
        right_arm.addChild("cube_r13", ModelPartBuilder.create().uv(11, 43).cuboid(-5.0F, -1.0F, -5.0F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -1.0F, 0.897F, -0.3093F, -0.4295F));
        right_arm.addChild("cube_r14", ModelPartBuilder.create().uv(29, 45).cuboid(-3.0F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -1.0F, 0.9964F, 0.3332F, 0.468F));
        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.origin(4.0F, 17.0F, 10.0F));
        left_leg.addChild("cube_r15", ModelPartBuilder.create().uv(15, 20).cuboid(4.25F, 3.0F, -3.0F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 2.0F, -1.0F, -0.3491F, 0.0F, -0.3491F));
        left_leg.addChild("cube_r16", ModelPartBuilder.create().uv(22, 33).cuboid(-0.5F, -1.7934F, -2.3912F, 3.5F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -1.0F, -2.4871F, 0.0F, -0.3491F));
        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.origin(-4.0F, 17.0F, 9.0F));
        right_leg.addChild("cube_r17", ModelPartBuilder.create().uv(0, 18).cuboid(-6.25F, 3.0F, -3.0F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 2.0F, 0.0F, -0.3491F, 0.0F, 0.3491F));
        right_leg.addChild("cube_r18", ModelPartBuilder.create().uv(0, 31).cuboid(-3.0F, -1.7934F, -2.3912F, 3.5F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, -2.4871F, 0.0F, 0.3491F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(CrawlerEntityRenderState renderState) {
        this.head.yaw = renderState.relativeHeadYaw / (180F / (float)Math.PI);
        this.head.pitch = renderState.pitch / (180F / (float)Math.PI);
        this.right_arm.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * 1.0F * renderState.limbSwingAmplitude;
        this.left_leg.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * -1.0F * renderState.limbSwingAmplitude;
        this.left_arm.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * -1.0F * renderState.limbSwingAmplitude;
        this.right_leg.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * 1.0F * renderState.limbSwingAmplitude;
    }
}
