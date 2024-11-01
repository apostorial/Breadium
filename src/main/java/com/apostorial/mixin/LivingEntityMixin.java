package com.apostorial.mixin;

import com.apostorial.item.custom.BreadiumBootsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "computeFallDamage", at = @At("HEAD"), cancellable = true)
    private void preventFallDamage(float fallDistance, float damageMultiplier, CallbackInfoReturnable<Integer> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity instanceof PlayerEntity player) {
            ItemStack boots = player.getInventory().getArmorStack(0);
            if (boots.getItem() instanceof BreadiumBootsItem) {
                cir.setReturnValue(0);

                if (player.getWorld() instanceof ServerWorld serverWorld && fallDistance > 3) {
                    serverWorld.spawnParticles(
                            ParticleTypes.CLOUD,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            (int) (fallDistance * 2),
                            0.5D,
                            0.1D,
                            0.5D,
                            0.0D
                    );

                    player.playSound(
                            SoundEvents.BLOCK_WOOL_FALL,
                            1.0F,
                            1.0F
                    );
                }
            }
        }
    }
}
