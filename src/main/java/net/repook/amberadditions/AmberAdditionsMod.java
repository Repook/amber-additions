package net.repook.amberadditions;

import net.fabricmc.api.ModInitializer;

import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.repook.amberadditions.block.ModBlocks;
import net.repook.amberadditions.item.ModItems;
import net.repook.amberadditions.mixin.TreeDecoratorTypeInvoker;
import net.repook.amberadditions.util.ModLootTableModifiers;
import net.repook.amberadditions.world.gen.ModWorldGeneration;
import net.repook.amberadditions.world.gen.treedecorator.AmberTreeDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmberAdditionsMod implements ModInitializer {
	public static final String MOD_ID = "amberadditions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TreeDecoratorType<AmberTreeDecorator> AMBER_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("amberadditions:amber_tree_decorator", AmberTreeDecorator.CODEC);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
		ModWorldGeneration.generateModWorldGeneration();
	}
}