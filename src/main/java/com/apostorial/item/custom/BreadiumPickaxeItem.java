package com.apostorial.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BreadiumPickaxeItem extends PickaxeItem {

    public BreadiumPickaxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity player) {
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld) world;
            Random random = world.getRandom();
            int xpAmount = random.nextBetween(1, 5);

            ExperienceOrbEntity.spawn(serverWorld, pos.toCenterPos(), xpAmount);
        }
        return super.postMine(stack, world, state, pos, player);
    }
}