package dev.epicpuppy.cloudtech.item.custom;

import dev.epicpuppy.cloudtech.item.CloudtechItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RainbowCloudItem extends CloudtechItem {

    private int tier = 0;
    private int color;
    private int cDelay = 4;

    public RainbowCloudItem(Properties pProperties) {
        super(CloudTier.T0, pProperties);
        this.color = cTier.tColor;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if (--this.cDelay <= 0) {
            this.tier++;
            if (this.tier > 15) {
                this.tier = 0;
            }
            this.cTier = CloudTier.valueOf("T" + this.tier);
            this.color = this.cTier.tColor;
            this.cDelay = 4;
        }
    }

    public int getColor(int pTintIndex) {
        return (pTintIndex == 0 ? this.color : 16777215);
    }
}
