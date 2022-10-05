package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.Cloudtech;
import dev.epicpuppy.cloudtech.CloudtechItems;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class CloudtechTiers {

    private static ForgeTier[] generateTiers() {
        ForgeTier[] tiers = new ForgeTier[16];
        for (int t = 0; t < 16; t++) {
            int finalT = t;
            tiers[t] = new ForgeTier(Cloudtech.ToolStats.LEVEL[t], Cloudtech.ToolStats.USES[t], Cloudtech.ToolStats.SPEED[t],
                    Cloudtech.ToolStats.DAMAGE[t], Cloudtech.ToolStats.ENCHANTING[t], Cloudtech.ToolStats.TAGS[t],
                    () -> Ingredient.of(CloudtechItems.CLOUDS[finalT].get()));
        }
        return tiers;
    }

    public static final ForgeTier[] TIERS = generateTiers();

}
