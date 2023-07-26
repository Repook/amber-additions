package net.repook.amberadditions.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.entity.custom.GlowWormEntity;
import net.repook.amberadditions.entity.layer.ModModelLayers;

public class GlowWormRenderer extends LivingEntityRenderer<GlowWormEntity,GlowWormModel<GlowWormEntity>> {
    private static final Identifier TEXTURE = new Identifier(AmberAdditionsMod.MOD_ID,"textures/entity/glow_worm.png");
    public GlowWormRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GlowWormModel<>(ctx.getPart(ModModelLayers.GLOW_WORM)), 0.1f);
    }

    @Override
    public Identifier getTexture(GlowWormEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GlowWormEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        if (livingEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        }
        else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    protected boolean hasLabel(GlowWormEntity livingEntity) {
        return false;
    }
}
