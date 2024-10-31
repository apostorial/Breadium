package com.apostorial.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class BreadiumChestplateItem extends ArmorItem {
    private static final float LOW_HEALTH_THRESHOLD = 2.0F;
    private static final int ABSORPTION_DURATION = 100;
    private static final int ABSORPTION_AMPLIFIER = 1;
    private boolean isOnCooldown = false;
    private int cooldownTicks = 0;
    private static final int COOLDOWN_DURATION = 400;

    public BreadiumChestplateItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (player.getInventory().armor.get(2) == stack) {
                handleLowHealth(player);
                handleCooldown();
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void handleLowHealth(PlayerEntity player) {
        float currentHealth = player.getHealth();

        if (currentHealth <= LOW_HEALTH_THRESHOLD && !isOnCooldown) {
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.ABSORPTION,
                    ABSORPTION_DURATION,
                    ABSORPTION_AMPLIFIER,
                    false,
                    true,
                    true
            ));

            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.REGENERATION,
                    ABSORPTION_DURATION,
                    0,
                    false,
                    true,
                    true
            ));

            isOnCooldown = true;
            cooldownTicks = COOLDOWN_DURATION;
        }
    }

    private void handleCooldown() {
        if (isOnCooldown) {
            cooldownTicks--;
            if (cooldownTicks <= 0) {
                isOnCooldown = false;
            }
        }
    }
}

