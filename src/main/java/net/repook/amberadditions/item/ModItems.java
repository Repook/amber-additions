package net.repook.amberadditions.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.block.ModBlocks;

public class ModItems {
    // new item registry
    public static final Item AMBER = registerItem("amber", new Item(new FabricItemSettings()));

    //adds items to custom item group
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.add(AMBER);

    }

    private static void addItemToBuildingBlocksItemGroup(FabricItemGroupEntries entries){
        entries.add(ModBlocks.VERA_WOOD_PLANKS);
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
    }
}
