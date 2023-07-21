package net.repook.amberadditions.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.entity.ModEntities;
import net.repook.amberadditions.item.custom.AmberFossilItem;
import net.repook.amberadditions.item.custom.CustomGlassBottleItem;
import net.repook.amberadditions.item.custom.GlowWormInABottleItem;

public class ModItems {
    // new item registry
    public static final Item AMBER = registerItem("amber", new AmberFossilItem(new FabricItemSettings()));
    public static final Item CUSTOM_GLASS_BOTTLE = registerItem("custom_glass_bottle", new CustomGlassBottleItem(new FabricItemSettings()));

    public static final Item GLOW_WORM_IN_A_BOTTLE = registerItem("glow_worm_in_a_bottle", new GlowWormInABottleItem(new FabricItemSettings()));
    public static final Item GLOW_WORM_SPAWN_EGG = registerItem("glow_worm_spawn_egg", new SpawnEggItem(ModEntities.GLOW_WORM,0x8fe5dc,0x4b4ced, new FabricItemSettings()));

    //adds items to custom item group
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.add(AMBER);

    }

    private static void addItemToBuildingBlocksItemGroup(FabricItemGroupEntries entries){
        entries.add(ModBlocks.VERA_WOOD_PLANKS);
        entries.add(ModBlocks.AMBER_BLOCK);
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
    }
}
