package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.Cloudtech;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class CloudtechTiers {

    private static ForgeTier[] generateTiers() {
        ForgeTier[] tiers = new ForgeTier[16];
        for (int t = 0; t < 16; t++) {
            int finalT = t;
            tiers[t] = new ForgeTier(Cloudtech.Stats.LEVEL[t], Cloudtech.Stats.USES[t], Cloudtech.Stats.SPEED[t],
                    Cloudtech.Stats.DAMAGE[t], Cloudtech.Stats.ENCHANTING[t], Cloudtech.Stats.TAGS[t],
                    () -> Ingredient.of(CloudtechItems.CLOUDS[finalT].get()));
        }
        return tiers;
    }

    public static final ForgeTier[] TIERS = generateTiers();

}
