package net.repook.amberadditions.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.item.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.VERA_WOOD_PLANKS);
        addDrop(ModBlocks.VERA_WOOD_STAIRS);
        addDrop(ModBlocks.VERA_WOOD_SLAB,slabDrops(ModBlocks.VERA_WOOD_SLAB));
        addDrop(ModBlocks.VERA_WOOD_LOG);
        addDrop(ModBlocks.VERA_WOOD);
        addDrop(ModBlocks.STRIPPED_VERA_WOOD_LOG);
        addDrop(ModBlocks.STRIPPED_VERA_WOOD);
        addDrop(ModBlocks.VERA_WOOD_SAPLING);
        addDrop(ModBlocks.VERA_WOOD_BUTTON);
        addDrop(ModBlocks.VERA_WOOD_PRESSURE_PLATE);
        addDrop(ModBlocks.VERA_WOOD_FENCE);
        addDrop(ModBlocks.VERA_WOOD_FENCE_GATE);
        addDrop(ModBlocks.VERA_WOOD_HANGING_SIGN);
        //addDrop(ModBlocks.AMBER_BLOCK, oreDrops(ModBlocks.AMBER_BLOCK, ModItems.AMBER));
    }
}
