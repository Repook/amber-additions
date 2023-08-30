package net.repook.amberadditions.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.AmberAdditionsMod;

public class ModTags {

    public static class Blocks{

        private static TagKey<Block> createBlockTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(AmberAdditionsMod.MOD_ID, name));
        }
        private static TagKey<Block> createCommonBlockTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
    }

    public static class Items{


        public static final TagKey<Item> VERA_WOOD_LOGS =
                createItemTag("vera_wood_logs");

        private static TagKey<Item> createItemTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(AmberAdditionsMod.MOD_ID, name));
        }
        private static TagKey<Item> createCommonBlockTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }

    }

}
