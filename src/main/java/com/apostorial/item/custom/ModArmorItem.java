package com.apostorial.item.custom;

import com.apostorial.item.ModArmorMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class ModArmorItem extends ArmorItem {
    private static final Map<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.BREADIUM_ARMOR_MATERIAL,
                            List.of(
                                    new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.STRENGTH, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.SPEED, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.HASTE, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.REGENERATION, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.WATER_BREATHING, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.INVISIBILITY, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.SATURATION, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.LUCK, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.SLOW_FALLING, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 600, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 600, 0, false, false)
                            )).build();

    private static int tickCounter = 0;
    private final Random random = new Random();
    private boolean effectApplied = false;

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (hasFullSuitOfArmorOn(player) && hasCorrectArmorOn(player)) {
                if (!effectApplied) {
                    applyRandomEffect(player);
                    effectApplied = true;
                }
                tickCounter++;
                if (tickCounter >= 600) {
                    tickCounter = 0;
                    applyRandomEffect(player);
                }
            } else {
                effectApplied = false;
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void applyRandomEffect(PlayerEntity player) {
        List<StatusEffectInstance> effects = MATERIAL_TO_EFFECT_MAP.get(ModArmorMaterials.BREADIUM_ARMOR_MATERIAL);
        if (effects != null && !effects.isEmpty()) {
            StatusEffectInstance randomEffect = effects.get(random.nextInt(effects.size()));
            player.addStatusEffect(new StatusEffectInstance(randomEffect.getEffectType(),
                    randomEffect.getDuration(), randomEffect.getAmplifier(), randomEffect.isAmbient(), randomEffect.shouldShowParticles()));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == ModArmorMaterials.BREADIUM_ARMOR_MATERIAL && breastplate.getMaterial() == ModArmorMaterials.BREADIUM_ARMOR_MATERIAL &&
                leggings.getMaterial() == ModArmorMaterials.BREADIUM_ARMOR_MATERIAL && boots.getMaterial() == ModArmorMaterials.BREADIUM_ARMOR_MATERIAL;
    }
}