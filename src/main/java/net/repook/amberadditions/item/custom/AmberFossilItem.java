package net.repook.amberadditions.item.custom;

import net.minecraft.advancement.criterion.SummonedEntityCriterion;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.command.SummonCommand;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.repook.amberadditions.entity.ModEntities;
import net.repook.amberadditions.entity.custom.GlowWormEntity;
import net.repook.amberadditions.item.ModItems;

public class AmberFossilItem extends Item {


    public AmberFossilItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockPos blockPosOffset = blockPos.offset(context.getSide());
        if (!world.isClient) {
            GlowWormEntity glow_worm = new GlowWormEntity(ModEntities.GLOW_WORM, world);
            glow_worm.refreshPositionAndAngles(blockPosOffset.getX() + 0.5D, blockPosOffset.getY(), blockPosOffset.getZ() + 0.5D, 0.0F, 0.0F);
            world.spawnEntity(glow_worm);
            world.syncWorldEvent(null, 1016, blockPos, 0);
            world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.PLAYERS, 1.0F, 1.0F);
            context.getStack().decrement(1); // This line removes one item from the stack when right-clicked

        }
        return ActionResult.SUCCESS;

    }


}




/*    public AmberFossilItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);*/


/*        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            // Check if the player is in creative mode or has permission to remove the item
            if (!player.isCreative()) {
                // Get the player's held item in their main hand
                if (player.getStackInHand(Hand.MAIN_HAND).getItem() == ModItems.AMBER) {
                    ItemStack itemStack = new ItemStack(ModItems.AMBER);
                    // Remove the item from the player's inventory
                    player.getInventory().removeOne(itemStack);
                    // Play a sound or perform any other actions you may want
                    player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
                    // Return SUCCESS to signify the interaction was successful
                    EntityType.PIG.spawn(world, null, null, null, player.getBlockPos(), SpawnReason.EVENT, false, false);
                    return ActionResult.SUCCESS;
                }
            }
        }*/

