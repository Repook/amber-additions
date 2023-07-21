package net.repook.amberadditions.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.AmberAdditionsModClient;
import net.repook.amberadditions.entity.custom.GlowWormEntity;

public class ModEntities {

    public static final EntityType<GlowWormEntity> GLOW_WORM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AmberAdditionsMod.MOD_ID, "glow_worm"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GlowWormEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());
    public static void registerModEntities() {
        AmberAdditionsMod.LOGGER.info("Registering Mod Entities for " + AmberAdditionsMod.MOD_ID);
    }
}
