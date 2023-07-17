package net.repook.amberadditions.world.gen.treedecorator;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.repook.amberadditions.AmberAdditionsMod;
import net.repook.amberadditions.block.ModBlocks;

public class AmberTreeDecorator extends TreeDecorator {
    public static final AmberTreeDecorator INSTANCE = new AmberTreeDecorator();
    public static final Codec<AmberTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);
    private AmberTreeDecorator() {}
    @Override
    protected TreeDecoratorType<?> getType() {
        return AmberAdditionsMod.AMBER_TREE_DECORATOR;
    }

    @Override
    public void generate(Generator generator) { generator.getLogPositions().forEach(pos -> {
        Random random = generator.getRandom();
        // Pick a value from 0 (inclusive) to 4 (exclusive) and if it's 0, continue
        // This is the chance for spawning the gold block
        if (random.nextInt(4) == 0) {
            // Pick a random value from 0 to 4 and determine the side where the gold block will be placed using it
            int sideRaw = random.nextInt(4);
            Direction side = switch (sideRaw) {
                case 0 -> Direction.NORTH;
                case 1 -> Direction.SOUTH;
                case 2 -> Direction.EAST;
                case 3 -> Direction.WEST;
                default -> throw new ArithmeticException("The picked side value doesn't fit in the 0 to 4 bounds");
            };

            // Offset the log position by the resulting side
            BlockPos targetPosition = pos.offset(side);

            // Place the gold block using the replacer BiConsumer
            // This is the standard way of placing blocks in TreeDecorators
            if (generator.isAir(targetPosition.down(1))){
                System.out.println("True");
                generator.replace(targetPosition, ModBlocks.AMBER_BLOCK.getDefaultState());
            } else {
                System.out.println("False");
            }
            //if(generator.isAir(pos.down())) {
            //generator.replace(pos.offset(Direction.DOWN, 1), Blocks.ORANGE_WOOL.getDefaultState());

            //}

        }
    });
    }

    }



            //generator.getLeavesPositions().forEach(pos -> {
            //Random random = generator.getRandom();
            //int chance = random.nextInt(4);

            //if(generator.isAir(pos.down()) && chance == 0) {
            //generator.replace(pos.offset(Direction.DOWN, 1), Blocks.ORANGE_WOOL.getDefaultState());
            //}
            //});