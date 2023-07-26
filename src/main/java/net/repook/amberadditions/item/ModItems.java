package net.repook.amberadditions.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.entity.ModEntities;
import net.repook.amberadditions.item.custom.AmberFossilItem;
import net.repook.amberadditions.item.custom.GlowWormInABottleItem;

public class ModItems {
    // new item registry
    public static final Item AMBER = registerItem("amber", new AmberFossilItem(new FabricItemSettings()));
    public static final Item VERA_WOOD_SIGN = registerItem("vera_wood_sign",
            new SignItem(new FabricItemSettings().maxCount(16),ModBlocks.VERA_WOOD_SIGN,ModBlocks.VERA_WOOD_WALL_SIGN));
    public static final Item VERA_WOOD_HANGING_SIGN = registerItem("vera_wood_hanging_sign",
            new HangingSignItem(ModBlocks.VERA_WOOD_HANGING_SIGN,ModBlocks.VERA_WOOD_WALL_HANGING_SIGN ,new FabricItemSettings().maxCount(16)));
    //public static final Item CUSTOM_GLASS_BOTTLE = registerItem("custom_glass_bottle", new CustomGlassBottleItem(new FabricItemSettings()));

    public static final Item GLOW_WORM_IN_A_BOTTLE = registerItem("glow_worm_in_a_bottle", new GlowWormInABottleItem(new FabricItemSettings()));
    public static final Item GLOW_WORM_SPAWN_EGG = registerItem("glow_worm_spawn_egg", new SpawnEggItem(ModEntities.GLOW_WORM,0x8fe5dc,0x4b4ced, new FabricItemSettings()));

    //adds items to custom item group
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.add(AMBER);
        entries.add(GLOW_WORM_IN_A_BOTTLE);

    }

    private static void addItemToBuildingBlocksItemGroup(FabricItemGroupEntries entries){
        entries.add(ModBlocks.VERA_WOOD_LOG);
        entries.add(ModBlocks.VERA_WOOD);
        entries.add(ModBlocks.STRIPPED_VERA_WOOD_LOG);
        entries.add(ModBlocks.STRIPPED_VERA_WOOD);
        entries.add(ModBlocks.VERA_WOOD_PLANKS);
        entries.add(ModBlocks.VERA_WOOD_STAIRS);
        entries.add(ModBlocks.VERA_WOOD_SLAB);
        entries.add(ModBlocks.VERA_WOOD_FENCE);
        entries.add(ModBlocks.VERA_WOOD_FENCE_GATE);
        //entries.add(ModItems.VERA_WOOD_HANGING_SIGN);
        //entries.add(ModItems.VERA_WOOD_SIGN);

        entries.add(ModBlocks.VERA_WOOD_PRESSURE_PLATE);
        entries.add(ModBlocks.VERA_WOOD_BUTTON);


        entries.add(ModBlocks.AMBER_BLOCK);
    }

    private static void addItemToSpawnEggsItemGroup(FabricItemGroupEntries entries){
        entries.add(ModItems.GLOW_WORM_SPAWN_EGG);
    }
//what is used to register items
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AmberAdditionsMod.MOD_ID,name),item);
    }
    //what registers items
    public static void registerModItems(){
        AmberAdditionsMod.LOGGER.info("Registering Mod Items for"+AmberAdditionsMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemToBuildingBlocksItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemToSpawnEggsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemToFunctionalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemToFoodAndDrinkItemGroup);
    }

    private static void addItemToFoodAndDrinkItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.GLOW_WORM_IN_A_BOTTLE);
    }

    private static void addItemToFunctionalItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.VERA_WOOD_HANGING_SIGN);
        entries.add(ModItems.VERA_WOOD_SIGN);
    }
}
