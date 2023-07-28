package net.repook.amberadditions.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_VERA_WOOD_LOG, ModBlocks.VERA_WOOD_HANGING_SIGN, ModBlocks.VERA_WOOD_WALL_HANGING_SIGN);

        BlockStateModelGenerator.BlockTexturePool tPlnaks = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VERA_WOOD_PLANKS);
        tPlnaks.family(BlockFamilies.register(ModBlocks.VERA_WOOD_PLANKS).sign(ModBlocks.VERA_WOOD_SIGN, ModBlocks.VERA_WOOD_WALL_SIGN).build());

        //BlockStateModelGenerator.BlockTexturePool veraWoodPlanksTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VERA_WOOD_PLANKS);
        //BlockStateModelGenerator.BlockTexturePool strippedVeraWoodTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.STRIPPED_VERA_WOOD_LOG);

        blockStateModelGenerator.registerLog(ModBlocks.VERA_WOOD_LOG).log(ModBlocks.VERA_WOOD_LOG).wood(ModBlocks.VERA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_VERA_WOOD_LOG).log(ModBlocks.STRIPPED_VERA_WOOD_LOG).wood(ModBlocks.STRIPPED_VERA_WOOD);
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERA_WOOD_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERA_WOOD_LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.VERA_WOOD_SAPLING,BlockStateModelGenerator.TintType.NOT_TINTED);

        tPlnaks.stairs(ModBlocks.VERA_WOOD_STAIRS);
        tPlnaks.slab(ModBlocks.VERA_WOOD_SLAB);
        tPlnaks.button(ModBlocks.VERA_WOOD_BUTTON);
        tPlnaks.pressurePlate(ModBlocks.VERA_WOOD_PRESSURE_PLATE);
        tPlnaks.fence(ModBlocks.VERA_WOOD_FENCE);
        tPlnaks.fenceGate(ModBlocks.VERA_WOOD_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.VERA_WOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.VERA_WOOD_TRAPDOOR);







    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
itemModelGenerator.register(ModItems.GLOW_WORM_SPAWN_EGG,
        new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));
    }
}
