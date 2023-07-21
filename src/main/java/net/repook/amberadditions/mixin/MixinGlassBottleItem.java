package net.repook.amberadditions.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.repook.amberadditions.entity.ModEntities;
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
                player.setStackInHand(hand, new ItemStack(ModItems.GLOW_WORM_IN_A_BOTTLE));

                // Remove the pig entity from the world
                Entity pigEntity = result.getEntity();
                pigEntity.remove(Entity.RemovalReason.KILLED);

                ci.setReturnValue(new TypedActionResult<>(ActionResult.SUCCESS, heldItem));
                ci.cancel();
            }
        }
    }
}
}





/*package net.repook.amberadditions.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.repook.amberadditions.item.ModItems;
import net.repook.amberadditions.util.IGlassBottleItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GlassBottleItem.class)
public abstract class GlassBottleItemMixin implements IGlassBottleItem {

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void onEntityUse(World world, PlayerEntity player, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> ci) {
        if (world.isClient) return;
        ItemStack heldItem = player.getStackInHand(hand);
        if (heldItem.getItem() == Items.GLASS_BOTTLE) {
            double reachDistance = 6.0D;
            RaycastContext.FluidHandling fluidHandling = RaycastContext.FluidHandling.NONE;
            RaycastContext context = new RaycastContext(player.getCameraPosVec(1.0F), player.getCameraPosVec(1.0F).add(player.getRotationVec(1.0F).multiply(reachDistance)), RaycastContext.ShapeType.OUTLINE, fluidHandling, player);

            Box box = player.getBoundingBox().stretch(rotationVec.multiply(reachDistance)).expand(1.0D);

            Entity targetEntity = null;
            for (Entity entity : ProjectileUtil.raycast(player, player.getCameraPosVec(1.0F), player.getCameraPosVec(1.0F).add(player.getRotationVec(1.0F).multiply(reachDistance)), box, entity -> PigEntity)) {
                if (entity instanceof PigEntity) {
                    targetEntity = entity;
                    break;
                }
            }

            if (targetEntity != null) {
                // Replace the item in the player's hand with a water bottle
                player.setStackInHand(hand, new ItemStack(Items.GLASS_BOTTLE));

                // Remove the pig entity from the world
                targetEntity.remove(Entity.RemovalReason.KILLED);

                ci.setReturnValue(new TypedActionResult<>(ActionResult.SUCCESS, heldItem));
                ci.cancel();
            }
        }
    }
}*/