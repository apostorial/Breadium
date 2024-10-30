package com.apostorial.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
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
            HungerManager manager = player.getHungerManager();
            if (!world.isClient && manager.isNotFull()) {
                manager.add(1,0.5f);
            } else {
                player.heal(1);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
