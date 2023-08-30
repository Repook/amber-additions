package net.repook.amberadditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.VERA_WOOD_LOG.asItem(),ModBlocks.VERA_WOOD.asItem(),ModBlocks.STRIPPED_VERA_WOOD.asItem()
                        ,ModBlocks.STRIPPED_VERA_WOOD_LOG.asItem());

        getOrCreateTagBuilder(ModTags.Items.VERA_WOOD_LOGS)
                .add(ModBlocks.VERA_WOOD_LOG.asItem(),ModBlocks.VERA_WOOD.asItem(),ModBlocks.STRIPPED_VERA_WOOD.asItem()
                        ,ModBlocks.STRIPPED_VERA_WOOD_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.VERA_WOOD_PLANKS.asItem());



    }
}
