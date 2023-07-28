package net.repook.amberadditions.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.entity.ModEntities;
import net.repook.amberadditions.entity.custom.GlowWormEntity;

public class ModRegistries {

    public static void registerModStuffs(){
        registerAttributes();
        registerFlammables();
        registerStrippables();
    }


    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.GLOW_WORM, GlowWormEntity.createGlowWormAttributes());
    }

    private static void registerFlammables(){
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERA_WOOD_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERA_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_VERA_WOOD_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_VERA_WOOD,5,5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERA_WOOD_PLANKS,5,20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERA_WOOD_LEAVES,30,60);
    }


    private static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.VERA_WOOD_LOG,ModBlocks.STRIPPED_VERA_WOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.VERA_WOOD,ModBlocks.STRIPPED_VERA_WOOD);
    }
}
