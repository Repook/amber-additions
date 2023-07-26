package net.repook.amberadditions.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.repook.amberadditions.entity.custom.GlowWormEntity;
import net.repook.amberadditions.item.ModItems;
import net.repook.amberadditions.util.IGlassBottleItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GlassBottleItem.class)
public abstract class MixinGlassBottleItem implements IGlassBottleItem {

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    protected void onEntityUse(World world, net.minecraft.entity.player.PlayerEntity player, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> ci) {
        if (world.isClient) return;

        ItemStack heldItem = player.getStackInHand(hand);
        if (heldItem.getItem() == Items.GLASS_BOTTLE) {
            double reachDistance = 6.0D;

            // Calculate the raycast direction
            Vec3d cameraPos = player.getCameraPosVec(1.0F);
            Vec3d rotationVec = player.getRotationVec(1.0F);
            Vec3d endPos = cameraPos.add(rotationVec.multiply(reachDistance));

            // Perform the raycast
            //EntityHitResult result = new RaycastContext(new RaycastContext(cameraPos, endPos, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player));

            for (Entity entity : world.getOtherEntities(player, player.getBoundingBox().stretch(rotationVec.multiply(reachDistance)).expand(1.0D))) {
                EntityHitResult result = new EntityHitResult(entity);

            if (result != null && result.getType() == EntityHitResult.Type.ENTITY && result.getEntity() instanceof GlowWormEntity) {
                // Replace the item in the player's hand with a water bottle
                heldItem.decrement(1);

                // Create a new ItemStack for the glow worm in a bottle
                ItemStack glowWormBottle = new ItemStack(ModItems.GLOW_WORM_IN_A_BOTTLE);

                // Add the glow worm in a bottle to the player's inventory
                if (!player.giveItemStack(glowWormBottle)) {
                    // If the player's inventory is full, drop the item in the world
                    player.dropItem(glowWormBottle, false);
                }


                // Remove the glow-worm entity from the world
                Entity glowWormEntity = result.getEntity();
                glowWormEntity.remove(Entity.RemovalReason.KILLED);

                ci.setReturnValue(new TypedActionResult<>(ActionResult.SUCCESS, heldItem));
                ci.cancel();

                break;
            }
        }
    }
}
}