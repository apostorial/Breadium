package com.apostorial.block.custom;

import com.apostorial.block.ModBlocks;
import com.apostorial.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;

import java.util.List;
import java.util.Random;

public class BreadiumStarExtractorBlock extends Block {

    private final Block block = ModBlocks.BREADIUM_STAR_CORE;
    private static final Random RANDOM = new Random();

    public BreadiumStarExtractorBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (!world.isClient) {
            BlockPos blockBelowPos = pos.down();
            BlockState blockBelowState = world.getBlockState(blockBelowPos);

            if (blockBelowState.getBlock() == block) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!world.isAir(blockBelowPos)) {
                    Block.dropStack(world, blockBelowPos, new ItemStack(ModItems.BREADIUM_STAR_FRAGMENT, RANDOM.nextInt(2) + 1));
                    world.setBlockState(blockBelowPos, Blocks.AIR.getDefaultState());
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.breadium.breadium_star_extractor"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}