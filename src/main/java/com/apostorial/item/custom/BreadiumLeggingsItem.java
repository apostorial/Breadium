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

public class BreadiumLeggingsItem extends ArmorItem {
    private static final int EFFECT_DURATION = 220;
    private static final int EFFECT_AMPLIFIER = 0;

    public BreadiumLeggingsItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (player.getInventory().armor.get(1) == stack) {
                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.FIRE_RESISTANCE,
                        EFFECT_DURATION,
                        EFFECT_AMPLIFIER,
                        false,
                        true,
                        true
                ));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
