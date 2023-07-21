package net.repook.amberadditions.util;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.repook.amberadditions.entity.ModEntities;
import net.repook.amberadditions.entity.custom.GlowWormEntity;

public class ModRegistries {

    public static void registerModStuffs(){
        registerAttributes();
    }


    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.GLOW_WORM, GlowWormEntity.createGlowWormAttributes());
    }
}
