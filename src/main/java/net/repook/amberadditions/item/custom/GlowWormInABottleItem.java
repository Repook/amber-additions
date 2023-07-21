package net.repook.amberadditions.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GlowWormInABottleItem extends Item {

    public GlowWormInABottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300, 0));
        user.playSound(SoundEvents.ENTITY_GLOW_SQUID_AMBIENT,1.0f,1.0f);
        ItemStack heldItem = user.getStackInHand(hand);

        // Check if the player is holding an item and it's not a Glass Bottle already
        if (!heldItem.isEmpty() && !(heldItem.getItem() instanceof GlassBottleItem)) {
            // Create a new ItemStack for Glass Bottle and decrease the held item count by 1
            ItemStack glassBottleStack = new ItemStack(Items.GLASS_BOTTLE);
            heldItem.decrement(1);

            // If the held item count reaches zero, replace the item in the player's hand with the Glass Bottle
            if (heldItem.isEmpty()) {
                user.setStackInHand(hand, glassBottleStack);
            } else {
                // If there are still items left in the stack, try to add the Glass Bottle to the player's inventory
                if (!user.getInventory().insertStack(glassBottleStack)) {
                    // If the inventory is full, drop the Glass Bottle at the player's feet
                    user.dropStack(glassBottleStack, 0.5f);
                }
    }}
        return super.use(world, user, hand);
    }



}
