package net.repook.amberadditions.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.block.custom.ModHangingSignBlock;
import net.repook.amberadditions.block.custom.ModStandingSignBlock;
import net.repook.amberadditions.block.custom.ModWallHangingSignBlock;
import net.repook.amberadditions.block.custom.ModWallSignBlock;
import net.repook.amberadditions.util.ModWoodTypes;
import net.repook.amberadditions.world.tree.VeraWoodSaplingGenerator;

public class ModBlocks {


    //all the wood stuff
    public static final Block VERA_WOOD_PLANKS = registerBlock("vera_wood_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));

    public static final Block VERA_WOOD_LEAVES = registerBlock("vera_wood_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.AZALEA_LEAVES).strength(1f).nonOpaque()));
    public static final Block VERA_WOOD_SIGN = registerBlockWithoutBlockItem("vera_wood_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_SIGN), ModWoodTypes.VERA_WOOD));
    public static final Block VERA_WOOD_WALL_SIGN = registerBlockWithoutBlockItem("vera_wood_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WALL_SIGN), ModWoodTypes.VERA_WOOD));
    public static final Block VERA_WOOD_HANGING_SIGN = registerBlockWithoutBlockItem("vera_wood_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_HANGING_SIGN), ModWoodTypes.VERA_WOOD));
    public static final Block VERA_WOOD_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("vera_wood_wall_hanging_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WALL_HANGING_SIGN), ModWoodTypes.VERA_WOOD));


    public static final Block VERA_WOOD_STAIRS = registerBlock("vera_wood_stairs",
            new StairsBlock(ModBlocks.VERA_WOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));

    public static final Block VERA_WOOD_SLAB = registerBlock("vera_wood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));

    public static final Block VERA_WOOD_BUTTON = registerBlock("vera_wood_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_BUTTON),BlockSetType.CHERRY,10,true));

    public static final Block VERA_WOOD_FENCE = registerBlock("vera_wood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE)));

    public static final Block VERA_WOOD_FENCE_GATE = registerBlock("vera_wood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE_GATE),WoodType.CHERRY));

    public static final Block VERA_WOOD_PRESSURE_PLATE = registerBlock("vera_wood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.CHERRY_BUTTON),BlockSetType.CHERRY));


    public static final Block VERA_WOOD_LOG = registerBlock("vera_wood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG)));

    public static final Block VERA_WOOD = registerBlock("vera_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD)));

    public static final Block STRIPPED_VERA_WOOD_LOG = registerBlock("stripped_vera_wood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));

    public static final Block STRIPPED_VERA_WOOD = registerBlock("stripped_vera_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));

    public static final Block VERA_WOOD_DOOR = registerBlock("vera_wood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_DOOR),BlockSetType.CHERRY));

    public static final Block VERA_WOOD_TRAPDOOR = registerBlock("vera_wood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_TRAPDOOR),BlockSetType.CHERRY));

//amber block
    public static final Block AMBER_BLOCK = registerBlock("amber_block",
            new TransparentBlock(FabricBlockSettings.copyOf(Blocks.COPPER_ORE).nonOpaque().mapColor(MapColor.ORANGE).strength(3.0f,
                    3.0f)));

//(AbstractBlock.Settings.copy(GOLD_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE))
    public static final Block VERA_WOOD_SAPLING = registerBlock("vera_wood_sapling",
            new SaplingBlock(new VeraWoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));



    //registering stuff
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(AmberAdditionsMod.MOD_ID, name), block);
    }

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
