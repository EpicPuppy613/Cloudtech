package dev.epicpuppy.cloudtech.item;

import net.minecraft.world.level.ItemLike;

public interface ICloudItem extends ItemLike {
    int getColor(int pTintIndex);
}
