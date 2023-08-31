package net.repook.amberadditions.entity;


import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.item.ModItems;

public class ModBoats {
    public static final Identifier VERA_WOOD_BOAT_ID = new Identifier(AmberAdditionsMod.MOD_ID,"vera_wood_boat");
    public static final Identifier VERA_WOOD_BOAT_CHEST_ID = new Identifier(AmberAdditionsMod.MOD_ID,"vera_wood_chest_boat");

    public static final RegistryKey<TerraformBoatType> VERA_WOOD_BOAT_KEY = TerraformBoatTypeRegistry.createKey(VERA_WOOD_BOAT_ID);

    public static void registerBoats(){
        TerraformBoatType veraWoodBoat = new TerraformBoatType.Builder()
                .item(ModItems.VERA_WOOD_BOAT)
                .chestItem(ModItems.VERA_WOOD_CHEST_BOAT)
                .planks(ModBlocks.VERA_WOOD_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, VERA_WOOD_BOAT_KEY,veraWoodBoat);
    }
}
