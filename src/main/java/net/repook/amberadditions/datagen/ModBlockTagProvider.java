package net.repook.amberadditions.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.repook.amberadditions.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.VERA_WOOD_PLANKS,ModBlocks.VERA_WOOD_DOOR,ModBlocks.VERA_WOOD_SIGN,ModBlocks.VERA_WOOD_TRAPDOOR,ModBlocks.VERA_WOOD_WALL_HANGING_SIGN,ModBlocks.VERA_WOOD_BUTTON
                        ,ModBlocks.VERA_WOOD_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.VERA_WOOD_LOG,ModBlocks.VERA_WOOD,ModBlocks.STRIPPED_VERA_WOOD_LOG,ModBlocks.STRIPPED_VERA_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.VERA_WOOD_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.VERA_WOOD_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.VERA_WOOD_HANGING_SIGN);


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.AMBER_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.AMBER_BLOCK);
    }

}
