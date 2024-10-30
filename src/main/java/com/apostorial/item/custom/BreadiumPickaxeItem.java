package com.apostorial.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class BreadiumPickaxeItem extends PickaxeItem {

    private static final Map<BlockState, ItemStack> SMELTABLE_ORES = new HashMap<>();

    static {
        SMELTABLE_ORES.put(Blocks.IRON_ORE.getDefaultState(), new ItemStack(Items.IRON_INGOT));
        SMELTABLE_ORES.put(Blocks.GOLD_ORE.getDefaultState(), new ItemStack(Items.GOLD_INGOT));
    }

    public BreadiumPickaxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && miner instanceof PlayerEntity player) {

            if (SMELTABLE_ORES.containsKey(state)) {
                ItemStack smeltedDrop = SMELTABLE_ORES.get(state);
                Block.dropStack(world, pos, smeltedDrop);
                world.breakBlock(pos, false, player);
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}