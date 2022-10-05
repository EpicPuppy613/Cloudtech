package dev.epicpuppy.cloudtech;

import dev.epicpuppy.cloudtech.item.*;
import dev.epicpuppy.cloudtech.item.custom.RainbowCloudItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.epicpuppy.cloudtech.Cloudtech.COLORS;
import static dev.epicpuppy.cloudtech.util.CloudtechCreativeTab.CLOUDTECH_GEAR;
import static dev.epicpuppy.cloudtech.util.CloudtechCreativeTab.CLOUDTECH_TAB;

public class CloudtechItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cloudtech.MOD_ID);

    public static final RegistryObject<Item>[] CLOUDS = generateClouds(COLORS, ITEMS);
    public static final RegistryObject<CloudSwordItem>[] SWORDS = generateSwords(COLORS, ITEMS);
    public static final RegistryObject<CloudPickaxeItem>[] PICKAXES = generatePickaxes(COLORS, ITEMS);
    public static final RegistryObject<CloudAxeItem>[] AXES = generateAxes(COLORS, ITEMS);
    public static final RegistryObject<CloudShovelItem>[] SHOVELS = generateShovels(COLORS, ITEMS);
    public static final RegistryObject<CloudHoeItem>[] HOES = generateHoes(COLORS, ITEMS);
    public static final RegistryObject<RainbowCloudItem> RAINBOW_CLOUD = ITEMS.register("rainbow_cloud", () -> new RainbowCloudItem(new Item.Properties().tab(CLOUDTECH_TAB)));

    public static RegistryObject<Item>[] generateClouds(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<Item>[] clouds = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            clouds[c] = register.register(color + "_cloud", () ->
                    new CloudtechItem(CloudTier.valueOf("T" + finalC), new Item.Properties().tab(CLOUDTECH_TAB)));
            c++;
        }
        return clouds;
    }

    //--TOOLS--
    //SWORDS
    public static RegistryObject<CloudSwordItem>[] generateSwords(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudSwordItem>[] swords = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            //SWORD
            swords[c] = register.register(color + "_cloud_sword", () ->
                    new CloudSwordItem(CloudTier.valueOf("T" + finalC), CloudtechTiers.TIERS[finalC], 2, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return swords;
    }
    //PICKAXES
    public static RegistryObject<CloudPickaxeItem>[] generatePickaxes(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudPickaxeItem>[] pickaxes = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            pickaxes[c] = register.register(color + "_cloud_pickaxe", () ->
                    new CloudPickaxeItem(CloudTier.valueOf("T" + finalC), CloudtechTiers.TIERS[finalC], 1, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return pickaxes;
    }
    //AXES
    public static RegistryObject<CloudAxeItem>[] generateAxes(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudAxeItem>[] axes = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            axes[c] = register.register(color + "_cloud_axe", () ->
                    new CloudAxeItem(CloudTier.valueOf("T" + finalC), CloudtechTiers.TIERS[finalC], 4, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return axes;
    }
    //SHOVELS
    public static RegistryObject<CloudShovelItem>[] generateShovels(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudShovelItem>[] shovels = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            shovels[c] = register.register(color + "_cloud_shovel", () ->
                    new CloudShovelItem(CloudTier.valueOf("T" + finalC), CloudtechTiers.TIERS[finalC], 0, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return shovels;
    }
    //HOES
    public static RegistryObject<CloudHoeItem>[] generateHoes(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudHoeItem>[] hoes = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            hoes[c] = register.register(color + "_cloud_hoe", () ->
                    new CloudHoeItem(CloudTier.valueOf("T" + finalC), CloudtechTiers.TIERS[finalC], 0, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return hoes;
    }

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);

    }

    public static void registerColors() {
        ItemColors itemColors = Minecraft.getInstance().getItemColors();

        itemColors.register((stack, tint) -> RAINBOW_CLOUD.get().getColor(tint), RAINBOW_CLOUD.get());

        for (RegistryObject<CloudSwordItem> sword : SWORDS) {
            CloudSwordItem item = sword.get();
            itemColors.register((stack, tint) -> item.getColor(tint), item);
        }
        for (RegistryObject<CloudPickaxeItem> pickaxe : PICKAXES) {
            CloudPickaxeItem item = pickaxe.get();
            itemColors.register((stack, tint) -> item.getColor(tint), item);
        }
        for (RegistryObject<CloudAxeItem> axe : AXES) {
            CloudAxeItem item = axe.get();
            itemColors.register((stack, tint) -> item.getColor(tint), item);
        }
        for (RegistryObject<CloudShovelItem> shovel : SHOVELS) {
            CloudShovelItem item = shovel.get();
            itemColors.register((stack, tint) -> item.getColor(tint), item);
        }
        for (RegistryObject<CloudHoeItem> hoe : HOES) {
            CloudHoeItem item = hoe.get();
            itemColors.register((stack, tint) -> item.getColor(tint), item);
        }
    }

}
