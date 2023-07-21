package net.repook.amberadditions.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomGlassBottleItem extends GlassBottleItem {
    public CustomGlassBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, net.minecraft.entity.player.PlayerEntity playerEntity, Hand hand) {
        return super.use(world, playerEntity, hand);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, net.minecraft.entity.player.PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof PigEntity && !player.getWorld().isClient) {
            // Replace the item in the player's hand with a water bottle
            player.setStackInHand(hand, new ItemStack(net.minecraft.item.Items.GLASS_BOTTLE));

            // Remove the pig entity from the world
            entity.remove(Entity.RemovalReason.KILLED);

            return ActionResult.SUCCESS;
        }

        return super.useOnEntity(stack, player, entity, hand);
    }




}
