package net.repook.amberadditions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.entity.ModEntities;
import net.repook.amberadditions.entity.client.GlowWormModel;
import net.repook.amberadditions.entity.client.GlowWormRenderer;
import net.repook.amberadditions.entity.layer.ModModelLayers;

public class AmberAdditionsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GLOW_WORM, GlowWormModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GLOW_WORM, GlowWormRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBER_BLOCK, RenderLayer.getTranslucent());
    }
}
