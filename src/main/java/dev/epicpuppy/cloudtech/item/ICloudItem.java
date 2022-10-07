package dev.epicpuppy.cloudtech.item;

import net.minecraft.world.level.ItemLike;

public interface ICloudItem extends ItemLike {
    public int getColor(int pTintIndex);
}
