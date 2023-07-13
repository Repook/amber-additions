package net.repook.amberadditions.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.world.tree.VeraWoodSaplingGenerator;

public class ModBlocks {

    public static final Block VERA_WOOD_PLANKS = registerBlock("vera_wood_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));


    //change null to sapling generator later
    public static final Block VERA_WOOD_SAPLING = registerBlock("vera_wood_sapling",
            new SaplingBlock(new VeraWoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));




    //registering stuff
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AmberAdditionsMod.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(AmberAdditionsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        AmberAdditionsMod.LOGGER.info("Registering Mod Blocks for" + AmberAdditionsMod.MOD_ID);
    }

}
