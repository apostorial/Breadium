package com.apostorial.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class BreadiumHoeItem extends HoeItem {

    private static final Map<Block, Item> CROP_TO_SEED = new HashMap<>();

    static {
        CROP_TO_SEED.put(Blocks.WHEAT, Items.WHEAT_SEEDS);
        CROP_TO_SEED.put(Blocks.CARROTS, Items.CARROT);
        CROP_TO_SEED.put(Blocks.POTATOES, Items.POTATO);
        CROP_TO_SEED.put(Blocks.BEETROOTS, Items.BEETROOT_SEEDS);
    }

    public BreadiumHoeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState state = world.getBlockState(pos);

        if (!world.isClient && player != null) {
            if (state.isOf(Blocks.DIRT) || state.isOf(Blocks.GRASS_BLOCK)) {
                world.setBlockState(pos, Blocks.FARMLAND.getDefaultState(), 11);
                return ActionResult.SUCCESS;
            }

            if (state.getBlock() instanceof CropBlock cropBlock && cropBlock.isMature(state)) {
                Item seedItem = CROP_TO_SEED.get(state.getBlock());
                if (seedItem != null && player.getInventory().count(seedItem) > 0) {
                    player.getInventory().removeStack(player.getInventory().getSlotWithStack(new ItemStack(seedItem)), 1);
                    Block.dropStacks(state, world, pos);
                    world.setBlockState(pos, cropBlock.withAge(0), 3);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return super.useOnBlock(context);
    }
}