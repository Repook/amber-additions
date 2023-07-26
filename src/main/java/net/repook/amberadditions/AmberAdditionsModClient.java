package net.repook.amberadditions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.block.entity.ModBlockEntities;
import net.repook.amberadditions.entity.ModEntities;
import net.repook.amberadditions.entity.client.GlowWormModel;
import net.repook.amberadditions.entity.client.GlowWormRenderer;
import net.repook.amberadditions.entity.layer.ModModelLayers;
import net.repook.amberadditions.util.ModWoodTypes;

public class AmberAdditionsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GLOW_WORM, GlowWormModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GLOW_WORM, GlowWormRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBER_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERA_WOOD_SAPLING, RenderLayer.getCutout());
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.VERA_WOOD, TexturedRenderLayers.getSignTextureId(ModWoodTypes.VERA_WOOD));
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);
    }
}
