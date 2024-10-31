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

public class BreadiumHelmetItem extends ArmorItem {
    public BreadiumHelmetItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (player.getInventory().armor.get(3) == stack) {
                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.NIGHT_VISION,
                        220,
                        0,
                        false,
                        false,
                        true
                ));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
