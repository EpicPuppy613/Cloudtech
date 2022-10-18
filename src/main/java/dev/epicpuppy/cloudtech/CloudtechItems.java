package dev.epicpuppy.cloudtech;

import dev.epicpuppy.cloudtech.item.*;
import dev.epicpuppy.cloudtech.item.custom.RainbowCloudItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.entity.EquipmentSlot;
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

    public static final RegistryObject<CloudtechItem>[] CLOUDS = generateClouds(COLORS, ITEMS);
    public static final RegistryObject<CloudtechItem>[] INGOTS = generateIngots(COLORS, ITEMS);
    public static final RegistryObject<CloudtechItem>[] CORES = generateCores(COLORS, ITEMS);
    public static final RegistryObject<CloudSwordItem>[] SWORDS = generateSwords(COLORS, ITEMS);
    public static final RegistryObject<CloudPickaxeItem>[] PICKAXES = generatePickaxes(COLORS, ITEMS);
    public static final RegistryObject<CloudAxeItem>[] AXES = generateAxes(COLORS, ITEMS);
    public static final RegistryObject<CloudShovelItem>[] SHOVELS = generateShovels(COLORS, ITEMS);
    public static final RegistryObject<CloudHoeItem>[] HOES = generateHoes(COLORS, ITEMS);
    public static final RegistryObject<CloudArmorItem>[] HELMETS = generateHelmets(COLORS, ITEMS);
    public static final RegistryObject<CloudArmorItem>[] CHESTPLATES = generateChestplates(COLORS, ITEMS);
    public static final RegistryObject<CloudArmorItem>[] LEGGINGS = generateLeggings(COLORS, ITEMS);
    public static final RegistryObject<CloudArmorItem>[] BOOTS = generateBoots(COLORS, ITEMS);
    public static final RegistryObject<RainbowCloudItem> RAINBOW_CLOUD = ITEMS.register("rainbow_cloud", () -> new RainbowCloudItem(new Item.Properties().tab(CLOUDTECH_TAB)));

    public static RegistryObject<CloudtechItem>[] generateClouds(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudtechItem>[] clouds = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            clouds[c] = register.register(color + "_cloud", () ->
                    new CloudtechItem(CloudTier.valueOf("T" + finalC), new Item.Properties().tab(CLOUDTECH_TAB)));
            c++;
        }
        return clouds;
    }

    public static RegistryObject<CloudtechItem>[] generateIngots(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudtechItem>[] ingots = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            ingots[c] = register.register(color + "_cloud_ingot", () ->
                    new CloudtechItem(CloudTier.valueOf("T" + finalC), new Item.Properties().tab(CLOUDTECH_TAB)));
            c++;
        }
        return ingots;
    }

    public static RegistryObject<CloudtechItem>[] generateCores(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudtechItem>[] cores = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            cores[c] = register.register(color + "_cloud_core", () ->
                    new CloudtechItem(CloudTier.valueOf("T" + finalC), new Item.Properties().tab(CLOUDTECH_TAB)));
            c++;
        }
        return cores;
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
                    new CloudHoeItem(CloudTier.valueOf("T" + finalC), CloudtechTiers.TIERS[finalC], -1, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return hoes;
    }
    //HELMET
    public static RegistryObject<CloudArmorItem>[] generateHelmets(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudArmorItem>[] helmets = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            helmets[c] = register.register(color + "_cloud_helmet", () ->
                    new CloudArmorItem(CloudTier.valueOf("T" + finalC), CloudtechArmorMaterials.MATERIALS[finalC], EquipmentSlot.HEAD,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return helmets;
    }
    //CHESTPLATE
    public static RegistryObject<CloudArmorItem>[] generateChestplates(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudArmorItem>[] chestplates = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            chestplates[c] = register.register(color + "_cloud_chestplate", () ->
                    new CloudArmorItem(CloudTier.valueOf("T" + finalC), CloudtechArmorMaterials.MATERIALS[finalC], EquipmentSlot.CHEST,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return chestplates;
    }
    //LEGGINGS
    public static RegistryObject<CloudArmorItem>[] generateLeggings(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudArmorItem>[] leggings = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            leggings[c] = register.register(color + "_cloud_leggings", () ->
                    new CloudArmorItem(CloudTier.valueOf("T" + finalC), CloudtechArmorMaterials.MATERIALS[finalC], EquipmentSlot.LEGS,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return leggings;
    }
    //BOOTS
    public static RegistryObject<CloudArmorItem>[] generateBoots(String[] colors, DeferredRegister<Item> register) {
        RegistryObject<CloudArmorItem>[] boots = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            boots[c] = register.register(color + "_cloud_boots", () ->
                    new CloudArmorItem(CloudTier.valueOf("T" + finalC), CloudtechArmorMaterials.MATERIALS[finalC], EquipmentSlot.FEET,
                            new Item.Properties().tab(CLOUDTECH_GEAR)));
            c++;
        }
        return boots;
    }

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);

    }

    public static void registerColors() {
        ItemColors itemColors = Minecraft.getInstance().getItemColors();

        itemColors.register((stack, tint) -> RAINBOW_CLOUD.get().getColor(tint), RAINBOW_CLOUD.get());

        registerColor(itemColors, CLOUDS);
        registerColor(itemColors, INGOTS);
        registerColor(itemColors, CORES);
        registerColor(itemColors, SWORDS);
        registerColor(itemColors, PICKAXES);
        registerColor(itemColors, AXES);
        registerColor(itemColors, SHOVELS);
        registerColor(itemColors, HOES);
        registerColor(itemColors, HELMETS);
        registerColor(itemColors, CHESTPLATES);
        registerColor(itemColors, LEGGINGS);
        registerColor(itemColors, CHESTPLATES);
        registerColor(itemColors, BOOTS);

    }

    private static <T extends ICloudItem> void registerColor(ItemColors itemColors, RegistryObject<T>[] objects) {
        for (RegistryObject<T> object : objects) {
            T item = object.get();
            itemColors.register((stack, tint) -> item.getColor(tint), item);
        }
    }

}
