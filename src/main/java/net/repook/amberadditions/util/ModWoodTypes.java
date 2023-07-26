package net.repook.amberadditions.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;

public class ModWoodTypes {
    public static final WoodType VERA_WOOD = WoodTypeRegistry.register(new Identifier(AmberAdditionsMod.MOD_ID, "vera_wood"), BlockSetType.CHERRY);
}
