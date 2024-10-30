package com.apostorial.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BreadiumShovelItem extends ShovelItem {
    private static final float DIAMOND_CHANCE = 0.05f;

    public BreadiumShovelItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient) {
            if (isDiggableBlock(state.getBlock())) {
                if (world.random.nextFloat() < DIAMOND_CHANCE) {
                    ItemStack diamond = new ItemStack(Items.DIAMOND);
                    Block.dropStack(world, pos, diamond);

                    ((ServerWorld) world).spawnParticles(ParticleTypes.HAPPY_VILLAGER,
                            pos.getX() + 0.5,
                            pos.getY() + 0.5,
                            pos.getZ() + 0.5,
                            10, 0.5, 0.5, 0.5, 0.1);
                }
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    private boolean isDiggableBlock(Block block) {
        return block == Blocks.DIRT ||
                block == Blocks.GRASS_BLOCK ||
                block == Blocks.SAND ||
                block == Blocks.GRAVEL ||
                block == Blocks.CLAY ||
                block == Blocks.SOUL_SAND;
    }
}
