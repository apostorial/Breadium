package com.apostorial.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class BreadiumSwordItem extends SwordItem {

    public BreadiumSwordItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            World world = player.getWorld();

            if (!world.isClient) {
                player.heal(1.0F);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
