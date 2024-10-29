package com.apostorial.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BreadiumStarItem extends Item {
    public BreadiumStarItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        return stack.copy();
    }
}
