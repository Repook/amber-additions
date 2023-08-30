package net.repook.amberadditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.item.ModItems;
import net.repook.amberadditions.util.ModTags;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //offerPressurePlateRecipe(exporter, ModBlocks.VERA_WOOD_PRESSURE_PLATE,ModBlocks.VERA_WOOD_PLANKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.SPECTRAL_ARROW,3)
                .pattern("I")
                .pattern("A")
                .pattern("G")
                .input('A', Items.ARROW)
                .input('I', Items.GLOW_INK_SAC)
                .input('G', ModItems.GLOW_WORM_IN_A_BOTTLE)
                .criterion(hasItem(ModItems.GLOW_WORM_IN_A_BOTTLE),conditionsFromItem(ModItems.GLOW_WORM_IN_A_BOTTLE))
                .criterion(hasItem(Items.ARROW),conditionsFromItem(Items.ARROW))
                .criterion(hasItem(Items.GLOW_INK_SAC),conditionsFromItem(Items.GLOW_INK_SAC))
                .offerTo(exporter, new Identifier(getRecipeName(Items.SPECTRAL_ARROW) + "_"));

        offerPlanksRecipe(exporter, ModBlocks.VERA_WOOD_PLANKS, ModTags.Items.VERA_WOOD_LOGS, 4);
    }
}
