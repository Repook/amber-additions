package net.repook.amberadditions.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.block.ModBlocks;

public class ModBlockEntities {


    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(AmberAdditionsMod.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new,
                    ModBlocks.VERA_WOOD_SIGN, ModBlocks.VERA_WOOD_WALL_SIGN).build());

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(AmberAdditionsMod.MOD_ID, "mod_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new,
                    ModBlocks.VERA_WOOD_HANGING_SIGN, ModBlocks.VERA_WOOD_WALL_HANGING_SIGN).build(null));
    public static void registerBlockEntities() {
        AmberAdditionsMod.LOGGER.info("Registering Block Entities for " + AmberAdditionsMod.MOD_ID);}
}
