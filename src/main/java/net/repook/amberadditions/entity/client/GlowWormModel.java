package net.repook.amberadditions.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.repook.amberadditions.entity.animations.ModAnimations;
import net.repook.amberadditions.entity.custom.GlowWormEntity;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
    public class GlowWormModel<T extends GlowWormEntity> extends SinglePartEntityModel<T> {
    private final ModelPart segment_1;
    private final ModelPart segment_2;
    private final ModelPart segment_3;
    private final ModelPart segment_4;

        public GlowWormModel(ModelPart root) {
            this.segment_1 = root.getChild("segment_1");
            this.segment_2 = root.getChild("segment_2");
            this.segment_3 = root.getChild("segment_3");
            this.segment_4 = root.getChild("segment_4");
        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData segment_1 = modelPartData.addChild("segment_1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -10.0F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

            ModelPartData segment_2 = modelPartData.addChild("segment_2", ModelPartBuilder.create().uv(9, 9).cuboid(-1.0F, -4.0F, -5.0F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 26.0F, 0.0F));

            ModelPartData glow_flower = segment_2.addChild("glow_flower", ModelPartBuilder.create().uv(7, 0).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, -4.0F));

            ModelPartData cube_r1 = glow_flower.addChild("cube_r1", ModelPartBuilder.create().uv(0, 7).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

            ModelPartData cube_r2 = glow_flower.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.2618F));

            ModelPartData cube_r3 = glow_flower.addChild("cube_r3", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 2.0F, 0.2618F, 0.0F, 0.0F));

            ModelPartData cube_r4 = glow_flower.addChild("cube_r4", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -2.0F, 1.0F, 0.0F, 0.0F, -0.2618F));

            ModelPartData segment_3 = modelPartData.addChild("segment_3", ModelPartBuilder.create().uv(9, 2).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

            ModelPartData segment_4 = modelPartData.addChild("segment_4", ModelPartBuilder.create().uv(0, 7).cuboid(-1.0F, -2.0F, 5.0F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
            return TexturedModelData.of(modelData, 32, 32);
        }
        @Override
        public void setAngles(GlowWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getPart().traverse().forEach(ModelPart::resetTransform);
            this.animateMovement(ModAnimations.GLOW_WORM_WALK,limbSwing,limbSwingAmount,2.0f,2.0f);
        }
        @Override
        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
            segment_1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            segment_2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            segment_3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            segment_4.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        }

    @Override
    public ModelPart getPart() {
        return segment_1;
    }
}

