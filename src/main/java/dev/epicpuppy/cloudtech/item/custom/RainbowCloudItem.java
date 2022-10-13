package dev.epicpuppy.cloudtech.item.custom;

import dev.epicpuppy.cloudtech.item.CloudtechItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RainbowCloudItem extends CloudtechItem {

    private static int tier = 0;
    private static int color;
    private static int cDelay = 4;

    public RainbowCloudItem(Properties pProperties) {
        super(CloudTier.T0, pProperties);
        this.color = cTier.tColor;
    }

    public static void tick() {
        if (--cDelay <= 0) {
            tier++;
            if (tier > 15) {
                tier = 0;
            }
            cTier = CloudTier.valueOf("T" + tier);
            color = cTier.tColor;
            cDelay = 4;
        }
    }

    public int getColor(int pTintIndex) {
        return (pTintIndex == 0 ? this.color : 16777215);
    }
}
