package net.petemc.mutantszombies.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.petemc.mutantszombies.MutantsZombies;
import net.petemc.mutantszombies.client.state.RottenMutantEntityRenderState;

public class RottenMutantModel extends EntityModel<RottenMutantEntityRenderState> {
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of(MutantsZombies.MOD_ID, "rotten_mutant_layer"), "main");
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart metalrods;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public RottenMutantModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.torso = root.getChild("torso");
        this.metalrods = this.torso.getChild("metalrods");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.of(0.0F, -8.5F, -4.5F, -0.1274F, 0.0F, 0.0436F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(15, 106).cuboid(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.85F, -1.675F, -3.075F, 0.0F, -0.4363F, 1.5708F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(18, 31).cuboid(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.75F, -6.5F, -0.15F, -0.436F, 0.0184F, -3.102F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(21, 105).cuboid(-1.0F, -3.0F, -3.0F, 2.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -8.5F, -4.5F, 0.0F, -0.4363F, 1.5708F));

        ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(7, 101).cuboid(-1.0F, -3.0F, -3.0F, 2.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -4.25F, -2.0F, 0.48F, 0.0F, 0.0F));

        ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(35, 27).cuboid(4.0F, -1.0F, -5.0F, 0.5F, 1.0F, 23.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -3.25F, -8.975F, 0.3745F, -1.0204F, 0.1668F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(1, 97).cuboid(-4.5468F, -10.2426F, -10.5803F, 9.0F, 9.0F, 8.0F, new Dilation(0.25F)), ModelTransform.of(0.0F, 3.4451F, -4.1885F, -1.0908F, 0.0F, 0.0F));

        ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 4.0F, 1.0F));

        ModelPartData cube_r7 = torso.addChild("cube_r7", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -13.9403F, -5.0F, 12.0F, 14.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r8 = torso.addChild("cube_r8", ModelPartBuilder.create().uv(0, 83).cuboid(0.5F, -0.1856F, 1.1898F, 7.0F, 6.0F, 7.0F, new Dilation(-0.75F)), ModelTransform.of(-4.0F, -15.2903F, -10.903F, 0.3491F, 0.0F, 0.0F));

        ModelPartData metalrods = torso.addChild("metalrods", ModelPartBuilder.create().uv(35, 27).cuboid(4.0F, 1.25F, -5.0F, 0.5F, 1.0F, 23.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -10.0F, -14.0F));

        ModelPartData cube_r9 = metalrods.addChild("cube_r9", ModelPartBuilder.create().uv(32, 24).cuboid(-4.5F, -1.0F, -7.0F, 0.5F, 1.0F, 26.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0173F, 0.192F, -0.1791F));

        ModelPartData cube_r10 = metalrods.addChild("cube_r10", ModelPartBuilder.create().uv(73, 0).cuboid(-5.5F, -1.0F, -4.0F, 0.5F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.176F, 0.1289F, -0.0229F));

        ModelPartData cube_r11 = metalrods.addChild("cube_r11", ModelPartBuilder.create().uv(61, 43).cuboid(-4.5F, -3.7F, -7.0F, 0.5F, 0.7F, 11.0F, new Dilation(0.0F)), ModelTransform.of(1.25F, 7.0F, 3.25F, -0.3054F, 0.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.origin(6.0F, -7.0F, -3.0F));

        ModelPartData cube_r12 = left_arm.addChild("cube_r12", ModelPartBuilder.create().uv(32, 67).cuboid(0.0F, 6.0F, -2.75F, 4.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 11.75F, -5.75F, 1.5371F, 0.1248F, 0.2446F));

        ModelPartData cube_r13 = left_arm.addChild("cube_r13", ModelPartBuilder.create().uv(31, 11).cuboid(0.0F, 1.0F, -9.0F, 4.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.0F, -2.0F, 1.7975F, 0.4542F, -0.4509F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.origin(-6.0F, -7.0F, -3.0F));

        ModelPartData cube_r14 = right_arm.addChild("cube_r14", ModelPartBuilder.create().uv(70, 20).cuboid(-4.7F, -1.0F, -2.723F, 4.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-1.825F, 11.0F, -6.0F, 1.0898F, -0.3133F, -0.0098F));

        ModelPartData cube_r15 = right_arm.addChild("cube_r15", ModelPartBuilder.create().uv(0, 38).cuboid(-4.0F, -1.0F, -9.0F, 4.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -1.0F, 1.0036F, 0.0F, 0.5236F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(17, 38).cuboid(-2.075F, 14.0F, -4.0F, 4.0F, 6.0F, 3.0F, new Dilation(0.25F)), ModelTransform.origin(3.0F, 4.0F, 0.0F));

        ModelPartData cube_r16 = left_leg.addChild("cube_r16", ModelPartBuilder.create().uv(74, 55).cuboid(-6.1F, -8.6F, -2.1F, 4.0F, 16.0F, 4.0F, new Dilation(0.5F)), ModelTransform.of(4.0F, 7.0F, -1.0F, -0.1749F, -0.0058F, 0.0013F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.origin(-3.0F, 3.0F, 0.0F));

        ModelPartData cube_r17 = right_leg.addChild("cube_r17", ModelPartBuilder.create().uv(0, 28).cuboid(-6.5F, -7.0F, -2.0F, 4.0F, 7.0F, 3.0F, new Dilation(0.25F)), ModelTransform.of(3.5F, 20.675F, -1.0F, 0.0F, 0.0F, -0.0436F));

        ModelPartData cube_r18 = right_leg.addChild("cube_r18", ModelPartBuilder.create().uv(29, 78).cuboid(-5.0F, -10.5554F, -2.3915F, 4.0F, 16.0F, 4.0F, new Dilation(0.5F)), ModelTransform.of(2.225F, 9.0F, -0.5F, -0.1279F, 0.0093F, 0.0902F));

        return TexturedModelData.of(modelData, 128, 128);
	}

    @Override
    public void setAngles(RottenMutantEntityRenderState renderState) {
        this.head.yaw = renderState.relativeHeadYaw / (180F / (float)Math.PI);
        this.head.pitch = renderState.pitch / (180F / (float)Math.PI);
        this.right_arm.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 0.6662F + (float)Math.PI) * renderState.limbSwingAmplitude;
        this.left_leg.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * -1.0F * renderState.limbSwingAmplitude;
        this.left_arm.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 0.5F) * renderState.limbSwingAmplitude;
        this.right_leg.pitch = MathHelper.cos(renderState.limbSwingAnimationProgress * 1.0F) * 1.0F * renderState.limbSwingAmplitude;
    }
}