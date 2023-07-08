package dev.epicpuppy.cloudtech.util;

import dev.epicpuppy.cloudtech.block.CloudtechBlockItem;
import net.minecraftforge.registries.RegistryObject;

public class TieredBlockRegisterHandler<T> {
    public final RegistryObject<T>[] BLOCKS;
    public final RegistryObject<CloudtechBlockItem>[] ITEMS;

    public TieredBlockRegisterHandler(RegistryObject<T>[] blocks, RegistryObject<CloudtechBlockItem>[] items) {
        BLOCKS = blocks;
        ITEMS = items;
    }
}
