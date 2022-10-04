package dev.epicpuppy.cloudtech.util;

import dev.epicpuppy.cloudtech.item.CloudtechItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CloudtechCreativeTab {

    public static final CreativeModeTab CLOUDTECH_TAB = new CreativeModeTab("cloudtech") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CloudtechItems.CLOUDS[0].get());
        }
    };

    public static final CreativeModeTab CLOUDTECH_GEAR = new CreativeModeTab("cloudtech_gear") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CloudtechItems.SWORDS[0].get());
        }
    };

}
