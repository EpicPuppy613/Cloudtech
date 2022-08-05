package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.Cloudtech;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.epicpuppy.cloudtech.Cloudtech.COLORS;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cloudtech.MOD_ID);

    public static RegistryObject<Item>[] generateClouds(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<Item>[] clouds = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            clouds[c] = register.register(color + "_cloud", () ->
                    new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
            c++;
        }
        return clouds;
    }

    public static final RegistryObject<Item>[] CLOUDS = generateClouds(COLORS, ITEMS);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
