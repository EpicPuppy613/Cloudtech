package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.Cloudtech;
import dev.epicpuppy.cloudtech.CloudtechItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;

public class CloudtechArmorMaterials {
    private static CloudArmorMaterial[] generateTiers() {
        CloudArmorMaterial[] tiers = new CloudArmorMaterial[16];
        for (int t = 0; t < 16; t++) {
            int finalT = t;
            int[] protectionValues = new int[4];
            protectionValues[0] = (int) Math.floor(1 * Cloudtech.ArmorStats.PROTECTION[t]);
            protectionValues[1] = (int) Math.floor(2 * Cloudtech.ArmorStats.PROTECTION[t]);
            protectionValues[2] = (int) Math.floor(3 * Cloudtech.ArmorStats.PROTECTION[t]);
            protectionValues[3] = (int) Math.floor(1 * Cloudtech.ArmorStats.PROTECTION[t]);
            tiers[t] = new CloudArmorMaterial(
                    Cloudtech.COLORS[t], Cloudtech.ArmorStats.DURABILITY[t], protectionValues, Cloudtech.ToolStats.ENCHANTING[t],
                    SoundEvents.ARMOR_EQUIP_LEATHER, Cloudtech.ArmorStats.TOUGHNESS[t], Cloudtech.ArmorStats.KB_RESIST[t],
                    () -> Ingredient.of(CloudtechItems.INGOTS[finalT].get()));
        }
        return tiers;
    }

    public static final CloudArmorMaterial[] MATERIALS = generateTiers();
}
